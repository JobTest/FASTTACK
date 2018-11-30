package com.cts.fasttack.core.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cts.fasttack.common.core.dict.TokenEventStatus;
import com.cts.fasttack.core.dto.TokenReasonDto;
import com.cts.fasttack.core.service.TokenReasonService;

/**
 * @author Dmitry Koval
 */
@RestController
@RequestMapping("/secured/tokenReasons")
public class TokenReasonRestController {

    @Autowired
    private TokenReasonService tokenReasonService;

    @GetMapping("/{id}")
    @ResponseBody
    public TokenReasonDto get(@PathVariable Long id) {
        return tokenReasonService.get(id);
    }

    @PostMapping("/status/{tokenEventStatus}")
    @ResponseBody
    public List<TokenReasonDto> listByStatus(@PathVariable TokenEventStatus tokenEventStatus) {
        return tokenReasonService.listByStatus(tokenEventStatus);
    }
}
