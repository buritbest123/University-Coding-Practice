import java.util.ArrayList;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;

class Main {
  public static void main(String[] args) {
    
    Dog myDog = new Dog(12, "black"); // First Dog named "myDog"
		
    ArrayList<Dog> dogList = new ArrayList<Dog>(); // ArrayList
		dogList.add(myDog);
		dogList.add(new Dog(10, "white")); // Second Dog
    
    HashSet<Dog> dogSet = new HashSet<Dog>(); // HashSet
		dogSet.add(myDog);                        // First Dog named "myDog"
		dogSet.add(new Dog(10, "white")); // Second Dog
    
    HashMap<String, Dog> dogMap = new HashMap<String,Dog>(); // HashMap
		dogMap.put("Foo", myDog);                            // First Dog named "Foo"
		dogMap.put("Bar", new Dog(10, "white"));  // Second Dog named "Bar"

    // check size of collection
    System.out.println("***** SIZE *****");
    System.out.println("List \t" + dogList.size());
    System.out.println("Set \t" + dogSet.size());
    System.out.println("Map \t" + dogMap.size());
    System.out.println("Expect size -> 2");

    // retrieve by index (list) or by key (map)
    System.out.println("\n***** RETRIEVE *****");
		Dog dogIndex = dogList.get(0);              // ArrayList get dog at specific index
    
    Dog dogKey = dogMap.get("Foo");                // HashMap get dog by key "myDog named 'Foo'"
    System.out.println("List index 0\t" + dogIndex);
		System.out.println("Set cannot get by index or key"); // HashSet cannot retrieve by index or key
		System.out.println("Map key 'Foo'\t" + dogKey);
    System.out.println("Expect dog info -> age: 12, color: black");

    // check whether the collection contains a specific dog or not
    System.out.println("\n\n***** CONTAINS *****");
    boolean findMyDogList = dogList.contains(myDog);
    boolean findMyDogSet = dogSet.contains(myDog); 
    boolean findMyDogMap = dogMap.containsKey("Foo");   // contains key by HashMap
    // OR
    //boolean findMyDogMap = dogMap.containsValue(myDog);   // contains value by HashMap
    System.out.println("List contains \t" + findMyDogList);
		System.out.println("Set contains \t" + findMyDogSet);
		System.out.println("Map contains \t" + findMyDogMap);
    System.out.println("Expect contain -> true");
    
    System.out.println("\n\n***** For-Each Loop *****");
    for(Dog dog: dogList){
      System.out.println("List => " + dog);
    }
    for(Dog dog: dogSet){
      System.out.println("Set => " + dog);
    }
    for(String key: dogMap.keySet()){
      System.out.println("Map => key: " + key + ", value " + dogMap.get(key));
    }

    System.out.println("\n\n***** Iterator *****");
    Iterator<Dog> cursorList = dogList.iterator();
    while(cursorList.hasNext()) {
      System.out.println("List => " + cursorList.next());
    }
    Iterator<Dog> cursorSet = dogSet.iterator();
    while(cursorSet.hasNext()) {
      System.out.println("Set => " + cursorSet.next());
    }
    // ERROR
    // Iterator<Dog> cursorSet = dogMap.iterator();
    // while(cursorSet.hasNext()) {
    //      System.out.println("Set => " + cursorSet.next());
    // }

    // For Map, we cannot get value (Dog) directly
    // 1. Getting a Set of key-value pairs
    Set entrySet = dogMap.entrySet();
    // 2. Obtaining an iterator for the entry set (key-value)
    Iterator<Map.Entry<String, Dog>> it = entrySet.iterator();
    while(it.hasNext()) {
      Map.Entry mapElement = it.next(); 
      System.out.println("Map => key: " + mapElement.getKey() + 
                         ", value " + mapElement.getValue());
    }

    System.out.println("\n\n***** forEach() Method *****");
    dogList.forEach(dog -> { 
      System.out.println("List => " + dog); 
    });
    dogSet.forEach(dog -> { 
      System.out.println("Set => " + dog); 
    });
    dogMap.forEach((k, v)-> { 
      System.out.println("key: " + k + ", value " + v);
    });


    System.out.println("\n\n***** Iterator - read & remove *****");
    Iterator<Dog> itList = dogList.iterator();
    while(itList.hasNext()) {
      System.out.println("List => " + itList.next());
      itList.remove();
    }
    Iterator<Dog> itSet = dogSet.iterator();
    while(itSet.hasNext()) {
      System.out.println("Set => " + itSet.next());
      itSet.remove();
    }
    Iterator<Map.Entry<String, Dog>> itMap = entrySet.iterator();
    while(itMap.hasNext()) {
      Map.Entry mapElement = itMap.next(); 
      //System.out.println(mapElement);
      System.out.println("Map => key: " + mapElement.getKey() + 
                         ", value " + mapElement.getValue());
      itMap.remove();
    }
    System.out.println("List \t" + dogList.size());
    System.out.println("Set \t" + dogSet.size());
    System.out.println("Map \t" + dogMap.size());
    System.out.println("Expect size -> 0");
    
  }

  
}