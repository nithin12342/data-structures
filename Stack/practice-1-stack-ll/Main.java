import java.util.Scanner;
import java.util.Stack;

public class CorporateFiestaBallPass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int currentPlayerId = scanner.nextInt();
        Stack<Integer> playerStack = new Stack<>();
        playerStack.push(currentPlayerId);
        for (int i = 0; i < N; i++) {
            String command = scanner.next();
            if (command.equals("F")) {
                int newPlayerId = scanner.nextInt();
                playerStack.push(newPlayerId);
            } else if (command.equals("R")) {
                if (playerStack.size() > 1) {
                    playerStack.pop();
                }
            }
        }
        System.out.println("Player " + playerStack.peek());
        scanner.close();
    }
}

