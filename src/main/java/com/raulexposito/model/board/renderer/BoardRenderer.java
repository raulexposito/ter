package com.raulexposito.model.board.renderer;

import com.google.gson.Gson;
import com.raulexposito.model.board.Content;
import com.raulexposito.model.board.Placement;

import java.util.Map;

@SuppressWarnings("PMD.UnusedPrivateField")
public class BoardRenderer {
    private final String TL;
    private final String TC;
    private final String TR;
    private final String ML;
    private final String C;
    private final String MR;
    private final String BL;
    private final String BC;
    private final String BR;

    public BoardRenderer(Map<Placement, Content> boardContent) {
        TL = boardContent.get(Placement.TOP_LEFT).toString();
        TC = boardContent.get(Placement.TOP_CENTER).toString();
        TR = boardContent.get(Placement.TOP_RIGHT).toString();
        ML = boardContent.get(Placement.MIDDLE_LEFT).toString();
        C = boardContent.get(Placement.CENTER).toString();
        MR = boardContent.get(Placement.MIDDLE_RIGHT).toString();
        BL = boardContent.get(Placement.BOTTOM_LEFT).toString();
        BC = boardContent.get(Placement.BOTTOM_CENTER).toString();
        BR = boardContent.get(Placement.BOTTOM_RIGHT).toString();
    }

    public String toJSON() {
        return new Gson().toJson(this);
    }
}
