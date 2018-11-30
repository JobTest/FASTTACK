package com.cts.fasttack.core.rest;

import javax.validation.constraints.NotNull;

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
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.common.core.list.QueryResult;
import com.cts.fasttack.core.data.FEProp;
import com.cts.fasttack.core.dto.FEPropDto;
import com.cts.fasttack.core.service.FEPropService;

@RestController
@RequestMapping("/secured/feProp")
public class FEPropertyRestController {

    @Autowired
    private FEPropService fePropService;

    @GetMapping("/isExists/{propName}")
    public Boolean isExistsFEProp(@PathVariable String propName) throws ServiceException {
        return fePropService.isExists(propName);
    }

    @PostMapping("/list")
    @ResponseBody
    public QueryResult<FEPropDto> filterFEProp(@NotNull @RequestBody ListFilter<FEProp> filter) throws ServiceException {
        return fePropService.list(filter);
    }

    @GetMapping("/{propName}")
    @ResponseBody
    public FEPropDto getFEProp(@PathVariable String propName) throws ServiceException {
        return fePropService.get(propName);
    }

    @PutMapping("/")
    @ResponseBody
    public FEPropDto createFEProp(@Validated @NotNull @RequestBody FEPropDto feProp) throws ServiceException {
        return fePropService.createFEProp(feProp);
    }

    @PostMapping("/")
    public void updateFEProp(@Validated @NotNull @RequestBody FEPropDto feProp) throws ServiceException {
        fePropService.updateFEProp(feProp);
    }

    @DeleteMapping("/{propName}")
    public void deleteFEProp(@PathVariable String propName) throws ServiceException {
        fePropService.delete(propName);
    }
}
