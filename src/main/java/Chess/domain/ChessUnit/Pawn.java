package Chess.domain.ChessUnit;

import Chess.domain.ChessBoard;

public class Pawn extends ChessUnit {
    private boolean isFirstMovement = true;

    public Pawn() {
        super(ChessUnitType.PAWN);
    }

    public Pawn(ChessUnitColor color) {
        super(ChessUnitType.PAWN, color);
    }

    @Override
    public boolean isAbleToMove(int fromR, int fromC, int toR, int toC) {
        if (!isRightDirectionMove(fromR, fromC, toR, toC)) {
            return false;
        }

        ChessUnit targetUnit = ChessBoard.getInstance().getUnitFromCell(toR, toC);
        if (targetUnit.getType() != ChessUnitType.EMPTY && isAbleAttackMove(fromR, fromC, toR, toC)) {
            return true;
        }

        if (isFirstMovement && isAbleFirstMove(fromR, fromC, toR, toC)) {
            return true;
        }

        return isAbleMove(fromR, fromC, toR, toC);
    }

    private boolean isRightDirectionMove(int fromR, int fromC, int toR, int toC) {
        if (color == ChessUnitColor.WHITE && fromR - toR > 0) {
            return false;
        }

        if (color == ChessUnitColor.BLACK && fromR - toR < 0) {
            return false;
        }

        return true;
    }

    private boolean isAbleAttackMove(int fromR, int fromC, int toR, int toC) {
        if (Math.abs(fromR - toR) != 1 || Math.abs(fromC - toC) != 1) {
            return false;
        }

        return true;
    }

    private boolean isAbleFirstMove(int fromR, int fromC, int toR, int toC) {
        if (Math.abs(fromR - toR) > 2) {
            return false;
        }

        return true;
    }

    private boolean isAbleMove(int fromR, int fromC, int toR, int toC) {
        if (Math.abs(fromR - fromC) != 1) {
            return false;
        }

        return true;
    }
}
