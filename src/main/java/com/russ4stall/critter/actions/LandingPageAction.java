package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Date: 10/15/14
 * Time: 2:35 PM
 *
 * @author Russ Forstall
 */

public class LandingPageAction extends ActionSupport implements SessionAware {

    Map<String, Object> session;

    public String input() {
        System.out.println("test");
        return INPUT;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("test");
        return SUCCESS;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
