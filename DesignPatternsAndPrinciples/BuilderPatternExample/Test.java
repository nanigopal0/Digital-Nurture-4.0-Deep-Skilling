package DesignPatternsAndPrinciples.BuilderPatternExample;

public class Test {
    public static void main(String[] args) {
        Computer computer1 = new Computer.Builder()
                .setCpu("Ryzen 5")
                .setRam("16GB")
                .setStorage("512GB")
                .build();
        System.out.println("Computer1 specification: \n" + computer1);
        Computer computer2 = new Computer.Builder()
                .setCpu("Intel i5")
                .setRam("8GB")
                .setStorage("512GB")
                .build();
        System.out.println("Computer2 specification: \n" + computer2);

    }
}
