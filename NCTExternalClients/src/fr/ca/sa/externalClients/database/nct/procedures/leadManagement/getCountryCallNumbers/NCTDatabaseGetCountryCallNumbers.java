package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.getCountryCallNumbers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting phone call numbers for country
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetCountryCallNumbers extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetCountryCallNumbers.class);

	private Integer countryId;
	private Integer isMobile;

	/**
	 * NCT Database Get Country Call Numbers
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 * 
	 * @param countryId
	 * 				Country ID
	 * 
	 * @param isMobile
	 * 				Is mobile
	 */
	public NCTDatabaseGetCountryCallNumbers(Integer userId, Integer langId, Integer countryId, Integer isMobile) {
		super(userId, langId);
		this.countryId = countryId;
		this.isMobile = isMobile;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetCallNumbersByCountryId ?,?,?,?");
		try {
			setUserAndLanguage(ps);
			if (this.countryId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.countryId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, java.sql.Types.INTEGER);
			}
			if (this.isMobile != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.isMobile);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, java.sql.Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetCountryCallNumbersNCTResultList retValue = new GetCountryCallNumbersNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retValue.getCallNumbers()
						.add(new GetCountryCallNumbersNCTResultItem(this.getResultSet().getInt("CountryId"),
								this.getResultSet().getString("CountryCode"),
								this.getResultSet().getString("CountryISOCode2"),
								this.getResultSet().getString("CountryISOCode3"),
								this.getResultSet().getString("CountryCallNumber"),
								this.getResultSet().getInt("IsMobileCallNumber"),
								this.getResultSet().getString("CountryName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}
}
