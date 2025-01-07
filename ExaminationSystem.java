import java.util.ArrayList;
import java.util.Scanner;

public class ExaminationSystem {
    private final ArrayList<Student> students;
    private final ArrayList<Question> questions;

    public ExaminationSystem() {
        students = new ArrayList<>();
        questions = new ArrayList<>();

        // Sample questions
        questions.add(new Question("What is the capital of France?", "a) Berlin", "b) Madrid", "c) Paris", "d) Rome", 'c'));
        questions.add(new Question("Which language is used for web development?", "a) Python", "b) JavaScript", "c) C++", "d) Java", 'b'));
        questions.add(new Question("Who is the founder of Microsoft?", "a) Steve Jobs", "b) Bill Gates", "c) Elon Musk", "d) Mark Zuckerberg", 'b'));
    }

    public void registerStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        students.add(new Student(name));
        System.out.println("Student registered successfully!");
    }

    public void startExam() {
        if (students.isEmpty()) {
            System.out.println("No students registered. Please register a student first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        Student student = students.stream().filter(s -> s.getName().equalsIgnoreCase(name)).findFirst().orElse(null);

        if (student == null) {
            System.out.println("Student not found. Please register first.");
            return;
        }

        int score = 0;
        for (Question question : questions) {
            System.out.println("\n" + question.getQuestion());
            System.out.println(question.getOptionA());
            System.out.println(question.getOptionB());
            System.out.println(question.getOptionC());
            System.out.println(question.getOptionD());
            System.out.print("Enter your answer: ");
            char answer = scanner.next().charAt(0);

            if (answer == question.getCorrectAnswer()) {
                score++;
            }
        }

        System.out.println("\nExam finished!");
        System.out.println("Student: " + student.getName());
        System.out.println("Score: " + score + "/" + questions.size());
    }
}
