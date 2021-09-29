package Chess.domain.ChessUnit;

import Chess.domain.ChessBoard;
import Chess.domain.Position;
import Chess.exception.InvalidPositionException;
import Chess.exception.InvalidPositionException;

public class Pawn extends Unit {
    private boolean isFirstMovement = true;

    public Pawn() {
        super(UnitType.PAWN);
    }

    public Pawn(UnitColor color) {
        super(UnitType.PAWN, color);
    }

    @Override
    public void move(Position source, Position destination) {
        super.move(source, destination);

        if (isFirstMovement) {
            isFirstMovement = false;
        }
    }

    @Override
    protected void validateIsAbleToMove(Position source, Position destination) throws InvalidPositionException {
        if (isExistTeammateOnDestination(destination)) {
            throw new InvalidPositionException(InvalidPositionException.TEAMMATE_ON_DESTINATION);
        }

        if (!isRightDirectionMove(source, destination)) {
            throw new InvalidPositionException(InvalidPositionException.WRONG_DIRECTION_PATH);
        }

        Unit targetUnit = ChessBoard.getInstance().getUnitFromCell(destination);
        if (isAbleAttackMove(source, destination) && targetUnit.getType() == UnitType.EMPTY) {
            throw new InvalidPositionException(InvalidPositionException.UNABLE_PATH);
        }

        if (isFirstMove(source, destination)) {
            if (!isFirstMovement) {
                throw new InvalidPositionException(InvalidPositionException.UNABLE_PATH);
            }
        } else {
            if (!isAbleMovement(source, destination)) {
                throw new InvalidPositionException(InvalidPositionException.UNABLE_PATH);
            }
        }
    }

    private boolean isAbleMovement(Position source, Position destination) {
        if (Math.abs(source.getRow() - destination.getRow()) != 1) {
            return false;
        }

        return true;
    }

    private boolean isRightDirectionMove(Position source, Position destination) {
        if (color == UnitColor.WHITE && source.getRow() - destination.getRow() < 0) {
            return false;
        }

        if (color == UnitColor.BLACK && source.getRow() - destination.getRow() > 0) {
            return false;
        }

        return true;
    }

    private boolean isAbleAttackMove(Position source, Position destination) {
        if (Math.abs(source.getRow() - destination.getRow()) == 1 && Math.abs(source.getCol() - destination.getCol()) == 1) {
            return true;
        }

        return false;
    }

    private boolean isFirstMove(Position source, Position destination) {
        if (Math.abs(source.getRow() - destination.getRow()) == 2) {
            return true;
        }

        return false;
    }
}
