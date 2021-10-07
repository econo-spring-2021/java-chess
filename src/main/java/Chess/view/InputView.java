package Chess.view;

import Chess.exception.InvalidUserInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    public static final String GAME_START_COMMAND = "start";
    public static final String GAME_END_COMMAND = "end";
    public static final String GAME_MOVE_COMMAND = "move";
    public static final String GAME_STATUS_COMMAND = "status";

    private static Scanner scanner = new Scanner(System.in);

    public static void setTestScanner(Scanner testScanner) {
        scanner = testScanner;
    }

    public static List<String> getGameOperationCommands() {
        try {
            String input = scanner.nextLine().toLowerCase();
            List<String> commands = Arrays.asList(input.split(" "));
            String command = commands.get(0);
            if (!command.equals(GAME_START_COMMAND) && !command.equals(GAME_END_COMMAND) && !command.equals(GAME_MOVE_COMMAND) && !command.equals(GAME_STATUS_COMMAND)) {
                throw new InvalidUserInputException("올바르지 않은 명령어입니다.");
            }

            if (command.equals(GAME_MOVE_COMMAND)) {
                validateMoveCommand(commands);
            }

            return commands;
        } catch (InvalidUserInputException e) {
            OutputView.printException(e);

            return getGameOperationCommands();
        }
    }

    private static void validateMoveCommand(List<String> commands) throws InvalidUserInputException {
        if (commands.size() != 3) {
            throw new InvalidUserInputException("알맞은 갯수의 명령어를 입력하세요.");
        }

        if (commands.get(1).length() > 2 || commands.get(2).length() > 2) {
            throw new InvalidUserInputException("올바르지 않은 위치 값입니다.");
        }

        if (commands.get(1).equals(2)) {
            throw new InvalidUserInputException("같은 위치로 움직일 수 없습니다.");
        }

        Pattern specialCharactersPattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher specialCharactersMatcher = specialCharactersPattern.matcher(commands.get(1));
        if (specialCharactersMatcher.find()) {
            throw new InvalidUserInputException("위치 값에는 특수 문자가 들어갈 수 없습니다. (source 위치)");
        }

        specialCharactersMatcher = specialCharactersPattern.matcher(commands.get(2));
        if (specialCharactersMatcher.find()) {
            throw new InvalidUserInputException("위치 값에는 특수 문자가 들어갈 수 없습니다. (target 위치)");
        }
    }
}
