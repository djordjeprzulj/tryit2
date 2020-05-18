package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.setCodeTableOppCatAction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.CodeTablesCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.sharedEntities.codeTables.SetCodeTableOppCatActionRequest;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseSetCodeTableOppCatAction extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetCodeTableOppCatAction.class);
	
	private SetCodeTableOppCatActionRequest req;

	/**
	 * NCT Database Set CodeTable Opportunity Category Action
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param req
	 * 				Request
	 */
	public NCTDatabaseSetCodeTableOppCatAction(Integer userId, SetCodeTableOppCatActionRequest req) {
		super(userId);
		this.req = req;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException {		
		CallableStatement cs = connection.prepareCall("exec spSetOppCatAction ?,?,?,?,?,?");
		try {
			setUser(cs);
			if (this.req.getOpportunityCategoryId() != null) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.req.getOpportunityCategoryId());
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
			if (this.req.getCancel() != null) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.req.getCancel());
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.INTEGER);
			}
			if (this.req.getTreatOnOppList() != null) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.req.getTreatOnOppList());
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.INTEGER);
			}
			if (this.req.getTreatOnQCR() != null) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.req.getTreatOnQCR());
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_5, Types.INTEGER);
			}
			if (this.req.getExpire() != null) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_6, this.req.getExpire());
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_6, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}
		return cs;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new CodeTablesCRUDException(ErrorConstants.ERROR_MSG_SET_CODE_TABLE_DATA);

	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		return null;
	}
}
