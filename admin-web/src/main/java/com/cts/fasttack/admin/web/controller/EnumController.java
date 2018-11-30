package com.cts.fasttack.admin.web.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cts.fasttack.admin.web.data.OptionWrapperDto;
import com.cts.fasttack.admin.web.data.dict.AccessType;
import com.cts.fasttack.admin.web.data.dict.ItemType;
import com.cts.fasttack.admin.web.data.dict.TokenStatus;
import com.cts.fasttack.admin.web.data.dict.UserStatus;
import com.cts.fasttack.admin.web.util.OptionWrapperHelper;
import com.cts.fasttack.crypto.client.dict.EncKeyCapacityType;
import com.cts.fasttack.crypto.client.dict.EncKeyStatus;
import com.cts.fasttack.crypto.client.dict.KeyType;
import com.cts.fasttack.crypto.client.dict.WrappingKey;

/**
 * @author Dmitry Koval
 */
@Controller
@RequestMapping("/enum")
@PreAuthorize("isAuthenticated()")
public class EnumController {

    @GetMapping("/enckeyCapacity.json")
    @ResponseBody
    public List<OptionWrapperDto> getEncKeyCapacityList() {
        return OptionWrapperHelper.getI18DictOptionWrappers(EncKeyCapacityType.values());
    }

    @GetMapping("/enckeyStatus.json")
    @ResponseBody
    public List<OptionWrapperDto> getEncKeyStatusList() {
        return OptionWrapperHelper.getI18DictOptionWrappers(EncKeyStatus.values());
    }

    @GetMapping("/enckeyWrappingKey.json")
    @ResponseBody
    public List<OptionWrapperDto> getEncKeyWrappingKeyList() {
        return OptionWrapperHelper.getI18DictOptionWrappers(WrappingKey.values());
    }

    @GetMapping("/keyTypes.json")
    @ResponseBody
    public List<OptionWrapperDto> keyTypes() {
        return OptionWrapperHelper.getDictOptionWrappers(KeyType.values());
    }

    @GetMapping("/userStatusList.json")
    @ResponseBody
    public List<OptionWrapperDto> getUserStatusList() {
        List<UserStatus> userStatusList = Arrays.stream(UserStatus.values())
                .filter(userStatus -> userStatus != UserStatus.TEMP_BLOCKED)
                .collect(Collectors.toList());
        return OptionWrapperHelper.getI18DictOptionWrappers(
                userStatusList.toArray(new UserStatus[userStatusList.size()]));
    }

    @GetMapping("/tokenStatusList.json")
    @ResponseBody
    public List<OptionWrapperDto> listTokenStatuses(){
        return OptionWrapperHelper.getI18DictOptionWrappers(TokenStatus.values());
    }

    @RequestMapping(value = "/itemTypes.json", method = RequestMethod.GET)
    @ResponseBody
    public List<OptionWrapperDto> itemTypes() {
        return OptionWrapperHelper.getI18DictOptionWrappers(ItemType.values());
    }

    @RequestMapping(value = "/accessTypes.json", method = RequestMethod.GET)
    @ResponseBody
    public List<OptionWrapperDto> accessTypes() {
        return OptionWrapperHelper.getI18DictOptionWrappers(AccessType.values());
    }
}
