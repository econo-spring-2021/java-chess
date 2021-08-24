package Chess;

import Chess.domain.ChessUnit.Knight;
import Chess.domain.ChessUnit.Rook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChessUnitTest {

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
        Assertions.assertFalse(knight.isAbleToMove(4, 4, 4, 10));
    }

    @Test
    @DisplayName("나이트가 움직일 수 있는 움직임에 대해 올바르게 판단하는개")
    void test_knight_isAbleToMove_possibleMovement() {
        Knight knight = new Knight();
        Assertions.assertTrue(knight.isAbleToMove(4, 4, 6, 5));
    }
}
