package kr.or.soon.login;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;


public class LoginImpl extends HttpServlet implements HttpSessionBindingListener{
	private static final long serialVersionUID = 1L;
       String id;
       String password;
       static int total = 0;
    public LoginImpl(String id,String password) {
    	this.id = id;
    	this.password = password;
    	
    }
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("사용자 접속");
		++total;
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("사용자 접속 해제");
		total --;
	}

	
}
