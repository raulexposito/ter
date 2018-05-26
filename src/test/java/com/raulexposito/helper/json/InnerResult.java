package com.raulexposito.helper.json;

import com.google.gson.Gson;

import java.util.Map;

abstract class InnerResult<T> {

    protected String key;

    InnerResult(String key) {
        this.key = key;
    }

    abstract T of(String json);

    Map read(String json) {
        return new Gson().fromJson(json, Map.class);
    }
}