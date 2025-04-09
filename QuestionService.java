import java.util.Scanner;

// Service class that handles quiz logic
public class QuestionService {

    Questions[] question = new Questions[5];
    String selection[]= new String[5];

    // Constructor initializes all quiz questions
    public QuestionService(){
        question[0] = new Questions(1,"In Java, what is the size of int?", "2", "6", "4", "8", "4");
        question[1] = new Questions(2,"In Java, what is the size of double?", "2", "6", "4", "8", "8");
        question[2] = new Questions(3,"In Java, what is the size of char?", "2", "6", "4", "8", "2");
        question[3] = new Questions(4,"In Java, what is the size of long?", "2", "6", "4", "8", "8");
        question[4] = new Questions(5,"In Java, what is the size of boolean?", "2", "6", "1", "8", "1");
    }
    public void playQuiz(){
        
        int i=0;
        Scanner sc= new Scanner(System.in);
        // Loop through each question
        for(Questions q: question){

            System.out.println("Question no." + q.getId());
            System.out.println(q.getQuestion());
            System.out.println("1. " + q.getOpt1());
            System.out.println("2. " + q.getOpt2());
            System.out.println("3. " + q.getOpt3());
            System.out.println("4. " + q.getOpt4());
            //System.out.println("Enter your answer: ");
            System.out.print("Enter your option (1/2/3/4): ");
            int choice = sc.nextInt();
            // Store the user's selected answer
            switch (choice) {
                case 1 -> selection[i] = q.getOpt1();
                case 2 -> selection[i] = q.getOpt2();
                case 3 -> selection[i] = q.getOpt3();
                case 4 -> selection[i] = q.getOpt4();
                default -> {
                    System.out.println("Invalid input, defaulting to option 1.");
                    selection[i] = q.getOpt1();
                }
            }
            // Give immediate feedback on the selected answer
            if (selection[i].equals(q.getAnswer())) {
                System.out.println("Correct!\n");
            } else {
                System.out.println("Incorrect. The correct answer was: " + q.getAnswer() + "\n");
            }
            i++;
        }
        sc.close();
        System.out.println("Your answers:");
        for (String s: selection){
            System.out.println(s);
        }
    }

    // Method to calculate and print the user's score
    public void printScore(){
        int score=0;
        for (int i=0; i<question.length;i++){
            Questions que = question[i];
            String actualAnswer = que.getAnswer();
            String userAnswer= selection[i];
            if(actualAnswer.equals(userAnswer)){
                score++;
            }
        }
        System.out.println("Your score is: " + score);
    }
}

