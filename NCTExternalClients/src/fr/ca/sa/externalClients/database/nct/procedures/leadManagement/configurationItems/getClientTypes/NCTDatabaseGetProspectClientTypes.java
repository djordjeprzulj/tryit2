package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.configurationItems.getClientTypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.externalClients.database.nct.procedures.leadManagement.configurationItems.LeadManagementNCTExtendedResultItem;
import fr.ca.sa.externalClients.database.nct.procedures.leadManagement.configurationItems.LeadManagementNCTExtendedResultList;

/**
 * 
 * Store procedure call for retrieving prospect client types
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetProspectClientTypes extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetProspectClientTypes.class);

	/**
	 * NCT Database Get Prospect Client Code Types
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetProspectClientTypes(Integer userId) {
		super(userId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetProspectClientTypes ?");
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
		LeadManagementNCTExtendedResultList retList = new LeadManagementNCTExtendedResultList();

		try {
			while (this.getResultSet().next()) {
				retList.getExtendedList()
						.add(new LeadManagementNCTExtendedResultItem(this.getResultSet().getInt("TypeId"),
								this.getResultSet().getString("TypeName"), this.getResultSet().getInt("isIndividual")));
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
