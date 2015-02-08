package ru.rumter.kfr.koala.domain.entity.exp;

import javax.persistence.*;

@Entity
@Table(name = "exp_category")
public class ExpCategory {

	/**
     */
	@Id
	@Column(name = "ec_id")
	@SequenceGenerator(name = "exp_category_seq", sequenceName = "exp_category_seq", allocationSize = 1)
    @GeneratedValue(generator = "exp_category_seq")
	private Long id;

	/**
     */
	@Column(name = "title")
	private String title;
}
