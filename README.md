# DormMate - Dormitory Management System

## 📋 Project Overview

**DormMate** is a Java-based console application designed to streamline the dormitory rental process for students and landlords. The system allows students to browse available dorm listings, inquire about properties, book rooms, and manage their rental payments. Landlords can manage their dorm properties, view student inquiries, and track room availability. This project demonstrates core Object-Oriented Programming (OOP) principles and provides a practical solution for managing dormitory accommodations in an educational setting.

---

## 🎯 Description

DormMate addresses the common challenges faced by students searching for affordable accommodation near their universities and landlords trying to manage multiple properties efficiently. The system provides:

- **For Students**: Browse dorm listings, filter by budget, send inquiries to landlords, book rooms, and track rental payments
- **For Landlords**: Manage multiple dorm properties, view and respond to student inquiries, track room availability and bookings
- **Data Validation**: Input validation for emails, phone numbers, dates, and budget amounts
- **User-Friendly Interface**: Simple menu-driven console interface for easy navigation

---

## 🏗️ OOP Concepts Applied

### 1. **Encapsulation**

Encapsulation is implemented throughout the project by keeping data members or instance variables `private` and using special methods known as `getter` and `setter` methods to access and modify them. Using encapsulation helps provide security and restrict access to those classes that are connected to it.

**Example:**

```java
// Person.java
private String fullName;
private String email;
private String contactNumber;

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    if (InputValidator.isValidEmail(email)) {
        this.email = email;
    } else {
        InputValidator.printError("Invalid email format!");
    }
}
```

### 2. **Inheritance**

The `Person` class serves as the parent class, providing common attributes and methods that are shared among all persons. The `Student` and `Landlord` classes are child classes that inherit these common features, while also introducing their own unique attributes and methods to handle specific behaviors and functionality relevant to students and landlords, respectively. We also use `super()` to call the constructor of the parent class, which allows the child classes to initialize the inherited attributes properly before adding their own specific attributes. This ensures that the common data from the parent class is set correctly and reduces code duplication.

**Class Hierarchy:**

```
Person (Abstract)
├── Student
└── Landlord
```

**Example:**

```java
// Student inherits from Person
public class Student extends Person {
    private String studentID;
    private String universitySchool;
    private double budget;
    public Student(
        String fullName,
        String email,
        String contactNumber,
        String address,

        String studentID,
        String universitySchool,
        double budget
    ) {
        // use super() to call Person constructor
        super(fullName, email, contactNumber, address);

        this.studentID = studentID;
        this.universitySchool = universitySchool;
        this.budget = budget;

}
```

```java
// Landlord inherits from Person
public class Landlord extends Person {
    private String landlordID;
    private List<Dorm> ownedDorms;

    // Parameterized constructor
    public Landlord(
        String fullName,
        String email,
        String contactNumber,
        String address,
        String landlordID
    ) {
        // use super() to call Person constructor
        super(fullName, email, contactNumber, address);

        this.landlordID = landlordID;
        this.ownedDorms = new ArrayList<>();
    }
```

### 3. **Polymorphism**

Polymorphism is demonstrated through method overriding, where child classes provide their own implementation of the abstract `displayInfo()` method. We also use the `@Override` annotation to override the method that is defined in the parent class. This allows objects of different child classes to be treated as objects of the parent class while still executing their own specific behavior, showing how the same method call can produce different results depending on the object’s actual type.

**Example:**

```java
// Person.java
public abstract String displayInfo(); // Abstract Method
```

```java
// Student.java
@Override
 public String displayInfo() {
        String info = "\n=== STUDENT INFO ===" +
                      "\nName: " + getfullName() +
                      "\nStudent ID: " + studentID +
                      "\nUniversity: " + universitySchool +
                      "\nBudget: ₱" + String.format("%.2f", budget) +
                      "\nEmail: " + getEmail() +
                      "\nContact: " + getContactNumber() +
                      "\nAddress: " + getAddress();

        // Show rental info if currently renting
        if (isRenting && currentRoom != null) {
            info += "\n\n=== RENTAL INFO ===" +
                    "\nRoom: " + currentRoom.getRoomNumber() +
                    "\nMonthly Rent: ₱" + String.format("%.2f", monthlyRent) +
                    "\nLease: " + leaseStartDate + " to " + leaseEndDate +
                    "\nPayment Status: " + paymentStatus;
        }

        return info;
    }
```

```java
// Landlord.java
@Override
    public String displayInfo() {
        return "\nName: " + getfullName() +
               "\nLandlord ID: " + landlordID +
               "\nOwned Dorms: " + ownedDorms.size() +
               "\nEmail: " + getEmail() +
               "\nContact: " + getContactNumber() +
               "\nAddress: " + getAddress() +
               "\n Total Dorms: " + ownedDorms.size();
```

