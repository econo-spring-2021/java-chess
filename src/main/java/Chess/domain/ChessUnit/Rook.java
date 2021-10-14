package Chess.domain.ChessUnit;

import Chess.domain.ChessBoard;
import Chess.domain.Position;
import Chess.exception.InvalidPositionException;

public class Rook extends Unit {
    public static UnitType TYPE = UnitType.ROOK;

    public Rook() {
        super(TYPE);
    }

    public Rook(UnitColor color) {
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

        if (isObstacleExistOnPath(source, destination)) {
            throw new InvalidPositionException(InvalidPositionException.OBSTACLE_IN_PATH);
        }
    }

    private boolean isAbleMovement(Position source, Position destination) {
        if (source.getRow() != destination.getRow() && source.getCol() != destination.getCol()) {
            return false;
        }

        return true;
    }

    /**
     * 룩의 상하좌우 이동 경로에 장애물이 있는지 검사한다.
     * @param source 말이 있던 위치
     * @param destination 말이 이동할 위치
     */
    private boolean isObstacleExistOnPath(Position source, Position destination) {
        return isObstacleExistOnRowPath(source, destination) || isObstacleExistOnColumnPath(source, destination);
    }

    /**
     * 상하 이동 경로의 장애물을 검사한다.
     * @param source 말이 있던 위치
     * @param destination 말이 이동할 위치
     */
    private boolean isObstacleExistOnRowPath(Position source, Position destination) {
        Position position = new Position(source);
        position.setNextRowToCheck(destination);

        for (;position.getRow() != destination.getRow(); position.setNextRowToCheck(destination)) {
            if (!(ChessBoard.getInstance().getUnitFromCell(position).getType().equals(UnitType.EMPTY))) {
                return true;
            }
        }

        return false;
    }

    /**
     * 좌우 이동 경로의 장애물을 검사한다.
     * @param source 말이 있던 위치
     * @param destination 말이 이동할 위치
     */
    private boolean isObstacleExistOnColumnPath(Position source, Position destination) {
        Position position = new Position(source);
        position.setNextColToCheck(destination);

        for (;position.getCol() != destination.getCol(); position.setNextColToCheck(destination)) {
            if (!(ChessBoard.getInstance().getUnitFromCell(position).getType().equals(UnitType.EMPTY))) {
                return true;
            }
        }

        return false;
    }
}
