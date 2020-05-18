package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * @author Djordje Przulj
 *
 * Parent class for all store procedure handlers that have user id and language id parameters.
 */
public abstract class AbstractUserBasketStoreProcedureHandler extends AbstractUserStoreProcedureHandler {

	protected Integer basketId;
	
	/**
	 * default constructor for Abstract User Basket Store Procedure Handler
	 */
	public AbstractUserBasketStoreProcedureHandler() {
		super();		
	}	
	
	/**
	 * Abstract User Basket Store Procedure Handler
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param basketId
	 * 				Basket ID
	 */
	public AbstractUserBasketStoreProcedureHandler(Integer userId, Integer basketId) {
		super(userId);		
		this.basketId = basketId;
	}
	
	/**
	 * Sets first parameter to userId and second parameter to langId
	 * 
	 * @param ps
	 * @throws SQLException
	 */
	protected void setUserAndBasket(PreparedStatement ps) throws SQLException {
		setUser(ps);
		setBasket(ps, NCTDatabaseConstants.SP_ARG_NR_2);
	}
	
	protected void setBasket(PreparedStatement ps, int index) throws SQLException {
		if (this.basketId != null) {
			ps.setInt(index, this.basketId);
		} else {
			ps.setNull(index, java.sql.Types.INTEGER);
		}					
	}

}
