package Chess.controller;

import Chess.domain.Game;
import Chess.view.InputView;
import Chess.view.OutputView;

public class GameController {
    Game game = new Game();

    public void start() {
        OutputView.announceGameStart();
        OutputView.askGameOperationCommand();

        while (!InputView.getGameOperationCommand().equals(InputView.GAME_END_COMMAND)) {
            game.initializeGame();
            game.showChessBoard();
        }
    }
}
