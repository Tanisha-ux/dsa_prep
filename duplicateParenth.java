import java.util.*;

public class duplicateParenth {
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ')' || ch == '}' || ch == ']') {
                char matchingOpen = (ch == ')') ? '(' : (ch == '}') ? '{' : '[';
                int count = 0;

                while (!s.isEmpty() && s.peek() != matchingOpen) {
                    s.pop();
                    count++;
                }

                if (s.isEmpty()) return false; // Unbalanced case
                if (count == 0) return true;   // Duplicate found
                s.pop(); // Pop the matching opening bracket
            } else {
                s.push(ch);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String str = "((a+b))"; // Try other test cases too
        System.out.println(isDuplicate(str)); // Output: true
    }
}
