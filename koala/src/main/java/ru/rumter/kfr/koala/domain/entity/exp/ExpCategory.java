package ru.rumter.kfr.koala.domain.entity.exp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import ru.rumter.kfr.koala.domain.entity.AbstractEntity;

/**
 * Категория расходов
 */
@Entity
@Table(name = "exp_category")
public class ExpCategory extends AbstractEntity {

	private Long id;

	/**
	 * Заголовок
	 */
	private String title;

	@Id
	@Column(name = "ec_id", nullable = false)
	@SequenceGenerator(name = "exp_category_seq", sequenceName = "exp_category_seq", allocationSize = 1)
	@GeneratedValue(generator = "exp_category_seq")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}
		ExpCategory entity = (ExpCategory) obj;
		return new EqualsBuilder().append(id, entity.id).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(id).append(title).toString();
	}

}
