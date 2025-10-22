package StudentRecordSystem;
import java.util.HashMap;

class Student {
    private int id;
    private String name;
    private HashMap<String, Double> subjectMarks;

    public Student(int id, String name, HashMap<String, Double> subjectMarks) {
        this.id = id;
        this.name = name;
        this.subjectMarks = subjectMarks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Double> getSubjectMarks() {
        return subjectMarks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubjectMarks(HashMap<String, Double> subjectMarks) {
        this.subjectMarks = subjectMarks;
    }

    public double getTotalMarks() {
        double total = 0;
        for (double m : subjectMarks.values()) total += m;
        return total;
    }

    public double getAverage() {
        return getTotalMarks() / subjectMarks.size();
    }

    @Override
    public String toString() {
        return String.format("%-10d %-20s %-10.2f", id, name, getAverage());
    }
}
