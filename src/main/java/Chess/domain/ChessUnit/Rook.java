package Chess.domain.ChessUnit;

public class Rook extends ChessUnit {
    public Rook() {
        super(ChessUnitType.ROOK);
    }

    public Rook(ChessUnitColor color) {
        super(ChessUnitType.ROOK, color);
    }

    @Override
    public boolean isAbleToMove(int fromR, int fromC, int toR, int toC) {
        if (fromR != toR && fromC != toC) {
            return false;
        }

        return true;
    }
}
