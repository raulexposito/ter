package com.raulexposito.helper.json;

import com.raulexposito.model.board.Placement;

public interface JsonStringReader {

    default InnerString theValue(Placement key) {
        return new InnerString(key.toString());
    }

    default InnerString theValue(String key) {
        return new InnerString(key);
    }

    class InnerString extends InnerResult<String> {

        InnerString(String key) {
            super(key);
        }

        @Override
        public String of(String json) {
            return read(json).get(key).toString();
        }
    }
}
