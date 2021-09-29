package Chess;

import Chess.domain.ChessBoard;
import Chess.domain.ChessUnit.*;
import Chess.domain.Position;
import Chess.exception.InvalidUserInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KnightTest {

    ChessBoard chessBoard = ChessBoard.getInstance();
    @BeforeEach
    void initChessBoard() {
        chessBoard.resetChessUnitOnChessBoard();
    }

    @Test
    @DisplayName("나이트가 움직일 수 있는 움직임에 대해 올바르게 판단하는개")
    void test_knight_isAbleToMove_possibleMovement() {
        Knight knight = new Knight();
        //        Assertions.assertDoesNotThrow(() -> bishop.move(new Position(4, 4), new Position(6, 5)));
    }

    @Test
    @DisplayName("나이트가 움직일 수 없는 움직임에 대해 올바르게 판단하는개")
    void test_knight_isAbleToMove_impossibleMovement() {
        Knight knight = new Knight();
        Assertions.assertThrows(InvalidUserInputException.class, () -> knight.move(new Position(4, 4), new Position(5, 5)));
    }


    @Test
    @DisplayName("나이트가 목적지에 아군이 있는 경우 이동가능 여부를 올바르게 판단하는가")
    void test_knight_isAbleToMove_teammateOnDestination() {
        Knight knight = new Knight();
        chessBoard.setUnitFromCell(4, 4, knight);
        Pawn pawn = new Pawn();
        chessBoard.setUnitFromCell(6, 5, pawn);

        Assertions.assertThrows(InvalidUserInputException.class, () -> knight.move(new Position(4, 4), new Position(6, 5)));
    }

    @Test
    @DisplayName("나이트가 목적지에 적군이 있는 경우 이동가능 여부를 올바르게 판단하는가")
    void test_knight_isAbleToMove_enemyOnDestination() {
        Knight knight = new Knight();
        chessBoard.setUnitFromCell(4, 4, knight);
        Pawn pawn = new Pawn(UnitColor.BLACK);
        chessBoard.setUnitFromCell(6, 5, pawn);

//        Assertions.assertDoesNotThrow(() -> knight.move(new Position(4, 4), new Position(6, 5)));
    }
}
