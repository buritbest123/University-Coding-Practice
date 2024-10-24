public class ICTStudent extends Customer {

    ICTStudent(CanteenICT _canteen){
        super(_canteen);
        this.eating_time = 0;
        this.requiredDishes.clear();
        this.customerType = CustomerType.STUDENT;
        this.requiredDishes.add(FoodStall.Menu.DESSERT);
        this.requiredDishes.add(FoodStall.Menu.DESSERT);
        this.requiredDishes.add(FoodStall.Menu.DESSERT);
        this.requiredDishes.add(FoodStall.Menu.DESSERT);
        this.requiredDishes.add(FoodStall.Menu.DESSERT);

        for(FoodStall.Menu dish: this.requiredDishes){
            eating_time += FoodStall.EAT_TIME[dish.ordinal()]; //get eat time of the dish
        }
    }
}