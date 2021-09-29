package Chess.domain.ChessUnit;

import Chess.domain.Position;
import Chess.exception.InvalidPositionException;

public class Knight extends Unit {
    public Knight() {
        super(UnitType.KNIGHT);
    }

    public Knight(UnitColor color) {
        super(UnitType.KNIGHT, color);
    }

    @Override
    protected void validateIsAbleToMove(Position source, Position destination) throws InvalidPositionException {
        if (isExistTeammateOnDestination(destination)) {
            throw new InvalidPositionException(InvalidPositionException.TEAMMATE_ON_DESTINATION);
        }

        if (!isAbleMovement(source, destination)) {
            throw new InvalidPositionException(InvalidPositionException.UNABLE_PATH);
        }
    }

    private boolean isAbleMovement(Position source, Position destination) {
        if ((Math.abs(source.getRow() - destination.getRow()) == 2 && Math.abs(source.getCol() - destination.getCol()) == 1) ||
                (Math.abs(source.getRow() - destination.getRow()) == 1 && Math.abs(source.getCol() - destination.getCol()) == 2)) {
            return true;
        }

        return false;
    }
}
