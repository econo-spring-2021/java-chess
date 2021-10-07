package Chess.domain.ChessUnit;

import Chess.domain.ChessBoard;
import Chess.domain.Position;
import Chess.exception.InvalidPositionException;

public class Bishop extends Unit {
    public static UnitType TYPE = UnitType.BISHOP;
    public Bishop() {
        super(TYPE);
    }

    public Bishop(UnitColor color) {
        super(TYPE, color);
    }

    @Override
    protected void validateIsAbleToMove(Position source, Position destination) throws InvalidPositionException{
        if (isExistTeammateOnDestination(destination)) {
            throw new InvalidPositionException(InvalidPositionException.TEAMMATE_ON_DESTINATION);
        }

        if (!isAbleMovement(source, destination)) {
            throw new InvalidPositionException(InvalidPositionException.UNABLE_PATH);
        }

        if (isExistObstacleOnDiagonalPath(source, destination)) {
            throw new InvalidPositionException(InvalidPositionException.OBSTACLE_IN_PATH);
        }
    }

    private boolean isAbleMovement(Position source, Position destination) {
        if (Math.abs(source.getRow() - destination.getRow()) != Math.abs(source.getCol() - destination.getCol())) {
            return false;
        }

        return true;
    }

    private boolean isExistObstacleOnDiagonalPath(Position source, Position destination) {
        Position position = new Position(source);
        position.setNextRowToCheck(destination);
        position.setNextColToCheck(destination);

        for (; position.getRow() != destination.getRow(); position.setNextRowToCheck(destination), position.setNextColToCheck(destination)) {
            int r = position.getRow();
            int r2 = destination.getRow();
            if (!(ChessBoard.getInstance().getUnitFromCell(position) instanceof EmptyCell)) {
                return true;
            }
        }

        return false;
    }
}
