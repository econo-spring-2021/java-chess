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

class RookTest {

    ChessBoard chessBoard = ChessBoard.getInstance();

    @BeforeEach
    void initChessBoard() {
        chessBoard.resetChessUnitOnChessBoard();
    }

    @Test
    @DisplayName("룩이 움직일 수 있는 움직임에 대한 이동가능 여부를 올바르게 판단하는가")
    void test_rook_isAbleToMove_possibleMovement() {
        Rook rook = new Rook();
        chessBoard.setUnitFromCell(0, 0, rook);

        Assertions.assertDoesNotThrow(() -> rook.move(new Position(0, 0), new Position(0, 5)));
    }

    @Test
    @DisplayName("룩이 움직일 수 없는 움직임에 대한 이동가능 여부를 올바르게 판단하는가")
    void test_rook_isAbleToMove_impossibleMovement() {
        Rook rook = new Rook();
        chessBoard.setUnitFromCell(0, 0, rook);

        Assertions.assertThrows(InvalidPositionException.class, () -> rook.move(new Position(0, 0), new Position(2, 2)));
    }

    @Test
    @DisplayName("룩이 이동경로에 장애물이 있는 경우 이동가능 여부를 올바르게 판단하는가")
    void test_rook_isAbleToMove_obstacleMovement() {
        Rook rook = new Rook();
        chessBoard.setUnitFromCell(0, 0, rook);
        Pawn pawn = new Pawn();
        chessBoard.setUnitFromCell(1, 0, pawn);

        Assertions.assertThrows(InvalidPositionException.class, () -> rook.move(new Position(0, 0), new Position(5, 0)));
    }

    @Test
    @DisplayName("룩이 목적지에 아군이 있는 경우 이동가능 여부를 올바르게 판단하는가")
    void test_rook_isAbleToMove_teammateOnDestination() {
        Rook rook = new Rook();
        chessBoard.setUnitFromCell(0, 0, rook);
        Pawn pawn = new Pawn();
        chessBoard.setUnitFromCell(5, 0, pawn);

        Assertions.assertThrows(InvalidPositionException.class, () -> rook.move(new Position(0, 0), new Position(5, 0)));
    }

    @Test
    @DisplayName("룩이 목적지에 적군이 있는 경우 이동가능 여부를 올바르게 판단하는가")
    void test_rook_isAbleToMove_enemyOnDestination() {
        Rook rook = new Rook();
        chessBoard.setUnitFromCell(0, 0, rook);
        Pawn pawn = new Pawn(UnitColor.BLACK);
        chessBoard.setUnitFromCell(5, 0, pawn);

        Assertions.assertDoesNotThrow(() -> rook.move(new Position(0, 0), new Position(5, 0)));
    }
}
