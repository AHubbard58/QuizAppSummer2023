package org.hubbard.quizappsummer2023;

import java.security.PrivateKey;

public class Question {
    private  String qprompt;
    private boolean correctAnswer;

    public String getQprompt() {
        return qprompt;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setQprompt(String qprompt) {
        this.qprompt = qprompt;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Question(String qprompt, boolean correctAnswer) {
        this.qprompt = qprompt;
        this.correctAnswer = correctAnswer;


    }
}
