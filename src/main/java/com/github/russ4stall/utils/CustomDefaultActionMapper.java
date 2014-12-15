package com.github.russ4stall.utils;

import com.opensymphony.xwork2.config.ConfigurationManager;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.apache.struts2.dispatcher.mapper.DefaultActionMapper;

import javax.servlet.http.HttpServletRequest;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * @author Russ Forstall
 * credit Steven Benitez
 *
 * This makes all GET requests defualt to the input method
 * and all other requests default to the execute method
 */
public class CustomDefaultActionMapper extends DefaultActionMapper {
    public static final String DEFAULT_GET_METHOD = "input";

    public static final String DEFAULT_METHOD = "execute";

    /**
     * Extends the parent {@code getMapping()} method to set the default
     * method to "input" instead of "execute".
     *
     * @param request       The <tt>HttpServletRequest</tt>.
     * @param configManager The <tt>ConfigurationManager</tt>.
     * @return The <tt>ActionMapping</tt> for this request.
     */

    @Override
    public ActionMapping getMapping(HttpServletRequest request, ConfigurationManager configManager) {
        ActionMapping actionMapping = super.getMapping(request, configManager);

        if (actionMapping != null && isEmpty(actionMapping.getMethod())) {
            if ("GET".equalsIgnoreCase(request.getMethod())) {
                actionMapping.setMethod(DEFAULT_GET_METHOD);
            } else {
                actionMapping.setMethod(DEFAULT_METHOD);
            }
        }

        return actionMapping;
    }
}
