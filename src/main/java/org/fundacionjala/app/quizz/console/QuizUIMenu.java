package org.fundacionjala.app.quizz.console;

import org.fundacionjala.app.quizz.model.Question;
import org.fundacionjala.app.quizz.model.Quiz;
import org.fundacionjala.app.quizz.console.util.InputReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class QuizUIMenu {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    JsonArray quizJson = new JsonArray();

    public Quiz handleCreateQuiz() {
        String title = askQuizTitle();
        quizJson.add(title);
        Quiz quiz = new Quiz(title);
        boolean shouldExit = false;

        do {
            showMenu();
            char option = InputReader.readOption();
            switch (option) {
                case '1':
                    Question question = QuestionUIMenu.handleCreateQuestion();
                    quiz.addQuestion(question);
                    quizJson.add(gson.toJson(question));
                    gson.toJson(quizJson, System.out);
                    gson.toString();
                    break;
                case '0':
                    shouldExit = true;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (!shouldExit);

        return quiz;
    }

    private void showMenu() {
        System.out.println("Select an option:");
        System.out.println("1. Add a new question");
        System.out.println("0. Finish");
    }

    private String askQuizTitle() {
        System.out.println("Type the quiz title");
        return InputReader.readLine();
    }
}
