package Chess.domain.ChessUnit;

public class Knight extends ChessUnit {
    public Knight() {
        super(ChessUnitType.KNIGHT);
    }

    public Knight(ChessUnitColor color) {
        super(ChessUnitType.KNIGHT, color);
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
        if ((Math.abs(fromR - toR) == 2 && Math.abs(fromC - toC) == 1) ||
                (Math.abs(fromR - toR) == 1 && Math.abs(fromC - toC) == 2)) {
            return true;
        }

        return false;
    }
}
