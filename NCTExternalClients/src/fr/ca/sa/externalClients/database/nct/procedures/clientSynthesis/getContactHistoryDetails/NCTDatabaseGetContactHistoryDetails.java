package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getContactHistoryDetails;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.ClientCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatisticsFailedException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;
import fr.ca.sa.model.Collaborator;
import fr.ca.sa.model.Client;
import fr.ca.sa.model.ContactHistory;
import fr.ca.sa.model.IdName;

/**
 * 
 * Store procedure call for handling contact history details
 * 
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetContactHistoryDetails extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetContactHistoryDetails.class);

	private int clientId;
	private String startTime;
	private String endTime;
	private String dataSource;
	/**
	 * NCT Database Get Contact History Details
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param langId
	 * 				Language ID
	 * 
	 * @param startTime
	 * 				Start time
	 * 
	 * @param endTime
	 * 				End time
	 */
	public NCTDatabaseGetContactHistoryDetails(int userId, int clientId, int langId, String startTime, String endTime, String dataSource) {
		super(userId, langId);
		this.clientId = clientId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.dataSource = dataSource;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetContactHistoryDetailsByClientId ?,?,?,?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.clientId);
			setLanguage(ps, NCTDatabaseConstants.SP_ARG_NR_3);
	
			if (this.startTime != null) {
				ps.setDate(NCTDatabaseConstants.SP_ARG_NR_4, formatDate(this.startTime));
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.DATE);
			}
	
			if (this.endTime != null) {
				ps.setDate(NCTDatabaseConstants.SP_ARG_NR_5, formatDate(this.endTime));
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_5, Types.DATE);
			}
			if (this.dataSource != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_6, this.dataSource);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_6, Types.VARCHAR);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}

		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetContactHistoryDetailsResultList retValue = new GetContactHistoryDetailsResultList();
		try {
			while (this.getResultSet().next()) {
				
				Client client = new Client(this.getResultSet().getInt("ClientId"), null, this.getResultSet().getString("C_L"));
				
				Collaborator advisor = new Collaborator(this.getResultSet().getInt("AdvisorId"), this.getResultSet().getString("AdvisorFirstName"), this.getResultSet().getString("AdvisorLastName"), null);
				
				IdName contactType = new IdName(this.getResultSet().getInt("ContactTypeID"), this.getResultSet().getString("ContactType")); 
				ContactHistory contactHistory = new ContactHistory(this.getResultSet().getInt("ContactId"), contactType, client, advisor);
				
				if (this.getResultSet().getTimestamp("ContactDate") != null) {
					DateFormat df = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
					contactHistory.setContactDate(df.format(this.getResultSet().getTimestamp("ContactDate")));
				}

				contactHistory.setOfferId(this.getResultSet().getInt("OfferId"));
				contactHistory.setOfferType(this.getResultSet().getString("OfferType"));
				contactHistory.setOfferName(this.getResultSet().getString("OfferName"));
				contactHistory.setOfferStatus(this.getResultSet().getString("OfferStatus"));
				contactHistory.setChannelName(this.getResultSet().getString("ChannelName"));
				contactHistory.setOriginName(this.getResultSet().getString("OriginName"));
				contactHistory.setComment(this.getResultSet().getString("Comment"));
				contactHistory.setDataSource(this.getResultSet().getInt("DataSource"));
				
				retValue.getContactHistoryDetails().add(new GetContactHistoryDetailsResultItem(contactHistory));

			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new ClientCRUDException(ErrorConstants.ERROR_MSG_LOAD_CONTACT_HISTORY_DETAILS);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new ClientCRUDException(ErrorConstants.ERROR_MSG_LOAD_CONTACT_HISTORY_DETAILS);
	}

	private Date formatDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.getBackboneOnlyDateDatetimeFormat());

		Date newDate = null;

		java.util.Date tNewDate = null;
		try {
			tNewDate = formatter.parse(date);
		} catch (ParseException ex) {
			throw new StatisticsFailedException(ErrorConstants.ERROR_MSG_LOAD_CONTACT_HISTORY_DETAILS);
		}
		newDate = new Date(tNewDate.getTime());

		return newDate;
	}

}
