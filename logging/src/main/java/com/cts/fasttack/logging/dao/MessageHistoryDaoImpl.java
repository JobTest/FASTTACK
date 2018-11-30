package com.cts.fasttack.logging.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.cts.fasttack.common.core.dao.GenericDaoImpl;
import com.cts.fasttack.common.core.dao.PageCriteria;
import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.common.core.util.CriteriaUtil;
import com.cts.fasttack.logging.domain.MessageHistory;
import com.cts.fasttack.logging.domain.filter.MessageHistoryListFilter;

/**
 * @author Dmitry Koval
 */
@Repository("messageHistoryDao")
public class MessageHistoryDaoImpl extends GenericDaoImpl<Long, MessageHistory> implements MessageHistoryDao {

    @Override
    public Class<MessageHistory> getEntityClass() {
        return MessageHistory.class;
    }

    @Override
    public List<MessageHistory> list(ListFilter<MessageHistory> filter) {
        MessageHistoryListFilter messageHistoryListFilter = (MessageHistoryListFilter) filter;

        PageCriteria pc = createPageCriteria(getEntityClass());
        CriteriaUtil.likeIfNotEmpty(pc, "connectorClient", messageHistoryListFilter.getConnectorClient());
        CriteriaUtil.likeIfNotEmpty(pc, "msgType", messageHistoryListFilter.getMsgType());
        CriteriaUtil.dateBetween(pc, "msgDateIn", messageHistoryListFilter.getMsgDateInFrom(), messageHistoryListFilter.getMsgDateInTill());
        CriteriaUtil.dateBetween(pc, "msgDateOut", messageHistoryListFilter.getMsgDateOutFrom(), messageHistoryListFilter.getMsgDateOutTill());
        CriteriaUtil.likeIfNotEmpty(pc, "maskedPan", messageHistoryListFilter.getMaskedPan());
        CriteriaUtil.likeIfNotEmpty(pc, "panInternalId", messageHistoryListFilter.getPanInternalId());
        CriteriaUtil.likeIfNotEmpty(pc, "panInternalGuid", messageHistoryListFilter.getPanInternalGuid());
        return pc.list(filter);
    }
}
