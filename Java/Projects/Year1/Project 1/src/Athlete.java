public class Athlete extends Customer {

    Athlete(CanteenICT _canteen){
        super(_canteen);
        this.eating_time = 0;
        this.requiredDishes.clear();
        this.customerType = CustomerType.ATHLETE;
        this.requiredDishes.add(FoodStall.Menu.MEAT);
        this.requiredDishes.add(FoodStall.Menu.MEAT);
        this.requiredDishes.add(FoodStall.Menu.MEAT);
        this.requiredDishes.add(FoodStall.Menu.SALAD);
        this.requiredDishes.add(FoodStall.Menu.BEVERAGE);

        for(FoodStall.Menu dish: this.requiredDishes){
            eating_time += FoodStall.EAT_TIME[dish.ordinal()]; //get eat time of the dish
        }
    }
}