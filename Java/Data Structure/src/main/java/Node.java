public class Node {

    int admin3Pcode;
    String admin3Name_en, admin2Name_en, admin2Pcode, admin1Name_en, admin1Pcode, admin0Name_en, admin0Pcode;
    double Shape_Length, Shape_Area;

    Node leftChild, rightChild;

    Node(int admin3Pcode, String admin3Name_en , String admin2Name_en, String admin2Pcode, String admin1Name_en, String admin1Pcode, String admin0Name_en, String admin0Pcode, double shapeLength, double shapeArea){
        this.admin3Name_en =    admin3Name_en;
        this.admin3Pcode =      admin3Pcode;
        this.admin2Name_en =    admin2Name_en;
        this.admin2Pcode =      admin2Pcode;
        this.admin1Name_en =    admin1Name_en;
        this.admin1Pcode =      admin1Pcode;
        this.admin0Name_en =    admin0Name_en;
        this.admin0Pcode =      admin0Pcode;
        this.Shape_Length =      shapeLength;
        this.Shape_Area =        shapeArea;
    }

    public void displayNode(){
        System.out.print('{');
        System.out.print(admin3Name_en);
        System.out.print(", ");
        System.out.print("TH"+admin3Pcode);
        System.out.println("} ");
    }
}
