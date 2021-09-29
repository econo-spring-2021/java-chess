package Chess.domain.ChessUnit;

public enum UnitType {
    KING("k"),
    QUEEN("q"),
    ROOK("r"),
    BISHOP("b"),
    KNIGHT("n"),
    PAWN("p"),
    EMPTY(".");

    private String type;

    UnitType(String type) {
        this.type = type;
    }

    public String getBlackSymbol() {
        return type.toUpperCase();
    }

    public String getWhiteSymbol() {
        return type.toLowerCase();
    }
}
