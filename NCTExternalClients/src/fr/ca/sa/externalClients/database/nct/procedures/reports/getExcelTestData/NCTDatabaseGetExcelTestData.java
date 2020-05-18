package fr.ca.sa.externalClients.database.nct.procedures.reports.getExcelTestData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.QuickContactReportCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetExcelTestData extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetExcelTestData.class);

	private int recordNumber;

	/**
	 * NCT Database Get Excel Test Data
	 * 
	 * @param recordNumber
	 * 				Record number
	 */
	public NCTDatabaseGetExcelTestData(int recordNumber) {
		super();
		this.recordNumber = recordNumber;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement cs = connection.prepareStatement("exec spGetExcelTestData ?");
		try {
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.recordNumber);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}
		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetExcelTestDataList retList = new GetExcelTestDataList();

		try {
			while (this.getResultSet().next()) {

				retList.getTemplateList().add(new GetExcelTestDataItem(this.getResultSet().getInt("TRANSACT_ID"),
						this.getResultSet().getInt("TRA_TRANSACT_CODE"),
						this.getResultSet().getInt("COLLABORATOR_ID_SESSION"),
						this.getResultSet().getInt("CLI_PROS_ID"), this.getResultSet().getString("START_SESSION_DATE"),
						this.getResultSet().getString("END_SESSION_DATE"), this.getResultSet().getInt("ClientId"),
						this.getResultSet().getInt("ClientIdCore"), this.getResultSet().getString("Civility"),
						this.getResultSet().getString("C_L"), this.getResultSet().getString("TypeOfClient"),
						this.getResultSet().getInt("isIndividual"), this.getResultSet().getString("ClientCode"),
						this.getResultSet().getString("Name"), this.getResultSet().getString("Surname"),
						this.getResultSet().getString("CompanyOfficerName"),
						this.getResultSet().getString("CompanyOfficerSurname"),
						this.getResultSet().getString("BirthDate"), this.getResultSet().getString("Email"),
						this.getResultSet().getString("Address"), this.getResultSet().getString("PostCode"),
						this.getResultSet().getString("CityName"), this.getResultSet().getString("MobilePhone"),
						this.getResultSet().getString("DateOfLastContact"),
						this.getResultSet().getString("LastContactAdvisorName"),
						this.getResultSet().getString("Segment"), this.getResultSet().getInt("PortfolioId"),
						this.getResultSet().getInt("AdvisorId"), this.getResultSet().getInt("EntityId"),
						this.getResultSet().getString("EntityName"), this.getResultSet().getInt("NotInterested"),
						this.getResultSet().getInt("ChangedProspectToClient")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new QuickContactReportCRUDException(ErrorConstants.ERROR_MSG_GET_QCR_CONFIGURATION);
		}

		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new QuickContactReportCRUDException(ErrorConstants.ERROR_MSG_GET_QCR_CONFIGURATION);
	}

}
