package com.learnings.practise.designpatterns;

public class Builder {
    public static void main(String[] args) {
        Employee employee = Employee.builder().firstName("Madanraj").build();
        System.out.println(employee.getFirstName() + " - " + employee.getLastName());
    }
}

class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static EmployeeBuilder builder() {
        return new EmployeeBuilder();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class EmployeeBuilder {
        private String firstName;
        private String lastName;

        EmployeeBuilder() { }

        public EmployeeBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Employee build() { return new Employee(firstName, lastName); }
    }
}