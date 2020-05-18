package fr.ca.sa.externalClients.database.nct.procedures.todoList.removeToDoItem;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.exceptions.databaseExceptions.ToDoListCRUDException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.nct.commons.services.json.event.RemoveToDoItem;

/**
 * 
 * Store procedure handler for removing todo list item from DB
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseRemoveToDoItem extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseRemoveToDoItem.class);
	
	private RemoveToDoItem item;

	/**
	 * NCT Database Remove ToDo Item
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param item
	 * 				Item
	 */
	public NCTDatabaseRemoveToDoItem(int userId, RemoveToDoItem item) {
		super(userId);
		this.item = item;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		CallableStatement cs = connection.prepareCall("exec spDeleteToDoEvent ?,?");
		try {
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.item.getEventId());
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.userId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}	
		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		return null;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new ToDoListCRUDException(ErrorConstants.ERROR_MSG_DELETE_TODO_ITEM);
	}

	public RemoveToDoItem getItem() {
		return item;
	}

	public void setItem(RemoveToDoItem item) {
		this.item = item;
	}

}
