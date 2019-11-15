import Parser.XmlFileValidator;
import org.junit.Assert;
import org.junit.Test;

public class XmlFileValidatorTest {
    @Test
    public void validXMLvalidation(){
        Assert.assertTrue(XmlFileValidator.validateXMLDocument("src/main/resources/test/Periodicals.xml",
                "src/main/resources/Periodicals.xsd"));
    }

    @Test
    public void invalidXMLvalidation(){
        Assert.assertFalse(XmlFileValidator.validateXMLDocument("src/main/resources/test/invalidXmlFile.xml",
                "src/main/resources/Periodicals.xsd"));
    }
}
