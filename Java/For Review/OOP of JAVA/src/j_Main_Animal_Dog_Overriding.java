public class j_Main_Animal_Dog_Overriding {

    public static void main(String[] args) {

        // method overriding = 	Declaring a method in sub class,
        //						which is already present in parent class.
        //						done so that a child class can give its own implementation

        j_Animal animal = new j_Animal();
        j_Dog dog = new j_Dog();

        dog.speak();

    }
}