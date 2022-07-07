package com.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineListener implements HttpSessionListener {
    private Integer onlineNumber = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        onlineNumber++;
//        将人数设置到session
//        se.getSession().setAttribute("onlineNumber", onlineNumber);
        se.getSession().getServletContext().setAttribute("onlineNumber", onlineNumber);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        onlineNumber--;
//        将人数设置到session
//        se.getSession().setAttribute("onlineNumber", onlineNumber);
        se.getSession().getServletContext().setAttribute("onlineNumber", onlineNumber);
    }
}
