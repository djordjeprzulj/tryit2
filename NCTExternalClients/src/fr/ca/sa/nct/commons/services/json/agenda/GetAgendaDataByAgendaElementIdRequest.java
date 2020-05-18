package fr.ca.sa.nct.commons.services.json.agenda;

import java.io.Serializable;
import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetAgendaDataByAgendaElementIdRequest implements Serializable {
		public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
		
		private Integer agendaElementId;
		
		/**
		 * default constructor for Get Agenda Data By Agenda Element Id Request
		 */
		public GetAgendaDataByAgendaElementIdRequest() {
			super();
		}

		/**
		 * Get Agenda Data By Agenda Element Id Request
		 * 
		 * @param agendaElementId
		 * 				Agenda element ID
		 */
		public GetAgendaDataByAgendaElementIdRequest(Integer agendaElementId) {
			super();
			this.agendaElementId = agendaElementId;
		}

		public Integer getAgendaElementId() {
			return agendaElementId;
		}

		public void setAgendaElementId(Integer agendaElementId) {
			this.agendaElementId = agendaElementId;
		}

		@Override
		public String toString() {
			return "GetAgendaDataByAgendaElementIdRequest [agendaElementId=" + agendaElementId + "]";
		}
		
}
