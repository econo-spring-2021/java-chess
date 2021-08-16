package Chess.domain;

public class ChessUnit {
    ChessUnitType type;
    boolean isBlack;

    public ChessUnit(ChessUnitType type, boolean isBlack) {
        this.type = type;
        this.isBlack = isBlack;
    }

    public ChessUnitType getType() {
        return type;
    }

    public Character getTypeSymbol() {
        if (isBlack) {
            return type.getBlackSymbol();
        }

        return type.getWhiteSymbol();
    }
}
