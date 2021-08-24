package Chess.domain;

import Chess.domain.ChessUnit.ChessUnit;
import Chess.domain.ChessUnit.ChessUnitColor;
import Chess.domain.ChessUnit.ChessUnitType;
import Chess.domain.ChessUnit.Rook;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {
    public static int CHESSBOARD_ROW = 8;
    public static int CHESSBOARD_COLUMN = 8;
    public static int BLACK_SPECIAL_CHESS_UNIT_ROW = 0;
    public static int BLACK_PAWN_CHESS_UNIT_ROW = 1;
    public static int WHITE_SPECIAL_CHESS_UNIT_ROW = ChessBoard.CHESSBOARD_ROW - 1;
    public static int WHITE_PAWN_CHESS_INIT_ROW = ChessBoard.CHESSBOARD_ROW - 2;
    public static ChessUnitType[] INITIAL_SPECIAL_CHESS_UNIT_POSITION = {
            ChessUnitType.ROOK,
            ChessUnitType.KNIGHT,
            ChessUnitType.BISHOP,
            ChessUnitType.QUEEN,
            ChessUnitType.KING,
            ChessUnitType.BISHOP,
            ChessUnitType.KNIGHT,
            ChessUnitType.ROOK
    };

    private static ChessBoard instance = new ChessBoard();
    public static ChessBoard getInstance() { return instance; }

    private List<List<ChessUnit>> chessBoard = new ArrayList<>();

    private ChessBoard() {
        initializeChessGame();
    }

    public void initializeChessGame(){
        chessBoard.clear();
        initializeChessboard();
        initializeChessUnit();
    }

    private void initializeChessboard() {
        for (int i = 0; i < CHESSBOARD_ROW; i++) {
            List<ChessUnit> boardRow = new ArrayList<>();
            for (int j = 0; j < CHESSBOARD_COLUMN; j++) {
                boardRow.add(new Rook());
            }
            chessBoard.add(boardRow);
        }
    }

    private void initializeChessUnit() {
        for (int i = 0; i < CHESSBOARD_COLUMN; i++) {
//            setUnitFromCell(BLACK_SPECIAL_CHESS_UNIT_ROW, i, new ChessUnit(INITIAL_SPECIAL_CHESS_UNIT_POSITION[i], ChessUnitColor.BLACK));
//            setUnitFromCell(BLACK_PAWN_CHESS_UNIT_ROW, i, new ChessUnit(ChessUnitType.PAWN, ChessUnitColor.BLACK));
//            setUnitFromCell(WHITE_SPECIAL_CHESS_UNIT_ROW, i, new ChessUnit(INITIAL_SPECIAL_CHESS_UNIT_POSITION[i], ChessUnitColor.WHITE));
//            setUnitFromCell(WHITE_PAWN_CHESS_INIT_ROW, i, new ChessUnit(ChessUnitType.PAWN, ChessUnitColor.WHITE));

            setUnitFromCell(BLACK_SPECIAL_CHESS_UNIT_ROW, i, new Rook());
            setUnitFromCell(BLACK_PAWN_CHESS_UNIT_ROW, i, new Rook());
            setUnitFromCell(WHITE_SPECIAL_CHESS_UNIT_ROW, i, new Rook());
            setUnitFromCell(WHITE_PAWN_CHESS_INIT_ROW, i, new Rook());
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
        for (List<ChessUnit> row : chessBoard) {
            for (ChessUnit unit : row) {
                stringBuilder.append(unit.getTypeSymbol());
            }
            stringBuilder.append('\n');
        }

        return stringBuilder.toString();
    }
}
