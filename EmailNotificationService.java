package inventory;

public class EmailNotificationService implements NotificationService {

    @Override
    public void sendNotification(String to, String message) {
        System.out.println("Sending email to: " + to);
        System.out.println("Message: " + message);
    }
}

