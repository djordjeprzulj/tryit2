package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.getCodeTableData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.CodeTablesCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store procedure handler for getting code tables data
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetCodeTableData extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetCodeTableData.class);

	private String tableName;
	private boolean isSimple;
	private static final String ACTIVE = "ACTIVE";

	/**
	 * NCT Database Get Code Table Data
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param tableName
	 * 				Table name
	 * 
	 * @param isSimple
	 * 				Is table simple
	 */
	public NCTDatabaseGetCodeTableData(Integer userId, String tableName, boolean isSimple) {
		super(userId);
		this.tableName = tableName;
		this.isSimple = isSimple;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetTableData ?,?");
		try  {
			setUser(ps);
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_2, this.tableName);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		StoreProcedureResult retList = null;
		try {
			if (isSimple) {
				retList = new GetCodeTableDataSimpleNCTResultList();
				while (this.getResultSet().next()) {
					if (retList instanceof GetCodeTableDataSimpleNCTResultList) {
						((GetCodeTableDataSimpleNCTResultList) retList).getData()
						.add(new GetCodeTableDataSimpleNCTResultItem(this.getResultSet().getInt("ID"),
								this.getResultSet().getString("NAME_L1"), this.getResultSet().getString("NAME_L2"),
								this.getResultSet().getInt(ACTIVE)));	
					}
				}
			} else {
				retList = new GetCodeTableDataComplexNCTResult();
				while (this.getResultSet().next()) {
					if (tableName.equals("MESSAGE_TEMPLATE")) {
						HashMap<String, String> row = new HashMap<String, String>();
						row.put("MESSAGE_TEMPLATE_ID",
								String.valueOf(this.getResultSet().getInt("MESSAGE_TEMPLATE_ID")));
						row.put("AGE_AGENDA_ELEMENT_MESSAGE_TYPE_ID",
								String.valueOf(this.getResultSet().getInt("AGE_AGENDA_ELEMENT_MESSAGE_TYPE_ID")));
						row.put("MESSAGE_TEMPLATE_NAME_L1", this.getResultSet().getString("MESSAGE_TEMPLATE_NAME_L1"));
						row.put("MESSAGE_TEMPLATE_NAME_L2", this.getResultSet().getString("MESSAGE_TEMPLATE_NAME_L2"));
						row.put("MESSAGE_TEMPLATE_TEXT_L1", this.getResultSet().getString("MESSAGE_TEMPLATE_TEXT_L1"));
						row.put("MESSAGE_TEMPLATE_TEXT_L2", this.getResultSet().getString("MESSAGE_TEMPLATE_TEXT_L2"));
						row.put("READ_ONLY", String.valueOf(this.getResultSet().getInt("READ_ONLY")));
						row.put(ACTIVE, String.valueOf(this.getResultSet().getInt(ACTIVE)));
						if (retList instanceof GetCodeTableDataComplexNCTResult) {
							((GetCodeTableDataComplexNCTResult) retList).getData().add(row);	
						}
					} else if (tableName.equals("COMPETITOR")) {
						HashMap<String, String> row = new HashMap<String, String>();
						row.put("COMPETITOR_ID", String.valueOf(this.getResultSet().getInt("COMPETITOR_ID")));
						row.put("COMPETITOR_NAME", this.getResultSet().getString("COMPETITOR_NAME"));
						row.put(ACTIVE, String.valueOf(this.getResultSet().getInt(ACTIVE)));
						if (retList instanceof GetCodeTableDataComplexNCTResult) {
							((GetCodeTableDataComplexNCTResult) retList).getData().add(row);	
						}
					} else if (tableName.equals("CLIENT_CODE_TYPE")) {
						HashMap<String, String> row = new HashMap<String, String>();
						row.put("NCT_ID", String.valueOf(this.getResultSet().getInt("NCT_ID")));
						row.put("CLIENT_CODE_TYPE", this.getResultSet().getString("CLIENT_CODE_TYPE"));
						row.put("NAME_L1", this.getResultSet().getString("NAME_L1"));
						row.put("NAME_L2", this.getResultSet().getString("NAME_L2"));
						row.put(ACTIVE, String.valueOf(this.getResultSet().getInt(ACTIVE)));
						if (retList instanceof GetCodeTableDataComplexNCTResult) {
							((GetCodeTableDataComplexNCTResult) retList).getData().add(row);	
						}
					} else if (tableName.equals("TRANSACT_APPLICATION")) {
						HashMap<String, String> row = new HashMap<String, String>();
						row.put("APPLICATION_CODE", String.valueOf(this.getResultSet().getInt("APPLICATION_CODE")));
						row.put("APPLICATION_NAME_L1", this.getResultSet().getString("APPLICATION_NAME_L1"));
						row.put("APPLICATION_NAME_L2",
								String.valueOf(this.getResultSet().getString("APPLICATION_NAME_L2")));
						row.put(ACTIVE, String.valueOf(this.getResultSet().getInt(ACTIVE)));
						if (retList instanceof GetCodeTableDataComplexNCTResult) {
							((GetCodeTableDataComplexNCTResult) retList).getData().add(row);	
						}
					} else if (tableName.equals("TRANSACT_DESC")) {
						HashMap<String, String> row = new HashMap<String, String>();
						row.put("TRANSACT_CODE", String.valueOf(this.getResultSet().getInt("TRANSACT_CODE")));
						row.put("TRANSACT_DESC_L1", this.getResultSet().getString("TRANSACT_DESC_L1"));
						row.put("TRANSACT_DESC_L2", String.valueOf(this.getResultSet().getString("TRANSACT_DESC_L2")));
						row.put(ACTIVE, String.valueOf(this.getResultSet().getInt(ACTIVE)));
						if (retList instanceof GetCodeTableDataComplexNCTResult) {
							((GetCodeTableDataComplexNCTResult) retList).getData().add(row);	
						}						
					} else if (tableName.equals("STRING_AUDIT1")) {
						HashMap<String, String> row = new HashMap<String, String>();
						row.put("STRING_ID", String.valueOf(this.getResultSet().getInt("STRING_ID")));
						row.put("PARAM_NAME", this.getResultSet().getString("PARAM_NAME"));
						row.put("PARAM_VALUE_L1", String.valueOf(this.getResultSet().getString("PARAM_VALUE_L1")));
						row.put("PARAM_VALUE_L2", String.valueOf(this.getResultSet().getString("PARAM_VALUE_L2")));
						row.put(ACTIVE, String.valueOf(this.getResultSet().getInt(ACTIVE)));
						if (retList instanceof GetCodeTableDataComplexNCTResult) {
							((GetCodeTableDataComplexNCTResult) retList).getData().add(row);	
						}
					} else if (tableName.equals("OPPORTUNITY_SUB_CATEGORY_REASON_TREATED")) {
						HashMap<String, String> row = new HashMap<String, String>();
						row.put("OPPORTUNITY_REASON_TREATED_ID",
								String.valueOf(this.getResultSet().getInt("OPPORTUNITY_REASON_TREATED_ID")));
						row.put("REASON_TREATED_NAME_L1",
								String.valueOf(this.getResultSet().getString("REASON_TREATED_NAME_L1")));
						row.put("REASON_TREATED_NAME_L2",
								String.valueOf(this.getResultSet().getString("REASON_TREATED_NAME_L2")));
						row.put(ACTIVE, String.valueOf(this.getResultSet().getInt(ACTIVE)));
						row.put("CATEGORY_ID", String.valueOf(this.getResultSet().getInt("CATEGORY_ID")));
						row.put("OPPORTUNITY_SUB_CATEGORY_ID",
								String.valueOf(this.getResultSet().getInt("OPPORTUNITY_SUB_CATEGORY_ID")));
						row.put("REASON_ORDER", String.valueOf(this.getResultSet().getInt("REASON_ORDER")));
						if (retList instanceof GetCodeTableDataComplexNCTResult) {
							((GetCodeTableDataComplexNCTResult) retList).getData().add(row);	
						}
					} else if (tableName.equals("OPPORTUNITY_CATEGORY")) {
						HashMap<String, String> row = new HashMap<String, String>();
						row.put("OPPORTUNITY_CATEGORY_ID",
								String.valueOf(this.getResultSet().getInt("OPPORTUNITY_CATEGORY_ID")));
						row.put("CATEGORY_NAME_L1", String.valueOf(this.getResultSet().getString("CATEGORY_NAME_L1")));
						row.put("CATEGORY_NAME_L2", String.valueOf(this.getResultSet().getString("CATEGORY_NAME_L2")));
						row.put("CANCEL", String.valueOf(this.getResultSet().getInt("CANCEL")));
						row.put("TREAT_ON_OPP_LIST", String.valueOf(this.getResultSet().getInt("TREAT_ON_OPP_LIST")));
						row.put("TREAT_ON_QCR", String.valueOf(this.getResultSet().getInt("TREAT_ON_QCR")));
						row.put("EXPIRE", String.valueOf(this.getResultSet().getInt("EXPIRE")));
						if (retList instanceof GetCodeTableDataComplexNCTResult) {
							((GetCodeTableDataComplexNCTResult) retList).getData().add(row);	
						}
					} else if (tableName.equals("AGENDA_ELEMENT_OBJECT_TYPE")) {
						HashMap<String, String> row = new HashMap<String, String>();
						row.put("AGENDA_ELEMENT_OBJECT_TYPE_CODE", String.valueOf(this.getResultSet().getInt("ID")));
						row.put("AGENDA_ELEMENT_OBJECT_TYPE_NAME_L1", this.getResultSet().getString("NAME_L1"));
						row.put("AGENDA_ELEMENT_OBJECT_TYPE_NAME_L2", this.getResultSet().getString("NAME_L2"));
						row.put(ACTIVE, String.valueOf(this.getResultSet().getInt(ACTIVE)));
						if (retList instanceof GetCodeTableDataComplexNCTResult) {
							((GetCodeTableDataComplexNCTResult) retList).getData().add(row);	
						}
					}
				}
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new CodeTablesCRUDException(ErrorConstants.ERROR_MSG_GET_CODE_TABLE_DATA);
		}

		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new CodeTablesCRUDException(ErrorConstants.ERROR_MSG_GET_CODE_TABLE_DATA);
	}
}
