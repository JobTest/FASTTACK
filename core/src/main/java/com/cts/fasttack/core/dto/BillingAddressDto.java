package com.cts.fasttack.core.dto;

/**
 * Cardholder billing address information
 *
 * @author a.lipavets
 */
public class BillingAddressDto {

    /**
     * First line of the billing address
     */
    private String line1;

    /**
     * Second line of the billing address
     */
    private String line2;

    /**
     * The city of the billing address
     */
    private String city;

    /**
     * The country subdivision (for example, the state in the U.S.) of the billing address
     */
    private String countrySubdivision;

    /**
     * The postal code (for example, zipcode in the U.S.) of the billing address
     */
    private String postalCode;

    /**
     * The country of the billing address
     */
    private String country;

    /* getters and setters*/

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountrySubdivision() {
        return countrySubdivision;
    }

    public void setCountrySubdivision(String countrySubdivision) {
        this.countrySubdivision = countrySubdivision;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
