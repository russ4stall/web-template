package com.github.russ4stall.actions;

import com.github.russ4stall.core.User;
import com.github.russ4stall.db.DbiFactory;
import com.github.russ4stall.db.UserDao;
import com.github.russ4stall.utils.LoginNotRequired;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * Date: 10/15/14
 * Time: 2:35 PM
 *
 * @author Russ Forstall
 */

@LoginNotRequired
@Result(location = "/landing-page", type = "redirect")
public class LoginAction extends ActionSupport implements SessionAware {
    private String email;
    private String password;

    private Map<String, Object> session;

    private UserDao userDao;

    public String input() {
        //if user is already logged in, redirect to landing page
        if (session.containsKey("user")) {
            return SUCCESS;
        }
        return INPUT;
    }

    @Override
    public String execute() throws Exception {
        UserDao userDao = new DbiFactory().getDbi().open(UserDao.class);
        session.put("user", userDao.getUserByEmail(email));

        userDao.close();
        return SUCCESS;
    }

    @Override
    public void validate() {
        if(isEmpty(email)) {
            addFieldError("email", "Email is a required field");
            return;
        }
        if(isEmpty(password)) {
            addFieldError("password", "Password is a required field");
            return;
        }
        UserDao userDao = new DbiFactory().getDbi().open(UserDao.class);
        User user = userDao.getUserByEmail(email);
        if (user == null || !BCrypt.checkpw(password, user.getPassword())) {
            addFieldError("email", "Incorrect email and password combination");
        }

        userDao.close();
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
