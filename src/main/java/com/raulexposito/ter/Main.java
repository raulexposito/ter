package com.raulexposito.ter;

import com.raulexposito.ter.model.match.Match;
import com.raulexposito.ter.model.match.Report;
import com.raulexposito.ter.model.player.Player;
import com.raulexposito.ter.model.player.RandomPlayer;

import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Piece.CROSS;

public class Main {

    public static void main(String[] args) {
        final Player cross = new RandomPlayer(CROSS);
        final Player circle = new RandomPlayer(CIRCLE);

        final Match match = new Match(cross, circle, 10);
        final Report report = match.getReport();
        System.out.println(report.toJSON());
    }
}
