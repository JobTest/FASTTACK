package com.cts.fasttack.mdes.server.dict;

/**
 * The result of the address validation performed against the values provided by the cardholder
 *
 * @author Dmitry Koval
 */
public enum AddressValidationStatus {

    /**
     * Address matches, postal code does not
     */
    POSTAL_DOES_NOT_MATCH,

    /**
     * Neither address nor postal code matches
     */
    ADDRESS_AND_POSTAL_DO_NOT_MATCH,

    /**
     * Retry, system unable to process
     */
    RETRY,

    /**
     * AVS currently not supported
     */
    AVS_NOT_SUPPORTED,

    /**
     * No data from issuer/Authorization Platform
     */
    NO_DATA,

    /**
     * For U.S. addresses, nine-digit postal code matches, address does not;
     * for address outside the U.S., postal code matches, address does not
     */
    ADDRESS_DOES_NOT_MATCH,

    /**
     * X - For U.S. addresses, nine-digit postal code and address matches;
     * for addresses outside the U.S., postal code and address match
     */
    ADDRESS_AND_POSTAL_MATCH,

    /**
     * Y - For U.S. addresses, five-digit postal code and address matches
     */
    US5_ADDRESS_AND_POSTAL_MATCH,

    /**
     * Z - For U.S. addresses, five-digit postal code matches, address does not
     */
    US5_ADDRESS_DOES_NOT_MATCH;

    public static AddressValidationStatus getInstance(String key){
        for(AddressValidationStatus status : values()){
            if(status.name().equals(key)){
                return status;
            }
        }
        return null;
    }
}
