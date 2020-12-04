package com.sgcc.uap.share.task;

import java.util.TimerTask;


/*
 * 15天内可以投诉
 * 15天后，默认好评
 * */
public class evaluateTask  extends TimerTask{
	

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
