package StudentRecordSystem;
import java.util.*;

class StudentService {
    private final ArrayList<Student> students = new ArrayList<>();

    // Add student
    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully!");
    }

    // View all students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println(" No records found!");
            return;
        }

        System.out.println("\n--- Student Records ---");
        System.out.printf("%-10s %-20s %-15s %-15s %-15s %-10s %-10s%n",
                "ID", "Name", "Java", "Python", "SQL", "Total", "Average");
        System.out.println("-------------------------------------------------------------------------------");
        for (Student s : students) {
            var m = s.getSubjectMarks();
            System.out.printf("%-10d %-20s %-15.2f %-15.2f %-15.2f %-10.2f %-10.2f%n",
                    s.getId(), s.getName(),
                    m.get("Java"), m.get("Python"), m.get("SQL"),
                    s.getTotalMarks(), s.getAverage());
        }
    }

    // Update student
    public void updateStudent(int id, HashMap<String, Double> newMarks, String newName) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(newName);
                s.setSubjectMarks(newMarks);
                System.out.println("Record updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Delete student
    public void deleteStudent(int id) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                System.out.println("Record deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Sort students
    public void sortByName() {
        students.sort(Comparator.comparing(Student::getName));
        System.out.println("Records sorted by name!");
    }

    public void sortByAverage() {
        students.sort(Comparator.comparingDouble(Student::getAverage).reversed());
        System.out.println("Records sorted by average marks!");
    }
}
