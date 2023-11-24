package Models.Notification;
import Patterns.Observer.CustomerObserver;

public interface NotificationSubject {
    void addObserver(CustomerObserver observer);
    void removeObserver(CustomerObserver observer);
    void notifyObservers(String message);
}
