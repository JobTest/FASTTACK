package com.cts.fasttack.admin.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Resolve templates for RequireJs TPL plugin
 */
@Controller
@RequestMapping("/template")
public class TemplateController {

    @GetMapping("/**/*.htm")
    public String getTemplate(HttpServletRequest request) {
        String fullUrl = request.getRequestURL().toString();
        return fullUrl.substring(fullUrl.indexOf("/template/") + 1, fullUrl.lastIndexOf(".htm"));
    }
}
