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
public class Question {
    private int question;
private String NoiDung;
    private String CauA;
    private String CauB;
    private String CauC;
    private String CauD;
    private String Answer;
    
    public Question(){
        
    }
    
    public Question(int question, String NoiDung, String CauA, String CauB, String CauC, String CauD, String Answer){
        this.question = question;
        this.NoiDung = NoiDung;
        this.CauA = CauA;
        this.CauB = CauB;
        this.CauC = CauC;
        this.CauD = CauD;
        this.Answer = Answer;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public String getCauA() {
        return CauA;
    }

    public void setCauA(String CauA) {
        this.CauA = CauA;
    }

    public String getCauB() {
        return CauB;
    }

    public void setCauB(String CauB) {
        this.CauB = CauB;
    }

    public String getCauC() {
        return CauC;
    }

    public void setCauC(String CauC) {
        this.CauC = CauC;
    }

    public String getCauD() {
        return CauD;
    }

    public void setCauD(String CauD) {
        this.CauD = CauD;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String Answer) {
        this.Answer = Answer;
    }
}
