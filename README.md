# Advanced School Management System (Java OOP)

A console-based school management application built using **Java**. This project demonstrates the practical application of core Object-Oriented Programming (OOP) concepts such as Abstraction, Inheritance, and Encapsulation to manage student records and course enrollments.

## 🚀 Features

- **Student Management:**
  - Create new student accounts with unique IDs.
  - Securely delete student profiles.
- **Security & Authentication:**
  - Login system requiring Student ID and Password to perform actions.
- **Course Enrollment:**
  - View a catalog of available school courses.
  - Enroll in courses (prevents duplicate enrollment).
  - Drop/Remove specific courses from a student profile.
- **Data Display:**
  - View detailed student information, including a list of all currently enrolled courses.

## 🛠️ OOP Principles Applied

- **Abstraction:** The `Person` class is an `abstract` class. It defines the blueprint for common attributes and forces subclasses to implement the `displayInfo()` method.
- **Inheritance:** The `Student` class extends `Person`, inheriting name/ID properties while adding specific attributes like `password` and `EnrolledCourses`.
- **Encapsulation:** All attributes (`id`, `name`, `password`) are set to `private`, accessed and modified only through public `Getter` and `Setter` methods.
- **Polymorphism:** The `displayInfo()` method is overridden in the `Student` class to provide a specific implementation for showing student-specific data.

## 📁 Project Structure

```text
src/advanced_school_system/
│
├── Person.java                 # Abstract base class for all individuals
├── Student.java                # Subclass representing a student user
├── Course.java                 # Data model for school courses
└── Advanced_School_System.java # Main driver class (Logic & Menu)
```

## 👤 Author
**Shreef Rekaby**  
[GitHub Profile](https://github.com/shreef-rekaby) | [LinkedIn](https://www.linkedin.com/in/shreef-rekaby)
