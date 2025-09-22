package JavaStreams.InterviewCodingQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStreamExamples {
    static List<Employee> emplist = Arrays.asList(
            new Employee(1, "Abraham", 29, "IT", "Mumbai", 20000, "Male"),
            new Employee(2, "Mary", 27, "Sales", "Chennai", 25000, "Female"),
            new Employee(3, "Joe", 28, "IT", "Chennai", 22000, "Male"),
            new Employee(4, "John", 29, "Sales", "Gurgaon", 29000, "Male"),
            new Employee(5, "Liza", 25, "Sales", "Bangalore", 32000, "Female"),
            new Employee(6, "Peter", 27, "Admin", "Mumbai", 31500, "Male"),
            new Employee(7, "Harry", 30, "Research", "Kochi", 21000, "Male")
    );

    public static void main(String[] args) {
        // 1. Filter employees whose names start with "A"
        List<Employee> empWithA = emplist.stream().filter(emp -> emp.getName().startsWith("A")).toList();
        System.out.println("Employees whose name starts with A : " + empWithA);

        // 2. Group employees by department
        Map<String, List<Employee>> empWithGroupByDept = emplist.stream().collect(Collectors.groupingBy(Employee::getDepartNames));
        System.out.println("Employees group by department : " + empWithGroupByDept);

        // 3. Count total number of employees
        Long countEmp = emplist.stream().count();
        System.out.println("Count of Employee using stream : " + countEmp);

        // 4. Find employee with maximum age
        Employee countByAge = emplist.stream()
                .max(Comparator.comparing(emp -> emp.getAge()))
                .get();
        System.out.println("Maximum by Employee age : " + countByAge);

        // 5. Group employees by department (duplicate of step 2, just showing usage)
        Map<String, List<Employee>> empByDept = emplist.stream().collect(Collectors.groupingBy(Employee::getDepartNames));
        System.out.println("All Departments : " + empByDept);

        // 6. Count number of departments (size of grouped map)
        int deptSize = emplist.stream().collect(Collectors.groupingBy(Employee::getDepartNames)).size();
        System.out.println("Count of Employees grouped by department " + deptSize);

        // 7. Employees whose age is less than 30
        List<Employee> empByAgeGreater = emplist.stream()
                .filter(emp -> emp.getAge() < 30)
                .toList();
        System.out.println("Employees whose age is less than 30 : " + empByAgeGreater);

        // 8. Employees whose age is between 27 and 30
        List<Employee> empByAgeGreaterAndBetween = emplist.stream()
                .filter(emp -> emp.getAge() > 26 && emp.getAge() < 31)
                .toList();
        System.out.println("Employees whose age is greater than 26 and less than 31 : " + empByAgeGreaterAndBetween);

        // 9. Average age of employees grouped by gender
        Map<String, Double> avgAgeByGender = emplist.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(emp -> emp.getAge())));
        System.out.println("Employees Average age by Gender : " + avgAgeByGender);

        // 10. Average salary of all employees
        Double avgSalary = emplist.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("Average Salary of all Employees : " + avgSalary);

        // 11. Department with maximum employees
        Map.Entry<String, Long> empWithMaxDept = emplist.stream()
                .collect(Collectors.groupingBy(emp -> emp.getDepartNames(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();
        System.out.println("Department with the maximum no. of employees : " + empWithMaxDept);

        /*We used Collectors.groupingBy() which collects data into a Map because groupingBy naturally produces one.
        This is a terminal operation where the stream is converted into a specified collection. So,to get the
        department + count, you need convert it to stream() first and then use entrySet().
        To find the max, you need to stream those entries*/

        // 12. Employees from Mumbai sorted by name
        List<Employee> empAddDelhi = emplist.stream()
                .filter(emp -> emp.getAddress().equals("Mumbai"))
                .sorted(Comparator.comparing(Employee::getName))
                .toList();
        System.out.println("Employee whose address is delhi : " + empAddDelhi);

        //Note - If .sorted() with no arguments in Java tries to sort using natural ordering.
        // That means the elements (Employee objects) must implement Comparable<Employee>.
        // If your class doesn’t implement it → use .sorted(Comparator.comparing(...)).

        // 13. Highest salary for each department
        Map<String, Optional<Employee>> highestSalForEachDept = emplist.stream().collect(Collectors.groupingBy(Employee::getDepartNames, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println("Highest Salary for each dept : " + highestSalForEachDept);

        // 14. Sort employees by salary (ascending order)
        List<Employee> salarySort = emplist.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
        System.out.println("List of Employees by sorted salary : " + salarySort);

        // 15. Find second lowest salary
        Optional<Employee> secondLowestSal = emplist.stream()
                .sorted(Comparator.comparing(Employee::getSalary)) // sort ascending
                .skip(1) // skip first (lowest)
                .findFirst(); // take second
        System.out.println("Second lowest Salary : " + secondLowestSal);

        // 16. Find second highest salary
        Optional<Employee> secondHighestSal = emplist.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()) // sort descending
                .skip(1) // skip first (highest)
                .findFirst(); // take second
        System.out.println("Second Highest Salary : " + secondHighestSal);
    }
}
