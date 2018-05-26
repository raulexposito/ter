package com.raulexposito.helper.json;

import java.math.BigDecimal;

public interface JsonNumericReader {

    default InnerInteger theNumericValue(String key) {
        return new InnerInteger(key);
    }

    class InnerInteger extends InnerResult<Integer> {

        InnerInteger(String key) {
            super(key);
        }

        @Override
        public Integer of(String json) {
            return new BigDecimal(read(json).get(key).toString()).intValue();
        }
    }
}
