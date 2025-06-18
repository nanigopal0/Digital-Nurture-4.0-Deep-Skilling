package DesignPatternsAndPrinciples.AdapterPatternExample;

public class Stripe {
    public boolean payWithCard(String cardNumber,int cvv,int amount){
        System.out.println("Paying with card "+cardNumber+" cvv "+cvv+" amount "+amount);
        return true;
    }

    public boolean payWithNetBanking(String bankName,int amount){
        System.out.println("Paying with net banking "+bankName+" amount "+amount);
        return true;
    }

}
