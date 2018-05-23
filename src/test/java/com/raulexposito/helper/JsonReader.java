package com.raulexposito.helper;

import com.google.gson.Gson;
import com.raulexposito.model.board.Piece;
import com.raulexposito.model.board.Placement;

import java.util.Map;

public interface JsonReader {

    default Map read(String json) {
        return new Gson().fromJson(json, Map.class);
    }

    default boolean contains(String json, String key, String value) {
        return read(json).get(key).equals(value);
    }

    default boolean contains(String json, String key, Double value) {
        return read(json).get(key).equals(value);
    }

    default boolean contains(String json, String key, Map<String, String> value) {
        return read(json).get(key).equals(value);
    }

    default boolean contains(String json, Placement key, String value) {
        return contains(json, key.toString(), value);
    }

    default boolean contains(String json, Placement key, Piece value) {
        return contains(json, key.toString(), value.toString());
    }
}
