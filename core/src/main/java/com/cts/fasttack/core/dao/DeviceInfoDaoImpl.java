package com.cts.fasttack.core.dao;

import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.core.dao.DeviceInfoDao;
import com.cts.fasttack.core.data.DeviceInfo;
import org.springframework.stereotype.Repository;

/**
 * @author a.lipavets
 */
@Repository("deviceInfoDao")
public class DeviceInfoDaoImpl extends GenericDaoImpl<String, DeviceInfo> implements DeviceInfoDao {
    @Override
    public Class<DeviceInfo> getEntityClass() {
        return DeviceInfo.class;
    }
}
