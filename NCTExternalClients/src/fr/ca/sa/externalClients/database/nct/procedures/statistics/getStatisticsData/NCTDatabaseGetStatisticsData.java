package fr.ca.sa.externalClients.database.nct.procedures.statistics.getStatisticsData;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatisticsFailedException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.nct.commons.services.json.statistics.GetStatisticsRequest;

/**
 * 
 * Store procedure handler for getting statistics data
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetStatisticsData extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetStatisticsData.class);

	private GetStatisticsRequest request;

	/**
	 * NCT Database Get Statistics Data
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param request
	 * 				Request
	 */
	public NCTDatabaseGetStatisticsData(int userId, GetStatisticsRequest request) {
		super(userId);
		this.request = request;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetStatisticsData ?,?,?,?,?,?,?,?");
		try {
			setUser(ps);
	
			if (this.request.getAdvisorId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.request.getAdvisorId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
	
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.request.getEntityId());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.request.getReportId());
	
			ps.setDate(NCTDatabaseConstants.SP_ARG_NR_5, formatDate(this.request.getStartDate()));
			ps.setDate(NCTDatabaseConstants.SP_ARG_NR_6, formatDate(this.request.getEndDate()));
	
			// no record count limit
			ps.setNull(NCTDatabaseConstants.SP_ARG_NR_7, Types.INTEGER);
	
			if (this.request.getLangId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_8, this.request.getLangId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_8, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}	
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetStatisticsDataResultItem retValue = new GetStatisticsDataResultItem();

		ResultSetMetaData rsmd;
		try {
			rsmd = this.getResultSet().getMetaData();

			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				retValue.getStatisticsData().put(rsmd.getColumnName(i), new ArrayList<>());
			}

			int rowCount = 0;

			while (this.getResultSet().next()) {
				rowCount++;
				for (Map.Entry<String, ArrayList<String>> entry : retValue.getStatisticsData().entrySet()) {
					retValue.getStatisticsData().get(entry.getKey()).add(this.getResultSet().getString(entry.getKey()));
				}
			}

			retValue.setRowCount(rowCount);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new StatisticsFailedException(ErrorConstants.ERROR_MSG_LOAD_STATISTICS);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new StatisticsFailedException(ErrorConstants.ERROR_MSG_LOAD_STATISTICS);
	}

	private Date formatDate(String date) {
		Date newDate = null;

		java.util.Date tNewDate = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.getBackboneOnlyDateDatetimeFormat());
			tNewDate = formatter.parse(date);
		} catch (ParseException ex) {
			LOGGER.error(ex);
			throw new StatisticsFailedException(ErrorConstants.ERROR_MSG_LOAD_STATISTICS);
		}
		newDate = new Date(tNewDate.getTime());

		return newDate;
	}
}
