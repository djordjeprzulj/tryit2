package fr.ca.sa.commons.utilFunctions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.commons.sharedEntities.multipart.ImageInfoContainer;

/**
 * Class for implementation of utility function for various handlings of Strings
 * (random, sql...)
 * 
 * @author Nemanja Ignjatov
 *
 */
public class TextUtilFunctions {

	private static final Logger LOGGER = Logger.getLogger(DateUtilFunctions.class);

	private TextUtilFunctions() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * Convert int array to SQL string
	 * 
	 * @param array
	 * @return retString
	 */
	public static String convertIntArrayToSQLString(List<Integer> array) {
		String retString = "()";
		String arrayString = StringUtils.join(array.iterator(), ",");
		retString = new StringBuilder(retString).insert(1, arrayString).toString();

		return retString;
	}

	/**
	 * Generate random string
	 * 
	 * @return random string
	 */
	public static String generateRandomString() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(ProjectConstants.RANDOM_STRING_BASE_130, random)
				.toString(ProjectConstants.RANDOM_STRING_LENGTH_32);
	}

	/**
	 * Generate random token
	 * 
	 * @param length
	 * 			Length of token
	 * @return String that represents random token
	 */
	public static String generateRandomToken(int length) {
		return RandomStringUtils.random(length, true, true);
	}
	
	
	/**
	 * Get image stream from string
	 * 
	 * @param imageString
	 * @return image stream
	 */
	public static InputStream getImageStreamFromString(String imageString) {
		if (imageString != null && imageString.length() > 0) {
			try {
				byte[] decodedImg = null;
				if (imageString.startsWith(ProjectConstants.HEX_PREFIX)) {
					decodedImg = Hex.decodeHex(imageString
							.substring(ProjectConstants.HEX_PREFIX.length(), imageString.length()).toCharArray());
				} else {
					decodedImg = imageString.getBytes();
				}

				InputStream decodedStream = new ByteArrayInputStream(decodedImg);
				ImageInfoContainer imageContainer = new ImageInfoContainer(decodedStream);

				InputStream imgRetStream = null;
				if (imageContainer.getImageContent() != null) {
					ByteArrayOutputStream os = new ByteArrayOutputStream();
					ImageIO.write(imageContainer.getImageContent(), imageContainer.getImageType(), os);
					imgRetStream = new ByteArrayInputStream(os.toByteArray());
				}

				return imgRetStream;
			} catch (DecoderException | IOException ex) {
				LOGGER.error(ex);

				return null;
			}
		} else {

			return null;
		}
	}
	
	/**
	 * Get Input Stream From Hex String
	 * 
	 * @param hex
	 * 				Hex value
	 * 
	 * @return InputStream
	 * 				Returns input stream
	 * 
	 * @throws DecoderException
	 * 				Throws decoder exception
	 */
	public static final InputStream getInputStreamFromHexString(String hex) throws DecoderException {
		InputStream retIS = null;
		if (hex != null) {
			String str = String.valueOf(hex);
			// Cut out Hex prefix from 0x from string
			if (str.startsWith(ProjectConstants.HEX_PREFIX)) {
				str = str.substring(ProjectConstants.HEX_PREFIX.length());
			}

			byte[] bArr = Hex.decodeHex(str.toCharArray());
			ByteArrayInputStream bis = new ByteArrayInputStream(bArr);
			retIS = bis;
		}
		return retIS;
	}

	/**
	 * Get Input Stream For Base64 String
	 * 
	 * @param base64String
	 * 				Base 64 string
	 * 
	 * @return InputStream
	 * 				Returns Input stream
	 * 
	 * @throws IOException
	 * 				Throws IO Exception
	 */
	public static final InputStream getInputStreamForBase64String(String base64String) throws IOException {
		try {
			InputStream retIS = null;
			if (base64String != null) {
				String imageSource = base64String;
				// If base64 string contains description data before image, truncate them
				if (base64String.contains(ProjectConstants.BASE64_IMAGE_DATA_SEPARATOR)) {
					imageSource = base64String.substring(base64String.indexOf(ProjectConstants.BASE64_IMAGE_DATA_SEPARATOR) + 1,
							base64String.length());
				}

				byte[] decodedBytes = Base64.getDecoder().decode(imageSource);
				retIS = new ByteArrayInputStream(decodedBytes);
			}
			return retIS;
		} catch (Exception ex) {
			LOGGER.error(ex);
			throw new IOException(ex.getMessage(), ex.getCause());
		}
	}
	
	/**
	 * Generates a random string - word or number
	 * 
	 * @param type
	 *            - select "word" or "number" to generate desired random string
	 * @param length
	 *            - random string length
	 * @return - return type is string
	 */
	public static final String randomString(String type, int length) {
		char[] chars = {};
		if (type.equals("word")) {
			chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
		}
		if (type.equals("number")) {
			chars = "0123456789".toCharArray();
		}
		StringBuilder sb = new StringBuilder();
		SecureRandom sRandom = new SecureRandom();
		for (int i = 0; i < length; i++) {
			char ch = chars[sRandom.nextInt(chars.length)];
			sb.append(ch);
		}
		return sb.toString();
	}
}
