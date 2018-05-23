package com.raulexposito.model.board.renderer;

import com.google.gson.Gson;
import com.raulexposito.model.board.Content;
import com.raulexposito.model.board.Placement;

import java.util.Map;

import static com.raulexposito.model.board.Placement.*;

@SuppressWarnings("PMD.UnusedPrivateField")
public class BoardRenderer {
    private final String TL;
    private final String TC;
    private final String TR;
    private final String ML;
    private final String CE;
    private final String MR;
    private final String BL;
    private final String BC;
    private final String BR;

    public BoardRenderer(Map<Placement, Content> boardContent) {
        TL = boardContent.get(TOP_LEFT).toString();
        TC = boardContent.get(TOP_CENTER).toString();
        TR = boardContent.get(TOP_RIGHT).toString();
        ML = boardContent.get(MIDDLE_LEFT).toString();
        CE = boardContent.get(CENTER).toString();
        MR = boardContent.get(MIDDLE_RIGHT).toString();
        BL = boardContent.get(BOTTOM_LEFT).toString();
        BC = boardContent.get(BOTTOM_CENTER).toString();
        BR = boardContent.get(BOTTOM_RIGHT).toString();
    }

    public String toJSON() {
        return new Gson().toJson(this);
    }
}
