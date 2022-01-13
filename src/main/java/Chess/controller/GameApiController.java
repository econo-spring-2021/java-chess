package Chess.controller;

import Chess.domain.GameState;
import Chess.dto.MovementDto;
import org.springframework.web.bind.annotation.*;

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
    public boolean getIsMovableUnit(@RequestParam(value = "source") int sourceCellIndex, @RequestParam(value = "destination") int destinationCellIndex) {
        return gameController.getIsMovableUnit(new MovementDto(sourceCellIndex, destinationCellIndex));
    }

    @PostMapping("/api/unit/move")
    public void moveUnit(@RequestParam(value = "source") int sourceCellIndex, @RequestParam(value = "destination") int destinationCellIndex) {
        gameController.executeMoveCommand(new MovementDto(sourceCellIndex, destinationCellIndex));
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

    @GetMapping("/api/game/data")
    public String loadGameData() {
        return gameController.getChessboardData();
    }
}
