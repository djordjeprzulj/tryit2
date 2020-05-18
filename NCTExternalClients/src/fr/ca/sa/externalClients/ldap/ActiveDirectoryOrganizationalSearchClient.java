package fr.ca.sa.externalClients.ldap;

import java.util.Hashtable;

import javax.naming.Context;
import org.jboss.logging.Logger;
import fr.ca.sa.commons.exceptions.databaseExceptions.WrongCredentialException;

/**
 * This class should be used for connecting to Active Directory.
 * 
 * @author Jelena Stankovski
 * @author Nemanja Ignjatov
 * @author Djordje Przulj
 *
 */
public class ActiveDirectoryOrganizationalSearchClient extends ActiveDirectoryClient {

	private static final Logger LOGGER = Logger.getLogger(ActiveDirectoryOrganizationalSearchClient.class);

	/**
	 * Active Directory Client
	 * 
	 * @param activeDirectoryAddress
	 *            Active directory address
	 * 
	 * @param domain
	 *            Domain
	 *            
	 * @param searchBase
	 *            Organizational base search
	 */
	public ActiveDirectoryOrganizationalSearchClient(String activeDirectoryAddress, String domain) {
		super(activeDirectoryAddress, domain);
	}

	/**
	 * 
	 * Checks if user exists in Active Directory
	 * 
	 * @param uid
	 * 			  - uid to check	
	 * @param email
	 * 			  - email to check	
	 * @param username
	 *            - username to check
	 * @param password
	 *            - password to check
	 * @throws WrongCredentialException
	 *             - if there is no user in LDAP
	 */
	@Override
	public void checkUserInActiveDirectory(String username, String password) throws WrongCredentialException {

		Hashtable<String, String> env = new Hashtable<String, String>();

		env.put(Context.INITIAL_CONTEXT_FACTORY, ActiveDirectoryClient.LDAP_LIBRARY_PATH);

		env.put(Context.PROVIDER_URL, this.activeDirectoryAddress);

		env.put(Context.SECURITY_PRINCIPAL,"uid=" + username + this.domain);

		env.put(Context.SECURITY_CREDENTIALS, password);

		initDirContext(env, LOGGER);
	}
}
