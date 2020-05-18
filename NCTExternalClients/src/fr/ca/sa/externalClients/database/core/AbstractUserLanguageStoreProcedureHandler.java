package fr.ca.sa.externalClients.database.core;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;

/**
 * 
 * @author Djordje Przulj
 *
 * Parent class for all store procedure handlers that have user id and language id parameters.
 */
public abstract class AbstractUserLanguageStoreProcedureHandler extends AbstractUserStoreProcedureHandler {

	protected Integer langId;
	
	/**
	 * default constructor for Abstract User Language Store Procedure Handler 
	 */
	public AbstractUserLanguageStoreProcedureHandler() {
		super();		
	}	
	
	/**
	 * Abstract User Language Store Procedure Handler
	 * 
	 * @param userId
	 * 			User ID
	 * 
	 * @param langId
	 * 			Language ID
	 */
	public AbstractUserLanguageStoreProcedureHandler(Integer userId, Integer langId) {
		super(userId);		
		this.langId = langId;
	}
	
	/**
	 * Sets first parameter to userId and second parameter to langId
	 * 
	 * @param ps
	 * @throws SQLException
	 */
	protected void setUserAndLanguage(PreparedStatement ps) throws SQLException {
		setUser(ps);
		setLanguage(ps, NCTDatabaseConstants.SP_ARG_NR_2);
	}
	
	protected void setLanguage(PreparedStatement ps, int index) throws SQLException {
		if (this.langId != null) {
			ps.setInt(index, this.langId);
		} else {
			ps.setNull(index, java.sql.Types.INTEGER);
		}					
	}

}
