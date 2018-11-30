package com.cts.fasttack.admin.web.data.menu;

import com.cts.fasttack.admin.web.security.acl.Acl;

/**
 * @author Olexandr Lypivets
 */
public class MenuItem {

    private String caption;

    private String url;

    private String cssStyle;

    private Acl acl;

    public String getCaption() {
        return caption;
    }

    public MenuItem caption(String caption) {
        this.caption = caption;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public MenuItem url(String url) {
        this.url = url;
        return this;
    }

    public String getCssStyle() {
        return cssStyle;
    }

    public MenuItem cssStyle(String cssStyle) {
        this.cssStyle = cssStyle;
        return this;
    }

    public Acl getAcl() {
        return acl;
    }

    public MenuItem acl(Acl acl) {
        this.acl = acl;
        return this;
    }

}
