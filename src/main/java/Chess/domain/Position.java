package Chess.domain;

import Chess.exception.InvalidUserInputException;
import Chess.view.OutputView;

public class Position {

    private int row;
    private int col;

    public Position(String pos) throws InvalidUserInputException {
        try {
            this.row = convertCharRowToIntRow(pos.charAt(1));
            this.col = convertCharColToIntCol(pos.charAt(0));

            validatePositionRange();

            this.row = convertInputRowToDataRow(this.row);
        } catch (InvalidUserInputException e) {
            OutputView.printException(e);
        }
    }

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Position(Position pos) {
        this.row = pos.getRow();
        this.col = pos.getCol();
    }

    private int convertCharRowToIntRow(char row) {
        return row - '0';
    }

    private int convertCharColToIntCol(char col) {
        return col - 'a';
    }

    private int convertInputRowToDataRow(int row) {
        return ChessBoard.CHESSBOARD_ROW - row;
    }

    private void validatePositionRange() {
        if (row < 0 || row >= ChessBoard.CHESSBOARD_ROW) {
            throw new InvalidUserInputException("올바르지 않은 범위의 행 값입니다.");
        }

        if (col < 0 || col >= ChessBoard.CHESSBOARD_COLUMN) {
            throw new InvalidUserInputException("올바르지 않은 범위의 열 값입니다.");
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setNextRowToCheck(Position destination) {
        if (row < destination.getRow()) {
            row++;
        }

        row--;
    }

    public void setNextColToCheck(Position destination) {
        if (col < destination.getCol()) {
            col++;
        }

        col--;
    }
}
