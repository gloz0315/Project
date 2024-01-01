package project1.invalidate;

import project1.view.InputView;

public class InvalidateEmpty {

    // 공백을 입력한 경우...
    public static String invalidateEmpty() {
        String text = InputView.input();

        if(text.isEmpty())
            return null;

        return text;
    }
}
