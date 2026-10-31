
import java.util.Scanner;

public class AIChatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String message;

        System.out.println("================================");
        System.out.println("       WELCOME TO AI CHATBOT");
        System.out.println("================================");
        System.out.println("You can start chatting with me.");
        System.out.println("Type 'bye' to exit.");

        while (true) {

            System.out.print("\nYou: ");
            message = sc.nextLine().toLowerCase().trim();

            if (message.equals("hello") || message.equals("hi")) {

                System.out.println("Bot: Hello! How can I help you?");

            } 
            else if (message.contains("how are you")) {

                System.out.println("Bot: I am fine! Thank you for asking.");

            } 
            else if (message.contains("your name")) {

                System.out.println("Bot: My name is JavaBot.");

            } 
            else if (message.contains("java")) {

                System.out.println("Bot: Java is a popular programming language.");

            } 
            else if (message.contains("what is ai")) {

                System.out.println("Bot: AI stands for Artificial Intelligence.");

            } 
            else if (message.contains("what is nlp")) {

                System.out.println("Bot: NLP stands for Natural Language Processing.");

            } 
            else if (message.contains("weather")) {

                System.out.println("Bot: You can check the latest weather using a weather website.");

            } 
            else if (message.contains("college")) {

                System.out.println("Bot: College is a place where students learn and develop skills.");

            } 
            else if (message.contains("help")) {

                System.out.println("Bot: Sure! I am here to help you.");

            } 
            else if (message.contains("thank")) {

                System.out.println("Bot: You're welcome!");

            } 
            else if (message.equals("bye")) {

                System.out.println("Bot: Goodbye! Have a nice day.");
                break;

            } 
            else {

                System.out.println("Bot: Sorry, I don't understand. Please ask something else.");

            }
        }

        sc.close();
    }
}
