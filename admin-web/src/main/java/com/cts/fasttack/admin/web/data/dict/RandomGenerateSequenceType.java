package com.cts.fasttack.admin.web.data.dict;

/**
 * Наборы сомволов: NUMERIC - цифры; ALPHA_NUMERIC - буквы и цифры; HEX - hex - символы.
 * Для генерации рандомных последовательностей.
 */
public enum RandomGenerateSequenceType {

    NUMERIC(true, false),
    ALPHA_NUMERIC(true, true),
    HEX(false, false);

    private boolean numeric;
    private boolean alpha;

    RandomGenerateSequenceType(boolean numeric, boolean alpha) {
        this.numeric = numeric;
        this.alpha = alpha;
    }

    public boolean isNumeric() {
        return numeric;
    }

    public boolean isAlpha() {
        return alpha;
    }
}