### 4. **Abstraction**

The `Person` class is declared as abstract, providing a template for common attributes while enforcing that subclasses implement specific methods. This class acts as an abstraction because it does not have method bodies for certain behaviors, which forces child classes to provide their own implementations. By doing this, abstraction hides the complexity of how these behaviors are performed in each subclass, allowing the program to focus on what the objects do rather than how they do it. This makes the code cleaner, easier to maintain, and more flexible for future extensions.

**Example:**

```java
public abstract class Person {
    // Common attributes
    private String fullName;
    private String email;

    // Abstract method - must be implemented by subclasses
    public abstract String displayInfo();
}
```

---

## 📁 Program Structure

### Project Directory Structure

```
DormManagementSystem/
│
├── src/
│   ├── model/                  # Domain models
│   │   ├── Person.java         # Abstract parent class
│   │   ├── Student.java        # Student class (extends Person)
│   │   ├── Landlord.java       # Landlord class (extends Person)
│   │   ├── Dorm.java           # Dorm property cllass
│   │   ├── Room.java           # Room class
│   │   ├── DormListing.java    # Listing class
│   │   └── Inquiry.java        # Inquiry class
│   │
│   ├── service/                
│   │   ├── DormMate.java       # Main entry point
│   │   ├── StudentMenu.java    # Student operations menu
│   │   └── LandlordMenu.java   # Landlord operations menu
│   │
│   ├── ui/                     
│   │   └── Main.java           # Data initialization
│   │
│   └── util/                   
│       └── InputValidator.java # Input validation methods
│
└── bin/                        # Compiled .class files
```

### Class Relationships

```
┌─────────────────────────────────────────────────────────────┐
│                         Person (Abstract)                    │
│  - fullName: String                                          │
│  - email: String                                             │
│  - contactNumber: String                                     │
│  - address: String                                           │
│  + abstract displayInfo(): String                            │
└──────────────────┬──────────────────────────────────────────┘
                   │
          ┌────────┴────────┐
          │                 │
┌─────────▼────────┐ ┌─────▼──────────┐
│     Student      │ │    Landlord    │
├──────────────────┤ ├────────────────┤
│ - studentID      │ │ - landlordID   │
│ - university     │ │ - ownedDorms   │
│ - budget         │ │                │
│ - currentRoom    │ │ + addDorm()    │
│ + bookRoom()     │ │ + viewInquiries│
│ + payRent()      │ │                │
└──────────────────┘ └────────────────┘
         │                    │
         │                    │
         ▼                    ▼
┌─────────────────┐  ┌──────────────┐
│     Inquiry     │  │     Dorm     │
├─────────────────┤  ├──────────────┤
│ - inquiryID     │  │ - dormID     │
│ - student       │  │ - dormName   │
│ - listing       │  │ - address    │
│ - message       │  │ - rooms[]    │
│ - dateSent      │  │              │
└─────────────────┘  └──────┬───────┘
                            │
                            ▼
                     ┌─────────────┐
                     │    Room     │
                     ├─────────────┤
                     │ - roomNumber│
                     │ - roomType  │
                     │ - price     │
                     │ - available │
                     └─────────────┘
```

### Main Classes and Their Roles

| Class              | Package   | Role                                                |
| ------------------ | --------- | --------------------------------------------------- |
| **Person**         | `model`   | Abstract base class for Student and Landlord        |
| **Student**        | `model`   | Represents a student user with booking capabilities |
| **Landlord**       | `model`   | Represents a landlord managing dorm properties      |
| **Dorm**           | `model`   | Represents a dormitory property                     |
| **Room**           | `model`   | Represents individual rooms within a dorm           |
| **DormListing**    | `model`   | Represents a dorm listing advertisement             |
| **Inquiry**        | `model`   | Represents student inquiries to landlords           |
| **DormMate**       | `service` | Main entry point and application controller         |
| **StudentMenu**    | `service` | Handles student menu operations                     |
| **LandlordMenu**   | `service` | Handles landlord menu operations                    |
| **Main**           | `ui`      | Initializes sample data                             |
| **InputValidator** | `util`    | Validates user inputs                               |

---

## 🚀 How to Run the Program

### Prerequisites

- Java Development Kit (JDK) 17 or higher
- Terminal/Command Prompt access

### Step-by-Step Instructions

#### 1. **Navigate to the Project Directory**

```bash
cd /workspaces/dormManagementSystem/DormManagementSystem
```

#### 2. **Compile the Java Files**

