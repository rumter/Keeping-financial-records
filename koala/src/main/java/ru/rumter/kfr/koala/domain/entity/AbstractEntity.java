package ru.rumter.kfr.koala.domain.entity;

public abstract class AbstractEntity {

	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
