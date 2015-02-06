package ru.rumter.kfr.koala.domain.entity.inc;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "inc_income")
public class Income {

	/**
     */
	@NotNull
	@Column(name = "inc_id")
	private Long id;

	/**
     */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "ic_id")
	private IncCategory incCategory;

	/**
     */
	@NotNull
	@Column(name = "occured")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date occured;

	/**
     */
	@NotNull
	@Column(name = "amount")
	private Long amount;

	/**
     */
	@Column(name = "description")
	private String description;
}
