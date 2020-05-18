package fr.ca.sa.externalClients.database.core;

import fr.ca.sa.externalClients.database.common.PreparedStatementBatchBuilderI;

/**
 * Basic functionality for handling bulk batch updates, which is required to be
 * extended in order to perform bulk insert on DB
 * 
 * @author Nemanja Ignjatov
 *
 */
public abstract class AbstractBatchBulkProcedureHandler extends AbstractStoreProcedureHandler
		implements PreparedStatementBatchBuilderI {

}
