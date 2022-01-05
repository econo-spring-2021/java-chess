package Chess.controller;

import Chess.domain.ChessUnit.UnitColor;
import Chess.domain.Game;
import Chess.domain.GameState;
import Chess.domain.Position;
import Chess.dto.MovementDto;
import Chess.exception.InvalidUserInputException;
import Chess.view.OutputView;
import org.springframework.stereotype.Service;

@Service
public class GameController {
    Game game = new Game();


    public void executeStartCommand() {
        game.initializeGame();
    }

    public boolean getIsMovableUnit(MovementDto movementDto) {
        Position source = movementDto.getSourcePosition();
        Position destination = movementDto.getDestinationPosition();

        return game.getIsMovableUnit(source, destination);
    }

    public void executeMoveCommand(MovementDto movementDto) {
        if (!game.getIsPlaying()) {
            throw new InvalidUserInputException("게임 시작 전에 체스말을 움직일 수 없습니다");
        }

        try {
            Position source = movementDto.getSourcePosition();
            Position destination = movementDto.getDestinationPosition();

            game.moveChessUnit(source, destination);
            if (!game.getGameWinner().equals(null)) {
                game.endGame();
            }
        } catch (Exception e) {
            OutputView.printException(e);
        }
    }

    public float getBlackScore() {
        return game.getBlackScore();
    }

    public float getWhiteScore() {
        return game.getWhiteScore();
    }

    public GameState executeStatusCommand() {
        if (game.getIsPlaying()) {
            return GameState.ONGOING;
        }

        UnitColor winner = game.getGameWinner();
        if (winner.equals(UnitColor.BLACK)) {
            return GameState.BLACKWIN;
        }

        return GameState.WHITEWIN;
    }
}
