public class Tree {
    private Node root;

    public void insert(int id, String dd, String a, String b, String c, String d, String e, String f, double l, double area){
        Node newNode = new Node(id, dd, a,b,c,d,e,f,l,area);
        if(root == null){
            root = newNode;
        }
        else{
            Node current = root;
            Node parent;
            while(true){
                parent = current;
                if(id < current.admin3Pcode){
                    current = current.leftChild;
                    if(current == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else{
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                } //end else go right
            }//end while
        }
    }// end insert

    public Node getRoot(){return root;}

    public void inOrder(Node localRoot){
        if(localRoot != null){
            inOrder(localRoot.leftChild);
            System.out.print("TH" + localRoot.admin3Pcode + " ");

            inOrder(localRoot.rightChild);
        }
    }

    public void preOrder(Node localRoot){
        if(localRoot != null){
            System.out.print(localRoot.admin3Name_en + " ");
            System.out.print("TH" + localRoot.admin3Pcode + " ");
            System.out.print(localRoot.admin2Name_en + " ");
            System.out.print(localRoot.admin2Pcode + " ");
            System.out.print(localRoot.admin1Name_en + " ");
            System.out.print(localRoot.admin1Pcode + " ");
            System.out.print(localRoot.admin0Name_en + " ");
            System.out.print(localRoot.admin0Pcode + " ");
            System.out.print(localRoot.Shape_Length + " ");
            System.out.println(localRoot.Shape_Area);
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    public void postOrder(Node localRoot){
        if(localRoot != null){
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.admin3Name_en + " ");
            System.out.print("TH" + localRoot.admin3Pcode + " ");
            System.out.print(localRoot.admin2Name_en + " ");
            System.out.print(localRoot.admin2Pcode + " ");
            System.out.print(localRoot.admin1Name_en + " ");
            System.out.print(localRoot.admin1Pcode + " ");
            System.out.print(localRoot.admin0Name_en + " ");
            System.out.print(localRoot.admin0Pcode + " ");
            System.out.print(localRoot.Shape_Length + " ");
            System.out.println(localRoot.Shape_Area);
        }
    }

    public Node find(int key){
        Node current = root;
        while(current.admin3Pcode != key){
            if(key < current.admin3Pcode){
                current = current.leftChild;
            }
            else{
                current = current.rightChild;
            }
            if(current == null) return null;
        }// end while
        return current;
    } //end find

    public Node minimum(){
        Node current, last;
        current = root;
        last = null;
        while(current != null){
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public boolean delete(int key){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while(current.admin3Pcode != key){
            parent = current;
            if(key < current.admin3Pcode){
                isLeftChild = true;
                current = current.leftChild;
            }else{
                isLeftChild = false;
                current = current.rightChild;
            }
            if(current == null) return false;
        }// end while
        // CASE 1: The node to delete has no children
        //simply delete it
        if(current.leftChild == null && current.rightChild == null){
            if(current==root) root = null;
            else if(isLeftChild) parent.leftChild = null;
            else parent.rightChild = null;
        }
        //CASE 2: one child
        else if(current.rightChild == null)
            if(current == root) root = current.leftChild;
            else if(isLeftChild) parent.leftChild = current.leftChild;
            else parent.rightChild = current.leftChild;
        else if(current.leftChild == null)
            if(current == root) root  = current.rightChild;
            else if(isLeftChild) parent.leftChild = current.rightChild;
            else parent.rightChild = current.rightChild;
        //CASE 3: 2 CHILDREN
        else{
            Node successor = getSuccessor(current);
            if(current == root) root = successor;
            else if(isLeftChild) parent.leftChild = successor;
            else parent.rightChild = successor;

            successor.leftChild = current.leftChild;
        }// end else 2 children
        return true;
    }// end delete

    private Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if(successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }
}
