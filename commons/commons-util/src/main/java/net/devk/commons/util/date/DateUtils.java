package net.devk.commons.util.date;

import java.util.Calendar;
import java.util.Date;

/**
 * Date utility class
 */
public final class DateUtils {

    private DateUtils() {
    }

    /**
     * @return current Date
     */
    public static Date now() {
        return new Date();
    }

    /**
     * @param date
     * @return date
     * convert date to midday date for Contradiction
     *
     */
    public static Date convertToMidday(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        return instance.getTime();
    }

    /**
     * @param date
     * @return date
     * convert date to midnight date for Contradiction
     */
    public static Date convertToMidnight(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(Calendar.HOUR_OF_DAY, 23);
        instance.set(Calendar.MINUTE, 59);
        instance.set(Calendar.SECOND, 59);
        instance.set(Calendar.HOUR_OF_DAY, 999);
        return instance.getTime();

    }

}
