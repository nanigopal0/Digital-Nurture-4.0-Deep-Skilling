

public class Test {
    public static void main(String[] args) {
        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();
        Thread t1 = new Thread(()->{
                Logger log = Logger.getInstance();
                log.log("Logger object "+log.hashCode()+" by "+Thread.currentThread().getName());
        });

        Thread t2 = new Thread(()->{
                Logger log = Logger.getInstance();
                log.log("Logger object "+log.hashCode()+" by "+Thread.currentThread().getName());
        });
        t1.start();
        t2.start();
        if(log1 == log2){
            log1.log("Same instance! logger object "+log1.hashCode());
            log2.log("Logger object "+log2.hashCode());
        }

    }
}