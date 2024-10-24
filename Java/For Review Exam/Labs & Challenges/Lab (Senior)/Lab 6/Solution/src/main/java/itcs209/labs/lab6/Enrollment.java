package itcs209.labs.lab6;

public class Enrollment {
    private String names;
    private String IDs;
    private double scores;
    private String grades;

    public Enrollment(String names, String IDs, double scores, String grades) {
        this.names = names;
        this.IDs = IDs;
        this.scores = scores;
        this.grades = grades;
    }

    public String getSubjectTitle() {


        return this.names;
    }

    public String getCourseID() {

        return this.IDs;
    }

    public double getScore() {

        return this.scores;
    }

    public String getLetterGrade() {

        return this.grades;
    }
}