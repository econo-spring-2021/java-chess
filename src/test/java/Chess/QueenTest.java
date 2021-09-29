package Chess;

import Chess.domain.ChessBoard;
import Chess.domain.ChessUnit.UnitColor;
import Chess.domain.ChessUnit.Pawn;
import Chess.domain.ChessUnit.Queen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueenTest {

    ChessBoard chessBoard = ChessBoard.getInstance();
    @BeforeEach
    void initChessBoard() {
        chessBoard.resetChessUnitOnChessBoard();
    }

    @Test
    @DisplayName("퀸이 움직일 수 있는 움직임(킹)에 대한 이동가능 여부를 올바르게 판단하는개")
    void test_queen_isAbleToMove_kingMovement() {
        Queen queen = new Queen();
        Assertions.assertTrue(queen.isAbleToMove(4, 4, 5, 5));
    }

    @Test
    @DisplayName("퀸이 움직일 수 있는 움직임(비숍)에 대한 이동가능 여부를 올바르게 판단하는개")
    void test_queen_isAbleToMove_bishopMovement() {
        Queen queen = new Queen();
        Assertions.assertTrue(queen.isAbleToMove(4, 4, 7, 7));
    }

    @Test
    @DisplayName("퀸이 움직일 수 없는 움직임에 대한 이동가능 여부를 올바르게 판단하는개")
    void test_queen_isAbleToMove_impossibleMovement() {
        Queen queen = new Queen();
        Assertions.assertFalse(queen.isAbleToMove(4, 4, 5, 6));
    }


    @Test
    @DisplayName("퀸이 이동경로에 장애물이 있는 경우 이동가능 여부를 올바르게 판단하는가")
    void test_queen_isAbleToMove_obstacleMovement() {
        Queen queen = new Queen();
        chessBoard.setUnitFromCell(0, 0, queen);
        Pawn pawn = new Pawn();
        chessBoard.setUnitFromCell(1, 1, pawn);

        Assertions.assertFalse(queen.isAbleToMove(0, 0, 5, 5));
    }

    @Test
    @DisplayName("퀸이 목적지에 아군이 있는 경우 이동가능 여부를 올바르게 판단하는가")
    void test_queen_isAbleToMove_teammateOnDestination() {
        Queen queen = new Queen();
        chessBoard.setUnitFromCell(0, 0, queen);
        Pawn pawn = new Pawn();
        chessBoard.setUnitFromCell(5, 5, pawn);

        Assertions.assertFalse(queen.isAbleToMove(0, 0, 5, 5));
    }

    @Test
    @DisplayName("퀸이 목적지에 적군이 있는 경우 이동가능 여부를 올바르게 판단하는가")
    void test_queen_isAbleToMove_enemyOnDestination() {
        Queen queen = new Queen();
        chessBoard.setUnitFromCell(0, 0, queen);
        Pawn pawn = new Pawn(UnitColor.BLACK);
        chessBoard.setUnitFromCell(5, 5, pawn);

        Assertions.assertTrue(queen.isAbleToMove(0, 0, 5, 5));
    }
}
