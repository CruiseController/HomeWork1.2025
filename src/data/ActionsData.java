package data;

import java.util.Locale;

public enum ActionsData {

    ADD, LIST, EXIT;

    public static ActionsData toEnumActionsFunc(String userInputData) {

        userInputData = userInputData.toUpperCase().trim();
        return ActionsData.valueOf(userInputData);
    }


}
