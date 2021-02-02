package org.fundacionjala.app.quizz.model.validator;

import java.util.ArrayList;
import java.util.List;

public class OnlyUppercaseValidator implements Validator {

    private static ArrayList<Character> lowercaseArray = new ArrayList<Character>();

    private static final String ERROR_MESSAGE = "The text must be only uppercase";

    @Override
    public void validate(String value, String conditionValue, List<String> errors) {
        this.buildArrayList();
        for(int i=0; i<value.length(); i++) {
                if(lowercaseArray.contains(value.charAt(i))) {
                    errors.add(ERROR_MESSAGE);
                }
        }
        /*if (value == null || value.equals("")) {
            errors.add(ERROR_MESSAGE);
        }*/
    }

    private void buildArrayList() {
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        for(int x=0; x<lowercase.length(); x++) {
            lowercaseArray.add(lowercase.charAt(x));
        }
    }
}
