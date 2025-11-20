package dsa;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private int age;
    private long salary;
    private String gender;
    private String deptName;
    private String city;
    private int yearOfJoining;

    public Employee(int id, String name, int age, long salary, String gender,
                    String deptName, String city, int yearOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.deptName = deptName;
        this.city = city;
        this.yearOfJoining = yearOfJoining;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    @Override
    public String toString() {
        return "dsa.Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", deptName='" + deptName + '\'' +
                ", city='" + city + '\'' +
                ", yearOfJoining='" + yearOfJoining + '\'' +
                '}';
    }

}

public class Java8StreamPart2Questions {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1001, "Jack", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new Employee(1002, "jhon", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new Employee(1003, "Sam", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new Employee(1004, "Wacky", 32, 125, "F", "HR", "Chennai", 2013));

        empList.add(new Employee(1005, "Cummins", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new Employee(1006, "Root", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new Employee(1007, "Anderson", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new Employee(1008, "Mathew", 23, 145, "M", "IT", "Trivandam", 2015));
        empList.add(new Employee(1009, "Clark", 25, 160, "M", "IT", "Blore", 2010));


        //.Print the number of employees in each department.
        Map<String, Long> empCountInEachDepartment = empList
                .stream()
                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
        System.out.println("Number of employees in each department: " + empCountInEachDepartment);






















        // 1.Group the Employees by city.
        Map<String, List<Employee>> empByCity = empList.stream().collect(Collectors.groupingBy(Employee::getCity));
        System.out.println("Group by City : " + empByCity);

        // 2. Find the count of male and female employees present in the organization.
        Map<String, Long> empByGender = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Group By Gender : " + empByGender);

        //3. Print the names of all departments in the organization.
        System.out.println("Names of all departments in the organization ");
        empList.stream().map(e -> e.getDeptName()).distinct().forEach(System.out::println);

        //4.Print employee details whose age is greater than 28.
        System.out.println("dsa.Employee details whose age is greater than 28");
        empList.stream().filter(e -> e.getAge() > 28).toList().forEach(System.out::println);

        //5.Find maximum age of employee.
        System.out.println("Maximum age of dsa.Employee: ");
        empList.stream().mapToInt(Employee::getAge).max().ifPresent(System.out::println);
      int maxAge=   empList.stream().max((e1,e2)->e1.getAge()-e2.getAge()).get().getAge();
        System.out.println("max age. " + maxAge);

        //6.Print Average age of Male and Female Employees.
        Map<String, Double> empAvgAge = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println("Average age of Male and female :" + empAvgAge);

        //7.Print the number of employees in each department.
        Map<String, Long> empCountByEachDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
        System.out.println("Number of employees in each department: " + empCountByEachDept);

        //8.Find the oldest employee.
        System.out.println("Oldest Employee.");
        empList.stream().max(Comparator.comparing(Employee::getAge)).ifPresent(System.out::println);

        // 9. Find the youngest female employee.
        System.out.println("Youngest Female Employee.");
        empList.stream().filter(e -> Objects.equals(e.getGender(), "F")).min(Comparator.comparingInt(Employee::getAge)).ifPresent(System.out::println);
        empList.stream().filter(e->e.getGender().equals("F")).min((e1,e2)->e1.getAge()-e2.getAge()).ifPresent(System.out::println);
        //10. Find employees whose age is greater than 30 and less than 30.
        Map<Boolean, List<Employee>> partitionEmployeesByAge = empList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 30));
        System.out.println("Employees whose age is greater than 30 and less than 30: " + partitionEmployeesByAge);

        //11.Find the department name which has the highest number of employees.
        System.out.println("The department name which has the highest number of employees.");
        empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).entrySet()
                .stream().max(Comparator.comparing(Map.Entry::getValue)).ifPresent(System.out::println);
        empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).entrySet()
                .stream().max((e1,e2)-> Math.toIntExact(e1.getValue() - e2.getValue())).ifPresent(System.out::println);
        //12.Find if there is any employees from HR Department.
        Optional<Employee> empFromHR = empList.stream().filter(d -> d.getDeptName().equalsIgnoreCase("HR")).findAny();
        System.out.println("Found employees from HR department" + empFromHR.get());

        //13.Find the department names that these employees work for, where the number of employees in the department is over 3.
        System.out.println("Department names");
        empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).entrySet()
                .stream().filter(entry -> entry.getValue() > 3).forEach(System.out::println);


        //14. Find all employees who lives in ‘Blore’ city, sort them by their name and print the names of employees.
        System.out.println("Employees who lives in ‘Blore’ city");
        empList.stream().filter(c -> c.getCity().equalsIgnoreCase("Blore")).sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);

        //15.Find the department which has the highest number of employees.
        Optional<Map.Entry<String, Long>> deptNameWithHighestEmp = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).entrySet()
                .stream().max(Map.Entry.comparingByValue());
        Optional<Map.Entry<String, Long>> deptNameWithHighestEmps = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).entrySet()
                .stream().max(Comparator.comparing(Map.Entry::getValue));
    System.out.println("Department which has the highest number of employees " + deptNameWithHighestEmp.get() + " or " + deptNameWithHighestEmps.get());

        //16.Sorting a Stream by age and name fields.
        System.out.println("Sorting by age and name fields");
        empList.stream().sorted(Comparator.comparing(Employee::getAge).thenComparing(Comparator.comparing(Employee::getName))).forEach(System.out::println);

        //17.Print average and total salary of the organization.
        DoubleSummaryStatistics empSalary = empList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average Salary in the organisation = " + empSalary.getAverage());
        System.out.println("Total Salary in the organisation  = " + empSalary.getSum());

        //18.Print Average salary of each department.
        Map<String, Double> avgSalary = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Average salary of each department :" + avgSalary);

        //19. Find Highest salary in the organisation.
        System.out.println("Highest salary in the organisation.");
        empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst().ifPresent(e -> System.out.println(e.getSalary()));

//        //20.Find the second-highest salary in the organisation.
        System.out.println("Second highest salary in the organisation.");
        empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().ifPresent(e -> System.out.println(e.getSalary()));

        Map<String, Optional<Employee>> collect = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println("Highest salary of each department :" + collect);
    }
}
