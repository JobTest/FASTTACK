package com.cts.fasttack.core.dict;

/**
 * For {@link com.cts.fasttack.core.data.DCProgress}
 *
 * @author Dmitry Koval
 */
public enum ProvisioningDecision {
    /**
     * APPROVED
     */
    APPR("APPROVED"),

    /**
     * DECLINED
     */
    DECL("DECLINED"),

    /**
     * REQUIRE_ADDITIONAL_AUTHENTICATION
     */
    AUTH("REQUIRE_ADDITIONAL_AUTHENTICATION");

    private String caption;

    ProvisioningDecision(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public static ProvisioningDecision getInstanceByCaption(String key) {
        for (ProvisioningDecision c : ProvisioningDecision.values()) {
            if (c.caption.equals(key)) {
                return c;
            }
        }
        return null;
    }

    public boolean isDeclined(){
        return this == DECL;
    }


    public boolean isAuth() {
        return this == AUTH;
    }

    public boolean isApproved() {
        return this == APPR;
    }

}
