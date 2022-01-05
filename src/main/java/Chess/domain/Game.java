package Chess.domain;

import Chess.domain.ChessUnit.Unit;
import Chess.domain.ChessUnit.UnitColor;
import Chess.domain.ChessUnit.UnitType;
import Chess.exception.InvalidPositionException;
import Chess.view.OutputView;

public class Game {
    ChessBoard chessBoard = ChessBoard.getInstance();
    boolean isPlaying = false;


    public boolean getIsPlaying() {
        return isPlaying;
    }

    public void initializeGame() {
        isPlaying = true;
        chessBoard.initializeChessGame();
    }

    public void endGame() {
        isPlaying = false;
    }

    public UnitColor getGameWinner() {
        return chessBoard.getWinner();
    }

    public boolean checkIsKingAlive() {
        if (chessBoard.isWhiteKingAlive() && chessBoard.isBlackKingAlive()) {
            return true;
        }

        return false;
    }

    public float getBlackScore() {
        return chessBoard.getScore(UnitColor.BLACK);
    }

    public float getWhiteScore() {
        return chessBoard.getScore(UnitColor.WHITE);
    }

    public boolean getIsMovableUnit(Position source, Position destination) {
        Unit unit = chessBoard.getUnitFromCell(source);
        try {
            unit.validateIsAbleToMove(source, destination);

            return true;
        } catch (InvalidPositionException e) {
            return false;
        }
    }

    public void moveChessUnit(Position source, Position destination) {
        try {
            Unit unit = chessBoard.getUnitFromCell(source);
            if (unit.getType().equals(UnitType.EMPTY)) {
                throw new IllegalArgumentException("그 곳에는 움직일 체스말이 없습니다.");
            }

            unit.move(source, destination);
        } catch (Exception e) {
            OutputView.printException(e);
        }
    }
}
