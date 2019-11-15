import Parser.PaperBuilder;
import Parser.PeriodicalsParser;
import Periodicals.Chars;
import Periodicals.Paper;
import Periodicals.Periodicals;
import Periodicals.Type;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    PeriodicalsParser periodicalParser;
    Paper magazine;
    Paper newspaper;

    public ParserTest(){
        periodicalParser = new PeriodicalsParser();
        magazine = new Paper();
        newspaper = new Paper();

        magazine.setTitle("First");
        magazine.setMonthly(true);
        magazine.setType(Type.valueOf("Magazine"));
        magazine.setChars(new Chars(true,100,true));

        newspaper.setTitle("Second");
        newspaper.setMonthly(false);
        newspaper.setType(Type.valueOf("Newspaper"));
        newspaper.setChars(new Chars(true,15,false));
    }

    @Test
    public void DOMParserTest() throws ParserConfigurationException, XMLStreamException, SAXException, IOException {
        periodicalParser.setTypeOfParser("DOM");
        Periodicals periodicals = periodicalParser.parseXmlDocument("src/main/resources/test/Periodicals.xml",
                "src/main/resources/Periodicals.xsd");
        assertEquals(periodicals.getPeriodicals().get(1), newspaper);
        assertEquals(periodicals.getPeriodicals().get(0), magazine);
    }

    @Test
    public void SAXParserTest() throws ParserConfigurationException, XMLStreamException, SAXException, IOException {
        periodicalParser.setTypeOfParser("SAX");
        Periodicals periodicals = periodicalParser.parseXmlDocument("src/main/resources/test/Periodicals.xml",
                "src/main/resources/Periodicals.xsd");
        assertEquals(periodicals.getPeriodicals().get(1), newspaper);
        assertEquals(periodicals.getPeriodicals().get(0), magazine);
    }

    @Test
    public void StaxParserTest() throws ParserConfigurationException, XMLStreamException, SAXException, IOException {
        periodicalParser.setTypeOfParser("STAX");
        Periodicals periodicals = periodicalParser.parseXmlDocument("src/main/resources/test/Periodicals.xml",
                "src/main/resources/Periodicals.xsd");
        assertEquals(periodicals.getPeriodicals().get(1), newspaper);
        assertEquals(periodicals.getPeriodicals().get(0), magazine);
    }

    @Test
    public void XMLHandlerTest(){
        PaperBuilder builder = new PaperBuilder();
        builder.setTag("title", "First");
        builder.setTag("type", "Magazine");
        builder.setTag("monthly", "true");
        builder.setTag("colored","true");
        builder.setTag("size", "100");
        builder.setTag("glossy", "true");
        builder.saveElement("paper");

        builder.setTag("title", "Second");
        builder.setTag("type", "Newspaper");
        builder.setTag("monthly", "false");
        builder.setTag("colored","true");
        builder.setTag("size", "15");
        builder.setTag("glossy", "false");
        builder.saveElement("paper");

        assertEquals(magazine, builder.getPeriodicals().get(0));
        assertEquals(newspaper, builder.getPeriodicals().get(1));
    }
}