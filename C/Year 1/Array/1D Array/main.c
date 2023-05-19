#include<stdio.h>
int main(){
// array สามารถใช้ได้ทั้ง int float char
/* Tips and Tricks เราสามารถเขียน int grades[5] = {98, 87, 92, 79, 85};
                                char letter_grade[5] = {'A','B','C','D','E'}*/
// *อย่าลืมว่า index ต้องเริ่มด้วย 0 เสมอ //
/* int grades[5];
= grade[0], grade[1], grade[2], grade[3], grade[4];

char letter_grade[5]
= letter_grade[0], letter_grade[1], letter_grade[2], letter_grade[3], letter_grade[4];

float decimal[5]
= decimal[0], decimal[1], decimal[2], decimal[3], decimal[4];*/

// 3 Possible How To Use An Array

// Know the size of the array.
/*
  #define N 5
  int grades[N];

  int n=5;
  int grades[n];*/

// Not know the size of the array
  /*
  int n;
  scanf("%d", &n);
  int grades[n];*/

// การใช้ element ข้างใน *อย่าลืมว่า index ต้องเริ่มด้วย 0 เสมอ

/*  เริ่มด้วยการกำหนด มี อยู่ 3 รูปแบบ int n = 3, Total=0;
int grades[n];

grades[0]=98;
grades[1]=grades[0]-11;
grades[2]=2*(grades[0]-6);
Total = grades[0] + grades[1] + grades[2];

printf("%d %d %d %d", grades[0], grades[1], grades[2], Total);*/
// OUTPUT is 98, 87, 184, 369

/* Loop Statement with Array */
// เราสามารถใช้ loop ในการช่วยกำหนดค่า int ได้ 
/* และสามารถนำมาประยุกต์กับการกำหนดค่า การให้ user กำหนดขนาด size และ กำหนด size ของแต้ละค่าได้อีกเช่นกัน */

/* เช่น ในที่นี้ กำหนดค่า int ชื่อ "zeros" ขนาด size 10 
และใช้ for loop ในการช่วยกำหนดค่า โดยกำหนดค่าเป็น 0 
  int zeros[10];
  for (int i=0; i<10; i++){
    zeros[i]=0;
    printf("%d ", zeros[i]);
  }*/

int arr[5] = {2, 4, 6, 0, 1};
int sum = 0, product = 1.0;
  for (int i=0;i<5;i++){
    printf("%d %d ", i, arr[i]);
  }
  return 0;
}
