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
      List<Employee> empWithA =  emplist.stream().filter(emp -> emp.getName().startsWith("A")).toList();
      System.out.println("Employees whose name starts with A : "+ empWithA);

      Map<String, List<Employee>> empWithGroupByDept = emplist.stream().collect(Collectors.groupingBy(Employee::getDepartNames));
      System.out.println("Employees group by department : "+ empWithGroupByDept + "\n");

      Long countEmp =  emplist.stream().count();
      System.out.println("Count of Employee using stream : "+countEmp);

      Employee countByAge = emplist.stream().max(Comparator.comparing(emp -> emp.getAge())).get();
      System.out.println("Maximum by Employee age : "+ countByAge);

      Map<String, List<Employee>> empByDept = emplist.stream().collect(Collectors.groupingBy(emp -> emp.getDepartNames()));
      System.out.println("All Departments : "+empByDept);

      int deptSize = emplist.stream().collect(Collectors.groupingBy(emp -> emp.getDepartNames())).size();
      System.out.println("Count of Employees grouped by department "+ deptSize);

      List<Employee> empByAgeGreater = emplist.stream().filter(emp -> emp.getAge() < 30 ).collect(Collectors.toList());
      System.out.println("Employees whose salary is greater than 30 : " + empByAgeGreater);

      List<Employee> empByAgeGreaterAndBetween = emplist.stream().filter(emp -> emp.getAge() > 26 && emp.getAge() < 31 ).collect(Collectors.toList());
      System.out.println("Employees whose salary is greater than 26 and less than 31 : " + empByAgeGreater);

      Map<String, Double> avgAgeByGender = emplist.stream().collect(Collectors.groupingBy(emp -> emp.getGender(), Collectors.averagingDouble(emp -> emp.getAge())));
      System.out.println("Employees Average age by Gender : "+ avgAgeByGender);

    }
}
