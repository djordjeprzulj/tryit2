package fr.ca.sa.nct.commons.services.json.countryConfiguration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankParameters.GetBankParametersNCTResultItem;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class BankParametersResponse implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetBankParametersNCTResultItem> parameters;
	private String defaultLanguage;
	private String nctApplicationVersion;
	private Boolean functionRoleMapping;
	private String leadSageLink;
	private String basketSageLink;

	/**
	 * default constructor for Bank Parameters Response
	 */
	public BankParametersResponse() {
		super();
		this.parameters = new ArrayList<GetBankParametersNCTResultItem>();
	}

	/**
	 * Bank Parameters Response
	 * 
	 * @param parameters
	 * 				Parameters
	 * 
	 * @param defaultLanguage
	 * 				Default language
	 * 
	 * @param nctApplicationVersion
	 * 				Version of NCT application
	 */
	public BankParametersResponse(List<GetBankParametersNCTResultItem> parameters, String defaultLanguage, String nctApplicationVersion, Boolean functionRoleMapping) {
		super();
		this.parameters = parameters;
		this.defaultLanguage = defaultLanguage;
		this.nctApplicationVersion = nctApplicationVersion;
		this.functionRoleMapping = functionRoleMapping;
	}

	public List<GetBankParametersNCTResultItem> getParameters() {
		return parameters;
	}

	public void setParameters(List<GetBankParametersNCTResultItem> parameters) {
		this.parameters = parameters;
	}

	public String getDefaultLanguage() {
		return defaultLanguage;
	}

	public void setDefaultLanguage(String defaultLanguage) {
		this.defaultLanguage = defaultLanguage;
	}

	public String getNctApplicationVersion() {
		return nctApplicationVersion;
	}

	public void setNctApplicationVersion(String nctApplicationVersion) {
		this.nctApplicationVersion = nctApplicationVersion;
	}

	public Boolean getFunctionRoleMapping() {
		return functionRoleMapping;
	}

	public void setFunctionRoleMapping(Boolean functionRoleMapping) {
		this.functionRoleMapping = functionRoleMapping;
	}

	public String getLeadSageLink() {
		return leadSageLink;
	}

	public void setLeadSageLink(String leadSageLink) {
		this.leadSageLink = leadSageLink;
	}

	public String getBasketSageLink() {
		return basketSageLink;
	}

	public void setBasketSageLink(String basketSageLink) {
		this.basketSageLink = basketSageLink;
	}
}
