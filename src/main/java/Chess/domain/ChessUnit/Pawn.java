package Chess.domain.ChessUnit;

import Chess.domain.ChessBoard;
import Chess.domain.Position;
import Chess.exception.InvalidPositionException;
import Chess.exception.InvalidPositionException;

public class Pawn extends Unit {
    public static UnitType TYPE = UnitType.PAWN;

    private boolean isFirstMovement = true;

    public Pawn() {
        super(TYPE);
    }

    public Pawn(UnitColor color) {
        super(TYPE, color);
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

    /**
     * 폰의 기본 이동 규칙에 부합하는 이동인지 검사한다.
     * @param source 말이 있던 위치
     * @param destination 말이 이동할 위치
     */
    private boolean isAbleMovement(Position source, Position destination) {
        if (Math.abs(source.getRow() - destination.getRow()) != 1) {
            return false;
        }

        return true;
    }

    /**
     * 폰의 팀에 따른 이동 방향이 올바른지 검사한다.
     * @param source 말이 있던 위치
     * @param destination 말이 이동할 위치
     */
    private boolean isRightDirectionMove(Position source, Position destination) {
        if (color == UnitColor.WHITE && source.getRow() - destination.getRow() < 0) {
            return false;
        }

        if (color == UnitColor.BLACK && source.getRow() - destination.getRow() > 0) {
            return false;
        }

        return true;
    }

    /**
     * 폰이 공격용 이동 규칙에 부합하는 이동인지 검사한다
     * @param source 말이 있던 위치
     * @param destination 말이 이동할 위치
     */
    private boolean isAbleAttackMove(Position source, Position destination) {
        if (Math.abs(source.getRow() - destination.getRow()) == 1 && Math.abs(source.getCol() - destination.getCol()) == 1) {
            return true;
        }

        return false;
    }

    /**
     * 킹의 첫 이동 규칙에 부합하는 이동인지 검사한다.
     * @param source 말이 있던 위치
     * @param destination 말이 이동할 위치
     */
    private boolean isFirstMove(Position source, Position destination) {
        if (Math.abs(source.getRow() - destination.getRow()) == 2) {
            return true;
        }

        return false;
    }
}
