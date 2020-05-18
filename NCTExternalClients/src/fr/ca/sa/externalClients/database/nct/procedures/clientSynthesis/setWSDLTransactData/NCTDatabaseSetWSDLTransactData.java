package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.setWSDLTransactData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.ClientCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.exceptions.databaseExceptions.UnknownUserException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;
import fr.ca.sa.nct.commons.commonEntities.WSDLTransactionData;

/**
 * 
 * Store procedure handler for setting information got from WSDL for client
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseSetWSDLTransactData extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetWSDLTransactData.class);

	private WSDLTransactionData transData;

	/**
	 * NCT Database Set WSDL Transaction Data
	 * 
	 * @param transData
	 * 				Transaction data
	 */
	public NCTDatabaseSetWSDLTransactData(WSDLTransactionData transData) {
		this.transData = transData;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement cs = connection.prepareStatement("exec spSetTransactCS ?,?,?,?,?,?");
		try {
			if (this.transData.getTransactId() != null) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.transData.getTransactId());
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_1, java.sql.Types.INTEGER);
			}
	
			if (this.transData.getCollaboratorId() != null) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.transData.getCollaboratorId());
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_2, java.sql.Types.INTEGER);
			}
	
			if (this.transData.getClientId() != null) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.transData.getClientId());
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_3, java.sql.Types.INTEGER);
			}
	
			if (this.transData.getStartSessionDate() != null) {
				cs.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.transData.getStartSessionDate());
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_4, java.sql.Types.VARCHAR);
			}
	
			if (this.transData.getEndSessionDate() != null) {
				cs.setString(NCTDatabaseConstants.SP_ARG_NR_5, this.transData.getEndSessionDate());
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_5, java.sql.Types.VARCHAR);
			}
	
	
			if (this.transData.getErrorDescription() != null) {
				cs.setString(NCTDatabaseConstants.SP_ARG_NR_6, this.transData.getErrorDescription());
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_6, java.sql.Types.VARCHAR);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}

		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		StoreProcedureResult retValue = null;
		try {
			while (this.getResultSet().next()) {
				retValue = new SetWSDLTransactDataNCTResult(this.getResultSet().getInt("transact_id"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new ClientCRUDException();
		}

		if (retValue == null) {
			throw new UnknownUserException();
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new ClientCRUDException();
	}
}
