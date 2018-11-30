package com.cts.fasttack.admin.web.controller;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import com.cts.fasttack.admin.web.data.JsonResponseWrapper;
import com.cts.fasttack.admin.web.data.dict.AccessType;
import com.cts.fasttack.admin.web.data.dict.ItemType;
import com.cts.fasttack.admin.web.data.dict.UserStatus;
import com.cts.fasttack.admin.web.data.dto.BinSetupDto;
import com.cts.fasttack.admin.web.data.list.BinSetupListFilter;
import com.cts.fasttack.admin.web.rest.BinSetupRestClient;
import com.cts.fasttack.admin.web.service.AccessLogService;
import com.cts.fasttack.admin.web.validation.operation.EntityCreateOperation;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.logging.dto.ChangeLogMessage;
import com.cts.fasttack.logging.service.ChangeLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

/**
 * Controller for BinSetup
 *
 * @author a.lipavets
 */
@Controller
@RequestMapping("/bin")
@PreAuthorize("isAuthenticated()")
public class BinSetupController {

    @GroupSequence({Default.class, EntityCreateOperation.class})
    private interface Sequence{}

    @Autowired
    private BinSetupRestClient binSetupRestClient;

    @Autowired
    private AccessLogService accessLogService;

    @Autowired
    private ChangeLogger changeLogger;

    @PreAuthorize("@aclBinSetup.isCanView()")
    @GetMapping("/list.htm")
    public String list() {
        return "binSetup/bin_list";
    }

    @PreAuthorize("@aclBinSetup.isCanView()")
    @GetMapping("/view.htm")
    public String view() {
        return "binSetup/bin_view";
    }

    @PreAuthorize("@aclBinSetup.isCanCreate()")
    @GetMapping("/new.htm")
    public String createNew() {
        return "binSetup/bin_create";
    }

    @PreAuthorize("@aclBinSetup.isCanEdit()")
    @GetMapping("/edit.htm")
    public String edit() {
        return "binSetup/bin_edit";
    }

    @PreAuthorize("@aclBinSetup.isCanView()")
    @PostMapping("/filter.json")
    @ResponseBody
    public QueryResultDto<BinSetupDto> filter(@Validated @RequestBody BinSetupListFilter filter) throws ServiceException {
        accessLogService.create().item(ItemType.BIN_SETUP).type(AccessType.VIEW_ALL).fields("sort by: " + filter.getSortField() + ", page" + String.valueOf(filter.getPage())).save();
        return binSetupRestClient.filter(filter);
    }

    @PreAuthorize("@aclBinSetup.isCanCreate()")
    @PostMapping("/item.json")
    @ResponseBody
    public JsonResponseWrapper<?> createBinSetup(@Validated(Sequence.class) @RequestBody BinSetupDto dto) throws ServiceException {
        accessLogService.create().item(ItemType.BIN_SETUP).type(AccessType.CREATE).id(dto.getBin()).fields(dto.getBin(), String.valueOf(dto.isSendAsv()), String.valueOf(dto.isSendCardTokenized()), String.valueOf(dto.isSendGetCustomerId())).save();
        toChangeLoggerInfo(AccessType.CREATE);
        binSetupRestClient.createBinSetup(dto);
        return JsonResponseWrapper.success(dto);
    }

    @PreAuthorize("@aclBinSetup.isCanView()")
    @GetMapping("/item.json")
    @ResponseBody
    public BinSetupDto getBinSetup(@RequestParam("bin") Long bin) throws ServiceException {
        accessLogService.create().item(ItemType.BIN_SETUP).id(bin).type(AccessType.VIEW).save();
        return binSetupRestClient.getBinSetup(bin);
    }

    @PreAuthorize("@aclBinSetup.isCanEdit()")
    @PutMapping("/item.json")
    @ResponseBody
    public JsonResponseWrapper<?> updateBinSetup(@Validated @RequestBody BinSetupDto dto) throws ServiceException {
        accessLogService.create().item(ItemType.BIN_SETUP).type(AccessType.UPDATE).id(dto.getBin()).fields(dto.getBin(), String.valueOf(dto.isSendAsv()), String.valueOf(dto.isSendCardTokenized()), String.valueOf(dto.isSendGetCustomerId())).save();
        toChangeLoggerInfo(AccessType.UPDATE);
        binSetupRestClient.updateBinSetup(dto);
        return JsonResponseWrapper.success(dto);
    }

    @PreAuthorize("@aclBinSetup.isCanDelete()")
    @DeleteMapping("/item.json")
    @ResponseBody
    public JsonResponseWrapper<?> deleteBinSetup(@RequestParam String bin) throws ServiceException {
        accessLogService.create().item(ItemType.BIN_SETUP).type(AccessType.DELETE).id(bin).fields(bin).save();
        toChangeLoggerInfo(AccessType.DELETE);
        binSetupRestClient.deleteBinSetup(bin);
        return JsonResponseWrapper.success(bin);
    }

    private void toChangeLoggerInfo(AccessType action) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ( !(authentication instanceof AnonymousAuthenticationToken) ) {
            changeLogger.info(action.getCaption(), new ChangeLogMessage(ItemType.BIN_SETUP.getCaption(), "AUTHORIZE").fields(authentication.getName(), UserStatus.ACTIVE.getCaption(), "0"));
        } else {
            changeLogger.info(action.getCaption(), new ChangeLogMessage(ItemType.BIN_SETUP.getCaption(), "UNAUTHORIZE"));
        }
    }
}
