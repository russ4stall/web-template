package com.github.russ4stall.utils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.github.russ4stall.core.User;

import java.util.Map;

/**
 * Date: 10/15/14
 * Time: 1:32 PM
 *
 * @author Russ Forstall
 */
public class LoginCheckInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        Map<String, Object> session = ActionContext.getContext().getSession();
        User user = (User) session.get("user");


        if (user != null) {
            return invocation.invoke();
        }
        Object action = invocation.getAction();

        // rf: if the action doesn't require sign-in, then let it through.
        if (action.getClass().isAnnotationPresent(LoginNotRequired.class)) {
            return invocation.invoke();
        }

        return "login";
    }

}
