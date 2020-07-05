package Servlet.Listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ListenerDemo02 implements HttpSessionListener {
    //在session对象创建以后自动执行
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("Hello Session Created");

        HttpSession session = httpSessionEvent.getSession();
        //httpSessionEvent代表当前时间发生时的相关数据
        System.out.println("SID:" + session.getId());
    }

    //在Session对象销毁之后自动执行
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("Hello Session Destroyed");
    }
}
