package Chess;

import Chess.domain.ChessBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChessTest {
    ChessBoard chessBoard;

    @BeforeEach
    void initChessBoard() {
        chessBoard = new ChessBoard();
    }

    @Test
    @DisplayName("체스판이 제대로 생성되었는지")
    void test_initChessBoard() {
        for (int i = 0; i < ChessBoard.CHESSBOARD_ROW; i++) {
            for (int j = 0; j < ChessBoard.CHESSBOARD_COLUMN; j++) {
                Assertions.assertEquals('.', chessBoard.getUnitFromCell(i, j));
            }
        }
    }

    @Test
    @DisplayName("잘못된 위치의 체스말을 조회할 때, 올바른 예외를 발생시키는지")
    void test_getUnitFromCell_IndexOutOfBoundsException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> chessBoard.getUnitFromCell(ChessBoard.CHESSBOARD_ROW + 1, ChessBoard.CHESSBOARD_COLUMN + 1));
    }
}
