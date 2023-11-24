package Patterns.Observer;

public class CustomerObserverImp implements CustomerObserver{
    @Override
    public void update(String message) {
        System.out.println("Notification for : " + message);
    }
}
