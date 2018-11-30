package com.cts.fasttack.admin.web.security;

import javax.servlet.http.HttpServletRequest;

/**
 * Helper methods that allows to detect whether HTTP request was AJAX request.
 * @author Anton Leliuk
 */
public class AjaxDetectionHelper {

    private static final String X_REQUESTED_WITH_HEADER = "X-Requested-With";

    private static final String XML_HTTP_REQUEST = "XMLHttpRequest";

    /**
     * @return <code>true</code> if the request is AJAX request. <code>False</code> otherwise.
     */
    public static boolean isAjax(HttpServletRequest request) {
        return XML_HTTP_REQUEST.equals(request.getHeader(X_REQUESTED_WITH_HEADER));
    }
}
