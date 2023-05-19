#include <stdio.h>

int height;
int main()
{
 // check number ต้องมากกว่า 0 และ เลขคี่
    do
    {
        scanf("%d", &height);
    } while (!(height > 0 && height % 2 == 1));
 // นำ Control variables มาใช้เป็นตัวแปร อ้างอิงจากบรรทัดที่ 15 
    for (int i = 0; i <= height; i++)
    {
        int j;
        for (j = 0; j < height - i; j++)
        {
            printf("-");
        }
// ใช้ multiple inner loop ส่วนที่นำมาเติมเต็ม
       for (int k = 0; k < i; k++)
        {
            if(i%2==0){
              printf("*");
            }else{
              printf("+");
            }
        }
        printf("\n");
    }
    return 0;
}