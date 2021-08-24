package Chess.domain.ChessUnit;

public class Queen extends ChessUnit {
    public Queen() {
        super(ChessUnitType.QUEEN, ChessUnitColor.BLACK);
    }

    public Queen(ChessUnitColor color) {
        super(ChessUnitType.QUEEN, color);
    }

    @Override
    public boolean isAbleToMove(int fromR, int fromC, int toR, int toC) {
        if (Math.abs(fromR - toR) <= 1 && Math.abs(fromC - toC) <= 1) {
            return true;
        }

        if (Math.abs(fromR - toR) == Math.abs(fromC - toC)) {
            return true;
        }

        return false;
    }
}
