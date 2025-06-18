package DesignPatternsAndPrinciples.FactoryMethodPatternExample;

public class PdfDocumentFactory extends DocumentFactory {

    public Document createDocument() {
        return new PdfDocument();
    }
}