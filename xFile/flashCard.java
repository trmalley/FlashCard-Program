package xFile;

public class flashCard {

    String title;
    String question;
    String answer;

    public flashCard(String title, String question, String answer ){
        this.title = title;
        this.question = question;
        this.answer = answer;
    }
    public String getTitle(){
        return this.title;
    }
    public String getQuestion(){
        return this.question;
    }
    public String getAnwser(){
        return this.answer;
    }
    public void editTitle(String newTitle){
        this.title = newTitle;
    }
    public void editQuestion(String newQuestion){
        this.question = newQuestion;
    }
    public void editAnswer(String newAnswer){
        this.answer = newAnswer;
    }
    //toString for testing only
    public String toString(){
        return "Title: " + this.title + "\nQuestion: "+
                this.question + "\nAnswer: " + this.answer;
    }
}
