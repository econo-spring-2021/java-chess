package Chess.domain.ChessUnit;

public class King extends ChessUnit {
    public King() {
        super(ChessUnitType.KING);
    }

    public King(ChessUnitColor color) {
        super(ChessUnitType.KING, color);
    }

    @Override
    public boolean isAbleToMove(int fromR, int fromC, int toR, int toC) {
        if (isExistTeammateOnDestination(toR, toC)) {
            return false;
        }

        if (!isAbleMovement(fromR, fromC, toR, toC)) {
            return false;
        }

        return true;
    }

    private boolean isAbleMovement(int fromR, int fromC, int toR, int toC) {
        if (Math.abs(fromR - toR) != 1 || Math.abs(fromC - toC) != 1) {
            return false;
        }

        return true;
    }
}
