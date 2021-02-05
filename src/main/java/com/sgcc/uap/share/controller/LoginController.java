package com.sgcc.uap.share.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.sgcc.uap.exception.NullArgumentException;
import com.sgcc.uap.rest.support.FormRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.WrappedResult;
import com.sgcc.uap.rest.utils.RestUtils;
import com.sgcc.uap.share.customer.services.ICustomerInfoService;
import com.sgcc.uap.share.customer.services.IGetElectricianInfoService;
import com.sgcc.uap.share.domain.AuthorityUser;
import com.sgcc.uap.share.domain.CustomerInfo;
import com.sgcc.uap.share.domain.LoginBackInfo;
import com.sgcc.uap.share.electrician.services.IElecPositionService;
import com.sgcc.uap.share.services.IAuthorityUserService;
import com.sgcc.uap.sys.constant.CookieConstant;
import com.sgcc.uap.sys.constant.RedisConstant;
import com.sgcc.uap.util.CookieUtil;
import com.sgcc.uap.util.Md5Util;
import com.sgcc.uap.util.UuidUtil;

/**
 * <b>概述</b>：<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
@RestController
@Transactional
@RequestMapping("/userLogin")
public class LoginController {
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(LoginController.class);
	/**
	 * 是否为开发模式
	 */
	@Value("${uapmicServer.dev}")
	private boolean isDev;
	
	@Autowired
	private ICustomerInfoService customerInfoService;
	@Autowired
	private IGetElectricianInfoService getElectricianInfoService;
	@Autowired
	private IElecPositionService elecPositionService;
	@Autowired
	private IAuthorityUserService authorityUserService;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;
	
	
	@RequestMapping(value = "/authCodeVerify", method = RequestMethod.POST)
	public WrappedResult authCodeVerify(@RequestBody FormRequestObject<Map<String,Object>> params) {
		try {
			if(params == null){
				throw new NullArgumentException("params");
			}
			QueryResultObject result = new QueryResultObject();
			List<Map<String,Object>> items = params.getItems();
			if(items != null && !items.isEmpty()){
				Map<String,Object> map = items.get(0);
				String userAccount = (String) map.get("phonenumber");
				String authCode = (String) map.get("authCode");
				
				String redisAuthCode = stringRedisTemplate.opsForValue().get("phonenum"+userAccount);
				
				if(authCode.equals(redisAuthCode)){
					return WrappedResult.successWrapedResult(result);
				}else{
					throw new Exception("验证码错误或验证码已过期");
				}
			}else{
				throw new Exception("发送参数错误");
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "查询异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public WrappedResult userLogin(HttpServletResponse response,@RequestBody FormRequestObject<Map<String,Object>> params) {	
		try {
			if(params == null){
				throw new NullArgumentException("params");
			}
			QueryResultObject result = new QueryResultObject();
			List<Map<String,Object>> items = params.getItems();
			if(items != null && !items.isEmpty()){
				Map<String,Object> map = items.get(0);
				String userAccount = (String) map.get("userAccount");
				String _password = (String) map.get("userPsw");
				
				//密码加密
				String password = Md5Util.string2MD5(_password);
				AuthorityUser authorityUser = authorityUserService.queryAuthorityUser(userAccount, password);
				
				if(null==authorityUser||"".equals(authorityUser)){
					throw new Exception("账号或密码填写错误！");
				}else{
					boolean isElec = getElectricianInfoService.getElectricianInfoNumberByElectricianId(authorityUser.getId());
					
					LoginBackInfo loginBackInfo = new LoginBackInfo();
					loginBackInfo.setUserId(authorityUser.getId());
					
					if(isElec){
						//跳转到电工首页 录入电工位置信息
						//response.sendRedirect("http://127.0.0.1:8080/electricianend");
						loginBackInfo.setUserType("1");
					}else{
						CustomerInfo customerInfo = customerInfoService.getCustomerInfoByCustomerId(authorityUser.getId());
						loginBackInfo.setRealNameAuth(customerInfo.getRealNameAuth());
						loginBackInfo.setUserType("0");
						//跳转到客户首页
						//response.sendRedirect("http://127.0.0.1:8080/customer");
					}
					result = RestUtils.wrappQueryResult(loginBackInfo);
					
					//设置token至redis
			        String token = UUID.randomUUID().toString();
			        Integer expire = RedisConstant.EXPIRE;

			        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), userAccount, expire, TimeUnit.SECONDS);

			        //设置token至cookie
			        CookieUtil.set(response, CookieConstant.TOKEN, token, expire);
					logger.info("登录跳转成功"); 
				}
			}
			return WrappedResult.successWrapedResult(result);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "查询异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}
	
	/**
	 * 登录方法的编写——用户登录后，通过判断是否为电工，如果为电工则跳转电工首页，并获取位置信息储存，如果没有获取到，则提示打开定位；
	 * 如果不为电工，则查询用户信息，如果没有则录入信息，然后跳转用户首页。
	 * 用户下单后储存位置信息，电工登录后储存位置信息
	 * http://localhost:8083/userLogin/customer002
	 */
	@RequestMapping(value = "/{userId}")
	public WrappedResult getLoginUserId(HttpServletResponse response,@PathVariable String userId) {
		try {
			
			boolean isElec = getElectricianInfoService.getElectricianInfoNumberByElectricianId(userId);
			
			if(isElec){
				//录入电工位置信息
				//{"items":[{"electricianId":"123","areaId":"1","lon":"12.546","lat":"52.698","status":"1"}]}
				HashMap<String, Object> map = new HashMap<String,Object>();
				map.put("electricianId", "electricianId");
				map.put("areaId", "areaId");
				map.put("lon", "lon");
				map.put("lat", "lat");
				elecPositionService.saveElecPosition(map);
				
				//跳转到电工首页
				response.sendRedirect("http://127.0.0.1:8080/electricianend");
			}else{
				boolean isCust = customerInfoService.getNumberByCustomerId(userId);
				if(isCust){
					//跳转到客户首页
					response.sendRedirect("http://127.0.0.1:8080/customer");
				}else{
					//调用国网接口，获取用户信息
					
					
					//用户信息录入
					
					
					//跳转到客户首页
					response.sendRedirect("http://127.0.0.1:8080/customer");
				}
			}
			logger.info("登录跳转成功"); 
			return WrappedResult.successWrapedResult("登录跳转成功");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "查询异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}
	
	
	@RequestMapping(value = "/authCode/{phonenumber}")
	public WrappedResult getAuthCode(HttpServletResponse response,@PathVariable String phonenumber) {
        //生产环境请求地址：app.cloopen.com
        String serverIp = "app.cloopen.com";
        //请求端口
        String serverPort = "8883";
        //主账号,登陆云通讯网站后,可在控制台首页看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN
        String accountSId = "8a216da877373e59017760b0c8921098";
        String accountToken = "112406f5740a415a90ba1c29b49f712c";
        //请使用管理控制台中已创建应用的APPID
        String appId = "8a216da877373e59017760b0c981109e";
        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        sdk.init(serverIp, serverPort);
        sdk.setAccount(accountSId, accountToken);
        sdk.setAppId(appId);
        sdk.setBodyType(BodyType.Type_JSON);
        String to = phonenumber;
        String templateId= "1";
        String randomNum = UuidUtil.randomIntegerString(6);
        String[] datas = {randomNum,"5"};
        String subAppend="";  //可选 扩展码，四位数字 0~9999
        String reqId="";  //可选 第三方自定义消息id，最大支持32位英文数字，同账号下同一自然天内不允许重复
        //HashMap<String, Object> result = sdk.sendTemplateSMS(to,templateId,datas);
        HashMap<String, Object> result = sdk.sendTemplateSMS(to,templateId,datas,subAppend,reqId);
        if("000000".equals(result.get("statusCode"))){
        	//发送验证码成功，则加入redis
        	stringRedisTemplate.opsForValue().set("phonenum"+phonenumber, randomNum, 5L, TimeUnit.MINUTES);
        	
            //正常返回输出data包体信息（map）
            HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for(String key:keySet){
                Object object = data.get(key);
                System.out.println(key +" = "+object);
            }
        }else{
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
            return WrappedResult.failedWrappedResult("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
        }
        
        return WrappedResult.successWrapedResult("验证码已发送");
	}
}
