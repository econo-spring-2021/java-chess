package Chess.domain;

import Chess.domain.ChessUnit.Unit;
import Chess.domain.ChessUnit.EmptyCell;
import Chess.domain.ChessUnit.UnitColor;
import Chess.view.OutputView;

public class Game {
    ChessBoard chessBoard = ChessBoard.getInstance();
    boolean isStarted = false;
    boolean isPlaying = false;

    public boolean getIsStarted() {
        return isStarted;
    }

    public boolean getIsPlaying() {
        return isPlaying;
    }

    public void initializeGame() {
        isStarted = true;
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

    public void showChessBoard() {
        String chessBoardStr = chessBoard.convertChessBoardToString();
        OutputView.printString(chessBoardStr);
    }

    public void moveChessUnit(Position source, Position destination) {
        try {
            Unit unit = chessBoard.getUnitFromCell(source);
            if (unit instanceof EmptyCell) {
                throw new IllegalArgumentException("그 곳에는 움직일 체스말이 없습니다.");
            }

            unit.move(source, destination);
        } catch (Exception e) {
            OutputView.printException(e);
        }
    }
}
