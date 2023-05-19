rows = int(input("Enter the number of rows: "))
for i in range(rows, 0, -1):  # i is the number of rows | rows (i) is start | 0 is end | -1 is step
    for j in range(0, (rows - i)*2): # j is the number of spaces | 0  is start | (rows - i)*2 is end
        print(end=" ")
    for j in range(0, i*2):  # j is the number of stars | 0 (j) is start | i*2 is end
        print("*", end=" ")
    print()
