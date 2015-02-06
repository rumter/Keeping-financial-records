package ru.rumter.kfr.koala.domain.entity.inc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "inc_category")
public class IncCategory {

	/**
     */
	@NotNull
	@Column(name = "ic_id")
	private Long id;

	/**
     */
	@NotNull
	@Column(name = "title")
	private String title;
}
