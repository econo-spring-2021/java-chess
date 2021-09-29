package Chess;

import Chess.domain.ChessBoard;
import Chess.domain.ChessUnit.ChessUnitColor;
import Chess.domain.ChessUnit.King;
import Chess.domain.ChessUnit.Knight;
import Chess.domain.ChessUnit.Pawn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KingTest {

    ChessBoard chessBoard = ChessBoard.getInstance();
    @BeforeEach
    void initChessBoard() {
        chessBoard.resetChessUnitOnChessBoard();
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
    @DisplayName("킹이 목적지에 아군이 있는 경우 이동가능 여부를 올바르게 판단하는가")
    void test_king_isAbleToMove_teammateOnDestination() {
        King king = new King();
        chessBoard.setUnitFromCell(0, 0, king);
        Pawn pawn = new Pawn();
        chessBoard.setUnitFromCell(1, 1, pawn);

        Assertions.assertFalse(king.isAbleToMove(0, 0, 1, 1));
    }

    @Test
    @DisplayName("킹이 목적지에 적군이 있는 경우 이동가능 여부를 올바르게 판단하는가")
    void test_king_isAbleToMove_enemyOnDestination() {
        King king = new King();
        chessBoard.setUnitFromCell(0, 0, king);
        Pawn pawn = new Pawn(ChessUnitColor.BLACK);
        chessBoard.setUnitFromCell(1, 1, pawn);

        Assertions.assertTrue(king.isAbleToMove(0, 0, 1, 1));
    }
}
