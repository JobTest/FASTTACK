
package com.cts.fasttack.bank.client.ws.client;

import com.cts.fasttack.bank.client.config.WebServicesConfiguration;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cts.fasttack.bank.client.ws.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RequestId_QNAME = new QName("http://sab/", "requestId");
    private final static QName _ConversationId_QNAME = new QName("http://sab/", "conversationId");
    private final static QName _Pan_QNAME = new QName("http://sab/", "pan");
    private final static QName _ExpiryMonth_QNAME = new QName("http://sab/", "expiryMonth");
    private final static QName _ExpiryYear_QNAME = new QName("http://sab/", "expiryYear");
    private final static QName _Lang_QNAME = new QName("http://sab/", "lang");
    private final static QName _PanSource_QNAME = new QName("http://sab/", "panSource");
    private final static QName _Ips_QNAME = new QName("http://sab/", "ips");
    private final static QName _Decision_QNAME = new QName("http://sab/", "decision");
    private final static QName _PanInternalId_QNAME = new QName("http://sab/", "panInternalId");
    private final static QName _PanInternalGUID_QNAME = new QName("http://sab/", "panInternalGUID");
    private final static QName _Code_QNAME = new QName("http://sab/", "code");
    private final static QName _ErrorMessage_QNAME = new QName("http://sab/", "errorMessage");
    private final static QName _Otp_QNAME = new QName("http://sab/", "otp");
    private final static QName _Mediate_QNAME = new QName("http://sab/", "mediate");
    private final static QName _MediateResponse_QNAME = new QName("http://sab/", "mediateResponse");
    private final static QName _CustomerPhone_QNAME = new QName("http://sab/", "customerPhone");
    private final static QName _ProductConfigID_QNAME = new QName("http://sab/", "productConfigID");
    private final static QName _TokenizationPath_QNAME = new QName("http://sab/", "tokenizationPath");
    private final static QName _DeviceType_QNAME = new QName("http://sab/", "deviceType");
    private final static QName _Status_QNAME = new QName("http://sab/", "status");
    private final static QName _Token_QNAME = new QName("http://sab/", "token");
    private final static QName _TokenExpiryMonth_QNAME = new QName("http://sab/", "tokenExpiryMonth");
    private final static QName _TokenExpiryYear_QNAME = new QName("http://sab/", "tokenExpiryYear");
    private final static QName _TokenActivationDate_QNAME = new QName("http://sab/", "tokenActivationDate");
    private final static QName _StorageTechnology_QNAME = new QName("http://sab/", "storageTechnology");
    private final static QName _MessageReasonCode_QNAME = new QName("http://sab/", "messageReasonCode");
    private final static QName _CustomerId_QNAME = new QName("http://sab/", "customerId");
    private final static QName _TokenRefId_QNAME = new QName("http://sab/", "tokenRefId");
    private final static QName _TokenRequestorId_QNAME = new QName("http://sab/", "tokenRequestorId");
    private final static QName _NotificationType_QNAME = new QName("http://sab/", "notificationType");
    private final static QName _LastFourOfPAN_QNAME = new QName("http://sab/", "lastFourOfPAN");
    private final static QName _ReminderPeriod_QNAME = new QName("http://sab/", "reminderPeriod");
    private final static QName _User_QNAME = new QName(WebServicesConfiguration.authenticateNamespace, "user");
    private final static QName _Password_QNAME = new QName(WebServicesConfiguration.authenticateNamespace, "password");
    private final static QName _IsAuthenticated_QNAME = new QName(WebServicesConfiguration.authenticateNamespace, "isAuthenticated");
    private final static QName _PosCode_QNAME = new QName(WebServicesConfiguration.authenticateNamespace, "posCode");
    private final static QName _SystemName_QNAME = new QName(WebServicesConfiguration.authenticateNamespace, "systemName");
    private final static QName _UserRoles_QNAME = new QName(WebServicesConfiguration.authenticateNamespace, "userRoles");
    private final static QName _TraidPointType_QNAME = new QName(WebServicesConfiguration.authenticateNamespace, "traidPointType");
    private final static QName _DeviceName_QNAME = new QName("http://sab/", "deviceName");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cts.fasttack.bank.client.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConfirmProvisioning }
     * 
     */
    public ConfirmProvisioning createConfirmProvisioning() {
        return new ConfirmProvisioning();
    }

    /**
     * Create an instance of {@link ConfirmProvisioningResponse }
     * 
     */
    public ConfirmProvisioningResponse createConfirmProvisioningResponse() {
        return new ConfirmProvisioningResponse();
    }

    /**
     * Create an instance of {@link SendOTP }
     * 
     */
    public SendOTP createSendOTP() {
        return new SendOTP();
    }

    /**
     * Create an instance of {@link SendOTPResponse }
     * 
     */
    public SendOTPResponse createSendOTPResponse() {
        return new SendOTPResponse();
    }

    /**
     * Create an instance of {@link CardTokenized }
     *
     */
    public CardTokenized createCardTokenized() {
        return new CardTokenized();
    }

    /**
     * Create an instance of {@link CardTokenizedResponse }
     *
     */
    public CardTokenizedResponse createCardTokenizedResponse() {
        return new CardTokenizedResponse();
    }

    /**
     * Create an instance of {@link TokenStatusUpdated }
     *
     */
    public TokenStatusUpdated createTokenStatusUpdated() {
        return new TokenStatusUpdated();
    }

    /**
     * Create an instance of {@link SendNotificationToCustomer }
     *
     */
    public SendNotificationToCustomer createSendNotificationToCustomer() {
        return new SendNotificationToCustomer();
    }

    /**
     * Create an instance of {@link Authenticate }
     *
     */
    public Authenticate createAuthenticate() {
        return new Authenticate();
    }

    /**
     * Create an instance of {@link GetUserRoles }
     *
     */
    public GetUserRoles createGetUserRoles() {
        return new GetUserRoles();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sab/", name = "requestId")
    public JAXBElement<String> createRequestId(String value) {
        return new JAXBElement<String>(_RequestId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "tokenRefId")
    public JAXBElement<String> createTokenRefId(String value) {
        return new JAXBElement<String>(_TokenRefId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sab/", name = "conversationId")
    public JAXBElement<String> createConversationId(String value) {
        return new JAXBElement<String>(_ConversationId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sab/", name = "pan", scope = ConfirmProvisioning.class)
    public JAXBElement<String> createPan(String value) {
        return new JAXBElement<String>(_Pan_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sab/", name = "expiryMonth", scope = ConfirmProvisioning.class)
    public JAXBElement<String> createExpiryMonth(String value) {
        return new JAXBElement<String>(_ExpiryMonth_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sab/", name = "expiryYear", scope = ConfirmProvisioning.class)
    public JAXBElement<String> createExpiryYear(String value) {
        return new JAXBElement<String>(_ExpiryYear_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sab/", name = "lang", scope = ConfirmProvisioning.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createLang(String value) {
        return new JAXBElement<String>(_Lang_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sab/", name = "panSource", scope = ConfirmProvisioning.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createPanSource(String value) {
        return new JAXBElement<String>(_PanSource_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sab/", name = "ips", scope = ConfirmProvisioning.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createIps(String value) {
        return new JAXBElement<String>(_Ips_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sab/", name = "decision", scope = ConfirmProvisioningResponse.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createDecision(String value) {
        return new JAXBElement<String>(_Decision_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sab/", name = "panInternalId")
    public JAXBElement<String> createPanInternalId(String value) {
        return new JAXBElement<String>(_PanInternalId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sab/", name = "panInternalGUID")
    public JAXBElement<String> createPanInternalGUID(String value) {
        return new JAXBElement<String>(_PanInternalGUID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sab/", name = "code")
    public JAXBElement<String> createCode(String value) {
        return new JAXBElement<String>(_Code_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorMessage")
    public JAXBElement<String> createErrorMessage(String value) {
        return new JAXBElement<String>(_ErrorMessage_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sab/", name = "otp")
    public JAXBElement<String> createOtp(String value) {
        return new JAXBElement<String>(_Otp_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sab/", name = "mediate")
    public JAXBElement<String> createMediate(String value) {
        return new JAXBElement<String>(_Mediate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sab/", name = "mediateResponse")
    public JAXBElement<String> createMediateResponse(String value) {
        return new JAXBElement<String>(_MediateResponse_QNAME, String.class, null, value);
    }

    @XmlElementDecl(namespace = "http://sab/", name = "customerPhone")
    public JAXBElement<String> createCustomerPhone(String value) {
        return new JAXBElement<String>(_CustomerPhone_QNAME, String.class, null, value);
    }

    @XmlElementDecl(namespace = "http://sab/", name = "productConfigID", scope = ConfirmProvisioningResponse.class)
    public JAXBElement<String> createProductConfigID(String value) {
        return new JAXBElement<String>(_ProductConfigID_QNAME, String.class, null, value);
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "tokenizationPath", scope = ConfirmProvisioning.class)
    public JAXBElement<String> createTokenizationPath(String value) {
        return new JAXBElement<String>(_TokenizationPath_QNAME, String.class, null, value);
    }

    @XmlElementDecl(namespace = "http://sab/", name = "deviceType")
    public JAXBElement<String> createDeviceType(String value) {
        return new JAXBElement<String>(_DeviceType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "status")
    public JAXBElement<String> createStatus(String value) {
        return new JAXBElement<String>(_Status_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "token")
    public JAXBElement<String> createToken(String value) {
        return new JAXBElement<String>(_Token_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "tokenExpiryMonth")
    public JAXBElement<String> createTokenExpiryMonth(String value) {
        return new JAXBElement<String>(_TokenExpiryMonth_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "tokenExpiryYear")
    public JAXBElement<String> createTokenExpiryYear(String value) {
        return new JAXBElement<String>(_TokenExpiryYear_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "tokenActivationDate")
    public JAXBElement<String> createTokenActivationDate(String value) {
        return new JAXBElement<String>(_TokenActivationDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "storageTechnology")
    public JAXBElement<String> createStorageTechnology(String value) {
        return new JAXBElement<String>(_StorageTechnology_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "messageReasonCode")
    public JAXBElement<String> createMessageReasonCode(String value) {
        return new JAXBElement<String>(_MessageReasonCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "customerId")
    public JAXBElement<String> createCustomerId(String value) {
        return new JAXBElement<String>(_CustomerId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "tokenRequestorId")
    public JAXBElement<String> createTokenRequestorId(String value) {
        return new JAXBElement<String>(_TokenRequestorId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "notificationType")
    public JAXBElement<String> createNotificationType(String value) {
        return new JAXBElement<String>(_NotificationType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "lastFourOfPAN")
    public JAXBElement<String> createLastFourOfPAN(String value) {
        return new JAXBElement<String>(_LastFourOfPAN_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "reminderPeriod")
    public JAXBElement<String> createReminderPeriod(String value) {
        return new JAXBElement<String>(_ReminderPeriod_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = WebServicesConfiguration.authenticateNamespace, name = "user")
    public JAXBElement<String> createUser(String value) {
        return new JAXBElement<String>(_User_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = WebServicesConfiguration.authenticateNamespace, name = "password")
    public JAXBElement<String> createPassword(String value) {
        return new JAXBElement<String>(_Password_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = WebServicesConfiguration.authenticateNamespace, name = "isAuthenticated")
    public JAXBElement<Boolean> createIsAuthenticated(Boolean value) {
        return new JAXBElement<Boolean>(_IsAuthenticated_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = WebServicesConfiguration.authenticateNamespace, name = "posCode")
    public JAXBElement<String> createPosCode(String value) {
        return new JAXBElement<String>(_PosCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = WebServicesConfiguration.authenticateNamespace, name = "systemName")
    public JAXBElement<String> createSystemName(String value) {
        return new JAXBElement<String>(_SystemName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = WebServicesConfiguration.authenticateNamespace, name = "userRoles")
    public JAXBElement<String> createUserRoles(String value) {
        return new JAXBElement<String>(_UserRoles_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = WebServicesConfiguration.authenticateNamespace, name = "traidPointType")
    public JAXBElement<String> createTraidPointType(String value) {
        return new JAXBElement<String>(_TraidPointType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deviceName")
    public JAXBElement<String> createDeviceName(String value) {
        return new JAXBElement<String>(_DeviceName_QNAME, String.class, null, value);
    }
}
