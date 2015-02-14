package ru.rumter.kfr.koala.domain.criteria;

public class Sort {

	private String field;
	private SortDirectionEnum direction;

	public Sort(String field) {
		this.field = field;
		this.direction = SortDirectionEnum.ASC;
	}

	public Sort(String field, SortDirectionEnum direction) {
		this.field = field;
		this.direction = direction;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public SortDirectionEnum getDirection() {
		return direction;
	}

	public void setDirection(SortDirectionEnum direction) {
		this.direction = direction;
	}

}
