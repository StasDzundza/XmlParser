package Parser;

import Periodicals.Paper;
import Periodicals.Type;

import java.util.ArrayList;
import java.util.List;


public class PaperBuilder{
    private Paper paper;
    private List<Paper> periodicals;
    private String rootName;

    public PaperBuilder() {
        paper = new Paper();
        periodicals = new ArrayList<>();
        rootName = "Paper";
    }

    public Paper getPaper(){
        return paper;
    }

    public List<Paper> getPeriodicals(){
        return periodicals;
    }

    public String getRootName(){
        return rootName;
    }

    public void setTag(String tag, String value){
        switch (tag.toLowerCase()){
            case "paper":
                paper = new Paper();
            case "title":
                paper.setTitle(value);
                break;
            case "type":
                paper.setType(Type.valueOf(value));
                break;
            case "monthly":
                paper.setMonthly(Boolean.parseBoolean(value));
                break;
            case "colored":
                paper.getChars().setColored(Boolean.parseBoolean(value));
                break;
            case "size":
                paper.getChars().setSize(Integer.parseInt(value));
                break;
            case "glossy":
                paper.getChars().setGlossy(Boolean.parseBoolean(value));
                break;
            default:
                break;
        }
    }

    public void saveElement(String element){
        if(element.equalsIgnoreCase("paper")) {
            periodicals.add(paper);
            paper = new Paper();
        }
    }
}