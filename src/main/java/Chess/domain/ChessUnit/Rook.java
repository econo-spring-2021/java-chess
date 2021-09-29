package Chess.domain.ChessUnit;

import Chess.domain.ChessBoard;

public class Rook extends Unit {
    public Rook() {
        super(UnitType.ROOK);
    }

    public Rook(UnitColor color) {
        super(UnitType.ROOK, color);
    }

    @Override
    public boolean isAbleToMove(int fromR, int fromC, int toR, int toC) {
        if (isExistTeammateOnDestination(toR, toC)) {
            return false;
        }

        if (!isAbleMovement(fromR, fromC, toR, toC)) {
            return false;
        }

        if (fromR == toR && isObstacleExistOnColumnPath(fromC, toC, fromR)) {
            return false;
        }

        if (fromC == toC && isObstacleExistOnRowPath(fromR, toR, fromC)) {
            return false;
        }

        return true;
    }

    private boolean isAbleMovement(int fromR, int fromC, int toR, int toC) {
        if (fromR != toR && fromC != toC) {
            return false;
        }

        return true;
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
}
