import java.util.*;

public class HospitalRunner {
    public static void main(String[] args) {
        String userInput;
        Hospital hospital;
        boolean notChosen = true;
        Scanner sc = new Scanner(System.in);

        while (notChosen) {
            System.out.println("What would you like to do? \n1. Edit your hospital\n2. Exit program\n");
            userInput = sc.nextLine();
            if (userInput.equals("1") || userInput.equals("2")) notChosen = false;
            else System.out.println("\nPlease input a valid choice!\n");
        }
    }
}
