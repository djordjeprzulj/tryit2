package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankEntities;

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
 * Store procedure handler for getting bank entities
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetBankEntities extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetBankEntities.class);

	private int bankId;
	private int levelId;
	private String parentEntityCode;

	/**
	 * default constructor for NCT Database Get Bank Entities
	 */
	public NCTDatabaseGetBankEntities() {
		super();
	}

	/**
	 * NCT Database Get Bank Entities
	 * 
	 * @param userId
	 *            User ID
	 * 
	 * @param bankId
	 *            Bank ID
	 * 
	 * @param levelId
	 *            Level ID
	 * 
	 * @param parentEntityCode
	 *            Parent entity code
	 */
	public NCTDatabaseGetBankEntities(Integer userId, int bankId, int levelId, String parentEntityCode) {
		super(userId);
		this.bankId = bankId;
		this.levelId = levelId;
		this.parentEntityCode = parentEntityCode;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetBankEntities ?,?,?,?");
		try {
			setUser(ps);

			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.bankId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.levelId);
			if (this.parentEntityCode != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.parentEntityCode);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.NVARCHAR);
			}
		} catch (SQLException ex) {
			LOGGER.info(ex);
			ps.close();
		}			
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetBankEntitiesNCTResultList retList = new GetBankEntitiesNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getEntities().add(new GetBankEntitiesNCTResultItem(this.getResultSet().getInt("ENTITY_ID"),
						this.getResultSet().getString("ENTITY_CODE"), this.getResultSet().getString("ENTITY_NAME"),
						this.getResultSet().getString("PARENT_CODE"), this.getResultSet().getInt("LEVEL")));
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

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public String getParentEntityCode() {
		return parentEntityCode;
	}

	public void setParentEntityCode(String parentEntityCode) {
		this.parentEntityCode = parentEntityCode;
	}

}
