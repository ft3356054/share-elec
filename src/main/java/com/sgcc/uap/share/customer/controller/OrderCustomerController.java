package com.sgcc.uap.share.customer.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import com.sgcc.uap.exception.NullArgumentException;
import com.sgcc.uap.rest.annotation.ColumnRequestParam;
import com.sgcc.uap.rest.annotation.QueryRequestParam;
import com.sgcc.uap.rest.annotation.attribute.ViewAttributeData;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.ViewMetaData;
import com.sgcc.uap.rest.support.WrappedResult;
import com.sgcc.uap.rest.utils.ViewAttributeUtils;
import com.sgcc.uap.service.validator.ServiceValidatorBaseException;
import com.sgcc.uap.share.customer.services.IOrderCustomerService;
import com.sgcc.uap.share.customer.vo.OrderCustomerVO;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.util.FileUtil;
import com.sgcc.uap.util.JsonUtils;
import com.sgcc.uap.util.MapUtil;
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
@RequestMapping("/orderCustomer")
public class OrderCustomerController {
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(OrderCustomerController.class);
	/**
	 * 方法绑定属性中不允许的参数
	 */
	private final static String[] DISALLOWED_PARAMS = new String[]{"idObject.primarykey"};
	/**
	 * 是否为开发模式
	 */
	@Value("${uapmicServer.dev}")
	private boolean isDev;
	
	
	/** 
     * OrderCustomer服务
     */
	@Autowired
	private IOrderCustomerService orderCustomerService;
	/**
	 * @getByOrderId:根据orderId查询单条
	 * @param orderId
	 * @return WrappedResult 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@RequestMapping(value = "/{orderId}")
	public WrappedResult getByOrderId(@PathVariable String orderId) {
		try {
			QueryResultObject result = orderCustomerService.getOrderCustomerByOrderId(orderId);
			logger.info("查询成功"); 
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
	 * @getByOrderId:根据orderId查询单条 关联电工订单
	 * @param orderId
	 * @return WrappedResult 查询结果
	 * @date 2020-12-26 14:32:47
	 * @author 18511
	 */
	@RequestMapping(value = "/OrderDetail/{orderId}")
	public WrappedResult getOrderDetailByOrderId(@PathVariable String orderId) {
		try {
			QueryResultObject result = orderCustomerService.getOrderDetailByOrderId(orderId);
			logger.info("查询成功"); 
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
	 * @getByOrderId:根据orderId查询全部
	 * @param orderId
	 * @return WrappedResult 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@RequestMapping("/queryAll")
	public WrappedResult getAllByCustomerId(@QueryRequestParam("params") RequestCondition requestCondition) {
		try {
			QueryResultObject queryResult = orderCustomerService.getAllOrderCustomerByCustomerId(requestCondition);
			logger.info("查询数据成功"); 
			return WrappedResult.successWrapedResult(queryResult);
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
	 * 首页订单展示
	 * @getByOrderId:根据orderId查询
	 * @param orderId
	 * @return WrappedResult 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@RequestMapping("/queryAllToBegin")
	public WrappedResult queryAllToBegin(@QueryRequestParam("params") RequestCondition requestCondition) {
		try {
			if(requestCondition == null){
				throw new NullArgumentException("queryCondition");
			}
			requestCondition.setParentID("beginPage");
			QueryResultObject queryResult = orderCustomerService.getAllOrderCustomerByCustomerId(requestCondition);
			logger.info("查询数据成功"); 
			return WrappedResult.successWrapedResult(queryResult);
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
	 * @deleteByIds:删除
	 * @param idObject  封装ids主键值数组和idName主键名称
	 * @return WrappedResult 删除结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public WrappedResult deleteByIds(@RequestBody IDRequestObject idObject) {
		try {
			orderCustomerService.remove(idObject);
			logger.info("删除成功");  
			return WrappedResult.successWrapedResult(true);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "删除异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}
	/**
	 * @saveOrUpdate:保存或更新
	 * @param params
	 * @return WrappedResult 保存或更新的结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public WrappedResult saveOrUpdate(
		@RequestParam(value = "items", required = false) String items
		,HttpServletRequest request
		//,@RequestParam("myFile") MultipartFile file
		) throws IOException {	
	
		try {
			MultipartFile file = null;
	        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	        if (isMultipart){ 
	            MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
	            file = multipartRequest.getFile("myFile");
	        }
			
			
			QueryResultObject result = new QueryResultObject();
			
			if(items != null && !items.isEmpty()){
				Map<String,Object> map = JsonUtils.parseJSONstr2Map(items); 
				result.setFormItems(orderCustomerService.saveOrderCustomer(map,file));
			}
			
			logger.info("保存数据成功"); 
			return WrappedResult.successWrapedResult(result);
		} catch (ServiceValidatorBaseException e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "校验异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedValidateWrappedResult(errorMessage);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "保存异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}
	
	/*@RequestMapping(value = "/save", method = RequestMethod.POST)
	public WrappedResult saveOrUpdate(@RequestBody FormRequestObject<Map<String,Object>> params) {
		try {
			if(params == null){
				throw new NullArgumentException("params");
			}
			QueryResultObject result = new QueryResultObject();
			List<Map<String,Object>> items = params.getItems();
			if(items != null && !items.isEmpty()){
				for(Map<String,Object> map : items){
					result.setFormItems(orderCustomerService.saveOrderCustomer(map));
				}
			}
			logger.info("保存数据成功"); 
			return WrappedResult.successWrapedResult(result);
		} catch (ServiceValidatorBaseException e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "校验异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedValidateWrappedResult(errorMessage);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "保存异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}*/
	
	@RequestMapping(value = "/photo1", method = RequestMethod.POST)
    public String abcd(
    		@RequestParam(value = "items", required = false) String items,
    		@RequestParam("myFile") MultipartFile file
    		) throws IOException {	
			String customerDescriveIcon = FileUtil.uploadFile(file, UuidUtil.getIntUuid32(),"ORDER_CUSTOMER", "CUSTOMER_DESCRIVE_ICON");
            System.out.println("customerDescriveIcon---"+customerDescriveIcon+"---");
            
            return customerDescriveIcon;
	}
	
    @RequestMapping(value = "/photo", method = RequestMethod.POST)
    public Map<String, Object> imagesAddMethod(
    		@RequestParam(value = "imgTitle", required = false) String imgTitle,
    		@RequestParam("myFile") MultipartFile file ) throws IOException {	
 
        if (file.isEmpty()) {
            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("msg", "请上传图片");
            return resultMap;
        } else {
            String fileName = file.getOriginalFilename();  // 文件名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            
            String staticPath = ClassUtils.getDefaultClassLoader().getResource("pictures").getPath();
            String filePath = staticPath + File.separator + "CUSTOMER_DESCRIVE_ICON" + 
            			File.separator + UuidUtil.getIntUuid32() + File.separator ;//这个path就是你要存在服务器上的
            fileName = UUID.randomUUID() + suffixName; // 新文件名
            
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //Picture materialPicture = new Picture();
            //materialPicture.setImgTitle(imgTitle);
            String filename = "http://localhost:8083/orderCustomer/photo" + fileName;
            //materialPicture.setPicture_url(filename);
            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("filename", filename);
            return resultMap;
            //return filename;//这里就是上传图片返回的信息，成功失败异常等，前端根据字段接收就是了
        }
    }
	
	
	
	/**
	 * @query:查询
	 * @param requestCondition
	 * @return WrappedResult 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@RequestMapping("/")
	public WrappedResult query(@QueryRequestParam("params") RequestCondition requestCondition) {
		try {
			QueryResultObject queryResult = orderCustomerService.query(requestCondition);
			logger.info("查询数据成功"); 
			return WrappedResult.successWrapedResult(queryResult);
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
	 * @getMetaData:从vo中获取页面展示元数据信息
	 * @param columns  将请求参数{columns:["id","name"]}封装为字符串数组
	 * @return WrappedResult 元数据
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@RequestMapping("/meta")
	public 	WrappedResult getMetaData(
			@ColumnRequestParam("params") String[] columns) {
		try{
			if(columns == null){
				throw new NullArgumentException("columns");
			}
			List<ViewAttributeData> datas = null;
			datas = ViewAttributeUtils.getViewAttributes(columns, OrderCustomerVO.class);
			WrappedResult wrappedResult = WrappedResult
					.successWrapedResult(new ViewMetaData(datas));
			return wrappedResult;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			String errorMessage = "异常处理";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}

	/**
	 * @initBinder:初始化binder
	 * @param binder  绑定器引用，用于控制各个方法绑定的属性
	 * @return void
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.setDisallowedFields(DISALLOWED_PARAMS);
	}
	
	/**
	 * @query:查询
	 * @param requestCondition
	 * @return WrappedResult 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@RequestMapping("/searchBox")
	public WrappedResult searchBox(@QueryRequestParam("params") RequestCondition requestCondition) {
		try {
			Map<String, String> map = MapUtil.getParam(requestCondition);
			String customerId = map.get("customerId");
			String searchContent = map.get("searchContent");
			String tagType = map.get("tagType");
			QueryResultObject queryResult = orderCustomerService.searchBox(customerId,tagType,searchContent);
			logger.info("查询数据成功"); 
			return WrappedResult.successWrapedResult(queryResult);
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
	 * @saveOrUpdate: 支付上门费 
	 * @param requestCondition
	 * @return WrappedResult 
	 * @date 2020-12-30 14:32:47
	 * @author 18511
	 * 
	 */
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public WrappedResult payCustomerPrice(@RequestParam(value = "items", required = false) String items) {
		try {
			Map<String,Object> map = JsonUtils.parseJSONstr2Map(items); 
			String orderId = (String) map.get("orderId");
			//String price = (String) map.get("price");
			String type = (String) map.get("type"); //0上门费 1维修费
			
			OrderCustomer orderCustomer = null;
			if("0".equals(type)){
				orderCustomer = orderCustomerService.payPrice(orderId,"1");
			}else{
				orderCustomer = orderCustomerService.payPrice(orderId,"3");
			}
			return WrappedResult.successWrapedResult(orderCustomer);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "支付异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}

}
