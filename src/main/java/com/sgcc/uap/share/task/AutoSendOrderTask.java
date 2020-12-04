package com.sgcc.uap.share.task;

import java.util.TimerTask;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;


/*
 * 自动派单
 * 20分钟没有被抢到的订单，会自动派给电工
 * */
public class AutoSendOrderTask  extends TimerTask{
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(AutoSendOrderTask.class);
	

	@Override
	public void run() {
		/*MerchantInfo mi=new MerchantInfo();
		
		ReTryService reTryService = (ReTryService) ServiceLocator.getBean("reTryService");
		List<ReTry> list = reTryService.queryAllReTry();
		
		if(list.size()!=0){
			for(int i=0;i<list.size();i++){
				mi.setOrderID(list.get(i).getOrderID());
				mi.setMerchantID(list.get(i).getMerchantid());
				mi.setStatus(list.get(i).getStatus());
				mi.setSignature(list.get(i).getSignature());
				String url =list.get(i).getUrl();
				
				long start = System.currentTimeMillis();
				boolean result=false;
				if(url!=null){
					if(list.get(i).getStatus()==77){
						result=NotifyUtil.innerCharging(url, 3000);
					}else{
						result=NotifyUtil.postJsonInfo(url, mi, 4000);
					}
				}
				String cost = "cost:" + (System.currentTimeMillis() - start);
				if (result) {
					reTryService.deleteReTry(list.get(i).getOrderID());
					logger1.info("[RETransport] [SUCCESS] [OID="+list.get(i).getOrderID()+"] [URL=" + url + "] ["+ cost +"ms]");
				} else {
					reTryService.updatePush(list.get(i).getOrderID());
					logger1.info("[RETransport] [Failed] [OID="+list.get(i).getOrderID()+"] [URL=" + url + "] ["+ cost +"ms]");
				}
			}
		}else{
			System.out.println("retry list null");
		}*/
	}

}
