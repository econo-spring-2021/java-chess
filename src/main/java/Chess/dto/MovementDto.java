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
        int row = source / ChessBoard.CHESSBOARD_COLUMN;
        int col = source % ChessBoard.CHESSBOARD_COLUMN - 1;
        if (source % ChessBoard.CHESSBOARD_COLUMN == 0) {
            row -= 1;
            col = ChessBoard.CHESSBOARD_COLUMN - 1;
        }
        return new Position(row, col);
    }

    public Position getDestinationPosition() {
        int row = destination / ChessBoard.CHESSBOARD_COLUMN;
        int col = destination % ChessBoard.CHESSBOARD_COLUMN - 1;
        if (destination % ChessBoard.CHESSBOARD_COLUMN == 0) {
            row -= 1;
            col = ChessBoard.CHESSBOARD_COLUMN - 1;
        }
        return new Position(row, col);
    }
}
