package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.saveBasket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.SalesAssistantCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket.AbstractUserBasketStoreProcedureHandler;
import fr.ca.sa.model.Collaborator;
import fr.ca.sa.model.Client;

/**
 * 
 * Store procedure for setting project details on created basket
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseSetProjectDetails extends AbstractUserBasketStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetProjectDetails.class);
	
	private Client client;

	private Collaborator advisor;

	private Integer categoryId;

	private Double amount;

	private Integer currencyId;

	private Timestamp targetDate;

	private String comment;

	private Integer needCategoryId;

	/**
	 * NCT Database Set Project Details
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param client
	 * 				Client
	 *  
	 * @param advisor
	 * 				Advisor
	 * 
	 * @param categoryId
	 * 				Category ID
	 * 
	 * @param amount	
	 * 				Amount
	 * 
	 * @param currencyId
	 * 				Currency ID
	 * 
	 * @param targetDate
	 * 				Target date
	 * 
	 * @param comment
	 * 				Comment
	 * 
	 * @param needCategoryId
	 * 				Need category ID
	 * 
	 * @throws ParseException
	 * 				Throws parse exception
	 */
	public NCTDatabaseSetProjectDetails(int userId, Integer basketId, Client client,
			Collaborator advisor, Integer categoryId, Double amount, Integer currencyId,
			String targetDate, String comment, Integer needCategoryId) throws ParseException {
		super(userId, basketId);
		this.client = client;
		this.advisor = advisor;
		this.categoryId = categoryId;
		this.amount = amount;
		this.currencyId = currencyId;
		SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.getBackboneOnlyDateDatetimeFormat());
		this.targetDate = new Timestamp(formatter.parse(targetDate).getTime());
		this.comment = comment;
		this.needCategoryId = needCategoryId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spSetSalAssProjectDetails ?,?,?,?,?,?,?,?,?,?,?,?");
		try {		
			setUserAndBasket(ps);
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.client.getClientOrLead());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.client.getId());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.advisor.getPrimaryEntity().getId());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_6, this.advisor.getId());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_7, this.categoryId);
			if (this.amount != null && this.amount != -1) {
				ps.setDouble(NCTDatabaseConstants.SP_ARG_NR_8, this.amount);
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_9, this.currencyId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_8, Types.DOUBLE);
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_9, Types.INTEGER);
			}
			ps.setTimestamp(NCTDatabaseConstants.SP_ARG_NR_10, this.targetDate);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_11, this.needCategoryId);
			if (this.comment != null && !this.comment.isEmpty()) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_12, this.comment);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_12, Types.VARCHAR);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}														
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		return null;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_SAVE_BASKET);
	}

}
