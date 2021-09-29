package Chess.domain.ChessUnit;

import Chess.domain.ChessBoard;

public class Bishop extends ChessUnit {
    public Bishop() {
        super(ChessUnitType.BISHOP);
    }

    public Bishop(ChessUnitColor color) {
        super(ChessUnitType.BISHOP, color);
    }

    @Override
    public boolean isAbleToMove(int fromR, int fromC, int toR, int toC) {
        if (isExistTeammateOnDestination(toR, toC)) {
            return false;
        }

        if (!isAbleMovement(fromR, fromC, toR, toC)) {
            return false;
        }

        if (isExistObstacleOnMovement(fromR, fromC, toR, toC)) {
            return false;
        }

        return true;
    }

    private boolean isAbleMovement(int fromR, int fromC, int toR, int toC) {
        if (Math.abs(fromR - toR) != Math.abs(fromC - toC)) {
            return false;
        }

        return true;
    }

    private boolean isExistObstacleOnMovement(int fromR, int fromC, int toR, int toC) {
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
