package fr.ca.sa.externalClients.database.core;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;

/**
 * 
 * @author Djordje Przulj
 *
 * Parent class for all store procedure handlers that have user id parameter.
 */
public abstract class AbstractUserStoreProcedureHandler extends AbstractStoreProcedureHandler {

	protected Integer userId;
	
	/**
	 * default constructor for Abstract User Store Procedure Handler
	 */
	public AbstractUserStoreProcedureHandler() {
		super();
	}
	
	/**
	 * Abstract User Store Procedure Handler
	 * 
	 * @param userId
	 * 			User ID
	 */
	public AbstractUserStoreProcedureHandler(Integer userId) {
		super();
		this.userId = userId;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	protected void setUser(PreparedStatement ps) throws SQLException {
		if (this.userId != null) {
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.userId);
		} else {
			ps.setNull(NCTDatabaseConstants.SP_ARG_NR_1, java.sql.Types.INTEGER);
		}		
	}
}
