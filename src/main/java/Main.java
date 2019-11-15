import Parser.PeriodicalsParser;
import Periodicals.Periodicals;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class Main {
    public static void main(String[]args) throws ParserConfigurationException, XMLStreamException, SAXException, IOException {
        PeriodicalsParser periodicalsParser = new PeriodicalsParser();

        periodicalsParser.setTypeOfParser("STAX");
        Periodicals result = periodicalsParser.parseXmlDocument("src/main/resources/Periodicals.xml",
                "src/main/resources/Periodicals.xsd");
        result.writeInFile("Periodicals.txt");

        periodicalsParser.setTypeOfParser("DOM");
        result = periodicalsParser.parseXmlDocument("src/main/resources/Periodicals.xml",
                "src/main/resources/Periodicals.xsd");
        result.writeInFile("Periodicals.txt");

        periodicalsParser.setTypeOfParser("SAX");
        result = periodicalsParser.parseXmlDocument("src/main/resources/Periodicals.xml",
                "src/main/resources/Periodicals.xsd");
        result.writeInFile("Periodicals.txt");
    }
}
