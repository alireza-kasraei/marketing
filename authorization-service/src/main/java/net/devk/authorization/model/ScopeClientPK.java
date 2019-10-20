package net.devk.authorization.model;

import java.io.Serializable;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ScopeClientPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Long scope;
	private final Long client;

}
