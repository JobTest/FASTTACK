package com.cts.fasttack.crypto.server.converter;

import com.cts.fasttack.common.core.converter.IdentifierToDtoConverter;
import com.cts.fasttack.crypto.server.data.EncKey;
import com.cts.fasttack.crypto.server.dto.EncKeyDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class EncKeyToDtoConverter extends IdentifierToDtoConverter<Long, EncKey, EncKeyDto> {

    protected EncKeyDto generateTarget() {
        return new EncKeyDto();
    }

    @Override
    public void convert(EncKey source, EncKeyDto target) {
        convertPrimitives(source,target);
        target.setCapacity(source.getCapacity());
        target.setStatusCode(source.getStatusCode());
        target.setKeyValue(source.getKeyValue());
        target.setCheckValue(source.getCheckValue());
        target.setEffDate(source.getEffDate());
        target.setExpDate(source.getExpDate());
        target.setPublicExponent(source.getPublicExponent());
        target.setWrappingKey(source.getWrappingKey());
        target.setNew(source.isNew());
    }

    @Override
    public void convertPrimitives(EncKey source, EncKeyDto target) {
        target.setId(source.getId());
        target.setKeyType(source.getKeyType());
        target.setRefCode(source.getRefCode());
    }

    @Override
    public void convert(Collection<EncKey> sources, Collection<EncKeyDto> targets) {
        if (sources !=null) {
            for (EncKey source : sources) {
                EncKeyDto target = generateTarget();
                convert(source, target);
                targets.add(target);
            }
        }
    }

    @Override
    public List<EncKeyDto> convert(Collection<EncKey> sources) {
        List<EncKeyDto> targets = new ArrayList<>(sources.size());
        convert(sources, targets);
        return targets;
    }

    @Override
    public EncKeyDto convert(EncKey source) {
        if (source != null) {
            EncKeyDto target = generateTarget();
            convert(source, target);
            return target;
        }
        return null;
    }
}
