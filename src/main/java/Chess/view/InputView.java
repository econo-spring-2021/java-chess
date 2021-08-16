package Chess.view;

import java.util.Scanner;

public class InputView {
    public static String GAME_START_COMMAND = "start";
    public static String GAME_END_COMMAND = "end";

    private static Scanner scanner = new Scanner(System.in);

    public static void setTestScanner(Scanner testScanner) {
        scanner = testScanner;
    }

    public static String getGameOperationCommand() {
        try {
            String command = scanner.nextLine();
            if (!command.equals(GAME_START_COMMAND) && !command.equals(GAME_END_COMMAND)) {
                throw new InvalidUserInputException("올바르지 않은 커멘드입니다.");
            }

            return command.toLowerCase();
        } catch (InvalidUserInputException e) {
            OutputView.printException(e);

            return getGameOperationCommand();
        }
    }
}
