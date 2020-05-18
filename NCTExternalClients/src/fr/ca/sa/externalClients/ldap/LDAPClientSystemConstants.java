package fr.ca.sa.externalClients.ldap;

/**
 * 
 * Constants for LDAP Client Configuration
 * 
 * @author Nemanja Ignjatov
 *
 */
public class LDAPClientSystemConstants {

	private String activeDirectoryAddress = null;
	private String domain = null;
	private long sessionLength;
	private long maxJWTDuration;
	private Boolean ldapSecuriryPrincipalUid;
	
	public LDAPClientSystemConstants() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Active Directory Client
	 * 
	 * @param activeDirectoryAddress
	 * 				Active directory address
	 * 
	 * @param domain
	 * 				Domain
	 * 
	 * @param sessionLength
	 * 				Session length
	 * 
	 * @param maxJWTDuration
	 * 				Maximal JWT token duration
	 */
	public LDAPClientSystemConstants(String activeDirectoryAddress, String domain, long sessionLength,
			long maxJWTDuration,Boolean ldapSecuriryPrincipalUid) {
		super();
		this.activeDirectoryAddress = activeDirectoryAddress;
		this.domain = domain;
		this.sessionLength = sessionLength;
		this.maxJWTDuration = maxJWTDuration;
		this.ldapSecuriryPrincipalUid=ldapSecuriryPrincipalUid;
	}

	public String getActiveDirectoryAddress() {
		return activeDirectoryAddress;
	}

	public void setActiveDirectoryAddress(String activeDirectoryAddress) {
		this.activeDirectoryAddress = activeDirectoryAddress;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public long getSessionLength() {
		return sessionLength;
	}

	public void setSessionLength(long sessionLength) {
		this.sessionLength = sessionLength;
	}

	public long getMaxJWTDuration() {
		return maxJWTDuration;
	}

	public void setMaxJWTDuration(long maxJWTDuration) {
		this.maxJWTDuration = maxJWTDuration;
	}

	public Boolean getLdapSecuriryPrincipalUid() {
		return ldapSecuriryPrincipalUid;
	}

	public void setLdapSecuriryPrincipalUid(Boolean ldapSecuriryPrincipalUid) {
		this.ldapSecuriryPrincipalUid = ldapSecuriryPrincipalUid;
	}

	@Override
	public String toString() {
		return "LDAPClientSystemConstants [activeDirectoryAddress=" + activeDirectoryAddress + ", domain=" + domain
				+ ", sessionLength=" + sessionLength + ", maxJWTDuration=" + maxJWTDuration
				+ ", ldapSecuriryPrincipalUid=" + ldapSecuriryPrincipalUid + "]";
	}

	

}
