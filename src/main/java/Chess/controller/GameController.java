package Chess.controller;

import Chess.domain.ChessBoard;
import Chess.domain.Game;
import Chess.domain.Position;
import Chess.view.InputView;
import Chess.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameController {
    Game game = new Game();

    public void start() {
        OutputView.announceGameStart();
        OutputView.askGameOperationCommand();

        loopForCommand();
    }

    private void loopForCommand() {
        while (true) {
            List<String> commands = InputView.getGameOperationCommands();
            String command = commands.get(0);
            if (command.equals(InputView.GAME_END_COMMAND)) {
                return;
            }

            List<String> args = new ArrayList<>();
            if (commands.size() > 1) {
                args = commands.subList(1, commands.size());
            }
            executeCommand(command, args);
        }
    }

    private void executeCommand(String command, List<String> args) {
        switch (command) {
            case InputView.GAME_START_COMMAND:
                executeStartCommand();
                break;
            case InputView.GAME_MOVE_COMMAND:
                executeMoveCommand(args);
                break;
        }
    }

    private void executeStartCommand() {
        game.initializeGame();
        game.showChessBoard();
    }

    private void executeMoveCommand(List<String> args) {
        Position source = new Position(args.get(0));
        Position destination = new Position(args.get(0));

        game.moveChessUnit(source, destination);
        game.showChessBoard();
    }
}
