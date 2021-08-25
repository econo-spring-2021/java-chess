package Chess.domain;

import Chess.domain.ChessUnit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChessBoard {
    public static int CHESSBOARD_ROW = 8;
    public static int CHESSBOARD_COLUMN = 8;
    public static int WHITE_SPECIAL_CHESS_UNIT_ROW = 0;
    public static int WHITE_PAWN_CHESS_INIT_ROW = 1;
    public static int BLACK_PAWN_CHESS_UNIT_ROW = ChessBoard.CHESSBOARD_ROW - 2;
    public static int BLACK_SPECIAL_CHESS_UNIT_ROW = ChessBoard.CHESSBOARD_ROW - 1;
    public static List<Class<? extends ChessUnit>> INITIAL_SPECIAL_CHESS_UNIT_POSITION = Arrays.asList(
            Rook.class,
            Knight.class,
            Bishop.class,
            Queen.class,
            King.class,
            Bishop.class,
            Knight.class,
            Rook.class
    );

    private final static ChessBoard instance = new ChessBoard();

    public static ChessBoard getInstance() {
        return instance;
    }

    private List<List<ChessUnit>> chessBoard = new ArrayList<>();

    private ChessBoard() {
        initializeChessGame();
    }

    public void initializeChessGame() {
        try {
            chessBoard.clear();
            initializeChessboard();
            initializeChessUnit();
        } catch (Exception e) {
            initializeChessboard();
        }
    }

    private void initializeChessboard() {
        for (int i = 0; i < CHESSBOARD_ROW; i++) {
            List<ChessUnit> boardRow = new ArrayList<>();
            for (int j = 0; j < CHESSBOARD_COLUMN; j++) {
                boardRow.add(new EmptyCell());
            }
            chessBoard.add(boardRow);
        }
    }

    private void initializeChessUnit() throws Exception {
        for (int i = 0; i < CHESSBOARD_COLUMN; i++) {
            setUnitFromCell(BLACK_SPECIAL_CHESS_UNIT_ROW, i, INITIAL_SPECIAL_CHESS_UNIT_POSITION.get(i).getConstructor(ChessUnitColor.class).newInstance(ChessUnitColor.BLACK));
            setUnitFromCell(BLACK_PAWN_CHESS_UNIT_ROW, i, new Pawn(ChessUnitColor.BLACK));
            setUnitFromCell(WHITE_SPECIAL_CHESS_UNIT_ROW, i, INITIAL_SPECIAL_CHESS_UNIT_POSITION.get(i).getConstructor(ChessUnitColor.class).newInstance(ChessUnitColor.WHITE));
            setUnitFromCell(WHITE_PAWN_CHESS_INIT_ROW, i, new Pawn(ChessUnitColor.WHITE));
        }
    }

    public ChessUnit getUnitFromCell(int r, int c) throws IndexOutOfBoundsException {
        return chessBoard.get(r).get(c);
    }

    public void setUnitFromCell(int r, int c, ChessUnit unit) throws IndexOutOfBoundsException {
        chessBoard.get(r).set(c, unit);
    }

    public String convertChessBoardToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int r = CHESSBOARD_ROW - 1; r >= 0; r--) {
            for (int c = 0; c < CHESSBOARD_COLUMN; c++) {
                stringBuilder.append(chessBoard.get(r).get(c).getTypeSymbol());
            }
            stringBuilder.append('\n');
        }

        return stringBuilder.toString();
    }
}
