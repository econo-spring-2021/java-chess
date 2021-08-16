package Chess;

import Chess.domain.ChessBoard;
import Chess.domain.ChessUnitType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChessBoardTest {
    ChessBoard chessBoard;

    @BeforeEach
    void initializeChessBoard() {
        chessBoard = new ChessBoard();
    }

    @Test
    @DisplayName("체스판이 제대로 생성되었는지")
    void test_initializeChessBoard() {
        for (int i = 0; i < ChessBoard.CHESSBOARD_ROW; i++) {
            for (int j = 0; j < ChessBoard.CHESSBOARD_COLUMN; j++) {
                Assertions.assertEquals(ChessUnitType.EMPTY, chessBoard.getUnitFromCell(i, j).getType());
            }
        }
    }

    @Test
    @DisplayName("잘못된 위치의 체스말을 조회할 때, 올바른 예외를 발생시키는지")
    void test_getUnitFromCell_IndexOutOfBoundsException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> chessBoard.getUnitFromCell(ChessBoard.CHESSBOARD_ROW + 1, ChessBoard.CHESSBOARD_COLUMN + 1));
    }

    @Test
    @DisplayName("체스판에 시작 체스말을 제대로 생성되었는지")
    void test_initializeChessUnitOnChessBoard() {
        chessBoard.initializeChessUnit();

        for (int i = 0; i < ChessBoard.CHESSBOARD_COLUMN; i++) {
            Assertions.assertEquals(ChessBoard.INITIAL_SPECIAL_CHESS_UNIT_POSITION[i], chessBoard.getUnitFromCell(ChessBoard.BLACK_SPECIAL_CHESS_UNIT_ROW, i).getType());
            Assertions.assertEquals(ChessUnitType.PAWN, chessBoard.getUnitFromCell(ChessBoard.BLACK_PAWN_CHESS_UNIT_ROW, i).getType());
            Assertions.assertEquals(ChessBoard.INITIAL_SPECIAL_CHESS_UNIT_POSITION[i], chessBoard.getUnitFromCell(ChessBoard.WHITE_SPECIAL_CHESS_UNIT_ROW, i).getType());
            Assertions.assertEquals(ChessUnitType.PAWN, chessBoard.getUnitFromCell(ChessBoard.WHITE_PAWN_CHESS_INIT_ROW, i).getType());
        }
    }
}
