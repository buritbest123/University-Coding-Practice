# CanteenICT Simulation Project 🍽️🎓

**ITCS 209 - Object-Oriented Programming**  
This project simulates a canteen environment where customers (students, professors, athletes, etc.) queue up, purchase food, find seating, and eat their meals. The simulation focuses on object-oriented programming principles such as inheritance, encapsulation, and polymorphism. 🧑‍💻🚀

## Overview 📄✨

With the Bamboo Garden gone, a new canteen for hungry ICT students and visitors is needed! This project simulates the flow of customers from entering the canteen to finishing their meals. The canteen has multiple food stalls, tables, and different types of customers. This simulation provides insights into managing customer queues, handling orders, and maximizing seating efficiency. 🧑‍🏫💡

### Key Components 🛠️:

1. **Food Stalls 🍜**  
   Each food stall has a limited queue and serves different types of food (e.g., noodles, dessert, meat). Customers place orders and wait for their food to be prepared. 🍲🍰

2. **Customers 👥**  
   Different customer types (students, professors, athletes, ICT students) have different meal preferences and behaviors. For example, ICT students can start eating while waiting for a seat. 🧑‍🎓👨‍🏫💪

3. **Tables 🍽️**  
   Customers sit at tables to eat their meals. Tables have a limited number of seats, and customers must wait for an available table before they can start eating. 🪑🍴

## Project Features 🌟

- **Object-Oriented Design**:  
  Implements core OOP principles such as classes, inheritance, and encapsulation. 📦
  
- **Customer Simulation**:  
  Customers queue up, place orders, and wait for seats based on their type. ⏳

- **Dynamic Food Stalls**:  
  Each food stall has its own menu, queue management, and preparation time. 🕒🍛

- **Logging & Debugging**:  
  Each simulation iteration is logged in detailed files for debugging and analysis. 📝🔍

## Files in the Project 📂💻

- **CanteenICT.java**: The main simulation engine that manages the canteen, customers, food stalls, and tables. 🏗️
- **Customer.java**: Defines the behavior of different types of customers. 🧑‍🍳
- **FoodStall.java**: Manages each food stall’s menu, customer queue, and order handling. 🛒🍜
- **Table.java**: Handles the seating of customers and their eating time. 🍽️⏱️
- **ICTStudent.java**: Extends the `Student` class to handle special behaviors of ICT students. 🎓💼
- **Professor.java**, **Athlete.java**, **Student.java**: Specific customer types with unique meal preferences. 👨‍🏫🏅
- **StudentTester.java**: Contains test cases for validating the simulation logic. ✅📊

## How to Run the Simulation 🚀

1. **Clone the repository**:  
   First, clone the project to your local machine. 🌐💻
   ```bash
   git clone [repository-link]
   cd CanteenICT-Simulation
   ```

2. **Compile the Java files**:  
   Use the following command to compile the source files. 🛠️
   ```bash
   javac *.java
   ```

3. **Run the simulation**:  
   Execute the main `CanteenICT.java` class to start the simulation. 🎮
   ```bash
   java CanteenICT
   ```

4. **Test the simulation**:  
   Use the `StudentTester.java` to run the test cases. 🧪
   ```bash
   java StudentTester
   ```

## Bonus Features 🎉

- **Special Customers 👨‍🎓**:  
  Implement unique behaviors for specific customer types (e.g., ICT students who eat while waiting for a seat). 💡🍽️

- **Detailed Logs 📊**:  
  Each simulation iteration generates log files (`state.log`, `summary.log`) for tracking the progress of the simulation. 📜

## Contact Information 📧

For further inquiries or issues, please contact the project maintainers directly through our GitHub repository. 📩
