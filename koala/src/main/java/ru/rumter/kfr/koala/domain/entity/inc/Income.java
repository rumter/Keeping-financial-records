package ru.rumter.kfr.koala.domain.entity.inc;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "inc_income")
public class Income {

	/**
     */
	@Id
	@Column(name = "inc_id")
	@SequenceGenerator(name = "inc_income_seq", sequenceName = "inc_income_seq", allocationSize = 1)
    @GeneratedValue(generator = "inc_income_seq")
	private Long id;

	/**
     */
	@ManyToOne
	@JoinColumn(name = "ic_id")
	private IncCategory incCategory;

	/**
     */
	@Column(name = "occured")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date occured;

	/**
     */
	@Column(name = "amount")
	private Long amount;

	/**
     */
	@Column(name = "description")
	private String description;
}
