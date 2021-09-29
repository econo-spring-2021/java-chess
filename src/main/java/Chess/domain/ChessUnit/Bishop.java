package Chess.domain.ChessUnit;

import Chess.domain.ChessBoard;
import Chess.domain.Position;
import Chess.exception.InvalidUserInputException;

public class Bishop extends Unit {
    public Bishop() {
        super(UnitType.BISHOP);
    }

    public Bishop(UnitColor color) {
        super(UnitType.BISHOP, color);
    }

    @Override
    protected void validateIsAbleToMove(Position source, Position destination) throws InvalidUserInputException{
        if (isExistTeammateOnDestination(destination)) {
            throw new InvalidUserInputException("해당 위치에는 팀원이 있습니다.");
        }

        if (!isAbleMovement(source, destination)) {
            throw new InvalidUserInputException("해당 위치는 움직일 수 없는 경로입니다.");
        }

        if (isExistObstacleOnDiagonalPath(source, destination)) {
            throw new InvalidUserInputException("경로에 장애물이 있습니다.");
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
            if (!(ChessBoard.getInstance().getUnitFromCell(position) instanceof EmptyCell)) {
                return true;
            }
        }

        return false;
    }
}
