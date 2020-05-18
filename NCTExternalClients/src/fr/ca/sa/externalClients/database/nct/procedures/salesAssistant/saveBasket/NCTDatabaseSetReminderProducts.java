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

/**
 * 
 * Store procedure for setting not reminder project for specific basket
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseSetReminderProducts extends AbstractUserBasketStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetReminderProducts.class);
	
	private Integer productId;

	private String cL;

	private Integer clientId;

	private Integer advisorEntityId;

	private Integer advisorId;

	private Timestamp targetDate;

	private String comment;

	private int langId; 
	
	private Integer opportunityId;

	/**
	 * NCT Database Set Reminder Products
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param basketId
	 * 				Basket ID
	 * 
	 * @param productId
	 * 				Product ID
	 * 
	 * @param cL
	 * 				Client
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param advisorEntityId
	 * 				Advisor entity ID
	 * 
	 * @param advisorId
	 * 				Advisor ID
	 * 
	 * @param targetDate
	 * 				Target date
	 * 
	 * @param comment
	 * 				Comment
	 * 
	 * @param langId
	 * 				Language ID
	 * 
	 * @throws ParseException
	 * 				Throws parse exception
	 */
	public NCTDatabaseSetReminderProducts(int userId, Integer basketId, Integer productId, String cL, Integer clientId,
			Integer advisorEntityId, Integer advisorId, String targetDate, String comment, int langId, Integer opportunityId)
			throws ParseException {
		super(userId, basketId);
		this.productId = productId;
		this.cL = cL;
		this.clientId = clientId;
		this.advisorEntityId = advisorEntityId;
		this.advisorId = advisorId;
		SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.getBackboneOnlyDateDatetimeFormat());
		this.targetDate = new Timestamp(formatter.parse(targetDate).getTime());
		this.comment = comment;
		this.langId = langId;
		this.opportunityId = opportunityId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement cs = connection.prepareStatement("exec spSetSalAssOfferRemindedList ?,?,?,?,?,?,?,?,?,?,?");
		try {
			setUser(cs);
			cs.setString(NCTDatabaseConstants.SP_ARG_NR_2, this.cL);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.clientId);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.advisorEntityId);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.advisorId);
			setBasket(cs, NCTDatabaseConstants.SP_ARG_NR_6);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_7, this.productId);
			cs.setTimestamp(NCTDatabaseConstants.SP_ARG_NR_8, this.targetDate);
			if (this.comment != null && !this.comment.isEmpty()) {
				cs.setString(NCTDatabaseConstants.SP_ARG_NR_9, this.comment);
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_9, Types.VARCHAR);
			}
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_10, this.langId);
			if (this.opportunityId != null) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_11, this.opportunityId);
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_11, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}																		
		return cs;
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
