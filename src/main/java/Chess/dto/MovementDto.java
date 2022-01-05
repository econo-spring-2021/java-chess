package Chess.dto;

import Chess.domain.ChessBoard;
import Chess.domain.Position;

public class MovementDto {

    private int source;
    private int destination;

    public MovementDto() {
    }

    public MovementDto(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    public Position getSourcePosition() {
        return new Position(source%ChessBoard.CHESSBOARD_COLUMN - 1, source/ChessBoard.CHESSBOARD_COLUMN);
    }

    public Position getDestinationPosition() {
        return new Position(destination%ChessBoard.CHESSBOARD_COLUMN - 1, destination/ChessBoard.CHESSBOARD_COLUMN);
    }
}
