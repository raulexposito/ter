package com.raulexposito.helper.json;

import com.raulexposito.model.board.Placement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public interface JsonMapReader {

    default InnerMap theMappingValue(String key) {
        return new InnerMap(key);
    }

    class InnerMap extends InnerResult<Map<String, Placement>> {

        InnerMap(String key) {
            super(key);
        }

        @Override
        public Map<String, Placement> of(String json) {
            Map<String, String> readValue = (Map<String, String>) read(json).get(key);
            Map<String, Placement> returnValue = new HashMap<>();
            readValue.keySet().forEach(key -> {
                returnValue.put(key, getPlacement(readValue.get(key)));
            });
            return returnValue;
        }

        private Placement getPlacement(String value) {
            return Arrays.stream(Placement.values())
                    .filter(it -> it.toString().equals(value))
                    .findFirst().get();
        }
    }
}
