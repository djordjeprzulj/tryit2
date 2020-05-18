package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getGeneralClientInfo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.ClientCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.exceptions.databaseExceptions.UnknownUserException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.model.Client;
import fr.ca.sa.nct.commons.services.json.client.ClientGeneralInfoRequest;

/**
 * 
 * Store procedure handler for getting basic user information from DB
 * 
 * @author Nemanja Ignjatov
 *
 * @author Djordje Przulj
 * 
 */
public class NCTDatabaseGetClientGeneralInfo extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetClientGeneralInfo.class);

	private ClientGeneralInfoRequest req;

	/**
	 * NCT Database Get Client General Info
	 * 
	 * @param req
	 * 				Request
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetClientGeneralInfo(ClientGeneralInfoRequest req, int userId) {
		super(userId);
		this.req = req;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetClientSintHeadByClientId ?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.req.getClientId());
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}

		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		StoreProcedureResult retValue = null;
		try {
			while (this.getResultSet().next()) {
				Date birthDate = this.getResultSet().getDate("BirthDate");
				String strBirthDate = null;
				if (birthDate != null) {
					DateFormat df = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
					strBirthDate = df.format(birthDate);
				}

				Client client = new Client(this.getResultSet().getInt("ClientId"), null, null);
				client.setCode(this.getResultSet().getString("ClientCode"));
				client.setIdExt(this.getResultSet().getLong("ClientIdCore"));
				client.setName(this.getResultSet().getString("Name"));
				client.setLastName(this.getResultSet().getString("Surname"));
				client.setNumberOfYears(this.getResultSet().getInt("NumberOfYears"));
				client.setEmail(this.getResultSet().getString("Email"));
				client.setMobilePhone(this.getResultSet().getString("MobilePhone"));
				client.setContactPriority(this.getResultSet().getInt("ContactPriority"));
				client.setAccountNumber(this.getResultSet().getString("AccountNumber"));
				client.setBirthDate(strBirthDate);
						
				retValue = new GetClientGeneralInfoNCTResult(client);						
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new ClientCRUDException(ErrorConstants.ERROR_MSG_GET_USER_INFO);
		}

		if (retValue == null) {
			throw new UnknownUserException();
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new ClientCRUDException(ErrorConstants.ERROR_MSG_GET_USER_INFO);
	}
}
