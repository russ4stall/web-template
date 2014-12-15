package com.github.russ4stall.actions;

import com.github.russ4stall.utils.LoginNotRequired;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@LoginNotRequired
@Result(location = "/login", type = "redirect")
public class LogoutAction extends ActionSupport implements SessionAware, ServletResponseAware {
    private Map<String, Object> session;
    private HttpServletResponse response;

    public String input() {
        session.remove("user");

        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}
