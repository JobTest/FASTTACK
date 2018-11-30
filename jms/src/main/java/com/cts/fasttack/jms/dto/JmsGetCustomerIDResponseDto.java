package com.cts.fasttack.jms.dto;

/**
 * Getting customer ID response DTO.
 *
 * @author v.semerkov
 */
public class JmsGetCustomerIDResponseDto extends JmsResponseDto {

    /**
     * Inner customer identifier
     */
    private String customerID;

    /**
     * Operation execution code.
     * Possible value's variants:
     * <ul>
     * <li>"0" - OK Success</li>
     * <li>"1" and more - error</li>
     * </ul>
     */
    private String code;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
