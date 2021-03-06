package com.sgcc.uap.share.electrician.controller;

/**
 * <b>概述</b>：<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */

public class ElectricianSubCompanyInfoController {}
/*
@RestController
@Transactional
@RequestMapping("/electricianSubCompanyInfo")
public class ElectricianSubCompanyInfoController {
	*//** 
     * 日志
     *//*
	private final static Logger logger = (Logger) LoggerFactory.getLogger(ElectricianSubCompanyInfoController.class);
	*//**
	 * 方法绑定属性中不允许的参数
	 *//*
	private final static String[] DISALLOWED_PARAMS = new String[]{"idObject.primarykey"};
	*//**
	 * 是否为开发模式
	 *//*
	@Value("${uapmicServer.dev}")
	private boolean isDev;
	*//** 
     * ElectricianSubCompanyInfo服务
     *//*
	@Autowired
	private IElectricianSubCompanyInfoService electricianSubCompanyInfoService;
	*//**
	 * @getBySubCompanyId:根据subCompanyId查询
	 * @param subCompanyId
	 * @return WrappedResult 查询结果
	 * @date 2020-12-07 10:54:19
	 * @author 18511
	 *//*
	@RequestMapping(value = "/{subCompanyId}")
	public WrappedResult getBySubCompanyId(@PathVariable String subCompanyId) {
		try {
			QueryResultObject result = electricianSubCompanyInfoService.getElectricianSubCompanyInfoBySubCompanyId(subCompanyId);
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
	*//**
	 * @deleteByIds:删除
	 * @param idObject  封装ids主键值数组和idName主键名称
	 * @return WrappedResult 删除结果
	 * @date 2020-12-07 10:54:19
	 * @author 18511
	 *//*
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public WrappedResult deleteByIds(@RequestBody IDRequestObject idObject) {
		try {
			electricianSubCompanyInfoService.remove(idObject);
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
	*//**
	 * @saveOrUpdate:保存或更新
	 * @param params
	 * @return WrappedResult 保存或更新的结果
	 * @date 2020-12-07 10:54:19
	 * @author 18511
	 *//*
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public WrappedResult saveOrUpdate(@RequestBody FormRequestObject<Map<String,Object>> params) {
		try {
			if(params == null){
				throw new NullArgumentException("params");
			}
			QueryResultObject result = new QueryResultObject();
			List<Map<String,Object>> items = params.getItems();
			if(items != null && !items.isEmpty()){
				for(Map<String,Object> map : items){
					result.setFormItems(electricianSubCompanyInfoService.saveElectricianSubCompanyInfo(map));
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
	}
	*//**
	 * @query:查询
	 * @param requestCondition
	 * @return WrappedResult 查询结果
	 * @date 2020-12-07 10:54:19
	 * @author 18511
	 *//*
	@RequestMapping("/")
	public WrappedResult query(@QueryRequestParam("params") RequestCondition requestCondition) {
		try {
			QueryResultObject queryResult = electricianSubCompanyInfoService.query(requestCondition);
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
	*//**
	 * @getMetaData:从vo中获取页面展示元数据信息
	 * @param columns  将请求参数{columns:["id","name"]}封装为字符串数组
	 * @return WrappedResult 元数据
	 * @date 2020-12-07 10:54:19
	 * @author 18511
	 *//*
	@RequestMapping("/meta")
	public 	WrappedResult getMetaData(
			@ColumnRequestParam("params") String[] columns) {
		try{
			if(columns == null){
				throw new NullArgumentException("columns");
			}
			List<ViewAttributeData> datas = null;
			datas = ViewAttributeUtils.getViewAttributes(columns, ElectricianSubCompanyInfoVO.class);
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

	*//**
	 * @initBinder:初始化binder
	 * @param binder  绑定器引用，用于控制各个方法绑定的属性
	 * @return void
	 * @date 2020-12-07 10:54:19
	 * @author 18511
	 *//*
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.setDisallowedFields(DISALLOWED_PARAMS);
	}
	
	
	*//**
	 * 电工注册认证----->查询所属公司
	 * 
	 *//*
	
	@RequestMapping(value="/findCompany",name="查询所属公司")
	public WrappedResult findCompany(@RequestParam(value="companyName") String companyName){
		WrappedResult result=new WrappedResult();
		
		try {
			
			List<ElectricianSubCompanyInfo> list =electricianSubCompanyInfoService.findByCompanyName(companyName);
			result.setResultValue(list);
			return WrappedResult.successWrapedResult(result);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "异常处理";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
		}
		
		
	}

}*/
