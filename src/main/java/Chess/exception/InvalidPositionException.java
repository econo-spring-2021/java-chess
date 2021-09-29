package Chess.exception;

public class InvalidPositionException  extends IllegalArgumentException{
    public static String TEAMMATE_ON_DESTINATION = "해당 위치에는 팀원이 있습니다.";
    public static String UNABLE_PATH = "해당 위치는 움직일 수 없는 경로입니다.";
    public static String OBSTACLE_IN_PATH = "경로에 장애물이 있습니다.";
    public static String WRONG_DIRECTION_PATH = "잘못된 방향의 경로입니다.";

    public InvalidPositionException(String message) {
        super(message);
    }
}
