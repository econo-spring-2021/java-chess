package Chess.domain;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {
    public static int CHESSBOARD_ROW = 8;
    public static int CHESSBOARD_COLUMN = 8;

    private List<List<Character>> chessBoard = new ArrayList<>();

    public ChessBoard() {
        initChessboard();
    }

    private void initChessboard() {
        for (int i = 0; i < CHESSBOARD_ROW; i++) {
            List<Character> boardRow = new ArrayList<>();
            for (int j = 0; j < CHESSBOARD_COLUMN; j++) {
                boardRow.add('.');
            }
            chessBoard.add(boardRow);
        }
    }

    public Character getUnitFromCell(int r, int c) throws IndexOutOfBoundsException {
        return chessBoard.get(r).get(c);
    }
}
