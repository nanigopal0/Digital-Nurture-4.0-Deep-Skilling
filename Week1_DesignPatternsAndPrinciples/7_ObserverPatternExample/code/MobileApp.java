
public class MobileApp implements Observer {

    private String username;

    public MobileApp(String username) {
        this.username = username;
    }

    public void update(String message) {
        System.out.println(username+" (Mobile App) : " + message);
    }

    @Override
    public String getName() {
        return username;
    }
}