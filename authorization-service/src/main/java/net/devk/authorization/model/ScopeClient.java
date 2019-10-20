package net.devk.authorization.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.devk.commons.jpa.model.AbstractModel;

@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "SCOPES_CLIENTS")
@IdClass(ScopeClientPK.class)
public class ScopeClient extends AbstractModel {

	@Id
	@ManyToOne
	@JoinColumn(name = "SCOPE_ID")
	private Scope scope;

	@Id
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;

	@Column(name = "AUTO_APPROVED")
	private Boolean autoApproved;

}
