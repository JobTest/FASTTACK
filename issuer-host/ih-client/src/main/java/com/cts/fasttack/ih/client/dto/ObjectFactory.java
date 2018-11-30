package com.cts.fasttack.ih.client.dto;

import com.cts.fasttack.ih.client.dto.AirlineAddendumData;
import com.cts.fasttack.ih.client.dto.AncillaryData;
import com.cts.fasttack.ih.client.dto.Authorization;
import com.cts.fasttack.ih.client.dto.AuthorizationRef;
import com.cts.fasttack.ih.client.dto.Card;
import com.cts.fasttack.ih.client.dto.CardToCardTransfer;
import com.cts.fasttack.ih.client.dto.ECommerceConnect;
import com.cts.fasttack.ih.client.dto.Error;
import com.cts.fasttack.ih.client.dto.ExtData;
import com.cts.fasttack.ih.client.dto.Invoice;
import com.cts.fasttack.ih.client.dto.ItineraryData;
import com.cts.fasttack.ih.client.dto.MCTripLeg;
import com.cts.fasttack.ih.client.dto.MCTripLegs;
import com.cts.fasttack.ih.client.dto.MPIAuthRequest;
import com.cts.fasttack.ih.client.dto.MPIAuthResponse;
import com.cts.fasttack.ih.client.dto.MPIEnrolRequest;
import com.cts.fasttack.ih.client.dto.MPIEnrolResponse;
import com.cts.fasttack.ih.client.dto.MPIRequest;
import com.cts.fasttack.ih.client.dto.MPIResponse;
import com.cts.fasttack.ih.client.dto.MasterCard;
import com.cts.fasttack.ih.client.dto.Message;
import com.cts.fasttack.ih.client.dto.PARes;
import com.cts.fasttack.ih.client.dto.PayData;
import com.cts.fasttack.ih.client.dto.Postauthorization;
import com.cts.fasttack.ih.client.dto.PostauthorizationData;
import com.cts.fasttack.ih.client.dto.Preauthorization;
import com.cts.fasttack.ih.client.dto.PreauthorizationRef;
import com.cts.fasttack.ih.client.dto.Refund;
import com.cts.fasttack.ih.client.dto.RefundData;
import com.cts.fasttack.ih.client.dto.RequestData;
import com.cts.fasttack.ih.client.dto.ResponseData;
import com.cts.fasttack.ih.client.dto.Settlement;
import com.cts.fasttack.ih.client.dto.SettlementRefundData;
import com.cts.fasttack.ih.client.dto.Transaction;
import com.cts.fasttack.ih.client.dto.TransactionResult;
import com.cts.fasttack.ih.client.dto.TransactionResults;
import com.cts.fasttack.ih.client.dto.TransactionStateReq;
import com.cts.fasttack.ih.client.dto.TransactionStateReqData;
import com.cts.fasttack.ih.client.dto.Transactions;
import com.cts.fasttack.ih.client.dto.VISA;
import com.cts.fasttack.ih.client.dto.VISACheckout;
import com.cts.fasttack.ih.client.dto.VTripLeg;
import com.cts.fasttack.ih.client.dto.VTripLegs;
import com.cts.fasttack.ih.client.dto.Wallet;
import com.cts.fasttack.ih.client.dto.XMLMPIRequest;
import com.cts.fasttack.ih.client.dto.XMLMPIResponse;
import com.cts.fasttack.ih.client.dto.XMLPayRequest;
import com.cts.fasttack.ih.client.dto.XMLPayResponse;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
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

    private final static QName _CAVV_QNAME = new QName("", "CAVV");
    private final static QName _Ref3_QNAME = new QName("", "Ref3");
    private final static QName _CVResult_QNAME = new QName("", "CVResult");
    private final static QName _CardNum_QNAME = new QName("", "CardNum");
    private final static QName _PostauthorizationAmount_QNAME = new QName("", "PostauthorizationAmount");
    private final static QName _OrderID_QNAME = new QName("", "OrderID");
    private final static QName _Rrn_QNAME = new QName("", "Rrn");
    private final static QName _CavvAlgorithm_QNAME = new QName("", "CavvAlgorithm");
    private final static QName _Enrolled_QNAME = new QName("", "Enrolled");
    private final static QName _ErrorDetail_QNAME = new QName("", "ErrorDetail");
    private final static QName _PosConditionCode_QNAME = new QName("", "PosConditionCode");
    private final static QName _Currency_QNAME = new QName("", "Currency");
    private final static QName _NameOnCard_QNAME = new QName("", "NameOnCard");
    private final static QName _DeviceCategory_QNAME = new QName("", "DeviceCategory");
    private final static QName _Status_QNAME = new QName("", "Status");
    private final static QName _Recurrent_QNAME = new QName("", "Recurrent");
    private final static QName _CardTo_QNAME = new QName("", "CardTo");
    private final static QName _Code_QNAME = new QName("", "Code");
    private final static QName _AcsURL_QNAME = new QName("", "AcsURL");
    private final static QName _ExpMonth_QNAME = new QName("", "ExpMonth");
    private final static QName _Details_QNAME = new QName("", "Details");
    private final static QName _PAResExt_QNAME = new QName("", "PAResExt");
    private final static QName _HostCode_QNAME = new QName("", "HostCode");
    private final static QName _CardNumMasked_QNAME = new QName("", "CardNumMasked");
    private final static QName _Description_QNAME = new QName("", "Description");
    private final static QName _TranCode_QNAME = new QName("", "TranCode");
    private final static QName _CVNum_QNAME = new QName("", "CVNum");
    private final static QName _CardType_QNAME = new QName("", "CardType");
    private final static QName _PaReq_QNAME = new QName("", "PaReq");
    private final static QName _Walletid_QNAME = new QName("", "Walletid");
    private final static QName _Comment_QNAME = new QName("", "Comment");
    private final static QName _ECI_QNAME = new QName("", "ECI");
    private final static QName _RefundAmount_QNAME = new QName("", "RefundAmount");
    private final static QName _TotalAmount_QNAME = new QName("", "TotalAmount");
    private final static QName _MerchantID_QNAME = new QName("", "MerchantID");
    private final static QName _ApprovalCode_QNAME = new QName("", "ApprovalCode");
    private final static QName _Date_QNAME = new QName("", "Date");
    private final static QName _XID_QNAME = new QName("", "XID");
    private final static QName _TerminalID_QNAME = new QName("", "TerminalID");
    private final static QName _ErrorCode_QNAME = new QName("", "ErrorCode");
    private final static QName _ErrorMessage_QNAME = new QName("", "ErrorMessage");
    private final static QName _ExpYear_QNAME = new QName("", "ExpYear");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VTripLegs }
     * 
     */
    public VTripLegs createVTripLegs() {
        return new VTripLegs();
    }

    /**
     * Create an instance of {@link VTripLeg }
     * 
     */
    public VTripLeg createVTripLeg() {
        return new VTripLeg();
    }

    /**
     * Create an instance of {@link TransactionResults }
     * 
     */
    public TransactionResults createTransactionResults() {
        return new TransactionResults();
    }

    /**
     * Create an instance of {@link TransactionResult }
     * 
     */
    public TransactionResult createTransactionResult() {
        return new TransactionResult();
    }

    /**
     * Create an instance of {@link ExtData }
     * 
     */
    public ExtData createExtData() {
        return new ExtData();
    }

    /**
     * Create an instance of {@link Invoice }
     * 
     */
    public Invoice createInvoice() {
        return new Invoice();
    }

    /**
     * Create an instance of {@link AncillaryData }
     * 
     */
    public AncillaryData createAncillaryData() {
        return new AncillaryData();
    }

    /**
     * Create an instance of {@link XMLPayResponse }
     * 
     */
    public XMLPayResponse createXMLPayResponse() {
        return new XMLPayResponse();
    }

    /**
     * Create an instance of {@link ResponseData }
     * 
     */
    public ResponseData createResponseData() {
        return new ResponseData();
    }

    /**
     * Create an instance of {@link TransactionStateReq }
     * 
     */
    public TransactionStateReq createTransactionStateReq() {
        return new TransactionStateReq();
    }

    /**
     * Create an instance of {@link TransactionStateReqData }
     * 
     */
    public TransactionStateReqData createTransactionStateReqData() {
        return new TransactionStateReqData();
    }

    /**
     * Create an instance of {@link MasterCard }
     * 
     */
    public MasterCard createMasterCard() {
        return new MasterCard();
    }

    /**
     * Create an instance of {@link MCTripLegs }
     * 
     */
    public MCTripLegs createMCTripLegs() {
        return new MCTripLegs();
    }

    /**
     * Create an instance of {@link MCTripLeg }
     * 
     */
    public MCTripLeg createMCTripLeg() {
        return new MCTripLeg();
    }

    /**
     * Create an instance of {@link PayData }
     * 
     */
    public PayData createPayData() {
        return new PayData();
    }

    /**
     * Create an instance of {@link Card }
     * 
     */
    public Card createCard() {
        return new Card();
    }

    /**
     * Create an instance of {@link Wallet }
     * 
     */
    public Wallet createWallet() {
        return new Wallet();
    }

    /**
     * Create an instance of {@link VISACheckout }
     * 
     */
    public VISACheckout createVISACheckout() {
        return new VISACheckout();
    }

    /**
     * Create an instance of {@link PARes }
     * 
     */
    public PARes createPARes() {
        return new PARes();
    }

    /**
     * Create an instance of {@link AirlineAddendumData }
     * 
     */
    public AirlineAddendumData createAirlineAddendumData() {
        return new AirlineAddendumData();
    }

    /**
     * Create an instance of {@link VISA }
     * 
     */
    public VISA createVISA() {
        return new VISA();
    }

    /**
     * Create an instance of {@link ItineraryData }
     * 
     */
    public ItineraryData createItineraryData() {
        return new ItineraryData();
    }

    /**
     * Create an instance of {@link CardToCardTransfer }
     * 
     */
    public CardToCardTransfer createCardToCardTransfer() {
        return new CardToCardTransfer();
    }

    /**
     * Create an instance of {@link MPIAuthRequest }
     * 
     */
    public MPIAuthRequest createMPIAuthRequest() {
        return new MPIAuthRequest();
    }

    /**
     * Create an instance of {@link MPIRequest }
     * 
     */
    public MPIRequest createMPIRequest() {
        return new MPIRequest();
    }

    /**
     * Create an instance of {@link MPIEnrolRequest }
     * 
     */
    public MPIEnrolRequest createMPIEnrolRequest() {
        return new MPIEnrolRequest();
    }

    /**
     * Create an instance of {@link XMLMPIResponse }
     * 
     */
    public XMLMPIResponse createXMLMPIResponse() {
        return new XMLMPIResponse();
    }

    /**
     * Create an instance of {@link MPIResponse }
     * 
     */
    public MPIResponse createMPIResponse() {
        return new MPIResponse();
    }

    /**
     * Create an instance of {@link MPIEnrolResponse }
     * 
     */
    public MPIEnrolResponse createMPIEnrolResponse() {
        return new MPIEnrolResponse();
    }

    /**
     * Create an instance of {@link MPIAuthResponse }
     * 
     */
    public MPIAuthResponse createMPIAuthResponse() {
        return new MPIAuthResponse();
    }

    /**
     * Create an instance of {@link SettlementRefundData }
     * 
     */
    public SettlementRefundData createSettlementRefundData() {
        return new SettlementRefundData();
    }

    /**
     * Create an instance of {@link XMLPayRequest }
     * 
     */
    public XMLPayRequest createXMLPayRequest() {
        return new XMLPayRequest();
    }

    /**
     * Create an instance of {@link RequestData }
     * 
     */
    public RequestData createRequestData() {
        return new RequestData();
    }

    /**
     * Create an instance of {@link Transactions }
     * 
     */
    public Transactions createTransactions() {
        return new Transactions();
    }

    /**
     * Create an instance of {@link Transaction }
     * 
     */
    public Transaction createTransaction() {
        return new Transaction();
    }

    /**
     * Create an instance of {@link Authorization }
     * 
     */
    public Authorization createAuthorization() {
        return new Authorization();
    }

    /**
     * Create an instance of {@link Refund }
     * 
     */
    public Refund createRefund() {
        return new Refund();
    }

    /**
     * Create an instance of {@link RefundData }
     * 
     */
    public RefundData createRefundData() {
        return new RefundData();
    }

    /**
     * Create an instance of {@link AuthorizationRef }
     * 
     */
    public AuthorizationRef createAuthorizationRef() {
        return new AuthorizationRef();
    }

    /**
     * Create an instance of {@link Preauthorization }
     * 
     */
    public Preauthorization createPreauthorization() {
        return new Preauthorization();
    }

    /**
     * Create an instance of {@link Postauthorization }
     * 
     */
    public Postauthorization createPostauthorization() {
        return new Postauthorization();
    }

    /**
     * Create an instance of {@link PostauthorizationData }
     * 
     */
    public PostauthorizationData createPostauthorizationData() {
        return new PostauthorizationData();
    }

    /**
     * Create an instance of {@link PreauthorizationRef }
     * 
     */
    public PreauthorizationRef createPreauthorizationRef() {
        return new PreauthorizationRef();
    }

    /**
     * Create an instance of {@link Settlement }
     * 
     */
    public Settlement createSettlement() {
        return new Settlement();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link XMLMPIRequest }
     * 
     */
    public XMLMPIRequest createXMLMPIRequest() {
        return new XMLMPIRequest();
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
    }

    /**
     * Create an instance of {@link ECommerceConnect }
     * 
     */
    public ECommerceConnect createECommerceConnect() {
        return new ECommerceConnect();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CAVV")
    public JAXBElement<String> createCAVV(String value) {
        return new JAXBElement<String>(_CAVV_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Ref3")
    public JAXBElement<String> createRef3(String value) {
        return new JAXBElement<String>(_Ref3_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CVResult")
    public JAXBElement<String> createCVResult(String value) {
        return new JAXBElement<String>(_CVResult_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CardNum")
    public JAXBElement<Long> createCardNum(Long value) {
        return new JAXBElement<Long>(_CardNum_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PostauthorizationAmount")
    public JAXBElement<String> createPostauthorizationAmount(String value) {
        return new JAXBElement<String>(_PostauthorizationAmount_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "OrderID")
    public JAXBElement<String> createOrderID(String value) {
        return new JAXBElement<String>(_OrderID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Rrn")
    public JAXBElement<String> createRrn(String value) {
        return new JAXBElement<String>(_Rrn_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CavvAlgorithm")
    public JAXBElement<String> createCavvAlgorithm(String value) {
        return new JAXBElement<String>(_CavvAlgorithm_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Enrolled")
    public JAXBElement<String> createEnrolled(String value) {
        return new JAXBElement<String>(_Enrolled_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ErrorDetail")
    public JAXBElement<String> createErrorDetail(String value) {
        return new JAXBElement<String>(_ErrorDetail_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PosConditionCode")
    public JAXBElement<String> createPosConditionCode(String value) {
        return new JAXBElement<String>(_PosConditionCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Currency")
    public JAXBElement<String> createCurrency(String value) {
        return new JAXBElement<String>(_Currency_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "NameOnCard")
    public JAXBElement<String> createNameOnCard(String value) {
        return new JAXBElement<String>(_NameOnCard_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DeviceCategory")
    public JAXBElement<String> createDeviceCategory(String value) {
        return new JAXBElement<String>(_DeviceCategory_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Status")
    public JAXBElement<String> createStatus(String value) {
        return new JAXBElement<String>(_Status_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Recurrent")
    public JAXBElement<Boolean> createRecurrent(Boolean value) {
        return new JAXBElement<Boolean>(_Recurrent_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CardTo")
    public JAXBElement<Long> createCardTo(Long value) {
        return new JAXBElement<Long>(_CardTo_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Code")
    public JAXBElement<String> createCode(String value) {
        return new JAXBElement<String>(_Code_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AcsURL")
    public JAXBElement<String> createAcsURL(String value) {
        return new JAXBElement<String>(_AcsURL_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ExpMonth")
    public JAXBElement<String> createExpMonth(String value) {
        return new JAXBElement<String>(_ExpMonth_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Details")
    public JAXBElement<String> createDetails(String value) {
        return new JAXBElement<String>(_Details_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PAResExt")
    public JAXBElement<String> createPAResExt(String value) {
        return new JAXBElement<String>(_PAResExt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "HostCode")
    public JAXBElement<String> createHostCode(String value) {
        return new JAXBElement<String>(_HostCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CardNumMasked")
    public JAXBElement<String> createCardNumMasked(String value) {
        return new JAXBElement<String>(_CardNumMasked_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TranCode")
    public JAXBElement<String> createTranCode(String value) {
        return new JAXBElement<String>(_TranCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CVNum")
    public JAXBElement<String> createCVNum(String value) {
        return new JAXBElement<String>(_CVNum_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CardType")
    public JAXBElement<String> createCardType(String value) {
        return new JAXBElement<String>(_CardType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PaReq")
    public JAXBElement<String> createPaReq(String value) {
        return new JAXBElement<String>(_PaReq_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Walletid")
    public JAXBElement<String> createWalletid(String value) {
        return new JAXBElement<String>(_Walletid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Comment")
    public JAXBElement<String> createComment(String value) {
        return new JAXBElement<String>(_Comment_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ECI")
    public JAXBElement<String> createECI(String value) {
        return new JAXBElement<String>(_ECI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RefundAmount")
    public JAXBElement<String> createRefundAmount(String value) {
        return new JAXBElement<String>(_RefundAmount_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TotalAmount")
    public JAXBElement<Long> createTotalAmount(Long value) {
        return new JAXBElement<Long>(_TotalAmount_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MerchantID")
    public JAXBElement<String> createMerchantID(String value) {
        return new JAXBElement<String>(_MerchantID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ApprovalCode")
    public JAXBElement<String> createApprovalCode(String value) {
        return new JAXBElement<String>(_ApprovalCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Date")
    public JAXBElement<String> createDate(String value) {
        return new JAXBElement<String>(_Date_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "XID")
    public JAXBElement<String> createXID(String value) {
        return new JAXBElement<String>(_XID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TerminalID")
    public JAXBElement<String> createTerminalID(String value) {
        return new JAXBElement<String>(_TerminalID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ErrorCode")
    public JAXBElement<String> createErrorCode(String value) {
        return new JAXBElement<String>(_ErrorCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ErrorMessage")
    public JAXBElement<String> createErrorMessage(String value) {
        return new JAXBElement<String>(_ErrorMessage_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ExpYear")
    public JAXBElement<String> createExpYear(String value) {
        return new JAXBElement<String>(_ExpYear_QNAME, String.class, null, value);
    }

}
