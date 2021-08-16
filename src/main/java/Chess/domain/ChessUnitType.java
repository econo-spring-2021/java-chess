package Chess.domain;

public enum ChessUnitType {
    KING('K', 'k'),
    QUEEN('Q', 'q'),
    ROOK('R', 'r'),
    BISHOP('B', 'b'),
    KNIGHT('N', 'n'),
    PAWN('P', 'p'),
    EMPTY('.', '.');

    private Character black;
    private Character white;

    ChessUnitType(Character black, Character white) {
        this.black = black;
        this.white = white;
    }

    public Character getBlackSymbol() {
        return black;
    }

    public Character getWhiteSymbol() {
        return white;
    }
}
