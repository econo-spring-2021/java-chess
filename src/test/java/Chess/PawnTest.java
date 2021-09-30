package Chess;

import Chess.domain.ChessBoard;
import Chess.domain.ChessUnit.UnitColor;
import Chess.domain.ChessUnit.Pawn;
import Chess.domain.ChessUnit.Rook;
import Chess.domain.Position;
import Chess.exception.InvalidPositionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {

    ChessBoard chessBoard = ChessBoard.getInstance();

    @BeforeEach
    void initChessBoard() {
        chessBoard.resetChessUnitOnChessBoard();
    }

    @Test
    @DisplayName("폰이 반대 방향 움직임에 대해 올바르게 판단하는개")
    void test_pawn_isAbleToMove_impossibleOppositeMovement() {
        Pawn pawn = new Pawn();

        Assertions.assertThrows(InvalidPositionException.class, () -> pawn.move(new Position(5, 5), new Position(6, 5)));
    }

    @Test
    @DisplayName("폰이 첫 이동에서 움직일 수 있는 움직임에 대해 올바르게 판단하는개")
    void test_pawn_isAbleToMove_possibleFirstMovement() {
        Pawn pawn = new Pawn();

        Assertions.assertDoesNotThrow(() -> pawn.move(new Position(4, 4), new Position(2, 4)));
    }

    @Test
    @DisplayName("폰이 첫 이동에서 움직일 수 없는 움직임에 대해 올바르게 판단하는개")
    void test_pawn_isAbleToMove_impossibleFirstMovement() {
        Pawn pawn = new Pawn();

        Assertions.assertThrows(InvalidPositionException.class, () -> pawn.move(new Position(4, 4), new Position(1, 4)));
    }

    @Test
    @DisplayName("폰이 첫 이동 이후에서 움직일 수 있는 움직임에 대해 올바르게 판단하는개")
    void test_pawn_isAbleToMove_possibleMovement() {
        Pawn pawn = new Pawn();

        pawn.move(new Position(6, 6), new Position(4, 6));
        Assertions.assertDoesNotThrow(() -> pawn.move(new Position(4, 6), new Position(3, 6)));
    }

    @Test
    @DisplayName("폰이 첫 이동 이후에서 움직일 수 없는 움직임에 대해 올바르게 판단하는개")
    void test_pawn_isAbleToMove_impossibleMovement() {
        Pawn pawn = new Pawn();

        pawn.move(new Position(6, 6), new Position(4, 6));
        Assertions.assertThrows(InvalidPositionException.class, () -> pawn.move(new Position(4, 6), new Position(2, 6)));
    }

    @Test
    @DisplayName("룩이 첫 이동 목적지에 아군이 있는 경우 이동가능 여부를 올바르게 판단하는가")
    void test_pawn_isAbleToMove_teammateOnFirstDestination() {
        Pawn pawn = new Pawn();
        chessBoard.setUnitFromCell(2, 0, pawn);
        Rook rook = new Rook();
        chessBoard.setUnitFromCell(0, 0, rook);

        Assertions.assertThrows(InvalidPositionException.class, () -> pawn.move(new Position(2, 0), new Position(0, 0)));
    }

    @Test
    @DisplayName("룩이 첫 이동이후 목적지에 아군이 있는 경우 이동가능 여부를 올바르게 판단하는가")
    void test_pawn_isAbleToMove_teammateOnDestination() {
        Pawn pawn = new Pawn();
        chessBoard.setUnitFromCell(4, 0, pawn);
        Rook rook = new Rook();
        chessBoard.setUnitFromCell(1, 0, rook);

        pawn.move(new Position(4, 0), new Position(2, 0));
        Assertions.assertThrows(InvalidPositionException.class, () -> pawn.move(new Position(2, 0), new Position(1, 0)));
    }

    @Test
    @DisplayName("폰이 적을 잡을 때 움직일 수 있는 움직임에 대해 올바르게 판단하는개")
    void test_pawn_isAbleToMove_possibleAttackMovement() {
        Pawn pawn = new Pawn();
        ChessBoard.getInstance().setUnitFromCell(4, 4, new Pawn(UnitColor.BLACK));

        Assertions.assertDoesNotThrow(() -> pawn.move(new Position(5, 5), new Position(4, 4)));
    }

    @Test
    @DisplayName("폰이 적을 잡을 때 움직일 수 없는 움직임에 대해 올바르게 판단하는개")
    void test_pawn_isAbleToMove_impossibleAttackMovement() {
        Pawn pawn = new Pawn();
        ChessBoard.getInstance().setUnitFromCell(5, 5, new Pawn(UnitColor.BLACK));

        Assertions.assertThrows(InvalidPositionException.class, () -> pawn.move(new Position(4, 5), new Position(5, 5)));
    }
}
