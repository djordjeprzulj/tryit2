package fr.ca.sa.externalClients.database.nctManagement.procedures.bankParameters.setBankParameters;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import javax.imageio.ImageIO;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.ParametersCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.sharedEntities.multipart.ImageInfoContainer;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store procedure handler for setting bank parameters
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseSetBankParameters extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetBankParameters.class);

	private int bankId;
	private InputStream logoPicture;

	SetBankParametersNCTResultListImages retValue = new SetBankParametersNCTResultListImages();

	/**
	 * NCT Database Set Bank Parameters
	 *  
	 * @param userId
	 * 				User ID
	 * 
	 * @param bankId
	 * 				Bank ID
	 * 
	 * @param logoPicture
	 * 				Logo picture
	 */
	public NCTDatabaseSetBankParameters(int userId, int bankId, InputStream logoPicture) {
		super(userId);
		this.bankId = bankId;
		this.logoPicture = logoPicture;

		try {
			ImageInfoContainer imageContainer = new ImageInfoContainer(this.logoPicture);
			retValue.getImagesMapByName(SetBankParametersNCTResultListImages.LOGO_PIC_NAME).put(String.valueOf(bankId), imageContainer);

			// Rewrite image into stream
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(imageContainer.getImageContent(), imageContainer.getImageType(), os);
			this.logoPicture = new ByteArrayInputStream(os.toByteArray());
		} catch (IOException ex) {
			LOGGER.error(ex);
			throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_SET_BANK_PARAMETERS);
		}

	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException {
		CallableStatement cs = connection.prepareCall("exec spSetBankParameters ?,?,?");
		try {
			setUser(cs);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.bankId);
	
			if (this.logoPicture != null) {
				cs.setBinaryStream(NCTDatabaseConstants.SP_ARG_NR_3, this.logoPicture);
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.VARBINARY);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}
		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		try {
			this.logoPicture.close();
		} catch (IOException ex) {
			LOGGER.error(ex);
			throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_SET_BANK_PARAMETERS);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_SET_BANK_PARAMETERS);
	}
}
