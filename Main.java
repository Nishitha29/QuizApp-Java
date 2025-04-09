// Entry point of the quiz application
class Main{
    public static void main(String args[]){
        
        // Creating an instance of QuestionService
        QuestionService service = new QuestionService();

        //starting the quiz
        service.playQuiz();

        //print the final score
        service.printScore();
    }
}