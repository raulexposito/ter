package com.raulexposito.ter.model.match.summary;

import com.raulexposito.ter.model.game.result.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Overall {

    // ------------------------------------------------------------------------
    // ATTRIBUTES
    // ------------------------------------------------------------------------

    private final List<Result> results;
    private final UUID uuid;
    private final Long starts;
    private final Long ends;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    public Overall(List<Result> results, UUID uuid, Long starts, Long ends) {
        this.results = new ArrayList<>(results);
        this.uuid = uuid;
        this.starts = starts;
        this.ends = ends;
    }

    // ------------------------------------------------------------------------
    // GETTERS
    // ------------------------------------------------------------------------

    public String getId() {
        return uuid.toString();
    }

    public Long getStarts() {
        return starts;
    }

    public Long getEnds() {
        return ends;
    }

    public Long getDuration() {
        return ends - starts;
    }

    public Integer getLength() {
        return results.size();
    }

    public Long getDraws() {
        return results.parallelStream().filter(Result::isDrawn).count();
    }

    public Long getVictories() {
        return results.parallelStream().filter(Result::isVictory).count();
    }


    /*

    "id": "ab0359be-eab3-4d2a-b47d-f495039fc075",
                "started": "1529767084619",
                "ended": "1529767084649",
                "duration": "30",
                "length": "10",
                "victories": "10",
                "draws": "0",

    */
}
