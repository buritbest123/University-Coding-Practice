public class HashTable {
    private SortedList[] hashArray;
    private int arraySize;

    public HashTable(int size){
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for(int i = 0 ; i < arraySize; i++)
            hashArray[i] = new SortedList();
    }

    public void displayTable(){
        for(int i = 0 ; i < arraySize; i++){
            System.out.print(i + ". ");
            hashArray[i].displayList();
        }
    }

    public int hashFunc(int key){
        return key % arraySize;
    }

    public void insert(Link theLink){
        int key = theLink.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(theLink);
    }

    public void delete(int key){
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    public Link find(int key){
        int hashVal = hashFunc(key);
        Link theLink = hashArray[hashVal].find(key);
        return theLink;
    }

    public int hashFunc1(String key){
        int hashVal = 0;
        int pow27 = 1;
        for(int i = key.length()-1; i>= 0; i--){
            int letter = key.charAt(i) - 96;
            hashVal += pow27 * letter;
            pow27 *= 27;
        }
        return hashVal%arraySize;
    }

    public int hashFunc2(String key){
        int hashVal = key.charAt(0) - 96;
        for(int i = 1; i < key.length(); i++){
            int letter = key.charAt(i) - 96;
            hashVal = hashVal * 27 + letter;
        }
        return hashVal % arraySize;
    }

}
