package fr.ca.sa.commons.utilFunctions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * Class for implementation of utility function for various handlings of Date information
 * 
 * @author Nemanja Ignjatov
 *
 */
public class DateUtilFunctions {

	private static final Logger LOGGER = Logger.getLogger(DateUtilFunctions.class);
	
	private DateUtilFunctions() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * @param dateTime - String formatted time
	 * @return XMLGregorianCalendar - POJO Time object
	 * 
	 * Convert String date to XMLGregorianCalendar
	 */
	public static XMLGregorianCalendar stringToXMLGregorianCalendar(String dateTime) {
		DateFormat format = new SimpleDateFormat(ProjectConstants.DATETIME_FORMAT_FULL);
		GregorianCalendar calendar = new GregorianCalendar();

		try {
			Date date = format.parse(dateTime);
			calendar.setTime(date);
		} catch (ParseException ex) {
			LOGGER.error(ex);
		}

		XMLGregorianCalendar xmlDate;
		try {
			xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
			return xmlDate;
		} catch (DatatypeConfigurationException ex) {
			LOGGER.error(ex);
		}
		return null;
	}
	
	/**
	 * Check valid date format
	 * 
	 * @param format
	 * @param value
	 * @return date
	 */
	public static boolean isValidDateFormat(String format, String value) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(value);
			if (!value.equals(sdf.format(date))) {
				date = null;
			}
		} catch (ParseException ex) {
			LOGGER.error(ex);

			return false;
		}
		return date != null;
	}
}
