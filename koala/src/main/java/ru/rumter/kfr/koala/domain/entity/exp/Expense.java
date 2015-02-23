package ru.rumter.kfr.koala.domain.entity.exp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import ru.rumter.kfr.koala.domain.entity.AbstractEntity;

/**
 * Запись расходов
 */
@Entity
@Table(name = "exp_expense")
public class Expense extends AbstractEntity {

	private Long id;

	/**
	 * Дата проведения
	 */
	private Date occured;

	/**
	 * Сумма
	 */
	private Long amount;

	/**
	 * Описание
	 */
	private String description;

	@Id
	@Column(name = "exp_id", nullable = false)
	@SequenceGenerator(name = "exp_expense_seq", sequenceName = "exp_expense_seq", allocationSize = 1)
	@GeneratedValue(generator = "exp_expense_seq")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "occured", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getOccured() {
		return occured;
	}

	public void setOccured(Date occured) {
		this.occured = occured;
	}

	@Column(name = "amount", nullable = false)
	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}
		Expense entity = (Expense) obj;
		return new EqualsBuilder().append(id, entity.id).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(id).append(occured).append(amount).append(description).toString();
	}

}
