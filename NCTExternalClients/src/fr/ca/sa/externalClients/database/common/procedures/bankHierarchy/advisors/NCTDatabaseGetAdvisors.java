package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.advisors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting bank advisors
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetAdvisors extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAdvisors.class);

	private String entityCode;

	/**
	 * default constructor for NCT Database Get Advisors
	 */
	public NCTDatabaseGetAdvisors() {
		super();
	}

	/**
	 * NCT Database Get Advisors
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param entityCode
	 * 				Entity code
	 */
	public NCTDatabaseGetAdvisors(Integer userId, String entityCode) {
		super(userId);		
		this.entityCode = entityCode;
	}

	public String getEntityCode() {
		return entityCode;
	}

	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetBankAdvisors ?,?");
		try {
			setUser(ps);
			
			if (this.entityCode != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_2, this.entityCode);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.NVARCHAR);
			}
		} catch (SQLException ex) {
			LOGGER.info(ex);
			ps.close();
		}	
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetAdvisorsNCTResultList retList = new GetAdvisorsNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getAdvisors()
						.add(new GetAdvisorsNCTResultItem(this.getResultSet().getInt("UserId"),
								this.getResultSet().getString("LAST_NAME"), this.getResultSet().getString("FIRST_NAME"),
								this.getResultSet().getString("ENTITY_CODE"), this.getResultSet().getInt("ENTITY_ID"), this.getResultSet().getString("FUNCTION_NAME")));
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
