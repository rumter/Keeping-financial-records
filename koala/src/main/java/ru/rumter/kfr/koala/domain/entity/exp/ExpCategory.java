package ru.rumter.kfr.koala.domain.entity.exp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "exp_category")
public class ExpCategory {

	/**
     */
	@NotNull
	@Column(name = "ec_id")
	private Long id;

	/**
     */
	@NotNull
	@Column(name = "title")
	private String title;
}
