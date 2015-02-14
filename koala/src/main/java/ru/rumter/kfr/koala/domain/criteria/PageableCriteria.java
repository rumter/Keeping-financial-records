package ru.rumter.kfr.koala.domain.criteria;

/**
 * Criteria supports paging
 * 
 * @author Ilya
 *
 */
public class PageableCriteria implements Criteria {

	private int start;
	private int count;
	private Sort sort;

	public PageableCriteria() {
		start = 0;
		count = 0;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

}
