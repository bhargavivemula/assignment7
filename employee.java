import java.util.ArrayList;
import java.util.List;

class Employee {
    float hoursWorked;

    Employee(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(35));
        employees.add(new Employee(45));
        employees.add(new Employee(40));
        employees.add(new Employee(50));
        employees.add(new Employee(30));

        float[] buckets = {0, 0, 0};
        float totalHours = 0;
        for (Employee employee : employees) {
            if (employee.hoursWorked < 40) {
                buckets[0]++;
                totalHours += employee.hoursWorked;
            } else if (employee.hoursWorked == 40) {
                buckets[1]++;
                totalHours += employee.hoursWorked;
            } else {
                buckets[2]++;
                totalHours += 40 + (employee.hoursWorked - 40) * 1.5;
            }
        }

        System.out.println("Less than 40 hours: " + buckets[0]);
        System.out.println("Exactly 40 hours: " + buckets[1]);
        System.out.println("More than 40 hours: " + buckets[2]);
        System.out.println("Average hours worked per day for less than 40 hours: " + totalHours / buckets[0] / 5);
        System.out.println("Average hours worked per day for exactly 40 hours: " + totalHours / buckets[1] / 5);
        System.out.println("Average hours worked per day for more than 40 hours: " + (totalHours / buckets[2] / 5) / 1.5);
    }
}
