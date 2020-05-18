package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration;

import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public abstract class AbstractConfigurationNCTDatabase extends AbstractStoreProcedureHandler {

	protected Integer userId;
	protected Integer langId;
	
	/**
	 * Abstract Configuration NCT Database
	 * 
	 * @param userId
	 * 			User ID
	 * 
	 * @param langId
	 * 			Language ID
	 */
	public AbstractConfigurationNCTDatabase(Integer userId, Integer langId) {
		super();
		this.userId = userId;
		this.langId = langId;
	}
}
