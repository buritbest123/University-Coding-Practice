public class b_Human {

    String name;
    int age;
    double weight;

    b_Human(String name, int age, double weight){ // create a constructor it's the same name as the class name

        this.name = name; // same as human1 = name or human2 = name
        this.age = age; // same as human1 = age or human2 = age
        this.weight = weight; // same as human1 = weight or human2 = weight
    }

    void eat() {
        System.out.println(this.name+" is eating"); // access name by use "this.name"
                                                    // same as human1 = name or human2 = name
    }
    void drink() {
        System.out.println(this.name+" is drinking *burp*"); // access name by use "this.name"
                                                             // same as human1 = name or human2
    }

}