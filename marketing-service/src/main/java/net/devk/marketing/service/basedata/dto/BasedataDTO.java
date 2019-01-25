package net.devk.marketing.service.basedata.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Base data as id,name pair
 */
//TODO FIXME add code property for all base data
@Data
@RequiredArgsConstructor
public class BasedataDTO {

	private final Long id;
	private final String name;

}
