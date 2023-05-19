public class Student implements Measurable {
  // attribute
  double gpa;

  // constructor
  public Student(double gpa){
    this.gpa = gpa;
  }


  // implement getMeasure method from Measurable interface
  public double getMeasure(){
    return gpa;
  }
  
}