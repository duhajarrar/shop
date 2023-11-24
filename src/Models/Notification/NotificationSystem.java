package Models.Notification;
import java.util.ArrayList;
import java.util.List;
import Patterns.Observer.CustomerObserver;

public class NotificationSystem implements NotificationSubject {
    private List<CustomerObserver> observers;

    public NotificationSystem() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(CustomerObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(CustomerObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (CustomerObserver observer : observers) {
            observer.update(message);
        }
    }
}

