package Chess.domain;

public class ChessUnit {
    ChessUnitType type;

    public ChessUnit(ChessUnitType type) {
        this.type = type;
    }

    public ChessUnitType getType() {
        return type;
    }
}
