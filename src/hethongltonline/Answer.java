/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hethongltonline;

/**
 *
 * @author Admin
 */
public class Answer {
    
    public static String yourAnswer;
    public static int score;
    public static String answer;
    
    public Answer(){
        
    }
    
    public Answer(String youAnswer, int score, String answer){
        this.yourAnswer = youAnswer;
        this.score = score;
        this.answer = answer;
    }

    public static String getYourAnswer() {
        return yourAnswer;
    }

    public static void setYourAnswer(String yourAnswer) {
        Answer.yourAnswer = yourAnswer;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Answer.score = score;
    }

    public static String getAnswer() {
        return answer;
    }

    public static void setAnswer(String answer) {
        Answer.answer = answer;
    }
    
    
}
