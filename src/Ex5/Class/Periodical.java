package Ex5.Class;


import Ex5.Enume.Frequency;
import Ex5.Enume.PeriodicalType;

import java.util.Comparator;

public class Periodical {
    private String title;
    private Frequency frequency;
    private PeriodicalType periodicalType;
    private boolean isColor;
    private boolean isGloss;
    private int pages;
    private String index;

    public Periodical() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public void setColor(boolean color) {
        isColor = color;
    }

    public void setGloss(boolean gloss) {
        isGloss = gloss;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public PeriodicalType getPeriodicalType() {
        return periodicalType;
    }

    public void setPeriodicalType(PeriodicalType periodicalType) {
        this.periodicalType = periodicalType;
    }

    @Override
    public String toString() {
        return "Periodical{" +
                "title = '" + title + '\'' +
                ", frequency = " + frequency +
                ", periodicalType = " + periodicalType +
                ", Color = " + isColor +
                ", Gloss = " + isGloss +
                ", pages = " + pages +
                ", index = '" + index + '\'' +
                '}';
    }
}
