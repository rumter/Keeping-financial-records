package ru.rumter.kfr.koala.domain.criteria;

/**
 * Criteria supports paging
 * 
 * @author Ilya
 *
 */
public class PageableCriteria implements Criteria {

	private long start;
	private long count;
	private Sort sort;

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

}
