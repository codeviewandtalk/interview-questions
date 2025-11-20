package solidprinciple.singleResponsibility;

public class SingleResponsibility {
}
/**
 * Before Single responsibility principles
 */
class Employee {
    public void getDesignation(String designation) {
        System.out.println("designation" + designation);
    }



    public void updateSalary(int salary) {
        System.out.println("This method will update the salary");
    }



    public void sendMail() {
        System.out.println("This method is for sending email");
    }


}

/**
 * How to fix the issue
 */
class Employees {
    public void getDesignation(String designation) {
        System.out.println("designation" + designation);
    }



    public void updateSalary(int salary) {
        System.out.println("This method will update the salary");
    }


}

class Notification {
    public void sendMail() {
        System.out.println("This method is for sending email");
    }


}