package fr.ca.sa.externalClients.database.nctManagement.procedures.homepageLinks.setHomepageLink;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.HomepageLinksCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for setting homepage link
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseSetHomepageLink extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetHomepageLink.class);

	private Integer linkId;
	private String linkNameL1;
	private String linkNameL2;
	private String linkURL;
	private String linkPictureName;
	private int linkOrder;
	private int active;

	/**
	 * NCT Database Set Homepage Link
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param linkId
	 * 				Link ID
	 * 
	 * @param linkNameL1
	 * 				Link name in first language
	 * 
	 * @param linkNameL2
	 * 				Link name in second language
	 * 
	 * @param linkURL
	 * 				Link URL
	 * 
	 * @param linkPictureName
	 * 				Link picture name
	 * 
	 * @param linkOrder
	 * 				Link order
	 * 
	 * @param active
	 * 				Activity
	 */
	public NCTDatabaseSetHomepageLink(int userId, Integer linkId, String linkNameL1, String linkNameL2, String linkURL,
			String linkPictureName, int linkOrder, int active) {
		super(userId);
		this.linkId = linkId;
		this.linkNameL1 = linkNameL1;
		this.linkNameL2 = linkNameL2;
		this.linkURL = linkURL;
		this.linkPictureName = linkPictureName;
		this.linkOrder = linkOrder;
		this.active = active;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spSetAppHomePageMenuLink ?,?,?,?,?,?,?,?");
		try {
			setUser(ps);
			if (this.linkId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.linkId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.linkNameL1);
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.linkNameL2);
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_5, this.linkURL);
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_6, this.linkPictureName);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_7, this.linkOrder);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_8, this.active);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		SetHomepageLinkNCTResultItem retValue = null;
		try {
			while (this.getResultSet().next()) {
				retValue = new SetHomepageLinkNCTResultItem(this.getResultSet().getInt("LinkId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new HomepageLinksCRUDException(ErrorConstants.ERROR_MSG_SET_HOMEPAGE_LINKS);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new HomepageLinksCRUDException(ErrorConstants.ERROR_MSG_SET_HOMEPAGE_LINKS);
	}
}
