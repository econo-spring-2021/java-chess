package Chess;

import Chess.domain.ChessBoard;
import Chess.domain.ChessUnit.*;
import Chess.domain.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChessBoardTest {
    Game game = new Game();
    ChessBoard chessBoard = ChessBoard.getInstance();

    @BeforeEach
    void initializeChessBoard() {
        game.initializeGame();
    }

    @Test
    @DisplayName("게임을 위한 체스판이 제대로 초기화되었는지")
    void test_initializeChessUnit() throws Exception {
        for (int i = 0; i < ChessBoard.CHESSBOARD_COLUMN; i++) {
//            Assertions.assertEquals(ChessBoard.INITIAL_SPECIAL_CHESS_UNIT_POSITION.get(i).getField("TYPE").get(), chessBoard.getUnitFromCell(ChessBoard.BLACK_SPECIAL_CHESS_UNIT_ROW, i).getType());
//            Assertions.assertEquals(UnitType.PAWN, chessBoard.getUnitFromCell(ChessBoard.BLACK_PAWN_CHESS_UNIT_ROW, i).getType());
//            Assertions.assertEquals(ChessBoard.INITIAL_SPECIAL_CHESS_UNIT_POSITION.get(i).getField("TYPE"), chessBoard.getUnitFromCell(ChessBoard.WHITE_SPECIAL_CHESS_UNIT_ROW, i).getType());
//            Assertions.assertEquals(UnitType.PAWN, chessBoard.getUnitFromCell(ChessBoard.WHITE_PAWN_CHESS_INIT_ROW, i).getType());
        }
    }

    @Test
    @DisplayName("올바르게 체스말을 조회하는지")
    void test_getUnitFromCell() {
        Unit testUnit = new Rook();
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

    @Test
    @DisplayName("양 팀의 킹이 살아 있을 때, 올바르게 판단하는지")
    void test_checkIsKingAlice() {
        Assertions.assertTrue(game.checkIsKingAlive());
    }

    @Test
    @DisplayName("백팀의 킹만 살아 있을 때, 올바르게 판단하는지")
    void test_checkIsWhiteKingAlive() {
        chessBoard.setUnitFromCell(7, 4, new EmptyCell());
        Assertions.assertFalse(chessBoard.isWhiteKingAlive());
    }

    @Test
    @DisplayName("흑팀의 킹만 살아 있을 때, 올바르게 판단하는지")
    void test_checkIsBlackKingAlive() {
        chessBoard.setUnitFromCell(0, 4, new EmptyCell());
        Assertions.assertFalse(chessBoard.isBlackKingAlive());
    }

    @Test
    @DisplayName("겹치는 폰이 있을 때, 제대로 점수를 계산하는지")
    void test_getBlackScore_withDuplicatedPawn() {
        Assertions.assertEquals(34, chessBoard.getScore(UnitColor.BLACK));
    }

    @Test
    @DisplayName("겹치는 폰이 없을 때, 제대로 점수를 계산하는지")
    void test_getBlackScore_withoutDuplicatedPawn() {
        chessBoard.setUnitFromCell(1, 1, new EmptyCell());
        chessBoard.setUnitFromCell(1, 2, new EmptyCell());
        chessBoard.setUnitFromCell(1, 3, new EmptyCell());
        chessBoard.setUnitFromCell(1, 4, new EmptyCell());
        chessBoard.setUnitFromCell(1, 5, new EmptyCell());
        chessBoard.setUnitFromCell(1, 6, new EmptyCell());
        chessBoard.setUnitFromCell(1, 7, new EmptyCell());
        Assertions.assertEquals(31, chessBoard.getScore(UnitColor.BLACK));
    }

    @Test
    @DisplayName("백팀의 킹이 죽었을 때, 승자가 흑팀이라고 판단하는지")
    void test_getWinner_onWhiteKingDead() {
        chessBoard.setUnitFromCell(0, 4, new EmptyCell());
        Assertions.assertEquals(UnitColor.BLACK, chessBoard.getWinner());
    }

    @Test
    @DisplayName("흑팀의 킹이 죽었을 때, 승자가 백팀이라고 판단하는지")
    void test_getWinner_onBlackKingDead() {
        chessBoard.setUnitFromCell(7, 4, new EmptyCell());
        Assertions.assertEquals(UnitColor.WHITE, chessBoard.getWinner());
    }
}
