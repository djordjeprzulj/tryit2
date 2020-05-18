package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.setProductClient;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.ClientCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure handler for setting information on product catalogue Ids got
 * from WSDL for client
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseSetProductClient extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetProductClient.class);

	private int transid;
	private int collaboratorId;
	private int clientId;
	private List<String> productIds;

	/**
	 * NCT Database Set Product Client
	 * 
	 * @param transid        Transaction ID
	 * 
	 * @param collaboratorId Collaborator ID
	 * 
	 * @param clientId       Client ID
	 * 
	 * @param productIds     Product IDs
	 */
	public NCTDatabaseSetProductClient(int transid, int collaboratorId, int clientId, List<String> productIds) {
		super();
		this.transid = transid;
		this.collaboratorId = collaboratorId;
		this.clientId = clientId;
		this.productIds = productIds;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException {
		CallableStatement cs = connection.prepareCall("exec spSetProductClient ?,?,?,?");
		try {
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.transid);			
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.collaboratorId);			
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.clientId);
			setProductIds(cs);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}
		return cs;
	}

	private void setProductIds(PreparedStatement ps) throws SQLException {
		if (this.productIds != null && !this.productIds.isEmpty()) {
			StringBuilder sqlIds = new StringBuilder("(");
			for (String prodId : this.productIds) {
				if (prodId != null) {
					if (productIds.indexOf(prodId) == (productIds.size() - 1)) {
						sqlIds.append(" " + prodId + " ");
					} else {
						sqlIds.append(" " + prodId + ", ");
					}
				}
			}
			sqlIds.append(")");			
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, sqlIds.toString());
		} else {
			ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, java.sql.Types.VARCHAR);
		}
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		return null;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new ClientCRUDException();
	}
}
