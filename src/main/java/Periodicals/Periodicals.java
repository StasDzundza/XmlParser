package Periodicals;

import Parser.DomXmlParser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class Periodicals {
    private List<Paper> periodicals;
    private Logger log = Logger.getLogger(DomXmlParser.class.getName());

    public Periodicals(List<Paper> periodicals) {
        this.periodicals = periodicals;
    }

    public void sort() {
        Collections.sort(periodicals);
    }

    @Override
    public String toString() {
        String string = "";
        for (Paper paper : periodicals) {
            string += paper;
        }
        return string;
    }

    public void writeInFile(String fileName){
        try(FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(toString());
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

    public List<Paper> getPeriodicals() {
        return periodicals;
    }

}