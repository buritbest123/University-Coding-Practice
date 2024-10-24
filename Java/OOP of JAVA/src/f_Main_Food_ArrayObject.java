public class f_Main_Food_ArrayObject {

    public static void main(String[] args) {

        f_Food[] refrigerator = new f_Food[3];

        f_Food food1 = new f_Food("pizza");
        f_Food food2 = new f_Food("hamburger");
        f_Food food3 = new f_Food("hotdog");

        // Food[] refrigerator = {food1,food2,food3}; // declare and assign name of the data type
                                                      // followed by a name refrigerator

        refrigerator[0] = food1;
        refrigerator[1] = food2;
        refrigerator[2] = food3;

        System.out.println(refrigerator[0].name);
        System.out.println(refrigerator[1].name);
        System.out.println(refrigerator[2].name);

    }
}