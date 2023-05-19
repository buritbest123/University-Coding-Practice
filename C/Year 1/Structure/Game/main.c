#include <stdio.h>
#include <string.h>
#define MAXLEN 21
struct Monster{
  char name[MAXLEN];
  char elem;
  float hp;
  int spd;
  float atk;
  float def;
};
struct Tamer{
  char name[MAXLEN];
  int age;
  struct Monster partner;
  int wr;
  int lr;
};
void getFactor(char a, char b, float* f1, float* f2){
  *f1 = 1.0;
  *f2 = 1.0;
  if((a == 'P' && b == 'W') || (a == 'W' && b == 'F') || (a== 'F' && b == 'P')){
    *f1 = 2.0;
    *f2 = 0.5;
  }
  else if((b == 'P' && a == 'W') || (b == 'W' && a == 'F') || (b== 'F' && a == 'P')){
    *f1 = 0.5;
    *f2 = 2.0;
  } 
}
//m1 -> attacker , m2 -> defender 
float atkaction(struct Monster m1, struct Monster m2,float f, int turn){
  float oHP = m2.hp;
  float atk = (m1.atk * f) - m2.def;
  if(atk < 0) atk = 0; //cap attack
  
  m2.hp = m2.hp - atk;
  //cap hp
  if(m2.hp < 0) m2.hp = 0;
  
  printf("Turn %d: %s causes %.2f the damage to %s, HP of %s drops from %.2f to %.2f\n", turn, m1.name, atk, m2.name, m2.name, oHP, m2.hp);
  return m2.hp;
  
}
int fightLog(struct Tamer t1, struct Tamer t2,int maxturn){
  
  struct Monster a1, a2;
  int turn = 1, oria,orib; // the original position of the Tamer (as we need to set the later fight based on the speed)
 
 //choose the first fighter > announce that
 //can reduce the redundancy of assigning
  if(t1.partner.spd >= t2.partner.spd){
    a1 = t1.partner;
    a2 = t2.partner;
    oria = 1;
    orib = 2;
    printf("The first start is %s's %s \n",t1.name,a1.name);
  }
  else{
    a1 = t2.partner;
    a2 = t1.partner;
    oria = 2;
    orib = 1;
    printf("The first start is %s's %s \n",t2.name,a1.name);
  }
  float f1,f2; //record the factor
  getFactor(a1.elem,a2.elem,&f1,&f2);
  while((a1.hp > 0 && a2.hp > 0) && turn <= maxturn){
    //odd trun, first monster goes
    //can also use the fix attack (as it won't change the value; no need to recalc. like this all the time)
    if(turn%2 == 1){
      a2.hp = atkaction(a1,a2,f1,turn);
    }
    else{
      a1.hp = atkaction(a2,a1,f2,turn);
    } 
    turn++;
  }
  //at the end
  if(a1.hp > a2.hp) // a1 wins
    return oria; 
  else
    return orib;
}
void printstruct(struct Tamer t){
  printf("The winner is %s (%d) using %s (win: %d lose: %d)",t.name,t.age,t.partner.name,t.wr,t.lr);
}
int main(void) 
{
  int n,t1,t2,maxturn;
  scanf("%d",&n);
  struct Tamer tlist[n];
  
  //scan info
  //can also create a function for scanning struct
  for(int i=0;i<n;i++){
    scanf("%s ",tlist[i].name);
    scanf("%d ",&tlist[i].age);
    scanf("%d ",&tlist[i].wr);
    scanf("%d ",&tlist[i].lr);
    scanf("%s ",tlist[i].partner.name);
    scanf("%c ",&tlist[i].partner.elem);
    scanf("%f ",&tlist[i].partner.hp);
    scanf("%d ",&tlist[i].partner.spd);
    scanf("%f ",&tlist[i].partner.atk);
    scanf("%f ",&tlist[i].partner.def);
  }
  //when to end
  scanf("%d",&maxturn);
  //two tamer to fight
  scanf("%d %d", &t1,&t2);
  //Fight
  int result = fightLog(tlist[t1],tlist[t2],maxturn);
  //update win rate
  //the best is to update the lose rate of the opponent too, but this hasn't been asked in the instruction
  if(result == 1){
    tlist[t1].wr = tlist[t1].wr + 1;
    printstruct(tlist[t1]);
  } 
  else{
    tlist[t2].wr = tlist[t2].wr + 1;
    printstruct(tlist[t2]);
  }
  return 0;
}