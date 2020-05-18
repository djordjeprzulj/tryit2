package fr.ca.sa.externalClients.ldap;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

import fr.ca.sa.commons.exceptions.databaseExceptions.WrongCredentialException;

/**
 * This class should be used for connecting to Active Directory.
 * 
 * @author Jelena Stankovski
 * @author Nemanja Ignjatov
 *
 */
public class ActiveDirectoryClient {

	private static final Logger LOGGER = Logger.getLogger(ActiveDirectoryClient.class);

	protected static final String LDAP_LIBRARY_PATH = "com.sun.jndi.ldap.LdapCtxFactory";

	protected String activeDirectoryAddress;

	protected String domain;

	/**
	 * Active Directory Client
	 * 
	 * @param activeDirectoryAddress
	 * 				Active directory address
	 * 
	 * @param domain
	 * 				Domain
	 */
	public ActiveDirectoryClient(String activeDirectoryAddress, String domain) {
		super();
		this.activeDirectoryAddress = activeDirectoryAddress;
		this.domain = domain;
	}

	/**
	 * 
	 * Checks if user exists in Active Directory
	 * 
	 * @param username
	 *            - username to check
	 * @param password
	 *            - password to check
	 * @throws WrongCredentialException
	 *             - if there is no user in LDAP
	 */
	public void checkUserInActiveDirectory(String username, String password) throws WrongCredentialException {

		Hashtable<String, String> env = new Hashtable<String, String>();

		env.put(Context.INITIAL_CONTEXT_FACTORY, ActiveDirectoryClient.LDAP_LIBRARY_PATH);

		env.put(Context.PROVIDER_URL, this.activeDirectoryAddress);

		env.put(Context.SECURITY_PRINCIPAL, username + this.domain);

		env.put(Context.SECURITY_CREDENTIALS, password);
		
		if(password.isEmpty())
		{
			throw new WrongCredentialException();
		}
		
		initDirContext(env, LOGGER);
	}
	
	protected void initDirContext(Hashtable<String, String> env, Logger logger) {
		DirContext ctx = null;
		try {
			env.forEach((k,v)->{LOGGER.debug(k+ " = " + v);});
			ctx = new InitialDirContext(env);
		} catch (NamingException ex) {
			logger.error(ex);
			logger.error("LDAP error - " + ex.getMessage());
			throw new WrongCredentialException();
		} finally {
			if (ctx != null) {
				close(ctx);
			}
		}

		LOGGER.log(Level.DEBUG, "OK, successfully authenticating user");
	}

	protected void close(DirContext ctx) {
		try {
			ctx.close();
		} catch (NamingException ex) {
			LOGGER.error(ex);
			throw new WrongCredentialException();
		}
	}
}
