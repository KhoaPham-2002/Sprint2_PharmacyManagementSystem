// Name: Khoa Pham
// Project: Sprint 1 Java
// Group: Solo
// Date: 03/02/2025

public class Person {
    // Attributes to store personal details
    private int id;
    private String name;
    private int age;
    private String phoneNumber;

    // Constructor to initialize a Person object
    public Person(int id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // Getter methods to retrieve attribute values
    public int getId() {
        return id;
    }

    public String getName() { 
        return name; 
    }

    public int getAge() {
        return age; 
    }

    public String getPhoneNumber() {
        return phoneNumber; 
    }

    // Setter methods to update attribute values
    public void setName(String name) {
        this.name = name; 
    }

    public void setAge(int age) {
        this.age = age; 
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber; 
    }

    // Returns a formatted string representation of the Person object
    @Override
    public String toString() {
        return String.format("Person Id: %d%nPerson name: %s%nPerson age: %d%nPerson phone number: %s%n",
         id, name, age, phoneNumber);
    }
}