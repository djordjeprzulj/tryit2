package fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioClientFilter;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetPortfolioClientFilterNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private Integer id;
	private String name;
	
	/**
	 * default constructor for Get Portfolio Client Filter NCT Result Item
	 */
	public GetPortfolioClientFilterNCTResultItem() {
		super();
	}
	
	/**
	 * Get Portfolio Client Filter NCT Result Item
	 * 
	 * @param id
	 * 			ID
	 * 
	 * @param name
	 * 			Name
	 */
	public GetPortfolioClientFilterNCTResultItem(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "GetPortfolioClientFilterNCTResultItem [id=" + id + ", name=" + name + "]";
	}
	
	
}
