import java.security.Key;

public class HashDoubleTable {
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem; // for deleted items

    HashDoubleTable(int size){
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem("",-1, "", "","","","","", 0,0);
    }

    public void displayTable(){
        System.out.print("Table: ");
        for(int i = 0; i < arraySize; i++){
            if(hashArray[i] != null){
                System.out.print("[" + i + "]" + hashArray[i].getKey() + " ");
            }
            else{
                System.out.print("[" + i + "]" + "** ");
            }
        }
        System.out.println();
    }

    public int hashFunc1(int key){
        return key % arraySize;
    }

    public int hashFunc2(int key){
        return 5 - key % 5;
    }

    public void insert(int key, DataItem item){
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);

        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public DataItem delete(int key){
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        while(hashArray[hashVal] != null){
            if(hashArray[hashVal].getKey()==key){
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem find(int key){
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        while(hashArray[hashVal] != null){
            if(hashArray[hashVal].getKey()==key){
                return hashArray[hashVal];
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }
}
