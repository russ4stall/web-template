package com.russ4stall.critter.utils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.russ4stall.critter.core.User;

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
        //DBI dbi = new DBI("jdbc:mysql://localhost:3306/jorb", "jorb", "jorb");
        //UserDao userDao = dbi.open(UserDao.class);
        Map<String, Object> session = ActionContext.getContext().getSession();
        User user = (User) session.get("user");


        //HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);

        if (user != null) {
            return invocation.invoke();
        }
        Object action = invocation.getAction();

        // rf: if the action doesn't require sign-in, then let it through.
        if (action.getClass().isAnnotationPresent(LoginNotRequired.class)) {
            return invocation.invoke();
        }
        /*else {
            Cookie[] cookies = request.getCookies();
            if (cookies!=null){
                for (Cookie cookie : cookies){
                    if (cookie.getName().equals("remember-me")){
                        Map<String, String> loginParameters = Splitter.on('&').withKeyValueSeparator('=').split(cookie.getValue());
                        if (userDao.getUserByEmail(loginParameters.get("email")) == null){
                            return "login";
                        }

                        user = userDao.getUserByEmail(loginParameters.get("email"));
                        if(!loginParameters.get("password").equals(user.getPassword())){
                            return "login";
                        } else {
                            session.put("user", user);
                            request.setAttribute("rememberMe", "true");
                            return invocation.invoke();
                        }
                    }
                }
            }
            return "login";
        }*/

        return "login";
    }

}
