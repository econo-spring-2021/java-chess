package Chess.domain;

import Chess.domain.ChessUnit.*;

import java.util.Arrays;
import java.util.List;

public class ChessBoard {
    public static final int CHESSBOARD_ROW = 8;
    public static final int CHESSBOARD_COLUMN = 8;
    public static final int WHITE_SPECIAL_CHESS_UNIT_ROW = ChessBoard.CHESSBOARD_ROW - 1;
    public static final int WHITE_PAWN_CHESS_INIT_ROW = ChessBoard.CHESSBOARD_ROW - 2;
    public static final int BLACK_PAWN_CHESS_UNIT_ROW = 1;
    public static final int BLACK_SPECIAL_CHESS_UNIT_ROW = 0;
    public static final List<Class<? extends Unit>> INITIAL_SPECIAL_CHESS_UNIT_POSITION = Arrays.asList(
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

    private Unit[][] chessBoard = new Unit[CHESSBOARD_ROW][CHESSBOARD_COLUMN];

    private ChessBoard() {
        initializeChessGame();
    }

    public void initializeChessGame() {
        try {
            initializeChessboard();
            initializeChessUnit();
        } catch (Exception e) {
            initializeChessboard();
        }
    }

    private void initializeChessboard() {
        for (int i = 0; i < CHESSBOARD_ROW; i++) {
            for (int j = 0; j < CHESSBOARD_COLUMN; j++) {
                chessBoard[i][j] = new EmptyCell();
            }
        }
    }

    private void initializeChessUnit() throws Exception {
        for (int i = 0; i < CHESSBOARD_COLUMN; i++) {
            setUnitFromCell(BLACK_SPECIAL_CHESS_UNIT_ROW, i, INITIAL_SPECIAL_CHESS_UNIT_POSITION.get(i).getConstructor(UnitColor.class).newInstance(UnitColor.BLACK));
            setUnitFromCell(BLACK_PAWN_CHESS_UNIT_ROW, i, new Pawn(UnitColor.BLACK));
            setUnitFromCell(WHITE_SPECIAL_CHESS_UNIT_ROW, i, INITIAL_SPECIAL_CHESS_UNIT_POSITION.get(i).getConstructor(UnitColor.class).newInstance(UnitColor.WHITE));
            setUnitFromCell(WHITE_PAWN_CHESS_INIT_ROW, i, new Pawn(UnitColor.WHITE));
        }
    }

    public void resetChessUnitOnChessBoard() {
        for (int i = 0; i < CHESSBOARD_ROW; i++) {
            for (int j = 0; j < CHESSBOARD_COLUMN; j++) {
                setUnitFromCell(i, j, new EmptyCell());
            }
        }
    }

    public Unit getUnitFromCell(int r, int c) throws IndexOutOfBoundsException {
        return chessBoard[r][c];
    }
    public Unit getUnitFromCell(Position position) throws IndexOutOfBoundsException {
        return chessBoard[position.getRow()][position.getCol()];
    }

    public void setUnitFromCell(int r, int c, Unit unit) throws IndexOutOfBoundsException {
        chessBoard[r][c] = unit;
    }

    public void setUnitFromCell(Position position, Unit unit) throws IndexOutOfBoundsException {
        chessBoard[position.getRow()][position.getCol()] = unit;
    }

    public String convertChessBoardToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Unit[] row : chessBoard) {
            for (Unit unit : row) {
                stringBuilder.append(unit.getTypeSymbol());
            }
            stringBuilder.append('\n');
        }

        return stringBuilder.toString();
    }

    public Boolean isWhiteKingAlive() {
        for (Unit[] row : chessBoard) {
            for (Unit unit : row) {
                if (unit.getType().equals(UnitType.KING) && unit.getColor().equals(UnitColor.WHITE)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isBlackKingAlive() {
        for (Unit[] row : chessBoard) {
            for (Unit unit : row) {
                if (unit.getType().equals(UnitType.KING) && unit.getColor().equals(UnitColor.BLACK)) {
                    return true;
                }
            }
        }

        return false;
    }
}
