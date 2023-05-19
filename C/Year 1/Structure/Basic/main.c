#include <stdio.h>
struct Item{
  char item_name[50+1];
  int quantity;
  float price;
  char is_taxed;
};
struct Order{
  int order_id;
  char customer_name[50+1];
  struct Item items[3];
  float total;
  float vat_refund;
};
int main(){
  int amount;
    scanf("%d", &amount);
  struct Order goods[amount];
  for(int i=0;i<amount;i++){
    scanf("%d %s %s %d %f %c %f %f", &goods[i].order_id, goods[i].customer_name, goods[i].items[i].item_name, &goods[i].items[i].quantity, &goods[i].items[i].price, &goods[i].items[i].is_taxed, &goods[i].total, &goods[i].vat_refund);
    }

  for(int i=0;i<amount;i++){
    printf("Order_id: %d\nName: %s\nitem name: %s\nquantity:%d\nPrice: %.2f\nTaxed: %c\nTotal: %.2f\nvat_refund: %.2f\n", goods[i].order_id, goods[i].customer_name, goods[i].items[i].item_name, goods[i].items[i].quantity, goods[i].items[i].price, goods[i].items[i].is_taxed, goods[i].total, goods[i].vat_refund);
  }
  
  return 0;
}