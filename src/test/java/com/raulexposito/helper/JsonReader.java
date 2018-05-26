package com.raulexposito.helper;

import com.google.gson.Gson;
import com.raulexposito.model.board.Piece;
import com.raulexposito.model.board.Placement;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public interface JsonReader {

    default InnerString theValue(Placement key) {
        return new InnerString(key.toString());
    }

    default InnerString theValue(String key) {
        return new InnerString(key);
    }

    default InnerInteger theNumericValue(String key) {
        return new InnerInteger(key);
    }

    default InnerMap theMappingValue(String key) {
        return new InnerMap(key);
    }

    default InnerPiece thePiece(Placement key) {
        return new InnerPiece(key.toString());
    }

    class InnerString extends InnerResult<String> {

        InnerString(String key) {
            super(key);
        }

        @Override
        public String of (String json) {
            return read(json).get(key).toString();
        }
    }

    class InnerInteger extends InnerResult<Integer> {

        InnerInteger(String key) {
            super(key);
        }

        @Override
        public Integer of (String json) {
            return new BigDecimal(read(json).get(key).toString()).intValue();
        }
    }

    class InnerPiece extends InnerResult<Piece> {

        InnerPiece(String key) {
            super(key);
        }

        @Override
        public Piece of (String json) {
            return Arrays.stream(Piece.values())
                    .filter(it -> it.toString().equals(read(json).get(key)))
                    .findFirst().get();
        }
    }

    class InnerMap extends InnerResult<Map<String, Placement>> {

        InnerMap(String key) {
            super(key);
        }

        @Override
        public Map<String, Placement> of (String json) {
            Map<String, String> readValue = (Map<String, String>) read(json).get(key);
            Map<String, Placement> returnValue = new HashMap<>();
            readValue.keySet().forEach(key -> {
                    returnValue.put(key, getPlacement(readValue.get(key)));
            });
            return returnValue;
        }

        private Placement getPlacement (String value) {
            return Arrays.stream(Placement.values())
                    .filter(it -> it.toString().equals(value))
                    .findFirst().get();
        }
    }

    abstract class InnerResult<T> {
        String key;

        InnerResult(String key) {
            this.key = key;
        }

        abstract T of (String json);

        Map read(String json) {
            return new Gson().fromJson(json, Map.class);
        }
    }
}
