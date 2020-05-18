package fr.ca.sa.externalClients.database.nct.procedures.todoList.insertToDoItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.exceptions.databaseExceptions.ToDoListCRUDException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.nct.commons.services.json.event.InsertToDoItemRequest;

/**
 * 
 * Store procedure handler for inserting todo list item in DB
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseInsertToDoItem extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseInsertToDoItem.class);

	private InsertToDoItemRequest item;

	/**
	 * NCT Database Insert ToDo Item
	 * 
	 * @param item
	 * 				Item
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseInsertToDoItem(InsertToDoItemRequest item, int userId) {
		super(userId);
		this.item = item;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement cs = connection.prepareStatement("exec spInsertToDoEvent ?,?,?,?,?,?,?");
		try {
			// If todo shouldn't be assigned to another user(no collaboratorID,
			// assign todo item
			// to the requester
			int collaboratorId = this.userId;
			if ((item.getCollaboratorId() != null) && (item.getCollaboratorId() >= 0)) {
				collaboratorId = this.item.getCollaboratorId();
			}
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_1, collaboratorId);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.userId);
			cs.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.item.getSubject());
			cs.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.item.getReminderDate());
			if (this.item.getClientId() == null) {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_5, Types.INTEGER);
			} else {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.item.getClientId());
			}
			cs.setString(NCTDatabaseConstants.SP_ARG_NR_6, this.item.getComment());
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_7, this.item.getStatus());
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}				
		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		InsertToDoItemNCTResult retValue = new InsertToDoItemNCTResult();
		try {
			while (this.getResultSet().next()) {
				retValue.setEventId(this.getResultSet().getInt("EventId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new ToDoListCRUDException(ErrorConstants.ERROR_MSG_INSERT_TODO_ITEM);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new ToDoListCRUDException(ErrorConstants.ERROR_MSG_INSERT_TODO_ITEM);
	}

}
