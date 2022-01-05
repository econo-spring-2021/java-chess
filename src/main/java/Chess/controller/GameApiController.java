package Chess.controller;

import Chess.domain.GameState;
import Chess.dto.MovementDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class GameApiController {

    @PostMapping("/api/game/start")
    public void startGame() {

    }

    @GetMapping("/api/unit/movable")
    public boolean getIsMovableUnit(@RequestBody MovementDto movementDto) {
        return false;
    }

    @PostMapping("/api/unit/move")
    public void moveUnit(@RequestBody MovementDto movementDto) {

    }

    @GetMapping("/api/game/score/black")
    public int getBlackScore() {
        return 0;
    }

    @GetMapping("/api/game/score/white")
    public int getWhiteScore() {
        return 0;
    }

    @GetMapping("/api/game/state")
    public GameState getGameState() {
        return GameState.ONGOING;
    }
}
