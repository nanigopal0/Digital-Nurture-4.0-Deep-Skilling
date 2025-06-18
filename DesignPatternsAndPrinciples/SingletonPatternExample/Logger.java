

public class Logger {
    private static Logger instance;

    private Logger() {
    }

    public void log(String message){
        System.out.println(message);
    }

    // synchronized keyword ensures only one thread can access getInstance method at a time
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
}