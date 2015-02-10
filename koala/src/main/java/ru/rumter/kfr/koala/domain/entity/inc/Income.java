package ru.rumter.kfr.koala.domain.entity.inc;

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

/**
 * Запись доходов
 */
@Entity
@Table(name = "inc_income")
public class Income {

	/**
	 * Идентификатор
	 */
	private Long id;

	/**
	 * Категория доходов
	 */
	private IncCategory incCategory;

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
	@Column(name = "inc_id", nullable = false)
	@SequenceGenerator(name = "inc_income_seq", sequenceName = "inc_income_seq", allocationSize = 1)
	@GeneratedValue(generator = "inc_income_seq")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "ic_id", nullable = false)
	public IncCategory getIncCategory() {
		return incCategory;
	}

	public void setIncCategory(IncCategory incCategory) {
		this.incCategory = incCategory;
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
		Income entity = (Income) obj;
		return new EqualsBuilder().append(id, entity.id).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(id).append(incCategory)
				.append(occured).append(amount).append(description).toString();
	}

}
