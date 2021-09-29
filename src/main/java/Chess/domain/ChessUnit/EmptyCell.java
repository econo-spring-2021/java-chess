package Chess.domain.ChessUnit;

public class EmptyCell extends ChessUnit {
    public EmptyCell() {
        super(ChessUnitType.EMPTY, ChessUnitColor.WHITE);
    }

    @Override
    public boolean isAbleToMove(int fromR, int fromC, int toR, int toC) {
        return false;
    }
}
