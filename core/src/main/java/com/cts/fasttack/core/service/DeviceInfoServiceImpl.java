package com.cts.fasttack.core.service;

import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.core.converter.DeviceInfoDtoToDomainConverter;
import com.cts.fasttack.core.converter.DeviceInfoToDtoConverter;
import com.cts.fasttack.core.dao.DeviceInfoDao;
import com.cts.fasttack.core.data.DeviceInfo;
import com.cts.fasttack.core.dto.DeviceInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author a.lipavets
 */
@Service("deviceInfoService")
public class DeviceInfoServiceImpl extends GenericServiceImpl<String, DeviceInfoDto, DeviceInfo, DeviceInfoDao> implements DeviceInfoService {

    @Autowired
    public DeviceInfoServiceImpl(DeviceInfoDao dao, DeviceInfoToDtoConverter domainToDtoConverter, DeviceInfoDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }
}
