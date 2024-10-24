/**
 * Author: 6488057
 */

package itcs209.labs.lab4;

public class ExampleClass {

    //region Instance Variables
    private int instanceVar1;
    private String instanceVar2;
    //endregion


    //region Constructors
    public ExampleClass(int instanceVar1, String instanceVar2) {
        this.instanceVar1 = instanceVar1;
        this.instanceVar2 = instanceVar2;
    }

    public ExampleClass() {
        this(0, "");
    }
    //endregion



    //region Accessors
    public int getInstanceVar1() {
        return this.instanceVar1;
    }

    public String getInstanceVar2() {
        return this.instanceVar2;
    }

    public String describe(String msg) {
        return msg + ": " + this.instanceVar2 + ", " + this.instanceVar1;
    }
    //endregion


    //region Mutator
    public void setInstanceVar1(int instanceVar1) {
        this.instanceVar1 = instanceVar1;
    }

    public void setInstanceVar2(String instanceVar2) {
        this.instanceVar2 = instanceVar2;
    }

    public void reset() {
        this.instanceVar1 = 0;
        this.instanceVar2 = "";
    }
    //endregion
}
