package Chess.domain.ChessUnit;

import Chess.domain.ChessBoard;
import Chess.domain.Position;
import Chess.exception.InvalidUserInputException;

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

    public void move(Position source, Position destination) throws InvalidUserInputException {
        validateIsAbleToMove(source, destination);

        ChessBoard.getInstance().setUnitFromCell(destination, this);
        ChessBoard.getInstance().setUnitFromCell(source, new EmptyCell());
    }

    protected abstract void validateIsAbleToMove(Position source, Position destination) throws InvalidUserInputException;

    protected boolean isExistTeammateOnDestination(Position position) {
        Unit unit = ChessBoard.getInstance().getUnitFromCell(position);
        if (unit instanceof EmptyCell || color != unit.getColor()) {
            return false;
        }

        return true;
    }
}
