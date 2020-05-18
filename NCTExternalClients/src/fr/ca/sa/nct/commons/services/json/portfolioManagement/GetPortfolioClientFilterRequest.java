package fr.ca.sa.nct.commons.services.json.portfolioManagement;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetPortfolioClientFilterRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;


	private Integer langId;
	
	/**
	 * default constructor for Get Portfolio Client Filter Request
	 */
	public GetPortfolioClientFilterRequest() {
		super();
	}
	
	/**
	 * Get Portfolio Client Filter Request
	 * 
	 * @param langId
	 * 			Language ID
	 */
	public GetPortfolioClientFilterRequest(Integer langId) {
		super();
		this.langId = langId;
	}
	public Integer getLangId() {
		return langId;
	}
	public void setLangId(Integer langId) {
		this.langId = langId;
	}
	@Override
	public String toString() {
		return "GetPortfolioClientFilterRequest [langId=" + langId + "]";
	}
	
	

}
