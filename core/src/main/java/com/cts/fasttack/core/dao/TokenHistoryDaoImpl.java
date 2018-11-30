package com.cts.fasttack.core.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.common.core.dao.PageCriteria;
import com.cts.fasttack.core.data.TokenHistory;
import com.cts.fasttack.core.dto.TokenHistoryList;
import com.cts.fasttack.core.filter.TokenHistoryFilter;

/**
 * @author a.lipavets
 */
@Repository("tokenHistoryDao")
public class TokenHistoryDaoImpl extends GenericDaoImpl<Long, TokenHistory> implements TokenHistoryDao {
    @Override
    public Class<TokenHistory> getEntityClass() {
        return TokenHistory.class;
    }


    public List<TokenHistoryList> listTokenHistory(TokenHistoryFilter filter) {
        PageCriteria criteria = createPageCriteria(TokenHistoryList.class);
        if(StringUtils.isNotBlank(filter.getTokenRefId())){
            criteria.add(Restrictions.eq("id.tokenRefId", filter.getTokenRefId()));
        }

        if(StringUtils.isNotBlank(filter.getTokenRefId())){
            criteria.add(Restrictions.eq("id.tokenRequestorId", filter.getTokenRequestorId()));
        }

        if(StringUtils.isNotBlank(filter.getReminderPeriod())){
            criteria.add(Restrictions.eq("reminderPeriod", filter.getReminderPeriod()));
        }

        return criteria.list(filter);
    }
}
