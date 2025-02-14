public class n_Arrays {

    public static void main(String[] args) {

        // array = used to store multiple values within a single variable

        //Syntax How to write an Array
        //Datatype[] any_name = new DataType[size]
        String[] cars = new String[3];
        // another String[] cars = {"Camaro", "Corvette", "Tesla"};

        cars[0] = "Camaro";
        cars[1] = "Corvette";
        cars[2] = "Tesla";

        for(int i=0; i<cars.length; i++) {
            System.out.println(cars[i]);
        }

        String[] company = new String[3];

        company[0] = "apple";
        company[1] = "samsung";
        company[2] = "Huawei";

        for (int i = 0; i < company.length; i++) {
            System.out.println(company[i]);
        }
    }
}