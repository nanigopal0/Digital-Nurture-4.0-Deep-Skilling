
public class WebApp implements Observer {
    private String username;

    public WebApp(String username) {
        this.username = username;
    }

    public void update(String message) {
        System.out.println(username+" (WebApp) : " + message);
    }

    @Override
    public String getName() {
        return username;
    }
}