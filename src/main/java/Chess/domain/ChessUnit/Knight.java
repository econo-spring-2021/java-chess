package Chess.domain.ChessUnit;

public class Knight extends Unit {
    public Knight() {
        super(UnitType.KNIGHT);
    }

    public Knight(UnitColor color) {
        super(UnitType.KNIGHT, color);
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
