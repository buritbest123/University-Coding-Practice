# Let build a Monster battle system!

Write a program to generate a Monster battle system. The rule is the user would give the limited of the max turn and pick up 2 Monser Tamers from the list we have. 

Note: we can assume that the number of selection won't go beyond the number of the Tamer in the list.

Then, you would generate **the turn-based figthing system log** for their battle. The Tamer whose monster's HP reach to zero or use up to the maximum turn with the lower HP will be lost. 

In the end, print the winner details (see more information in the test cases) with the update of the win rate. 

The  following is the list of information you need to keep in the the `Tamer`'s card:

- Name (max length: 20)
- Age
- Win rate
- Lose rate
- A partner `Monster` 

For the `Monster`, we would have:

- Name (max length: 20)
- Element (character 'F' for fire, 'W' for water and 'P' for plant)
- HP (Health Point - can be in the floating point format) 
- Speed 
- Attack 
- Defense

The rules of the battle are as followed:
- This is the turn-based system, so the Monster will take turns attacking eact other
- The fastest (speed) Monster will attack first
- If the speed is equal, the first in the list (based on the user choice) would start the attack first
- The formula of damage from *monster A* (attacker) to *monster B* (defender) is
```
Damage to Monster B = (Attack of Monster A x the element factor) - Defense power of Monster B 
```
- If the Defense is higher than the attack, the attack power becomes 0 and vice versa
- The attack won't reduce the HP more than zero
- The **element factor** is like this: 
  - If you hit the monster that you are weak to, your attack will be reduce to 50% (x0.5). 
  - If you hit the monster you are stronger, your attack would be increased by 200% (x2.0). 
  - Otherwise, the factor will be 1

- The elements system work like: 
  - **Fire**: stonger than *Plant*, weaker than *Water*
  - **Water**: stronger than *Fire*, weaker than *Plant*
  - **Plant**: stronger than *Water*, weaker than *Fire*

For example:
- Monster A: atk 120, def 30
- Monster B: atk 50, def 70

If they are on the same element:
A attack B = (120x1) - 70 = 50

If A is stronger than B:
A attack B = (120x2) - 70 = 170

If A is weaker than B:
A attack B = (120x0.5) - 70 = 0 *(cause 60-70 is negative)*

- Once **the monster's HP reaches ZERO** OR **the miximum turn is reached**, the battle end and that Tamer who hs the less HP of monster loses 
- Turn counting will be like: 
```
A turn (A hits B) → B turn (B hits A) → A turn (A hits B) = 3 turns
```

- All the numbers representing via the battle log is in the 2 decimal points format (e.g. 100.00, 15.50)

Note that: you need to show the truly understanding of using structures; **all of the main operations should be auto generated based on the information in the structure**. Not manually printed, or use the input scan by user directly without passing them to store in the structure. If so, you would get **ZERO**.

**Case 1**
Sample input:
```
3
MasterMarry
15
10
2
MagesticPlant
P
1700
30
50
80
FighterKuzari
20
20
0
DragonDancer
F
750
82
105
30
SwimmerYoyo
14
6
15
SeaDivine
W
600
65
50
50
10
1
2
```
Sample output:
```
The first start is FighterKuzari's DragonDancer 
Turn 1: DragonDancer causes 2.50 the damage to SeaDivine, HP of SeaDivine drops from 600.00 to 597.50
Turn 2: SeaDivine causes 70.00 the damage to DragonDancer, HP of DragonDancer drops from 750.00 to 680.00
Turn 3: DragonDancer causes 2.50 the damage to SeaDivine, HP of SeaDivine drops from 597.50 to 595.00
Turn 4: SeaDivine causes 70.00 the damage to DragonDancer, HP of DragonDancer drops from 680.00 to 610.00
Turn 5: DragonDancer causes 2.50 the damage to SeaDivine, HP of SeaDivine drops from 595.00 to 592.50
Turn 6: SeaDivine causes 70.00 the damage to DragonDancer, HP of DragonDancer drops from 610.00 to 540.00
Turn 7: DragonDancer causes 2.50 the damage to SeaDivine, HP of SeaDivine drops from 592.50 to 590.00
Turn 8: SeaDivine causes 70.00 the damage to DragonDancer, HP of DragonDancer drops from 540.00 to 470.00
Turn 9: DragonDancer causes 2.50 the damage to SeaDivine, HP of SeaDivine drops from 590.00 to 587.50
Turn 10: SeaDivine causes 70.00 the damage to DragonDancer, HP of DragonDancer drops from 470.00 to 400.00
The winner is SwimmerYoyo (14) using SeaDivine (win: 7 lose: 15)
```

**Case 2**

