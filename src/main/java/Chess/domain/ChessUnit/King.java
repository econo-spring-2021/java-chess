package Chess.domain.ChessUnit;

import Chess.domain.Position;
import Chess.exception.InvalidUserInputException;

public class King extends Unit {
    public King() {
        super(UnitType.KING);
    }

    public King(UnitColor color) {
        super(UnitType.KING, color);
    }

    @Override
    protected void validateIsAbleToMove(Position source, Position destination) {
        if (isExistTeammateOnDestination(destination)) {
            throw new InvalidUserInputException("해당 위치에는 팀원이 있습니다.");
        }

        if (!isAbleMovement(source, destination)) {
            throw new InvalidUserInputException("해당 위치는 움직일 수 없는 경로입니다.");
        }
    }

    private boolean isAbleMovement(Position source, Position destination) {
        if (Math.abs(source.getRow()) - destination.getRow() != 1 || Math.abs(source.getCol() - destination.getCol()) != 1) {
            return false;
        }

        return true;
    }
}
