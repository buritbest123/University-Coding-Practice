# Fahrenheit to Kevin 
user_F = float(input("Enter your Fahrenheit: "))
K = (user_F + 459.67) / 5 / 9; 
print("Kelvin is now: %.2f" % (K))

# Kelvin to Fahrenheit
F = (9 / 5 * K) - 459.67
print("Fahrenheit is now: %.2f" % (F))