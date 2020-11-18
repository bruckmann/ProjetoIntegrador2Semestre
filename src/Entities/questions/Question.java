package Entities.questions;

public class Question {

    private int questionId;
    private int type;
    private String question;
    private String trueAlternative;
    private String falseAlternativeOne;
    private String falseAlternativeTwo;

    public Question(int questionId, String question, int type, String trueAlternative, String falseAlternativeOne, String falseAlternativeTwo) {
        this.question = question;
        this.type = type;
        this.trueAlternative = trueAlternative;
        this.falseAlternativeOne = falseAlternativeOne;
        this.falseAlternativeTwo = falseAlternativeTwo;
        this.questionId = questionId;
    }

    public int getId(){
        return this.questionId;
    }

    public void setType(String type) {
        if(type.toLowerCase().equals("soma")) {
            this.type = 1;
        }
        else if (type.toLowerCase().equals("subtracao")) {
            this.type = 2;
        }
        else if (type.toLowerCase().equals("ambos")) {
            this.type = 3;
        }
    }



}
