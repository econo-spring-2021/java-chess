package Chess;

import Chess.view.InputView;
import Chess.view.InvalidUserInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class InputTest {

    private Scanner generateScanner(String string) {
        return new Scanner(string);

    }

//    @Test
//    @DisplayName("잘못된 게임 작동 커멘드를 입력할때, 올바른 예외를 던지는지")
//    void test_getGameOperationCommand_InvalidInputException() {
//        Assertions.assertThrows(InvalidUserInputException.class,
//                () -> InputView.setTestScanner(generateScanner("ERROR")));
//    }
}
