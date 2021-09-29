package Chess.domain.ChessUnit;

public class EmptyCell extends Unit {
    public EmptyCell() {
        super(UnitType.EMPTY, UnitColor.WHITE);
    }

    @Override
    public boolean isAbleToMove(int fromR, int fromC, int toR, int toC) {
        return false;
    }
}
