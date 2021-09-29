package Chess.domain.ChessUnit;

import Chess.domain.ChessBoard;

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

    public void move(int fromR, int fromC, int toR, int toC) {
        ChessBoard.getInstance().setUnitFromCell(toR, toC, this);
        ChessBoard.getInstance().setUnitFromCell(fromR, fromC, new EmptyCell());
    }

    public abstract boolean isAbleToMove(int fromR, int fromC, int toR, int toC);

    protected boolean isExistTeammateOnDestination(int toR, int toC) {
        Unit unit = ChessBoard.getInstance().getUnitFromCell(toR, toC);
        if (unit instanceof EmptyCell || color != unit.getColor()) {
            return false;
        }

        return true;
    }

    protected int getNextPositionToCheck(int from, int to) {
        if (from < to) {
            return from + 1;
        }

        return from - 1;
    }
}
