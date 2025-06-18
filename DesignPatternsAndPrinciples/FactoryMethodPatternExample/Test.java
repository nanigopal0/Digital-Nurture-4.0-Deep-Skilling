package DesignPatternsAndPrinciples.FactoryMethodPatternExample;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of document you want to create: ");
        String type = scanner.nextLine();
        DocumentFactory factory = null;
        Document document = null;
        switch (type){
            case "word" -> {
                factory = new WordDocumentFactory();
                document = factory.createDocument();
            }
            case "excel" -> {
                factory = new ExcelDocumentFactory();
                document = factory.createDocument();
            }
            case "pdf" -> {
                factory = new PdfDocumentFactory();
                document = factory.createDocument();
            }
        }
        if(document == null){
            System.out.println("Invalid document type!");
            return;
        }
        document.read();
    }
}