package Periodicals;

public class Chars {
    private boolean colored;
    private int size;
    private boolean glossy;

    public Chars() {
    }

    public Chars(boolean colored, int size, boolean glossy) {
        this.colored = colored;
        this.size = size;
        this.glossy = glossy;
    }

    @Override
    public String toString() {
        return "{number of pages : " + size
                + ", colored: " + (colored ? "yes" : "no")
                + ", glossy: " + (glossy ? "yes" : "no")
                + '}';

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Chars)) {
            return false;
        }

        Chars chars = (Chars) o;
        return colored == chars.isColored()
                && glossy == chars.isGlossy()
                && size == chars.getSize();
    }


    public boolean isColored() {
        return colored;
    }

    public void setColored(boolean colored) {
        this.colored = colored;
    }

    public boolean isGlossy() {
        return glossy;
    }

    public void setGlossy(boolean glossy) {
        this.glossy = glossy;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
