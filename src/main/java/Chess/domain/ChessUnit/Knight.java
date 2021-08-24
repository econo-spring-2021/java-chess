package Chess.domain.ChessUnit;

public class Knight extends ChessUnit {
    public Knight() {
        super(ChessUnitType.KNIGHT, ChessUnitColor.BLACK);
    }

    public Knight(ChessUnitColor color) {
        super(ChessUnitType.KNIGHT, color);
    }

    @Override
    public boolean isAbleToMove(int fromR, int fromC, int toR, int toC) {
        if ((Math.abs(fromR - toR) == 2 && Math.abs(fromC - toC) == 1) ||
                (Math.abs(fromR - toR) == 1 && Math.abs(fromC - toC) == 2)) {
            return true;
        }

        return false;
    }
}
