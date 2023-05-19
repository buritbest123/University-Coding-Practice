public class Tree234 {

    private Node234 root = new Node234();

    public int find(long key){
        Node234 curNode = root;
        int childNumber;
        while(true){
            if((childNumber = curNode.findItem(key)) != -1)
                return childNumber;
            else if(curNode.isLeaf())
                return -1;
            else
                curNode = getNextChild(curNode, key);
        }
    }

    public Node234 getNextChild(Node234 theNode, long theValue){
        int j;
        int numItems = theNode.getNumItems();
        for(j = 0 ; j < numItems; j++){
            if(theValue < theNode.getItem(j).admin3Pcode)
                return theNode.getChild(j);
        }
        return theNode.getChild(j);
    }

    public void insert(String a, long admin3Pcode, String b, String c, String d, String e, String f, String g, double l, double ar){
        Node234 curNode = root;
        DataItem tempItem = new DataItem(a,admin3Pcode,b,c,d,e,f,g,l,ar);
        while(true){
            if(curNode.isFull()){
                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextChild(curNode, admin3Pcode);
            } //end if
            else if(curNode.isLeaf()) break;
            else curNode = getNextChild(curNode, admin3Pcode);
        }
        curNode.insertItem(tempItem);
    }

    public void split(Node234 thisNode){
        DataItem itemB, itemC;
        Node234 parent, child2, child3;
        int itemIndex;
        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();

        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);
        Node234 newRight = new Node234();
        if(thisNode == root){
            root = new Node234();
            parent = root;
            root.connectChild(0, thisNode);
        }
        else parent = thisNode.getParent();
        itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();
        for(int j = n - 1; j > itemIndex; j--){
            Node234 temp = parent.disconnectChild(j);
            parent.connectChild(j+1, temp);
        }
        parent.connectChild(itemIndex+1, newRight);
        newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
    }

    public void displayTree(){
        recDisplayTree(root, 0,0);
    }

    public void recDisplayTree(Node234 thisNode, int level, int childNumber){
        System.out.print("level="+level+" child="+childNumber+" ");
        thisNode.displayNode();

        int numItems = thisNode.getNumItems();
        for(int j =0 ; j < numItems+1; j++){
            Node234 nextNode = thisNode.getChild(j);
            if(nextNode != null){
                recDisplayTree(nextNode, level+1, j);
            }
            else{
                return;
            }
        }
    }
}
