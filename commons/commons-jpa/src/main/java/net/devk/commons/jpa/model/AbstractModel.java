package net.devk.commons.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import lombok.Data;
import net.devk.commons.util.date.DateUtils;

@Data
@MappedSuperclass
public abstract class AbstractModel {

	@Column(name = "REGISTER_DATE")
	private Date registerDate;

	@PrePersist
	public void onPrePersist() {
		registerDate = DateUtils.now();
	}

}