Sample input:
```
3
MasterMarry
15
10
2
MagesticPlant
P
1700
30
50
80
FighterKuzari
20
20
0
DragonDancer
F
750
82
105
30
SwimmerYoyo
14
6
15
SeaDivine
W
600
65
50
50
20
0
2

```
Sample output:
```
The first start is SwimmerYoyo's SeaDivine 
Turn 1: SeaDivine causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 2: MagesticPlant causes 50.00 the damage to SeaDivine, HP of SeaDivine drops from 600.00 to 550.00
Turn 3: SeaDivine causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 4: MagesticPlant causes 50.00 the damage to SeaDivine, HP of SeaDivine drops from 550.00 to 500.00
Turn 5: SeaDivine causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 6: MagesticPlant causes 50.00 the damage to SeaDivine, HP of SeaDivine drops from 500.00 to 450.00
Turn 7: SeaDivine causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 8: MagesticPlant causes 50.00 the damage to SeaDivine, HP of SeaDivine drops from 450.00 to 400.00
Turn 9: SeaDivine causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 10: MagesticPlant causes 50.00 the damage to SeaDivine, HP of SeaDivine drops from 400.00 to 350.00
Turn 11: SeaDivine causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 12: MagesticPlant causes 50.00 the damage to SeaDivine, HP of SeaDivine drops from 350.00 to 300.00
Turn 13: SeaDivine causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 14: MagesticPlant causes 50.00 the damage to SeaDivine, HP of SeaDivine drops from 300.00 to 250.00
Turn 15: SeaDivine causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 16: MagesticPlant causes 50.00 the damage to SeaDivine, HP of SeaDivine drops from 250.00 to 200.00
Turn 17: SeaDivine causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 18: MagesticPlant causes 50.00 the damage to SeaDivine, HP of SeaDivine drops from 200.00 to 150.00
Turn 19: SeaDivine causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 20: MagesticPlant causes 50.00 the damage to SeaDivine, HP of SeaDivine drops from 150.00 to 100.00
The winner is MasterMarry (15) using MagesticPlant (win: 11 lose: 2)
```

**Case 3**

They cannot hit each other, so the higher HP would win

Sample input:
```
4
MasterMarry
15
10
2
MagesticPlant
P
1700
30
50
80
FighterKuzari
20
20
0
DragonDancer
F
750
82
105
30
SwimmerYoyo
14
6
15
SeaDivine
W
600
65
50
50
AlohaMizuya
11
30
14
GreatesPlant
P
1200
10
65
120
27
0
3
```
Sample output:
```
The first start is MasterMarry's MagesticPlant 
Turn 1: MagesticPlant causes 0.00 the damage to GreatesPlant, HP of GreatesPlant drops from 1200.00 to 1200.00
Turn 2: GreatesPlant causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 3: MagesticPlant causes 0.00 the damage to GreatesPlant, HP of GreatesPlant drops from 1200.00 to 1200.00
Turn 4: GreatesPlant causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 5: MagesticPlant causes 0.00 the damage to GreatesPlant, HP of GreatesPlant drops from 1200.00 to 1200.00
Turn 6: GreatesPlant causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 7: MagesticPlant causes 0.00 the damage to GreatesPlant, HP of GreatesPlant drops from 1200.00 to 1200.00
Turn 8: GreatesPlant causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 9: MagesticPlant causes 0.00 the damage to GreatesPlant, HP of GreatesPlant drops from 1200.00 to 1200.00
Turn 10: GreatesPlant causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 11: MagesticPlant causes 0.00 the damage to GreatesPlant, HP of GreatesPlant drops from 1200.00 to 1200.00
Turn 12: GreatesPlant causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 13: MagesticPlant causes 0.00 the damage to GreatesPlant, HP of GreatesPlant drops from 1200.00 to 1200.00
Turn 14: GreatesPlant causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 15: MagesticPlant causes 0.00 the damage to GreatesPlant, HP of GreatesPlant drops from 1200.00 to 1200.00
Turn 16: GreatesPlant causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 17: MagesticPlant causes 0.00 the damage to GreatesPlant, HP of GreatesPlant drops from 1200.00 to 1200.00
Turn 18: GreatesPlant causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 19: MagesticPlant causes 0.00 the damage to GreatesPlant, HP of GreatesPlant drops from 1200.00 to 1200.00
Turn 20: GreatesPlant causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 21: MagesticPlant causes 0.00 the damage to GreatesPlant, HP of GreatesPlant drops from 1200.00 to 1200.00
Turn 22: GreatesPlant causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 23: MagesticPlant causes 0.00 the damage to GreatesPlant, HP of GreatesPlant drops from 1200.00 to 1200.00
Turn 24: GreatesPlant causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 25: MagesticPlant causes 0.00 the damage to GreatesPlant, HP of GreatesPlant drops from 1200.00 to 1200.00
Turn 26: GreatesPlant causes 0.00 the damage to MagesticPlant, HP of MagesticPlant drops from 1700.00 to 1700.00
Turn 27: MagesticPlant causes 0.00 the damage to GreatesPlant, HP of GreatesPlant drops from 1200.00 to 1200.00
The winner is MasterMarry (15) using MagesticPlant (win: 11 lose: 2)
```