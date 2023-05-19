#include <stdio.h>  
#include <stdlib.h>  

struct node   // typedef struct named 'node'
{  
  int data;  // same as value
  struct node *next; // keep pointer type struct node named '*next'
};  
struct node *HEAD;  
 
void insert_at_begin();   
void insert_at_last();  
void delete_at_begin();  
void delete_at_last();  
void print();  
void getting();  
void editing();

void main()  
{  
  int input = 0;  
  while(input != 8)   
  {
      printf("\n**************************************\n");
      printf("\n\nPerforming operations on Singly Linked List!\n\n");
      printf("Choose an option from the below list!\n");  
      printf("\n**************************************\n");  
      printf("1.Do insertion at beginning of the list!\n2.Do insertion at last of the list!\n3.Do deletion from the beginning of the list!\n4.Do deletion at the last of the list!\n5.Perform a getting operation for an element!\n6.Perform an editing operation for an element!\n7.Display!\n8.Exit!\n");  
      printf("\nEnter your choice?\n");       
      scanf("\n%d", &input);  
      switch(input)  
      {  
          case 1:  
          insert_at_begin();    
          break;  
          case 2:  
          insert_at_last();       
          break;   
          case 3:  
          delete_at_begin();     
          break;  
          case 4:  
          delete_at_last();      
          break;  
          case 5:  
          getting();       
          break;  
          case 6:  
          editing();
          break;  
          case 7: 
          print();  
          break;  
          case 8:
          exit(0);
          break;  
          default:  
          printf("Please enter a choice from the following list!");  
      }  
  }  
}  
void insert_at_begin()  
{  
  struct node *point;  
  int value;  
  point = (struct node *) malloc(sizeof(struct node *));  
  if (point == NULL)  
  {  
      printf("\nInvalid!!");  
  }  
  else  
  {  
      printf("\nEnter the value: \n");    
      scanf("%d",&value);    
      point->data = value;  
      point->next = HEAD;  
      HEAD = point;  
      printf("\nNice, The Node is inserted at the beginning!");  
  }  
    
}  
void insert_at_last()  
{  
  struct node *point,*tmp;  
  int value;   
  point = (struct node*)malloc(sizeof(struct node));    
  if (point == NULL)  
  {  
      printf("\nInvalid!!");   
  }  
  else  
  {  
      printf("\nEnter the value: \n");  
      scanf("%d",&value);  
      point->data = value;  
      if (HEAD == NULL)  
      {  
          point -> next = NULL;  
          HEAD = point;  
          printf("\nNice, The Node is inserted!");  
      }  
      else  
      {  
          tmp = HEAD;  
          while (tmp -> next != NULL)  
          {  
              tmp = tmp -> next;  
          }  
          tmp->next = point;  
          point->next = NULL;  
          printf("\nNice, The Node is inserted!");  
        
      }  
  }  
}  
void delete_at_begin()  
{  
  struct node *point;  
  if (HEAD == NULL)  
  {  
      printf("\nThe List is empty!\n");  
  }  
  else   
  {  
      point = HEAD;  
      HEAD = point->next;  
      free(point);  
      printf("\nThe node is deleted from the beginning!\n");  
  }  
}  
void delete_at_last()  
{  
  struct node *point,*point1;  
  if (HEAD == NULL)  
  {  
      printf("\nThe List is empty!");  
  }  
  else if (HEAD -> next == NULL)  
  {  
      HEAD = NULL;  
      free(HEAD);  
      printf("\nOne node is deleted from the list!\n");  
  }  
  else  
  {  
      point = HEAD;   
      while (point->next != NULL)  
      {  
          point1 = point;  
          point = point ->next;  
      }  
      point1->next = NULL;  
      free(point);  
      printf("\nThe Node is deleted from the last of the node!\n");  
  }   
}  
void getting()  
{  
  struct node *point;  
  int value, a = 0, check1 = 0;  
  point = HEAD;   
  if (point == NULL)  
  {  
      printf("\nSorry, but the list is empty!\n");  
  }  
  else  
  {   
      printf("\nEnter the value which you want to get: \n");   
      scanf("%d", &value);  
      while (point != NULL)  
      {  
          if (point->data == value)  
          {  
              printf("The value which you getted for, get index at: %d\n", a+1);  
              check1 = 0;  
              break; 
          }   
          else  
          {  
              check1 = 1;  
          }  
          a++;  
          point = point -> next;  
      }  
  if (check1 == 1)  
  {  
      printf("Sorry, the value is not found!\n");  
  }  
  }   
}  

void editing()
{
  struct node *point;  
  int value, a = 0, check2 = 0;  
  point = HEAD;   
  if (point == NULL)  
  {  
      printf("\nSorry, but the list is empty!\n");  
  }  
  else  
  {   
      printf("\nEnter the value which you want to edit: \n");   
      scanf("%d", &value);  
      while (point != NULL)  
      {  
          if (point->data == value)  
          {  
              printf("Edit to: "); 
              scanf("%d", &point->data); 
              printf("Edit Complete!!!\n"); 
              break;
          }   
          else  
          {  
              check2 = 1;  
          }  
          a++;  
          point = point -> next;  
      }  
  if (check2 == 1)  
  {  
      printf("Sorry, the value is not found!\n");  
  }  
  }    
}

void print()  
{  
  struct node *point;  
  point = HEAD;   
  if (point == NULL)  
  {  
      printf("Please enter something to print!");  
  }  
  else  
  {  
      printf("\nPrinting the values!\n");   
      while (point != NULL)  
      {  
          printf("\n%d",point->data);  
          point = point -> next;  
      }  
  }
}