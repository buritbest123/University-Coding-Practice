class Rabbit extends Animal{

  // instance variable
  String favFood = "";
  
  public Rabbit(int age, String color, String food){
    super(age, color);
    this.favFood = food; 
  }

  public void printFavFood(){
    System.out.println(favFood);
  }

  public String toString(){
    return super.toString() + ", favFood:" + favFood;
  }

  @Override
  public void speak(){
    System.out.println("~~~~");
  }
}