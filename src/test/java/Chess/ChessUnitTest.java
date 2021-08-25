package Chess;

import Chess.domain.ChessBoard;
import Chess.domain.ChessUnit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChessUnitTest {

    @BeforeEach
    void initializeChessBoard() {
        ChessBoard.getInstance().initializeChessGame();
    }

    @Test
    @DisplayName("룩이 움직일 수 없는 움직임에 대해 올바르게 판단하는개")
    void test_rook_isAbleToMove_impossibleMovement() {
        Rook rook = new Rook();
        Assertions.assertFalse(rook.isAbleToMove(1, 1, 2, 2));
    }

    @Test
    @DisplayName("룩이 움직일 수 있는 움직임에 대해 올바르게 판단하는개")
    void test_rook_isAbleToMove_possibleMovement() {
        Rook rook = new Rook();
        Assertions.assertTrue(rook.isAbleToMove(1, 1, 1, 5));
    }

    @Test
    @DisplayName("나이트가 움직일 수 없는 움직임에 대해 올바르게 판단하는개")
    void test_knight_isAbleToMove_impossibleMovement() {
        Knight knight = new Knight();
        Assertions.assertFalse(knight.isAbleToMove(4, 4, 5, 5));
    }

    @Test
    @DisplayName("나이트가 움직일 수 있는 움직임에 대해 올바르게 판단하는개")
    void test_knight_isAbleToMove_possibleMovement() {
        Knight knight = new Knight();
        Assertions.assertTrue(knight.isAbleToMove(4, 4, 6, 5));
    }

    @Test
    @DisplayName("킹이 움직일 수 없는 움직임에 대해 올바르게 판단하는개")
    void test_king_isAbleToMove_impossibleMovement() {
        Knight king = new Knight();
        Assertions.assertFalse(king.isAbleToMove(5, 5, 3, 3));
    }

    @Test
    @DisplayName("킹이 움직일 수 있는 움직임에 대해 올바르게 판단하는개")
    void test_king_isAbleToMove_possibleMovement() {
        King king = new King();
        Assertions.assertTrue(king.isAbleToMove(5, 5, 6, 6));
    }

    @Test
    @DisplayName("비숍이 움직일 수 없는 움직임에 대해 올바르게 판단하는개")
    void test_bishop_isAbleToMove_impossibleMovement() {
        Bishop bishop = new Bishop();
        Assertions.assertFalse(bishop.isAbleToMove(2, 2, 2, 7));
    }

    @Test
    @DisplayName("비숍이 움직일 수 있는 움직임에 대해 올바르게 판단하는개")
    void test_bishop_isAbleToMove_possibleMovement() {
        Bishop bishop = new Bishop();
        Assertions.assertTrue(bishop.isAbleToMove(2, 2, 7, 7));
    }

    @Test
    @DisplayName("퀸이 움직일 수 없는 움직임에 대해 올바르게 판단하는개")
    void test_queen_isAbleToMove_impossibleMovement() {
        Queen queen = new Queen();
        Assertions.assertFalse(queen.isAbleToMove(4, 4, 5, 6));
    }

    @Test
    @DisplayName("퀸이 움직일 수 있는 움직임(킹)에 대해 올바르게 판단하는개")
     void test_queen_isAbleToMove_kingMovement() {
        Queen queen = new Queen();
        Assertions.assertTrue(queen.isAbleToMove(4, 4, 5, 5));
    }

    @Test
    @DisplayName("퀸이 움직일 수 있는 움직임(비숍)에 대해 올바르게 판단하는개")
    void test_queen_isAbleToMove_bishopMovement() {
        Queen queen = new Queen();
        Assertions.assertTrue(queen.isAbleToMove(4, 4, 7, 7));
    }

    @Test
    @DisplayName("폰이 반대 방향 움직임에 대해 올바르게 판단하는개")
    void test_pawn_isAbleToMove_impossibleOppositeMovement() {
        Pawn pawn = new Pawn();
        Assertions.assertFalse(pawn.isAbleToMove(5, 5, 4, 5));
    }

    @Test
    @DisplayName("폰이 첫 이동에서 움직일 수 없는 움직임에 대해 올바르게 판단하는개")
    void test_pawn_isAbleToMove_impossibleFirstMovement() {
        Pawn pawn = new Pawn();
        Assertions.assertFalse(pawn.isAbleToMove(4, 4, 7, 4));
    }

    @Test
    @DisplayName("폰이 첫 이동에서 움직일 수 있는 움직임에 대해 올바르게 판단하는개")
    void test_pawn_isAbleToMove_possibleFirstMovement() {
        Pawn pawn = new Pawn();
        Assertions.assertTrue(pawn.isAbleToMove(4, 4, 6, 4));
    }

//    @Test
//    @DisplayName("폰이 첫 이동 이후에서 움직일 수 없는 움직임에 대해 올바르게 판단하는개")
//    void test_pawn_isAbleToMove_impossibleMovement() {
//        Pawn pawn = new Pawn();
//        Assertions.assertTrue(pawn.isAbleToMove(5, 5, 7, 5));
//        Assertions.assertTrue(pawn.isAbleToMove(7, 5, 9, 5));
//    }
//
//    @Test
//    @DisplayName("폰이 첫 이동 이후에서 움직일 수 있는 움직임에 대해 올바르게 판단하는개")
//    void test_pawn_isAbleToMove_possibleMovemet() {
//        Pawn pawn = new Pawn();
//        Assertions.assertTrue(pawn.isAbleToMove(5, 5, 7, 5));
//        Assertions.assertTrue(pawn.isAbleToMove(7, 5, 8, 5));
//    }
//
//    @Test
//    @DisplayName("폰이 적을 잡을 때 움직일 수 없는 움직임에 대해 올바르게 판단하는개")
//    void test_pawn_isAbleToMove_impossibleAttackMovement() {
//        Pawn pawn = new Pawn(ChessUnitColor.BLACK);
//        Assertions.assertTrue(pawn.isAbleToMove(5, 5, 7, 6));
//    }
//
//    @Test
//    @DisplayName("폰이 적을 잡을 때 움직일 수 있는 움직임에 대해 올바르게 판단하는개")
//    void test_pawn_isAbleToMove_possibleAttackMovement() {
//        Pawn pawn = new Pawn(ChessUnitColor.BLACK);
//        Assertions.assertTrue(pawn.isAbleToMove(5, 5, 6, 6));
//    }
}
