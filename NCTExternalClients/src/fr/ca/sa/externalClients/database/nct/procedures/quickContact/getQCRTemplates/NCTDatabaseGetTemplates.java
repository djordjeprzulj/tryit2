package fr.ca.sa.externalClients.database.nct.procedures.quickContact.getQCRTemplates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.QuickContactReportCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetTemplates extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetTemplates.class);

	private Integer messageTemplateTypeId;

	/**
	 * NCT Database Get Templates
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 * 
	 * @param messageTemplateTypeId
	 * 				Message template type ID
	 */
	public NCTDatabaseGetTemplates(Integer userId, Integer langId, Integer messageTemplateTypeId) {
		super(userId, langId);
		this.messageTemplateTypeId = messageTemplateTypeId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetMessageTemplates ?,?,?");
		try {
			setUserAndLanguage(ps);	
			if (this.messageTemplateTypeId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.messageTemplateTypeId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, java.sql.Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		QuickContactReportTemplateItemList retList = new QuickContactReportTemplateItemList();

		try {
			while (this.getResultSet().next()) {

				retList.getTemplateList()
						.add(new QuickContactReportTemplateItem(this.getResultSet().getInt("MessageTemplateId"),
								this.getResultSet().getString("MessageTemplateName"),
								this.getResultSet().getString("MessageTemplateText"),
								this.getResultSet().getInt("MessageTemplateTypeId"),this.getResultSet().getInt("ReadOnly")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new QuickContactReportCRUDException(ErrorConstants.ERROR_MSG_GET_QCR_CONFIGURATION);
		}

		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new QuickContactReportCRUDException(ErrorConstants.ERROR_MSG_GET_QCR_CONFIGURATION);
	}

}
