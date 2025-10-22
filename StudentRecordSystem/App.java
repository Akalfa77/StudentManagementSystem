package StudentRecordSystem;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        int choice;

        System.out.println(" Student Record Management System");

        do {
            System.out.println("\n======================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Sort by Name");
            System.out.println("6. Sort by Average Marks");
            System.out.println("7. Exit");
            System.out.print("-> Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print(" Please enter a valid number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    try {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        HashMap<String, Double> marksMap = new HashMap<>();
                        System.out.print("Enter marks in Java: ");
                        marksMap.put("Java", sc.nextDouble());
                        System.out.print("Enter marks in Python: ");
                        marksMap.put("Python", sc.nextDouble());
                        System.out.print("Enter marks in SQL: ");
                        marksMap.put("SQL", sc.nextDouble());

                        Student s = new Student(id, name, marksMap);
                        service.addStudent(s);
                    } catch (InputMismatchException e) {
                        System.out.println(" Invalid input! Please enter correct data types.");
                        sc.nextLine();
                    }
                }

                case 2 -> service.viewStudents();

                case 3 -> {
                    try {
                        System.out.print("Enter ID to update: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new Name: ");
                        String newName = sc.nextLine();

                        HashMap<String, Double> marksMap = new HashMap<>();
                        System.out.print("Enter new marks in Java: ");
                        marksMap.put("Java", sc.nextDouble());
                        System.out.print("Enter new marks in Python: ");
                        marksMap.put("Python", sc.nextDouble());
                        System.out.print("Enter new marks in SQL: ");
                        marksMap.put("SQL", sc.nextDouble());

                        service.updateStudent(id, marksMap, newName);
                    } catch (InputMismatchException e) {
                        System.out.println(" Invalid input! Try again.");
                        sc.nextLine();
                    }
                }

                case 4 -> {
                    System.out.print("Enter ID to delete: ");
                    int id = sc.nextInt();
                    service.deleteStudent(id);
                }

                case 5 -> service.sortByName();

                case 6 -> service.sortByAverage();

                case 7 -> System.out.println(" Exiting...!");

                default -> System.out.println(" Invalid choice! Try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}
