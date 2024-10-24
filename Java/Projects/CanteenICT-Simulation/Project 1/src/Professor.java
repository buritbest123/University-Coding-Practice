public class Professor extends Customer {

    Professor(CanteenICT _canteen){
        super(_canteen);
        this.eating_time = 0;
        this.requiredDishes.clear();
        this.customerType = CustomerType.PROFESSOR;
        this.requiredDishes.add(FoodStall.Menu.NOODLES);
        this.requiredDishes.add(FoodStall.Menu.BEVERAGE);

        for(FoodStall.Menu dish: this.requiredDishes){
            eating_time += FoodStall.EAT_TIME[dish.ordinal()]; //get eat time of the dish
        }
    }
}