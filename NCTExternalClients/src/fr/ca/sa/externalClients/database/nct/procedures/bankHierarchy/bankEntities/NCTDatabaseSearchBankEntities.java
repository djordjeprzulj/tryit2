package fr.ca.sa.externalClients.database.nct.procedures.bankHierarchy.bankEntities;

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
import fr.ca.sa.nct.commons.services.json.search.SearchEntityFilter;

/**
 * 
 * Store procedure handler for searching bank entities
 * 
 * @author Milivoj Bozic
 *
 */
public class NCTDatabaseSearchBankEntities extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSearchBankEntities.class);

	private SearchEntityFilter filter;

	/**
	 * default constructor for NCT Database Search Bank Entities
	 */
	public NCTDatabaseSearchBankEntities() {
		super();
	}
	
	/**
	 * NCT Database Search Bank Entities
	 * 
	 * @param userId user id
	 * @param filter filter containing restriction data
	 */
	public NCTDatabaseSearchBankEntities(int userId, SearchEntityFilter filter) {
		super(userId);
		this.filter = filter;
		

		
		
		
		
		
		
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spSearchBankEntities ?,?,?,?,?,?,?,?,?,?");
		try {
			setUser(ps);
	
			if (this.filter.getCityName() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_2, this.filter.getCityName());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.NVARCHAR);
			}
			if (this.filter.getAddress() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.filter.getAddress());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.NVARCHAR);
			}
			if (this.filter.getEntityCode() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.filter.getEntityCode());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.NVARCHAR);
			}
			if (this.filter.getRegion() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_5, this.filter.getRegion());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_5, Types.NVARCHAR);
			}
			if (this.filter.getFirstName() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_6, this.filter.getFirstName());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_6, Types.NVARCHAR);
			}
			if (this.filter.getLastName() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_7, this.filter.getLastName());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_7, Types.NVARCHAR);
			}
			if (this.filter.getFunctionId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_8, this.filter.getFunctionId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_8, Types.NVARCHAR);
			}
			if (this.filter.getEntityTypeId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_9, this.filter.getEntityTypeId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_9, Types.NVARCHAR);
			}
			if (this.filter.getProductGroupId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_10, this.filter.getProductGroupId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_10, Types.NVARCHAR);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}				
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		SearchBankEntitiesNCTResultList retList = new SearchBankEntitiesNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getEntities()
						.add(new SearchBankEntitiesNCTResultItem(this.getResultSet().getInt("ENTITY_ID"),
								this.getResultSet().getString("ENTITY_NAME"), this.getResultSet().getString("CITY"),
								this.getResultSet().getString("ADDRESS"), this.getResultSet().getString("REGION")));
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
