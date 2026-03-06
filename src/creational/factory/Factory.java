package creational.factory;

interface Document {}
class PdfDocument implements Document {}
class WordDocument implements Document {}

public class Factory {
    public Document createDocument(String type) {
        if (type.equalsIgnoreCase("PDF")) return new PdfDocument();
        if (type.equalsIgnoreCase("WORD")) return new WordDocument();
        return null;
    }
}