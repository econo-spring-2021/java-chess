package Chess.domain;

import Chess.view.OutputView;

public class Game {
    ChessBoard chessBoard = ChessBoard.getInstance();

    public void initializeGame() {
        chessBoard.initializeChessGame();
    }

    public void showChessBoard() {
        String chessBoardStr = chessBoard.convertChessBoardToString();
        OutputView.printString(chessBoardStr);
    }
}
