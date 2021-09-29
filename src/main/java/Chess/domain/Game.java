package Chess.domain;

import Chess.domain.ChessUnit.Unit;
import Chess.domain.ChessUnit.EmptyCell;
import Chess.view.OutputView;

public class Game {
    ChessBoard chessBoard = ChessBoard.getInstance();
    boolean isStarted = false;

    public boolean isGameStarted() {
        return isStarted;
    }

    public void initializeGame() {
        isStarted = true;
        chessBoard.initializeChessGame();
    }

    public void showChessBoard() {
        String chessBoardStr = chessBoard.convertChessBoardToString();
        OutputView.printString(chessBoardStr);
    }

    public void moveChessUnit(Position source, Position destination) {
        try {
            if (!isGameStarted()) {
                throw new IllegalArgumentException("게임 시작 전에 체스말을 움직일 수 없습니다");
            }

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
