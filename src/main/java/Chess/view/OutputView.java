package Chess.view;

public class OutputView {
    private static String GAME_START_MESSAGE = "체스 게임을 시작합니다.";
    private static String ASKING_GAME_OPERATION_COMMAND_MESSAGE = "게임 시작은 %s, 종료는 %s 명령을 입력하세요.\n";

    public static void printException(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printString(String string) {
        System.out.println(string);
    }

    public static void announceGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void askGameOperationCommand() {
        System.out.printf(ASKING_GAME_OPERATION_COMMAND_MESSAGE, InputView.GAME_START_COMMAND, InputView.GAME_END_COMMAND);
    }

}
