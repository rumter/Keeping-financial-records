package ru.rumter.kfr.koala.domain.entity.inc;

import javax.persistence.*;

@Entity
@Table(name = "inc_category")
public class IncCategory {

	/**
     */
	@Id
	@Column(name = "ic_id")
	@SequenceGenerator(name = "inc_category_seq", sequenceName = "inc_category_seq", allocationSize = 1)
    @GeneratedValue(generator = "inc_category_seq")
	private Long id;

	/**
     */
	@Column(name = "title")
	private String title;
}
