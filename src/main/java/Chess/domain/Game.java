package Chess.domain;

import Chess.view.OutputView;

public class Game {
    ChessBoard chessBoard = ChessBoard.getInstance();
    boolean isStarted = false;

    public boolean isGameStarted () {
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
}
