package Chess.domain.ChessUnit;

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

    public abstract boolean isAbleToMove(int fromR, int fromC, int toR, int toC);
}
