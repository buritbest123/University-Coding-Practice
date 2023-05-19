package itcs209.labs.lab4;

public class Tutle {
    private String name;
    private String breed;
    private double weight;
    private double age;

    public  Tutle(String name,String breed,double weight,int age){ //contsuct
            this.name = name;
            this.breed = breed;
            this.weight = weight;
            this.age = age;
    }
    public Tutle(){
        this.name = "Untitled";
        this.breed = "Tutle";
        this.weight = 15;
        this.age = 30;
    }

    public String getFirstName() {
        return this.name;
    }
    public String getType(){
         return this.breed;
    }
    public double getWeight(){
        return this.weight;
    }
    public double getAge(){
        return this.age;
    }
    public String explain(){
         return this.name+" "+"("+this.breed+")";
    }
    public void setFirstName(String name){
         this.name = name;
    }
    public void  setWeight(double weight){
         this.weight=weight;
    }
    public void setAge( double age){
         this.age = age;
    }

}

