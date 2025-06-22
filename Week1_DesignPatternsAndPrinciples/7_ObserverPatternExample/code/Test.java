import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stock stock = new StockMarket();
        int num = 0;
        while (num != 5) {
            System.out.println("Enter 1 to register a new mobile app user");
            System.out.println("Enter 2 to register a new web app user");
            System.out.println("Enter 3 to deregister a user");
            System.out.println("Enter 4 to notify all users");
            System.out.println("Enter 5 to exit");
            num = sc.nextInt();
            sc.nextLine();  //consume the next line
            switch (num) {
                case 1 -> {
                    System.out.println("Enter the name of the mobile app user: ");
                    stock.register(new MobileApp(sc.next()));
                }
                case 2 -> {
                    System.out.println("Enter the name of the web app user: ");
                    stock.register(new WebApp(sc.next()));
                }
                case 3 -> {
                    System.out.println("Enter the name of the user you want to deregister: ");
                    stock.deregister(sc.next());
                }
                case 4 -> {
                    System.out.println("Enter the message you want to notify all users: ");
                    stock.notify(sc.nextLine());
                }
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid input!");
            }
        }
        sc.close();
    }
}