package fr.ca.sa.nct.commons.services.json.portfolioManagement;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioData.GetPortfolioDataNCTResultItem;
import fr.ca.sa.model.Portfolio;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class PortfolioDetailsDataContainer extends GetPortfolioDataNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int clientCount;
	private int prospectCount;
	private int fillRate;
	private int quality;

	/**
	 * default constructor for Portfolio Details Data Container
	 */
	public PortfolioDetailsDataContainer() {
		super();
	}

	/**
	 * Portfolio Details Data Container
	 * 
	 * @param rowId
	 * 				Row ID
	 * 
	 * @param portfolioId
	 * 				Portfolio ID
	 * 
	 * @param name		
	 * 				Name
	 * 
	 * @param code
	 * 				Code
	 * 
	 * @param typeId
	 * 				Type ID
	 * 
	 * @param typeName
	 * 				Type name
	 * 
	 * @param typeCode
	 * 				Type code
	 * 
	 * @param size
	 * 				Size
	 * 
	 * @param fteSize
	 * 				FTE size
	 * 
	 * @param entityId
	 * 				Entity ID
	 * 
	 * @param entityName
	 * 				Entity name
	 * 
	 * @param ownerId
	 * 				Owner ID
	 * 
	 * @param ownerFirstName
	 * 				Owner first name
	 * 
	 * @param ownerLastName
	 * 				Owner last name
	 * 
	 * @param clientCount	
	 * 				Client count
	 * 
	 * @param prospectCount
	 * 				Prospect count
	 * 
	 * @param fillRate
	 * 				Fill rate
	 * 
	 * @param quality
	 * 				Quality
	 */
	public PortfolioDetailsDataContainer(Portfolio portfolio, int clientCount, int prospectCount, int fillRate,
			int quality) {
		super(portfolio);		
		this.clientCount = clientCount;
		this.prospectCount = prospectCount;
		this.fillRate = fillRate;
		this.quality = quality;
	}

	public int getClientCount() {
		return clientCount;
	}

	public void setClientCount(int clientCount) {
		this.clientCount = clientCount;
	}

	public int getProspectCount() {
		return prospectCount;
	}

	public void setProspectCount(int prospectCount) {
		this.prospectCount = prospectCount;
	}

	public int getFillRate() {
		return fillRate;
	}

	public void setFillRate(int fillRate) {
		this.fillRate = fillRate;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	@Override
	public String toString() {
		return "PortfolioDetailsDataContainer [portfolio=" + portfolio
				+ ", clientCount=" + clientCount + ", prospectCount=" + prospectCount + ", fillRate=" + fillRate
				+ ", quality=" + quality + "]";
	}

}
