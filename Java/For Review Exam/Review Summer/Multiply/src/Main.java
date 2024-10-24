import java.util.Scanner;
import java.math.BigInteger;

/*
[Multiply]
ก ำหนดให้ X และ Y เป็นจ ำนวนเต็มบวก โดยมีควำมยำวสูงสุด 200 หลัก โดยที่ควำมยำวของ X และ Y อำจ
แตกต่ำงกัน จงเขียนโปรแกรมเพื่อแสดงผลลัพธ์ของกำรคูณ X และ Y
ข้อมูลน ำเข้ำ
บรรทัดที่ 1 จ ำนวนเต็มบวก X โดยที่ X = { xi | 0 <= xi <= 9, 1<= i <= 200}
บรรทัดที่ 2 จ ำนวนเต็มบวก Y โดยที่ Y = { yj | 0 <= yj <= 9, 1<= j <= 200}
 */

public class Main {
    public static void main(String[] args) {
        //[Multiply]
        BigInteger multi;
        Scanner input = new Scanner(System.in);
        String strX;
        String strY;
        strX = input.nextLine();
        strY = input.nextLine();
        if ((strX.length() >= 0 && strX.length() <= 200) || (strY.length() >= 0 && strY.length() <= 200)) {
            BigInteger a = new BigInteger(strX);
            BigInteger b = new BigInteger(strY);
            multi = a.multiply(b);
            System.out.println(multi);
        } else {
            System.out.println("What are you doing?");
        }
    }
}