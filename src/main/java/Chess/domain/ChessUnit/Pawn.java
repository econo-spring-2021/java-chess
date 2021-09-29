package Chess.domain.ChessUnit;

import Chess.domain.ChessBoard;

public class Pawn extends Unit {
    private boolean isFirstMovement = true;

    public Pawn() {
        super(UnitType.PAWN);
    }

    public Pawn(UnitColor color) {
        super(UnitType.PAWN, color);
    }

    @Override
    public void move(int fromR, int fromC, int toR, int toC) {
        if (isFirstMovement) {
            isFirstMovement = false;
        }

        super.move(fromR, fromC, toR, toC);
    }

    @Override
    public boolean isAbleToMove(int fromR, int fromC, int toR, int toC) {
        if (isExistTeammateOnDestination(toR, toC)) {
            return false;
        }

        if (!isRightDirectionMove(fromR, toR)) {
            return false;
        }

        Unit targetUnit = ChessBoard.getInstance().getUnitFromCell(toR, toC);
        if (targetUnit.getType() != UnitType.EMPTY && isAbleAttackMove(fromR, fromC, toR, toC)) {
            return true;
        }

        if (isFirstMovement && isAbleFirstMove(fromR, toR)) {
            return true;
        }

        return isAbleMovement(fromR, toR);
    }

    private boolean isAbleMovement(int fromR, int toR) {
        if (Math.abs(fromR - toR) != 1) {
            return false;
        }

        return true;
    }

    private boolean isRightDirectionMove(int fromR, int toR) {
        if (color == UnitColor.WHITE && fromR - toR < 0) {
            return false;
        }

        if (color == UnitColor.BLACK && fromR - toR > 0) {
            return false;
        }

        return true;
    }

    private boolean isAbleAttackMove(int fromR, int fromC, int toR, int toC) {
        if (Math.abs(fromR - toR) == 1 && Math.abs(fromC - toC) == 1) {
            return true;
        }

        return false;
    }

    private boolean isAbleFirstMove(int fromR, int toR) {
        if (Math.abs(fromR - toR) > 2) {
            return false;
        }

        return true;
    }
}
