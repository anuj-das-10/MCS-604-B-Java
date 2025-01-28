interface SalaryCalculator {
    double calculateSalary();
    String getDetails();        // Abstract method
}

abstract class Employee implements SalaryCalculator {
    String name;
    private double baseSalary;
    private double bonus;

    public Employee(String name, double baseSalary, double bonus) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
    // getDetails() method remains abstract in this class
}

class Manager extends Employee {
    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary, bonus);
    }

    @Override
    public String getDetails() {
        return "Manager Name: " + name + ", Salary: $" + calculateSalary();
    }
}

public class Solution17 {
    public static void main(String[] args) {
        Employee manager = new Manager("John Doe", 50000, 5000);
        System.out.println(manager.getDetails());
    }
}
