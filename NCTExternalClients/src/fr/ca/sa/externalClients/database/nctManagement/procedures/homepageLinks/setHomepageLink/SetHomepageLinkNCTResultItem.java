package fr.ca.sa.externalClients.database.nctManagement.procedures.homepageLinks.setHomepageLink;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for result in result set from
 *         spSetAppHomePageMenuLink store procedure
 */
public class SetHomepageLinkNCTResultItem implements StoreProcedureResult {

	private int id;

	/**
	 * default constructor for Set Homepage Link NCT Result Item
	 */
	public SetHomepageLinkNCTResultItem() {
		super();
	}

	/**
	 * Set Homepage Link NCT Result Item
	 * 
	 * @param id
	 * 				ID
	 */
	public SetHomepageLinkNCTResultItem(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SetHomepageLinkNCTResultItem [id=" + id + "]";
	}

}
