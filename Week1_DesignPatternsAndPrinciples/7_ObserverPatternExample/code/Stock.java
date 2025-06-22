
interface Stock {
    void register(Observer ob);

    void deregister(String username);

    void notify(String message);
}