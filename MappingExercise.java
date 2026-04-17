import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Employee {
    private String firstName;
    private String lastName;
    private double salary;

    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public double getSalary() { return salary; }
}

public class MappingExercise {
    public static void main(String[] args) {

        List<Employee> staff = new ArrayList<>();
        staff.add(new Employee("Alice", "Smith", 75000));
        staff.add(new Employee("Bob", "Johnson", 62000));
        staff.add(new Employee("Charlie", "Davis", 88000));


        Function<Employee, String> formatCard = e -> 
            "Name: [" + e.getLastName() + ", " + e.getFirstName() + "] - Salary: $" + e.getSalary();


        Function<Employee, Double> salaryPicker = Employee::getSalary;


        System.out.println("Employee Records:");
        for (Employee person : staff) {
            String card = formatCard.apply(person);
            Double salaryValue = salaryPicker.apply(person);
            
            System.out.println(card);
            System.out.println("Extracted Salary: $" + salaryValue);
            System.out.println("---");
        }
    }
}