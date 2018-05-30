package com.raulexposito.ter.renderer;

import com.raulexposito.ter.model.board.Placement;

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
