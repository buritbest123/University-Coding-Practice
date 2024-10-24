import java.util.ArrayList;

public class ToH3<T> extends ArrayList<T> {

    public static void ToH3() {
        int steps = 0;
        Stack<Integer> s1 = new Stack<Integer>(3);
        Stack<Integer> s2 = new Stack<Integer>(3);
        Stack<Integer> s3 = new Stack<Integer>(3);
        System.out.println("Steps "+steps+"\n"+"-------"); // Steps 0
        s1.push(3);
        s1.push(2);
        s1.push(1);
        System.out.println(" S1\n"+s1+"===");
        System.out.println(" S2\n"+"===");
        System.out.println(" S3\n"+"===");
        steps++;

        System.out.println("Steps "+steps+"\n"+"-------"); // Steps 1
        s1.pop();
        s3.push(1);
        System.out.println(" S1\n"+s1+"===");
        System.out.println(" S2\n"+"===");
        System.out.println(" S3\n"+s3+"===");
        steps++;

        System.out.println("Steps "+steps+"\n"+"-------"); // Steps 2
        s1.pop();
        s2.push(2);
        print_ToH3(s1,s2,s3);
        steps++;

        System.out.println("Steps "+steps+"\n"+"-------"); // Steps 3
        s3.pop();
        s2.push(1);
        print_ToH3(s1,s2,s3);
        steps++;

        System.out.println("Steps "+steps+"\n"+"-------"); // Steps 4
        s1.pop();
        s3.push(3);
        print_ToH3(s1,s2,s3);
        steps++;

        System.out.println("Steps "+steps+"\n"+"-------"); // Steps 5
        s2.pop();
        s1.push(1);
        print_ToH3(s1,s2,s3);
        steps++;

        System.out.println("Steps "+steps+"\n"+"-------"); // Steps 6
        s2.pop();
        s3.push(2);
        print_ToH3(s1,s2,s3);
        steps++;

        System.out.println("Steps "+steps+"\n"+"-------"); // Steps 7
        s1.pop();
        s3.push(1);
        print_ToH3(s1,s2,s3);
        System.out.println(steps);
    }

    private static void print_ToH3(Stack<Integer> s1, Stack<Integer> s2, Stack<Integer> s3) {
        System.out.println(" S1\n"+s1+"===");
        System.out.println(" S2\n"+s2+"===");
        System.out.println(" S3\n"+s3+"===");
    }

    public static void main(String[] args) {
      ToH3();
        System.out.println("I took 7 steps to complete The Tower of Hanoi");
    }
}