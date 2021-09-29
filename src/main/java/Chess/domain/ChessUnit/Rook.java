package Chess.domain.ChessUnit;

import Chess.domain.ChessBoard;
import Chess.domain.Position;
import Chess.exception.InvalidPositionException;

public class Rook extends Unit {
    public Rook() {
        super(UnitType.ROOK);
    }

    public Rook(UnitColor color) {
        super(UnitType.ROOK, color);
    }

    @Override
    protected void validateIsAbleToMove(Position source, Position destination) throws InvalidPositionException {
        if (isExistTeammateOnDestination(destination)) {
            throw new InvalidPositionException(InvalidPositionException.TEAMMATE_ON_DESTINATION);
        }

        if (!isAbleMovement(source, destination)) {
            throw new InvalidPositionException(InvalidPositionException.UNABLE_PATH);
        }

        if (source.getRow() == destination.getRow() && isObstacleExistOnColumnPath(source, destination)) {
            throw new InvalidPositionException(InvalidPositionException.OBSTACLE_IN_PATH);
        }

        if (source.getCol() == destination.getCol() && isObstacleExistOnRowPath(source, destination)) {
            throw new InvalidPositionException(InvalidPositionException.OBSTACLE_IN_PATH);
        }
    }

    private boolean isAbleMovement(Position source, Position destination) {
        if (source.getRow() != destination.getRow() && source.getCol() != destination.getCol()) {
            return false;
        }

        return true;
    }

    private boolean isObstacleExistOnRowPath(Position source, Position destination) {
        Position position = new Position(source);
        position.setNextRowToCheck(destination);

        for (;position.getRow() != destination.getRow(); position.setNextRowToCheck(destination)) {
            if (!(ChessBoard.getInstance().getUnitFromCell(position) instanceof EmptyCell)) {
                return true;
            }
        }

        return false;
    }

    private boolean isObstacleExistOnColumnPath(Position source, Position destination) {
        Position position = new Position(source);
        position.setNextColToCheck(destination);

        for (;position.getCol() != destination.getCol(); position.setNextColToCheck(destination)) {
            if (!(ChessBoard.getInstance().getUnitFromCell(position) instanceof EmptyCell)) {
                return true;
            }
        }

        return false;
    }
}
