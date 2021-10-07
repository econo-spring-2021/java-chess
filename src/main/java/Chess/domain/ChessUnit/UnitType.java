package Chess.domain.ChessUnit;

public enum UnitType {
    KING("k", 0),
    QUEEN("q", 9),
    ROOK("r", 5),
    BISHOP("b", 3),
    KNIGHT("n", 2.5f),
    PAWN("p", 1),
    EMPTY(".", 0);

    private String type;
    private float score;

    UnitType(String type, float score) {
        this.type = type;
        this.score = score;
    }

    public String getBlackSymbol() {
        return type.toUpperCase();
    }

    public String getWhiteSymbol() {
        return type.toLowerCase();
    }

    public float getScore() {
        return score;
    }
}
