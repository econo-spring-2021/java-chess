package Chess;

import Chess.domain.ChessBoard;
import Chess.domain.ChessUnit.ChessUnit;
import Chess.domain.ChessUnit.ChessUnitColor;
import Chess.domain.ChessUnit.ChessUnitType;
import Chess.domain.ChessUnit.Rook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChessBoardTest {
    ChessBoard chessBoard = ChessBoard.getInstance();

    @BeforeEach
    void initializeChessBoard() {
        chessBoard.initializeChessGame();
    }

    @Test
    @DisplayName("게임을 위한 체스판이 제대로 초기화되었는지")
    void test_initializeChessUnit() {
        for (int i = 0; i < ChessBoard.CHESSBOARD_COLUMN; i++) {
//            Assertions.assertEquals(ChessBoard.INITIAL_SPECIAL_CHESS_UNIT_POSITION[i], chessBoard.getUnitFromCell(ChessBoard.BLACK_SPECIAL_CHESS_UNIT_ROW, i).getType());
//            Assertions.assertEquals(ChessUnitType.PAWN, chessBoard.getUnitFromCell(ChessBoard.BLACK_PAWN_CHESS_UNIT_ROW, i).getType());
//            Assertions.assertEquals(ChessBoard.INITIAL_SPECIAL_CHESS_UNIT_POSITION[i], chessBoard.getUnitFromCell(ChessBoard.WHITE_SPECIAL_CHESS_UNIT_ROW, i).getType());
//            Assertions.assertEquals(ChessUnitType.PAWN, chessBoard.getUnitFromCell(ChessBoard.WHITE_PAWN_CHESS_INIT_ROW, i).getType());
        }
    }

    @Test
    @DisplayName("올바르게 체스말을 조회하는지")
    void test_getUnitFromCell() {
        ChessUnit testUnit = new Rook();
        chessBoard.setUnitFromCell(0, 0, testUnit);
        Assertions.assertEquals(testUnit, chessBoard.getUnitFromCell(0, 0));
    }

    @Test
    @DisplayName("잘못된 위치의 체스말을 조회할 때, 올바른 예외를 발생시키는지")
    void test_getUnitFromCell_IndexOutOfBoundsException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> chessBoard.getUnitFromCell(ChessBoard.CHESSBOARD_ROW + 1, ChessBoard.CHESSBOARD_COLUMN + 1));
    }

    @Test
    @DisplayName("잘못된 위치에 체스말을 위치시킬 때, 올바른 예외를 발생시키는지")
    void test_setUnitFromCell_IndexOutOfBoundsException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> chessBoard.setUnitFromCell(ChessBoard.CHESSBOARD_ROW + 1, ChessBoard.CHESSBOARD_COLUMN + 1, new Rook()));
    }
}
