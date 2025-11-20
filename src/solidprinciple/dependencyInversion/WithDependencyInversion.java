package solidprinciple.dependencyInversion;

public class WithDependencyInversion {
    public static void main(String[] args) {
        Notifications notifications = new EmailNotifications();
        Employees employees = new Employees(notifications);
        employees.notifyUser();

        Notifications textNotification = new TextNotifications();
        Employees employee = new Employees(textNotification);
        employee.notifyUser();
    }
}

interface Notifications {
    public void notifications();
}

class EmailNotifications implements Notifications {

    @Override
    public void notifications() {
        //implement notification via email

    }
}

class TextNotifications implements Notifications {

    @Override
    public void notifications() {
        //implement notification via text

    }
}

class Employees {
    private Notifications notification;

    public Employees(Notifications notification) {
        this.notification = notification;
    }

    public void notifyUser() {
        notification.notify();
    }

}

