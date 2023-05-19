public class Node234 {
    private static final int ORDER = 4;
    private int numItems;
    private Node234 parent;
    private Node234 childArray[] = new Node234[ORDER];

    // the four cells long and holds references to whatever children
    //the node might have
    private DataItem itemArray[] = new DataItem[ORDER-1];
    //--------------------------
    //Connect child to this node
    public void connectChild(int childNum, Node234 child){
        childArray[childNum] = child;
        if(child != null) child.parent=this;
    }

    //----------
    //disconnecting child from this node, return it
    public Node234 disconnectChild(int childNum){
        Node234 tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }
    //
    public Node234 getChild(int childNum){
        return childArray[childNum];
    }

    public Node234 getParent(){
        return parent;
    }

    public boolean isLeaf(){
        return (childArray[0]==null ? true:false);
    }

    public int getNumItems(){
        return numItems;
    }

    public DataItem getItem(int index){
        return itemArray[index];
    }

    public boolean isFull(){
        return (numItems==ORDER-1);
    }

    public int findItem(long key){
        for(int j = 0 ; j < ORDER-1; j++){
            if(itemArray[j] == null) break;
            else if(itemArray[j].admin3Pcode == key)
                return j;
        }
        return -1;
    }

    public int insertItem(DataItem newItem){
        numItems++;
        long newKey = newItem.admin3Pcode;
        for(int j = ORDER-2; j>=0;j--){
            if(itemArray[j] == null) continue;
            else{
                long itsKey = itemArray[j].admin3Pcode;
                if(newKey < itsKey) itemArray[j+1] = itemArray[j];
                else{
                    itemArray[j+1] = newItem;
                    return j+1;
                }
            }
        }
        itemArray[0] = newItem;
        return 0;
    }

    public DataItem removeItem(){
        DataItem temp = itemArray[numItems-1];
        itemArray[numItems-1] = null;
        numItems--;
        return temp;
    }

    public void displayNode(){ //format /24/56/74/
        for(int j = 0 ; j < numItems; j++){
            itemArray[j].displayItem();
        }
        System.out.println("/");
    }
}
