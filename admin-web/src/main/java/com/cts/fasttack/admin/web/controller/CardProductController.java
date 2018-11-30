package com.cts.fasttack.admin.web.controller;

import com.cts.fasttack.admin.web.data.JsonResponseWrapper;
import com.cts.fasttack.admin.web.data.dict.AccessType;
import com.cts.fasttack.admin.web.data.dict.ItemType;
import com.cts.fasttack.admin.web.data.dto.CardProductDto;
import com.cts.fasttack.admin.web.data.list.CardProductListFilter;
import com.cts.fasttack.admin.web.rest.CardProductRestClient;
import com.cts.fasttack.admin.web.service.AccessLogService;
import com.cts.fasttack.admin.web.validation.operation.EntityCreateOperation;
import com.cts.fasttack.admin.web.validation.operation.EntityUpdateOperation;
import com.cts.fasttack.admin.web.validation.operation.RangeLengthOperation;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.validation.groups.Default;

@Controller
@RequestMapping("/cardProduct")
@PreAuthorize("isAuthenticated()")
public class CardProductController {

    @Autowired
    private CardProductRestClient cardProductRestClient;

    @Autowired
    private AccessLogService accessLogService;

    @PreAuthorize("@aclCardProduct.isCanView()")
    @GetMapping("/list.htm")
    public String list() {
        return "cardProduct/cardProduct_list";
    }

    @PreAuthorize("@aclCardProduct.isCanView()")
    @GetMapping("/view.htm")
    public String view() {
        return "cardProduct/cardProduct_view";
    }

    @PreAuthorize("@aclCardProduct.isCanCreate()")
    @GetMapping("/new.htm")
    public String createNew() {
        return "cardProduct/cardProduct_create";
    }

    @PreAuthorize("@aclCardProduct.isCanEdit()")
    @GetMapping("/edit.htm")
    public String edit() {
        return "cardProduct/cardProduct_edit";
    }

    @PreAuthorize("@aclCardProduct.isCanView()")
    @PostMapping("/filter.json")
    @ResponseBody
    public QueryResultDto<CardProductDto> filter(@Validated @RequestBody CardProductListFilter filter) throws ServiceException {
        accessLogService.create().item(ItemType.CARD_PROPRODUCT).type(AccessType.VIEW_ALL).fields("sort by: " + filter.getSortField() + ", page" + String.valueOf(filter.getPage())).save();
        return cardProductRestClient.filterCardProduct(filter);
    }

    @PreAuthorize("@aclCardProduct.isCanView()")
    @GetMapping("/item.json")
    @ResponseBody
    public CardProductDto getCardProduct(@RequestParam("id") Long id) throws ServiceException {
        accessLogService.create().item(ItemType.CARD_PROPRODUCT).id(id).type(AccessType.VIEW).save();
        return cardProductRestClient.getCardProduct(id);
    }

    @PreAuthorize("@aclCardProduct.isCanCreate()")
    @PostMapping("/item.json")
    @ResponseBody
    public JsonResponseWrapper<?> createCardProduct(@Validated({Default.class, EntityCreateOperation.class, RangeLengthOperation.class}) @RequestBody CardProductDto dto) throws ServiceException {
        accessLogService.create().item(ItemType.CARD_PROPRODUCT).type(AccessType.CREATE).id(dto.getProductConfigId()).fields(dto.getBeginRange(), dto.getEndRange()).save();
        cardProductRestClient.createCardProduct(dto);
        return JsonResponseWrapper.success(dto);
    }

    @PreAuthorize("@aclCardProduct.isCanEdit()")
    @PutMapping("/item.json")
    @ResponseBody
    public JsonResponseWrapper<?> updateCardProduct(@Validated({Default.class, EntityUpdateOperation.class, RangeLengthOperation.class}) @RequestBody CardProductDto dto) throws ServiceException {
        accessLogService.create().item(ItemType.CARD_PROPRODUCT).type(AccessType.UPDATE).id(dto.getProductConfigId()).fields(dto.getBeginRange(), dto.getEndRange()).save();
        cardProductRestClient.updateCardProduct(dto);
        return JsonResponseWrapper.success(dto);
    }

    @PreAuthorize("@aclCardProduct.isCanDelete()")
    @DeleteMapping("/item.json")
    @ResponseBody
    public JsonResponseWrapper<?> deleteCardProduct(@RequestParam Long id) throws ServiceException {
        accessLogService.create().item(ItemType.CARD_PROPRODUCT).id(id).type(AccessType.DELETE).save();
        cardProductRestClient.deleteCardProduct(id);
        return JsonResponseWrapper.success(id);
    }

    @GetMapping("/productConfigId.json")
    @ResponseBody
    public CardProductDto getProductConfigId(@RequestParam("pan") Long pan) throws ServiceException {
        return cardProductRestClient.getProductConfigId(pan);
    }
}

