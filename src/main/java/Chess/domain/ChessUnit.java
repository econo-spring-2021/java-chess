package Chess.domain;

public class ChessUnit {
    ChessUnitType type;
    ChessUnitColor color;

    public ChessUnit() {
        this.type = ChessUnitType.EMPTY;
        this.color = ChessUnitColor.BLACK;
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
}
