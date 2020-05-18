package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;

/**
 * 
 * @author Djordje Przulj
 *
 * Parent class for all store procedure handlers that have user id, language id and data source parameters.
 */
public abstract class AbstractUserBasketDataSourceProcedureHandler extends AbstractUserBasketStoreProcedureHandler {

	protected String dataSource;
	
	/**
	 * Default constructor.
	 */
	public AbstractUserBasketDataSourceProcedureHandler() {
		super();
	}
	
	/**
	 * Constructor for all fields initialization.
	 * 
	 * @param userId User ID
	 * @param basketId Basket ID
	 * @param dataSource Data source
	 */
	public AbstractUserBasketDataSourceProcedureHandler(Integer userId, Integer basketId, String dataSource) {
		super(userId, basketId);		
		this.dataSource = dataSource;
	}
	
	protected void setUserBasketAndDataSource(PreparedStatement ps) throws SQLException {
		setUserAndBasket(ps);
		setDataSource(ps, NCTDatabaseConstants.SP_ARG_NR_3);
	}
	
	protected void setDataSource(PreparedStatement ps, int index) throws SQLException {
		if (this.dataSource != null) {
			ps.setString(index, this.dataSource);
		} else {
			ps.setNull(index, java.sql.Types.VARCHAR);
		}
	}
}
