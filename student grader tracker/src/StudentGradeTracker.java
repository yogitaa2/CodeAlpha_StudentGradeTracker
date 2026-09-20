import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> marks = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Number of students must be greater than 0.");
            sc.close();
            return;
        }

        for (int i = 0; i < n; i++) {

            System.out.print("\nEnter student name: ");
            String name = sc.next();

            int mark;

            while (true) {
                System.out.print("Enter marks (0-100): ");
                mark = sc.nextInt();

                if (mark >= 0 && mark <= 100) {
                    break;
                }

                System.out.println("Invalid marks. Please enter marks between 0 and 100.");
            }

            names.add(name);
            marks.add(mark);
        }

        int total = 0;
        int highest = marks.get(0);
        int lowest = marks.get(0);

        int highestIndex = 0;
        int lowestIndex = 0;

        for (int i = 0; i < marks.size(); i++) {

            total += marks.get(i);

            if (marks.get(i) > highest) {
                highest = marks.get(i);
                highestIndex = i;
            }

            if (marks.get(i) < lowest) {
                lowest = marks.get(i);
                lowestIndex = i;
            }
        }

        double average = (double) total / marks.size();

        System.out.println("\n-----------------------------");
        System.out.println("       STUDENT REPORT");
        System.out.println("-----------------------------");

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + " - " + marks.get(i));
        }

        System.out.println("\n-----------------------------");
        System.out.printf("Average Marks : %.2f%n", average);
        System.out.println("Highest Marks : " + highest + " (" + names.get(highestIndex) + ")");
        System.out.println("Lowest Marks  : " + lowest + " (" + names.get(lowestIndex) + ")");
        System.out.println("-----------------------------");

        sc.close();
    }
}