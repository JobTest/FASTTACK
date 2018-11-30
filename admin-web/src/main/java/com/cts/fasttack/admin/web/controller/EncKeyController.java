package com.cts.fasttack.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cts.fasttack.admin.web.converter.EncKeyDtoToRequestResponseConverter;
import com.cts.fasttack.admin.web.converter.EncKeyRequestResponseToDtoConverter;
import com.cts.fasttack.admin.web.data.JsonResponseWrapper;
import com.cts.fasttack.admin.web.data.dict.AccessType;
import com.cts.fasttack.admin.web.data.dict.ItemType;
import com.cts.fasttack.admin.web.data.dto.EncKeyDto;
import com.cts.fasttack.admin.web.service.AccessLogService;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.crypto.client.dto.EncKeyListFilterDto;
import com.cts.fasttack.crypto.client.dto.EncKeyRequestResponseDto;
import com.cts.fasttack.crypto.client.rest.EncKeyRestClient;
import com.cts.fasttack.crypto.client.validation.operation.EncKeySaveOperation;

@Controller
@RequestMapping("/enckey")
@PreAuthorize("isAuthenticated()")
public class EncKeyController {

    @Autowired
    private EncKeyDtoToRequestResponseConverter encKeyDtoToRequestResponseConverter;

    @Autowired
    private EncKeyRequestResponseToDtoConverter encKeyRequestResponseToDtoConverter;

    @Autowired
    private EncKeyRestClient encKeyRestClient;

    @Autowired
    private AccessLogService accessLogService;

    @PreAuthorize("@aclEncKey.isCanView()")
    @GetMapping("/list.htm")
    public String list() {
        return "enckey/encKey_list";
    }

    @PreAuthorize("@aclEncKey.isCanView()")
    @GetMapping("/view.htm")
    public String view(@RequestParam Long id) {
        return "enckey/encKey_view";
    }

    @PreAuthorize("@aclEncKey.isCanCreate()")
    @GetMapping("/new.htm")
    public String createNew() {
        return "enckey/encKey_create";
    }

    @PreAuthorize("@aclEncKey.isCanEdit()")
    @GetMapping("/edit.htm")
    public String editEncKey(@RequestParam String id) {
        return "enckey/encKey_edit";
    }

    // CRUD Operations

    @PreAuthorize("@aclEncKey.isCanView()")
    @PostMapping(value = "/filter.json", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public QueryResultDto<EncKeyRequestResponseDto> filter(@RequestBody EncKeyListFilterDto filter) throws ServiceException {
        accessLogService.create().item(ItemType.ENC_KEY).type(AccessType.VIEW_ALL).fields(
                filter.getKeyType(),
                filter.getRefCode(),
                "sort by: " + filter.getSortField() + ", page" + String.valueOf(filter.getPage())).save();
        return encKeyRestClient.listPaged(filter);
    }

    @PreAuthorize("@aclEncKey.isCanView()")
    @GetMapping("/item.json")
    @ResponseBody
    public EncKeyDto getEncKey(@RequestParam Long id) throws ServiceException {
        accessLogService.create().item(ItemType.ENC_KEY).id(String.valueOf(id)).type(AccessType.VIEW).save();
        return encKeyRequestResponseToDtoConverter.convert(encKeyRestClient.get(id));
    }

    @PreAuthorize("@aclEncKey.isCanCreate()")
    @PostMapping("/item.json")
    @ResponseBody
    public JsonResponseWrapper<?> createEncKey(@Validated(value = {EncKeySaveOperation.class}) @RequestBody EncKeyDto dto) throws ServiceException {
        accessLogService.create().item(ItemType.ENC_KEY).type(AccessType.CREATE).id(dto.getId()).fields(dto.getKeyType().name(), dto.getRefCode(), dto.getKeyValue(), dto.getCheckValue(), dto.getPublicExponent(), dto.getWrappingKey()).save();
        return JsonResponseWrapper.success(encKeyRestClient.createNew(encKeyDtoToRequestResponseConverter.convert(dto)));
    }

    @PreAuthorize("@aclEncKey.isCanEdit()")
    @PutMapping("/item.json")
    @ResponseBody
    public JsonResponseWrapper<?> updateEncKey(@RequestBody EncKeyDto dto) throws ServiceException {
        accessLogService.create().item(ItemType.ENC_KEY).type(AccessType.UPDATE).id(dto.getId()).fields(dto.getKeyType().name(), dto.getRefCode(), dto.getKeyValue(), dto.getCheckValue(), dto.getPublicExponent(), dto.getWrappingKey()).save();
        return JsonResponseWrapper.success(encKeyRestClient.update(encKeyDtoToRequestResponseConverter.convert(dto)));
    }

    @PreAuthorize("@aclEncKey.isCanDelete()")
    @DeleteMapping("/item.json")
    @ResponseBody
    public JsonResponseWrapper<?> deleteEncKey(@RequestParam Long id) throws ServiceException {
        accessLogService.create().item(ItemType.ENC_KEY).id(String.valueOf(id)).type(AccessType.DELETE).save();
        encKeyRestClient.delete(id);
        return JsonResponseWrapper.success(id);
    }

}
