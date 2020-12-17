package com.sgcc.uap.share.controller;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @program: test
 * @description: WebSocketServer 服务器
 * @author: xingcheng
 * @create: 2019-05-30 19:34
 **/
@ServerEndpoint("/websocketserver/{sid}")
@Component
public class WebSocketServer {
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(WebSocketServer.class);

    /**
     * 静态变量，用来记录当前在线连接数。线程安全。
     */
    private static AtomicInteger onlineCount = new AtomicInteger(0);
    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
     */
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 接收sid
     */
    private String sid = "";

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        this.session = session;
        // 加入set中
        webSocketSet.add(this);
        // 在线数加1
        addOnlineCount();          
        this.sid = sid;
        //sendMessage("连接成功: " + sid);
        logger.info("【websocket消息】有新的连接, 总数:{}", webSocketSet.size());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        //从set中删除
        webSocketSet.remove(this);
        //在线数减1
        subOnlineCount();
        logger.info("【websocket消息】连接断开, 总数:{}", webSocketSet.size());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
    	logger.info("【websocket消息】收到客户端发来的消息:{}", message);
        //群发消息
        /*for (WebSocketServer item : webSocketSet) {
            item.sendMessage(message);
        }*/
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message, String uid) {
    	logger.info("【websocket消息】 message="+ message + ",uid=" +uid);
        for (WebSocketServer item : webSocketSet) {
            //这里可以设定只推送给这个sid的，为null则全部推送
            if (uid == null) {
                item.sendMessage(message);
            } else if (item.sid.equals(uid)) {
                item.sendMessage(message);
            }
        }
    }

    public static int getOnlineCount() {
        return onlineCount.get();
    }

    public static void addOnlineCount() {
        WebSocketServer.onlineCount.addAndGet(1);
    }

    public static void subOnlineCount() {
        WebSocketServer.onlineCount.decrementAndGet();
    }
}