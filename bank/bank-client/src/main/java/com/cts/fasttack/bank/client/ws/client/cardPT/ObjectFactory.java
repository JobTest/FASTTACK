
package com.cts.fasttack.bank.client.ws.client.cardPT;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
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

    private final static QName _SetCardStopListResponse_QNAME = new QName("http://sab/", "setCardStopListResponse");
    private final static QName _GetDNDStatusResponse_QNAME = new QName("http://sab/", "getDNDStatusResponse");
    private final static QName _GetCustomerIDResponse_QNAME = new QName("http://sab/", "getCustomerIDResponse");
    private final static QName _SetDNDStatusResponse_QNAME = new QName("http://sab/", "setDNDStatusResponse");
    private final static QName _GetCurrentNewSubproductResponse_QNAME = new QName("http://sab/", "getCurrentNewSubproductResponse");
    private final static QName _SetInstallmentRepaymentResponse_QNAME = new QName("http://sab/", "setInstallmentRepaymentResponse");
    private final static QName _GetCardDeliveryBranchesResponse_QNAME = new QName("http://sab/", "getCardDeliveryBranchesResponse");
    private final static QName _GetCardInfoShortResponse_QNAME = new QName("http://sab/", "getCardInfoShortResponse");
    private final static QName _RegisterCardContragentResponse_QNAME = new QName("http://sab/", "registerCardContragentResponse");
    private final static QName _CardDealInfoList_QNAME = new QName("http://sab/", "cardDealInfoList");
    private final static QName _GetUPCSessionUIDResponse_QNAME = new QName("http://sab/", "getUPCSessionUIDResponse");
    private final static QName _GetCardDeliveryStatusResponse_QNAME = new QName("http://sab/", "getCardDeliveryStatusResponse");
    private final static QName _GetCardAccountBalanceResponse_QNAME = new QName("http://sab/", "getCardAccountBalanceResponse");
    private final static QName _GetExtClientPrivIdResponse_QNAME = new QName("http://sab/", "getExtClientPrivIdResponse");
    private final static QName _FreezeCardAccountResponse_QNAME = new QName("http://sab/", "freezeCardAccountResponse");
    private final static QName _CheckTransferResponse_QNAME = new QName("http://sab/", "checkTransferResponse");
    private final static QName _GetStatusMonitoringTransactionsResponse_QNAME = new QName("http://sab/", "getStatusMonitoringTransactionsResponse");
    private final static QName _ChangeStatusMonitoringTransactionsResponse_QNAME = new QName("http://sab/", "changeStatusMonitoringTransactionsResponse");
    private final static QName _ID_QNAME = new QName("http://sab/", "ID");
    private final static QName _RegisterCardDealResponse_QNAME = new QName("http://sab/", "registerCardDealResponse");
    private final static QName _GetCVV2FlagResponse_QNAME = new QName("http://sab/", "getCVV2FlagResponse");
    private final static QName _GetAdditionalInstallmentInfoResponse_QNAME = new QName("http://sab/", "getAdditionalInstallmentInfoResponse");
    private final static QName _GetCardDealsByTaxIdResponse_QNAME = new QName("http://sab/", "getCardDealsByTaxIdResponse");
    private final static QName _REQUESTSTATUS_QNAME = new QName("http://ws.wso2.org/dataservice", "REQUEST_STATUS");
    private final static QName _CheckOpportunityRecreateCardResponse_QNAME = new QName("http://sab/", "checkOpportunityRecreateCardResponse");
    private final static QName _GetBalanceInIcResponse_QNAME = new QName("http://sab/", "getBalanceInIcResponse");
    private final static QName _InsBsnStopAfterEmbResponse_QNAME = new QName("http://sab/", "insBsnStopAfterEmbResponse");
    private final static QName _GetActualBalanceByCardResponse_QNAME = new QName("http://sab/", "getActualBalanceByCardResponse");
    private final static QName _SetUpSellNotReissuingResponse_QNAME = new QName("http://sab/", "setUpSellNotReissuingResponse");
    private final static QName _GetIPSResponse_QNAME = new QName("http://sab/", "getIPSResponse");
    private final static QName _GetSubproductAttributesResponse_QNAME = new QName("http://sab/", "getSubproductAttributesResponse");
    private final static QName _GetCardInfoResponse_QNAME = new QName("http://sab/", "getCardInfoResponse");
    private final static QName _GetActiveInstallmentsInfoResponse_QNAME = new QName("http://sab/", "getActiveInstallmentsInfoResponse");
    private final static QName _GetFinCorpAccBySiebelResponse_QNAME = new QName("http://sab/", "getFinCorpAccBySiebelResponse");
    private final static QName _ActivateCardStatuses_QNAME = new QName("http://sab/", "activateCardStatuses");
    private final static QName _SetStatementModeResponse_QNAME = new QName("http://sab/", "setStatementModeResponse");
    private final static QName _GetReportDeliveryModesResponse_QNAME = new QName("http://sab/", "getReportDeliveryModesResponse");
    private final static QName _GetFinsAppCardBySiebelResponse_QNAME = new QName("http://sab/", "getFinsAppCardBySiebelResponse");
    private final static QName _AddCardRebindingResponse_QNAME = new QName("http://sab/", "addCardRebindingResponse");
    private final static QName _GetInstallmentProductResponse_QNAME = new QName("http://sab/", "getInstallmentProductResponse");
    private final static QName _GetCardTemplateResponse_QNAME = new QName("http://sab/", "getCardTemplateResponse");
    private final static QName _RecreateCardResponse_QNAME = new QName("http://sab/", "recreateCardResponse");
    private final static QName _GetCardDealJurResponse_QNAME = new QName("http://sab/", "getCardDealJurResponse");
    private final static QName _GetAvailableAddCardResponse_QNAME = new QName("http://sab/", "getAvailableAddCardResponse");
    private final static QName _GetCardDealsByContragentIdResponse_QNAME = new QName("http://sab/", "getCardDealsByContragentIdResponse");
    private final static QName _CheckPinChangeResponse_QNAME = new QName("http://sab/", "checkPinChangeResponse");
    private final static QName _GetCardsByContragentIdResponse_QNAME = new QName("http://sab/", "getCardsByContragentIdResponse");
    private final static QName _SetCardDailyLimitsResponse_QNAME = new QName("http://sab/", "setCardDailyLimitsResponse");
    private final static QName _GetCurrentSubproductResponse_QNAME = new QName("http://sab/", "getCurrentSubproductResponse");
    private final static QName _GetSubproductCodesByAtrributeResponse_QNAME = new QName("http://sab/", "getSubproductCodesByAtrributeResponse");
    private final static QName _SetNewSubproductByCardResponse_QNAME = new QName("http://sab/", "setNewSubproductByCardResponse");
    private final static QName _GetCardDeliveryBranchResponse_QNAME = new QName("http://sab/", "getCardDeliveryBranchResponse");
    private final static QName _GetProjectInfoByAgrtplnameResponse_QNAME = new QName("http://sab/", "getProjectInfoByAgrtplnameResponse");
    private final static QName _ClientRebindingResponse_QNAME = new QName("http://sab/", "clientRebindingResponse");
    private final static QName _ActivateCardDealResponse_QNAME = new QName("http://sab/", "activateCardDealResponse");
    private final static QName _RemoveCardDealResponse_QNAME = new QName("http://sab/", "removeCardDealResponse");
    private final static QName _GetRateYieldSafeResponse_QNAME = new QName("http://sab/", "getRateYieldSafeResponse");
    private final static QName _GetCardServiceStatesResponse_QNAME = new QName("http://sab/", "getCardServiceStatesResponse");
    private final static QName _UpdateDBFileFlagResponse_QNAME = new QName("http://sab/", "updateDBFileFlagResponse");
    private final static QName _SetCodeWordResponse_QNAME = new QName("http://sab/", "setCodeWordResponse");
    private final static QName _GetCardDailyLimitsResponse_QNAME = new QName("http://sab/", "getCardDailyLimitsResponse");
    private final static QName _CardList_QNAME = new QName("http://sab/", "cardList");
    private final static QName _ActivateCardByIdResponse_QNAME = new QName("http://sab/", "activateCardByIdResponse");
    private final static QName _GetNewSubproductResponse_QNAME = new QName("http://sab/", "getNewSubproductResponse");
    private final static QName _GetCardDealFeesResponse_QNAME = new QName("http://sab/", "getCardDealFeesResponse");
    private final static QName _SetDeferredRenewCardResponse_QNAME = new QName("http://sab/", "setDeferredRenewCardResponse");
    private final static QName _GetSalaryCreditTurnoverResponse_QNAME = new QName("http://sab/", "getSalaryCreditTurnoverResponse");
    private final static QName _SetBarCodeResponse_QNAME = new QName("http://sab/", "setBarCodeResponse");
    private final static QName _CardInfoList_QNAME = new QName("http://sab/", "cardInfoList");
    private final static QName _RepaymentInstallmentResponse_QNAME = new QName("http://sab/", "repaymentInstallmentResponse");
    private final static QName _GetCardInfoByAccountNoResponse_QNAME = new QName("http://sab/", "getCardInfoByAccountNoResponse");
    private final static QName _CheckCardActivationResponse_QNAME = new QName("http://sab/", "checkCardActivationResponse");
    private final static QName _GetAvailIdArrayResponse_QNAME = new QName("http://sab/", "getAvailIdArrayResponse");
    private final static QName _GetCardDealByDealIdResponse_QNAME = new QName("http://sab/", "getCardDealByDealIdResponse");
    private final static QName _ProcessInstallmentResponse_QNAME = new QName("http://sab/", "processInstallmentResponse");
    private final static QName _ChangeSubproductCodeResponse_QNAME = new QName("http://sab/", "changeSubproductCodeResponse");
    private final static QName _CheckCodeWordResponse_QNAME = new QName("http://sab/", "checkCodeWordResponse");
    private final static QName _IdentifyCardResponse_QNAME = new QName("http://sab/", "identifyCardResponse");
    private final static QName _SignEnvelopeResponse_QNAME = new QName("http://sab/", "signEnvelopeResponse");
    private final static QName _GetDeliveryCardByMessageIdResponse_QNAME = new QName("http://sab/", "getDeliveryCardByMessageIdResponse");
    private final static QName _GetCardDealByCardNumberResponse_QNAME = new QName("http://sab/", "getCardDealByCardNumberResponse");
    private final static QName _RegisterAddCardResponse_QNAME = new QName("http://sab/", "registerAddCardResponse");
    private final static QName _SetDeferredReissueCardStatusResponse_QNAME = new QName("http://sab/", "setDeferredReissueCardStatusResponse");
    private final static QName _GetCardDeliveryStatusLogResponse_QNAME = new QName("http://sab/", "getCardDeliveryStatusLogResponse");
    private final static QName _GetDBFilesListResponse_QNAME = new QName("http://sab/", "getDBFilesListResponse");
    private final static QName _GetCardDeliveryStatusByTextResponse_QNAME = new QName("http://sab/", "getCardDeliveryStatusByTextResponse");
    private final static QName _GetAccountInfoByCardNumberResponse_QNAME = new QName("http://sab/", "getAccountInfoByCardNumberResponse");
    private final static QName _GetCardDealInfoByBarCodeResponse_QNAME = new QName("http://sab/", "getCardDealInfoByBarCodeResponse");
    private final static QName _GetTransactionHistoryResponse_QNAME = new QName("http://sab/", "getTransactionHistoryResponse");
    private final static QName _GetCardDealsByDealNoResponse_QNAME = new QName("http://sab/", "getCardDealsByDealNoResponse");
    private final static QName _ReissueCardWithNewSubproductCodeResponse_QNAME = new QName("http://sab/", "reissueCardWithNewSubproductCodeResponse");
    private final static QName _AccountList_QNAME = new QName("http://sab/", "accountList");
    private final static QName _SetCardDeliveryStatusResponse_QNAME = new QName("http://sab/", "setCardDeliveryStatusResponse");
    private final static QName _GetCardDealsByAccountNoResponse_QNAME = new QName("http://sab/", "getCardDealsByAccountNoResponse");
    private final static QName _CardAccountBillingReport_QNAME = new QName("http://sab/", "cardAccountBillingReport");
    private final static QName _GetProjectInfoByProjectIdResponse_QNAME = new QName("http://sab/", "getProjectInfoByProjectIdResponse");
    private final static QName _GetCardManufacturersResponse_QNAME = new QName("http://sab/", "getCardManufacturersResponse");
    private final static QName _SetCardDeliveryAddressResponse_QNAME = new QName("http://sab/", "setCardDeliveryAddressResponse");
    private final static QName _SetCardContractCreditLimitResponse_QNAME = new QName("http://sab/", "setCardContractCreditLimitResponse");
    private final static QName _DisableMBankingResponse_QNAME = new QName("http://sab/", "disableMBankingResponse");
    private final static QName _GetStatementResponse_QNAME = new QName("http://sab/", "getStatementResponse");
    private final static QName _EnableMBankingResponse_QNAME = new QName("http://sab/", "enableMBankingResponse");
    private final static QName _CheckAlfaChoiseEnableResponse_QNAME = new QName("http://sab/", "checkAlfaChoiseEnableResponse");
    private final static QName _ChangeDealPhoneNumberResponse_QNAME = new QName("http://sab/", "changeDealPhoneNumberResponse");
    private final static QName _CardAccountOperationList_QNAME = new QName("http://sab/", "cardAccountOperationList");
    private final static QName _ChangeBranchCodeResponse_QNAME = new QName("http://sab/", "changeBranchCodeResponse");
    private final static QName _DisableOldCardResponse_QNAME = new QName("http://sab/", "disableOldCardResponse");
    private final static QName _CancelCardDealResponse_QNAME = new QName("http://sab/", "cancelCardDealResponse");
    private final static QName _GetCardDealStateResponse_QNAME = new QName("http://sab/", "getCardDealStateResponse");
    private final static QName _AnnulateSalaryCardResponse_QNAME = new QName("http://sab/", "annulateSalaryCardResponse");
    private final static QName _GetFinAccBySiebelResponse_QNAME = new QName("http://sab/", "getFinAccBySiebelResponse");
    private final static QName _CheckInstallmentAvailabilityResponse_QNAME = new QName("http://sab/", "checkInstallmentAvailabilityResponse");
    private final static QName _GetCardInfoByCardIdResponse_QNAME = new QName("http://sab/", "getCardInfoByCardIdResponse");
    private final static QName _GetReIssueCardsResponse_QNAME = new QName("http://sab/", "getReIssueCardsResponse");
    private final static QName _CardTransactionList_QNAME = new QName("http://sab/", "cardTransactionList");
    private final static QName _GetCardInfoByAccountNoItemCardId_QNAME = new QName("http://sab/", "cardId");
    private final static QName _GetCardInfoByAccountNoItemExpireDate_QNAME = new QName("http://sab/", "expireDate");
    private final static QName _GetCardInfoByCardIdItemHardStoplist_QNAME = new QName("http://sab/", "hardStoplist");
    private final static QName _GetCardInfoByCardIdItemCardid_QNAME = new QName("http://sab/", "cardid");
    private final static QName _GetCardInfoByCardIdItemAccountNo_QNAME = new QName("http://sab/", "accountNo");
    private final static QName _GetCardInfoByCardIdItemNameOnCard_QNAME = new QName("http://sab/", "nameOnCard");
    private final static QName _GetCardInfoByCardIdItemContragentId_QNAME = new QName("http://sab/", "contragentId");
    private final static QName _GetCardInfoByCardIdItemBalanceNo_QNAME = new QName("http://sab/", "balanceNo");
    private final static QName _GetCardInfoByCardIdItemCardNumber_QNAME = new QName("http://sab/", "cardNumber");
    private final static QName _GetCardInfoByCardIdItemSoftStoplist_QNAME = new QName("http://sab/", "softStoplist");
    private final static QName _GetCardInfoByCardIdItemCurrencyCode_QNAME = new QName("http://sab/", "currencyCode");
    private final static QName _GetCardInfoByCardIdItemReserved1AccountNo_QNAME = new QName("http://sab/", "reserved1AccountNo");
    private final static QName _GetCardInfoByCardIdItemHashnum_QNAME = new QName("http://sab/", "hashnum");
    private final static QName _GetCardInfoByCardIdItemOperator_QNAME = new QName("http://sab/", "operator");
    private final static QName _GetCardInfoByCardIdItemIsActive_QNAME = new QName("http://sab/", "isActive");
    private final static QName _GetActiveInstallmentsInfoItemPeriodAmt_QNAME = new QName("http://sab/", "periodAmt");
    private final static QName _GetActiveInstallmentsInfoItemInstallmentID_QNAME = new QName("http://sab/", "installmentID");
    private final static QName _GetActiveInstallmentsInfoItemOperationInfo_QNAME = new QName("http://sab/", "operationInfo");
    private final static QName _GetActiveInstallmentsInfoItemStartAmount_QNAME = new QName("http://sab/", "startAmount");
    private final static QName _GetActiveInstallmentsInfoItemRemainAmtBody_QNAME = new QName("http://sab/", "remainAmtBody");
    private final static QName _GetActiveInstallmentsInfoItemOperationDate_QNAME = new QName("http://sab/", "operationDate");
    private final static QName _GetActiveInstallmentsInfoItemPeriodComiss_QNAME = new QName("http://sab/", "periodComiss");
    private final static QName _GetActiveInstallmentsInfoItemRemainAmt_QNAME = new QName("http://sab/", "remainAmt");
    private final static QName _GetActiveInstallmentsInfoItemPeriodPrc_QNAME = new QName("http://sab/", "periodPrc");
    private final static QName _GetActiveInstallmentsInfoItemRemainCnt_QNAME = new QName("http://sab/", "remainCnt");
    private final static QName _GetStatusMonitoringTransactionsItemCardMask_QNAME = new QName("http://sab/", "cardMask");
    private final static QName _GetStatusMonitoringTransactionsItemCategoryCard_QNAME = new QName("http://sab/", "categoryCard");
    private final static QName _GetStatusMonitoringTransactionsItemCardName_QNAME = new QName("http://sab/", "cardName");
    private final static QName _GetStatusMonitoringTransactionsItemCardProject_QNAME = new QName("http://sab/", "cardProject");
    private final static QName _GetStatusMonitoringTransactionsItemStatusMonitoringCard_QNAME = new QName("http://sab/", "statusMonitoringCard");
    private final static QName _GetStatusMonitoringTransactionsItemStatusMonitoringClient_QNAME = new QName("http://sab/", "statusMonitoringClient");
    private final static QName _AnnulateSalaryCardItemErrorCode_QNAME = new QName("http://sab/", "errorCode");
    private final static QName _AnnulateSalaryCardItemErrorMsg_QNAME = new QName("http://sab/", "errorMsg");
    private final static QName _DisableOldCardItemRemovedCardIds_QNAME = new QName("http://sab/", "removedCardIds");
    private final static QName _DisableOldCardItemErrCode_QNAME = new QName("http://sab/", "errCode");
    private final static QName _DisableOldCardItemErrMessage_QNAME = new QName("http://sab/", "errMessage");
    private final static QName _GetTransactionHistoryItemMccCode_QNAME = new QName("http://sab/", "mccCode");
    private final static QName _GetTransactionHistoryItemTransactionAmount_QNAME = new QName("http://sab/", "transactionAmount");
    private final static QName _GetTransactionHistoryItemMerchantId_QNAME = new QName("http://sab/", "merchantId");
    private final static QName _GetTransactionHistoryItemAcquirId_QNAME = new QName("http://sab/", "acquirId");
    private final static QName _GetTransactionHistoryItemAvailibleAmount_QNAME = new QName("http://sab/", "availibleAmount");
    private final static QName _GetTransactionHistoryItemAccountAmount_QNAME = new QName("http://sab/", "accountAmount");
    private final static QName _GetTransactionHistoryItemExpirationDate_QNAME = new QName("http://sab/", "expirationDate");
    private final static QName _GetTransactionHistoryItemTransactionCurrency_QNAME = new QName("http://sab/", "transactionCurrency");
    private final static QName _GetTransactionHistoryItemMsgType_QNAME = new QName("http://sab/", "msgType");
    private final static QName _GetTransactionHistoryItemProcessingCode_QNAME = new QName("http://sab/", "processingCode");
    private final static QName _GetTransactionHistoryItemAuthorizationCode_QNAME = new QName("http://sab/", "authorizationCode");
    private final static QName _GetTransactionHistoryItemMerchant_QNAME = new QName("http://sab/", "merchant");
    private final static QName _GetTransactionHistoryItemAccountCurrency_QNAME = new QName("http://sab/", "accountCurrency");
    private final static QName _GetTransactionHistoryItemMerchantName_QNAME = new QName("http://sab/", "merchantName");
    private final static QName _GetTransactionHistoryItemResponseCode_QNAME = new QName("http://sab/", "responseCode");
    private final static QName _GetTransactionHistoryItemTransactionDate_QNAME = new QName("http://sab/", "transactionDate");
    private final static QName _GetTransactionHistoryItemInternalNumber_QNAME = new QName("http://sab/", "internalNumber");
    private final static QName _GetCardDealJurItemAccountStatusText_QNAME = new QName("http://sab/", "accountStatusText");
    private final static QName _GetCardDealJurItemAccountContragentId_QNAME = new QName("http://sab/", "accountContragentId");
    private final static QName _GetCardDealJurItemIsPrimary_QNAME = new QName("http://sab/", "isPrimary");
    private final static QName _GetCardDealJurItemCardHashNumber_QNAME = new QName("http://sab/", "cardHashNumber");
    private final static QName _GetCardDealJurItemCardStatusText_QNAME = new QName("http://sab/", "cardStatusText");
    private final static QName _GetCardDealJurItemAccountStatusId_QNAME = new QName("http://sab/", "accountStatusId");
    private final static QName _GetCardDealJurItemProjectText_QNAME = new QName("http://sab/", "projectText");
    private final static QName _GetCardDealJurItemProjectId_QNAME = new QName("http://sab/", "projectId");
    private final static QName _GetCardDealJurItemCardStatusId_QNAME = new QName("http://sab/", "cardStatusId");
    private final static QName _GetCardDealJurItemDealId_QNAME = new QName("http://sab/", "dealId");
    private final static QName _GetCardDealJurItemResponseText_QNAME = new QName("http://sab/", "responseText");
    private final static QName _GetCardDealJurItemCompanyName_QNAME = new QName("http://sab/", "companyName");
    private final static QName _GetCardDealJurItemContragentName_QNAME = new QName("http://sab/", "contragentName");
    private final static QName _GetCardDealJurItemCardContragentId_QNAME = new QName("http://sab/", "cardContragentId");
    private final static QName _GetCardDealJurItemDealNo_QNAME = new QName("http://sab/", "dealNo");
    private final static QName _GetCardDealJurItemAccountNumber_QNAME = new QName("http://sab/", "accountNumber");
    private final static QName _GetCardDealJurItemIsChipCard_QNAME = new QName("http://sab/", "isChipCard");
    private final static QName _SetCardDailyLimitsItemCardRiskClassId_QNAME = new QName("http://sab/", "cardRiskClassId");
    private final static QName _CardIdICCardId_QNAME = new QName("http://sab/", "IC_Card_Id");
    private final static QName _CardDealCloseDate_QNAME = new QName("http://sab/", "closeDate");
    private final static QName _CardDealTaxId_QNAME = new QName("http://sab/", "taxId");
    private final static QName _CardDealStatusText_QNAME = new QName("http://sab/", "statusText");
    private final static QName _CardDealStatusId_QNAME = new QName("http://sab/", "statusId");
    private final static QName _CardDealStartDate_QNAME = new QName("http://sab/", "startDate");
    private final static QName _CardDealToboId_QNAME = new QName("http://sab/", "toboId");
    private final static QName _CardDealTarifPlanText_QNAME = new QName("http://sab/", "tarifPlanText");
    private final static QName _CardDealIsActiveText_QNAME = new QName("http://sab/", "isActiveText");
    private final static QName _CardDealSubProductCode_QNAME = new QName("http://sab/", "subProductCode");
    private final static QName _CardDealSold_QNAME = new QName("http://sab/", "sold");
    private final static QName _CardDealIsPersonalized_QNAME = new QName("http://sab/", "isPersonalized");
    private final static QName _CardDealIsSalary_QNAME = new QName("http://sab/", "isSalary");
    private final static QName _CardDealReportDeliveryModeId_QNAME = new QName("http://sab/", "reportDeliveryModeId");
    private final static QName _CardDealSegmentCode_QNAME = new QName("http://sab/", "segmentCode");
    private final static QName _CardDealTarifPlanId_QNAME = new QName("http://sab/", "tarifPlanId");
    private final static QName _CardDealEmailAddress_QNAME = new QName("http://sab/", "emailAddress");
    private final static QName _CardDealDealTypeId_QNAME = new QName("http://sab/", "dealTypeId");
    private final static QName _CardDealCreditLimit_QNAME = new QName("http://sab/", "creditLimit");
    private final static QName _CardDealProjectType_QNAME = new QName("http://sab/", "projectType");
    private final static QName _CardDealDealTypeText_QNAME = new QName("http://sab/", "dealTypeText");
    private final static QName _CardDealSignDate_QNAME = new QName("http://sab/", "signDate");
    private final static QName _CardDealReportDeliveryAdress_QNAME = new QName("http://sab/", "reportDeliveryAdress");
    private final static QName _GetExtClientPrivIdItemExtClientPrivId_QNAME = new QName("http://sab/", "extClientPrivId");
    private final static QName _ActivateCardByIdItemResultCode_QNAME = new QName("http://sab/", "resultCode");
    private final static QName _GetCardManufacturersItemCode_QNAME = new QName("http://sab/", "code");
    private final static QName _GetCardManufacturersItemText_QNAME = new QName("http://sab/", "text");
    private final static QName _CancelCardDealItemErrorMessage_QNAME = new QName("http://sab/", "errorMessage");
    private final static QName _CardCardNoXXX_QNAME = new QName("http://sab/", "cardNoXXX");
    private final static QName _CardCardTypeId_QNAME = new QName("http://sab/", "cardTypeId");
    private final static QName _CardMBanking_QNAME = new QName("http://sab/", "mBanking");
    private final static QName _CardAdditionalInfo_QNAME = new QName("http://sab/", "additionalInfo");
    private final static QName _CardMBankingPhone_QNAME = new QName("http://sab/", "mBankingPhone");
    private final static QName _CardCardTypeText_QNAME = new QName("http://sab/", "cardTypeText");
    private final static QName _CardCodeCardText_QNAME = new QName("http://sab/", "codeCardText");
    private final static QName _CardCodeCardId_QNAME = new QName("http://sab/", "codeCardId");
    private final static QName _CardCardOwnerFullName_QNAME = new QName("http://sab/", "cardOwnerFullName");
    private final static QName _GetNewSubproductItemNewSubProductCode_QNAME = new QName("http://sab/", "newSubProductCode");
    private final static QName _GetNewSubproductItemTemplateId_QNAME = new QName("http://sab/", "templateId");
    private final static QName _CardDealStateNextPaymentDate_QNAME = new QName("http://sab/", "nextPaymentDate");
    private final static QName _CardDealStateAvailableCredit_QNAME = new QName("http://sab/", "availableCredit");
    private final static QName _CardDealStateTotalDebt_QNAME = new QName("http://sab/", "totalDebt");
    private final static QName _CardDealStateBalance_QNAME = new QName("http://sab/", "balance");
    private final static QName _CardDealStateAvailableAmount_QNAME = new QName("http://sab/", "availableAmount");
    private final static QName _CardDealStateLastBalanceUpdate_QNAME = new QName("http://sab/", "lastBalanceUpdate");
    private final static QName _CardDealStateInstallmentDebt_QNAME = new QName("http://sab/", "installmentDebt");
    private final static QName _CardDealStateNextPaymentAmount_QNAME = new QName("http://sab/", "nextPaymentAmount");
    private final static QName _CheckCodeWordItemResult_QNAME = new QName("http://sab/", "result");
    private final static QName _ProcessInstallmentItemEqualAmount_QNAME = new QName("http://sab/", "equalAmount");
    private final static QName _ProcessInstallmentItemInstallmentId_QNAME = new QName("http://sab/", "installmentId");
    private final static QName _ProcessInstallmentItemTransactionSum_QNAME = new QName("http://sab/", "transactionSum");
    private final static QName _ProcessInstallmentItemEqualAvlAmountOut_QNAME = new QName("http://sab/", "equalAvlAmountOut");
    private final static QName _GetBalanceInIcItemLastChangeStatusCard_QNAME = new QName("http://sab/", "lastChangeStatusCard");
    private final static QName _GetBalanceInIcItemBalanceUah_QNAME = new QName("http://sab/", "balanceUah");
    private final static QName _GetBalanceInIcItemAccountReserved_QNAME = new QName("http://sab/", "accountReserved");
    private final static QName _CheckOpportunityRecreateCardItemBranchId_QNAME = new QName("http://sab/", "branchId");
    private final static QName _CheckOpportunityRecreateCardItemDecision_QNAME = new QName("http://sab/", "decision");
    private final static QName _CardDealInfoMinPaymentDate_QNAME = new QName("http://sab/", "minPaymentDate");
    private final static QName _CardDealInfoOverdraftAmount_QNAME = new QName("http://sab/", "overdraftAmount");
    private final static QName _CardDealInfoMinPayment_QNAME = new QName("http://sab/", "minPayment");
    private final static QName _GetCurrentNewSubproductItemCustValZDK_QNAME = new QName("http://sab/", "custValZDK");
    private final static QName _GetCurrentNewSubproductItemSubproductCode_QNAME = new QName("http://sab/", "subproductCode");
    private final static QName _GetCurrentNewSubproductItemMessageId_QNAME = new QName("http://sab/", "messageId");
    private final static QName _RegisterAddCardItemAddCardHashNumber_QNAME = new QName("http://sab/", "addCardHashNumber");
    private final static QName _GetFinAccBySiebelItemAccountState_QNAME = new QName("http://sab/", "accountState");
    private final static QName _GetFinAccBySiebelItemIsCardAccountId_QNAME = new QName("http://sab/", "isCardAccountId");
    private final static QName _GetFinAccBySiebelItemIsCardAgreementId_QNAME = new QName("http://sab/", "isCardAgreementId");
    private final static QName _GetFinAccBySiebelItemCurrDgtlCode_QNAME = new QName("http://sab/", "currDgtlCode");
    private final static QName _GetFinAccBySiebelItemAccountType_QNAME = new QName("http://sab/", "accountType");
    private final static QName _GetFinAccBySiebelItemFinAccountNumber_QNAME = new QName("http://sab/", "finAccountNumber");
    private final static QName _GetFinAccBySiebelItemIsPrincipal_QNAME = new QName("http://sab/", "isPrincipal");
    private final static QName _GetReportDeliveryModesItemReportDeliveryModeText_QNAME = new QName("http://sab/", "reportDeliveryModeText");
    private final static QName _CardAccountOperationItemApprovalCode_QNAME = new QName("http://sab/", "approvalCode");
    private final static QName _CardAccountOperationItemOperationAmount_QNAME = new QName("http://sab/", "operationAmount");
    private final static QName _CardAccountOperationItemTransactionCurrencyCode_QNAME = new QName("http://sab/", "transactionCurrencyCode");
    private final static QName _CardAccountOperationItemTransactionInfo_QNAME = new QName("http://sab/", "transactionInfo");
    private final static QName _CardAccountOperationItemOperationCurrencyCode_QNAME = new QName("http://sab/", "operationCurrencyCode");
    private final static QName _GetFinCorpAccBySiebelItemOverdraftBeginDate_QNAME = new QName("http://sab/", "overdraftBeginDate");
    private final static QName _GetFinCorpAccBySiebelItemAccountModel_QNAME = new QName("http://sab/", "accountModel");
    private final static QName _GetFinCorpAccBySiebelItemCollectionStatus_QNAME = new QName("http://sab/", "collectionStatus");
    private final static QName _GetFinCorpAccBySiebelItemPrBranch_QNAME = new QName("http://sab/", "prBranch");
    private final static QName _GetFinCorpAccBySiebelItemStatusB2_QNAME = new QName("http://sab/", "statusB2");
    private final static QName _GetFinCorpAccBySiebelItemOtherIdNumber_QNAME = new QName("http://sab/", "otherIdNumber");
    private final static QName _GetFinCorpAccBySiebelItemDealDate_QNAME = new QName("http://sab/", "dealDate");
    private final static QName _GetFinCorpAccBySiebelItemAccountBranchName_QNAME = new QName("http://sab/", "accountBranchName");
    private final static QName _GetFinCorpAccBySiebelItemIsCardConditRateId_QNAME = new QName("http://sab/", "isCardConditRateId");
    private final static QName _GetFinCorpAccBySiebelItemOverdraftEndDate_QNAME = new QName("http://sab/", "overdraftEndDate");
    private final static QName _GetFinCorpAccBySiebelItemIsCardProjectId_QNAME = new QName("http://sab/", "isCardProjectId");
    private final static QName _GetFinCorpAccBySiebelItemTaxIdNumber_QNAME = new QName("http://sab/", "taxIdNumber");
    private final static QName _GetFinCorpAccBySiebelItemAgreementDate_QNAME = new QName("http://sab/", "agreementDate");
    private final static QName _GetFinCorpAccBySiebelItemDlNumber_QNAME = new QName("http://sab/", "dlNumber");
    private final static QName _GetFinCorpAccBySiebelItemDateOfBirth_QNAME = new QName("http://sab/", "dateOfBirth");
    private final static QName _GetFinCorpAccBySiebelItemT24Id_QNAME = new QName("http://sab/", "t24Id");
    private final static QName _GetFinCorpAccBySiebelItemStatementMode_QNAME = new QName("http://sab/", "statementMode");
    private final static QName _GetFinCorpAccBySiebelItemStatementAddress_QNAME = new QName("http://sab/", "statementAddress");
    private final static QName _GetFinCorpAccBySiebelItemAgreementNumber_QNAME = new QName("http://sab/", "agreementNumber");
    private final static QName _GetFinCorpAccBySiebelItemIsCardConditAccId_QNAME = new QName("http://sab/", "isCardConditAccId");
    private final static QName _GetCardDeliveryBranchesItemBranchName_QNAME = new QName("http://sab/", "branchName");
    private final static QName _GetCardDealFeesItemB_QNAME = new QName("http://sab/", "B");
    private final static QName _GetCardDealFeesItemC_QNAME = new QName("http://sab/", "C");
    private final static QName _GetCardDealFeesItemA_QNAME = new QName("http://sab/", "A");
    private final static QName _GetCardDealFeesItemD_QNAME = new QName("http://sab/", "D");
    private final static QName _GetCardDealFeesItemE_QNAME = new QName("http://sab/", "E");
    private final static QName _GetCardDealFeesItemFeeName_QNAME = new QName("http://sab/", "feeName");
    private final static QName _GetCardDealFeesItemFeeClassId_QNAME = new QName("http://sab/", "feeClassId");
    private final static QName _GetCardDealFeesItemFeeType_QNAME = new QName("http://sab/", "feeType");
    private final static QName _CardTransactionAmount_QNAME = new QName("http://sab/", "amount");
    private final static QName _CardTransactionDate_QNAME = new QName("http://sab/", "date");
    private final static QName _CardTransactionInfo_QNAME = new QName("http://sab/", "info");
    private final static QName _CardTransactionType_QNAME = new QName("http://sab/", "type");
    private final static QName _CardTransactionCurrencyId_QNAME = new QName("http://sab/", "currencyId");
    private final static QName _GetCardInfoItemStopListId_QNAME = new QName("http://sab/", "stopListId");
    private final static QName _GetCardInfoItemBarcode_QNAME = new QName("http://sab/", "barcode");
    private final static QName _SetDNDStatusItemContragentIdOut_QNAME = new QName("http://sab/", "contragentIdOut");
    private final static QName _GetFinsAppCardBySiebelItemCodeWord_QNAME = new QName("http://sab/", "codeWord");
    private final static QName _GetFinsAppCardBySiebelItemAccessType_QNAME = new QName("http://sab/", "accessType");
    private final static QName _GetFinsAppCardBySiebelItemExpiryDate_QNAME = new QName("http://sab/", "expiryDate");
    private final static QName _GetFinsAppCardBySiebelItemIsCardCardId_QNAME = new QName("http://sab/", "isCardCardId");
    private final static QName _GetFinsAppCardBySiebelItemFirstName_QNAME = new QName("http://sab/", "firstName");
    private final static QName _GetFinsAppCardBySiebelItemIsCardRiskClassId_QNAME = new QName("http://sab/", "isCardRiskClassId");
    private final static QName _GetFinsAppCardBySiebelItemSideInformation_QNAME = new QName("http://sab/", "sideInformation");
    private final static QName _GetFinsAppCardBySiebelItemStatementStopList_QNAME = new QName("http://sab/", "statementStopList");
    private final static QName _GetFinsAppCardBySiebelItemCardStatus_QNAME = new QName("http://sab/", "cardStatus");
    private final static QName _GetFinsAppCardBySiebelItemCategoriesCards_QNAME = new QName("http://sab/", "categoriesCards");
    private final static QName _GetFinsAppCardBySiebelItemMBankingState_QNAME = new QName("http://sab/", "mBankingState");
    private final static QName _GetFinsAppCardBySiebelItemServiceType_QNAME = new QName("http://sab/", "serviceType");
    private final static QName _GetFinsAppCardBySiebelItemCardType_QNAME = new QName("http://sab/", "cardType");
    private final static QName _GetFinsAppCardBySiebelItemModeCards_QNAME = new QName("http://sab/", "modeCards");
    private final static QName _RegisterCardDealItemCardHashNum_QNAME = new QName("http://sab/", "cardHashNum");
    private final static QName _CheckTransferItemRespCode_QNAME = new QName("http://sab/", "respCode");
    private final static QName _GetActualBalanceByCardItemActualBalance_QNAME = new QName("http://sab/", "actualBalance");
    private final static QName _GetAdditionalInstallmentInfoItemPhoneNumber_QNAME = new QName("http://sab/", "phoneNumber");
    private final static QName _GetRateYieldSafeItemPercfeeclassid_QNAME = new QName("http://sab/", "percfeeclassid");
    private final static QName _GetRateYieldSafeItemB_QNAME = new QName("http://sab/", "b");
    private final static QName _GetRateYieldSafeItemC_QNAME = new QName("http://sab/", "c");
    private final static QName _GetRateYieldSafeItemA_QNAME = new QName("http://sab/", "a");
    private final static QName _GetRateYieldSafeItemPercfeename_QNAME = new QName("http://sab/", "percfeename");
    private final static QName _GetRateYieldSafeItemD_QNAME = new QName("http://sab/", "d");
    private final static QName _GetRateYieldSafeItemE_QNAME = new QName("http://sab/", "e");
    private final static QName _GetRateYieldSafeItemCcy_QNAME = new QName("http://sab/", "ccy");
    private final static QName _GetCardDeliveryStatusItemCourier_QNAME = new QName("http://sab/", "courier");
    private final static QName _GetCardDeliveryStatusItemDateFileGen_QNAME = new QName("http://sab/", "dateFileGen");
    private final static QName _GetCardDeliveryStatusItemDeliveryCorp_QNAME = new QName("http://sab/", "deliveryCorp");
    private final static QName _GetCardDeliveryStatusItemDateOnPrint_QNAME = new QName("http://sab/", "dateOnPrint");
    private final static QName _GetCardDeliveryStatusItemDeliveryHouse_QNAME = new QName("http://sab/", "deliveryHouse");
    private final static QName _GetCardDeliveryStatusItemDatePerson_QNAME = new QName("http://sab/", "datePerson");
    private final static QName _GetCardDeliveryStatusItemDeliveryDistrictCode_QNAME = new QName("http://sab/", "deliveryDistrictCode");
    private final static QName _GetCardDeliveryStatusItemPlantDeliveryPointName_QNAME = new QName("http://sab/", "plantDeliveryPointName");
    private final static QName _GetCardDeliveryStatusItemCityDistrict_QNAME = new QName("http://sab/", "cityDistrict");
    private final static QName _GetCardDeliveryStatusItemLastChangeDate_QNAME = new QName("http://sab/", "lastChangeDate");
    private final static QName _GetCardDeliveryStatusItemDeliveryStreet_QNAME = new QName("http://sab/", "deliveryStreet");
    private final static QName _GetCardDeliveryStatusItemDeliveryType_QNAME = new QName("http://sab/", "deliveryType");
    private final static QName _GetCardDeliveryStatusItemMessageIdPrimaryProcess_QNAME = new QName("http://sab/", "messageIdPrimaryProcess");
    private final static QName _GetCardDeliveryStatusItemDeliveryFlat_QNAME = new QName("http://sab/", "deliveryFlat");
    private final static QName _GetCardDeliveryStatusItemDeliveryCityCode_QNAME = new QName("http://sab/", "deliveryCityCode");
    private final static QName _GetCardDeliveryStatusItemPlantDeliveryPoint_QNAME = new QName("http://sab/", "plantDeliveryPoint");
    private final static QName _GetCardDeliveryStatusItemDeliveryRegionCode_QNAME = new QName("http://sab/", "deliveryRegionCode");
    private final static QName _GetCardDeliveryStatusItemShopId_QNAME = new QName("http://sab/", "shopId");
    private final static QName _GetCardDeliveryStatusItemEmbCardName_QNAME = new QName("http://sab/", "embCardName");
    private final static QName _GetCardDeliveryStatusItemRenewLabel_QNAME = new QName("http://sab/", "renewLabel");
    private final static QName _GetCardDeliveryStatusItemPrimaryProcessCode_QNAME = new QName("http://sab/", "primaryProcessCode");
    private final static QName _GetCardDeliveryStatusItemUrgent_QNAME = new QName("http://sab/", "urgent");
    private final static QName _GetCardDeliveryStatusItemTrackStatusAdd1_QNAME = new QName("http://sab/", "trackStatusAdd1");
    private final static QName _GetCardDeliveryStatusItemCardHash_QNAME = new QName("http://sab/", "cardHash");
    private final static QName _GetCardDeliveryStatusItemCardDeliveryStatus_QNAME = new QName("http://sab/", "cardDeliveryStatus");
    private final static QName _GetCardDeliveryStatusItemDeliveryChannel_QNAME = new QName("http://sab/", "deliveryChannel");
    private final static QName _GetCardDeliveryStatusItemCardsCount_QNAME = new QName("http://sab/", "cardsCount");
    private final static QName _GetCardDeliveryStatusItemFileGenName_QNAME = new QName("http://sab/", "fileGenName");
    private final static QName _GetCardDeliveryStatusItemDeliveryStreetType_QNAME = new QName("http://sab/", "deliveryStreetType");
    private final static QName _GetCardDeliveryStatusItemDateExp_QNAME = new QName("http://sab/", "dateExp");
    private final static QName _GetCardDeliveryStatusItemChipExist_QNAME = new QName("http://sab/", "chipExist");
    private final static QName _GetCardDeliveryStatusItemManufacturer_QNAME = new QName("http://sab/", "manufacturer");
    private final static QName _GetCardDeliveryStatusItemDateCreate_QNAME = new QName("http://sab/", "dateCreate");
    private final static QName _GetProjectInfoByProjectIdItemProjectRegDate_QNAME = new QName("http://sab/", "projectRegDate");
    private final static QName _GetCardServiceStatesItemKService_QNAME = new QName("http://sab/", "kService");
    private final static QName _GetCardServiceStatesItemFinRiskInsurance_QNAME = new QName("http://sab/", "finRiskInsurance");
    private final static QName _GetCardServiceStatesItemAccidentInsurance_QNAME = new QName("http://sab/", "accidentInsurance");
    private final static QName _GetCardServiceStatesItemVoyage_QNAME = new QName("http://sab/", "voyage");
    private final static QName _GetCardServiceStatesItemAlfaCheck_QNAME = new QName("http://sab/", "alfaCheck");
    private final static QName _SetDeferredRenewCardItemNewCardId_QNAME = new QName("http://sab/", "newCardId");
    private final static QName _RepaymentInstallmentItemOSystem_QNAME = new QName("http://sab/", "oSystem");
    private final static QName _CardDeal6AccountNo8030_QNAME = new QName("http://sab/", "accountNo8030");
    private final static QName _GetCardDailyLimitsItemCanChange_QNAME = new QName("http://sab/", "canChange");
    private final static QName _GetCardDailyLimitsItemPurchaseMaxAmount_QNAME = new QName("http://sab/", "purchaseMaxAmount");
    private final static QName _GetCardDailyLimitsItemCashMaxAmount_QNAME = new QName("http://sab/", "cashMaxAmount");
    private final static QName _GetCardDailyLimitsItemPurchaseMaxCount_QNAME = new QName("http://sab/", "purchaseMaxCount");
    private final static QName _GetCardDailyLimitsItemTotalMaxCount_QNAME = new QName("http://sab/", "totalMaxCount");
    private final static QName _GetCardDailyLimitsItemEndDate_QNAME = new QName("http://sab/", "endDate");
    private final static QName _GetCardDailyLimitsItemTotalMaxAmount_QNAME = new QName("http://sab/", "totalMaxAmount");
    private final static QName _GetCardDailyLimitsItemCashMaxCount_QNAME = new QName("http://sab/", "cashMaxCount");
    private final static QName _GetProjectInfoByAgrtplnameItemOProjectid_QNAME = new QName("http://sab/", "o_Projectid");
    private final static QName _GetProjectInfoByAgrtplnameItemOOrgname_QNAME = new QName("http://sab/", "o_Orgname");
    private final static QName _GetProjectInfoByAgrtplnameItemOBlocked_QNAME = new QName("http://sab/", "o_Blocked");
    private final static QName _GetProjectInfoByAgrtplnameItemOPrefixid_QNAME = new QName("http://sab/", "o_Prefixid");
    private final static QName _GetProjectInfoByAgrtplnameItemOAgrtplid_QNAME = new QName("http://sab/", "o_Agrtplid");
    private final static QName _GetProjectInfoByAgrtplnameItemOPerccondid_QNAME = new QName("http://sab/", "o_Perccondid");
    private final static QName _GetProjectInfoByAgrtplnameItemOCcycharid_QNAME = new QName("http://sab/", "o_Ccycharid");
    private final static QName _GetProjectInfoByAgrtplnameItemOCondid_QNAME = new QName("http://sab/", "o_Condid");
    private final static QName _GetProjectInfoByAgrtplnameItemOProjectname_QNAME = new QName("http://sab/", "o_Projectname");
    private final static QName _GetProjectInfoByAgrtplnameItemOCodecardid_QNAME = new QName("http://sab/", "o_Codecardid");
    private final static QName _GetDNDStatusItemStatus_QNAME = new QName("http://sab/", "status");
    private final static QName _CheckCardActivationItemStatusMessage_QNAME = new QName("http://sab/", "statusMessage");
    private final static QName _GetDeliveryCardByMessageIdItemCardNum_QNAME = new QName("http://sab/", "cardNum");
    private final static QName _GetDeliveryCardByMessageIdItemErrDescription_QNAME = new QName("http://sab/", "errDescription");
    private final static QName _GetDeliveryCardByMessageIdItemProjectName_QNAME = new QName("http://sab/", "projectName");
    private final static QName _CheckAlfaChoiseEnableItemIsAlfaChoiseEnable_QNAME = new QName("http://sab/", "isAlfaChoiseEnable");
    private final static QName _CheckPinChangeItemReason_QNAME = new QName("http://sab/", "reason");
    private final static QName _CheckPinChangeItemChangeCount_QNAME = new QName("http://sab/", "changeCount");
    private final static QName _ActivateCardStatusSmsText_QNAME = new QName("http://sab/", "smsText");
    private final static QName _ActivateCardStatusMessage_QNAME = new QName("http://sab/", "message");
    private final static QName _GetStatementItemXmlStatment_QNAME = new QName("http://sab/", "xmlStatment");
    private final static QName _GetSalaryCreditTurnoverItemCreditTurnover_QNAME = new QName("http://sab/", "creditTurnover");
    private final static QName _GetSalaryCreditTurnoverItemCalculationDate_QNAME = new QName("http://sab/", "calculationDate");
    private final static QName _CheckInstallmentAvailabilityItemTransactionId_QNAME = new QName("http://sab/", "transactionId");
    private final static QName _GetUPCSessionUIDItemUid_QNAME = new QName("http://sab/", "uid");
    private final static QName _GetDBFilesListItemDbFilesList_QNAME = new QName("http://sab/", "dbFilesList");
    private final static QName _GetSubproductAttributesItemSplit_QNAME = new QName("http://sab/", "split");
    private final static QName _GetSubproductAttributesItemPremium_QNAME = new QName("http://sab/", "premium");
    private final static QName _GetSubproductAttributesItemSubProductGroup_QNAME = new QName("http://sab/", "subProductGroup");
    private final static QName _GetSubproductAttributesItemSubProductName_QNAME = new QName("http://sab/", "subProductName");
    private final static QName _GetSubproductAttributesItemLoyaltyCode_QNAME = new QName("http://sab/", "loyaltyCode");
    private final static QName _GetSubproductAttributesItemActualProduct_QNAME = new QName("http://sab/", "actualProduct");
    private final static QName _GetCardAccountBalanceItemBalanceAmountCash_QNAME = new QName("http://sab/", "balanceAmountCash");
    private final static QName _GetCardAccountBalanceItemBalanceAmountPos_QNAME = new QName("http://sab/", "balanceAmountPos");
    private final static QName _GetCardAccountBalanceItemBalanceAmount_QNAME = new QName("http://sab/", "balanceAmount");
    private final static QName _GetInstallmentProductItemInterestRate_QNAME = new QName("http://sab/", "interestRate");
    private final static QName _GetInstallmentProductItemAmountRange_QNAME = new QName("http://sab/", "amountRange");
    private final static QName _GetInstallmentProductItemTerm_QNAME = new QName("http://sab/", "term");
    private final static QName _GetInstallmentProductItemPayment_QNAME = new QName("http://sab/", "payment");
    private final static QName _GetAvailableAddCardItemPrefixName_QNAME = new QName("http://sab/", "prefixName");
    private final static QName _GetAvailableAddCardItemCardRiskClassName_QNAME = new QName("http://sab/", "cardRiskClassName");
    private final static QName _GetAvailableAddCardItemAuthRangeId_QNAME = new QName("http://sab/", "authRangeId");
    private final static QName _GetAvailableAddCardItemPrefixId_QNAME = new QName("http://sab/", "prefixId");
    private final static QName _GetAvailableAddCardItemAuthRangeName_QNAME = new QName("http://sab/", "authRangeName");
    private final static QName _GetIPSItemNameIPS_QNAME = new QName("http://sab/", "nameIPS");
    private final static QName _GetIPSItemCodeIPS_QNAME = new QName("http://sab/", "codeIPS");
    private final static QName _GetCardInfoShortItemCardID_QNAME = new QName("http://sab/", "cardID");
    private final static QName _GetCardInfoShortItemCardGUID_QNAME = new QName("http://sab/", "cardGUID");
    private final static QName _GetCustomerIDItemCustomerID_QNAME = new QName("http://sab/", "customerID");

    private final static QName _GetCustomerIDCardID_QNAME = new QName("http://sab/", "cardId");
    private final static QName _GetCustomerIDCardNum_QNAME = new QName("http://sab/", "cardNum");
    private final static QName _GetCustomerIDHashNum_QNAME = new QName("http://sab/", "hashNum");
    private final static QName _GetCustomerIDCardGUID_QNAME = new QName("http://sab/", "cardGUID");

    private final static QName _RecreateCardItemRenewCardHashNumber_QNAME = new QName("http://sab/", "renewCardHashNumber");
    private final static QName _GetCardsByContragentIdItemAccStatusId_QNAME = new QName("http://sab/", "accStatusId");
    private final static QName _GetCardsByContragentIdItemAccStatusText_QNAME = new QName("http://sab/", "accStatusText");
    private final static QName _GetCardsByContragentIdItemOriginalCardStatusId_QNAME = new QName("http://sab/", "originalCardStatusId");
    private final static QName _GetCardDeliveryStatusByTextItemComment_QNAME = new QName("http://sab/", "comment");
    private final static QName _GetCardDeliveryStatusByTextItemCanModify_QNAME = new QName("http://sab/", "canModify");
    private final static QName _GetCardTemplateItemTemplateName_QNAME = new QName("http://sab/", "templateName");
    private final static QName _GetCardTemplateItemCardTypeCode_QNAME = new QName("http://sab/", "cardTypeCode");
    private final static QName _GetCardDeliveryStatusLogItemUsername_QNAME = new QName("http://sab/", "username");
    private final static QName _GetCardDeliveryStatusLogItemTrackstatus_QNAME = new QName("http://sab/", "trackstatus");
    private final static QName _GetCardDeliveryStatusLogItemLastchangedate_QNAME = new QName("http://sab/", "lastchangedate");
    private final static QName _SetCardStopListItemCodeOut_QNAME = new QName("http://sab/", "codeOut");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cts.fasttack.bank.client.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DataServiceFault }
     *
     */
    public DataServiceFault createDataServiceFault() {
        return new DataServiceFault();
    }

    /**
     * Create an instance of {@link DATASERVICERESPONSE }
     *
     */
    public DATASERVICERESPONSE createDATASERVICERESPONSE() {
        return new DATASERVICERESPONSE();
    }

    /**
     * Create an instance of {@link DataServiceFault.SourceDataService }
     *
     */
    public DataServiceFault.SourceDataService createDataServiceFaultSourceDataService() {
        return new DataServiceFault.SourceDataService();
    }

    /**
     * Create an instance of {@link SetStatementMode }
     *
     */
    public SetStatementMode createSetStatementMode() {
        return new SetStatementMode();
    }

    /**
     * Create an instance of {@link GetCardInfo }
     *
     */
    public GetCardInfo createGetCardInfo() {
        return new GetCardInfo();
    }

    /**
     * Create an instance of {@link GetCardInfoByCardId }
     *
     */
    public GetCardInfoByCardId createGetCardInfoByCardId() {
        return new GetCardInfoByCardId();
    }

    /**
     * Create an instance of {@link GetBalanceInIcResponse }
     *
     */
    public GetBalanceInIcResponse createGetBalanceInIcResponse() {
        return new GetBalanceInIcResponse();
    }

    /**
     * Create an instance of {@link GetCardInfoByAccountNo }
     *
     */
    public GetCardInfoByAccountNo createGetCardInfoByAccountNo() {
        return new GetCardInfoByAccountNo();
    }

    /**
     * Create an instance of {@link InsBsnStopAfterEmbResponse }
     *
     */
    public InsBsnStopAfterEmbResponse createInsBsnStopAfterEmbResponse() {
        return new InsBsnStopAfterEmbResponse();
    }

    /**
     * Create an instance of {@link GetExtClientPrivId }
     *
     */
    public GetExtClientPrivId createGetExtClientPrivId() {
        return new GetExtClientPrivId();
    }

    /**
     * Create an instance of {@link FreezeCardAccountResponse }
     *
     */
    public FreezeCardAccountResponse createFreezeCardAccountResponse() {
        return new FreezeCardAccountResponse();
    }

    /**
     * Create an instance of {@link InsBsnStopAfterEmb }
     *
     */
    public InsBsnStopAfterEmb createInsBsnStopAfterEmb() {
        return new InsBsnStopAfterEmb();
    }

    /**
     * Create an instance of {@link ChangeStatusMonitoringTransactionsResponse }
     *
     */
    public ChangeStatusMonitoringTransactionsResponse createChangeStatusMonitoringTransactionsResponse() {
        return new ChangeStatusMonitoringTransactionsResponse();
    }

    /**
     * Create an instance of {@link CheckTransferResponse }
     *
     */
    public CheckTransferResponse createCheckTransferResponse() {
        return new CheckTransferResponse();
    }

    /**
     * Create an instance of {@link GetCVV2FlagResponse }
     *
     */
    public GetCVV2FlagResponse createGetCVV2FlagResponse() {
        return new GetCVV2FlagResponse();
    }

    /**
     * Create an instance of {@link GetAdditionalInstallmentInfoResponse }
     *
     */
    public GetAdditionalInstallmentInfoResponse createGetAdditionalInstallmentInfoResponse() {
        return new GetAdditionalInstallmentInfoResponse();
    }

    /**
     * Create an instance of {@link GetCardDealsByTaxIdResponse }
     *
     */
    public GetCardDealsByTaxIdResponse createGetCardDealsByTaxIdResponse() {
        return new GetCardDealsByTaxIdResponse();
    }

    /**
     * Create an instance of {@link CardDealInfoList }
     *
     */
    public CardDealInfoList createCardDealInfoList() {
        return new CardDealInfoList();
    }

    /**
     * Create an instance of {@link GetCardDeliveryBranchesResponse }
     *
     */
    public GetCardDeliveryBranchesResponse createGetCardDeliveryBranchesResponse() {
        return new GetCardDeliveryBranchesResponse();
    }

    /**
     * Create an instance of {@link GetReportDeliveryModes }
     *
     */
    public GetReportDeliveryModes createGetReportDeliveryModes() {
        return new GetReportDeliveryModes();
    }

    /**
     * Create an instance of {@link SetCardDeliveryAddress }
     *
     */
    public SetCardDeliveryAddress createSetCardDeliveryAddress() {
        return new SetCardDeliveryAddress();
    }

    /**
     * Create an instance of {@link GetUPCSessionUIDResponse }
     *
     */
    public GetUPCSessionUIDResponse createGetUPCSessionUIDResponse() {
        return new GetUPCSessionUIDResponse();
    }

    /**
     * Create an instance of {@link GetCardAccountBalanceResponse }
     *
     */
    public GetCardAccountBalanceResponse createGetCardAccountBalanceResponse() {
        return new GetCardAccountBalanceResponse();
    }

    /**
     * Create an instance of {@link GetCardDealsByAccountNo }
     *
     */
    public GetCardDealsByAccountNo createGetCardDealsByAccountNo() {
        return new GetCardDealsByAccountNo();
    }

    /**
     * Create an instance of {@link RemoveCardDeal }
     *
     */
    public RemoveCardDeal createRemoveCardDeal() {
        return new RemoveCardDeal();
    }

    /**
     * Create an instance of {@link SetCardStopListResponse }
     *
     */
    public SetCardStopListResponse createSetCardStopListResponse() {
        return new SetCardStopListResponse();
    }

    /**
     * Create an instance of {@link SetDNDStatusResponse }
     *
     */
    public SetDNDStatusResponse createSetDNDStatusResponse() {
        return new SetDNDStatusResponse();
    }

    /**
     * Create an instance of {@link DisableMBanking }
     *
     */
    public DisableMBanking createDisableMBanking() {
        return new DisableMBanking();
    }

    /**
     * Create an instance of {@link GetCurrentNewSubproductResponse }
     *
     */
    public GetCurrentNewSubproductResponse createGetCurrentNewSubproductResponse() {
        return new GetCurrentNewSubproductResponse();
    }

    /**
     * Create an instance of {@link GetRateYieldSafeResponse }
     *
     */
    public GetRateYieldSafeResponse createGetRateYieldSafeResponse() {
        return new GetRateYieldSafeResponse();
    }

    /**
     * Create an instance of {@link GetCardServiceStatesResponse }
     *
     */
    public GetCardServiceStatesResponse createGetCardServiceStatesResponse() {
        return new GetCardServiceStatesResponse();
    }

    /**
     * Create an instance of {@link ActivateCardDealResponse }
     *
     */
    public ActivateCardDealResponse createActivateCardDealResponse() {
        return new ActivateCardDealResponse();
    }

    /**
     * Create an instance of {@link UpdateDBFileFlagResponse }
     *
     */
    public UpdateDBFileFlagResponse createUpdateDBFileFlagResponse() {
        return new UpdateDBFileFlagResponse();
    }

    /**
     * Create an instance of {@link GetSubproductCodesByAtrributeResponse }
     *
     */
    public GetSubproductCodesByAtrributeResponse createGetSubproductCodesByAtrributeResponse() {
        return new GetSubproductCodesByAtrributeResponse();
    }

    /**
     * Create an instance of {@link GetSubproductCodesByAtrribute }
     *
     */
    public GetSubproductCodesByAtrribute createGetSubproductCodesByAtrribute() {
        return new GetSubproductCodesByAtrribute();
    }

    /**
     * Create an instance of {@link GetCurrentSubproductResponse }
     *
     */
    public GetCurrentSubproductResponse createGetCurrentSubproductResponse() {
        return new GetCurrentSubproductResponse();
    }

    /**
     * Create an instance of {@link RepaymentInstallment }
     *
     */
    public RepaymentInstallment createRepaymentInstallment() {
        return new RepaymentInstallment();
    }

    /**
     * Create an instance of {@link GetProjectInfoByAgrtplnameResponse }
     *
     */
    public GetProjectInfoByAgrtplnameResponse createGetProjectInfoByAgrtplnameResponse() {
        return new GetProjectInfoByAgrtplnameResponse();
    }

    /**
     * Create an instance of {@link ActivateCard }
     *
     */
    public ActivateCard createActivateCard() {
        return new ActivateCard();
    }

    /**
     * Create an instance of {@link GetCardDeliveryStatus }
     *
     */
    public GetCardDeliveryStatus createGetCardDeliveryStatus() {
        return new GetCardDeliveryStatus();
    }

    /**
     * Create an instance of {@link RecreateCardResponse }
     *
     */
    public RecreateCardResponse createRecreateCardResponse() {
        return new RecreateCardResponse();
    }

    /**
     * Create an instance of {@link GetAvailableAddCardResponse }
     *
     */
    public GetAvailableAddCardResponse createGetAvailableAddCardResponse() {
        return new GetAvailableAddCardResponse();
    }

    /**
     * Create an instance of {@link SetCardDailyLimits }
     *
     */
    public SetCardDailyLimits createSetCardDailyLimits() {
        return new SetCardDailyLimits();
    }

    /**
     * Create an instance of {@link GetCardDealsByContragentIdResponse }
     *
     */
    public GetCardDealsByContragentIdResponse createGetCardDealsByContragentIdResponse() {
        return new GetCardDealsByContragentIdResponse();
    }

    /**
     * Create an instance of {@link CancelCardDeal }
     *
     */
    public CancelCardDeal createCancelCardDeal() {
        return new CancelCardDeal();
    }

    /**
     * Create an instance of {@link SetDeferredRenewCard }
     *
     */
    public SetDeferredRenewCard createSetDeferredRenewCard() {
        return new SetDeferredRenewCard();
    }

    /**
     * Create an instance of {@link GetCardInfoById }
     *
     */
    public GetCardInfoById createGetCardInfoById() {
        return new GetCardInfoById();
    }

    /**
     * Create an instance of {@link GetFinAccBySiebel }
     *
     */
    public GetFinAccBySiebel createGetFinAccBySiebel() {
        return new GetFinAccBySiebel();
    }

    /**
     * Create an instance of {@link DisableOldCard }
     *
     */
    public DisableOldCard createDisableOldCard() {
        return new DisableOldCard();
    }

    /**
     * Create an instance of {@link SetCardDailyLimitsResponse }
     *
     */
    public SetCardDailyLimitsResponse createSetCardDailyLimitsResponse() {
        return new SetCardDailyLimitsResponse();
    }

    /**
     * Create an instance of {@link GetCardInfoResponse }
     *
     */
    public GetCardInfoResponse createGetCardInfoResponse() {
        return new GetCardInfoResponse();
    }

    /**
     * Create an instance of {@link GetSubproductAttributesResponse }
     *
     */
    public GetSubproductAttributesResponse createGetSubproductAttributesResponse() {
        return new GetSubproductAttributesResponse();
    }

    /**
     * Create an instance of {@link GetFinCorpAccBySiebel }
     *
     */
    public GetFinCorpAccBySiebel createGetFinCorpAccBySiebel() {
        return new GetFinCorpAccBySiebel();
    }

    /**
     * Create an instance of {@link RecreateCard }
     *
     */
    public RecreateCard createRecreateCard() {
        return new RecreateCard();
    }

    /**
     * Create an instance of {@link GetActiveInstallmentsInfoResponse }
     *
     */
    public GetActiveInstallmentsInfoResponse createGetActiveInstallmentsInfoResponse() {
        return new GetActiveInstallmentsInfoResponse();
    }

    /**
     * Create an instance of {@link GetFinCorpAccBySiebelResponse }
     *
     */
    public GetFinCorpAccBySiebelResponse createGetFinCorpAccBySiebelResponse() {
        return new GetFinCorpAccBySiebelResponse();
    }

    /**
     * Create an instance of {@link SetStatementModeResponse }
     *
     */
    public SetStatementModeResponse createSetStatementModeResponse() {
        return new SetStatementModeResponse();
    }

    /**
     * Create an instance of {@link ChangeBranchCode }
     *
     */
    public ChangeBranchCode createChangeBranchCode() {
        return new ChangeBranchCode();
    }

    /**
     * Create an instance of {@link GetReportDeliveryModesResponse }
     *
     */
    public GetReportDeliveryModesResponse createGetReportDeliveryModesResponse() {
        return new GetReportDeliveryModesResponse();
    }

    /**
     * Create an instance of {@link GetInstallmentProductResponse }
     *
     */
    public GetInstallmentProductResponse createGetInstallmentProductResponse() {
        return new GetInstallmentProductResponse();
    }

    /**
     * Create an instance of {@link ClientRebinding }
     *
     */
    public ClientRebinding createClientRebinding() {
        return new ClientRebinding();
    }

    /**
     * Create an instance of {@link GetAccountInfoByCardNumber }
     *
     */
    public GetAccountInfoByCardNumber createGetAccountInfoByCardNumber() {
        return new GetAccountInfoByCardNumber();
    }

    /**
     * Create an instance of {@link AddCardRebindingResponse }
     *
     */
    public AddCardRebindingResponse createAddCardRebindingResponse() {
        return new AddCardRebindingResponse();
    }

    /**
     * Create an instance of {@link FreezeCardAccount }
     *
     */
    public FreezeCardAccount createFreezeCardAccount() {
        return new FreezeCardAccount();
    }

    /**
     * Create an instance of {@link GetCardInfoShort }
     *
     */
    public GetCardInfoShort createGetCardInfoShort() {
        return new GetCardInfoShort();
    }

    /**
     * Create an instance of {@link GetDBFilesListResponse }
     *
     */
    public GetDBFilesListResponse createGetDBFilesListResponse() {
        return new GetDBFilesListResponse();
    }

    /**
     * Create an instance of {@link SetDeferredReissueCardStatusResponse }
     *
     */
    public SetDeferredReissueCardStatusResponse createSetDeferredReissueCardStatusResponse() {
        return new SetDeferredReissueCardStatusResponse();
    }

    /**
     * Create an instance of {@link GetCardDealInfoByBarCodeResponse }
     *
     */
    public GetCardDealInfoByBarCodeResponse createGetCardDealInfoByBarCodeResponse() {
        return new GetCardDealInfoByBarCodeResponse();
    }

    /**
     * Create an instance of {@link GetAccountInfoByCardNumberResponse }
     *
     */
    public GetAccountInfoByCardNumberResponse createGetAccountInfoByCardNumberResponse() {
        return new GetAccountInfoByCardNumberResponse();
    }

    /**
     * Create an instance of {@link CheckAlfaChoiseEnable }
     *
     */
    public CheckAlfaChoiseEnable createCheckAlfaChoiseEnable() {
        return new CheckAlfaChoiseEnable();
    }

    /**
     * Create an instance of {@link GetAvailableAddCard }
     *
     */
    public GetAvailableAddCard createGetAvailableAddCard() {
        return new GetAvailableAddCard();
    }

    /**
     * Create an instance of {@link GetAdditionalInstallmentInfo }
     *
     */
    public GetAdditionalInstallmentInfo createGetAdditionalInstallmentInfo() {
        return new GetAdditionalInstallmentInfo();
    }

    /**
     * Create an instance of {@link SetBarCode }
     *
     */
    public SetBarCode createSetBarCode() {
        return new SetBarCode();
    }

    /**
     * Create an instance of {@link GetCardManufacturers }
     *
     */
    public GetCardManufacturers createGetCardManufacturers() {
        return new GetCardManufacturers();
    }

    /**
     * Create an instance of {@link SetInstallmentRepayment }
     *
     */
    public SetInstallmentRepayment createSetInstallmentRepayment() {
        return new SetInstallmentRepayment();
    }

    /**
     * Create an instance of {@link GetRateYieldSafe }
     *
     */
    public GetRateYieldSafe createGetRateYieldSafe() {
        return new GetRateYieldSafe();
    }

    /**
     * Create an instance of {@link CheckCodeWordResponse }
     *
     */
    public CheckCodeWordResponse createCheckCodeWordResponse() {
        return new CheckCodeWordResponse();
    }

    /**
     * Create an instance of {@link GetReIssueCards }
     *
     */
    public GetReIssueCards createGetReIssueCards() {
        return new GetReIssueCards();
    }

    /**
     * Create an instance of {@link SetUpSellNotReissuing }
     *
     */
    public SetUpSellNotReissuing createSetUpSellNotReissuing() {
        return new SetUpSellNotReissuing();
    }

    /**
     * Create an instance of {@link GetDeliveryCardByMessageIdResponse }
     *
     */
    public GetDeliveryCardByMessageIdResponse createGetDeliveryCardByMessageIdResponse() {
        return new GetDeliveryCardByMessageIdResponse();
    }

    /**
     * Create an instance of {@link GetCardDealByCardNumberResponse }
     *
     */
    public GetCardDealByCardNumberResponse createGetCardDealByCardNumberResponse() {
        return new GetCardDealByCardNumberResponse();
    }

    /**
     * Create an instance of {@link RegisterAddCardResponse }
     *
     */
    public RegisterAddCardResponse createRegisterAddCardResponse() {
        return new RegisterAddCardResponse();
    }

    /**
     * Create an instance of {@link RepaymentInstallmentResponse }
     *
     */
    public RepaymentInstallmentResponse createRepaymentInstallmentResponse() {
        return new RepaymentInstallmentResponse();
    }

    /**
     * Create an instance of {@link CheckCardActivationResponse }
     *
     */
    public CheckCardActivationResponse createCheckCardActivationResponse() {
        return new CheckCardActivationResponse();
    }

    /**
     * Create an instance of {@link GetCardDealByDealIdResponse }
     *
     */
    public GetCardDealByDealIdResponse createGetCardDealByDealIdResponse() {
        return new GetCardDealByDealIdResponse();
    }

    /**
     * Create an instance of {@link GetAvailIdArrayResponse }
     *
     */
    public GetAvailIdArrayResponse createGetAvailIdArrayResponse() {
        return new GetAvailIdArrayResponse();
    }

    /**
     * Create an instance of {@link CardList }
     *
     */
    public CardList createCardList() {
        return new CardList();
    }

    /**
     * Create an instance of {@link ActivateCardByIdResponse }
     *
     */
    public ActivateCardByIdResponse createActivateCardByIdResponse() {
        return new ActivateCardByIdResponse();
    }

    /**
     * Create an instance of {@link GetCardDailyLimitsResponse }
     *
     */
    public GetCardDailyLimitsResponse createGetCardDailyLimitsResponse() {
        return new GetCardDailyLimitsResponse();
    }

    /**
     * Create an instance of {@link GetSalaryCreditTurnover }
     *
     */
    public GetSalaryCreditTurnover createGetSalaryCreditTurnover() {
        return new GetSalaryCreditTurnover();
    }

    /**
     * Create an instance of {@link SetBarCodeResponse }
     *
     */
    public SetBarCodeResponse createSetBarCodeResponse() {
        return new SetBarCodeResponse();
    }

    /**
     * Create an instance of {@link GetCardAccountBalance }
     *
     */
    public GetCardAccountBalance createGetCardAccountBalance() {
        return new GetCardAccountBalance();
    }

    /**
     * Create an instance of {@link SetDeferredRenewCardResponse }
     *
     */
    public SetDeferredRenewCardResponse createSetDeferredRenewCardResponse() {
        return new SetDeferredRenewCardResponse();
    }

    /**
     * Create an instance of {@link CheckOpportunityRecreateCard }
     *
     */
    public CheckOpportunityRecreateCard createCheckOpportunityRecreateCard() {
        return new CheckOpportunityRecreateCard();
    }

    /**
     * Create an instance of {@link CheckInstallmentAvailabilityResponse }
     *
     */
    public CheckInstallmentAvailabilityResponse createCheckInstallmentAvailabilityResponse() {
        return new CheckInstallmentAvailabilityResponse();
    }

    /**
     * Create an instance of {@link GetCardServiceStates }
     *
     */
    public GetCardServiceStates createGetCardServiceStates() {
        return new GetCardServiceStates();
    }

    /**
     * Create an instance of {@link GetCardInfoByCardIdResponse }
     *
     */
    public GetCardInfoByCardIdResponse createGetCardInfoByCardIdResponse() {
        return new GetCardInfoByCardIdResponse();
    }

    /**
     * Create an instance of {@link GetDeliveryCardByMessageId }
     *
     */
    public GetDeliveryCardByMessageId createGetDeliveryCardByMessageId() {
        return new GetDeliveryCardByMessageId();
    }

    /**
     * Create an instance of {@link ChangeBranchCodeResponse }
     *
     */
    public ChangeBranchCodeResponse createChangeBranchCodeResponse() {
        return new ChangeBranchCodeResponse();
    }

    /**
     * Create an instance of {@link GetProjectInfoByProjectId }
     *
     */
    public GetProjectInfoByProjectId createGetProjectInfoByProjectId() {
        return new GetProjectInfoByProjectId();
    }

    /**
     * Create an instance of {@link CancelCardDealResponse }
     *
     */
    public CancelCardDealResponse createCancelCardDealResponse() {
        return new CancelCardDealResponse();
    }

    /**
     * Create an instance of {@link GetInstallmentProduct }
     *
     */
    public GetInstallmentProduct createGetInstallmentProduct() {
        return new GetInstallmentProduct();
    }

    /**
     * Create an instance of {@link GetCardDealStateResponse }
     *
     */
    public GetCardDealStateResponse createGetCardDealStateResponse() {
        return new GetCardDealStateResponse();
    }

    /**
     * Create an instance of {@link IdentifyCard }
     *
     */
    public IdentifyCard createIdentifyCard() {
        return new IdentifyCard();
    }

    /**
     * Create an instance of {@link GetCardManufacturersResponse }
     *
     */
    public GetCardManufacturersResponse createGetCardManufacturersResponse() {
        return new GetCardManufacturersResponse();
    }

    /**
     * Create an instance of {@link GetCardDealsByAccountNoResponse }
     *
     */
    public GetCardDealsByAccountNoResponse createGetCardDealsByAccountNoResponse() {
        return new GetCardDealsByAccountNoResponse();
    }

    /**
     * Create an instance of {@link UpdateDBFileFlag }
     *
     */
    public UpdateDBFileFlag createUpdateDBFileFlag() {
        return new UpdateDBFileFlag();
    }

    /**
     * Create an instance of {@link GetCardTransactionList }
     *
     */
    public GetCardTransactionList createGetCardTransactionList() {
        return new GetCardTransactionList();
    }

    /**
     * Create an instance of {@link EnableMBankingResponse }
     *
     */
    public EnableMBankingResponse createEnableMBankingResponse() {
        return new EnableMBankingResponse();
    }

    /**
     * Create an instance of {@link CheckAlfaChoiseEnableResponse }
     *
     */
    public CheckAlfaChoiseEnableResponse createCheckAlfaChoiseEnableResponse() {
        return new CheckAlfaChoiseEnableResponse();
    }

    /**
     * Create an instance of {@link GetDNDStatus }
     *
     */
    public GetDNDStatus createGetDNDStatus() {
        return new GetDNDStatus();
    }

    /**
     * Create an instance of {@link GetFinsAppCardBySiebel }
     *
     */
    public GetFinsAppCardBySiebel createGetFinsAppCardBySiebel() {
        return new GetFinsAppCardBySiebel();
    }

    /**
     * Create an instance of {@link RegisterCardDeal }
     *
     */
    public RegisterCardDeal createRegisterCardDeal() {
        return new RegisterCardDeal();
    }

    /**
     * Create an instance of {@link DisableMBankingResponse }
     *
     */
    public DisableMBankingResponse createDisableMBankingResponse() {
        return new DisableMBankingResponse();
    }

    /**
     * Create an instance of {@link GetStatementResponse }
     *
     */
    public GetStatementResponse createGetStatementResponse() {
        return new GetStatementResponse();
    }

    /**
     * Create an instance of {@link GetCardDeliveryBranches }
     *
     */
    public GetCardDeliveryBranches createGetCardDeliveryBranches() {
        return new GetCardDeliveryBranches();
    }

    /**
     * Create an instance of {@link RegisterCardContragent }
     *
     */
    public RegisterCardContragent createRegisterCardContragent() {
        return new RegisterCardContragent();
    }

    /**
     * Create an instance of {@link ChangeDealPhoneNumberResponse }
     *
     */
    public ChangeDealPhoneNumberResponse createChangeDealPhoneNumberResponse() {
        return new ChangeDealPhoneNumberResponse();
    }

    /**
     * Create an instance of {@link GetTransactionHistoryResponse }
     *
     */
    public GetTransactionHistoryResponse createGetTransactionHistoryResponse() {
        return new GetTransactionHistoryResponse();
    }

    /**
     * Create an instance of {@link GetCardDeliveryBranch }
     *
     */
    public GetCardDeliveryBranch createGetCardDeliveryBranch() {
        return new GetCardDeliveryBranch();
    }

    /**
     * Create an instance of {@link ChangeStatusMonitoringTransactions }
     *
     */
    public ChangeStatusMonitoringTransactions createChangeStatusMonitoringTransactions() {
        return new ChangeStatusMonitoringTransactions();
    }

    /**
     * Create an instance of {@link CheckOpportunityRecreateCardResponse }
     *
     */
    public CheckOpportunityRecreateCardResponse createCheckOpportunityRecreateCardResponse() {
        return new CheckOpportunityRecreateCardResponse();
    }

    /**
     * Create an instance of {@link GetCardDailyLimits }
     *
     */
    public GetCardDailyLimits createGetCardDailyLimits() {
        return new GetCardDailyLimits();
    }

    /**
     * Create an instance of {@link GetActualBalanceByCardResponse }
     *
     */
    public GetActualBalanceByCardResponse createGetActualBalanceByCardResponse() {
        return new GetActualBalanceByCardResponse();
    }

    /**
     * Create an instance of {@link SetUpSellNotReissuingResponse }
     *
     */
    public SetUpSellNotReissuingResponse createSetUpSellNotReissuingResponse() {
        return new SetUpSellNotReissuingResponse();
    }

    /**
     * Create an instance of {@link GetCardDealByDealId }
     *
     */
    public GetCardDealByDealId createGetCardDealByDealId() {
        return new GetCardDealByDealId();
    }

    /**
     * Create an instance of {@link GetCardDealInfoByICDealId }
     *
     */
    public GetCardDealInfoByICDealId createGetCardDealInfoByICDealId() {
        return new GetCardDealInfoByICDealId();
    }

    /**
     * Create an instance of {@link GetIPSResponse }
     *
     */
    public GetIPSResponse createGetIPSResponse() {
        return new GetIPSResponse();
    }

    /**
     * Create an instance of {@link GetCardDealsByTaxId }
     *
     */
    public GetCardDealsByTaxId createGetCardDealsByTaxId() {
        return new GetCardDealsByTaxId();
    }

    /**
     * Create an instance of {@link GetBalanceInIc }
     *
     */
    public GetBalanceInIc createGetBalanceInIc() {
        return new GetBalanceInIc();
    }

    /**
     * Create an instance of {@link GetUPCSessionUID }
     *
     */
    public GetUPCSessionUID createGetUPCSessionUID() {
        return new GetUPCSessionUID();
    }

    /**
     * Create an instance of {@link GetActiveInstallmentsInfo }
     *
     */
    public GetActiveInstallmentsInfo createGetActiveInstallmentsInfo() {
        return new GetActiveInstallmentsInfo();
    }

    /**
     * Create an instance of {@link GetStatusMonitoringTransactionsResponse }
     *
     */
    public GetStatusMonitoringTransactionsResponse createGetStatusMonitoringTransactionsResponse() {
        return new GetStatusMonitoringTransactionsResponse();
    }

    /**
     * Create an instance of {@link SetDNDStatus }
     *
     */
    public SetDNDStatus createSetDNDStatus() {
        return new SetDNDStatus();
    }

    /**
     * Create an instance of {@link RegisterCardDealResponse }
     *
     */
    public RegisterCardDealResponse createRegisterCardDealResponse() {
        return new RegisterCardDealResponse();
    }

    /**
     * Create an instance of {@link ID }
     *
     */
    public ID createID() {
        return new ID();
    }

    /**
     * Create an instance of {@link EnableMBanking }
     *
     */
    public EnableMBanking createEnableMBanking() {
        return new EnableMBanking();
    }

    /**
     * Create an instance of {@link GetAvailIdArray }
     *
     */
    public GetAvailIdArray createGetAvailIdArray() {
        return new GetAvailIdArray();
    }

    /**
     * Create an instance of {@link SetInstallmentRepaymentResponse }
     *
     */
    public SetInstallmentRepaymentResponse createSetInstallmentRepaymentResponse() {
        return new SetInstallmentRepaymentResponse();
    }

    /**
     * Create an instance of {@link ChangeSubproductCode }
     *
     */
    public ChangeSubproductCode createChangeSubproductCode() {
        return new ChangeSubproductCode();
    }

    /**
     * Create an instance of {@link GetCardDealFees }
     *
     */
    public GetCardDealFees createGetCardDealFees() {
        return new GetCardDealFees();
    }

    /**
     * Create an instance of {@link GetCardInfoShortResponse }
     *
     */
    public GetCardInfoShortResponse createGetCardInfoShortResponse() {
        return new GetCardInfoShortResponse();
    }

    /**
     * Create an instance of {@link RegisterCardContragentResponse }
     *
     */
    public RegisterCardContragentResponse createRegisterCardContragentResponse() {
        return new RegisterCardContragentResponse();
    }

    /**
     * Create an instance of {@link GetCardDealsByDealNo }
     *
     */
    public GetCardDealsByDealNo createGetCardDealsByDealNo() {
        return new GetCardDealsByDealNo();
    }

    /**
     * Create an instance of {@link GetCardIdByCardNumber }
     *
     */
    public GetCardIdByCardNumber createGetCardIdByCardNumber() {
        return new GetCardIdByCardNumber();
    }

    /**
     * Create an instance of {@link GetExtClientPrivIdResponse }
     *
     */
    public GetExtClientPrivIdResponse createGetExtClientPrivIdResponse() {
        return new GetExtClientPrivIdResponse();
    }

    /**
     * Create an instance of {@link ActivateCardDeal }
     *
     */
    public ActivateCardDeal createActivateCardDeal() {
        return new ActivateCardDeal();
    }

    /**
     * Create an instance of {@link GetCardDealInfoByBarCode }
     *
     */
    public GetCardDealInfoByBarCode createGetCardDealInfoByBarCode() {
        return new GetCardDealInfoByBarCode();
    }

    /**
     * Create an instance of {@link GetCardDeliveryStatusResponse }
     *
     */
    public GetCardDeliveryStatusResponse createGetCardDeliveryStatusResponse() {
        return new GetCardDeliveryStatusResponse();
    }

    /**
     * Create an instance of {@link GetCardDeliveryStatusLog }
     *
     */
    public GetCardDeliveryStatusLog createGetCardDeliveryStatusLog() {
        return new GetCardDeliveryStatusLog();
    }

    /**
     * Create an instance of {@link GetDNDStatusResponse }
     *
     */
    public GetDNDStatusResponse createGetDNDStatusResponse() {
        return new GetDNDStatusResponse();
    }

    /**
     * Create an instance of {@link CheckInstallmentAvailability }
     *
     */
    public CheckInstallmentAvailability createCheckInstallmentAvailability() {
        return new CheckInstallmentAvailability();
    }

    /**
     * Create an instance of {@link GetCustomerIDResponse }
     *
     */
    public GetCustomerIDResponse createGetCustomerIDResponse() {
        return new GetCustomerIDResponse();
    }

    /**
     * Create an instance of {@link SetCardDeliveryStatus }
     *
     */
    public SetCardDeliveryStatus createSetCardDeliveryStatus() {
        return new SetCardDeliveryStatus();
    }

    /**
     * Create an instance of {@link RemoveCardDealResponse }
     *
     */
    public RemoveCardDealResponse createRemoveCardDealResponse() {
        return new RemoveCardDealResponse();
    }

    /**
     * Create an instance of {@link SetCodeWordResponse }
     *
     */
    public SetCodeWordResponse createSetCodeWordResponse() {
        return new SetCodeWordResponse();
    }

    /**
     * Create an instance of {@link GetNewSubproduct }
     *
     */
    public GetNewSubproduct createGetNewSubproduct() {
        return new GetNewSubproduct();
    }

    /**
     * Create an instance of {@link SetNewSubproductByCardResponse }
     *
     */
    public SetNewSubproductByCardResponse createSetNewSubproductByCardResponse() {
        return new SetNewSubproductByCardResponse();
    }

    /**
     * Create an instance of {@link GetCardDeliveryBranchResponse }
     *
     */
    public GetCardDeliveryBranchResponse createGetCardDeliveryBranchResponse() {
        return new GetCardDeliveryBranchResponse();
    }

    /**
     * Create an instance of {@link CheckTransfer }
     *
     */
    public CheckTransfer createCheckTransfer() {
        return new CheckTransfer();
    }

    /**
     * Create an instance of {@link GetCVV2Flag }
     *
     */
    public GetCVV2Flag createGetCVV2Flag() {
        return new GetCVV2Flag();
    }

    /**
     * Create an instance of {@link ClientRebindingResponse }
     *
     */
    public ClientRebindingResponse createClientRebindingResponse() {
        return new ClientRebindingResponse();
    }

    /**
     * Create an instance of {@link CheckPinChange }
     *
     */
    public CheckPinChange createCheckPinChange() {
        return new CheckPinChange();
    }

    /**
     * Create an instance of {@link SetCardStopList }
     *
     */
    public SetCardStopList createSetCardStopList() {
        return new SetCardStopList();
    }

    /**
     * Create an instance of {@link GetCardTemplateResponse }
     *
     */
    public GetCardTemplateResponse createGetCardTemplateResponse() {
        return new GetCardTemplateResponse();
    }

    /**
     * Create an instance of {@link GetCardsByContragentId }
     *
     */
    public GetCardsByContragentId createGetCardsByContragentId() {
        return new GetCardsByContragentId();
    }

    /**
     * Create an instance of {@link CheckPinChangeResponse }
     *
     */
    public CheckPinChangeResponse createCheckPinChangeResponse() {
        return new CheckPinChangeResponse();
    }

    /**
     * Create an instance of {@link GetCardDealJurResponse }
     *
     */
    public GetCardDealJurResponse createGetCardDealJurResponse() {
        return new GetCardDealJurResponse();
    }

    /**
     * Create an instance of {@link GetStatusMonitoringTransactions }
     *
     */
    public GetStatusMonitoringTransactions createGetStatusMonitoringTransactions() {
        return new GetStatusMonitoringTransactions();
    }

    /**
     * Create an instance of {@link GetCardAccountOperations }
     *
     */
    public GetCardAccountOperations createGetCardAccountOperations() {
        return new GetCardAccountOperations();
    }

    /**
     * Create an instance of {@link GetCardsByContragentIdResponse }
     *
     */
    public GetCardsByContragentIdResponse createGetCardsByContragentIdResponse() {
        return new GetCardsByContragentIdResponse();
    }

    /**
     * Create an instance of {@link GetCustomerID }
     *
     */
    public GetCustomerID createGetCustomerID() {
        return new GetCustomerID();
    }

    /**
     * Create an instance of {@link ActivateCardStatuses }
     *
     */
    public ActivateCardStatuses createActivateCardStatuses() {
        return new ActivateCardStatuses();
    }

    /**
     * Create an instance of {@link GetCardAccountBillingReport }
     *
     */
    public GetCardAccountBillingReport createGetCardAccountBillingReport() {
        return new GetCardAccountBillingReport();
    }

    /**
     * Create an instance of {@link ProcessInstallment }
     *
     */
    public ProcessInstallment createProcessInstallment() {
        return new ProcessInstallment();
    }

    /**
     * Create an instance of {@link GetActualBalanceByCard }
     *
     */
    public GetActualBalanceByCard createGetActualBalanceByCard() {
        return new GetActualBalanceByCard();
    }

    /**
     * Create an instance of {@link GetIPS }
     *
     */
    public GetIPS createGetIPS() {
        return new GetIPS();
    }

    /**
     * Create an instance of {@link GetFinsAppCardBySiebelResponse }
     *
     */
    public GetFinsAppCardBySiebelResponse createGetFinsAppCardBySiebelResponse() {
        return new GetFinsAppCardBySiebelResponse();
    }

    /**
     * Create an instance of {@link GetCardDealJur }
     *
     */
    public GetCardDealJur createGetCardDealJur() {
        return new GetCardDealJur();
    }

    /**
     * Create an instance of {@link GetCardDealByCardNumber }
     *
     */
    public GetCardDealByCardNumber createGetCardDealByCardNumber() {
        return new GetCardDealByCardNumber();
    }

    /**
     * Create an instance of {@link GetTransactionHistory }
     *
     */
    public GetTransactionHistory createGetTransactionHistory() {
        return new GetTransactionHistory();
    }

    /**
     * Create an instance of {@link ReissueCardWithNewSubproductCode }
     *
     */
    public ReissueCardWithNewSubproductCode createReissueCardWithNewSubproductCode() {
        return new ReissueCardWithNewSubproductCode();
    }

    /**
     * Create an instance of {@link AnnulateSalaryCard }
     *
     */
    public AnnulateSalaryCard createAnnulateSalaryCard() {
        return new AnnulateSalaryCard();
    }

    /**
     * Create an instance of {@link CheckCardActivation }
     *
     */
    public CheckCardActivation createCheckCardActivation() {
        return new CheckCardActivation();
    }

    /**
     * Create an instance of {@link GetCardDeliveryStatusByTextResponse }
     *
     */
    public GetCardDeliveryStatusByTextResponse createGetCardDeliveryStatusByTextResponse() {
        return new GetCardDeliveryStatusByTextResponse();
    }

    /**
     * Create an instance of {@link GetCardDeliveryStatusLogResponse }
     *
     */
    public GetCardDeliveryStatusLogResponse createGetCardDeliveryStatusLogResponse() {
        return new GetCardDeliveryStatusLogResponse();
    }

    /**
     * Create an instance of {@link CheckCodeWord }
     *
     */
    public CheckCodeWord createCheckCodeWord() {
        return new CheckCodeWord();
    }

    /**
     * Create an instance of {@link SetNewSubproductByCard }
     *
     */
    public SetNewSubproductByCard createSetNewSubproductByCard() {
        return new SetNewSubproductByCard();
    }

    /**
     * Create an instance of {@link ActivateCardById }
     *
     */
    public ActivateCardById createActivateCardById() {
        return new ActivateCardById();
    }

    /**
     * Create an instance of {@link IdentifyCardResponse }
     *
     */
    public IdentifyCardResponse createIdentifyCardResponse() {
        return new IdentifyCardResponse();
    }

    /**
     * Create an instance of {@link SignEnvelopeResponse }
     *
     */
    public SignEnvelopeResponse createSignEnvelopeResponse() {
        return new SignEnvelopeResponse();
    }

    /**
     * Create an instance of {@link GetStatement }
     *
     */
    public GetStatement createGetStatement() {
        return new GetStatement();
    }

    /**
     * Create an instance of {@link CardInfoList }
     *
     */
    public CardInfoList createCardInfoList() {
        return new CardInfoList();
    }

    /**
     * Create an instance of {@link GetCardInfoByAccountNoResponse }
     *
     */
    public GetCardInfoByAccountNoResponse createGetCardInfoByAccountNoResponse() {
        return new GetCardInfoByAccountNoResponse();
    }

    /**
     * Create an instance of {@link SetCardDealCreditLimit }
     *
     */
    public SetCardDealCreditLimit createSetCardDealCreditLimit() {
        return new SetCardDealCreditLimit();
    }

    /**
     * Create an instance of {@link GetCardDealState }
     *
     */
    public GetCardDealState createGetCardDealState() {
        return new GetCardDealState();
    }

    /**
     * Create an instance of {@link GetSubproductAttributes }
     *
     */
    public GetSubproductAttributes createGetSubproductAttributes() {
        return new GetSubproductAttributes();
    }

    /**
     * Create an instance of {@link GetCardDealsByContragentId }
     *
     */
    public GetCardDealsByContragentId createGetCardDealsByContragentId() {
        return new GetCardDealsByContragentId();
    }

    /**
     * Create an instance of {@link ChangeSubproductCodeResponse }
     *
     */
    public ChangeSubproductCodeResponse createChangeSubproductCodeResponse() {
        return new ChangeSubproductCodeResponse();
    }

    /**
     * Create an instance of {@link ProcessInstallmentResponse }
     *
     */
    public ProcessInstallmentResponse createProcessInstallmentResponse() {
        return new ProcessInstallmentResponse();
    }

    /**
     * Create an instance of {@link AddCardRebinding }
     *
     */
    public AddCardRebinding createAddCardRebinding() {
        return new AddCardRebinding();
    }

    /**
     * Create an instance of {@link GetNewSubproductResponse }
     *
     */
    public GetNewSubproductResponse createGetNewSubproductResponse() {
        return new GetNewSubproductResponse();
    }

    /**
     * Create an instance of {@link GetCurrentNewSubproduct }
     *
     */
    public GetCurrentNewSubproduct createGetCurrentNewSubproduct() {
        return new GetCurrentNewSubproduct();
    }

    /**
     * Create an instance of {@link GetCardDealFeesResponse }
     *
     */
    public GetCardDealFeesResponse createGetCardDealFeesResponse() {
        return new GetCardDealFeesResponse();
    }

    /**
     * Create an instance of {@link GetSalaryCreditTurnoverResponse }
     *
     */
    public GetSalaryCreditTurnoverResponse createGetSalaryCreditTurnoverResponse() {
        return new GetSalaryCreditTurnoverResponse();
    }

    /**
     * Create an instance of {@link GetFinAccBySiebelResponse }
     *
     */
    public GetFinAccBySiebelResponse createGetFinAccBySiebelResponse() {
        return new GetFinAccBySiebelResponse();
    }

    /**
     * Create an instance of {@link GetCardListByDealId }
     *
     */
    public GetCardListByDealId createGetCardListByDealId() {
        return new GetCardListByDealId();
    }

    /**
     * Create an instance of {@link SetDeferredReissueCardStatus }
     *
     */
    public SetDeferredReissueCardStatus createSetDeferredReissueCardStatus() {
        return new SetDeferredReissueCardStatus();
    }

    /**
     * Create an instance of {@link GetReIssueCardsResponse }
     *
     */
    public GetReIssueCardsResponse createGetReIssueCardsResponse() {
        return new GetReIssueCardsResponse();
    }

    /**
     * Create an instance of {@link ChangeDealPhoneNumber }
     *
     */
    public ChangeDealPhoneNumber createChangeDealPhoneNumber() {
        return new ChangeDealPhoneNumber();
    }

    /**
     * Create an instance of {@link CardTransactionList }
     *
     */
    public CardTransactionList createCardTransactionList() {
        return new CardTransactionList();
    }

    /**
     * Create an instance of {@link SetCodeWord }
     *
     */
    public SetCodeWord createSetCodeWord() {
        return new SetCodeWord();
    }

    /**
     * Create an instance of {@link GetCurrentSubproduct }
     *
     */
    public GetCurrentSubproduct createGetCurrentSubproduct() {
        return new GetCurrentSubproduct();
    }

    /**
     * Create an instance of {@link DisableOldCardResponse }
     *
     */
    public DisableOldCardResponse createDisableOldCardResponse() {
        return new DisableOldCardResponse();
    }

    /**
     * Create an instance of {@link GetProjectInfoByAgrtplname }
     *
     */
    public GetProjectInfoByAgrtplname createGetProjectInfoByAgrtplname() {
        return new GetProjectInfoByAgrtplname();
    }

    /**
     * Create an instance of {@link AnnulateSalaryCardResponse }
     *
     */
    public AnnulateSalaryCardResponse createAnnulateSalaryCardResponse() {
        return new AnnulateSalaryCardResponse();
    }

    /**
     * Create an instance of {@link CardAccountBillingReport }
     *
     */
    public CardAccountBillingReport createCardAccountBillingReport() {
        return new CardAccountBillingReport();
    }

    /**
     * Create an instance of {@link GetProjectInfoByProjectIdResponse }
     *
     */
    public GetProjectInfoByProjectIdResponse createGetProjectInfoByProjectIdResponse() {
        return new GetProjectInfoByProjectIdResponse();
    }

    /**
     * Create an instance of {@link RegisterAddCard }
     *
     */
    public RegisterAddCard createRegisterAddCard() {
        return new RegisterAddCard();
    }

    /**
     * Create an instance of {@link GetDBFilesList }
     *
     */
    public GetDBFilesList createGetDBFilesList() {
        return new GetDBFilesList();
    }

    /**
     * Create an instance of {@link SetCardDeliveryAddressResponse }
     *
     */
    public SetCardDeliveryAddressResponse createSetCardDeliveryAddressResponse() {
        return new SetCardDeliveryAddressResponse();
    }

    /**
     * Create an instance of {@link SetCardContractCreditLimitResponse }
     *
     */
    public SetCardContractCreditLimitResponse createSetCardContractCreditLimitResponse() {
        return new SetCardContractCreditLimitResponse();
    }

    /**
     * Create an instance of {@link SignEnvelope }
     *
     */
    public SignEnvelope createSignEnvelope() {
        return new SignEnvelope();
    }

    /**
     * Create an instance of {@link CardAccountOperationList }
     *
     */
    public CardAccountOperationList createCardAccountOperationList() {
        return new CardAccountOperationList();
    }

    /**
     * Create an instance of {@link GetCardDealsByDealNoResponse }
     *
     */
    public GetCardDealsByDealNoResponse createGetCardDealsByDealNoResponse() {
        return new GetCardDealsByDealNoResponse();
    }

    /**
     * Create an instance of {@link ReissueCardWithNewSubproductCodeResponse }
     *
     */
    public ReissueCardWithNewSubproductCodeResponse createReissueCardWithNewSubproductCodeResponse() {
        return new ReissueCardWithNewSubproductCodeResponse();
    }

    /**
     * Create an instance of {@link GetCardDeliveryStatusByText }
     *
     */
    public GetCardDeliveryStatusByText createGetCardDeliveryStatusByText() {
        return new GetCardDeliveryStatusByText();
    }

    /**
     * Create an instance of {@link GetCardTemplate }
     *
     */
    public GetCardTemplate createGetCardTemplate() {
        return new GetCardTemplate();
    }

    /**
     * Create an instance of {@link AccountList }
     *
     */
    public AccountList createAccountList() {
        return new AccountList();
    }

    /**
     * Create an instance of {@link SetCardDeliveryStatusResponse }
     *
     */
    public SetCardDeliveryStatusResponse createSetCardDeliveryStatusResponse() {
        return new SetCardDeliveryStatusResponse();
    }

    /**
     * Create an instance of {@link ProcessInstallmentItem }
     *
     */
    public ProcessInstallmentItem createProcessInstallmentItem() {
        return new ProcessInstallmentItem();
    }

    /**
     * Create an instance of {@link CardTransaction }
     *
     */
    public CardTransaction createCardTransaction() {
        return new CardTransaction();
    }

    /**
     * Create an instance of {@link AccountNumberItem }
     *
     */
    public AccountNumberItem createAccountNumberItem() {
        return new AccountNumberItem();
    }

    /**
     * Create an instance of {@link SetCardDeliveryStatusItem }
     *
     */
    public SetCardDeliveryStatusItem createSetCardDeliveryStatusItem() {
        return new SetCardDeliveryStatusItem();
    }

    /**
     * Create an instance of {@link GetCardInfoShortItem }
     *
     */
    public GetCardInfoShortItem createGetCardInfoShortItem() {
        return new GetCardInfoShortItem();
    }

    /**
     * Create an instance of {@link ChangeDealPhoneNumberItem }
     *
     */
    public ChangeDealPhoneNumberItem createChangeDealPhoneNumberItem() {
        return new ChangeDealPhoneNumberItem();
    }

    /**
     * Create an instance of {@link RepaymentInstallmentItem }
     *
     */
    public RepaymentInstallmentItem createRepaymentInstallmentItem() {
        return new RepaymentInstallmentItem();
    }

    /**
     * Create an instance of {@link GetDNDStatusItem }
     *
     */
    public GetDNDStatusItem createGetDNDStatusItem() {
        return new GetDNDStatusItem();
    }

    /**
     * Create an instance of {@link GetActiveInstallmentsInfoItem }
     *
     */
    public GetActiveInstallmentsInfoItem createGetActiveInstallmentsInfoItem() {
        return new GetActiveInstallmentsInfoItem();
    }

    /**
     * Create an instance of {@link GetCardDeliveryStatusLogItem }
     *
     */
    public GetCardDeliveryStatusLogItem createGetCardDeliveryStatusLogItem() {
        return new GetCardDeliveryStatusLogItem();
    }

    /**
     * Create an instance of {@link SetBarCodeItem }
     *
     */
    public SetBarCodeItem createSetBarCodeItem() {
        return new SetBarCodeItem();
    }

    /**
     * Create an instance of {@link ActivateCardStatus }
     *
     */
    public ActivateCardStatus createActivateCardStatus() {
        return new ActivateCardStatus();
    }

    /**
     * Create an instance of {@link GetCardDeliveryStatusItem }
     *
     */
    public GetCardDeliveryStatusItem createGetCardDeliveryStatusItem() {
        return new GetCardDeliveryStatusItem();
    }

    /**
     * Create an instance of {@link SetDNDStatusItem }
     *
     */
    public SetDNDStatusItem createSetDNDStatusItem() {
        return new SetDNDStatusItem();
    }

    /**
     * Create an instance of {@link GetCardDeliveryBranchesItem }
     *
     */
    public GetCardDeliveryBranchesItem createGetCardDeliveryBranchesItem() {
        return new GetCardDeliveryBranchesItem();
    }

    /**
     * Create an instance of {@link GetFinCorpAccBySiebelItem }
     *
     */
    public GetFinCorpAccBySiebelItem createGetFinCorpAccBySiebelItem() {
        return new GetFinCorpAccBySiebelItem();
    }

    /**
     * Create an instance of {@link SetCardDeliveryAddressItem }
     *
     */
    public SetCardDeliveryAddressItem createSetCardDeliveryAddressItem() {
        return new SetCardDeliveryAddressItem();
    }

    /**
     * Create an instance of {@link GetDeliveryCardByMessageIdItem }
     *
     */
    public GetDeliveryCardByMessageIdItem createGetDeliveryCardByMessageIdItem() {
        return new GetDeliveryCardByMessageIdItem();
    }

    /**
     * Create an instance of {@link CardContragent }
     *
     */
    public CardContragent createCardContragent() {
        return new CardContragent();
    }

    /**
     * Create an instance of {@link ReportLine }
     *
     */
    public ReportLine createReportLine() {
        return new ReportLine();
    }

    /**
     * Create an instance of {@link GetRateYieldSafeItem }
     *
     */
    public GetRateYieldSafeItem createGetRateYieldSafeItem() {
        return new GetRateYieldSafeItem();
    }

    /**
     * Create an instance of {@link RegisterCardDealItem }
     *
     */
    public RegisterCardDealItem createRegisterCardDealItem() {
        return new RegisterCardDealItem();
    }

    /**
     * Create an instance of {@link GetCustomerIDItem }
     *
     */
    public GetCustomerIDItem createGetCustomerIDItem() {
        return new GetCustomerIDItem();
    }

    /**
     * Create an instance of {@link GetIPSItem }
     *
     */
    public GetIPSItem createGetIPSItem() {
        return new GetIPSItem();
    }

    /**
     * Create an instance of {@link CardAccountOperationItem }
     *
     */
    public CardAccountOperationItem createCardAccountOperationItem() {
        return new CardAccountOperationItem();
    }

    /**
     * Create an instance of {@link CardDealInfo }
     *
     */
    public CardDealInfo createCardDealInfo() {
        return new CardDealInfo();
    }

    /**
     * Create an instance of {@link SetInstallmentRepaymentItem }
     *
     */
    public SetInstallmentRepaymentItem createSetInstallmentRepaymentItem() {
        return new SetInstallmentRepaymentItem();
    }

    /**
     * Create an instance of {@link CheckPinChangeItem }
     *
     */
    public CheckPinChangeItem createCheckPinChangeItem() {
        return new CheckPinChangeItem();
    }

    /**
     * Create an instance of {@link GetAvailIdArrayItem }
     *
     */
    public GetAvailIdArrayItem createGetAvailIdArrayItem() {
        return new GetAvailIdArrayItem();
    }

    /**
     * Create an instance of {@link GetCardServiceStatesItem }
     *
     */
    public GetCardServiceStatesItem createGetCardServiceStatesItem() {
        return new GetCardServiceStatesItem();
    }

    /**
     * Create an instance of {@link InsBsnStopAfterEmbItem }
     *
     */
    public InsBsnStopAfterEmbItem createInsBsnStopAfterEmbItem() {
        return new InsBsnStopAfterEmbItem();
    }

    /**
     * Create an instance of {@link ClientRebindingItem }
     *
     */
    public ClientRebindingItem createClientRebindingItem() {
        return new ClientRebindingItem();
    }

    /**
     * Create an instance of {@link GetFinsAppCardBySiebelItem }
     *
     */
    public GetFinsAppCardBySiebelItem createGetFinsAppCardBySiebelItem() {
        return new GetFinsAppCardBySiebelItem();
    }

    /**
     * Create an instance of {@link SetStatementModeItem }
     *
     */
    public SetStatementModeItem createSetStatementModeItem() {
        return new SetStatementModeItem();
    }

    /**
     * Create an instance of {@link GetCardDealInfoByBarCodeItem }
     *
     */
    public GetCardDealInfoByBarCodeItem createGetCardDealInfoByBarCodeItem() {
        return new GetCardDealInfoByBarCodeItem();
    }

    /**
     * Create an instance of {@link SetCodeWordItem }
     *
     */
    public SetCodeWordItem createSetCodeWordItem() {
        return new SetCodeWordItem();
    }

    /**
     * Create an instance of {@link CancelCardDealItem }
     *
     */
    public CancelCardDealItem createCancelCardDealItem() {
        return new CancelCardDealItem();
    }

    /**
     * Create an instance of {@link ChangeBranchCodeItem }
     *
     */
    public ChangeBranchCodeItem createChangeBranchCodeItem() {
        return new ChangeBranchCodeItem();
    }

    /**
     * Create an instance of {@link GetCardDealJurItem }
     *
     */
    public GetCardDealJurItem createGetCardDealJurItem() {
        return new GetCardDealJurItem();
    }

    /**
     * Create an instance of {@link CheckCodeWordItem }
     *
     */
    public CheckCodeWordItem createCheckCodeWordItem() {
        return new CheckCodeWordItem();
    }

    /**
     * Create an instance of {@link CreditLimit }
     *
     */
    public CreditLimit createCreditLimit() {
        return new CreditLimit();
    }

    /**
     * Create an instance of {@link SetDeferredReissueCardStatusItem }
     *
     */
    public SetDeferredReissueCardStatusItem createSetDeferredReissueCardStatusItem() {
        return new SetDeferredReissueCardStatusItem();
    }

    /**
     * Create an instance of {@link FreezeCardAccountItem }
     *
     */
    public FreezeCardAccountItem createFreezeCardAccountItem() {
        return new FreezeCardAccountItem();
    }

    /**
     * Create an instance of {@link GetSalaryCreditTurnoverItem }
     *
     */
    public GetSalaryCreditTurnoverItem createGetSalaryCreditTurnoverItem() {
        return new GetSalaryCreditTurnoverItem();
    }

    /**
     * Create an instance of {@link CardInfo }
     *
     */
    public CardInfo createCardInfo() {
        return new CardInfo();
    }

    /**
     * Create an instance of {@link CheckOpportunityRecreateCardItem }
     *
     */
    public CheckOpportunityRecreateCardItem createCheckOpportunityRecreateCardItem() {
        return new CheckOpportunityRecreateCardItem();
    }

    /**
     * Create an instance of {@link GetAvailableAddCardItem }
     *
     */
    public GetAvailableAddCardItem createGetAvailableAddCardItem() {
        return new GetAvailableAddCardItem();
    }

    /**
     * Create an instance of {@link GetTransactionHistoryItem }
     *
     */
    public GetTransactionHistoryItem createGetTransactionHistoryItem() {
        return new GetTransactionHistoryItem();
    }

    /**
     * Create an instance of {@link CheckTransferItem }
     *
     */
    public CheckTransferItem createCheckTransferItem() {
        return new CheckTransferItem();
    }

    /**
     * Create an instance of {@link AnnulateSalaryCardItem }
     *
     */
    public AnnulateSalaryCardItem createAnnulateSalaryCardItem() {
        return new AnnulateSalaryCardItem();
    }

    /**
     * Create an instance of {@link SignEnvelopeItem }
     *
     */
    public SignEnvelopeItem createSignEnvelopeItem() {
        return new SignEnvelopeItem();
    }

    /**
     * Create an instance of {@link GetReportDeliveryModesItem }
     *
     */
    public GetReportDeliveryModesItem createGetReportDeliveryModesItem() {
        return new GetReportDeliveryModesItem();
    }

    /**
     * Create an instance of {@link GetCardAccountBalanceItem }
     *
     */
    public GetCardAccountBalanceItem createGetCardAccountBalanceItem() {
        return new GetCardAccountBalanceItem();
    }

    /**
     * Create an instance of {@link CardDeal }
     *
     */
    public CardDeal createCardDeal() {
        return new CardDeal();
    }

    /**
     * Create an instance of {@link GetCardInfoByCardIdItem }
     *
     */
    public GetCardInfoByCardIdItem createGetCardInfoByCardIdItem() {
        return new GetCardInfoByCardIdItem();
    }

    /**
     * Create an instance of {@link ActivateCardByIdItem }
     *
     */
    public ActivateCardByIdItem createActivateCardByIdItem() {
        return new ActivateCardByIdItem();
    }

    /**
     * Create an instance of {@link GetUPCSessionUIDItem }
     *
     */
    public GetUPCSessionUIDItem createGetUPCSessionUIDItem() {
        return new GetUPCSessionUIDItem();
    }

    /**
     * Create an instance of {@link GetStatementItem }
     *
     */
    public GetStatementItem createGetStatementItem() {
        return new GetStatementItem();
    }

    /**
     * Create an instance of {@link GetNewSubproductItem }
     *
     */
    public GetNewSubproductItem createGetNewSubproductItem() {
        return new GetNewSubproductItem();
    }

    /**
     * Create an instance of {@link GetFinAccBySiebelItem }
     *
     */
    public GetFinAccBySiebelItem createGetFinAccBySiebelItem() {
        return new GetFinAccBySiebelItem();
    }

    /**
     * Create an instance of {@link ChangeSubproductCodeItem }
     *
     */
    public ChangeSubproductCodeItem createChangeSubproductCodeItem() {
        return new ChangeSubproductCodeItem();
    }

    /**
     * Create an instance of {@link ActivateCardDealItem }
     *
     */
    public ActivateCardDealItem createActivateCardDealItem() {
        return new ActivateCardDealItem();
    }

    /**
     * Create an instance of {@link SetDeferredRenewCardItem }
     *
     */
    public SetDeferredRenewCardItem createSetDeferredRenewCardItem() {
        return new SetDeferredRenewCardItem();
    }

    /**
     * Create an instance of {@link EnableMBankingItem }
     *
     */
    public EnableMBankingItem createEnableMBankingItem() {
        return new EnableMBankingItem();
    }

    /**
     * Create an instance of {@link GetCurrentSubproductItem }
     *
     */
    public GetCurrentSubproductItem createGetCurrentSubproductItem() {
        return new GetCurrentSubproductItem();
    }

    /**
     * Create an instance of {@link RegisterAddCardItem }
     *
     */
    public RegisterAddCardItem createRegisterAddCardItem() {
        return new RegisterAddCardItem();
    }

    /**
     * Create an instance of {@link GetCardDeliveryStatusByTextItem }
     *
     */
    public GetCardDeliveryStatusByTextItem createGetCardDeliveryStatusByTextItem() {
        return new GetCardDeliveryStatusByTextItem();
    }

    /**
     * Create an instance of {@link Card }
     *
     */
    public Card createCard() {
        return new Card();
    }

    /**
     * Create an instance of {@link GetCardDealFeesItem }
     *
     */
    public GetCardDealFeesItem createGetCardDealFeesItem() {
        return new GetCardDealFeesItem();
    }

    /**
     * Create an instance of {@link GetProjectInfoByAgrtplnameItem }
     *
     */
    public GetProjectInfoByAgrtplnameItem createGetProjectInfoByAgrtplnameItem() {
        return new GetProjectInfoByAgrtplnameItem();
    }

    /**
     * Create an instance of {@link GetDBFilesListItem }
     *
     */
    public GetDBFilesListItem createGetDBFilesListItem() {
        return new GetDBFilesListItem();
    }

    /**
     * Create an instance of {@link GetCardInfoByAccountNoItem }
     *
     */
    public GetCardInfoByAccountNoItem createGetCardInfoByAccountNoItem() {
        return new GetCardInfoByAccountNoItem();
    }

    /**
     * Create an instance of {@link GetCurrentNewSubproductItem }
     *
     */
    public GetCurrentNewSubproductItem createGetCurrentNewSubproductItem() {
        return new GetCurrentNewSubproductItem();
    }

    /**
     * Create an instance of {@link RecreateCardItem }
     *
     */
    public RecreateCardItem createRecreateCardItem() {
        return new RecreateCardItem();
    }

    /**
     * Create an instance of {@link DisableMBankingItem }
     *
     */
    public DisableMBankingItem createDisableMBankingItem() {
        return new DisableMBankingItem();
    }

    /**
     * Create an instance of {@link GetSubproductAttributesItem }
     *
     */
    public GetSubproductAttributesItem createGetSubproductAttributesItem() {
        return new GetSubproductAttributesItem();
    }

    /**
     * Create an instance of {@link CheckCardActivationItem }
     *
     */
    public CheckCardActivationItem createCheckCardActivationItem() {
        return new CheckCardActivationItem();
    }

    /**
     * Create an instance of {@link GetAdditionalInstallmentInfoItem }
     *
     */
    public GetAdditionalInstallmentInfoItem createGetAdditionalInstallmentInfoItem() {
        return new GetAdditionalInstallmentInfoItem();
    }

    /**
     * Create an instance of {@link GetReIssueCardsItem }
     *
     */
    public GetReIssueCardsItem createGetReIssueCardsItem() {
        return new GetReIssueCardsItem();
    }

    /**
     * Create an instance of {@link GetBalanceInIcItem }
     *
     */
    public GetBalanceInIcItem createGetBalanceInIcItem() {
        return new GetBalanceInIcItem();
    }

    /**
     * Create an instance of {@link GetCardDailyLimitsItem }
     *
     */
    public GetCardDailyLimitsItem createGetCardDailyLimitsItem() {
        return new GetCardDailyLimitsItem();
    }

    /**
     * Create an instance of {@link UpdateDBFileFlagItem }
     *
     */
    public UpdateDBFileFlagItem createUpdateDBFileFlagItem() {
        return new UpdateDBFileFlagItem();
    }

    /**
     * Create an instance of {@link GetCardsByContragentIdItem }
     *
     */
    public GetCardsByContragentIdItem createGetCardsByContragentIdItem() {
        return new GetCardsByContragentIdItem();
    }

    /**
     * Create an instance of {@link CardDealState }
     *
     */
    public CardDealState createCardDealState() {
        return new CardDealState();
    }

    /**
     * Create an instance of {@link CardId }
     *
     */
    public CardId createCardId() {
        return new CardId();
    }

    /**
     * Create an instance of {@link CheckInstallmentAvailabilityItem }
     *
     */
    public CheckInstallmentAvailabilityItem createCheckInstallmentAvailabilityItem() {
        return new CheckInstallmentAvailabilityItem();
    }

    /**
     * Create an instance of {@link RemoveCardDealItem }
     *
     */
    public RemoveCardDealItem createRemoveCardDealItem() {
        return new RemoveCardDealItem();
    }

    /**
     * Create an instance of {@link SetUpSellNotReissuingItem }
     *
     */
    public SetUpSellNotReissuingItem createSetUpSellNotReissuingItem() {
        return new SetUpSellNotReissuingItem();
    }

    /**
     * Create an instance of {@link GetSubproductCodesByAtrributeItem }
     *
     */
    public GetSubproductCodesByAtrributeItem createGetSubproductCodesByAtrributeItem() {
        return new GetSubproductCodesByAtrributeItem();
    }

    /**
     * Create an instance of {@link GetCardTemplateItem }
     *
     */
    public GetCardTemplateItem createGetCardTemplateItem() {
        return new GetCardTemplateItem();
    }

    /**
     * Create an instance of {@link GetInstallmentProductItem }
     *
     */
    public GetInstallmentProductItem createGetInstallmentProductItem() {
        return new GetInstallmentProductItem();
    }

    /**
     * Create an instance of {@link GetCardInfoItem }
     *
     */
    public GetCardInfoItem createGetCardInfoItem() {
        return new GetCardInfoItem();
    }

    /**
     * Create an instance of {@link SetNewSubproductByCardItem }
     *
     */
    public SetNewSubproductByCardItem createSetNewSubproductByCardItem() {
        return new SetNewSubproductByCardItem();
    }

    /**
     * Create an instance of {@link AddCardRebindingItem }
     *
     */
    public AddCardRebindingItem createAddCardRebindingItem() {
        return new AddCardRebindingItem();
    }

    /**
     * Create an instance of {@link GetExtClientPrivIdItem }
     *
     */
    public GetExtClientPrivIdItem createGetExtClientPrivIdItem() {
        return new GetExtClientPrivIdItem();
    }

    /**
     * Create an instance of {@link GetCardManufacturersItem }
     *
     */
    public GetCardManufacturersItem createGetCardManufacturersItem() {
        return new GetCardManufacturersItem();
    }

    /**
     * Create an instance of {@link GetProjectInfoByProjectIdItem }
     *
     */
    public GetProjectInfoByProjectIdItem createGetProjectInfoByProjectIdItem() {
        return new GetProjectInfoByProjectIdItem();
    }

    /**
     * Create an instance of {@link DisableOldCardItem }
     *
     */
    public DisableOldCardItem createDisableOldCardItem() {
        return new DisableOldCardItem();
    }

    /**
     * Create an instance of {@link SetCardDailyLimitsItem }
     *
     */
    public SetCardDailyLimitsItem createSetCardDailyLimitsItem() {
        return new SetCardDailyLimitsItem();
    }

    /**
     * Create an instance of {@link SetCardStopListItem }
     *
     */
    public SetCardStopListItem createSetCardStopListItem() {
        return new SetCardStopListItem();
    }

    /**
     * Create an instance of {@link ReissueCardWithNewSubproductCodeItem }
     *
     */
    public ReissueCardWithNewSubproductCodeItem createReissueCardWithNewSubproductCodeItem() {
        return new ReissueCardWithNewSubproductCodeItem();
    }

    /**
     * Create an instance of {@link GetCVV2FlagItem }
     *
     */
    public GetCVV2FlagItem createGetCVV2FlagItem() {
        return new GetCVV2FlagItem();
    }

    /**
     * Create an instance of {@link GetCardDeliveryBranchItem }
     *
     */
    public GetCardDeliveryBranchItem createGetCardDeliveryBranchItem() {
        return new GetCardDeliveryBranchItem();
    }

    /**
     * Create an instance of {@link GetStatusMonitoringTransactionsItem }
     *
     */
    public GetStatusMonitoringTransactionsItem createGetStatusMonitoringTransactionsItem() {
        return new GetStatusMonitoringTransactionsItem();
    }

    /**
     * Create an instance of {@link GetActualBalanceByCardItem }
     *
     */
    public GetActualBalanceByCardItem createGetActualBalanceByCardItem() {
        return new GetActualBalanceByCardItem();
    }

    /**
     * Create an instance of {@link CardDeal3 }
     *
     */
    public CardDeal3 createCardDeal3() {
        return new CardDeal3();
    }

    /**
     * Create an instance of {@link CardDeal2 }
     *
     */
    public CardDeal2 createCardDeal2() {
        return new CardDeal2();
    }

    /**
     * Create an instance of {@link CheckAlfaChoiseEnableItem }
     *
     */
    public CheckAlfaChoiseEnableItem createCheckAlfaChoiseEnableItem() {
        return new CheckAlfaChoiseEnableItem();
    }

    /**
     * Create an instance of {@link CardDeal5 }
     *
     */
    public CardDeal5 createCardDeal5() {
        return new CardDeal5();
    }

    /**
     * Create an instance of {@link CardDeal4 }
     *
     */
    public CardDeal4 createCardDeal4() {
        return new CardDeal4();
    }

    /**
     * Create an instance of {@link CardDeal7 }
     *
     */
    public CardDeal7 createCardDeal7() {
        return new CardDeal7();
    }

    /**
     * Create an instance of {@link CardDeal6 }
     *
     */
    public CardDeal6 createCardDeal6() {
        return new CardDeal6();
    }

    /**
     * Create an instance of {@link ChangeStatusMonitoringTransactionsItem }
     *
     */
    public ChangeStatusMonitoringTransactionsItem createChangeStatusMonitoringTransactionsItem() {
        return new ChangeStatusMonitoringTransactionsItem();
    }

    /**
     * Create an instance of {@link Account }
     *
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCardStopListResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "setCardStopListResponse")
    public JAXBElement<SetCardStopListResponse> createSetCardStopListResponse(SetCardStopListResponse value) {
        return new JAXBElement<SetCardStopListResponse>(_SetCardStopListResponse_QNAME, SetCardStopListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDNDStatusResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getDNDStatusResponse")
    public JAXBElement<GetDNDStatusResponse> createGetDNDStatusResponse(GetDNDStatusResponse value) {
        return new JAXBElement<GetDNDStatusResponse>(_GetDNDStatusResponse_QNAME, GetDNDStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomerIDResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCustomerIDResponse")
    public JAXBElement<GetCustomerIDResponse> createGetCustomerIDResponse(GetCustomerIDResponse value) {
        return new JAXBElement<GetCustomerIDResponse>(_GetCustomerIDResponse_QNAME, GetCustomerIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetDNDStatusResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "setDNDStatusResponse")
    public JAXBElement<SetDNDStatusResponse> createSetDNDStatusResponse(SetDNDStatusResponse value) {
        return new JAXBElement<SetDNDStatusResponse>(_SetDNDStatusResponse_QNAME, SetDNDStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentNewSubproductResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCurrentNewSubproductResponse")
    public JAXBElement<GetCurrentNewSubproductResponse> createGetCurrentNewSubproductResponse(GetCurrentNewSubproductResponse value) {
        return new JAXBElement<GetCurrentNewSubproductResponse>(_GetCurrentNewSubproductResponse_QNAME, GetCurrentNewSubproductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetInstallmentRepaymentResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "setInstallmentRepaymentResponse")
    public JAXBElement<SetInstallmentRepaymentResponse> createSetInstallmentRepaymentResponse(SetInstallmentRepaymentResponse value) {
        return new JAXBElement<SetInstallmentRepaymentResponse>(_SetInstallmentRepaymentResponse_QNAME, SetInstallmentRepaymentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardDeliveryBranchesResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardDeliveryBranchesResponse")
    public JAXBElement<GetCardDeliveryBranchesResponse> createGetCardDeliveryBranchesResponse(GetCardDeliveryBranchesResponse value) {
        return new JAXBElement<GetCardDeliveryBranchesResponse>(_GetCardDeliveryBranchesResponse_QNAME, GetCardDeliveryBranchesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardInfoShortResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardInfoShortResponse")
    public JAXBElement<GetCardInfoShortResponse> createGetCardInfoShortResponse(GetCardInfoShortResponse value) {
        return new JAXBElement<GetCardInfoShortResponse>(_GetCardInfoShortResponse_QNAME, GetCardInfoShortResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterCardContragentResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "registerCardContragentResponse")
    public JAXBElement<RegisterCardContragentResponse> createRegisterCardContragentResponse(RegisterCardContragentResponse value) {
        return new JAXBElement<RegisterCardContragentResponse>(_RegisterCardContragentResponse_QNAME, RegisterCardContragentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardDealInfoList }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardDealInfoList")
    public JAXBElement<CardDealInfoList> createCardDealInfoList(CardDealInfoList value) {
        return new JAXBElement<CardDealInfoList>(_CardDealInfoList_QNAME, CardDealInfoList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUPCSessionUIDResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getUPCSessionUIDResponse")
    public JAXBElement<GetUPCSessionUIDResponse> createGetUPCSessionUIDResponse(GetUPCSessionUIDResponse value) {
        return new JAXBElement<GetUPCSessionUIDResponse>(_GetUPCSessionUIDResponse_QNAME, GetUPCSessionUIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardDeliveryStatusResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardDeliveryStatusResponse")
    public JAXBElement<GetCardDeliveryStatusResponse> createGetCardDeliveryStatusResponse(GetCardDeliveryStatusResponse value) {
        return new JAXBElement<GetCardDeliveryStatusResponse>(_GetCardDeliveryStatusResponse_QNAME, GetCardDeliveryStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardAccountBalanceResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardAccountBalanceResponse")
    public JAXBElement<GetCardAccountBalanceResponse> createGetCardAccountBalanceResponse(GetCardAccountBalanceResponse value) {
        return new JAXBElement<GetCardAccountBalanceResponse>(_GetCardAccountBalanceResponse_QNAME, GetCardAccountBalanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExtClientPrivIdResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getExtClientPrivIdResponse")
    public JAXBElement<GetExtClientPrivIdResponse> createGetExtClientPrivIdResponse(GetExtClientPrivIdResponse value) {
        return new JAXBElement<GetExtClientPrivIdResponse>(_GetExtClientPrivIdResponse_QNAME, GetExtClientPrivIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FreezeCardAccountResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "freezeCardAccountResponse")
    public JAXBElement<FreezeCardAccountResponse> createFreezeCardAccountResponse(FreezeCardAccountResponse value) {
        return new JAXBElement<FreezeCardAccountResponse>(_FreezeCardAccountResponse_QNAME, FreezeCardAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckTransferResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "checkTransferResponse")
    public JAXBElement<CheckTransferResponse> createCheckTransferResponse(CheckTransferResponse value) {
        return new JAXBElement<CheckTransferResponse>(_CheckTransferResponse_QNAME, CheckTransferResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatusMonitoringTransactionsResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getStatusMonitoringTransactionsResponse")
    public JAXBElement<GetStatusMonitoringTransactionsResponse> createGetStatusMonitoringTransactionsResponse(GetStatusMonitoringTransactionsResponse value) {
        return new JAXBElement<GetStatusMonitoringTransactionsResponse>(_GetStatusMonitoringTransactionsResponse_QNAME, GetStatusMonitoringTransactionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeStatusMonitoringTransactionsResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "changeStatusMonitoringTransactionsResponse")
    public JAXBElement<ChangeStatusMonitoringTransactionsResponse> createChangeStatusMonitoringTransactionsResponse(ChangeStatusMonitoringTransactionsResponse value) {
        return new JAXBElement<ChangeStatusMonitoringTransactionsResponse>(_ChangeStatusMonitoringTransactionsResponse_QNAME, ChangeStatusMonitoringTransactionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ID }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "ID")
    public JAXBElement<ID> createID(ID value) {
        return new JAXBElement<ID>(_ID_QNAME, ID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterCardDealResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "registerCardDealResponse")
    public JAXBElement<RegisterCardDealResponse> createRegisterCardDealResponse(RegisterCardDealResponse value) {
        return new JAXBElement<RegisterCardDealResponse>(_RegisterCardDealResponse_QNAME, RegisterCardDealResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCVV2FlagResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCVV2FlagResponse")
    public JAXBElement<GetCVV2FlagResponse> createGetCVV2FlagResponse(GetCVV2FlagResponse value) {
        return new JAXBElement<GetCVV2FlagResponse>(_GetCVV2FlagResponse_QNAME, GetCVV2FlagResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAdditionalInstallmentInfoResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getAdditionalInstallmentInfoResponse")
    public JAXBElement<GetAdditionalInstallmentInfoResponse> createGetAdditionalInstallmentInfoResponse(GetAdditionalInstallmentInfoResponse value) {
        return new JAXBElement<GetAdditionalInstallmentInfoResponse>(_GetAdditionalInstallmentInfoResponse_QNAME, GetAdditionalInstallmentInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardDealsByTaxIdResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardDealsByTaxIdResponse")
    public JAXBElement<GetCardDealsByTaxIdResponse> createGetCardDealsByTaxIdResponse(GetCardDealsByTaxIdResponse value) {
        return new JAXBElement<GetCardDealsByTaxIdResponse>(_GetCardDealsByTaxIdResponse_QNAME, GetCardDealsByTaxIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://ws.wso2.org/dataservice", name = "REQUEST_STATUS")
    public JAXBElement<String> createREQUESTSTATUS(String value) {
        return new JAXBElement<String>(_REQUESTSTATUS_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckOpportunityRecreateCardResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "checkOpportunityRecreateCardResponse")
    public JAXBElement<CheckOpportunityRecreateCardResponse> createCheckOpportunityRecreateCardResponse(CheckOpportunityRecreateCardResponse value) {
        return new JAXBElement<CheckOpportunityRecreateCardResponse>(_CheckOpportunityRecreateCardResponse_QNAME, CheckOpportunityRecreateCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBalanceInIcResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getBalanceInIcResponse")
    public JAXBElement<GetBalanceInIcResponse> createGetBalanceInIcResponse(GetBalanceInIcResponse value) {
        return new JAXBElement<GetBalanceInIcResponse>(_GetBalanceInIcResponse_QNAME, GetBalanceInIcResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsBsnStopAfterEmbResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "insBsnStopAfterEmbResponse")
    public JAXBElement<InsBsnStopAfterEmbResponse> createInsBsnStopAfterEmbResponse(InsBsnStopAfterEmbResponse value) {
        return new JAXBElement<InsBsnStopAfterEmbResponse>(_InsBsnStopAfterEmbResponse_QNAME, InsBsnStopAfterEmbResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActualBalanceByCardResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getActualBalanceByCardResponse")
    public JAXBElement<GetActualBalanceByCardResponse> createGetActualBalanceByCardResponse(GetActualBalanceByCardResponse value) {
        return new JAXBElement<GetActualBalanceByCardResponse>(_GetActualBalanceByCardResponse_QNAME, GetActualBalanceByCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetUpSellNotReissuingResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "setUpSellNotReissuingResponse")
    public JAXBElement<SetUpSellNotReissuingResponse> createSetUpSellNotReissuingResponse(SetUpSellNotReissuingResponse value) {
        return new JAXBElement<SetUpSellNotReissuingResponse>(_SetUpSellNotReissuingResponse_QNAME, SetUpSellNotReissuingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIPSResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getIPSResponse")
    public JAXBElement<GetIPSResponse> createGetIPSResponse(GetIPSResponse value) {
        return new JAXBElement<GetIPSResponse>(_GetIPSResponse_QNAME, GetIPSResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubproductAttributesResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getSubproductAttributesResponse")
    public JAXBElement<GetSubproductAttributesResponse> createGetSubproductAttributesResponse(GetSubproductAttributesResponse value) {
        return new JAXBElement<GetSubproductAttributesResponse>(_GetSubproductAttributesResponse_QNAME, GetSubproductAttributesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardInfoResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardInfoResponse")
    public JAXBElement<GetCardInfoResponse> createGetCardInfoResponse(GetCardInfoResponse value) {
        return new JAXBElement<GetCardInfoResponse>(_GetCardInfoResponse_QNAME, GetCardInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActiveInstallmentsInfoResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getActiveInstallmentsInfoResponse")
    public JAXBElement<GetActiveInstallmentsInfoResponse> createGetActiveInstallmentsInfoResponse(GetActiveInstallmentsInfoResponse value) {
        return new JAXBElement<GetActiveInstallmentsInfoResponse>(_GetActiveInstallmentsInfoResponse_QNAME, GetActiveInstallmentsInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFinCorpAccBySiebelResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getFinCorpAccBySiebelResponse")
    public JAXBElement<GetFinCorpAccBySiebelResponse> createGetFinCorpAccBySiebelResponse(GetFinCorpAccBySiebelResponse value) {
        return new JAXBElement<GetFinCorpAccBySiebelResponse>(_GetFinCorpAccBySiebelResponse_QNAME, GetFinCorpAccBySiebelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivateCardStatuses }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "activateCardStatuses")
    public JAXBElement<ActivateCardStatuses> createActivateCardStatuses(ActivateCardStatuses value) {
        return new JAXBElement<ActivateCardStatuses>(_ActivateCardStatuses_QNAME, ActivateCardStatuses.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetStatementModeResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "setStatementModeResponse")
    public JAXBElement<SetStatementModeResponse> createSetStatementModeResponse(SetStatementModeResponse value) {
        return new JAXBElement<SetStatementModeResponse>(_SetStatementModeResponse_QNAME, SetStatementModeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReportDeliveryModesResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getReportDeliveryModesResponse")
    public JAXBElement<GetReportDeliveryModesResponse> createGetReportDeliveryModesResponse(GetReportDeliveryModesResponse value) {
        return new JAXBElement<GetReportDeliveryModesResponse>(_GetReportDeliveryModesResponse_QNAME, GetReportDeliveryModesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFinsAppCardBySiebelResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getFinsAppCardBySiebelResponse")
    public JAXBElement<GetFinsAppCardBySiebelResponse> createGetFinsAppCardBySiebelResponse(GetFinsAppCardBySiebelResponse value) {
        return new JAXBElement<GetFinsAppCardBySiebelResponse>(_GetFinsAppCardBySiebelResponse_QNAME, GetFinsAppCardBySiebelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCardRebindingResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "addCardRebindingResponse")
    public JAXBElement<AddCardRebindingResponse> createAddCardRebindingResponse(AddCardRebindingResponse value) {
        return new JAXBElement<AddCardRebindingResponse>(_AddCardRebindingResponse_QNAME, AddCardRebindingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInstallmentProductResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getInstallmentProductResponse")
    public JAXBElement<GetInstallmentProductResponse> createGetInstallmentProductResponse(GetInstallmentProductResponse value) {
        return new JAXBElement<GetInstallmentProductResponse>(_GetInstallmentProductResponse_QNAME, GetInstallmentProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardTemplateResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardTemplateResponse")
    public JAXBElement<GetCardTemplateResponse> createGetCardTemplateResponse(GetCardTemplateResponse value) {
        return new JAXBElement<GetCardTemplateResponse>(_GetCardTemplateResponse_QNAME, GetCardTemplateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecreateCardResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "recreateCardResponse")
    public JAXBElement<RecreateCardResponse> createRecreateCardResponse(RecreateCardResponse value) {
        return new JAXBElement<RecreateCardResponse>(_RecreateCardResponse_QNAME, RecreateCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardDealJurResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardDealJurResponse")
    public JAXBElement<GetCardDealJurResponse> createGetCardDealJurResponse(GetCardDealJurResponse value) {
        return new JAXBElement<GetCardDealJurResponse>(_GetCardDealJurResponse_QNAME, GetCardDealJurResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvailableAddCardResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getAvailableAddCardResponse")
    public JAXBElement<GetAvailableAddCardResponse> createGetAvailableAddCardResponse(GetAvailableAddCardResponse value) {
        return new JAXBElement<GetAvailableAddCardResponse>(_GetAvailableAddCardResponse_QNAME, GetAvailableAddCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardDealsByContragentIdResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardDealsByContragentIdResponse")
    public JAXBElement<GetCardDealsByContragentIdResponse> createGetCardDealsByContragentIdResponse(GetCardDealsByContragentIdResponse value) {
        return new JAXBElement<GetCardDealsByContragentIdResponse>(_GetCardDealsByContragentIdResponse_QNAME, GetCardDealsByContragentIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckPinChangeResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "checkPinChangeResponse")
    public JAXBElement<CheckPinChangeResponse> createCheckPinChangeResponse(CheckPinChangeResponse value) {
        return new JAXBElement<CheckPinChangeResponse>(_CheckPinChangeResponse_QNAME, CheckPinChangeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardsByContragentIdResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardsByContragentIdResponse")
    public JAXBElement<GetCardsByContragentIdResponse> createGetCardsByContragentIdResponse(GetCardsByContragentIdResponse value) {
        return new JAXBElement<GetCardsByContragentIdResponse>(_GetCardsByContragentIdResponse_QNAME, GetCardsByContragentIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCardDailyLimitsResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "setCardDailyLimitsResponse")
    public JAXBElement<SetCardDailyLimitsResponse> createSetCardDailyLimitsResponse(SetCardDailyLimitsResponse value) {
        return new JAXBElement<SetCardDailyLimitsResponse>(_SetCardDailyLimitsResponse_QNAME, SetCardDailyLimitsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentSubproductResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCurrentSubproductResponse")
    public JAXBElement<GetCurrentSubproductResponse> createGetCurrentSubproductResponse(GetCurrentSubproductResponse value) {
        return new JAXBElement<GetCurrentSubproductResponse>(_GetCurrentSubproductResponse_QNAME, GetCurrentSubproductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubproductCodesByAtrributeResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getSubproductCodesByAtrributeResponse")
    public JAXBElement<GetSubproductCodesByAtrributeResponse> createGetSubproductCodesByAtrributeResponse(GetSubproductCodesByAtrributeResponse value) {
        return new JAXBElement<GetSubproductCodesByAtrributeResponse>(_GetSubproductCodesByAtrributeResponse_QNAME, GetSubproductCodesByAtrributeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetNewSubproductByCardResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "setNewSubproductByCardResponse")
    public JAXBElement<SetNewSubproductByCardResponse> createSetNewSubproductByCardResponse(SetNewSubproductByCardResponse value) {
        return new JAXBElement<SetNewSubproductByCardResponse>(_SetNewSubproductByCardResponse_QNAME, SetNewSubproductByCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardDeliveryBranchResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardDeliveryBranchResponse")
    public JAXBElement<GetCardDeliveryBranchResponse> createGetCardDeliveryBranchResponse(GetCardDeliveryBranchResponse value) {
        return new JAXBElement<GetCardDeliveryBranchResponse>(_GetCardDeliveryBranchResponse_QNAME, GetCardDeliveryBranchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProjectInfoByAgrtplnameResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getProjectInfoByAgrtplnameResponse")
    public JAXBElement<GetProjectInfoByAgrtplnameResponse> createGetProjectInfoByAgrtplnameResponse(GetProjectInfoByAgrtplnameResponse value) {
        return new JAXBElement<GetProjectInfoByAgrtplnameResponse>(_GetProjectInfoByAgrtplnameResponse_QNAME, GetProjectInfoByAgrtplnameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientRebindingResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "clientRebindingResponse")
    public JAXBElement<ClientRebindingResponse> createClientRebindingResponse(ClientRebindingResponse value) {
        return new JAXBElement<ClientRebindingResponse>(_ClientRebindingResponse_QNAME, ClientRebindingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivateCardDealResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "activateCardDealResponse")
    public JAXBElement<ActivateCardDealResponse> createActivateCardDealResponse(ActivateCardDealResponse value) {
        return new JAXBElement<ActivateCardDealResponse>(_ActivateCardDealResponse_QNAME, ActivateCardDealResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCardDealResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "removeCardDealResponse")
    public JAXBElement<RemoveCardDealResponse> createRemoveCardDealResponse(RemoveCardDealResponse value) {
        return new JAXBElement<RemoveCardDealResponse>(_RemoveCardDealResponse_QNAME, RemoveCardDealResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRateYieldSafeResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getRateYieldSafeResponse")
    public JAXBElement<GetRateYieldSafeResponse> createGetRateYieldSafeResponse(GetRateYieldSafeResponse value) {
        return new JAXBElement<GetRateYieldSafeResponse>(_GetRateYieldSafeResponse_QNAME, GetRateYieldSafeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardServiceStatesResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardServiceStatesResponse")
    public JAXBElement<GetCardServiceStatesResponse> createGetCardServiceStatesResponse(GetCardServiceStatesResponse value) {
        return new JAXBElement<GetCardServiceStatesResponse>(_GetCardServiceStatesResponse_QNAME, GetCardServiceStatesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateDBFileFlagResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "updateDBFileFlagResponse")
    public JAXBElement<UpdateDBFileFlagResponse> createUpdateDBFileFlagResponse(UpdateDBFileFlagResponse value) {
        return new JAXBElement<UpdateDBFileFlagResponse>(_UpdateDBFileFlagResponse_QNAME, UpdateDBFileFlagResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCodeWordResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "setCodeWordResponse")
    public JAXBElement<SetCodeWordResponse> createSetCodeWordResponse(SetCodeWordResponse value) {
        return new JAXBElement<SetCodeWordResponse>(_SetCodeWordResponse_QNAME, SetCodeWordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardDailyLimitsResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardDailyLimitsResponse")
    public JAXBElement<GetCardDailyLimitsResponse> createGetCardDailyLimitsResponse(GetCardDailyLimitsResponse value) {
        return new JAXBElement<GetCardDailyLimitsResponse>(_GetCardDailyLimitsResponse_QNAME, GetCardDailyLimitsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardList }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardList")
    public JAXBElement<CardList> createCardList(CardList value) {
        return new JAXBElement<CardList>(_CardList_QNAME, CardList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivateCardByIdResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "activateCardByIdResponse")
    public JAXBElement<ActivateCardByIdResponse> createActivateCardByIdResponse(ActivateCardByIdResponse value) {
        return new JAXBElement<ActivateCardByIdResponse>(_ActivateCardByIdResponse_QNAME, ActivateCardByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNewSubproductResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getNewSubproductResponse")
    public JAXBElement<GetNewSubproductResponse> createGetNewSubproductResponse(GetNewSubproductResponse value) {
        return new JAXBElement<GetNewSubproductResponse>(_GetNewSubproductResponse_QNAME, GetNewSubproductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardDealFeesResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardDealFeesResponse")
    public JAXBElement<GetCardDealFeesResponse> createGetCardDealFeesResponse(GetCardDealFeesResponse value) {
        return new JAXBElement<GetCardDealFeesResponse>(_GetCardDealFeesResponse_QNAME, GetCardDealFeesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetDeferredRenewCardResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "setDeferredRenewCardResponse")
    public JAXBElement<SetDeferredRenewCardResponse> createSetDeferredRenewCardResponse(SetDeferredRenewCardResponse value) {
        return new JAXBElement<SetDeferredRenewCardResponse>(_SetDeferredRenewCardResponse_QNAME, SetDeferredRenewCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSalaryCreditTurnoverResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getSalaryCreditTurnoverResponse")
    public JAXBElement<GetSalaryCreditTurnoverResponse> createGetSalaryCreditTurnoverResponse(GetSalaryCreditTurnoverResponse value) {
        return new JAXBElement<GetSalaryCreditTurnoverResponse>(_GetSalaryCreditTurnoverResponse_QNAME, GetSalaryCreditTurnoverResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetBarCodeResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "setBarCodeResponse")
    public JAXBElement<SetBarCodeResponse> createSetBarCodeResponse(SetBarCodeResponse value) {
        return new JAXBElement<SetBarCodeResponse>(_SetBarCodeResponse_QNAME, SetBarCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardInfoList }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardInfoList")
    public JAXBElement<CardInfoList> createCardInfoList(CardInfoList value) {
        return new JAXBElement<CardInfoList>(_CardInfoList_QNAME, CardInfoList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RepaymentInstallmentResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "repaymentInstallmentResponse")
    public JAXBElement<RepaymentInstallmentResponse> createRepaymentInstallmentResponse(RepaymentInstallmentResponse value) {
        return new JAXBElement<RepaymentInstallmentResponse>(_RepaymentInstallmentResponse_QNAME, RepaymentInstallmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardInfoByAccountNoResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardInfoByAccountNoResponse")
    public JAXBElement<GetCardInfoByAccountNoResponse> createGetCardInfoByAccountNoResponse(GetCardInfoByAccountNoResponse value) {
        return new JAXBElement<GetCardInfoByAccountNoResponse>(_GetCardInfoByAccountNoResponse_QNAME, GetCardInfoByAccountNoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckCardActivationResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "checkCardActivationResponse")
    public JAXBElement<CheckCardActivationResponse> createCheckCardActivationResponse(CheckCardActivationResponse value) {
        return new JAXBElement<CheckCardActivationResponse>(_CheckCardActivationResponse_QNAME, CheckCardActivationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvailIdArrayResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getAvailIdArrayResponse")
    public JAXBElement<GetAvailIdArrayResponse> createGetAvailIdArrayResponse(GetAvailIdArrayResponse value) {
        return new JAXBElement<GetAvailIdArrayResponse>(_GetAvailIdArrayResponse_QNAME, GetAvailIdArrayResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardDealByDealIdResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardDealByDealIdResponse")
    public JAXBElement<GetCardDealByDealIdResponse> createGetCardDealByDealIdResponse(GetCardDealByDealIdResponse value) {
        return new JAXBElement<GetCardDealByDealIdResponse>(_GetCardDealByDealIdResponse_QNAME, GetCardDealByDealIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessInstallmentResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "processInstallmentResponse")
    public JAXBElement<ProcessInstallmentResponse> createProcessInstallmentResponse(ProcessInstallmentResponse value) {
        return new JAXBElement<ProcessInstallmentResponse>(_ProcessInstallmentResponse_QNAME, ProcessInstallmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeSubproductCodeResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "changeSubproductCodeResponse")
    public JAXBElement<ChangeSubproductCodeResponse> createChangeSubproductCodeResponse(ChangeSubproductCodeResponse value) {
        return new JAXBElement<ChangeSubproductCodeResponse>(_ChangeSubproductCodeResponse_QNAME, ChangeSubproductCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckCodeWordResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "checkCodeWordResponse")
    public JAXBElement<CheckCodeWordResponse> createCheckCodeWordResponse(CheckCodeWordResponse value) {
        return new JAXBElement<CheckCodeWordResponse>(_CheckCodeWordResponse_QNAME, CheckCodeWordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifyCardResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "identifyCardResponse")
    public JAXBElement<IdentifyCardResponse> createIdentifyCardResponse(IdentifyCardResponse value) {
        return new JAXBElement<IdentifyCardResponse>(_IdentifyCardResponse_QNAME, IdentifyCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignEnvelopeResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "signEnvelopeResponse")
    public JAXBElement<SignEnvelopeResponse> createSignEnvelopeResponse(SignEnvelopeResponse value) {
        return new JAXBElement<SignEnvelopeResponse>(_SignEnvelopeResponse_QNAME, SignEnvelopeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDeliveryCardByMessageIdResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getDeliveryCardByMessageIdResponse")
    public JAXBElement<GetDeliveryCardByMessageIdResponse> createGetDeliveryCardByMessageIdResponse(GetDeliveryCardByMessageIdResponse value) {
        return new JAXBElement<GetDeliveryCardByMessageIdResponse>(_GetDeliveryCardByMessageIdResponse_QNAME, GetDeliveryCardByMessageIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardDealByCardNumberResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardDealByCardNumberResponse")
    public JAXBElement<GetCardDealByCardNumberResponse> createGetCardDealByCardNumberResponse(GetCardDealByCardNumberResponse value) {
        return new JAXBElement<GetCardDealByCardNumberResponse>(_GetCardDealByCardNumberResponse_QNAME, GetCardDealByCardNumberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterAddCardResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "registerAddCardResponse")
    public JAXBElement<RegisterAddCardResponse> createRegisterAddCardResponse(RegisterAddCardResponse value) {
        return new JAXBElement<RegisterAddCardResponse>(_RegisterAddCardResponse_QNAME, RegisterAddCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetDeferredReissueCardStatusResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "setDeferredReissueCardStatusResponse")
    public JAXBElement<SetDeferredReissueCardStatusResponse> createSetDeferredReissueCardStatusResponse(SetDeferredReissueCardStatusResponse value) {
        return new JAXBElement<SetDeferredReissueCardStatusResponse>(_SetDeferredReissueCardStatusResponse_QNAME, SetDeferredReissueCardStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardDeliveryStatusLogResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardDeliveryStatusLogResponse")
    public JAXBElement<GetCardDeliveryStatusLogResponse> createGetCardDeliveryStatusLogResponse(GetCardDeliveryStatusLogResponse value) {
        return new JAXBElement<GetCardDeliveryStatusLogResponse>(_GetCardDeliveryStatusLogResponse_QNAME, GetCardDeliveryStatusLogResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDBFilesListResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getDBFilesListResponse")
    public JAXBElement<GetDBFilesListResponse> createGetDBFilesListResponse(GetDBFilesListResponse value) {
        return new JAXBElement<GetDBFilesListResponse>(_GetDBFilesListResponse_QNAME, GetDBFilesListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardDeliveryStatusByTextResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardDeliveryStatusByTextResponse")
    public JAXBElement<GetCardDeliveryStatusByTextResponse> createGetCardDeliveryStatusByTextResponse(GetCardDeliveryStatusByTextResponse value) {
        return new JAXBElement<GetCardDeliveryStatusByTextResponse>(_GetCardDeliveryStatusByTextResponse_QNAME, GetCardDeliveryStatusByTextResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountInfoByCardNumberResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getAccountInfoByCardNumberResponse")
    public JAXBElement<GetAccountInfoByCardNumberResponse> createGetAccountInfoByCardNumberResponse(GetAccountInfoByCardNumberResponse value) {
        return new JAXBElement<GetAccountInfoByCardNumberResponse>(_GetAccountInfoByCardNumberResponse_QNAME, GetAccountInfoByCardNumberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardDealInfoByBarCodeResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardDealInfoByBarCodeResponse")
    public JAXBElement<GetCardDealInfoByBarCodeResponse> createGetCardDealInfoByBarCodeResponse(GetCardDealInfoByBarCodeResponse value) {
        return new JAXBElement<GetCardDealInfoByBarCodeResponse>(_GetCardDealInfoByBarCodeResponse_QNAME, GetCardDealInfoByBarCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransactionHistoryResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getTransactionHistoryResponse")
    public JAXBElement<GetTransactionHistoryResponse> createGetTransactionHistoryResponse(GetTransactionHistoryResponse value) {
        return new JAXBElement<GetTransactionHistoryResponse>(_GetTransactionHistoryResponse_QNAME, GetTransactionHistoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardDealsByDealNoResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardDealsByDealNoResponse")
    public JAXBElement<GetCardDealsByDealNoResponse> createGetCardDealsByDealNoResponse(GetCardDealsByDealNoResponse value) {
        return new JAXBElement<GetCardDealsByDealNoResponse>(_GetCardDealsByDealNoResponse_QNAME, GetCardDealsByDealNoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReissueCardWithNewSubproductCodeResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "reissueCardWithNewSubproductCodeResponse")
    public JAXBElement<ReissueCardWithNewSubproductCodeResponse> createReissueCardWithNewSubproductCodeResponse(ReissueCardWithNewSubproductCodeResponse value) {
        return new JAXBElement<ReissueCardWithNewSubproductCodeResponse>(_ReissueCardWithNewSubproductCodeResponse_QNAME, ReissueCardWithNewSubproductCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountList }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountList")
    public JAXBElement<AccountList> createAccountList(AccountList value) {
        return new JAXBElement<AccountList>(_AccountList_QNAME, AccountList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCardDeliveryStatusResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "setCardDeliveryStatusResponse")
    public JAXBElement<SetCardDeliveryStatusResponse> createSetCardDeliveryStatusResponse(SetCardDeliveryStatusResponse value) {
        return new JAXBElement<SetCardDeliveryStatusResponse>(_SetCardDeliveryStatusResponse_QNAME, SetCardDeliveryStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardDealsByAccountNoResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardDealsByAccountNoResponse")
    public JAXBElement<GetCardDealsByAccountNoResponse> createGetCardDealsByAccountNoResponse(GetCardDealsByAccountNoResponse value) {
        return new JAXBElement<GetCardDealsByAccountNoResponse>(_GetCardDealsByAccountNoResponse_QNAME, GetCardDealsByAccountNoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardAccountBillingReport }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardAccountBillingReport")
    public JAXBElement<CardAccountBillingReport> createCardAccountBillingReport(CardAccountBillingReport value) {
        return new JAXBElement<CardAccountBillingReport>(_CardAccountBillingReport_QNAME, CardAccountBillingReport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProjectInfoByProjectIdResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getProjectInfoByProjectIdResponse")
    public JAXBElement<GetProjectInfoByProjectIdResponse> createGetProjectInfoByProjectIdResponse(GetProjectInfoByProjectIdResponse value) {
        return new JAXBElement<GetProjectInfoByProjectIdResponse>(_GetProjectInfoByProjectIdResponse_QNAME, GetProjectInfoByProjectIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardManufacturersResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardManufacturersResponse")
    public JAXBElement<GetCardManufacturersResponse> createGetCardManufacturersResponse(GetCardManufacturersResponse value) {
        return new JAXBElement<GetCardManufacturersResponse>(_GetCardManufacturersResponse_QNAME, GetCardManufacturersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCardDeliveryAddressResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "setCardDeliveryAddressResponse")
    public JAXBElement<SetCardDeliveryAddressResponse> createSetCardDeliveryAddressResponse(SetCardDeliveryAddressResponse value) {
        return new JAXBElement<SetCardDeliveryAddressResponse>(_SetCardDeliveryAddressResponse_QNAME, SetCardDeliveryAddressResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCardContractCreditLimitResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "setCardContractCreditLimitResponse")
    public JAXBElement<SetCardContractCreditLimitResponse> createSetCardContractCreditLimitResponse(SetCardContractCreditLimitResponse value) {
        return new JAXBElement<SetCardContractCreditLimitResponse>(_SetCardContractCreditLimitResponse_QNAME, SetCardContractCreditLimitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisableMBankingResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "disableMBankingResponse")
    public JAXBElement<DisableMBankingResponse> createDisableMBankingResponse(DisableMBankingResponse value) {
        return new JAXBElement<DisableMBankingResponse>(_DisableMBankingResponse_QNAME, DisableMBankingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatementResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getStatementResponse")
    public JAXBElement<GetStatementResponse> createGetStatementResponse(GetStatementResponse value) {
        return new JAXBElement<GetStatementResponse>(_GetStatementResponse_QNAME, GetStatementResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnableMBankingResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "enableMBankingResponse")
    public JAXBElement<EnableMBankingResponse> createEnableMBankingResponse(EnableMBankingResponse value) {
        return new JAXBElement<EnableMBankingResponse>(_EnableMBankingResponse_QNAME, EnableMBankingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckAlfaChoiseEnableResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "checkAlfaChoiseEnableResponse")
    public JAXBElement<CheckAlfaChoiseEnableResponse> createCheckAlfaChoiseEnableResponse(CheckAlfaChoiseEnableResponse value) {
        return new JAXBElement<CheckAlfaChoiseEnableResponse>(_CheckAlfaChoiseEnableResponse_QNAME, CheckAlfaChoiseEnableResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeDealPhoneNumberResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "changeDealPhoneNumberResponse")
    public JAXBElement<ChangeDealPhoneNumberResponse> createChangeDealPhoneNumberResponse(ChangeDealPhoneNumberResponse value) {
        return new JAXBElement<ChangeDealPhoneNumberResponse>(_ChangeDealPhoneNumberResponse_QNAME, ChangeDealPhoneNumberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardAccountOperationList }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardAccountOperationList")
    public JAXBElement<CardAccountOperationList> createCardAccountOperationList(CardAccountOperationList value) {
        return new JAXBElement<CardAccountOperationList>(_CardAccountOperationList_QNAME, CardAccountOperationList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeBranchCodeResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "changeBranchCodeResponse")
    public JAXBElement<ChangeBranchCodeResponse> createChangeBranchCodeResponse(ChangeBranchCodeResponse value) {
        return new JAXBElement<ChangeBranchCodeResponse>(_ChangeBranchCodeResponse_QNAME, ChangeBranchCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisableOldCardResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "disableOldCardResponse")
    public JAXBElement<DisableOldCardResponse> createDisableOldCardResponse(DisableOldCardResponse value) {
        return new JAXBElement<DisableOldCardResponse>(_DisableOldCardResponse_QNAME, DisableOldCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelCardDealResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cancelCardDealResponse")
    public JAXBElement<CancelCardDealResponse> createCancelCardDealResponse(CancelCardDealResponse value) {
        return new JAXBElement<CancelCardDealResponse>(_CancelCardDealResponse_QNAME, CancelCardDealResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardDealStateResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardDealStateResponse")
    public JAXBElement<GetCardDealStateResponse> createGetCardDealStateResponse(GetCardDealStateResponse value) {
        return new JAXBElement<GetCardDealStateResponse>(_GetCardDealStateResponse_QNAME, GetCardDealStateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnulateSalaryCardResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "annulateSalaryCardResponse")
    public JAXBElement<AnnulateSalaryCardResponse> createAnnulateSalaryCardResponse(AnnulateSalaryCardResponse value) {
        return new JAXBElement<AnnulateSalaryCardResponse>(_AnnulateSalaryCardResponse_QNAME, AnnulateSalaryCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFinAccBySiebelResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getFinAccBySiebelResponse")
    public JAXBElement<GetFinAccBySiebelResponse> createGetFinAccBySiebelResponse(GetFinAccBySiebelResponse value) {
        return new JAXBElement<GetFinAccBySiebelResponse>(_GetFinAccBySiebelResponse_QNAME, GetFinAccBySiebelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckInstallmentAvailabilityResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "checkInstallmentAvailabilityResponse")
    public JAXBElement<CheckInstallmentAvailabilityResponse> createCheckInstallmentAvailabilityResponse(CheckInstallmentAvailabilityResponse value) {
        return new JAXBElement<CheckInstallmentAvailabilityResponse>(_CheckInstallmentAvailabilityResponse_QNAME, CheckInstallmentAvailabilityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardInfoByCardIdResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getCardInfoByCardIdResponse")
    public JAXBElement<GetCardInfoByCardIdResponse> createGetCardInfoByCardIdResponse(GetCardInfoByCardIdResponse value) {
        return new JAXBElement<GetCardInfoByCardIdResponse>(_GetCardInfoByCardIdResponse_QNAME, GetCardInfoByCardIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReIssueCardsResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "getReIssueCardsResponse")
    public JAXBElement<GetReIssueCardsResponse> createGetReIssueCardsResponse(GetReIssueCardsResponse value) {
        return new JAXBElement<GetReIssueCardsResponse>(_GetReIssueCardsResponse_QNAME, GetReIssueCardsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardTransactionList }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardTransactionList")
    public JAXBElement<CardTransactionList> createCardTransactionList(CardTransactionList value) {
        return new JAXBElement<CardTransactionList>(_CardTransactionList_QNAME, CardTransactionList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardId", scope = GetCardInfoByAccountNoItem.class)
    public JAXBElement<String> createGetCardInfoByAccountNoItemCardId(String value) {
        return new JAXBElement<String>(_GetCardInfoByAccountNoItemCardId_QNAME, String.class, GetCardInfoByAccountNoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "expireDate", scope = GetCardInfoByAccountNoItem.class)
    public JAXBElement<String> createGetCardInfoByAccountNoItemExpireDate(String value) {
        return new JAXBElement<String>(_GetCardInfoByAccountNoItemExpireDate_QNAME, String.class, GetCardInfoByAccountNoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "hardStoplist", scope = GetCardInfoByCardIdItem.class)
    public JAXBElement<String> createGetCardInfoByCardIdItemHardStoplist(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemHardStoplist_QNAME, String.class, GetCardInfoByCardIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardid", scope = GetCardInfoByCardIdItem.class)
    public JAXBElement<String> createGetCardInfoByCardIdItemCardid(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemCardid_QNAME, String.class, GetCardInfoByCardIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountNo", scope = GetCardInfoByCardIdItem.class)
    public JAXBElement<String> createGetCardInfoByCardIdItemAccountNo(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemAccountNo_QNAME, String.class, GetCardInfoByCardIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "nameOnCard", scope = GetCardInfoByCardIdItem.class)
    public JAXBElement<String> createGetCardInfoByCardIdItemNameOnCard(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemNameOnCard_QNAME, String.class, GetCardInfoByCardIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentId", scope = GetCardInfoByCardIdItem.class)
    public JAXBElement<String> createGetCardInfoByCardIdItemContragentId(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemContragentId_QNAME, String.class, GetCardInfoByCardIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "balanceNo", scope = GetCardInfoByCardIdItem.class)
    public JAXBElement<String> createGetCardInfoByCardIdItemBalanceNo(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemBalanceNo_QNAME, String.class, GetCardInfoByCardIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "expireDate", scope = GetCardInfoByCardIdItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetCardInfoByCardIdItemExpireDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardInfoByAccountNoItemExpireDate_QNAME, XMLGregorianCalendar.class, GetCardInfoByCardIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardNumber", scope = GetCardInfoByCardIdItem.class)
    public JAXBElement<String> createGetCardInfoByCardIdItemCardNumber(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemCardNumber_QNAME, String.class, GetCardInfoByCardIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "softStoplist", scope = GetCardInfoByCardIdItem.class)
    public JAXBElement<String> createGetCardInfoByCardIdItemSoftStoplist(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemSoftStoplist_QNAME, String.class, GetCardInfoByCardIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "currencyCode", scope = GetCardInfoByCardIdItem.class)
    public JAXBElement<String> createGetCardInfoByCardIdItemCurrencyCode(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemCurrencyCode_QNAME, String.class, GetCardInfoByCardIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "reserved1AccountNo", scope = GetCardInfoByCardIdItem.class)
    public JAXBElement<String> createGetCardInfoByCardIdItemReserved1AccountNo(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemReserved1AccountNo_QNAME, String.class, GetCardInfoByCardIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "hashnum", scope = GetCardInfoByCardIdItem.class)
    public JAXBElement<String> createGetCardInfoByCardIdItemHashnum(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemHashnum_QNAME, String.class, GetCardInfoByCardIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "operator", scope = GetCardInfoByCardIdItem.class)
    public JAXBElement<String> createGetCardInfoByCardIdItemOperator(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemOperator_QNAME, String.class, GetCardInfoByCardIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isActive", scope = GetCardInfoByCardIdItem.class)
    public JAXBElement<BigInteger> createGetCardInfoByCardIdItemIsActive(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardInfoByCardIdItemIsActive_QNAME, BigInteger.class, GetCardInfoByCardIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "periodAmt", scope = GetActiveInstallmentsInfoItem.class)
    public JAXBElement<Long> createGetActiveInstallmentsInfoItemPeriodAmt(Long value) {
        return new JAXBElement<Long>(_GetActiveInstallmentsInfoItemPeriodAmt_QNAME, Long.class, GetActiveInstallmentsInfoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "installmentID", scope = GetActiveInstallmentsInfoItem.class)
    public JAXBElement<Long> createGetActiveInstallmentsInfoItemInstallmentID(Long value) {
        return new JAXBElement<Long>(_GetActiveInstallmentsInfoItemInstallmentID_QNAME, Long.class, GetActiveInstallmentsInfoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "operationInfo", scope = GetActiveInstallmentsInfoItem.class)
    public JAXBElement<String> createGetActiveInstallmentsInfoItemOperationInfo(String value) {
        return new JAXBElement<String>(_GetActiveInstallmentsInfoItemOperationInfo_QNAME, String.class, GetActiveInstallmentsInfoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "startAmount", scope = GetActiveInstallmentsInfoItem.class)
    public JAXBElement<Long> createGetActiveInstallmentsInfoItemStartAmount(Long value) {
        return new JAXBElement<Long>(_GetActiveInstallmentsInfoItemStartAmount_QNAME, Long.class, GetActiveInstallmentsInfoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "remainAmtBody", scope = GetActiveInstallmentsInfoItem.class)
    public JAXBElement<Long> createGetActiveInstallmentsInfoItemRemainAmtBody(Long value) {
        return new JAXBElement<Long>(_GetActiveInstallmentsInfoItemRemainAmtBody_QNAME, Long.class, GetActiveInstallmentsInfoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "operationDate", scope = GetActiveInstallmentsInfoItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetActiveInstallmentsInfoItemOperationDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetActiveInstallmentsInfoItemOperationDate_QNAME, XMLGregorianCalendar.class, GetActiveInstallmentsInfoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "periodComiss", scope = GetActiveInstallmentsInfoItem.class)
    public JAXBElement<Long> createGetActiveInstallmentsInfoItemPeriodComiss(Long value) {
        return new JAXBElement<Long>(_GetActiveInstallmentsInfoItemPeriodComiss_QNAME, Long.class, GetActiveInstallmentsInfoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "remainAmt", scope = GetActiveInstallmentsInfoItem.class)
    public JAXBElement<Long> createGetActiveInstallmentsInfoItemRemainAmt(Long value) {
        return new JAXBElement<Long>(_GetActiveInstallmentsInfoItemRemainAmt_QNAME, Long.class, GetActiveInstallmentsInfoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "periodPrc", scope = GetActiveInstallmentsInfoItem.class)
    public JAXBElement<Long> createGetActiveInstallmentsInfoItemPeriodPrc(Long value) {
        return new JAXBElement<Long>(_GetActiveInstallmentsInfoItemPeriodPrc_QNAME, Long.class, GetActiveInstallmentsInfoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "remainCnt", scope = GetActiveInstallmentsInfoItem.class)
    public JAXBElement<Long> createGetActiveInstallmentsInfoItemRemainCnt(Long value) {
        return new JAXBElement<Long>(_GetActiveInstallmentsInfoItemRemainCnt_QNAME, Long.class, GetActiveInstallmentsInfoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardMask", scope = GetStatusMonitoringTransactionsItem.class)
    public JAXBElement<String> createGetStatusMonitoringTransactionsItemCardMask(String value) {
        return new JAXBElement<String>(_GetStatusMonitoringTransactionsItemCardMask_QNAME, String.class, GetStatusMonitoringTransactionsItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "categoryCard", scope = GetStatusMonitoringTransactionsItem.class)
    public JAXBElement<Long> createGetStatusMonitoringTransactionsItemCategoryCard(Long value) {
        return new JAXBElement<Long>(_GetStatusMonitoringTransactionsItemCategoryCard_QNAME, Long.class, GetStatusMonitoringTransactionsItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardId", scope = GetStatusMonitoringTransactionsItem.class)
    public JAXBElement<Long> createGetStatusMonitoringTransactionsItemCardId(Long value) {
        return new JAXBElement<Long>(_GetCardInfoByAccountNoItemCardId_QNAME, Long.class, GetStatusMonitoringTransactionsItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardName", scope = GetStatusMonitoringTransactionsItem.class)
    public JAXBElement<String> createGetStatusMonitoringTransactionsItemCardName(String value) {
        return new JAXBElement<String>(_GetStatusMonitoringTransactionsItemCardName_QNAME, String.class, GetStatusMonitoringTransactionsItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardProject", scope = GetStatusMonitoringTransactionsItem.class)
    public JAXBElement<String> createGetStatusMonitoringTransactionsItemCardProject(String value) {
        return new JAXBElement<String>(_GetStatusMonitoringTransactionsItemCardProject_QNAME, String.class, GetStatusMonitoringTransactionsItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statusMonitoringCard", scope = GetStatusMonitoringTransactionsItem.class)
    public JAXBElement<Long> createGetStatusMonitoringTransactionsItemStatusMonitoringCard(Long value) {
        return new JAXBElement<Long>(_GetStatusMonitoringTransactionsItemStatusMonitoringCard_QNAME, Long.class, GetStatusMonitoringTransactionsItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statusMonitoringClient", scope = GetStatusMonitoringTransactionsItem.class)
    public JAXBElement<Long> createGetStatusMonitoringTransactionsItemStatusMonitoringClient(Long value) {
        return new JAXBElement<Long>(_GetStatusMonitoringTransactionsItemStatusMonitoringClient_QNAME, Long.class, GetStatusMonitoringTransactionsItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorCode", scope = AnnulateSalaryCardItem.class)
    public JAXBElement<String> createAnnulateSalaryCardItemErrorCode(String value) {
        return new JAXBElement<String>(_AnnulateSalaryCardItemErrorCode_QNAME, String.class, AnnulateSalaryCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorMsg", scope = AnnulateSalaryCardItem.class)
    public JAXBElement<String> createAnnulateSalaryCardItemErrorMsg(String value) {
        return new JAXBElement<String>(_AnnulateSalaryCardItemErrorMsg_QNAME, String.class, AnnulateSalaryCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "removedCardIds", scope = DisableOldCardItem.class)
    public JAXBElement<String> createDisableOldCardItemRemovedCardIds(String value) {
        return new JAXBElement<String>(_DisableOldCardItemRemovedCardIds_QNAME, String.class, DisableOldCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errCode", scope = DisableOldCardItem.class)
    public JAXBElement<String> createDisableOldCardItemErrCode(String value) {
        return new JAXBElement<String>(_DisableOldCardItemErrCode_QNAME, String.class, DisableOldCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errMessage", scope = DisableOldCardItem.class)
    public JAXBElement<String> createDisableOldCardItemErrMessage(String value) {
        return new JAXBElement<String>(_DisableOldCardItemErrMessage_QNAME, String.class, DisableOldCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "mccCode", scope = GetTransactionHistoryItem.class)
    public JAXBElement<BigDecimal> createGetTransactionHistoryItemMccCode(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_GetTransactionHistoryItemMccCode_QNAME, BigDecimal.class, GetTransactionHistoryItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "transactionAmount", scope = GetTransactionHistoryItem.class)
    public JAXBElement<String> createGetTransactionHistoryItemTransactionAmount(String value) {
        return new JAXBElement<String>(_GetTransactionHistoryItemTransactionAmount_QNAME, String.class, GetTransactionHistoryItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "merchantId", scope = GetTransactionHistoryItem.class)
    public JAXBElement<String> createGetTransactionHistoryItemMerchantId(String value) {
        return new JAXBElement<String>(_GetTransactionHistoryItemMerchantId_QNAME, String.class, GetTransactionHistoryItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "acquirId", scope = GetTransactionHistoryItem.class)
    public JAXBElement<String> createGetTransactionHistoryItemAcquirId(String value) {
        return new JAXBElement<String>(_GetTransactionHistoryItemAcquirId_QNAME, String.class, GetTransactionHistoryItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "availibleAmount", scope = GetTransactionHistoryItem.class)
    public JAXBElement<String> createGetTransactionHistoryItemAvailibleAmount(String value) {
        return new JAXBElement<String>(_GetTransactionHistoryItemAvailibleAmount_QNAME, String.class, GetTransactionHistoryItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountAmount", scope = GetTransactionHistoryItem.class)
    public JAXBElement<String> createGetTransactionHistoryItemAccountAmount(String value) {
        return new JAXBElement<String>(_GetTransactionHistoryItemAccountAmount_QNAME, String.class, GetTransactionHistoryItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "expirationDate", scope = GetTransactionHistoryItem.class)
    public JAXBElement<String> createGetTransactionHistoryItemExpirationDate(String value) {
        return new JAXBElement<String>(_GetTransactionHistoryItemExpirationDate_QNAME, String.class, GetTransactionHistoryItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "transactionCurrency", scope = GetTransactionHistoryItem.class)
    public JAXBElement<String> createGetTransactionHistoryItemTransactionCurrency(String value) {
        return new JAXBElement<String>(_GetTransactionHistoryItemTransactionCurrency_QNAME, String.class, GetTransactionHistoryItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "msgType", scope = GetTransactionHistoryItem.class)
    public JAXBElement<String> createGetTransactionHistoryItemMsgType(String value) {
        return new JAXBElement<String>(_GetTransactionHistoryItemMsgType_QNAME, String.class, GetTransactionHistoryItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "processingCode", scope = GetTransactionHistoryItem.class)
    public JAXBElement<String> createGetTransactionHistoryItemProcessingCode(String value) {
        return new JAXBElement<String>(_GetTransactionHistoryItemProcessingCode_QNAME, String.class, GetTransactionHistoryItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "authorizationCode", scope = GetTransactionHistoryItem.class)
    public JAXBElement<String> createGetTransactionHistoryItemAuthorizationCode(String value) {
        return new JAXBElement<String>(_GetTransactionHistoryItemAuthorizationCode_QNAME, String.class, GetTransactionHistoryItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "merchant", scope = GetTransactionHistoryItem.class)
    public JAXBElement<String> createGetTransactionHistoryItemMerchant(String value) {
        return new JAXBElement<String>(_GetTransactionHistoryItemMerchant_QNAME, String.class, GetTransactionHistoryItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountCurrency", scope = GetTransactionHistoryItem.class)
    public JAXBElement<String> createGetTransactionHistoryItemAccountCurrency(String value) {
        return new JAXBElement<String>(_GetTransactionHistoryItemAccountCurrency_QNAME, String.class, GetTransactionHistoryItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "merchantName", scope = GetTransactionHistoryItem.class)
    public JAXBElement<String> createGetTransactionHistoryItemMerchantName(String value) {
        return new JAXBElement<String>(_GetTransactionHistoryItemMerchantName_QNAME, String.class, GetTransactionHistoryItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "responseCode", scope = GetTransactionHistoryItem.class)
    public JAXBElement<String> createGetTransactionHistoryItemResponseCode(String value) {
        return new JAXBElement<String>(_GetTransactionHistoryItemResponseCode_QNAME, String.class, GetTransactionHistoryItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "transactionDate", scope = GetTransactionHistoryItem.class)
    public JAXBElement<String> createGetTransactionHistoryItemTransactionDate(String value) {
        return new JAXBElement<String>(_GetTransactionHistoryItemTransactionDate_QNAME, String.class, GetTransactionHistoryItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "internalNumber", scope = GetTransactionHistoryItem.class)
    public JAXBElement<String> createGetTransactionHistoryItemInternalNumber(String value) {
        return new JAXBElement<String>(_GetTransactionHistoryItemInternalNumber_QNAME, String.class, GetTransactionHistoryItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountStatusText", scope = GetCardDealJurItem.class)
    public JAXBElement<String> createGetCardDealJurItemAccountStatusText(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemAccountStatusText_QNAME, String.class, GetCardDealJurItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountContragentId", scope = GetCardDealJurItem.class)
    public JAXBElement<String> createGetCardDealJurItemAccountContragentId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemAccountContragentId_QNAME, String.class, GetCardDealJurItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isPrimary", scope = GetCardDealJurItem.class)
    public JAXBElement<String> createGetCardDealJurItemIsPrimary(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemIsPrimary_QNAME, String.class, GetCardDealJurItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardId", scope = GetCardDealJurItem.class)
    public JAXBElement<String> createGetCardDealJurItemCardId(String value) {
        return new JAXBElement<String>(_GetCardInfoByAccountNoItemCardId_QNAME, String.class, GetCardDealJurItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardHashNumber", scope = GetCardDealJurItem.class)
    public JAXBElement<String> createGetCardDealJurItemCardHashNumber(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemCardHashNumber_QNAME, String.class, GetCardDealJurItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardStatusText", scope = GetCardDealJurItem.class)
    public JAXBElement<String> createGetCardDealJurItemCardStatusText(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemCardStatusText_QNAME, String.class, GetCardDealJurItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountStatusId", scope = GetCardDealJurItem.class)
    public JAXBElement<String> createGetCardDealJurItemAccountStatusId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemAccountStatusId_QNAME, String.class, GetCardDealJurItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectText", scope = GetCardDealJurItem.class)
    public JAXBElement<String> createGetCardDealJurItemProjectText(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemProjectText_QNAME, String.class, GetCardDealJurItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "currencyCode", scope = GetCardDealJurItem.class)
    public JAXBElement<String> createGetCardDealJurItemCurrencyCode(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemCurrencyCode_QNAME, String.class, GetCardDealJurItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectId", scope = GetCardDealJurItem.class)
    public JAXBElement<String> createGetCardDealJurItemProjectId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemProjectId_QNAME, String.class, GetCardDealJurItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardStatusId", scope = GetCardDealJurItem.class)
    public JAXBElement<String> createGetCardDealJurItemCardStatusId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemCardStatusId_QNAME, String.class, GetCardDealJurItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealId", scope = GetCardDealJurItem.class)
    public JAXBElement<String> createGetCardDealJurItemDealId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemDealId_QNAME, String.class, GetCardDealJurItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "responseText", scope = GetCardDealJurItem.class)
    public JAXBElement<String> createGetCardDealJurItemResponseText(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemResponseText_QNAME, String.class, GetCardDealJurItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "companyName", scope = GetCardDealJurItem.class)
    public JAXBElement<String> createGetCardDealJurItemCompanyName(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemCompanyName_QNAME, String.class, GetCardDealJurItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentName", scope = GetCardDealJurItem.class)
    public JAXBElement<String> createGetCardDealJurItemContragentName(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemContragentName_QNAME, String.class, GetCardDealJurItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardContragentId", scope = GetCardDealJurItem.class)
    public JAXBElement<String> createGetCardDealJurItemCardContragentId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemCardContragentId_QNAME, String.class, GetCardDealJurItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "responseCode", scope = GetCardDealJurItem.class)
    public JAXBElement<String> createGetCardDealJurItemResponseCode(String value) {
        return new JAXBElement<String>(_GetTransactionHistoryItemResponseCode_QNAME, String.class, GetCardDealJurItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealNo", scope = GetCardDealJurItem.class)
    public JAXBElement<String> createGetCardDealJurItemDealNo(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemDealNo_QNAME, String.class, GetCardDealJurItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountNumber", scope = GetCardDealJurItem.class)
    public JAXBElement<String> createGetCardDealJurItemAccountNumber(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemAccountNumber_QNAME, String.class, GetCardDealJurItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isChipCard", scope = GetCardDealJurItem.class)
    public JAXBElement<String> createGetCardDealJurItemIsChipCard(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemIsChipCard_QNAME, String.class, GetCardDealJurItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errCode", scope = SetNewSubproductByCardItem.class)
    public JAXBElement<BigInteger> createSetNewSubproductByCardItemErrCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_DisableOldCardItemErrCode_QNAME, BigInteger.class, SetNewSubproductByCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errMessage", scope = SetNewSubproductByCardItem.class)
    public JAXBElement<String> createSetNewSubproductByCardItemErrMessage(String value) {
        return new JAXBElement<String>(_DisableOldCardItemErrMessage_QNAME, String.class, SetNewSubproductByCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardRiskClassId", scope = SetCardDailyLimitsItem.class)
    public JAXBElement<Long> createSetCardDailyLimitsItemCardRiskClassId(Long value) {
        return new JAXBElement<Long>(_SetCardDailyLimitsItemCardRiskClassId_QNAME, Long.class, SetCardDailyLimitsItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "IC_Card_Id", scope = CardId.class)
    public JAXBElement<String> createCardIdICCardId(String value) {
        return new JAXBElement<String>(_CardIdICCardId_QNAME, String.class, CardId.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "closeDate", scope = CardDeal.class)
    public JAXBElement<XMLGregorianCalendar> createCardDealCloseDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealCloseDate_QNAME, XMLGregorianCalendar.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "taxId", scope = CardDeal.class)
    public JAXBElement<String> createCardDealTaxId(String value) {
        return new JAXBElement<String>(_CardDealTaxId_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statusText", scope = CardDeal.class)
    public JAXBElement<String> createCardDealStatusText(String value) {
        return new JAXBElement<String>(_CardDealStatusText_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statusId", scope = CardDeal.class)
    public JAXBElement<String> createCardDealStatusId(String value) {
        return new JAXBElement<String>(_CardDealStatusId_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentId", scope = CardDeal.class)
    public JAXBElement<String> createCardDealContragentId(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemContragentId_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "startDate", scope = CardDeal.class)
    public JAXBElement<XMLGregorianCalendar> createCardDealStartDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealStartDate_QNAME, XMLGregorianCalendar.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "toboId", scope = CardDeal.class)
    public JAXBElement<String> createCardDealToboId(String value) {
        return new JAXBElement<String>(_CardDealToboId_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "tarifPlanText", scope = CardDeal.class)
    public JAXBElement<String> createCardDealTarifPlanText(String value) {
        return new JAXBElement<String>(_CardDealTarifPlanText_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "currencyCode", scope = CardDeal.class)
    public JAXBElement<String> createCardDealCurrencyCode(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemCurrencyCode_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectId", scope = CardDeal.class)
    public JAXBElement<String> createCardDealProjectId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemProjectId_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isActiveText", scope = CardDeal.class)
    public JAXBElement<String> createCardDealIsActiveText(String value) {
        return new JAXBElement<String>(_CardDealIsActiveText_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "subProductCode", scope = CardDeal.class)
    public JAXBElement<String> createCardDealSubProductCode(String value) {
        return new JAXBElement<String>(_CardDealSubProductCode_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "sold", scope = CardDeal.class)
    public JAXBElement<String> createCardDealSold(String value) {
        return new JAXBElement<String>(_CardDealSold_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isPersonalized", scope = CardDeal.class)
    public JAXBElement<BigInteger> createCardDealIsPersonalized(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardDealIsPersonalized_QNAME, BigInteger.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isSalary", scope = CardDeal.class)
    public JAXBElement<BigInteger> createCardDealIsSalary(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardDealIsSalary_QNAME, BigInteger.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "reportDeliveryModeId", scope = CardDeal.class)
    public JAXBElement<String> createCardDealReportDeliveryModeId(String value) {
        return new JAXBElement<String>(_CardDealReportDeliveryModeId_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "segmentCode", scope = CardDeal.class)
    public JAXBElement<String> createCardDealSegmentCode(String value) {
        return new JAXBElement<String>(_CardDealSegmentCode_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentName", scope = CardDeal.class)
    public JAXBElement<String> createCardDealContragentName(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemContragentName_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "tarifPlanId", scope = CardDeal.class)
    public JAXBElement<String> createCardDealTarifPlanId(String value) {
        return new JAXBElement<String>(_CardDealTarifPlanId_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealNo", scope = CardDeal.class)
    public JAXBElement<String> createCardDealDealNo(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemDealNo_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "emailAddress", scope = CardDeal.class)
    public JAXBElement<String> createCardDealEmailAddress(String value) {
        return new JAXBElement<String>(_CardDealEmailAddress_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealTypeId", scope = CardDeal.class)
    public JAXBElement<String> createCardDealDealTypeId(String value) {
        return new JAXBElement<String>(_CardDealDealTypeId_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountNo", scope = CardDeal.class)
    public JAXBElement<String> createCardDealAccountNo(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemAccountNo_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "expireDate", scope = CardDeal.class)
    public JAXBElement<XMLGregorianCalendar> createCardDealExpireDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardInfoByAccountNoItemExpireDate_QNAME, XMLGregorianCalendar.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "creditLimit", scope = CardDeal.class)
    public JAXBElement<Long> createCardDealCreditLimit(Long value) {
        return new JAXBElement<Long>(_CardDealCreditLimit_QNAME, Long.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectText", scope = CardDeal.class)
    public JAXBElement<String> createCardDealProjectText(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemProjectText_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealId", scope = CardDeal.class)
    public JAXBElement<String> createCardDealDealId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemDealId_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectType", scope = CardDeal.class)
    public JAXBElement<String> createCardDealProjectType(String value) {
        return new JAXBElement<String>(_CardDealProjectType_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealTypeText", scope = CardDeal.class)
    public JAXBElement<String> createCardDealDealTypeText(String value) {
        return new JAXBElement<String>(_CardDealDealTypeText_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "signDate", scope = CardDeal.class)
    public JAXBElement<XMLGregorianCalendar> createCardDealSignDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealSignDate_QNAME, XMLGregorianCalendar.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isActive", scope = CardDeal.class)
    public JAXBElement<BigInteger> createCardDealIsActive(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardInfoByCardIdItemIsActive_QNAME, BigInteger.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "reportDeliveryAdress", scope = CardDeal.class)
    public JAXBElement<String> createCardDealReportDeliveryAdress(String value) {
        return new JAXBElement<String>(_CardDealReportDeliveryAdress_QNAME, String.class, CardDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errCode", scope = GetExtClientPrivIdItem.class)
    public JAXBElement<BigInteger> createGetExtClientPrivIdItemErrCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_DisableOldCardItemErrCode_QNAME, BigInteger.class, GetExtClientPrivIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "extClientPrivId", scope = GetExtClientPrivIdItem.class)
    public JAXBElement<BigInteger> createGetExtClientPrivIdItemExtClientPrivId(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetExtClientPrivIdItemExtClientPrivId_QNAME, BigInteger.class, GetExtClientPrivIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errMessage", scope = GetExtClientPrivIdItem.class)
    public JAXBElement<String> createGetExtClientPrivIdItemErrMessage(String value) {
        return new JAXBElement<String>(_DisableOldCardItemErrMessage_QNAME, String.class, GetExtClientPrivIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "resultCode", scope = ActivateCardByIdItem.class)
    public JAXBElement<BigInteger> createActivateCardByIdItemResultCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_ActivateCardByIdItemResultCode_QNAME, BigInteger.class, ActivateCardByIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "code", scope = GetCardManufacturersItem.class)
    public JAXBElement<String> createGetCardManufacturersItemCode(String value) {
        return new JAXBElement<String>(_GetCardManufacturersItemCode_QNAME, String.class, GetCardManufacturersItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "text", scope = GetCardManufacturersItem.class)
    public JAXBElement<String> createGetCardManufacturersItemText(String value) {
        return new JAXBElement<String>(_GetCardManufacturersItemText_QNAME, String.class, GetCardManufacturersItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorMessage", scope = CancelCardDealItem.class)
    public JAXBElement<String> createCancelCardDealItemErrorMessage(String value) {
        return new JAXBElement<String>(_CancelCardDealItemErrorMessage_QNAME, String.class, CancelCardDealItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorCode", scope = CancelCardDealItem.class)
    public JAXBElement<String> createCancelCardDealItemErrorCode(String value) {
        return new JAXBElement<String>(_AnnulateSalaryCardItemErrorCode_QNAME, String.class, CancelCardDealItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isPrimary", scope = Card.class)
    public JAXBElement<BigInteger> createCardIsPrimary(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardDealJurItemIsPrimary_QNAME, BigInteger.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardId", scope = Card.class)
    public JAXBElement<String> createCardCardId(String value) {
        return new JAXBElement<String>(_GetCardInfoByAccountNoItemCardId_QNAME, String.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "nameOnCard", scope = Card.class)
    public JAXBElement<String> createCardNameOnCard(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemNameOnCard_QNAME, String.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardNoXXX", scope = Card.class)
    public JAXBElement<String> createCardCardNoXXX(String value) {
        return new JAXBElement<String>(_CardCardNoXXX_QNAME, String.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "expireDate", scope = Card.class)
    public JAXBElement<XMLGregorianCalendar> createCardExpireDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardInfoByAccountNoItemExpireDate_QNAME, XMLGregorianCalendar.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardTypeId", scope = Card.class)
    public JAXBElement<String> createCardCardTypeId(String value) {
        return new JAXBElement<String>(_CardCardTypeId_QNAME, String.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "mBanking", scope = Card.class)
    public JAXBElement<BigInteger> createCardMBanking(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardMBanking_QNAME, BigInteger.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "additionalInfo", scope = Card.class)
    public JAXBElement<String> createCardAdditionalInfo(String value) {
        return new JAXBElement<String>(_CardAdditionalInfo_QNAME, String.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardHashNumber", scope = Card.class)
    public JAXBElement<String> createCardCardHashNumber(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemCardHashNumber_QNAME, String.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardStatusText", scope = Card.class)
    public JAXBElement<String> createCardCardStatusText(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemCardStatusText_QNAME, String.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "mBankingPhone", scope = Card.class)
    public JAXBElement<String> createCardMBankingPhone(String value) {
        return new JAXBElement<String>(_CardMBankingPhone_QNAME, String.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardTypeText", scope = Card.class)
    public JAXBElement<String> createCardCardTypeText(String value) {
        return new JAXBElement<String>(_CardCardTypeText_QNAME, String.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardStatusId", scope = Card.class)
    public JAXBElement<String> createCardCardStatusId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemCardStatusId_QNAME, String.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "codeCardText", scope = Card.class)
    public JAXBElement<String> createCardCodeCardText(String value) {
        return new JAXBElement<String>(_CardCodeCardText_QNAME, String.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "codeCardId", scope = Card.class)
    public JAXBElement<BigInteger> createCardCodeCardId(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardCodeCardId_QNAME, BigInteger.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardOwnerFullName", scope = Card.class)
    public JAXBElement<String> createCardCardOwnerFullName(String value) {
        return new JAXBElement<String>(_CardCardOwnerFullName_QNAME, String.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isActive", scope = Card.class)
    public JAXBElement<BigInteger> createCardIsActive(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardInfoByCardIdItemIsActive_QNAME, BigInteger.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "newSubProductCode", scope = GetNewSubproductItem.class)
    public JAXBElement<String> createGetNewSubproductItemNewSubProductCode(String value) {
        return new JAXBElement<String>(_GetNewSubproductItemNewSubProductCode_QNAME, String.class, GetNewSubproductItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorMessage", scope = GetNewSubproductItem.class)
    public JAXBElement<String> createGetNewSubproductItemErrorMessage(String value) {
        return new JAXBElement<String>(_CancelCardDealItemErrorMessage_QNAME, String.class, GetNewSubproductItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorCode", scope = GetNewSubproductItem.class)
    public JAXBElement<String> createGetNewSubproductItemErrorCode(String value) {
        return new JAXBElement<String>(_AnnulateSalaryCardItemErrorCode_QNAME, String.class, GetNewSubproductItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "templateId", scope = GetNewSubproductItem.class)
    public JAXBElement<String> createGetNewSubproductItemTemplateId(String value) {
        return new JAXBElement<String>(_GetNewSubproductItemTemplateId_QNAME, String.class, GetNewSubproductItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "nextPaymentDate", scope = CardDealState.class)
    public JAXBElement<XMLGregorianCalendar> createCardDealStateNextPaymentDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealStateNextPaymentDate_QNAME, XMLGregorianCalendar.class, CardDealState.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "availableCredit", scope = CardDealState.class)
    public JAXBElement<Long> createCardDealStateAvailableCredit(Long value) {
        return new JAXBElement<Long>(_CardDealStateAvailableCredit_QNAME, Long.class, CardDealState.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "totalDebt", scope = CardDealState.class)
    public JAXBElement<Long> createCardDealStateTotalDebt(Long value) {
        return new JAXBElement<Long>(_CardDealStateTotalDebt_QNAME, Long.class, CardDealState.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "balance", scope = CardDealState.class)
    public JAXBElement<Long> createCardDealStateBalance(Long value) {
        return new JAXBElement<Long>(_CardDealStateBalance_QNAME, Long.class, CardDealState.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "availableAmount", scope = CardDealState.class)
    public JAXBElement<Long> createCardDealStateAvailableAmount(Long value) {
        return new JAXBElement<Long>(_CardDealStateAvailableAmount_QNAME, Long.class, CardDealState.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "lastBalanceUpdate", scope = CardDealState.class)
    public JAXBElement<XMLGregorianCalendar> createCardDealStateLastBalanceUpdate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealStateLastBalanceUpdate_QNAME, XMLGregorianCalendar.class, CardDealState.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "installmentDebt", scope = CardDealState.class)
    public JAXBElement<Long> createCardDealStateInstallmentDebt(Long value) {
        return new JAXBElement<Long>(_CardDealStateInstallmentDebt_QNAME, Long.class, CardDealState.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "creditLimit", scope = CardDealState.class)
    public JAXBElement<Long> createCardDealStateCreditLimit(Long value) {
        return new JAXBElement<Long>(_CardDealCreditLimit_QNAME, Long.class, CardDealState.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "nextPaymentAmount", scope = CardDealState.class)
    public JAXBElement<Long> createCardDealStateNextPaymentAmount(Long value) {
        return new JAXBElement<Long>(_CardDealStateNextPaymentAmount_QNAME, Long.class, CardDealState.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "result", scope = CheckCodeWordItem.class)
    public JAXBElement<String> createCheckCodeWordItemResult(String value) {
        return new JAXBElement<String>(_CheckCodeWordItemResult_QNAME, String.class, CheckCodeWordItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "equalAmount", scope = ProcessInstallmentItem.class)
    public JAXBElement<String> createProcessInstallmentItemEqualAmount(String value) {
        return new JAXBElement<String>(_ProcessInstallmentItemEqualAmount_QNAME, String.class, ProcessInstallmentItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "installmentId", scope = ProcessInstallmentItem.class)
    public JAXBElement<String> createProcessInstallmentItemInstallmentId(String value) {
        return new JAXBElement<String>(_ProcessInstallmentItemInstallmentId_QNAME, String.class, ProcessInstallmentItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "result", scope = ProcessInstallmentItem.class)
    public JAXBElement<BigInteger> createProcessInstallmentItemResult(BigInteger value) {
        return new JAXBElement<BigInteger>(_CheckCodeWordItemResult_QNAME, BigInteger.class, ProcessInstallmentItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "transactionSum", scope = ProcessInstallmentItem.class)
    public JAXBElement<String> createProcessInstallmentItemTransactionSum(String value) {
        return new JAXBElement<String>(_ProcessInstallmentItemTransactionSum_QNAME, String.class, ProcessInstallmentItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorMessage", scope = ProcessInstallmentItem.class)
    public JAXBElement<String> createProcessInstallmentItemErrorMessage(String value) {
        return new JAXBElement<String>(_CancelCardDealItemErrorMessage_QNAME, String.class, ProcessInstallmentItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorCode", scope = ProcessInstallmentItem.class)
    public JAXBElement<BigInteger> createProcessInstallmentItemErrorCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_AnnulateSalaryCardItemErrorCode_QNAME, BigInteger.class, ProcessInstallmentItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "equalAvlAmountOut", scope = ProcessInstallmentItem.class)
    public JAXBElement<String> createProcessInstallmentItemEqualAvlAmountOut(String value) {
        return new JAXBElement<String>(_ProcessInstallmentItemEqualAvlAmountOut_QNAME, String.class, ProcessInstallmentItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "balance", scope = GetBalanceInIcItem.class)
    public JAXBElement<String> createGetBalanceInIcItemBalance(String value) {
        return new JAXBElement<String>(_CardDealStateBalance_QNAME, String.class, GetBalanceInIcItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "lastChangeStatusCard", scope = GetBalanceInIcItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetBalanceInIcItemLastChangeStatusCard(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetBalanceInIcItemLastChangeStatusCard_QNAME, XMLGregorianCalendar.class, GetBalanceInIcItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorMessage", scope = GetBalanceInIcItem.class)
    public JAXBElement<String> createGetBalanceInIcItemErrorMessage(String value) {
        return new JAXBElement<String>(_CancelCardDealItemErrorMessage_QNAME, String.class, GetBalanceInIcItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorCode", scope = GetBalanceInIcItem.class)
    public JAXBElement<String> createGetBalanceInIcItemErrorCode(String value) {
        return new JAXBElement<String>(_AnnulateSalaryCardItemErrorCode_QNAME, String.class, GetBalanceInIcItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "balanceUah", scope = GetBalanceInIcItem.class)
    public JAXBElement<String> createGetBalanceInIcItemBalanceUah(String value) {
        return new JAXBElement<String>(_GetBalanceInIcItemBalanceUah_QNAME, String.class, GetBalanceInIcItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountReserved", scope = GetBalanceInIcItem.class)
    public JAXBElement<String> createGetBalanceInIcItemAccountReserved(String value) {
        return new JAXBElement<String>(_GetBalanceInIcItemAccountReserved_QNAME, String.class, GetBalanceInIcItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "code", scope = CheckOpportunityRecreateCardItem.class)
    public JAXBElement<String> createCheckOpportunityRecreateCardItemCode(String value) {
        return new JAXBElement<String>(_GetCardManufacturersItemCode_QNAME, String.class, CheckOpportunityRecreateCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "branchId", scope = CheckOpportunityRecreateCardItem.class)
    public JAXBElement<String> createCheckOpportunityRecreateCardItemBranchId(String value) {
        return new JAXBElement<String>(_CheckOpportunityRecreateCardItemBranchId_QNAME, String.class, CheckOpportunityRecreateCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "decision", scope = CheckOpportunityRecreateCardItem.class)
    public JAXBElement<String> createCheckOpportunityRecreateCardItemDecision(String value) {
        return new JAXBElement<String>(_CheckOpportunityRecreateCardItemDecision_QNAME, String.class, CheckOpportunityRecreateCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "text", scope = CheckOpportunityRecreateCardItem.class)
    public JAXBElement<String> createCheckOpportunityRecreateCardItemText(String value) {
        return new JAXBElement<String>(_GetCardManufacturersItemText_QNAME, String.class, CheckOpportunityRecreateCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "minPaymentDate", scope = CardDealInfo.class)
    public JAXBElement<String> createCardDealInfoMinPaymentDate(String value) {
        return new JAXBElement<String>(_CardDealInfoMinPaymentDate_QNAME, String.class, CardDealInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "overdraftAmount", scope = CardDealInfo.class)
    public JAXBElement<String> createCardDealInfoOverdraftAmount(String value) {
        return new JAXBElement<String>(_CardDealInfoOverdraftAmount_QNAME, String.class, CardDealInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "minPayment", scope = CardDealInfo.class)
    public JAXBElement<String> createCardDealInfoMinPayment(String value) {
        return new JAXBElement<String>(_CardDealInfoMinPayment_QNAME, String.class, CardDealInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "creditLimit", scope = CardDealInfo.class)
    public JAXBElement<Long> createCardDealInfoCreditLimit(Long value) {
        return new JAXBElement<Long>(_CardDealCreditLimit_QNAME, Long.class, CardDealInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "resultCode", scope = FreezeCardAccountItem.class)
    public JAXBElement<BigInteger> createFreezeCardAccountItemResultCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_ActivateCardByIdItemResultCode_QNAME, BigInteger.class, FreezeCardAccountItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorMessage", scope = FreezeCardAccountItem.class)
    public JAXBElement<String> createFreezeCardAccountItemErrorMessage(String value) {
        return new JAXBElement<String>(_CancelCardDealItemErrorMessage_QNAME, String.class, FreezeCardAccountItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "custValZDK", scope = GetCurrentNewSubproductItem.class)
    public JAXBElement<String> createGetCurrentNewSubproductItemCustValZDK(String value) {
        return new JAXBElement<String>(_GetCurrentNewSubproductItemCustValZDK_QNAME, String.class, GetCurrentNewSubproductItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "subproductCode", scope = GetCurrentNewSubproductItem.class)
    public JAXBElement<String> createGetCurrentNewSubproductItemSubproductCode(String value) {
        return new JAXBElement<String>(_GetCurrentNewSubproductItemSubproductCode_QNAME, String.class, GetCurrentNewSubproductItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "messageId", scope = GetCurrentNewSubproductItem.class)
    public JAXBElement<String> createGetCurrentNewSubproductItemMessageId(String value) {
        return new JAXBElement<String>(_GetCurrentNewSubproductItemMessageId_QNAME, String.class, GetCurrentNewSubproductItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "addCardHashNumber", scope = RegisterAddCardItem.class)
    public JAXBElement<String> createRegisterAddCardItemAddCardHashNumber(String value) {
        return new JAXBElement<String>(_RegisterAddCardItemAddCardHashNumber_QNAME, String.class, RegisterAddCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountState", scope = GetFinAccBySiebelItem.class)
    public JAXBElement<String> createGetFinAccBySiebelItemAccountState(String value) {
        return new JAXBElement<String>(_GetFinAccBySiebelItemAccountState_QNAME, String.class, GetFinAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isCardAccountId", scope = GetFinAccBySiebelItem.class)
    public JAXBElement<BigInteger> createGetFinAccBySiebelItemIsCardAccountId(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetFinAccBySiebelItemIsCardAccountId_QNAME, BigInteger.class, GetFinAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isCardAgreementId", scope = GetFinAccBySiebelItem.class)
    public JAXBElement<BigInteger> createGetFinAccBySiebelItemIsCardAgreementId(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetFinAccBySiebelItemIsCardAgreementId_QNAME, BigInteger.class, GetFinAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "currDgtlCode", scope = GetFinAccBySiebelItem.class)
    public JAXBElement<String> createGetFinAccBySiebelItemCurrDgtlCode(String value) {
        return new JAXBElement<String>(_GetFinAccBySiebelItemCurrDgtlCode_QNAME, String.class, GetFinAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountType", scope = GetFinAccBySiebelItem.class)
    public JAXBElement<String> createGetFinAccBySiebelItemAccountType(String value) {
        return new JAXBElement<String>(_GetFinAccBySiebelItemAccountType_QNAME, String.class, GetFinAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "finAccountNumber", scope = GetFinAccBySiebelItem.class)
    public JAXBElement<String> createGetFinAccBySiebelItemFinAccountNumber(String value) {
        return new JAXBElement<String>(_GetFinAccBySiebelItemFinAccountNumber_QNAME, String.class, GetFinAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isPrincipal", scope = GetFinAccBySiebelItem.class)
    public JAXBElement<BigInteger> createGetFinAccBySiebelItemIsPrincipal(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetFinAccBySiebelItemIsPrincipal_QNAME, BigInteger.class, GetFinAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "reportDeliveryModeId", scope = GetReportDeliveryModesItem.class)
    public JAXBElement<BigInteger> createGetReportDeliveryModesItemReportDeliveryModeId(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardDealReportDeliveryModeId_QNAME, BigInteger.class, GetReportDeliveryModesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "reportDeliveryModeText", scope = GetReportDeliveryModesItem.class)
    public JAXBElement<String> createGetReportDeliveryModesItemReportDeliveryModeText(String value) {
        return new JAXBElement<String>(_GetReportDeliveryModesItemReportDeliveryModeText_QNAME, String.class, GetReportDeliveryModesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorMessage", scope = ChangeDealPhoneNumberItem.class)
    public JAXBElement<String> createChangeDealPhoneNumberItemErrorMessage(String value) {
        return new JAXBElement<String>(_CancelCardDealItemErrorMessage_QNAME, String.class, ChangeDealPhoneNumberItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "approvalCode", scope = CardAccountOperationItem.class)
    public JAXBElement<String> createCardAccountOperationItemApprovalCode(String value) {
        return new JAXBElement<String>(_CardAccountOperationItemApprovalCode_QNAME, String.class, CardAccountOperationItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "operationDate", scope = CardAccountOperationItem.class)
    public JAXBElement<XMLGregorianCalendar> createCardAccountOperationItemOperationDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetActiveInstallmentsInfoItemOperationDate_QNAME, XMLGregorianCalendar.class, CardAccountOperationItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "transactionAmount", scope = CardAccountOperationItem.class)
    public JAXBElement<Long> createCardAccountOperationItemTransactionAmount(Long value) {
        return new JAXBElement<Long>(_GetTransactionHistoryItemTransactionAmount_QNAME, Long.class, CardAccountOperationItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "operationAmount", scope = CardAccountOperationItem.class)
    public JAXBElement<Long> createCardAccountOperationItemOperationAmount(Long value) {
        return new JAXBElement<Long>(_CardAccountOperationItemOperationAmount_QNAME, Long.class, CardAccountOperationItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "transactionCurrencyCode", scope = CardAccountOperationItem.class)
    public JAXBElement<String> createCardAccountOperationItemTransactionCurrencyCode(String value) {
        return new JAXBElement<String>(_CardAccountOperationItemTransactionCurrencyCode_QNAME, String.class, CardAccountOperationItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "transactionInfo", scope = CardAccountOperationItem.class)
    public JAXBElement<String> createCardAccountOperationItemTransactionInfo(String value) {
        return new JAXBElement<String>(_CardAccountOperationItemTransactionInfo_QNAME, String.class, CardAccountOperationItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "transactionDate", scope = CardAccountOperationItem.class)
    public JAXBElement<XMLGregorianCalendar> createCardAccountOperationItemTransactionDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetTransactionHistoryItemTransactionDate_QNAME, XMLGregorianCalendar.class, CardAccountOperationItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "operationCurrencyCode", scope = CardAccountOperationItem.class)
    public JAXBElement<String> createCardAccountOperationItemOperationCurrencyCode(String value) {
        return new JAXBElement<String>(_CardAccountOperationItemOperationCurrencyCode_QNAME, String.class, CardAccountOperationItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "overdraftBeginDate", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetFinCorpAccBySiebelItemOverdraftBeginDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetFinCorpAccBySiebelItemOverdraftBeginDate_QNAME, XMLGregorianCalendar.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountModel", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<String> createGetFinCorpAccBySiebelItemAccountModel(String value) {
        return new JAXBElement<String>(_GetFinCorpAccBySiebelItemAccountModel_QNAME, String.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "collectionStatus", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<String> createGetFinCorpAccBySiebelItemCollectionStatus(String value) {
        return new JAXBElement<String>(_GetFinCorpAccBySiebelItemCollectionStatus_QNAME, String.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "prBranch", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<BigInteger> createGetFinCorpAccBySiebelItemPrBranch(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetFinCorpAccBySiebelItemPrBranch_QNAME, BigInteger.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statusB2", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<String> createGetFinCorpAccBySiebelItemStatusB2(String value) {
        return new JAXBElement<String>(_GetFinCorpAccBySiebelItemStatusB2_QNAME, String.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "otherIdNumber", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<String> createGetFinCorpAccBySiebelItemOtherIdNumber(String value) {
        return new JAXBElement<String>(_GetFinCorpAccBySiebelItemOtherIdNumber_QNAME, String.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealDate", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetFinCorpAccBySiebelItemDealDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetFinCorpAccBySiebelItemDealDate_QNAME, XMLGregorianCalendar.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountBranchName", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<String> createGetFinCorpAccBySiebelItemAccountBranchName(String value) {
        return new JAXBElement<String>(_GetFinCorpAccBySiebelItemAccountBranchName_QNAME, String.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isCardConditRateId", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<String> createGetFinCorpAccBySiebelItemIsCardConditRateId(String value) {
        return new JAXBElement<String>(_GetFinCorpAccBySiebelItemIsCardConditRateId_QNAME, String.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "overdraftEndDate", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetFinCorpAccBySiebelItemOverdraftEndDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetFinCorpAccBySiebelItemOverdraftEndDate_QNAME, XMLGregorianCalendar.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isCardAgreementId", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<BigInteger> createGetFinCorpAccBySiebelItemIsCardAgreementId(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetFinAccBySiebelItemIsCardAgreementId_QNAME, BigInteger.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountType", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<String> createGetFinCorpAccBySiebelItemAccountType(String value) {
        return new JAXBElement<String>(_GetFinAccBySiebelItemAccountType_QNAME, String.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isCardProjectId", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<String> createGetFinCorpAccBySiebelItemIsCardProjectId(String value) {
        return new JAXBElement<String>(_GetFinCorpAccBySiebelItemIsCardProjectId_QNAME, String.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "taxIdNumber", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<String> createGetFinCorpAccBySiebelItemTaxIdNumber(String value) {
        return new JAXBElement<String>(_GetFinCorpAccBySiebelItemTaxIdNumber_QNAME, String.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "agreementDate", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetFinCorpAccBySiebelItemAgreementDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetFinCorpAccBySiebelItemAgreementDate_QNAME, XMLGregorianCalendar.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dlNumber", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<String> createGetFinCorpAccBySiebelItemDlNumber(String value) {
        return new JAXBElement<String>(_GetFinCorpAccBySiebelItemDlNumber_QNAME, String.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dateOfBirth", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetFinCorpAccBySiebelItemDateOfBirth(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetFinCorpAccBySiebelItemDateOfBirth_QNAME, XMLGregorianCalendar.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "t24Id", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<String> createGetFinCorpAccBySiebelItemT24Id(String value) {
        return new JAXBElement<String>(_GetFinCorpAccBySiebelItemT24Id_QNAME, String.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statementMode", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<String> createGetFinCorpAccBySiebelItemStatementMode(String value) {
        return new JAXBElement<String>(_GetFinCorpAccBySiebelItemStatementMode_QNAME, String.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statementAddress", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<String> createGetFinCorpAccBySiebelItemStatementAddress(String value) {
        return new JAXBElement<String>(_GetFinCorpAccBySiebelItemStatementAddress_QNAME, String.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "agreementNumber", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<String> createGetFinCorpAccBySiebelItemAgreementNumber(String value) {
        return new JAXBElement<String>(_GetFinCorpAccBySiebelItemAgreementNumber_QNAME, String.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountNumber", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<String> createGetFinCorpAccBySiebelItemAccountNumber(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemAccountNumber_QNAME, String.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isCardConditAccId", scope = GetFinCorpAccBySiebelItem.class)
    public JAXBElement<String> createGetFinCorpAccBySiebelItemIsCardConditAccId(String value) {
        return new JAXBElement<String>(_GetFinCorpAccBySiebelItemIsCardConditAccId_QNAME, String.class, GetFinCorpAccBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "subProductCode", scope = GetCurrentSubproductItem.class)
    public JAXBElement<String> createGetCurrentSubproductItemSubProductCode(String value) {
        return new JAXBElement<String>(_CardDealSubProductCode_QNAME, String.class, GetCurrentSubproductItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errCode", scope = SetBarCodeItem.class)
    public JAXBElement<BigInteger> createSetBarCodeItemErrCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_DisableOldCardItemErrCode_QNAME, BigInteger.class, SetBarCodeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errMessage", scope = SetBarCodeItem.class)
    public JAXBElement<String> createSetBarCodeItemErrMessage(String value) {
        return new JAXBElement<String>(_DisableOldCardItemErrMessage_QNAME, String.class, SetBarCodeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "branchId", scope = GetCardDeliveryBranchesItem.class)
    public JAXBElement<BigInteger> createGetCardDeliveryBranchesItemBranchId(BigInteger value) {
        return new JAXBElement<BigInteger>(_CheckOpportunityRecreateCardItemBranchId_QNAME, BigInteger.class, GetCardDeliveryBranchesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "branchName", scope = GetCardDeliveryBranchesItem.class)
    public JAXBElement<String> createGetCardDeliveryBranchesItemBranchName(String value) {
        return new JAXBElement<String>(_GetCardDeliveryBranchesItemBranchName_QNAME, String.class, GetCardDeliveryBranchesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "B", scope = GetCardDealFeesItem.class)
    public JAXBElement<Double> createGetCardDealFeesItemB(Double value) {
        return new JAXBElement<Double>(_GetCardDealFeesItemB_QNAME, Double.class, GetCardDealFeesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "C", scope = GetCardDealFeesItem.class)
    public JAXBElement<Long> createGetCardDealFeesItemC(Long value) {
        return new JAXBElement<Long>(_GetCardDealFeesItemC_QNAME, Long.class, GetCardDealFeesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "A", scope = GetCardDealFeesItem.class)
    public JAXBElement<Long> createGetCardDealFeesItemA(Long value) {
        return new JAXBElement<Long>(_GetCardDealFeesItemA_QNAME, Long.class, GetCardDealFeesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "D", scope = GetCardDealFeesItem.class)
    public JAXBElement<Double> createGetCardDealFeesItemD(Double value) {
        return new JAXBElement<Double>(_GetCardDealFeesItemD_QNAME, Double.class, GetCardDealFeesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "E", scope = GetCardDealFeesItem.class)
    public JAXBElement<Long> createGetCardDealFeesItemE(Long value) {
        return new JAXBElement<Long>(_GetCardDealFeesItemE_QNAME, Long.class, GetCardDealFeesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "feeName", scope = GetCardDealFeesItem.class)
    public JAXBElement<String> createGetCardDealFeesItemFeeName(String value) {
        return new JAXBElement<String>(_GetCardDealFeesItemFeeName_QNAME, String.class, GetCardDealFeesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "feeClassId", scope = GetCardDealFeesItem.class)
    public JAXBElement<String> createGetCardDealFeesItemFeeClassId(String value) {
        return new JAXBElement<String>(_GetCardDealFeesItemFeeClassId_QNAME, String.class, GetCardDealFeesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "feeType", scope = GetCardDealFeesItem.class)
    public JAXBElement<String> createGetCardDealFeesItemFeeType(String value) {
        return new JAXBElement<String>(_GetCardDealFeesItemFeeType_QNAME, String.class, GetCardDealFeesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "amount", scope = CardTransaction.class)
    public JAXBElement<String> createCardTransactionAmount(String value) {
        return new JAXBElement<String>(_CardTransactionAmount_QNAME, String.class, CardTransaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "date", scope = CardTransaction.class)
    public JAXBElement<String> createCardTransactionDate(String value) {
        return new JAXBElement<String>(_CardTransactionDate_QNAME, String.class, CardTransaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "info", scope = CardTransaction.class)
    public JAXBElement<String> createCardTransactionInfo(String value) {
        return new JAXBElement<String>(_CardTransactionInfo_QNAME, String.class, CardTransaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "type", scope = CardTransaction.class)
    public JAXBElement<String> createCardTransactionType(String value) {
        return new JAXBElement<String>(_CardTransactionType_QNAME, String.class, CardTransaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "currencyId", scope = CardTransaction.class)
    public JAXBElement<String> createCardTransactionCurrencyId(String value) {
        return new JAXBElement<String>(_CardTransactionCurrencyId_QNAME, String.class, CardTransaction.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "stopListId", scope = GetCardInfoItem.class)
    public JAXBElement<BigInteger> createGetCardInfoItemStopListId(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardInfoItemStopListId_QNAME, BigInteger.class, GetCardInfoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statusId", scope = GetCardInfoItem.class)
    public JAXBElement<BigInteger> createGetCardInfoItemStatusId(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardDealStatusId_QNAME, BigInteger.class, GetCardInfoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "barcode", scope = GetCardInfoItem.class)
    public JAXBElement<String> createGetCardInfoItemBarcode(String value) {
        return new JAXBElement<String>(_GetCardInfoItemBarcode_QNAME, String.class, GetCardInfoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errCode", scope = ChangeSubproductCodeItem.class)
    public JAXBElement<String> createChangeSubproductCodeItemErrCode(String value) {
        return new JAXBElement<String>(_DisableOldCardItemErrCode_QNAME, String.class, ChangeSubproductCodeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errMessage", scope = ChangeSubproductCodeItem.class)
    public JAXBElement<String> createChangeSubproductCodeItemErrMessage(String value) {
        return new JAXBElement<String>(_DisableOldCardItemErrMessage_QNAME, String.class, ChangeSubproductCodeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentIdOut", scope = SetDNDStatusItem.class)
    public JAXBElement<String> createSetDNDStatusItemContragentIdOut(String value) {
        return new JAXBElement<String>(_SetDNDStatusItemContragentIdOut_QNAME, String.class, SetDNDStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorMessage", scope = SetDNDStatusItem.class)
    public JAXBElement<String> createSetDNDStatusItemErrorMessage(String value) {
        return new JAXBElement<String>(_CancelCardDealItemErrorMessage_QNAME, String.class, SetDNDStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorCode", scope = SetDNDStatusItem.class)
    public JAXBElement<BigInteger> createSetDNDStatusItemErrorCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_AnnulateSalaryCardItemErrorCode_QNAME, BigInteger.class, SetDNDStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "codeWord", scope = GetFinsAppCardBySiebelItem.class)
    public JAXBElement<String> createGetFinsAppCardBySiebelItemCodeWord(String value) {
        return new JAXBElement<String>(_GetFinsAppCardBySiebelItemCodeWord_QNAME, String.class, GetFinsAppCardBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accessType", scope = GetFinsAppCardBySiebelItem.class)
    public JAXBElement<String> createGetFinsAppCardBySiebelItemAccessType(String value) {
        return new JAXBElement<String>(_GetFinsAppCardBySiebelItemAccessType_QNAME, String.class, GetFinsAppCardBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "expiryDate", scope = GetFinsAppCardBySiebelItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetFinsAppCardBySiebelItemExpiryDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetFinsAppCardBySiebelItemExpiryDate_QNAME, XMLGregorianCalendar.class, GetFinsAppCardBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isCardCardId", scope = GetFinsAppCardBySiebelItem.class)
    public JAXBElement<BigInteger> createGetFinsAppCardBySiebelItemIsCardCardId(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetFinsAppCardBySiebelItemIsCardCardId_QNAME, BigInteger.class, GetFinsAppCardBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "firstName", scope = GetFinsAppCardBySiebelItem.class)
    public JAXBElement<String> createGetFinsAppCardBySiebelItemFirstName(String value) {
        return new JAXBElement<String>(_GetFinsAppCardBySiebelItemFirstName_QNAME, String.class, GetFinsAppCardBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isCardRiskClassId", scope = GetFinsAppCardBySiebelItem.class)
    public JAXBElement<String> createGetFinsAppCardBySiebelItemIsCardRiskClassId(String value) {
        return new JAXBElement<String>(_GetFinsAppCardBySiebelItemIsCardRiskClassId_QNAME, String.class, GetFinsAppCardBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "sideInformation", scope = GetFinsAppCardBySiebelItem.class)
    public JAXBElement<String> createGetFinsAppCardBySiebelItemSideInformation(String value) {
        return new JAXBElement<String>(_GetFinsAppCardBySiebelItemSideInformation_QNAME, String.class, GetFinsAppCardBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statementStopList", scope = GetFinsAppCardBySiebelItem.class)
    public JAXBElement<String> createGetFinsAppCardBySiebelItemStatementStopList(String value) {
        return new JAXBElement<String>(_GetFinsAppCardBySiebelItemStatementStopList_QNAME, String.class, GetFinsAppCardBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardNumber", scope = GetFinsAppCardBySiebelItem.class)
    public JAXBElement<String> createGetFinsAppCardBySiebelItemCardNumber(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemCardNumber_QNAME, String.class, GetFinsAppCardBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardStatus", scope = GetFinsAppCardBySiebelItem.class)
    public JAXBElement<String> createGetFinsAppCardBySiebelItemCardStatus(String value) {
        return new JAXBElement<String>(_GetFinsAppCardBySiebelItemCardStatus_QNAME, String.class, GetFinsAppCardBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "mBankingPhone", scope = GetFinsAppCardBySiebelItem.class)
    public JAXBElement<String> createGetFinsAppCardBySiebelItemMBankingPhone(String value) {
        return new JAXBElement<String>(_CardMBankingPhone_QNAME, String.class, GetFinsAppCardBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "categoriesCards", scope = GetFinsAppCardBySiebelItem.class)
    public JAXBElement<String> createGetFinsAppCardBySiebelItemCategoriesCards(String value) {
        return new JAXBElement<String>(_GetFinsAppCardBySiebelItemCategoriesCards_QNAME, String.class, GetFinsAppCardBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "mBankingState", scope = GetFinsAppCardBySiebelItem.class)
    public JAXBElement<String> createGetFinsAppCardBySiebelItemMBankingState(String value) {
        return new JAXBElement<String>(_GetFinsAppCardBySiebelItemMBankingState_QNAME, String.class, GetFinsAppCardBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "serviceType", scope = GetFinsAppCardBySiebelItem.class)
    public JAXBElement<String> createGetFinsAppCardBySiebelItemServiceType(String value) {
        return new JAXBElement<String>(_GetFinsAppCardBySiebelItemServiceType_QNAME, String.class, GetFinsAppCardBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isCardAccountId", scope = GetFinsAppCardBySiebelItem.class)
    public JAXBElement<BigInteger> createGetFinsAppCardBySiebelItemIsCardAccountId(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetFinAccBySiebelItemIsCardAccountId_QNAME, BigInteger.class, GetFinsAppCardBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isCardAgreementId", scope = GetFinsAppCardBySiebelItem.class)
    public JAXBElement<BigInteger> createGetFinsAppCardBySiebelItemIsCardAgreementId(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetFinAccBySiebelItemIsCardAgreementId_QNAME, BigInteger.class, GetFinsAppCardBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardType", scope = GetFinsAppCardBySiebelItem.class)
    public JAXBElement<String> createGetFinsAppCardBySiebelItemCardType(String value) {
        return new JAXBElement<String>(_GetFinsAppCardBySiebelItemCardType_QNAME, String.class, GetFinsAppCardBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "modeCards", scope = GetFinsAppCardBySiebelItem.class)
    public JAXBElement<String> createGetFinsAppCardBySiebelItemModeCards(String value) {
        return new JAXBElement<String>(_GetFinsAppCardBySiebelItemModeCards_QNAME, String.class, GetFinsAppCardBySiebelItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardId", scope = RegisterCardDealItem.class)
    public JAXBElement<String> createRegisterCardDealItemCardId(String value) {
        return new JAXBElement<String>(_GetCardInfoByAccountNoItemCardId_QNAME, String.class, RegisterCardDealItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardHashNum", scope = RegisterCardDealItem.class)
    public JAXBElement<String> createRegisterCardDealItemCardHashNum(String value) {
        return new JAXBElement<String>(_RegisterCardDealItemCardHashNum_QNAME, String.class, RegisterCardDealItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorMessage", scope = RegisterCardDealItem.class)
    public JAXBElement<String> createRegisterCardDealItemErrorMessage(String value) {
        return new JAXBElement<String>(_CancelCardDealItemErrorMessage_QNAME, String.class, RegisterCardDealItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorCode", scope = RegisterCardDealItem.class)
    public JAXBElement<String> createRegisterCardDealItemErrorCode(String value) {
        return new JAXBElement<String>(_AnnulateSalaryCardItemErrorCode_QNAME, String.class, RegisterCardDealItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealNo", scope = RegisterCardDealItem.class)
    public JAXBElement<String> createRegisterCardDealItemDealNo(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemDealNo_QNAME, String.class, RegisterCardDealItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentId", scope = CheckTransferItem.class)
    public JAXBElement<String> createCheckTransferItemContragentId(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemContragentId_QNAME, String.class, CheckTransferItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "nameOnCard", scope = CheckTransferItem.class)
    public JAXBElement<String> createCheckTransferItemNameOnCard(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemNameOnCard_QNAME, String.class, CheckTransferItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "respCode", scope = CheckTransferItem.class)
    public JAXBElement<String> createCheckTransferItemRespCode(String value) {
        return new JAXBElement<String>(_CheckTransferItemRespCode_QNAME, String.class, CheckTransferItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountNumber", scope = CheckTransferItem.class)
    public JAXBElement<String> createCheckTransferItemAccountNumber(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemAccountNumber_QNAME, String.class, CheckTransferItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardId", scope = GetCardDealInfoByBarCodeItem.class)
    public JAXBElement<String> createGetCardDealInfoByBarCodeItemCardId(String value) {
        return new JAXBElement<String>(_GetCardInfoByAccountNoItemCardId_QNAME, String.class, GetCardDealInfoByBarCodeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountNo", scope = GetCardDealInfoByBarCodeItem.class)
    public JAXBElement<String> createGetCardDealInfoByBarCodeItemAccountNo(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemAccountNo_QNAME, String.class, GetCardDealInfoByBarCodeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardHashNumber", scope = GetCardDealInfoByBarCodeItem.class)
    public JAXBElement<String> createGetCardDealInfoByBarCodeItemCardHashNumber(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemCardHashNumber_QNAME, String.class, GetCardDealInfoByBarCodeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "currencyCode", scope = GetCardDealInfoByBarCodeItem.class)
    public JAXBElement<String> createGetCardDealInfoByBarCodeItemCurrencyCode(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemCurrencyCode_QNAME, String.class, GetCardDealInfoByBarCodeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "actualBalance", scope = GetActualBalanceByCardItem.class)
    public JAXBElement<BigDecimal> createGetActualBalanceByCardItemActualBalance(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_GetActualBalanceByCardItemActualBalance_QNAME, BigDecimal.class, GetActualBalanceByCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "phoneNumber", scope = GetAdditionalInstallmentInfoItem.class)
    public JAXBElement<String> createGetAdditionalInstallmentInfoItemPhoneNumber(String value) {
        return new JAXBElement<String>(_GetAdditionalInstallmentInfoItemPhoneNumber_QNAME, String.class, GetAdditionalInstallmentInfoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardId", scope = GetAdditionalInstallmentInfoItem.class)
    public JAXBElement<String> createGetAdditionalInstallmentInfoItemCardId(String value) {
        return new JAXBElement<String>(_GetCardInfoByAccountNoItemCardId_QNAME, String.class, GetAdditionalInstallmentInfoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentId", scope = GetAdditionalInstallmentInfoItem.class)
    public JAXBElement<String> createGetAdditionalInstallmentInfoItemContragentId(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemContragentId_QNAME, String.class, GetAdditionalInstallmentInfoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorMessage", scope = GetAdditionalInstallmentInfoItem.class)
    public JAXBElement<String> createGetAdditionalInstallmentInfoItemErrorMessage(String value) {
        return new JAXBElement<String>(_CancelCardDealItemErrorMessage_QNAME, String.class, GetAdditionalInstallmentInfoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorCode", scope = GetAdditionalInstallmentInfoItem.class)
    public JAXBElement<BigInteger> createGetAdditionalInstallmentInfoItemErrorCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_AnnulateSalaryCardItemErrorCode_QNAME, BigInteger.class, GetAdditionalInstallmentInfoItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "percfeeclassid", scope = GetRateYieldSafeItem.class)
    public JAXBElement<String> createGetRateYieldSafeItemPercfeeclassid(String value) {
        return new JAXBElement<String>(_GetRateYieldSafeItemPercfeeclassid_QNAME, String.class, GetRateYieldSafeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "b", scope = GetRateYieldSafeItem.class)
    public JAXBElement<String> createGetRateYieldSafeItemB(String value) {
        return new JAXBElement<String>(_GetRateYieldSafeItemB_QNAME, String.class, GetRateYieldSafeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "c", scope = GetRateYieldSafeItem.class)
    public JAXBElement<String> createGetRateYieldSafeItemC(String value) {
        return new JAXBElement<String>(_GetRateYieldSafeItemC_QNAME, String.class, GetRateYieldSafeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "a", scope = GetRateYieldSafeItem.class)
    public JAXBElement<String> createGetRateYieldSafeItemA(String value) {
        return new JAXBElement<String>(_GetRateYieldSafeItemA_QNAME, String.class, GetRateYieldSafeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "percfeename", scope = GetRateYieldSafeItem.class)
    public JAXBElement<String> createGetRateYieldSafeItemPercfeename(String value) {
        return new JAXBElement<String>(_GetRateYieldSafeItemPercfeename_QNAME, String.class, GetRateYieldSafeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "d", scope = GetRateYieldSafeItem.class)
    public JAXBElement<String> createGetRateYieldSafeItemD(String value) {
        return new JAXBElement<String>(_GetRateYieldSafeItemD_QNAME, String.class, GetRateYieldSafeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "e", scope = GetRateYieldSafeItem.class)
    public JAXBElement<String> createGetRateYieldSafeItemE(String value) {
        return new JAXBElement<String>(_GetRateYieldSafeItemE_QNAME, String.class, GetRateYieldSafeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "ccy", scope = GetRateYieldSafeItem.class)
    public JAXBElement<String> createGetRateYieldSafeItemCcy(String value) {
        return new JAXBElement<String>(_GetRateYieldSafeItemCcy_QNAME, String.class, GetRateYieldSafeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentId", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemContragentId(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemContragentId_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "courier", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemCourier(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemCourier_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardMask", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemCardMask(String value) {
        return new JAXBElement<String>(_GetStatusMonitoringTransactionsItemCardMask_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dateFileGen", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetCardDeliveryStatusItemDateFileGen(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardDeliveryStatusItemDateFileGen_QNAME, XMLGregorianCalendar.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deliveryCorp", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemDeliveryCorp(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemDeliveryCorp_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dateOnPrint", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetCardDeliveryStatusItemDateOnPrint(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardDeliveryStatusItemDateOnPrint_QNAME, XMLGregorianCalendar.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deliveryHouse", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemDeliveryHouse(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemDeliveryHouse_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "datePerson", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetCardDeliveryStatusItemDatePerson(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardDeliveryStatusItemDatePerson_QNAME, XMLGregorianCalendar.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deliveryDistrictCode", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemDeliveryDistrictCode(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemDeliveryDistrictCode_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "plantDeliveryPointName", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemPlantDeliveryPointName(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemPlantDeliveryPointName_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cityDistrict", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemCityDistrict(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemCityDistrict_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "lastChangeDate", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetCardDeliveryStatusItemLastChangeDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardDeliveryStatusItemLastChangeDate_QNAME, XMLGregorianCalendar.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deliveryStreet", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemDeliveryStreet(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemDeliveryStreet_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deliveryType", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemDeliveryType(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemDeliveryType_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "messageIdPrimaryProcess", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemMessageIdPrimaryProcess(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemMessageIdPrimaryProcess_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deliveryFlat", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemDeliveryFlat(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemDeliveryFlat_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deliveryCityCode", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemDeliveryCityCode(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemDeliveryCityCode_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "plantDeliveryPoint", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemPlantDeliveryPoint(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemPlantDeliveryPoint_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardProject", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemCardProject(String value) {
        return new JAXBElement<String>(_GetStatusMonitoringTransactionsItemCardProject_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deliveryRegionCode", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemDeliveryRegionCode(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemDeliveryRegionCode_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "shopId", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemShopId(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemShopId_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "embCardName", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemEmbCardName(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemEmbCardName_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "renewLabel", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemRenewLabel(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemRenewLabel_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "primaryProcessCode", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemPrimaryProcessCode(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemPrimaryProcessCode_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "urgent", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemUrgent(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemUrgent_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "trackStatusAdd1", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemTrackStatusAdd1(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemTrackStatusAdd1_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "barcode", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemBarcode(String value) {
        return new JAXBElement<String>(_GetCardInfoItemBarcode_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardHash", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemCardHash(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemCardHash_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardDeliveryStatus", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemCardDeliveryStatus(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemCardDeliveryStatus_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deliveryChannel", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemDeliveryChannel(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemDeliveryChannel_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardsCount", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<BigInteger> createGetCardDeliveryStatusItemCardsCount(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardDeliveryStatusItemCardsCount_QNAME, BigInteger.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "fileGenName", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemFileGenName(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemFileGenName_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deliveryStreetType", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemDeliveryStreetType(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemDeliveryStreetType_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dateExp", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetCardDeliveryStatusItemDateExp(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardDeliveryStatusItemDateExp_QNAME, XMLGregorianCalendar.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "chipExist", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemChipExist(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemChipExist_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "manufacturer", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusItemManufacturer(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemManufacturer_QNAME, String.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dateCreate", scope = GetCardDeliveryStatusItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetCardDeliveryStatusItemDateCreate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardDeliveryStatusItemDateCreate_QNAME, XMLGregorianCalendar.class, GetCardDeliveryStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "taxId", scope = GetProjectInfoByProjectIdItem.class)
    public JAXBElement<String> createGetProjectInfoByProjectIdItemTaxId(String value) {
        return new JAXBElement<String>(_CardDealTaxId_QNAME, String.class, GetProjectInfoByProjectIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectRegDate", scope = GetProjectInfoByProjectIdItem.class)
    public JAXBElement<String> createGetProjectInfoByProjectIdItemProjectRegDate(String value) {
        return new JAXBElement<String>(_GetProjectInfoByProjectIdItemProjectRegDate_QNAME, String.class, GetProjectInfoByProjectIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectText", scope = GetProjectInfoByProjectIdItem.class)
    public JAXBElement<String> createGetProjectInfoByProjectIdItemProjectText(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemProjectText_QNAME, String.class, GetProjectInfoByProjectIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorMessage", scope = ChangeStatusMonitoringTransactionsItem.class)
    public JAXBElement<String> createChangeStatusMonitoringTransactionsItemErrorMessage(String value) {
        return new JAXBElement<String>(_CancelCardDealItemErrorMessage_QNAME, String.class, ChangeStatusMonitoringTransactionsItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorCode", scope = ChangeStatusMonitoringTransactionsItem.class)
    public JAXBElement<Long> createChangeStatusMonitoringTransactionsItemErrorCode(Long value) {
        return new JAXBElement<Long>(_AnnulateSalaryCardItemErrorCode_QNAME, Long.class, ChangeStatusMonitoringTransactionsItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "kService", scope = GetCardServiceStatesItem.class)
    public JAXBElement<String> createGetCardServiceStatesItemKService(String value) {
        return new JAXBElement<String>(_GetCardServiceStatesItemKService_QNAME, String.class, GetCardServiceStatesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "finRiskInsurance", scope = GetCardServiceStatesItem.class)
    public JAXBElement<String> createGetCardServiceStatesItemFinRiskInsurance(String value) {
        return new JAXBElement<String>(_GetCardServiceStatesItemFinRiskInsurance_QNAME, String.class, GetCardServiceStatesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accidentInsurance", scope = GetCardServiceStatesItem.class)
    public JAXBElement<String> createGetCardServiceStatesItemAccidentInsurance(String value) {
        return new JAXBElement<String>(_GetCardServiceStatesItemAccidentInsurance_QNAME, String.class, GetCardServiceStatesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "voyage", scope = GetCardServiceStatesItem.class)
    public JAXBElement<String> createGetCardServiceStatesItemVoyage(String value) {
        return new JAXBElement<String>(_GetCardServiceStatesItemVoyage_QNAME, String.class, GetCardServiceStatesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "alfaCheck", scope = GetCardServiceStatesItem.class)
    public JAXBElement<String> createGetCardServiceStatesItemAlfaCheck(String value) {
        return new JAXBElement<String>(_GetCardServiceStatesItemAlfaCheck_QNAME, String.class, GetCardServiceStatesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "newCardId", scope = SetDeferredRenewCardItem.class)
    public JAXBElement<String> createSetDeferredRenewCardItemNewCardId(String value) {
        return new JAXBElement<String>(_SetDeferredRenewCardItemNewCardId_QNAME, String.class, SetDeferredRenewCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errCode", scope = ClientRebindingItem.class)
    public JAXBElement<BigInteger> createClientRebindingItemErrCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_DisableOldCardItemErrCode_QNAME, BigInteger.class, ClientRebindingItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errMessage", scope = ClientRebindingItem.class)
    public JAXBElement<String> createClientRebindingItemErrMessage(String value) {
        return new JAXBElement<String>(_DisableOldCardItemErrMessage_QNAME, String.class, ClientRebindingItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "oSystem", scope = RepaymentInstallmentItem.class)
    public JAXBElement<String> createRepaymentInstallmentItemOSystem(String value) {
        return new JAXBElement<String>(_RepaymentInstallmentItemOSystem_QNAME, String.class, RepaymentInstallmentItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorMessage", scope = RepaymentInstallmentItem.class)
    public JAXBElement<String> createRepaymentInstallmentItemErrorMessage(String value) {
        return new JAXBElement<String>(_CancelCardDealItemErrorMessage_QNAME, String.class, RepaymentInstallmentItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorCode", scope = RepaymentInstallmentItem.class)
    public JAXBElement<Long> createRepaymentInstallmentItemErrorCode(Long value) {
        return new JAXBElement<Long>(_AnnulateSalaryCardItemErrorCode_QNAME, Long.class, RepaymentInstallmentItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "closeDate", scope = CardDeal6 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal6CloseDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealCloseDate_QNAME, XMLGregorianCalendar.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "taxId", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6TaxId(String value) {
        return new JAXBElement<String>(_CardDealTaxId_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statusText", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6StatusText(String value) {
        return new JAXBElement<String>(_CardDealStatusText_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statusId", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6StatusId(String value) {
        return new JAXBElement<String>(_CardDealStatusId_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentId", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6ContragentId(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemContragentId_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "startDate", scope = CardDeal6 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal6StartDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealStartDate_QNAME, XMLGregorianCalendar.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "toboId", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6ToboId(String value) {
        return new JAXBElement<String>(_CardDealToboId_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "tarifPlanText", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6TarifPlanText(String value) {
        return new JAXBElement<String>(_CardDealTarifPlanText_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "currencyCode", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6CurrencyCode(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemCurrencyCode_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectId", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6ProjectId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemProjectId_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isActiveText", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6IsActiveText(String value) {
        return new JAXBElement<String>(_CardDealIsActiveText_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "subProductCode", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6SubProductCode(String value) {
        return new JAXBElement<String>(_CardDealSubProductCode_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "sold", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6Sold(String value) {
        return new JAXBElement<String>(_CardDealSold_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isPersonalized", scope = CardDeal6 .class)
    public JAXBElement<BigInteger> createCardDeal6IsPersonalized(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardDealIsPersonalized_QNAME, BigInteger.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isSalary", scope = CardDeal6 .class)
    public JAXBElement<BigInteger> createCardDeal6IsSalary(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardDealIsSalary_QNAME, BigInteger.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "reportDeliveryModeId", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6ReportDeliveryModeId(String value) {
        return new JAXBElement<String>(_CardDealReportDeliveryModeId_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "segmentCode", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6SegmentCode(String value) {
        return new JAXBElement<String>(_CardDealSegmentCode_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentName", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6ContragentName(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemContragentName_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "tarifPlanId", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6TarifPlanId(String value) {
        return new JAXBElement<String>(_CardDealTarifPlanId_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountNo8030", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6AccountNo8030(String value) {
        return new JAXBElement<String>(_CardDeal6AccountNo8030_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealNo", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6DealNo(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemDealNo_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "emailAddress", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6EmailAddress(String value) {
        return new JAXBElement<String>(_CardDealEmailAddress_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealTypeId", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6DealTypeId(String value) {
        return new JAXBElement<String>(_CardDealDealTypeId_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountNo", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6AccountNo(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemAccountNo_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "expireDate", scope = CardDeal6 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal6ExpireDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardInfoByAccountNoItemExpireDate_QNAME, XMLGregorianCalendar.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "creditLimit", scope = CardDeal6 .class)
    public JAXBElement<Long> createCardDeal6CreditLimit(Long value) {
        return new JAXBElement<Long>(_CardDealCreditLimit_QNAME, Long.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectText", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6ProjectText(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemProjectText_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealId", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6DealId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemDealId_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectType", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6ProjectType(String value) {
        return new JAXBElement<String>(_CardDealProjectType_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealTypeText", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6DealTypeText(String value) {
        return new JAXBElement<String>(_CardDealDealTypeText_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "signDate", scope = CardDeal6 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal6SignDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealSignDate_QNAME, XMLGregorianCalendar.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isActive", scope = CardDeal6 .class)
    public JAXBElement<BigInteger> createCardDeal6IsActive(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardInfoByCardIdItemIsActive_QNAME, BigInteger.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "reportDeliveryAdress", scope = CardDeal6 .class)
    public JAXBElement<String> createCardDeal6ReportDeliveryAdress(String value) {
        return new JAXBElement<String>(_CardDealReportDeliveryAdress_QNAME, String.class, CardDeal6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorMessage", scope = SetInstallmentRepaymentItem.class)
    public JAXBElement<String> createSetInstallmentRepaymentItemErrorMessage(String value) {
        return new JAXBElement<String>(_CancelCardDealItemErrorMessage_QNAME, String.class, SetInstallmentRepaymentItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorCode", scope = SetInstallmentRepaymentItem.class)
    public JAXBElement<BigInteger> createSetInstallmentRepaymentItemErrorCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_AnnulateSalaryCardItemErrorCode_QNAME, BigInteger.class, SetInstallmentRepaymentItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "canChange", scope = GetCardDailyLimitsItem.class)
    public JAXBElement<BigInteger> createGetCardDailyLimitsItemCanChange(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardDailyLimitsItemCanChange_QNAME, BigInteger.class, GetCardDailyLimitsItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "purchaseMaxAmount", scope = GetCardDailyLimitsItem.class)
    public JAXBElement<Long> createGetCardDailyLimitsItemPurchaseMaxAmount(Long value) {
        return new JAXBElement<Long>(_GetCardDailyLimitsItemPurchaseMaxAmount_QNAME, Long.class, GetCardDailyLimitsItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cashMaxAmount", scope = GetCardDailyLimitsItem.class)
    public JAXBElement<Long> createGetCardDailyLimitsItemCashMaxAmount(Long value) {
        return new JAXBElement<Long>(_GetCardDailyLimitsItemCashMaxAmount_QNAME, Long.class, GetCardDailyLimitsItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "purchaseMaxCount", scope = GetCardDailyLimitsItem.class)
    public JAXBElement<BigInteger> createGetCardDailyLimitsItemPurchaseMaxCount(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardDailyLimitsItemPurchaseMaxCount_QNAME, BigInteger.class, GetCardDailyLimitsItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "totalMaxCount", scope = GetCardDailyLimitsItem.class)
    public JAXBElement<BigInteger> createGetCardDailyLimitsItemTotalMaxCount(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardDailyLimitsItemTotalMaxCount_QNAME, BigInteger.class, GetCardDailyLimitsItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "endDate", scope = GetCardDailyLimitsItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetCardDailyLimitsItemEndDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardDailyLimitsItemEndDate_QNAME, XMLGregorianCalendar.class, GetCardDailyLimitsItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "totalMaxAmount", scope = GetCardDailyLimitsItem.class)
    public JAXBElement<Long> createGetCardDailyLimitsItemTotalMaxAmount(Long value) {
        return new JAXBElement<Long>(_GetCardDailyLimitsItemTotalMaxAmount_QNAME, Long.class, GetCardDailyLimitsItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cashMaxCount", scope = GetCardDailyLimitsItem.class)
    public JAXBElement<BigInteger> createGetCardDailyLimitsItemCashMaxCount(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardDailyLimitsItemCashMaxCount_QNAME, BigInteger.class, GetCardDailyLimitsItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "text", scope = ReportLine.class)
    public JAXBElement<String> createReportLineText(String value) {
        return new JAXBElement<String>(_GetCardManufacturersItemText_QNAME, String.class, ReportLine.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "o_Projectid", scope = GetProjectInfoByAgrtplnameItem.class)
    public JAXBElement<String> createGetProjectInfoByAgrtplnameItemOProjectid(String value) {
        return new JAXBElement<String>(_GetProjectInfoByAgrtplnameItemOProjectid_QNAME, String.class, GetProjectInfoByAgrtplnameItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "o_Orgname", scope = GetProjectInfoByAgrtplnameItem.class)
    public JAXBElement<String> createGetProjectInfoByAgrtplnameItemOOrgname(String value) {
        return new JAXBElement<String>(_GetProjectInfoByAgrtplnameItemOOrgname_QNAME, String.class, GetProjectInfoByAgrtplnameItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "o_Blocked", scope = GetProjectInfoByAgrtplnameItem.class)
    public JAXBElement<String> createGetProjectInfoByAgrtplnameItemOBlocked(String value) {
        return new JAXBElement<String>(_GetProjectInfoByAgrtplnameItemOBlocked_QNAME, String.class, GetProjectInfoByAgrtplnameItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "o_Prefixid", scope = GetProjectInfoByAgrtplnameItem.class)
    public JAXBElement<String> createGetProjectInfoByAgrtplnameItemOPrefixid(String value) {
        return new JAXBElement<String>(_GetProjectInfoByAgrtplnameItemOPrefixid_QNAME, String.class, GetProjectInfoByAgrtplnameItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "o_Agrtplid", scope = GetProjectInfoByAgrtplnameItem.class)
    public JAXBElement<String> createGetProjectInfoByAgrtplnameItemOAgrtplid(String value) {
        return new JAXBElement<String>(_GetProjectInfoByAgrtplnameItemOAgrtplid_QNAME, String.class, GetProjectInfoByAgrtplnameItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "o_Perccondid", scope = GetProjectInfoByAgrtplnameItem.class)
    public JAXBElement<String> createGetProjectInfoByAgrtplnameItemOPerccondid(String value) {
        return new JAXBElement<String>(_GetProjectInfoByAgrtplnameItemOPerccondid_QNAME, String.class, GetProjectInfoByAgrtplnameItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "o_Ccycharid", scope = GetProjectInfoByAgrtplnameItem.class)
    public JAXBElement<String> createGetProjectInfoByAgrtplnameItemOCcycharid(String value) {
        return new JAXBElement<String>(_GetProjectInfoByAgrtplnameItemOCcycharid_QNAME, String.class, GetProjectInfoByAgrtplnameItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "o_Condid", scope = GetProjectInfoByAgrtplnameItem.class)
    public JAXBElement<String> createGetProjectInfoByAgrtplnameItemOCondid(String value) {
        return new JAXBElement<String>(_GetProjectInfoByAgrtplnameItemOCondid_QNAME, String.class, GetProjectInfoByAgrtplnameItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "o_Projectname", scope = GetProjectInfoByAgrtplnameItem.class)
    public JAXBElement<String> createGetProjectInfoByAgrtplnameItemOProjectname(String value) {
        return new JAXBElement<String>(_GetProjectInfoByAgrtplnameItemOProjectname_QNAME, String.class, GetProjectInfoByAgrtplnameItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "o_Codecardid", scope = GetProjectInfoByAgrtplnameItem.class)
    public JAXBElement<String> createGetProjectInfoByAgrtplnameItemOCodecardid(String value) {
        return new JAXBElement<String>(_GetProjectInfoByAgrtplnameItemOCodecardid_QNAME, String.class, GetProjectInfoByAgrtplnameItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorMessage", scope = GetDNDStatusItem.class)
    public JAXBElement<String> createGetDNDStatusItemErrorMessage(String value) {
        return new JAXBElement<String>(_CancelCardDealItemErrorMessage_QNAME, String.class, GetDNDStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorCode", scope = GetDNDStatusItem.class)
    public JAXBElement<BigInteger> createGetDNDStatusItemErrorCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_AnnulateSalaryCardItemErrorCode_QNAME, BigInteger.class, GetDNDStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "status", scope = GetDNDStatusItem.class)
    public JAXBElement<BigInteger> createGetDNDStatusItemStatus(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetDNDStatusItemStatus_QNAME, BigInteger.class, GetDNDStatusItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "closeDate", scope = CardDeal2 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal2CloseDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealCloseDate_QNAME, XMLGregorianCalendar.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "taxId", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2TaxId(String value) {
        return new JAXBElement<String>(_CardDealTaxId_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statusText", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2StatusText(String value) {
        return new JAXBElement<String>(_CardDealStatusText_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statusId", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2StatusId(String value) {
        return new JAXBElement<String>(_CardDealStatusId_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentId", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2ContragentId(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemContragentId_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "startDate", scope = CardDeal2 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal2StartDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealStartDate_QNAME, XMLGregorianCalendar.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "toboId", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2ToboId(String value) {
        return new JAXBElement<String>(_CardDealToboId_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "tarifPlanText", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2TarifPlanText(String value) {
        return new JAXBElement<String>(_CardDealTarifPlanText_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "currencyCode", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2CurrencyCode(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemCurrencyCode_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectId", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2ProjectId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemProjectId_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isActiveText", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2IsActiveText(String value) {
        return new JAXBElement<String>(_CardDealIsActiveText_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "subProductCode", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2SubProductCode(String value) {
        return new JAXBElement<String>(_CardDealSubProductCode_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "sold", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2Sold(String value) {
        return new JAXBElement<String>(_CardDealSold_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isPersonalized", scope = CardDeal2 .class)
    public JAXBElement<BigInteger> createCardDeal2IsPersonalized(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardDealIsPersonalized_QNAME, BigInteger.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isSalary", scope = CardDeal2 .class)
    public JAXBElement<BigInteger> createCardDeal2IsSalary(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardDealIsSalary_QNAME, BigInteger.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "reportDeliveryModeId", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2ReportDeliveryModeId(String value) {
        return new JAXBElement<String>(_CardDealReportDeliveryModeId_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "segmentCode", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2SegmentCode(String value) {
        return new JAXBElement<String>(_CardDealSegmentCode_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentName", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2ContragentName(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemContragentName_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "tarifPlanId", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2TarifPlanId(String value) {
        return new JAXBElement<String>(_CardDealTarifPlanId_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountNo8030", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2AccountNo8030(String value) {
        return new JAXBElement<String>(_CardDeal6AccountNo8030_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealNo", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2DealNo(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemDealNo_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "emailAddress", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2EmailAddress(String value) {
        return new JAXBElement<String>(_CardDealEmailAddress_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealTypeId", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2DealTypeId(String value) {
        return new JAXBElement<String>(_CardDealDealTypeId_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountNo", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2AccountNo(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemAccountNo_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "expireDate", scope = CardDeal2 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal2ExpireDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardInfoByAccountNoItemExpireDate_QNAME, XMLGregorianCalendar.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "creditLimit", scope = CardDeal2 .class)
    public JAXBElement<Long> createCardDeal2CreditLimit(Long value) {
        return new JAXBElement<Long>(_CardDealCreditLimit_QNAME, Long.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectText", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2ProjectText(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemProjectText_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealId", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2DealId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemDealId_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectType", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2ProjectType(String value) {
        return new JAXBElement<String>(_CardDealProjectType_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealTypeText", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2DealTypeText(String value) {
        return new JAXBElement<String>(_CardDealDealTypeText_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "signDate", scope = CardDeal2 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal2SignDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealSignDate_QNAME, XMLGregorianCalendar.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isActive", scope = CardDeal2 .class)
    public JAXBElement<BigInteger> createCardDeal2IsActive(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardInfoByCardIdItemIsActive_QNAME, BigInteger.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "reportDeliveryAdress", scope = CardDeal2 .class)
    public JAXBElement<String> createCardDeal2ReportDeliveryAdress(String value) {
        return new JAXBElement<String>(_CardDealReportDeliveryAdress_QNAME, String.class, CardDeal2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statusMessage", scope = CheckCardActivationItem.class)
    public JAXBElement<String> createCheckCardActivationItemStatusMessage(String value) {
        return new JAXBElement<String>(_CheckCardActivationItemStatusMessage_QNAME, String.class, CheckCardActivationItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "status", scope = CheckCardActivationItem.class)
    public JAXBElement<BigInteger> createCheckCardActivationItemStatus(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetDNDStatusItemStatus_QNAME, BigInteger.class, CheckCardActivationItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "result", scope = GetAvailIdArrayItem.class)
    public JAXBElement<String> createGetAvailIdArrayItemResult(String value) {
        return new JAXBElement<String>(_CheckCodeWordItemResult_QNAME, String.class, GetAvailIdArrayItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardNum", scope = GetDeliveryCardByMessageIdItem.class)
    public JAXBElement<String> createGetDeliveryCardByMessageIdItemCardNum(String value) {
        return new JAXBElement<String>(_GetDeliveryCardByMessageIdItemCardNum_QNAME, String.class, GetDeliveryCardByMessageIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errDescription", scope = GetDeliveryCardByMessageIdItem.class)
    public JAXBElement<String> createGetDeliveryCardByMessageIdItemErrDescription(String value) {
        return new JAXBElement<String>(_GetDeliveryCardByMessageIdItemErrDescription_QNAME, String.class, GetDeliveryCardByMessageIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errCode", scope = GetDeliveryCardByMessageIdItem.class)
    public JAXBElement<BigInteger> createGetDeliveryCardByMessageIdItemErrCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_DisableOldCardItemErrCode_QNAME, BigInteger.class, GetDeliveryCardByMessageIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectName", scope = GetDeliveryCardByMessageIdItem.class)
    public JAXBElement<String> createGetDeliveryCardByMessageIdItemProjectName(String value) {
        return new JAXBElement<String>(_GetDeliveryCardByMessageIdItemProjectName_QNAME, String.class, GetDeliveryCardByMessageIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isAlfaChoiseEnable", scope = CheckAlfaChoiseEnableItem.class)
    public JAXBElement<BigInteger> createCheckAlfaChoiseEnableItemIsAlfaChoiseEnable(BigInteger value) {
        return new JAXBElement<BigInteger>(_CheckAlfaChoiseEnableItemIsAlfaChoiseEnable_QNAME, BigInteger.class, CheckAlfaChoiseEnableItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "closeDate", scope = CardDeal3 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal3CloseDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealCloseDate_QNAME, XMLGregorianCalendar.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "taxId", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3TaxId(String value) {
        return new JAXBElement<String>(_CardDealTaxId_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statusText", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3StatusText(String value) {
        return new JAXBElement<String>(_CardDealStatusText_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statusId", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3StatusId(String value) {
        return new JAXBElement<String>(_CardDealStatusId_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentId", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3ContragentId(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemContragentId_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "startDate", scope = CardDeal3 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal3StartDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealStartDate_QNAME, XMLGregorianCalendar.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "toboId", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3ToboId(String value) {
        return new JAXBElement<String>(_CardDealToboId_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "tarifPlanText", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3TarifPlanText(String value) {
        return new JAXBElement<String>(_CardDealTarifPlanText_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "currencyCode", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3CurrencyCode(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemCurrencyCode_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectId", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3ProjectId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemProjectId_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isActiveText", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3IsActiveText(String value) {
        return new JAXBElement<String>(_CardDealIsActiveText_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "subProductCode", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3SubProductCode(String value) {
        return new JAXBElement<String>(_CardDealSubProductCode_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "sold", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3Sold(String value) {
        return new JAXBElement<String>(_CardDealSold_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isPersonalized", scope = CardDeal3 .class)
    public JAXBElement<BigInteger> createCardDeal3IsPersonalized(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardDealIsPersonalized_QNAME, BigInteger.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isSalary", scope = CardDeal3 .class)
    public JAXBElement<BigInteger> createCardDeal3IsSalary(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardDealIsSalary_QNAME, BigInteger.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "reportDeliveryModeId", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3ReportDeliveryModeId(String value) {
        return new JAXBElement<String>(_CardDealReportDeliveryModeId_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "segmentCode", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3SegmentCode(String value) {
        return new JAXBElement<String>(_CardDealSegmentCode_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentName", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3ContragentName(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemContragentName_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "tarifPlanId", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3TarifPlanId(String value) {
        return new JAXBElement<String>(_CardDealTarifPlanId_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountNo8030", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3AccountNo8030(String value) {
        return new JAXBElement<String>(_CardDeal6AccountNo8030_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealNo", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3DealNo(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemDealNo_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "emailAddress", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3EmailAddress(String value) {
        return new JAXBElement<String>(_CardDealEmailAddress_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealTypeId", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3DealTypeId(String value) {
        return new JAXBElement<String>(_CardDealDealTypeId_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountNo", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3AccountNo(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemAccountNo_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "expireDate", scope = CardDeal3 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal3ExpireDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardInfoByAccountNoItemExpireDate_QNAME, XMLGregorianCalendar.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "creditLimit", scope = CardDeal3 .class)
    public JAXBElement<Long> createCardDeal3CreditLimit(Long value) {
        return new JAXBElement<Long>(_CardDealCreditLimit_QNAME, Long.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectText", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3ProjectText(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemProjectText_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealId", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3DealId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemDealId_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectType", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3ProjectType(String value) {
        return new JAXBElement<String>(_CardDealProjectType_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealTypeText", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3DealTypeText(String value) {
        return new JAXBElement<String>(_CardDealDealTypeText_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "signDate", scope = CardDeal3 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal3SignDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealSignDate_QNAME, XMLGregorianCalendar.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isActive", scope = CardDeal3 .class)
    public JAXBElement<BigInteger> createCardDeal3IsActive(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardInfoByCardIdItemIsActive_QNAME, BigInteger.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "reportDeliveryAdress", scope = CardDeal3 .class)
    public JAXBElement<String> createCardDeal3ReportDeliveryAdress(String value) {
        return new JAXBElement<String>(_CardDealReportDeliveryAdress_QNAME, String.class, CardDeal3 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "canChange", scope = CheckPinChangeItem.class)
    public JAXBElement<BigInteger> createCheckPinChangeItemCanChange(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardDailyLimitsItemCanChange_QNAME, BigInteger.class, CheckPinChangeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "reason", scope = CheckPinChangeItem.class)
    public JAXBElement<String> createCheckPinChangeItemReason(String value) {
        return new JAXBElement<String>(_CheckPinChangeItemReason_QNAME, String.class, CheckPinChangeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "changeCount", scope = CheckPinChangeItem.class)
    public JAXBElement<BigInteger> createCheckPinChangeItemChangeCount(BigInteger value) {
        return new JAXBElement<BigInteger>(_CheckPinChangeItemChangeCount_QNAME, BigInteger.class, CheckPinChangeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "code", scope = ActivateCardStatus.class)
    public JAXBElement<String> createActivateCardStatusCode(String value) {
        return new JAXBElement<String>(_GetCardManufacturersItemCode_QNAME, String.class, ActivateCardStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "smsText", scope = ActivateCardStatus.class)
    public JAXBElement<String> createActivateCardStatusSmsText(String value) {
        return new JAXBElement<String>(_ActivateCardStatusSmsText_QNAME, String.class, ActivateCardStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "message", scope = ActivateCardStatus.class)
    public JAXBElement<String> createActivateCardStatusMessage(String value) {
        return new JAXBElement<String>(_ActivateCardStatusMessage_QNAME, String.class, ActivateCardStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "xmlStatment", scope = GetStatementItem.class)
    public JAXBElement<String> createGetStatementItemXmlStatment(String value) {
        return new JAXBElement<String>(_GetStatementItemXmlStatment_QNAME, String.class, GetStatementItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "closeDate", scope = CardDeal7 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal7CloseDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealCloseDate_QNAME, XMLGregorianCalendar.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "taxId", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7TaxId(String value) {
        return new JAXBElement<String>(_CardDealTaxId_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statusText", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7StatusText(String value) {
        return new JAXBElement<String>(_CardDealStatusText_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statusId", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7StatusId(String value) {
        return new JAXBElement<String>(_CardDealStatusId_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentId", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7ContragentId(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemContragentId_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "startDate", scope = CardDeal7 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal7StartDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealStartDate_QNAME, XMLGregorianCalendar.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "toboId", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7ToboId(String value) {
        return new JAXBElement<String>(_CardDealToboId_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "tarifPlanText", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7TarifPlanText(String value) {
        return new JAXBElement<String>(_CardDealTarifPlanText_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "currencyCode", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7CurrencyCode(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemCurrencyCode_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectId", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7ProjectId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemProjectId_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isActiveText", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7IsActiveText(String value) {
        return new JAXBElement<String>(_CardDealIsActiveText_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "subProductCode", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7SubProductCode(String value) {
        return new JAXBElement<String>(_CardDealSubProductCode_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "sold", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7Sold(String value) {
        return new JAXBElement<String>(_CardDealSold_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isPersonalized", scope = CardDeal7 .class)
    public JAXBElement<BigInteger> createCardDeal7IsPersonalized(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardDealIsPersonalized_QNAME, BigInteger.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isSalary", scope = CardDeal7 .class)
    public JAXBElement<BigInteger> createCardDeal7IsSalary(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardDealIsSalary_QNAME, BigInteger.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "reportDeliveryModeId", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7ReportDeliveryModeId(String value) {
        return new JAXBElement<String>(_CardDealReportDeliveryModeId_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "segmentCode", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7SegmentCode(String value) {
        return new JAXBElement<String>(_CardDealSegmentCode_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentName", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7ContragentName(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemContragentName_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "tarifPlanId", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7TarifPlanId(String value) {
        return new JAXBElement<String>(_CardDealTarifPlanId_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealNo", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7DealNo(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemDealNo_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "emailAddress", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7EmailAddress(String value) {
        return new JAXBElement<String>(_CardDealEmailAddress_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealTypeId", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7DealTypeId(String value) {
        return new JAXBElement<String>(_CardDealDealTypeId_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountNo", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7AccountNo(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemAccountNo_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "expireDate", scope = CardDeal7 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal7ExpireDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardInfoByAccountNoItemExpireDate_QNAME, XMLGregorianCalendar.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "creditLimit", scope = CardDeal7 .class)
    public JAXBElement<Long> createCardDeal7CreditLimit(Long value) {
        return new JAXBElement<Long>(_CardDealCreditLimit_QNAME, Long.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectText", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7ProjectText(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemProjectText_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealId", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7DealId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemDealId_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectType", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7ProjectType(String value) {
        return new JAXBElement<String>(_CardDealProjectType_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealTypeText", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7DealTypeText(String value) {
        return new JAXBElement<String>(_CardDealDealTypeText_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "signDate", scope = CardDeal7 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal7SignDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealSignDate_QNAME, XMLGregorianCalendar.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isActive", scope = CardDeal7 .class)
    public JAXBElement<BigInteger> createCardDeal7IsActive(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardInfoByCardIdItemIsActive_QNAME, BigInteger.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "reportDeliveryAdress", scope = CardDeal7 .class)
    public JAXBElement<String> createCardDeal7ReportDeliveryAdress(String value) {
        return new JAXBElement<String>(_CardDealReportDeliveryAdress_QNAME, String.class, CardDeal7 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "closeDate", scope = CardDeal5 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal5CloseDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealCloseDate_QNAME, XMLGregorianCalendar.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "taxId", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5TaxId(String value) {
        return new JAXBElement<String>(_CardDealTaxId_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statusText", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5StatusText(String value) {
        return new JAXBElement<String>(_CardDealStatusText_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statusId", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5StatusId(String value) {
        return new JAXBElement<String>(_CardDealStatusId_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentId", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5ContragentId(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemContragentId_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "startDate", scope = CardDeal5 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal5StartDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealStartDate_QNAME, XMLGregorianCalendar.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "toboId", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5ToboId(String value) {
        return new JAXBElement<String>(_CardDealToboId_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "tarifPlanText", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5TarifPlanText(String value) {
        return new JAXBElement<String>(_CardDealTarifPlanText_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "currencyCode", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5CurrencyCode(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemCurrencyCode_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectId", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5ProjectId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemProjectId_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isActiveText", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5IsActiveText(String value) {
        return new JAXBElement<String>(_CardDealIsActiveText_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "subProductCode", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5SubProductCode(String value) {
        return new JAXBElement<String>(_CardDealSubProductCode_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "sold", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5Sold(String value) {
        return new JAXBElement<String>(_CardDealSold_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isPersonalized", scope = CardDeal5 .class)
    public JAXBElement<BigInteger> createCardDeal5IsPersonalized(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardDealIsPersonalized_QNAME, BigInteger.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isSalary", scope = CardDeal5 .class)
    public JAXBElement<BigInteger> createCardDeal5IsSalary(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardDealIsSalary_QNAME, BigInteger.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "reportDeliveryModeId", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5ReportDeliveryModeId(String value) {
        return new JAXBElement<String>(_CardDealReportDeliveryModeId_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "segmentCode", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5SegmentCode(String value) {
        return new JAXBElement<String>(_CardDealSegmentCode_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentName", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5ContragentName(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemContragentName_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "tarifPlanId", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5TarifPlanId(String value) {
        return new JAXBElement<String>(_CardDealTarifPlanId_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealNo", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5DealNo(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemDealNo_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "emailAddress", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5EmailAddress(String value) {
        return new JAXBElement<String>(_CardDealEmailAddress_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealTypeId", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5DealTypeId(String value) {
        return new JAXBElement<String>(_CardDealDealTypeId_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountNo", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5AccountNo(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemAccountNo_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "expireDate", scope = CardDeal5 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal5ExpireDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardInfoByAccountNoItemExpireDate_QNAME, XMLGregorianCalendar.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "creditLimit", scope = CardDeal5 .class)
    public JAXBElement<Long> createCardDeal5CreditLimit(Long value) {
        return new JAXBElement<Long>(_CardDealCreditLimit_QNAME, Long.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectText", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5ProjectText(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemProjectText_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealId", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5DealId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemDealId_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectType", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5ProjectType(String value) {
        return new JAXBElement<String>(_CardDealProjectType_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealTypeText", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5DealTypeText(String value) {
        return new JAXBElement<String>(_CardDealDealTypeText_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "signDate", scope = CardDeal5 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal5SignDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealSignDate_QNAME, XMLGregorianCalendar.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isActive", scope = CardDeal5 .class)
    public JAXBElement<BigInteger> createCardDeal5IsActive(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardInfoByCardIdItemIsActive_QNAME, BigInteger.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "reportDeliveryAdress", scope = CardDeal5 .class)
    public JAXBElement<String> createCardDeal5ReportDeliveryAdress(String value) {
        return new JAXBElement<String>(_CardDealReportDeliveryAdress_QNAME, String.class, CardDeal5 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentId", scope = GetSalaryCreditTurnoverItem.class)
    public JAXBElement<String> createGetSalaryCreditTurnoverItemContragentId(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemContragentId_QNAME, String.class, GetSalaryCreditTurnoverItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "creditTurnover", scope = GetSalaryCreditTurnoverItem.class)
    public JAXBElement<Long> createGetSalaryCreditTurnoverItemCreditTurnover(Long value) {
        return new JAXBElement<Long>(_GetSalaryCreditTurnoverItemCreditTurnover_QNAME, Long.class, GetSalaryCreditTurnoverItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "calculationDate", scope = GetSalaryCreditTurnoverItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetSalaryCreditTurnoverItemCalculationDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetSalaryCreditTurnoverItemCalculationDate_QNAME, XMLGregorianCalendar.class, GetSalaryCreditTurnoverItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "currencyCode", scope = GetSalaryCreditTurnoverItem.class)
    public JAXBElement<String> createGetSalaryCreditTurnoverItemCurrencyCode(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemCurrencyCode_QNAME, String.class, GetSalaryCreditTurnoverItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "equalAmount", scope = CheckInstallmentAvailabilityItem.class)
    public JAXBElement<String> createCheckInstallmentAvailabilityItemEqualAmount(String value) {
        return new JAXBElement<String>(_ProcessInstallmentItemEqualAmount_QNAME, String.class, CheckInstallmentAvailabilityItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "result", scope = CheckInstallmentAvailabilityItem.class)
    public JAXBElement<BigInteger> createCheckInstallmentAvailabilityItemResult(BigInteger value) {
        return new JAXBElement<BigInteger>(_CheckCodeWordItemResult_QNAME, BigInteger.class, CheckInstallmentAvailabilityItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "transactionSum", scope = CheckInstallmentAvailabilityItem.class)
    public JAXBElement<String> createCheckInstallmentAvailabilityItemTransactionSum(String value) {
        return new JAXBElement<String>(_ProcessInstallmentItemTransactionSum_QNAME, String.class, CheckInstallmentAvailabilityItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorMessage", scope = CheckInstallmentAvailabilityItem.class)
    public JAXBElement<String> createCheckInstallmentAvailabilityItemErrorMessage(String value) {
        return new JAXBElement<String>(_CancelCardDealItemErrorMessage_QNAME, String.class, CheckInstallmentAvailabilityItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorCode", scope = CheckInstallmentAvailabilityItem.class)
    public JAXBElement<BigInteger> createCheckInstallmentAvailabilityItemErrorCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_AnnulateSalaryCardItemErrorCode_QNAME, BigInteger.class, CheckInstallmentAvailabilityItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "transactionId", scope = CheckInstallmentAvailabilityItem.class)
    public JAXBElement<String> createCheckInstallmentAvailabilityItemTransactionId(String value) {
        return new JAXBElement<String>(_CheckInstallmentAvailabilityItemTransactionId_QNAME, String.class, CheckInstallmentAvailabilityItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "equalAvlAmountOut", scope = CheckInstallmentAvailabilityItem.class)
    public JAXBElement<String> createCheckInstallmentAvailabilityItemEqualAvlAmountOut(String value) {
        return new JAXBElement<String>(_ProcessInstallmentItemEqualAvlAmountOut_QNAME, String.class, CheckInstallmentAvailabilityItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "uid", scope = GetUPCSessionUIDItem.class)
    public JAXBElement<BigInteger> createGetUPCSessionUIDItemUid(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetUPCSessionUIDItemUid_QNAME, BigInteger.class, GetUPCSessionUIDItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dbFilesList", scope = GetDBFilesListItem.class)
    public JAXBElement<String> createGetDBFilesListItemDbFilesList(String value) {
        return new JAXBElement<String>(_GetDBFilesListItemDbFilesList_QNAME, String.class, GetDBFilesListItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "subProductCode", scope = GetSubproductAttributesItem.class)
    public JAXBElement<String> createGetSubproductAttributesItemSubProductCode(String value) {
        return new JAXBElement<String>(_CardDealSubProductCode_QNAME, String.class, GetSubproductAttributesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "split", scope = GetSubproductAttributesItem.class)
    public JAXBElement<String> createGetSubproductAttributesItemSplit(String value) {
        return new JAXBElement<String>(_GetSubproductAttributesItemSplit_QNAME, String.class, GetSubproductAttributesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "premium", scope = GetSubproductAttributesItem.class)
    public JAXBElement<String> createGetSubproductAttributesItemPremium(String value) {
        return new JAXBElement<String>(_GetSubproductAttributesItemPremium_QNAME, String.class, GetSubproductAttributesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "kService", scope = GetSubproductAttributesItem.class)
    public JAXBElement<String> createGetSubproductAttributesItemKService(String value) {
        return new JAXBElement<String>(_GetCardServiceStatesItemKService_QNAME, String.class, GetSubproductAttributesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "subProductGroup", scope = GetSubproductAttributesItem.class)
    public JAXBElement<String> createGetSubproductAttributesItemSubProductGroup(String value) {
        return new JAXBElement<String>(_GetSubproductAttributesItemSubProductGroup_QNAME, String.class, GetSubproductAttributesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "subProductName", scope = GetSubproductAttributesItem.class)
    public JAXBElement<String> createGetSubproductAttributesItemSubProductName(String value) {
        return new JAXBElement<String>(_GetSubproductAttributesItemSubProductName_QNAME, String.class, GetSubproductAttributesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "loyaltyCode", scope = GetSubproductAttributesItem.class)
    public JAXBElement<String> createGetSubproductAttributesItemLoyaltyCode(String value) {
        return new JAXBElement<String>(_GetSubproductAttributesItemLoyaltyCode_QNAME, String.class, GetSubproductAttributesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "finRiskInsurance", scope = GetSubproductAttributesItem.class)
    public JAXBElement<String> createGetSubproductAttributesItemFinRiskInsurance(String value) {
        return new JAXBElement<String>(_GetCardServiceStatesItemFinRiskInsurance_QNAME, String.class, GetSubproductAttributesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accidentInsurance", scope = GetSubproductAttributesItem.class)
    public JAXBElement<String> createGetSubproductAttributesItemAccidentInsurance(String value) {
        return new JAXBElement<String>(_GetCardServiceStatesItemAccidentInsurance_QNAME, String.class, GetSubproductAttributesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "voyage", scope = GetSubproductAttributesItem.class)
    public JAXBElement<String> createGetSubproductAttributesItemVoyage(String value) {
        return new JAXBElement<String>(_GetCardServiceStatesItemVoyage_QNAME, String.class, GetSubproductAttributesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "actualProduct", scope = GetSubproductAttributesItem.class)
    public JAXBElement<String> createGetSubproductAttributesItemActualProduct(String value) {
        return new JAXBElement<String>(_GetSubproductAttributesItemActualProduct_QNAME, String.class, GetSubproductAttributesItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "balanceAmountCash", scope = GetCardAccountBalanceItem.class)
    public JAXBElement<String> createGetCardAccountBalanceItemBalanceAmountCash(String value) {
        return new JAXBElement<String>(_GetCardAccountBalanceItemBalanceAmountCash_QNAME, String.class, GetCardAccountBalanceItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "balanceAmountPos", scope = GetCardAccountBalanceItem.class)
    public JAXBElement<String> createGetCardAccountBalanceItemBalanceAmountPos(String value) {
        return new JAXBElement<String>(_GetCardAccountBalanceItemBalanceAmountPos_QNAME, String.class, GetCardAccountBalanceItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "responseCode", scope = GetCardAccountBalanceItem.class)
    public JAXBElement<String> createGetCardAccountBalanceItemResponseCode(String value) {
        return new JAXBElement<String>(_GetTransactionHistoryItemResponseCode_QNAME, String.class, GetCardAccountBalanceItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "balanceAmount", scope = GetCardAccountBalanceItem.class)
    public JAXBElement<String> createGetCardAccountBalanceItemBalanceAmount(String value) {
        return new JAXBElement<String>(_GetCardAccountBalanceItemBalanceAmount_QNAME, String.class, GetCardAccountBalanceItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errCode", scope = ReissueCardWithNewSubproductCodeItem.class)
    public JAXBElement<String> createReissueCardWithNewSubproductCodeItemErrCode(String value) {
        return new JAXBElement<String>(_DisableOldCardItemErrCode_QNAME, String.class, ReissueCardWithNewSubproductCodeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errMessage", scope = ReissueCardWithNewSubproductCodeItem.class)
    public JAXBElement<String> createReissueCardWithNewSubproductCodeItemErrMessage(String value) {
        return new JAXBElement<String>(_DisableOldCardItemErrMessage_QNAME, String.class, ReissueCardWithNewSubproductCodeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "newCardId", scope = ReissueCardWithNewSubproductCodeItem.class)
    public JAXBElement<String> createReissueCardWithNewSubproductCodeItemNewCardId(String value) {
        return new JAXBElement<String>(_SetDeferredRenewCardItemNewCardId_QNAME, String.class, ReissueCardWithNewSubproductCodeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "interestRate", scope = GetInstallmentProductItem.class)
    public JAXBElement<BigDecimal> createGetInstallmentProductItemInterestRate(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_GetInstallmentProductItemInterestRate_QNAME, BigDecimal.class, GetInstallmentProductItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "amountRange", scope = GetInstallmentProductItem.class)
    public JAXBElement<String> createGetInstallmentProductItemAmountRange(String value) {
        return new JAXBElement<String>(_GetInstallmentProductItemAmountRange_QNAME, String.class, GetInstallmentProductItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "term", scope = GetInstallmentProductItem.class)
    public JAXBElement<BigInteger> createGetInstallmentProductItemTerm(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetInstallmentProductItemTerm_QNAME, BigInteger.class, GetInstallmentProductItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "payment", scope = GetInstallmentProductItem.class)
    public JAXBElement<BigInteger> createGetInstallmentProductItemPayment(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetInstallmentProductItemPayment_QNAME, BigInteger.class, GetInstallmentProductItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "subproductCode", scope = GetInstallmentProductItem.class)
    public JAXBElement<String> createGetInstallmentProductItemSubproductCode(String value) {
        return new JAXBElement<String>(_GetCurrentNewSubproductItemSubproductCode_QNAME, String.class, GetInstallmentProductItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardRiskClassId", scope = GetAvailableAddCardItem.class)
    public JAXBElement<String> createGetAvailableAddCardItemCardRiskClassId(String value) {
        return new JAXBElement<String>(_SetCardDailyLimitsItemCardRiskClassId_QNAME, String.class, GetAvailableAddCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "codeCardId", scope = GetAvailableAddCardItem.class)
    public JAXBElement<String> createGetAvailableAddCardItemCodeCardId(String value) {
        return new JAXBElement<String>(_CardCodeCardId_QNAME, String.class, GetAvailableAddCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "prefixName", scope = GetAvailableAddCardItem.class)
    public JAXBElement<String> createGetAvailableAddCardItemPrefixName(String value) {
        return new JAXBElement<String>(_GetAvailableAddCardItemPrefixName_QNAME, String.class, GetAvailableAddCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardName", scope = GetAvailableAddCardItem.class)
    public JAXBElement<String> createGetAvailableAddCardItemCardName(String value) {
        return new JAXBElement<String>(_GetStatusMonitoringTransactionsItemCardName_QNAME, String.class, GetAvailableAddCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardRiskClassName", scope = GetAvailableAddCardItem.class)
    public JAXBElement<String> createGetAvailableAddCardItemCardRiskClassName(String value) {
        return new JAXBElement<String>(_GetAvailableAddCardItemCardRiskClassName_QNAME, String.class, GetAvailableAddCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "authRangeId", scope = GetAvailableAddCardItem.class)
    public JAXBElement<String> createGetAvailableAddCardItemAuthRangeId(String value) {
        return new JAXBElement<String>(_GetAvailableAddCardItemAuthRangeId_QNAME, String.class, GetAvailableAddCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "prefixId", scope = GetAvailableAddCardItem.class)
    public JAXBElement<String> createGetAvailableAddCardItemPrefixId(String value) {
        return new JAXBElement<String>(_GetAvailableAddCardItemPrefixId_QNAME, String.class, GetAvailableAddCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "authRangeName", scope = GetAvailableAddCardItem.class)
    public JAXBElement<String> createGetAvailableAddCardItemAuthRangeName(String value) {
        return new JAXBElement<String>(_GetAvailableAddCardItemAuthRangeName_QNAME, String.class, GetAvailableAddCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "nameIPS", scope = GetIPSItem.class)
    public JAXBElement<String> createGetIPSItemNameIPS(String value) {
        return new JAXBElement<String>(_GetIPSItemNameIPS_QNAME, String.class, GetIPSItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "codeIPS", scope = GetIPSItem.class)
    public JAXBElement<String> createGetIPSItemCodeIPS(String value) {
        return new JAXBElement<String>(_GetIPSItemCodeIPS_QNAME, String.class, GetIPSItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "phoneNumber", scope = GetCardInfoShortItem.class)
    public JAXBElement<String> createGetCardInfoShortItemPhoneNumber(String value) {
        return new JAXBElement<String>(_GetAdditionalInstallmentInfoItemPhoneNumber_QNAME, String.class, GetCardInfoShortItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardID", scope = GetCardInfoShortItem.class)
    public JAXBElement<String> createGetCardInfoShortItemCardID(String value) {
        return new JAXBElement<String>(_GetCardInfoShortItemCardID_QNAME, String.class, GetCardInfoShortItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardGUID", scope = GetCardInfoShortItem.class)
    public JAXBElement<String> createGetCardInfoShortItemCardGUID(String value) {
        return new JAXBElement<String>(_GetCardInfoShortItemCardGUID_QNAME, String.class, GetCardInfoShortItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errCode", scope = SignEnvelopeItem.class)
    public JAXBElement<BigInteger> createSignEnvelopeItemErrCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_DisableOldCardItemErrCode_QNAME, BigInteger.class, SignEnvelopeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errMessage", scope = SignEnvelopeItem.class)
    public JAXBElement<String> createSignEnvelopeItemErrMessage(String value) {
        return new JAXBElement<String>(_DisableOldCardItemErrMessage_QNAME, String.class, SignEnvelopeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountNumber", scope = AccountNumberItem.class)
    public JAXBElement<String> createAccountNumberItemAccountNumber(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemAccountNumber_QNAME, String.class, AccountNumberItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "code", scope = GetCustomerIDItem.class)
    public JAXBElement<BigInteger> createGetCustomerIDItemCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardManufacturersItemCode_QNAME, BigInteger.class, GetCustomerIDItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "customerID", scope = GetCustomerIDItem.class)
    public JAXBElement<BigInteger> createGetCustomerIDItemCustomerID(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCustomerIDItemCustomerID_QNAME, BigInteger.class, GetCustomerIDItem.class, value);
    }

    @XmlElementDecl(namespace = "http://sab/", name = "cardId", scope = GetCustomerID.class)
    public JAXBElement<String> createGetCustomerIDCardId(String value){
        return new JAXBElement<>(_GetCustomerIDCardID_QNAME, String.class, GetCustomerID.class, value);
    }

    @XmlElementDecl(namespace = "http://sab/", name = "cardNum", scope = GetCustomerID.class)
    public JAXBElement<String> createGetCustomerIDCardNum(String value){
        return new JAXBElement<>(_GetCustomerIDCardNum_QNAME, String.class, GetCustomerID.class, value);
    }

    @XmlElementDecl(namespace = "http://sab/", name = "hashNum", scope = GetCustomerID.class)
    public JAXBElement<String> createGetCustomerIDHashNum(String value){
        return new JAXBElement<>(_GetCustomerIDHashNum_QNAME, String.class, GetCustomerID.class, value);
    }

    @XmlElementDecl(namespace = "http://sab/", name = "cardGUID", scope = GetCustomerID.class)
    public JAXBElement<String> createGetCustomerIDCardGUID(String value){
        return new JAXBElement<>(_GetCustomerIDCardGUID_QNAME, String.class, GetCustomerID.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorMessage", scope = GetCustomerIDItem.class)
    public JAXBElement<String> createGetCustomerIDItemErrorMessage(String value) {
        return new JAXBElement<String>(_CancelCardDealItemErrorMessage_QNAME, String.class, GetCustomerIDItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errCode", scope = AddCardRebindingItem.class)
    public JAXBElement<BigInteger> createAddCardRebindingItemErrCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_DisableOldCardItemErrCode_QNAME, BigInteger.class, AddCardRebindingItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errMessage", scope = AddCardRebindingItem.class)
    public JAXBElement<String> createAddCardRebindingItemErrMessage(String value) {
        return new JAXBElement<String>(_DisableOldCardItemErrMessage_QNAME, String.class, AddCardRebindingItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "branchId", scope = GetCardDeliveryBranchItem.class)
    public JAXBElement<String> createGetCardDeliveryBranchItemBranchId(String value) {
        return new JAXBElement<String>(_CheckOpportunityRecreateCardItemBranchId_QNAME, String.class, GetCardDeliveryBranchItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardId", scope = GetReIssueCardsItem.class)
    public JAXBElement<String> createGetReIssueCardsItemCardId(String value) {
        return new JAXBElement<String>(_GetCardInfoByAccountNoItemCardId_QNAME, String.class, GetReIssueCardsItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "renewCardHashNumber", scope = RecreateCardItem.class)
    public JAXBElement<String> createRecreateCardItemRenewCardHashNumber(String value) {
        return new JAXBElement<String>(_RecreateCardItemRenewCardHashNumber_QNAME, String.class, RecreateCardItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "subProductCode", scope = GetSubproductCodesByAtrributeItem.class)
    public JAXBElement<String> createGetSubproductCodesByAtrributeItemSubProductCode(String value) {
        return new JAXBElement<String>(_CardDealSubProductCode_QNAME, String.class, GetSubproductCodesByAtrributeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isPrimary", scope = GetCardsByContragentIdItem.class)
    public JAXBElement<BigInteger> createGetCardsByContragentIdItemIsPrimary(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardDealJurItemIsPrimary_QNAME, BigInteger.class, GetCardsByContragentIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardId", scope = GetCardsByContragentIdItem.class)
    public JAXBElement<String> createGetCardsByContragentIdItemCardId(String value) {
        return new JAXBElement<String>(_GetCardInfoByAccountNoItemCardId_QNAME, String.class, GetCardsByContragentIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accStatusId", scope = GetCardsByContragentIdItem.class)
    public JAXBElement<BigInteger> createGetCardsByContragentIdItemAccStatusId(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardsByContragentIdItemAccStatusId_QNAME, BigInteger.class, GetCardsByContragentIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "nameOnCard", scope = GetCardsByContragentIdItem.class)
    public JAXBElement<String> createGetCardsByContragentIdItemNameOnCard(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemNameOnCard_QNAME, String.class, GetCardsByContragentIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardNoXXX", scope = GetCardsByContragentIdItem.class)
    public JAXBElement<String> createGetCardsByContragentIdItemCardNoXXX(String value) {
        return new JAXBElement<String>(_CardCardNoXXX_QNAME, String.class, GetCardsByContragentIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "expireDate", scope = GetCardsByContragentIdItem.class)
    public JAXBElement<String> createGetCardsByContragentIdItemExpireDate(String value) {
        return new JAXBElement<String>(_GetCardInfoByAccountNoItemExpireDate_QNAME, String.class, GetCardsByContragentIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardTypeId", scope = GetCardsByContragentIdItem.class)
    public JAXBElement<String> createGetCardsByContragentIdItemCardTypeId(String value) {
        return new JAXBElement<String>(_CardCardTypeId_QNAME, String.class, GetCardsByContragentIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "mBanking", scope = GetCardsByContragentIdItem.class)
    public JAXBElement<BigInteger> createGetCardsByContragentIdItemMBanking(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardMBanking_QNAME, BigInteger.class, GetCardsByContragentIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "additionalInfo", scope = GetCardsByContragentIdItem.class)
    public JAXBElement<String> createGetCardsByContragentIdItemAdditionalInfo(String value) {
        return new JAXBElement<String>(_CardAdditionalInfo_QNAME, String.class, GetCardsByContragentIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardHashNumber", scope = GetCardsByContragentIdItem.class)
    public JAXBElement<String> createGetCardsByContragentIdItemCardHashNumber(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemCardHashNumber_QNAME, String.class, GetCardsByContragentIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardStatusText", scope = GetCardsByContragentIdItem.class)
    public JAXBElement<String> createGetCardsByContragentIdItemCardStatusText(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemCardStatusText_QNAME, String.class, GetCardsByContragentIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "mBankingPhone", scope = GetCardsByContragentIdItem.class)
    public JAXBElement<String> createGetCardsByContragentIdItemMBankingPhone(String value) {
        return new JAXBElement<String>(_CardMBankingPhone_QNAME, String.class, GetCardsByContragentIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectText", scope = GetCardsByContragentIdItem.class)
    public JAXBElement<String> createGetCardsByContragentIdItemProjectText(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemProjectText_QNAME, String.class, GetCardsByContragentIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardTypeText", scope = GetCardsByContragentIdItem.class)
    public JAXBElement<String> createGetCardsByContragentIdItemCardTypeText(String value) {
        return new JAXBElement<String>(_CardCardTypeText_QNAME, String.class, GetCardsByContragentIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardStatusId", scope = GetCardsByContragentIdItem.class)
    public JAXBElement<String> createGetCardsByContragentIdItemCardStatusId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemCardStatusId_QNAME, String.class, GetCardsByContragentIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "codeCardText", scope = GetCardsByContragentIdItem.class)
    public JAXBElement<String> createGetCardsByContragentIdItemCodeCardText(String value) {
        return new JAXBElement<String>(_CardCodeCardText_QNAME, String.class, GetCardsByContragentIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accStatusText", scope = GetCardsByContragentIdItem.class)
    public JAXBElement<String> createGetCardsByContragentIdItemAccStatusText(String value) {
        return new JAXBElement<String>(_GetCardsByContragentIdItemAccStatusText_QNAME, String.class, GetCardsByContragentIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "originalCardStatusId", scope = GetCardsByContragentIdItem.class)
    public JAXBElement<String> createGetCardsByContragentIdItemOriginalCardStatusId(String value) {
        return new JAXBElement<String>(_GetCardsByContragentIdItemOriginalCardStatusId_QNAME, String.class, GetCardsByContragentIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "codeCardId", scope = GetCardsByContragentIdItem.class)
    public JAXBElement<BigInteger> createGetCardsByContragentIdItemCodeCardId(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardCodeCardId_QNAME, BigInteger.class, GetCardsByContragentIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardOwnerFullName", scope = GetCardsByContragentIdItem.class)
    public JAXBElement<String> createGetCardsByContragentIdItemCardOwnerFullName(String value) {
        return new JAXBElement<String>(_CardCardOwnerFullName_QNAME, String.class, GetCardsByContragentIdItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorCode", scope = ChangeBranchCodeItem.class)
    public JAXBElement<String> createChangeBranchCodeItemErrorCode(String value) {
        return new JAXBElement<String>(_AnnulateSalaryCardItemErrorCode_QNAME, String.class, ChangeBranchCodeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "errorMsg", scope = ChangeBranchCodeItem.class)
    public JAXBElement<String> createChangeBranchCodeItemErrorMsg(String value) {
        return new JAXBElement<String>(_AnnulateSalaryCardItemErrorMsg_QNAME, String.class, ChangeBranchCodeItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentId", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemContragentId(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemContragentId_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "courier", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemCourier(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemCourier_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "comment", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemComment(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusByTextItemComment_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardMask", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemCardMask(String value) {
        return new JAXBElement<String>(_GetStatusMonitoringTransactionsItemCardMask_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dateFileGen", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetCardDeliveryStatusByTextItemDateFileGen(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardDeliveryStatusItemDateFileGen_QNAME, XMLGregorianCalendar.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deliveryCorp", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemDeliveryCorp(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemDeliveryCorp_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dateOnPrint", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetCardDeliveryStatusByTextItemDateOnPrint(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardDeliveryStatusItemDateOnPrint_QNAME, XMLGregorianCalendar.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deliveryHouse", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemDeliveryHouse(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemDeliveryHouse_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "datePerson", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetCardDeliveryStatusByTextItemDatePerson(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardDeliveryStatusItemDatePerson_QNAME, XMLGregorianCalendar.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deliveryDistrictCode", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemDeliveryDistrictCode(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemDeliveryDistrictCode_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "plantDeliveryPointName", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemPlantDeliveryPointName(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemPlantDeliveryPointName_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "lastChangeDate", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetCardDeliveryStatusByTextItemLastChangeDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardDeliveryStatusItemLastChangeDate_QNAME, XMLGregorianCalendar.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deliveryStreet", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemDeliveryStreet(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemDeliveryStreet_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deliveryType", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemDeliveryType(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemDeliveryType_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deliveryFlat", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemDeliveryFlat(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemDeliveryFlat_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deliveryCityCode", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemDeliveryCityCode(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemDeliveryCityCode_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "plantDeliveryPoint", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemPlantDeliveryPoint(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemPlantDeliveryPoint_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardProject", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemCardProject(String value) {
        return new JAXBElement<String>(_GetStatusMonitoringTransactionsItemCardProject_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deliveryRegionCode", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemDeliveryRegionCode(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemDeliveryRegionCode_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "shopId", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemShopId(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemShopId_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "embCardName", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemEmbCardName(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemEmbCardName_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "renewLabel", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemRenewLabel(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemRenewLabel_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "urgent", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemUrgent(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemUrgent_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "trackStatusAdd1", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemTrackStatusAdd1(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemTrackStatusAdd1_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "barcode", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemBarcode(String value) {
        return new JAXBElement<String>(_GetCardInfoItemBarcode_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardHash", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemCardHash(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemCardHash_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardDeliveryStatus", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemCardDeliveryStatus(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemCardDeliveryStatus_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deliveryChannel", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemDeliveryChannel(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemDeliveryChannel_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "fileGenName", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemFileGenName(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemFileGenName_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "deliveryStreetType", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemDeliveryStreetType(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemDeliveryStreetType_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dateExp", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetCardDeliveryStatusByTextItemDateExp(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardDeliveryStatusItemDateExp_QNAME, XMLGregorianCalendar.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "chipExist", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemChipExist(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemChipExist_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "manufacturer", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemManufacturer(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusItemManufacturer_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dateCreate", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetCardDeliveryStatusByTextItemDateCreate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardDeliveryStatusItemDateCreate_QNAME, XMLGregorianCalendar.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "canModify", scope = GetCardDeliveryStatusByTextItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusByTextItemCanModify(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusByTextItemCanModify_QNAME, String.class, GetCardDeliveryStatusByTextItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardTypeText", scope = GetCardTemplateItem.class)
    public JAXBElement<String> createGetCardTemplateItemCardTypeText(String value) {
        return new JAXBElement<String>(_CardCardTypeText_QNAME, String.class, GetCardTemplateItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "taxId", scope = GetCardTemplateItem.class)
    public JAXBElement<String> createGetCardTemplateItemTaxId(String value) {
        return new JAXBElement<String>(_CardDealTaxId_QNAME, String.class, GetCardTemplateItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "templateName", scope = GetCardTemplateItem.class)
    public JAXBElement<String> createGetCardTemplateItemTemplateName(String value) {
        return new JAXBElement<String>(_GetCardTemplateItemTemplateName_QNAME, String.class, GetCardTemplateItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardTypeCode", scope = GetCardTemplateItem.class)
    public JAXBElement<String> createGetCardTemplateItemCardTypeCode(String value) {
        return new JAXBElement<String>(_GetCardTemplateItemCardTypeCode_QNAME, String.class, GetCardTemplateItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectText", scope = GetCardTemplateItem.class)
    public JAXBElement<String> createGetCardTemplateItemProjectText(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemProjectText_QNAME, String.class, GetCardTemplateItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectId", scope = GetCardTemplateItem.class)
    public JAXBElement<String> createGetCardTemplateItemProjectId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemProjectId_QNAME, String.class, GetCardTemplateItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "closeDate", scope = CardDeal4 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal4CloseDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealCloseDate_QNAME, XMLGregorianCalendar.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "taxId", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4TaxId(String value) {
        return new JAXBElement<String>(_CardDealTaxId_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statusText", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4StatusText(String value) {
        return new JAXBElement<String>(_CardDealStatusText_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "statusId", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4StatusId(String value) {
        return new JAXBElement<String>(_CardDealStatusId_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentId", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4ContragentId(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemContragentId_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "startDate", scope = CardDeal4 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal4StartDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealStartDate_QNAME, XMLGregorianCalendar.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "toboId", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4ToboId(String value) {
        return new JAXBElement<String>(_CardDealToboId_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "tarifPlanText", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4TarifPlanText(String value) {
        return new JAXBElement<String>(_CardDealTarifPlanText_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "currencyCode", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4CurrencyCode(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemCurrencyCode_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectId", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4ProjectId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemProjectId_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isActiveText", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4IsActiveText(String value) {
        return new JAXBElement<String>(_CardDealIsActiveText_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "subProductCode", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4SubProductCode(String value) {
        return new JAXBElement<String>(_CardDealSubProductCode_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "sold", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4Sold(String value) {
        return new JAXBElement<String>(_CardDealSold_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isPersonalized", scope = CardDeal4 .class)
    public JAXBElement<BigInteger> createCardDeal4IsPersonalized(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardDealIsPersonalized_QNAME, BigInteger.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isSalary", scope = CardDeal4 .class)
    public JAXBElement<BigInteger> createCardDeal4IsSalary(BigInteger value) {
        return new JAXBElement<BigInteger>(_CardDealIsSalary_QNAME, BigInteger.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "reportDeliveryModeId", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4ReportDeliveryModeId(String value) {
        return new JAXBElement<String>(_CardDealReportDeliveryModeId_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "segmentCode", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4SegmentCode(String value) {
        return new JAXBElement<String>(_CardDealSegmentCode_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "contragentName", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4ContragentName(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemContragentName_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "tarifPlanId", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4TarifPlanId(String value) {
        return new JAXBElement<String>(_CardDealTarifPlanId_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountNo8030", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4AccountNo8030(String value) {
        return new JAXBElement<String>(_CardDeal6AccountNo8030_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealNo", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4DealNo(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemDealNo_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "emailAddress", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4EmailAddress(String value) {
        return new JAXBElement<String>(_CardDealEmailAddress_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealTypeId", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4DealTypeId(String value) {
        return new JAXBElement<String>(_CardDealDealTypeId_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountNo", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4AccountNo(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemAccountNo_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "expireDate", scope = CardDeal4 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal4ExpireDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardInfoByAccountNoItemExpireDate_QNAME, XMLGregorianCalendar.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "creditLimit", scope = CardDeal4 .class)
    public JAXBElement<Long> createCardDeal4CreditLimit(Long value) {
        return new JAXBElement<Long>(_CardDealCreditLimit_QNAME, Long.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectText", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4ProjectText(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemProjectText_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealId", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4DealId(String value) {
        return new JAXBElement<String>(_GetCardDealJurItemDealId_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "projectType", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4ProjectType(String value) {
        return new JAXBElement<String>(_CardDealProjectType_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "dealTypeText", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4DealTypeText(String value) {
        return new JAXBElement<String>(_CardDealDealTypeText_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "signDate", scope = CardDeal4 .class)
    public JAXBElement<XMLGregorianCalendar> createCardDeal4SignDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealSignDate_QNAME, XMLGregorianCalendar.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isActive", scope = CardDeal4 .class)
    public JAXBElement<BigInteger> createCardDeal4IsActive(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardInfoByCardIdItemIsActive_QNAME, BigInteger.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "reportDeliveryAdress", scope = CardDeal4 .class)
    public JAXBElement<String> createCardDeal4ReportDeliveryAdress(String value) {
        return new JAXBElement<String>(_CardDealReportDeliveryAdress_QNAME, String.class, CardDeal4 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "canChange", scope = GetCVV2FlagItem.class)
    public JAXBElement<BigInteger> createGetCVV2FlagItemCanChange(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardDailyLimitsItemCanChange_QNAME, BigInteger.class, GetCVV2FlagItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "hardStoplist", scope = CardInfo.class)
    public JAXBElement<String> createCardInfoHardStoplist(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemHardStoplist_QNAME, String.class, CardInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "cardNumber", scope = CardInfo.class)
    public JAXBElement<String> createCardInfoCardNumber(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemCardNumber_QNAME, String.class, CardInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "softStoplist", scope = CardInfo.class)
    public JAXBElement<String> createCardInfoSoftStoplist(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemSoftStoplist_QNAME, String.class, CardInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "comment", scope = GetCardDeliveryStatusLogItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusLogItemComment(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusByTextItemComment_QNAME, String.class, GetCardDeliveryStatusLogItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "username", scope = GetCardDeliveryStatusLogItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusLogItemUsername(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusLogItemUsername_QNAME, String.class, GetCardDeliveryStatusLogItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "trackstatus", scope = GetCardDeliveryStatusLogItem.class)
    public JAXBElement<String> createGetCardDeliveryStatusLogItemTrackstatus(String value) {
        return new JAXBElement<String>(_GetCardDeliveryStatusLogItemTrackstatus_QNAME, String.class, GetCardDeliveryStatusLogItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "lastchangedate", scope = GetCardDeliveryStatusLogItem.class)
    public JAXBElement<XMLGregorianCalendar> createGetCardDeliveryStatusLogItemLastchangedate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetCardDeliveryStatusLogItemLastchangedate_QNAME, XMLGregorianCalendar.class, GetCardDeliveryStatusLogItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accStatusText", scope = Account.class)
    public JAXBElement<String> createAccountAccStatusText(String value) {
        return new JAXBElement<String>(_GetCardsByContragentIdItemAccStatusText_QNAME, String.class, Account.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accountNo", scope = Account.class)
    public JAXBElement<String> createAccountAccountNo(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemAccountNo_QNAME, String.class, Account.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "accStatusId", scope = Account.class)
    public JAXBElement<String> createAccountAccStatusId(String value) {
        return new JAXBElement<String>(_GetCardsByContragentIdItemAccStatusId_QNAME, String.class, Account.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "balance", scope = Account.class)
    public JAXBElement<Long> createAccountBalance(Long value) {
        return new JAXBElement<Long>(_CardDealStateBalance_QNAME, Long.class, Account.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "lastBalanceUpdate", scope = Account.class)
    public JAXBElement<XMLGregorianCalendar> createAccountLastBalanceUpdate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CardDealStateLastBalanceUpdate_QNAME, XMLGregorianCalendar.class, Account.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "balanceNo", scope = Account.class)
    public JAXBElement<String> createAccountBalanceNo(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemBalanceNo_QNAME, String.class, Account.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "isActive", scope = Account.class)
    public JAXBElement<BigInteger> createAccountIsActive(BigInteger value) {
        return new JAXBElement<BigInteger>(_GetCardInfoByCardIdItemIsActive_QNAME, BigInteger.class, Account.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "currencyCode", scope = Account.class)
    public JAXBElement<String> createAccountCurrencyCode(String value) {
        return new JAXBElement<String>(_GetCardInfoByCardIdItemCurrencyCode_QNAME, String.class, Account.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://sab/", name = "codeOut", scope = SetCardStopListItem.class)
    public JAXBElement<String> createSetCardStopListItemCodeOut(String value) {
        return new JAXBElement<String>(_SetCardStopListItemCodeOut_QNAME, String.class, SetCardStopListItem.class, value);
    }

}
