package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.bulkInsertFlowImportTable;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchProcessingOperationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.sharedEntities.multipart.ImageInfoContainer;
import fr.ca.sa.commons.utilFunctions.TextUtilFunctions;
import fr.ca.sa.externalClients.database.common.PreparedStatementBatchBuilderI;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure handler for tracing batch processing
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseBulkInsertFlowImportTable extends AbstractStoreProcedureHandler implements PreparedStatementBatchBuilderI {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseBulkInsertFlowImportTable.class);
	private static final String BULK = "[BULK] Row ";
	private static final String INDEX = " Index ";
	
	private String flowName;
	private List<List<BatchCellValueContainer>> flowParsedRows;
	private List<String> columnNamesList;
	private boolean isBatchProcessing;

	/**
	 * default constructor for NCT Database Bulk Insert Flow Import Table
	 */
	public NCTDatabaseBulkInsertFlowImportTable() {
		super();
	}

	/**
	 * NCT Database Bulk Insert Flow Import Table
	 * 
	 * @param flowName
	 * 				Flow name
	 * 
	 * @param flowParsedRows
	 * 				Flow parsed rows
	 * 
	 * @param columnNamesList
	 * 				Column names list
	 * 
	 * @param isBatchProcessing
	 * 				Is batch processing
	 */
	public NCTDatabaseBulkInsertFlowImportTable(String flowName, List<List<BatchCellValueContainer>> flowParsedRows,
			List<String> columnNamesList, boolean isBatchProcessing) {
		super();
		this.flowName = flowName;
		this.flowParsedRows = flowParsedRows;
		this.columnNamesList = columnNamesList;
		this.isBatchProcessing = isBatchProcessing;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		
		StringBuilder sbColumnNames = new StringBuilder("[ID], ");
		StringBuilder sbArgs = new StringBuilder("?, ");

		for (String column : this.columnNamesList) {
			sbColumnNames.append("[" + column + "], ");
			sbArgs.append("?, ");
		}
		String columnNames = sbColumnNames.substring(0, sbColumnNames.lastIndexOf(","));
		String args = sbArgs.substring(0, sbArgs.lastIndexOf(","));

		String sqlString = "INSERT batchFlow." + flowName + "("+columnNames+") VALUES (" + args + ")";
		PreparedStatement ps = connection.prepareStatement(sqlString, ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		try {
			LOGGER.info("[BULK] SQL HOLDER : " + sqlString);
			for (List<BatchCellValueContainer> row : flowParsedRows) {
				// Offset due to csv headers
				int rowOrder = flowParsedRows.indexOf(row) + 1;
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, rowOrder);
				for (int i = 0; i < row.size(); i++) {
					BatchCellValueContainer cellWrapper = row.get(i);
					// 2 = 1 for ID column, 1 for Java indexing from 0
					int cellIndex = i + NCTDatabaseConstants.getBulkInsertQueryCellIndexOffset();
	
					if (!cellWrapper.isStream()) {
						// String cell
						if (cellWrapper.getData() == null) {
							ps.setNull(cellIndex, Types.VARCHAR);
							LOGGER.debug(BULK + rowOrder + INDEX + cellIndex );
						} else {
							Object objCell = cellWrapper.getData();
							String stringCell = null;
							if (objCell instanceof String) {
								stringCell = (String) objCell;
							}
							ps.setString(cellIndex, stringCell);
							LOGGER.debug(BULK + rowOrder + INDEX + cellIndex + " length " + stringCell.length());
						}
					} else {
						// Binary cell
						if (cellWrapper.getData() == null) {
							ps.setNull(cellIndex, Types.VARBINARY);
							LOGGER.debug(BULK + rowOrder + INDEX + cellIndex + " binary value : null");
						} else {
							InputStream cellStream = null;
	
							if (this.isBatchProcessing) {
								Object objCell = cellWrapper.getData();
								ImageInfoContainer imageObj = null;
								if (objCell instanceof ImageInfoContainer) {
									imageObj = (ImageInfoContainer) objCell;	
								}
								cellStream = imageObj.getStreamFromBufferedImage();
							} else {
								try {
									cellStream =  TextUtilFunctions.getInputStreamForBase64String(cellWrapper.getDataFromJMS());
								} catch (IOException ex) {
									LOGGER.warn(ex);
									LOGGER.warn(
											"Unable to decode HEX String for index " + cellIndex + "in row " + rowOrder);
								}
							}
							if (cellStream != null) {
								ps.setBinaryStream(cellIndex, cellStream);
								LOGGER.debug(
										BULK + rowOrder + INDEX + cellIndex);
							} else {
								LOGGER.warn(BULK + rowOrder + INDEX + cellIndex
										+ " binary value converting failed : null");
							}
	
						}
					}
				}
				ps.addBatch();
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		return null;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new BatchProcessingOperationException(ex.getMessage(), ex.getCause());
	}

	@Override
	public void setConnectionAutoCommit(Connection connection) throws SQLException {
		connection.setAutoCommit(false);

	}

	@Override
	public void commitBatchBulk(PreparedStatement statement, Connection connection) throws SQLException {
		statement.executeBatch();
		connection.commit();

	}

}
