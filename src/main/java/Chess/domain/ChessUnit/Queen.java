package Chess.domain.ChessUnit;

import Chess.domain.ChessBoard;

public class Queen extends Unit {
    public Queen() {
        super(UnitType.QUEEN);
    }

    public Queen(UnitColor color) {
        super(UnitType.QUEEN, color);
    }

    @Override
    public boolean isAbleToMove(int fromR, int fromC, int toR, int toC) {
        if (isExistTeammateOnDestination(toR, toC)) {
            return false;
        }

        if (!isAbleMovement(fromR, fromC, toR, toC)) {
            return false;
        }

        if (isObstacleExistOnPath(fromR, fromC, toR, toC)) {
            return false;
        }

        return true;
    }

    private boolean isAbleMovement(int fromR, int fromC, int toR, int toC) {
        return isAbleRookMovement(fromR, fromC, toR, toC) || isAbleBishopMovement(fromR, fromC, toR, toC);
    }

    private boolean isAbleRookMovement(int fromR, int fromC, int toR, int toC) {
        if (fromR != toR && fromC != toC) {
            return false;
        }

        return true;
    }

    private boolean isAbleBishopMovement(int fromR, int fromC, int toR, int toC) {
        if (Math.abs(fromR - toR) != Math.abs(fromC - toC)) {
            return false;
        }

        return true;
    }

    private boolean isObstacleExistOnPath(int fromR, int fromC, int toR, int toC) {
        return isObstacleExistOnRookPath(fromR, fromC, toR, toC) || isObstableExistOnBishopPath(fromR, fromC, toR, toC);
    }

    private boolean isObstacleExistOnRookPath(int fromR, int fromC, int toR, int toC) {
        return isObstacleExistOnRowPath(fromR, toR, toC) || isObstacleExistOnColumnPath(fromC, toC, toR);
    }

    private boolean isObstacleExistOnRowPath(int fromR, int toR, int column) {
        int row = getNextPositionToCheck(fromR, toR);
        while (row != toR) {
            if (!(ChessBoard.getInstance().getUnitFromCell(row, column) instanceof EmptyCell)) {
                return true;
            }

            row = getNextPositionToCheck(row, toR);
        }

        return false;
    }

    private boolean isObstacleExistOnColumnPath(int fromC, int toC, int row) {
        int column = getNextPositionToCheck(fromC, toC);
        while (column != toC) {
            if (!(ChessBoard.getInstance().getUnitFromCell(row, column) instanceof EmptyCell)) {
                return true;
            }

            column = getNextPositionToCheck(column, toC);
        }

        return false;
    }

    private boolean isObstableExistOnBishopPath(int fromR, int fromC, int toR, int toC) {
        int row = getNextPositionToCheck(fromR, toR);
        int column = getNextPositionToCheck(fromC, toC);
        while (row != toR && column != toC) {
            if (!(ChessBoard.getInstance().getUnitFromCell(row, column) instanceof EmptyCell)) {
                return true;
            }

            row = getNextPositionToCheck(row, toR);
            column = getNextPositionToCheck(column, toC);
        }

        return false;
    }
}
