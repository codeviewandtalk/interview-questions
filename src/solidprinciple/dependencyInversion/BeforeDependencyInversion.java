package solidprinciple.dependencyInversion;

public class BeforeDependencyInversion {
    public static void main(String[] args) {
        EmailNotification notification = new EmailNotification();
        Employee employee = new Employee(notification,null);
        employee.notifyUser();
    }
}

interface Notification {
    void notification();
}

class EmailNotification implements Notification {
    public void notification() {
        System.out.println("Sending notification via email");
    }
}

class TextNotification implements Notification {
    public void notification() {
        System.out.println("Sending notification via text");
    }
}

class Employee {
    private final EmailNotification emailNotification;
    private final TextNotification textNotification;


    public Employee(EmailNotification emailNotification,TextNotification textNotification) {
        this.emailNotification = emailNotification;
        this.textNotification= textNotification;
    }

    public void notifyUser() {
        emailNotification.notification();
    }
}
