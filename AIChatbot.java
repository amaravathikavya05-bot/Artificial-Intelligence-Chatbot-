import java.util.ArrayList;
import java.util.Scanner;

class Response {

    String question;
    String answer;

    Response(String question, String answer) {
        this.question = question.toLowerCase();
        this.answer = answer;
    }
}

public class AIChatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Response> chatbot = new ArrayList<>();

        // Default Responses
        chatbot.add(new Response("hi", "Hello! How can I help you?"));
        chatbot.add(new Response("hello", "Hi there!"));
        chatbot.add(new Response("how are you", "I am functioning perfectly!"));
        chatbot.add(new Response("your name", "I am a Dynamic Java AI Chatbot."));
        chatbot.add(new Response("what is java",
                "Java is a popular object-oriented programming language."));
        chatbot.add(new Response("help",
                "I can answer questions and learn new responses dynamically."));
        chatbot.add(new Response("thank you", "You're welcome!"));

        System.out.println("======================================");
        System.out.println("       DYNAMIC AI CHATBOT SYSTEM");
        System.out.println("======================================");

        System.out.println("Bot: Hello! I am your AI Chatbot.");
        System.out.println("Bot: Type 'exit' to end the chat.");
        System.out.println("Bot: I can also learn new responses!\n");

        while (true) {

            System.out.print("You: ");
            String userInput = sc.nextLine().toLowerCase();

            // Exit
            if (userInput.equals("exit")) {

                System.out.println("Bot: Goodbye! Have a great day!");
                break;
            }

            boolean found = false;

            // Search Existing Responses
            for (Response r : chatbot) {

                if (userInput.contains(r.question)) {

                    System.out.println("Bot: " + r.answer);
                    found = true;
                    break;
                }
            }

            // If Question Not Found
            if (!found) {

                System.out.println(
                        "Bot: I don't know the answer for that."
                );

                System.out.print(
                        "Bot: Would you like to teach me? (yes/no): "
                );

                String choice = sc.nextLine().toLowerCase();

                if (choice.equals("yes")) {

                    System.out.print("Enter the correct response: ");
                    String newAnswer = sc.nextLine();

                    chatbot.add(new Response(userInput, newAnswer));

                    System.out.println(
                            "Bot: Thank you! I learned a new response."
                    );

                } else {

                    System.out.println(
                            "Bot: Okay! Let's continue chatting."
                    );
                }
            }
        }

        sc.close();
    }
}
