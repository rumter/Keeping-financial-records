package ru.rumter.kfr.koala.domain.criteria;

public class Sort {

    private String property;
    private SortDirectionEnum direction;

    public Sort() {
    }

    public Sort(String property) {
        this.property = property;
        this.direction = SortDirectionEnum.ASC;
    }

    public Sort(String property, SortDirectionEnum direction) {
        this.property = property;
        this.direction = direction;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public SortDirectionEnum getDirection() {
        return direction;
    }

    public void setDirection(SortDirectionEnum direction) {
        this.direction = direction;
    }

}
