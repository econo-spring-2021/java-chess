package Chess.domain.ChessUnit;

import Chess.domain.Position;
import Chess.exception.InvalidPositionException;

public class Knight extends Unit {
    public static UnitType TYPE = UnitType.KNIGHT;
    public Knight() {
        super(TYPE);
    }

    public Knight(UnitColor color) {
        super(TYPE, color);
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
