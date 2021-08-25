package Chess.view;

public class OutputView {
    private static final String GAME_START_MESSAGE = "> 체스 게임을 시작합니다.";
    private static final String ASKING_GAME_OPERATION_COMMAND_MESSAGE = "> 게임 시작 : %s\n> 게임 종료 : %s\n> 게임 이동 : %s source위치 target위치 - 예 %s b2 b3\n";

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
        System.out.printf(ASKING_GAME_OPERATION_COMMAND_MESSAGE,
                InputView.GAME_START_COMMAND, InputView.GAME_END_COMMAND,
                InputView.GAME_MOVE_COMMAND, InputView.GAME_MOVE_COMMAND);
    }

}