```bash
javac -d bin src/**/*.java
```

This command compiles all `.java` files in the `src` directory and places the compiled `.class` files in the `bin` directory.

#### 3. **Run the Program**

```bash
java -cp bin service.DormMate
```

This executes the `DormMate` class which contains the main method.

### Alternative: One-Line Command

```bash
cd /workspaces/dormManagementSystem/DormManagementSystem && javac -d bin src/**/*.java && java -cp bin service.DormMate
```

---

## 📺 Sample Output

### Program Start

```
✓ Sample data initialized successfully!
=== WELCOME TO DormMate! ===

Are you a:
1. Student
2. Landlord
3. Exit
Enter choice: 1
```

### Student Login

```
--- STUDENT LOGIN ---
Enter your student ID: S001
Welcome, Juan Dela Cruz!

--- STUDENT MENU ---
1. Browse listings
2. Inquire about a dorm
3. Book a room
4. Pay rent
5. Display my info
6. Logout
Choice: 1
```

### Browse Listings

```
--- AVAILABLE LISTINGS ---

Listing ID: LIST001
Dorm: Sunshine Dorm
Address: 123 Main St
Available Rooms: 2
Monthly Rate: ₱5000.0 - ₱7000.0
Description: Affordable student housing
```

### Book a Room

```
Choice: 3
Enter room number to book: 101
Enter start date (YYYY-MM-DD): 2025-01-01
Enter end date (YYYY-MM-DD): 2025-05-31
✓ Juan Dela Cruz successfully booked room 101
✓ Room booked successfully!
```

### Student Information Display

```
Choice: 5

=== STUDENT INFORMATION ===
Student ID: S001
Name: Juan Dela Cruz
Email: juan@email.com
Contact: 09123456789
University: BSCS - UP Diliman
Budget: ₱10000.0
Booked Room: 101
```

### Input Validation Examples

```
Enter your student ID: INVALID
Landlord not found!

Enter start date (YYYY-MM-DD): 2025-13-45
✗ Invalid start date format!

Enter your message:
✗ Message cannot be empty!
```

---

## 👨‍💻 Authors and Acknowledgements

### Authors

#### ![Shin-mie Ramos](https://avatars.githubusercontent.com/u/191760553?v=4) Shin-mie Ramos
- **Course:** Computer Science
- **Email:** 24-07030@g.batstate-u.edu.ph
- **GitHub:** [shinmieeeee](https://github.com/shinmieeeee)

#### ![Coleen Dichoso](https://avatars.githubusercontent.com/u/191759724?v=4) Coleen Dichoso
- **Course:** Computer Science
- **Email:** 24-07852@g.batstate-u.edu.ph
- **GitHub:** [cole-colee](https://github.com/cole-colee)

#### ![Julianne Antoinette Deduque](https://avatars.githubusercontent.com/u/129857185?v=4) Julianne Antoinette Deduque
- **Course:** Computer Science
- **Email:** 22-07161@g.batstate-u.edu.ph
- **GitHub:** [jasd927](https://github.com/jasd927)

#### Jyvhan Earl Ponce
- **Course:** Computer Science
- **Email:** 24-04667@g.batstate-u.edu.ph
- **GitHub:** [Kuroi17](https://github.com/kuroi17)

### Acknowledgements

- **Course Instructor**: Ms. Fatima Marie Agdon - For teaching and guidance on Java OOP principles and project requirements. Thank you so much Maam.
- **Classmates**: For collaboration and code review sessions
- **Github**: For platform to use for dynamic collaboration
- **Generative AIs**: For brainstorming and debugging code issues

---

## 🔮 Future Enhancements

1. **Database Integration**

   - Implement MySQL/PostgreSQL for persistent data storage
   - Replace in-memory lists with database queries

2. **Advanced Search & Filters**

   - Filter by location, price range, room type
   - Sort listings by price, rating, or availability

3. **Payment Integration**

   - Add online payment gateway simulation
   - Generate payment console-based receipts

4. **GUI Implementation**

   - Develop JavaFX or Swing-based graphical interface
   - Improve user experience with visual elements


---

## 📚 References
**OOP Lesson Presentations**
- **Encapsulation** – Using `private` class members and special methods (getters and setters) to control access.
- **Inheritance** – Using `extends` and `super()` to create a parent-child class relationship.
- **Polymorphism** – using `@Override` methods to allow different behaviors in child classes.
- **Abstraction** – Hiding complexity by making subclasses implement the abstract methods of the parent class.



**Online Resources**
   - Youtube - Java Programming Tutorials
   - Generative AIs - Brainstorm and Debugging
   - GitHub - Open Source Java Repositoyies

---
