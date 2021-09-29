package Chess.domain.ChessUnit;

import Chess.domain.Position;

public class EmptyCell extends Unit {
    public EmptyCell() {
        super(UnitType.EMPTY, UnitColor.WHITE);
    }

    @Override
    protected void validateIsAbleToMove(Position source, Position destination) {

    }
}
