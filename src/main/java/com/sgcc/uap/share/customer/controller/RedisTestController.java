package com.sgcc.uap.share.customer.controller;

import org.springframework.stereotype.Controller;

/**
 * Created by wisely on 2015/5/25.
 */

@Controller
public class RedisTestController {

   /* @Autowired
    DemoService demoService;
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    @RequestMapping("/test")
    @ResponseBody
    public String putCache(HttpServletRequest request){
    	User user = demoService.findUser(1l,"wang","yunfei");
    	Address address = demoService.findAddress(1l,"anhui","hefei");
        System.out.println("若上面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return "user:"+"/"+user.getFirstName()+"/"+user.getLastName()+",address:"+"/"+address.getProvince()+"/"+address.getCity();
    }
    @RequestMapping("/test2")
    @ResponseBody
    public String testCache(){
        User user = demoService.findUser(1l,"wang","yunfei");
        Address address =demoService.findAddress(1l,"anhui","hefei");
        System.out.println("上面若没执行查询，这里取缓存中的数据");
        System.out.println("user:"+"/"+user.getFirstName()+"/"+user.getLastName());
        System.out.println("address:"+"/"+address.getProvince()+"/"+address.getCity());
        return "user:"+"/"+user.getFirstName()+"/"+user.getLastName()+",address:"+"/"+address.getProvince()+"/"+address.getCity();
    }
    @RequestMapping("/test3")
    @ResponseBody
    public String testSession(HttpServletRequest request){
    	HttpSession session= request.getSession();
    	session.setAttribute("login","true"+System.currentTimeMillis());
    	String sessionStr = (String)session.getAttribute("login");
	    stringRedisTemplate.opsForValue().set("aaa", "111");
	    String string = stringRedisTemplate.opsForValue().get("aaa");
	    return "set to redis key:aaa"+ ",value:"+string +" login: "+sessionStr ;
    }
    @RequestMapping("/test4")
    @ResponseBody
    public String testCache3(HttpServletRequest request){
    	HttpSession session= request.getSession();
    	String okStr = session.getAttribute("login").toString();
    	System.out.println("okStr:"+okStr);
	    String string = stringRedisTemplate.opsForValue().get("aaa");
	    System.out.println("aaa:"+string);
	    return "set to redis key:aaa"+ ",value:"+string +" login: " +okStr;
    }*/
   
}
