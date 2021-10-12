package Chess.domain.ChessUnit;

import Chess.domain.ChessBoard;
import Chess.domain.Position;
import Chess.exception.InvalidPositionException;

public abstract class Unit {
    UnitType type;
    UnitColor color;

    public Unit(UnitType type) {
        this.type = type;
        this.color = UnitColor.WHITE;
    }

    public Unit(UnitType type, UnitColor color) {
        this.type = type;
        this.color = color;
    }

    public UnitType getType() {
        return type;
    }

    public String getTypeSymbol() {
        if (color == UnitColor.WHITE) {
            return type.getWhiteSymbol();
        }

        return type.getBlackSymbol();
    }

    public UnitColor getColor() {
        return color;
    }

    public void move(Position source, Position destination) throws InvalidPositionException {
        validateIsAbleToMove(source, destination);

        ChessBoard.getInstance().setUnitFromCell(destination, this);
        ChessBoard.getInstance().setUnitFromCell(source, new EmptyCell());
    }

    protected abstract void validateIsAbleToMove(Position source, Position destination) throws InvalidPositionException;

    protected boolean isExistTeammateOnDestination(Position position) {
        Unit unit = ChessBoard.getInstance().getUnitFromCell(position);
        if (unit.getType().equals(UnitType.EMPTY) || !unit.getColor().equals(color)) {
            return false;
        }

        return true;
    }
}
