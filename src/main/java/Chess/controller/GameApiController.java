package Chess.controller;

import Chess.domain.GameState;
import Chess.dto.MovementDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameApiController {

    public GameApiController(GameController gameController) {
        this.gameController = gameController;
    }

    private final GameController gameController;

    @PostMapping("/api/game/start")
    public void startGame() {
        gameController.executeStartCommand();
    }

    @GetMapping("/api/unit/movable")
    public boolean getIsMovableUnit(@RequestBody MovementDto movementDto) {
        return gameController.getIsMovableUnit(movementDto);
    }

    @PostMapping("/api/unit/move")
    public void moveUnit(@RequestBody MovementDto movementDto) {
        gameController.executeMoveCommand(movementDto);
    }

    @GetMapping("/api/game/score/black")
    public Float getBlackScore() {
        return gameController.getBlackScore();
    }

    @GetMapping("/api/game/score/white")
    public Float getWhiteScore() {
        return gameController.getWhiteScore();
    }

    @GetMapping("/api/game/state")
    public GameState getGameState() {
        return gameController.executeStatusCommand();
    }
}
