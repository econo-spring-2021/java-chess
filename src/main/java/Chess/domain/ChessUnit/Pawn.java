package Chess.domain.ChessUnit;

import Chess.domain.ChessBoard;
import Chess.domain.Position;
import Chess.exception.InvalidUserInputException;

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
    protected void validateIsAbleToMove(Position source, Position destination) {
        if (isExistTeammateOnDestination(destination)) {
            throw new InvalidUserInputException("해당 위치에는 팀원이 있습니다.");
        }

        if (!isRightDirectionMove(source, destination)) {
            throw new InvalidUserInputException("잘못된 방향의 경로입니다.");
        }

        Unit targetUnit = ChessBoard.getInstance().getUnitFromCell(destination);
        if (isAbleAttackMove(source, destination) && targetUnit.getType() == UnitType.EMPTY) {
            throw new InvalidUserInputException("해당 위치는 움직일 수 없는 경로입니다.");
        }

        if (isFirstMove(source, destination)) {
            if (!isFirstMovement) {
                throw new InvalidUserInputException("해당 위치는 움직일 수 없는 경로입니다.");
            }
        } else {
            if (!isAbleMovement(source, destination)) {
                throw new InvalidUserInputException("해당 위치는 움직일 수 없는 경로입니다.");
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
