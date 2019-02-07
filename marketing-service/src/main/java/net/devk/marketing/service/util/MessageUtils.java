package net.devk.marketing.service.util;

public class MessageUtils {

	private MessageUtils() {
	}

	public static String generateEntityNotFoundMessage(Long id, String entityName) {
		return String.format("Entity %s With id %d not found!", entityName, id);
	}

}
