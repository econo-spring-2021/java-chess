package Chess;

import Chess.domain.ChessUnit.Rook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChessUnitTest {


    @Test
    @DisplayName("룩이 움직일 수 없는 움직임에 대해 올바르게 판단하는개")
    void test_rook_isAbleToMove_impossibleMovement() {
        Rook rook = new Rook();
        Assertions.assertFalse(rook.isAbleToMove(0, 0, 1, 1));
    }

    @Test
    @DisplayName("룩이 움직일 수 있는 움직임에 대해 올바르게 판단하는개")
    void test_rook_isAbleToMove_possibleMovement() {
        Rook rook = new Rook();
        Assertions.assertTrue(rook.isAbleToMove(0, 0, 0, 5));
    }
}
