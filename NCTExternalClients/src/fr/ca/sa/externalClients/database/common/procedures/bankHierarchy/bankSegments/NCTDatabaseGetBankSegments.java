package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankSegments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting bank segments
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetBankSegments extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetBankSegments.class);

	/**
	 * default constructor for NCT Database Get Bank Segments
	 */
	public NCTDatabaseGetBankSegments() {
		super();
	}

	/**
	 * NCT Database Get Bank Segments
	 * 
	 * @param userId
	 *            User ID
	 */
	public NCTDatabaseGetBankSegments(Integer userId) {
		super(userId);
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetBankSegments ?");
		try {
			setUser(ps);			
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}		
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetBankSegmentsNCTResultList retList = new GetBankSegmentsNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getSegments().add(new GetBankSegmentsNCTResultItem(this.getResultSet().getInt("SEGMENT_ID"),
						this.getResultSet().getString("SEGMENT_NAME"), this.getResultSet().getInt("isPROSPECT")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}
		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}
}
