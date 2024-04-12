package practicle;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of friends: ");
        int n = scanner.nextInt();
        HashSet<String> friendNames = new HashSet<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the name of friend " + (i + 1) + ": ");
            String name = scanner.next();
            friendNames.add(name);
        }
        ArrayList<String> sortedNames = new ArrayList<>(friendNames);
        Collections.sort(sortedNames);
        System.out.println("\nFriend Names in Ascending Order:");
        for (String name : sortedNames) {
            System.out.println(name);
        }
    }
}

