package Parser.SAX;

import Parser.PaperBuilder;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {
    private PaperBuilder paperBuilder;
    private StringBuilder data;

    public SaxHandler(PaperBuilder paperBuilder){
        this.paperBuilder = paperBuilder;
        data = null;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if(qName.equalsIgnoreCase(paperBuilder.getRootName()))
            paperBuilder.saveElement(qName);
        paperBuilder.setTag(qName, data.toString());
        data = new StringBuilder();
    }


    @Override
    public void characters(char ch[], int start, int length) {
        data.append(new String(ch, start, length));
    }


}