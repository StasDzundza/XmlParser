package Periodicals;

public class Paper implements Comparable {
    private String title;
    private Type paperType;
    private boolean monthly;
    private Chars chars;

    public Paper() {
        chars = new Chars();
    }

    @Override
    public int compareTo(Object o) {
        return title.compareTo(((Paper) o).getTitle());
    }

    @Override
    public String toString() {
        return "\nPaper{ "
                + "\n\tTitle: " + title
                + ", \n\tType: " + paperType
                + ", \n\tMonthly: " + ((monthly) ? "Yes" : "No")
                + ", \n\tChars: " + chars
                + "\n}";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paper)) return false;
        Paper p = (Paper) o;
        return title.equals(p.getTitle())
                && paperType.equals(p.getType())
                && monthly == p.getMonthly()
                && chars.equals(p.getChars());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return paperType;
    }

    public void setType(Type type) {
        paperType = type;
    }

    public boolean getMonthly() {
        return monthly;
    }

    public void setMonthly(boolean monthly) {
        this.monthly = monthly;
    }

    public Chars getChars() {
        return chars;
    }

    public void setChars(Chars chars) {
        this.chars = chars;
    }
}
