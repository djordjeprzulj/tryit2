package fr.ca.sa.externalClients.database.common.procedures.getHomepageLinks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.HomepageLinksCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting homepage links
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetHomepageLinks extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetHomepageLinks.class);

	/**
	 * NCT Database Get Homepage Links
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetHomepageLinks(Integer userId, Integer langId) {
		super(userId, langId);
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetAppHomePageMenuLinks ?,?");
		try {
			setUserAndLanguage(ps);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}		
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetHomepageLinksNCTResultList retList = new GetHomepageLinksNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getLinks()
						.add(new GetHomepageLinksNCTResultItem(this.getResultSet().getInt("LinkId"),
								this.getResultSet().getString("LinkName"), this.getResultSet().getString("LinkUrl"),
								this.getResultSet().getString("LinkPictureName"),
								this.getResultSet().getInt("LinkOrder"), this.getResultSet().getInt("isActive")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}
		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new HomepageLinksCRUDException(ErrorConstants.ERROR_MSG_GET_HOMEPAGE_LINKS);
	}

}
