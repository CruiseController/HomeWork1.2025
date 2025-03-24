package tools;

import animals.pets.Dog;

public class IsNumericCheck {

    public static boolean isNumeric(String inputString) {
        try {
            Integer.parseInt(inputString);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }

    }


}
