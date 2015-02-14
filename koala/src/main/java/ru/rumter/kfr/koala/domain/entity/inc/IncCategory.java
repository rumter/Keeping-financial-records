package ru.rumter.kfr.koala.domain.entity.inc;

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
 * Категория доходов
 */
@Entity
@Table(name = "inc_category")
public class IncCategory extends AbstractEntity {

	private Long id;

	/**
	 * Заголовок
	 */
	private String title;

	@Id
	@Column(name = "ic_id", nullable = false)
	@SequenceGenerator(name = "inc_category_seq", sequenceName = "inc_category_seq", allocationSize = 1)
	@GeneratedValue(generator = "inc_category_seq")
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
		IncCategory entity = (IncCategory) obj;
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
