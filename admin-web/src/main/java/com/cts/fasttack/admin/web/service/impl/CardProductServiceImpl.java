package com.cts.fasttack.admin.web.service.impl;

import com.cts.fasttack.admin.web.converter.CardProductDtoToDomainConverter;
import com.cts.fasttack.admin.web.converter.CardProductToDtoConverter;
import com.cts.fasttack.admin.web.dao.CardProductDao;
import com.cts.fasttack.admin.web.data.domain.CardProduct;
import com.cts.fasttack.admin.web.data.dto.CardProductDto;

import com.cts.fasttack.admin.web.service.CardProductService;
import com.cts.fasttack.common.core.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service("cardProductService")
public class CardProductServiceImpl extends GenericServiceImpl<String, CardProductDto, CardProduct, CardProductDao> implements CardProductService {

    @Autowired
    public CardProductServiceImpl(CardProductDao dao, CardProductToDtoConverter domainToDtoConverter, CardProductDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CardProductDto> listAll() {
        return super.listAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public boolean isNotCollisionRange(final List<CardProductDto> list, final CardProductDto item) {
        boolean isNotDouble = isNotDouble(list, item);
        boolean isOutSide = isOutSide(list, item);
        boolean isInSide = isInSide(list, item);

        return item.getBeginRange().length() == item.getEndRange().length()
                && Long.valueOf(item.getBeginRange()) < Long.valueOf(item.getEndRange())
                && isNotDouble
                && (isOutSide || isInSide);
    }

    private void sortByExtension (final List<CardProductDto> list) {
        Collections.sort(list, new Comparator<CardProductDto>() {
            @Override
            public int compare(CardProductDto o1, CardProductDto o2) {
                if (o1.equals(o2)) return 0;
                if (Long.valueOf(o1.getBeginRange()) <= Long.valueOf(o2.getBeginRange()) && Long.valueOf(o2.getEndRange()) <= Long.valueOf(o1.getEndRange())) return 1;
                if (Long.valueOf(o2.getBeginRange()) <= Long.valueOf(o1.getBeginRange()) && Long.valueOf(o1.getEndRange()) <= Long.valueOf(o2.getEndRange())) return -1;
                return 0;
            }});
    }

    private boolean isNotDouble(final List<CardProductDto> list, final CardProductDto item) {
        return list!=null && !list.isEmpty() && item!=null
                ? !list.contains(item)
                : false;
    }

    private boolean isInSide(final List<CardProductDto> list, final CardProductDto item) {
        boolean notNullAndNotEqual = list!=null && !list.isEmpty() && item!=null
                ? !list.contains(item)
                : false;
        if (!notNullAndNotEqual) return false;

        sortByExtension(list);
        for (CardProductDto cardProduct: list) {
            if (Long.valueOf(item.getBeginRange()) <= Long.valueOf(cardProduct.getEndRange())) {
                if (Long.valueOf(cardProduct.getBeginRange()) <= Long.valueOf(item.getBeginRange())) {
                    return Long.valueOf(item.getEndRange()) <= Long.valueOf(cardProduct.getEndRange())
                            ? true
                            : false;
                }
            }
        }

        CardProductDto lastItem = list.get(list.size()-1);
        return Long.valueOf(item.getEndRange()) <= Long.valueOf(lastItem.getEndRange())
                ? true
                : false;
    }

    private boolean isOutSide(final List<CardProductDto> list, final CardProductDto item) {
        boolean isNotNull = list!=null && !list.isEmpty() && item!=null;
        if (!isNotNull) return false;

        sortByExtension(list);
        CardProductDto lastItem = list.get(list.size()-1);

        boolean  isBothSides = Long.valueOf(item.getBeginRange()) <= Long.valueOf(lastItem.getBeginRange()) && Long.valueOf(lastItem.getEndRange()) <= Long.valueOf(item.getEndRange());
        boolean   isLeftSide = Long.valueOf(item.getEndRange()) <= Long.valueOf(lastItem.getBeginRange());
        boolean isRightSides = Long.valueOf(lastItem.getEndRange()) <= Long.valueOf(item.getBeginRange());
        boolean     notEqual = !lastItem.equals(item);
        boolean    isOutSide = isBothSides || isLeftSide || isRightSides;

        return notEqual && isOutSide;
    }
}
