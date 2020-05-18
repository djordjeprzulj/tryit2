package fr.ca.sa.externalClients.database.common.procedures.getHomepageLinks;

import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 * 
 *         Wrapper class for all results from spGetAppHomePageMenuLinks store
 *         procedure
 */
public class GetHomepageLinksNCTResultList implements StoreProcedureResult {

	private List<GetHomepageLinksNCTResultItem> links;

	/**
	 * default constructor for Get Homepage Links NCT Result List
	 */
	public GetHomepageLinksNCTResultList() {
		super();
		links = new ArrayList<GetHomepageLinksNCTResultItem>();
	}

	/**
	 * Get Homepage Links NCT Result List
	 * 
	 * @param links
	 * 				Links
	 */
	public GetHomepageLinksNCTResultList(List<GetHomepageLinksNCTResultItem> links) {
		super();
		this.links = links;
	}

	public List<GetHomepageLinksNCTResultItem> getLinks() {
		return links;
	}

	public void setLinks(List<GetHomepageLinksNCTResultItem> links) {
		this.links = links;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetHomepageLinksNCTResultList [ ");
		if (this.links != null) {
			for (GetHomepageLinksNCTResultItem link : this.links) {
				sbRetValue.append(link.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetHomepageLinksNCTResultList is empty!!!";
	}

}
