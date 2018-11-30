package com.cts.fasttack.admin.web.data.dto;

import com.cts.fasttack.admin.web.rest.CardProductRestClient;
import com.cts.fasttack.admin.web.validation.cardProduct.RangeLengthCheck;
import com.cts.fasttack.admin.web.validation.cardProduct.ValidateCardProductCreate;
import com.cts.fasttack.admin.web.validation.common.UniqueIdentifier;
import com.cts.fasttack.admin.web.validation.operation.EntityCreateOperation;
import com.cts.fasttack.admin.web.validation.operation.RangeLengthOperation;
import com.cts.fasttack.common.core.dto.IdentifierDto;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.util.Objects;

@ValidateCardProductCreate(message = "{cardProduct.validation.create.ranges}")
public class CardProductDto extends IdentifierDto<String> {

    @NotEmpty(message = "{cardProduct.validation.empty.productConfigId}")
    @Size(max = 30)
    @UniqueIdentifier(groups = EntityCreateOperation.class, service = CardProductRestClient.class, message = "{cardProduct.validation.exist.productConfigId}")
    private String productConfigId;

    @RangeLengthCheck(groups = RangeLengthOperation.class)
    private String beginRange;

    @RangeLengthCheck(groups = RangeLengthOperation.class)
    private String endRange;

    public String getProductConfigId() {
        return productConfigId;
    }

    public void setProductConfigId(String productConfigId) {
        this.productConfigId = productConfigId;
    }

    public String getBeginRange() {
        return beginRange;
    }

    public void setBeginRange(String beginRange) {
        this.beginRange = beginRange;
    }

    public String getEndRange() {
        return endRange;
    }

    public void setEndRange(String endRange) {
        this.endRange = endRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardProductDto that = (CardProductDto) o;
        return Objects.equals(beginRange, that.beginRange) &&
                Objects.equals(endRange, that.endRange);
    }

    @Override
    public int hashCode() {

        return Objects.hash(beginRange, endRange);
    }
}
