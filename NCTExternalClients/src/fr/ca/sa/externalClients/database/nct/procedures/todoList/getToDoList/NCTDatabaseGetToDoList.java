package fr.ca.sa.externalClients.database.nct.procedures.todoList.getToDoList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.exceptions.databaseExceptions.ToDoListCRUDException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.model.Client;
import fr.ca.sa.model.Entity;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store procedure handler for getting user's todo list from DB
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetToDoList extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetToDoList.class);

	/**
	 * default constructor for NCT Database Get ToDo List
	 */
	public NCTDatabaseGetToDoList() {
		super();
	}

	/**
	 * NCT Database Get ToDo List
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetToDoList(int userId) {
		super(userId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetToDoEventsByUserId ?");
		try {
			setUser(ps);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}	
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetToDoListNCTResultList retValue = new GetToDoListNCTResultList();
		try {
			while (this.getResultSet().next()) {
				Entity entity = new Entity(this.getResultSet().getInt("EntityId"), null, null, null);
				Client client = new Client(this.getResultSet().getInt("CLIENT_ID"), this.getResultSet().getString("NAME"), entity,  
						this.getResultSet().getInt("PortfolioId"), this.getResultSet().getString("C_L"));
				client.setLastName(this.getResultSet().getString("SURNAME"));
				
				retValue.getItems()
						.add(new GetToDoListNCTResultItem(this.getResultSet().getString("REMINDER_DATE"),
								this.getResultSet().getString("SUBJECT"), 
								this.getResultSet().getString("COMMENTS"), 
								this.getResultSet().getInt("EventId"),
								this.getResultSet().getInt("STATUS"), 
								client));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new StatementExecutionException(ErrorConstants.ERROR_MSG_GET_TODO_LIST);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new ToDoListCRUDException(ErrorConstants.ERROR_MSG_GET_TODO_LIST);
	}
}
