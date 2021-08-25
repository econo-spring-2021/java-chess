package Chess.domain.ChessUnit;

public class Bishop extends ChessUnit {
    public Bishop() {
        super(ChessUnitType.BISHOP);
    }

    public Bishop(ChessUnitColor color) {
        super(ChessUnitType.BISHOP, color);
    }

    @Override
    public boolean isAbleToMove(int fromR, int fromC, int toR, int toC) {
        if (Math.abs(fromR - toR) != Math.abs(fromC - toC)) {
            return false;
        }

        return true;
    }
}
