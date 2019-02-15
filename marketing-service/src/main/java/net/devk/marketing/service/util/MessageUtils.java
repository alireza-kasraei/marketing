package net.devk.marketing.service.util;

import net.devk.marketing.service.EntityNotFoundException;

/**
 * Utility class for generating application wide scope messages
 */
public class MessageUtils {

	private MessageUtils() {
	}

	/**
	 * @param id
	 * @param entityName
	 * @return integrated message for {@link EntityNotFoundException}
	 */
	public static String generateEntityNotFoundMessage(Long id, String entityName) {
		return String.format("Entity %s With id %d not found!", entityName, id);
	}

}
