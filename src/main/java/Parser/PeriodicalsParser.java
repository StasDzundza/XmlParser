package Parser;

import Parser.SAX.SaxXmlParser;
import Periodicals.Paper;
import Periodicals.Periodicals;
import org.xml.sax.SAXException;


import javax.xml.parsers.*;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class PeriodicalsParser {
    private XMLParser parser;
    private Periodicals result;
    private PaperBuilder paperBuilder;
    private String typeOfParser = "DOM";

    public void setTypeOfParser(String typeOfParser){
        this.typeOfParser = typeOfParser;
    }

    public Periodicals parseXmlDocument(String pathToXmlDocument, String pathToXsdFile) throws ParserConfigurationException, SAXException, IOException, XMLStreamException {

        if(XmlFileValidator.validateXMLDocument(pathToXmlDocument,pathToXsdFile)) {
            paperBuilder = new PaperBuilder();
            switch (typeOfParser.toUpperCase()) {
                case "SAX": {
                    parser = new SaxXmlParser(paperBuilder);
                    break;
                }
                case "DOM": {
                    parser = new DomXmlParser(paperBuilder);
                    break;
                }
                case "STAX": {
                    parser = new StaxXmlParser(paperBuilder);
                    break;
                }
                default:
                    break;
            }
            parser.parseXmlDocument(pathToXmlDocument);
            result = new Periodicals(paperBuilder.getPeriodicals());

            result.sort();
        }
        return result;
    }
}
