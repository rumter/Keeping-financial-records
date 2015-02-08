package ru.rumter.kfr.koala.domain.entity.exp;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "exp_expense")
public class Expense {

	/**
     */
	@Id
	@Column(name = "exp_id")
	@SequenceGenerator(name = "exp_expense_seq", sequenceName = "exp_expense_seq", allocationSize = 1)
    @GeneratedValue(generator = "exp_expense_seq")
	private Long id;

	/**
     */
	@ManyToOne
	@JoinColumn(name = "ec_id")
	private ExpCategory expCategory;

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
