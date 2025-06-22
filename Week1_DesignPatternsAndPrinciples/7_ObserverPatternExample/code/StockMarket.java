import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private static List<Observer> observers = new ArrayList<>();

    public void register(Observer ob) {
        observers.add(ob);
    }

    public void deregister(String username) {
        for (Observer ob : observers) {
            if (ob.getName().equalsIgnoreCase(username)) {
                observers.remove(ob);
                break;
            }
        }
    }

    public void notify(String message) {
        for (Observer ob : observers) {
            ob.update(message);
        }
    }
}