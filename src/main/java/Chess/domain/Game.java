package Chess.domain;

import Chess.view.OutputView;

public class Game {
    ChessBoard chessBoard = new ChessBoard();

    public void initializeGame() {
        chessBoard.initializeChessUnit();
    }

    public void showChessBoard() {
        String chessBoardStr = chessBoard.convertChessBoardToString();
        OutputView.printString(chessBoardStr);
    }
}
