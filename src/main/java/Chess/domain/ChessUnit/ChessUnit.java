package Chess.domain.ChessUnit;

import Chess.domain.ChessBoard;

public abstract class ChessUnit {
    ChessUnitType type;
    ChessUnitColor color;

    public ChessUnit(ChessUnitType type) {
        this.type = type;
        this.color = ChessUnitColor.WHITE;
    }

    public ChessUnit(ChessUnitType type, ChessUnitColor color) {
        this.type = type;
        this.color = color;
    }

    public ChessUnitType getType() {
        return type;
    }

    public Character getTypeSymbol() {
        if (color == ChessUnitColor.WHITE) {
            return type.getWhiteSymbol();
        }

        return type.getBlackSymbol();
    }

    public ChessUnitColor getColor() {
        return color;
    }

    public void move(int fromR, int fromC, int toR, int toC) {
        ChessBoard.getInstance().setUnitFromCell(toR, toC, this);
        ChessBoard.getInstance().setUnitFromCell(fromR, fromC, new EmptyCell());
    }

    public abstract boolean isAbleToMove(int fromR, int fromC, int toR, int toC);
}
