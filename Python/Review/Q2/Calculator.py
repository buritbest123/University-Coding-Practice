while True:  # Do While (but not really xD)
    # (+) Addition
    # (-) Subtraction
    # (*) Multiplication
    # (/) Division
    try:
        n1 = int(input("Enter first number: "))
        n2 = int(input("Enter second number: "))
        OPERATOR = str(input("Enter operator: "))
        if (n1 == 999 and n2 == 999 and (OPERATOR == "C" or OPERATOR == "c")):
            print("Thank you for using the calculator!")
            break
        else:
            if OPERATOR == "+":
                print(n1 + n2)
            elif OPERATOR == "-":
                print(n1 - n2)
            elif OPERATOR == "*":
                print(n1 * n2)
            elif OPERATOR == "/":
                print(n1 / n2)
    except ZeroDivisionError:
        print("Cannot divide by zero!, You FOOL XD")
