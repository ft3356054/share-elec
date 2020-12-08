package com.sgcc.uap.share.task;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

//@Configuration
public class TaskConfig {
	
	private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;
	
	//@Bean
	public String initMethod(){
        Calendar calendar = Calendar.getInstance();  
        calendar.set(Calendar.HOUR_OF_DAY, 0); //凌晨0点  
        calendar.set(Calendar.MINUTE, 0);  
        calendar.set(Calendar.SECOND, 1);  
        
        Date date=calendar.getTime(); //第一次执行定时任务的时间  
        //如果第一次执行定时任务的时间 小于当前的时间  
        //此时要在 第一次执行定时任务的时间加一天，以便此任务在下个时间点执行。如果不加一天，任务会立即执行。  
        if (date.before(new Date())) {  
            date = this.addDay(date, 1);  
        }  
        
        EvaluateTask evaluateTask = new EvaluateTask();
        Timer evaluateTaskTimer = new Timer();  
        //evaluateTaskTimer.schedule(EvaluateTask, date,PERIOD_DAY);
        //延迟60s后，间隔1min打印
        evaluateTaskTimer.schedule(evaluateTask, 15000L,15000L);
        return "TaskConfig";
	}
	
	// 增加或减少天数  
    public Date addDay(Date date, int num) {  
        Calendar startDT = Calendar.getInstance();  
        startDT.setTime(date);  
        startDT.add(Calendar.DAY_OF_MONTH, num);  
        return startDT.getTime();  
    }
}
