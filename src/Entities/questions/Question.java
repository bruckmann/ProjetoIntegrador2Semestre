package Entities.questions;

public class Question {

    private String question;
    private int type;
    private String trueAlternative;
    private String falseAlternativeOne;
    private String falseAlternativeTwo;

    public Question(String question, int type, String trueAlternative, String falseAlternativeOne, String falseAlternativeTwo) {
        this.question = question;
        this.type = type;
        this.trueAlternative = trueAlternative;
        this.falseAlternativeOne = falseAlternativeOne;
        this.falseAlternativeTwo = falseAlternativeTwo;
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
