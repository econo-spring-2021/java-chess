package Chess.view;

import Chess.domain.ChessUnit.UnitColor;

public class OutputView {
    private static final String GAME_START_MESSAGE = "> 체스 게임을 시작합니다.";
    private static final String ASKING_GAME_OPERATION_COMMAND_MESSAGE = "> 게임 시작 : %s\n> 게임 종료 : %s\n> 게임 이동 : %s source위치 target위치 - 예 %s b2 b3\n";
    private static final String GAME_FINISH_MESSAGE = "> 게임이 끝났습니다.";
    private static final String GAME_BLACK_WIN_MESSAGE = "> 흑팀이 이겼습니다.";
    private static final String GAME_WHITE_WIN_MESSAGE = "> 백팀이 이겼습니다.";
    private static final String GAME_ON_PROGRESS_MESSAGE = "> 게임이 진행중입니다.";
    private static final String GAME_SCORE_MESSAGE = "> 흑 : %f 점, 백 : %f 점";

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

    public static void printGameResult(UnitColor winner) {
        System.out.println(GAME_FINISH_MESSAGE);
        if (winner.equals(UnitColor.BLACK)) {
            System.out.println(GAME_BLACK_WIN_MESSAGE);
            return;
        }

        System.out.println(GAME_WHITE_WIN_MESSAGE);
    }

    public static void printPlayerScore(float blackScore, float whiteScore) {
        System.out.println(GAME_ON_PROGRESS_MESSAGE);
        System.out.printf(GAME_SCORE_MESSAGE, blackScore, whiteScore);
    }
}
