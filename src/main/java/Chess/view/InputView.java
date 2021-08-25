package Chess.view;

import java.util.Scanner;

public class InputView {
    public static final String GAME_START_COMMAND = "start";
    public static final String GAME_END_COMMAND = "end";
    public static final String GAME_MOVE_COMMAND = "move";

    private static Scanner scanner = new Scanner(System.in);

    public static void setTestScanner(Scanner testScanner) {
        scanner = testScanner;
    }

    public static String getGameOperationCommand() {
        try {
            String command = scanner.nextLine().toLowerCase();
            if (!command.equals(GAME_START_COMMAND) && !command.equals(GAME_END_COMMAND) && !command.equals(GAME_MOVE_COMMAND)) {
                throw new InvalidUserInputException("올바르지 않은 커멘드입니다.");
            }

            return command;
        } catch (InvalidUserInputException e) {
            OutputView.printException(e);

            return getGameOperationCommand();
        }
    }
}
