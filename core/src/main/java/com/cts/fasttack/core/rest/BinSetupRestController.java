package com.cts.fasttack.core.rest;

import javax.validation.constraints.NotNull;

import com.cts.fasttack.common.core.converter.QueryResultToDtoConverter;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.core.data.list.BinSetupListFilter;
import com.cts.fasttack.core.dto.BinSetupDto;
import com.cts.fasttack.core.service.BinSetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author a.lipavets
 */
@RestController
@RequestMapping("/secured/binSetup")
public class BinSetupRestController {

    @Autowired
    private BinSetupService binSetupService;

    @Autowired
    protected QueryResultToDtoConverter<BinSetupDto> queryResultToDtoConverter;

    @GetMapping("/isExists/{bin}")
    public Boolean isExistsBinSetup(@PathVariable Long bin) throws ServiceException {
        return binSetupService.isExists(bin);
    }

    @PostMapping("/list")
    @ResponseBody
    public QueryResultDto<BinSetupDto> filter(@NotNull @RequestBody BinSetupListFilter filter) throws ServiceException {
        return queryResultToDtoConverter.convert(binSetupService.list(filter));
    }

    @GetMapping("/{bin}")
    @ResponseBody
    public BinSetupDto get(@PathVariable Long bin) throws ServiceException {
        return binSetupService.get(bin);
    }

    @PutMapping("/")
    @ResponseBody
    public BinSetupDto create(@Validated @NotNull @RequestBody BinSetupDto bin) throws ServiceException {
        return binSetupService.createNew(bin);
    }

    @PostMapping("/")
    public void update(@Validated @NotNull @RequestBody BinSetupDto binSetupDto) throws ServiceException {
        binSetupService.save(binSetupDto);
    }

    @DeleteMapping("/{bin}")
    public void delete(@PathVariable Long bin) throws ServiceException {
        binSetupService.delete(bin);
    }
}
