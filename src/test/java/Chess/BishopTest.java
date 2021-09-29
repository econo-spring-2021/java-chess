package Chess;

import Chess.domain.ChessBoard;
import Chess.domain.ChessUnit.Bishop;
import Chess.domain.ChessUnit.ChessUnitColor;
import Chess.domain.ChessUnit.Pawn;
import Chess.domain.ChessUnit.Rook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BishopTest {

    ChessBoard chessBoard = ChessBoard.getInstance();
    @BeforeEach
    void initChessBoard() {
        chessBoard.resetChessUnitOnChessBoard();
    }

    @Test
    @DisplayName("비숍이 움직일 수 있는 움직임에 대한 이동가능 여부를 올바르게 판단하는가")
    void test_bishop_isAbleToMove_possibleMovement() {
        Bishop bishop = new Bishop();
        Assertions.assertTrue(bishop.isAbleToMove(2, 2, 7, 7));
    }

    @Test
    @DisplayName("비숍이 움직일 수 없는 움직임에 대한 이동가능 여부를 올바르게 판단하는가")
    void test_bishop_isAbleToMove_impossibleMovement() {
        Bishop bishop = new Bishop();
        Assertions.assertFalse(bishop.isAbleToMove(2, 2, 2, 7));
    }

    @Test
    @DisplayName("비숍이 이동경로에 장애물이 있는 경우 이동가능 여부를 올바르게 판단하는가")
    void test_bishop_isAbleToMove_obstacleMovement() {
        Bishop bishop = new Bishop();
        chessBoard.setUnitFromCell(0, 0, bishop);
        Pawn pawn = new Pawn();
        chessBoard.setUnitFromCell(1, 1, pawn);

        Assertions.assertFalse(bishop.isAbleToMove(0, 0, 5, 5));
    }


    @Test
    @DisplayName("비숍이 목적지에 아군이 있는 경우 이동가능 여부를 올바르게 판단하는가")
    void test_bishop_isAbleToMove_teammateOnDestination() {
        Bishop bishop = new Bishop();
        chessBoard.setUnitFromCell(0, 0, bishop);
        Pawn pawn = new Pawn();
        chessBoard.setUnitFromCell(5, 5, pawn);

        Assertions.assertFalse(bishop.isAbleToMove(0, 0, 5, 5));
    }

    @Test
    @DisplayName("비숍이 목적지에 적군이 있는 경우 이동가능 여부를 올바르게 판단하는가")
    void test_bishop_isAbleToMove_enemyOnDestination() {
        Bishop bishop = new Bishop();
        chessBoard.setUnitFromCell(0, 0, bishop);
        Pawn pawn = new Pawn(ChessUnitColor.BLACK);
        chessBoard.setUnitFromCell(5, 5, pawn);

        Assertions.assertTrue(bishop.isAbleToMove(0, 0, 5, 5));
    }
}
