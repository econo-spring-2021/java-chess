package Chess.domain.ChessUnit;

import Chess.domain.ChessBoard;
import Chess.domain.Position;
import Chess.exception.InvalidUserInputException;

public class Queen extends Unit {
    public Queen() {
        super(UnitType.QUEEN);
    }

    public Queen(UnitColor color) {
        super(UnitType.QUEEN, color);
    }

    @Override
    protected void validateIsAbleToMove(Position source, Position destination) throws InvalidUserInputException {
        if (isExistTeammateOnDestination(destination)) {
            throw new InvalidUserInputException("해당 위치에는 팀원이 있습니다.");
        }

        if (!isAbleMovement(source, destination)) {
            throw new InvalidUserInputException("해당 위치는 움직일 수 없는 경로입니다.");
        }

        if (isObstacleExistOnPath(source, destination)) {
            throw new InvalidUserInputException("경로에 장애물이 있습니다.");
        }
    }

    private boolean isAbleMovement(Position source, Position destination) {
        return isAbleRookMovement(source, destination) || isAbleBishopMovement(source, destination);
    }

    private boolean isAbleRookMovement(Position source, Position destination) {
        if (source.getRow() != destination.getRow() && source.getCol() != destination.getCol()) {
            return false;
        }

        return true;
    }

    private boolean isAbleBishopMovement(Position source, Position destination) {
        if (Math.abs(source.getRow() - destination.getRow()) != Math.abs(source.getCol() - destination.getCol())) {
            return false;
        }

        return true;
    }

    private boolean isObstacleExistOnPath(Position source, Position destination) {
        return isObstacleExistOnRookPath(source, destination) || isExistObstacleOnDiagonalPath(source, destination);
    }

    private boolean isObstacleExistOnRookPath(Position source, Position destination) {
        return isObstacleExistOnRowPath(source, destination) || isObstacleExistOnColumnPath(source, destination);
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

    private boolean isExistObstacleOnDiagonalPath(Position source, Position destination) {
        Position position = new Position(source);
        position.setNextRowToCheck(destination);
        position.setNextColToCheck(destination);

        for (; position.getRow() != destination.getRow(); position.setNextRowToCheck(destination), position.setNextColToCheck(destination)) {
            if (!(ChessBoard.getInstance().getUnitFromCell(position) instanceof EmptyCell)) {
                return true;
            }
        }

        return false;
    }
}
