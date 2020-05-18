package fr.ca.sa.model;

import java.sql.Timestamp;

public class QuickContactReport {

	private Client client = new Client();

	private Integer entityId;
	
	private Integer advisorId;

	private Integer requestId;

	private Integer channelId;

	private Integer reasonId;

	private Integer claimReasonId;

	private Integer unreachableReasonId;

	private Integer notIntReasonId;

	private Integer resultId;

	private String comment;

	private String emailText;

	private String reportDate;
	
	private Timestamp tsReportDate;

	public QuickContactReport(Client client, Integer entityId, Integer advisorId, Integer requestId, Integer channelId,
			Integer reasonId, Integer claimReasonId, Integer unreachableReasonId, Integer notIntReasonId,
			Integer resultId, String comment, String emailText, String reportDate, Timestamp tsReportDate) {
		super();
		this.client = client;
		this.entityId = entityId;
		this.advisorId = advisorId;
		this.requestId = requestId;
		this.channelId = channelId;
		this.reasonId = reasonId;
		this.claimReasonId = claimReasonId;
		this.unreachableReasonId = unreachableReasonId;
		this.notIntReasonId = notIntReasonId;
		this.resultId = resultId;
		this.comment = comment;
		this.emailText = emailText;
		this.reportDate = reportDate;
		this.tsReportDate = tsReportDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public Integer getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(Integer advisorId) {
		this.advisorId = advisorId;
	}

	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public Integer getReasonId() {
		return reasonId;
	}

	public void setReasonId(Integer reasonId) {
		this.reasonId = reasonId;
	}

	public Integer getClaimReasonId() {
		return claimReasonId;
	}

	public void setClaimReasonId(Integer claimReasonId) {
		this.claimReasonId = claimReasonId;
	}

	public Integer getUnreachableReasonId() {
		return unreachableReasonId;
	}

	public void setUnreachableReasonId(Integer unreachableReasonId) {
		this.unreachableReasonId = unreachableReasonId;
	}

	public Integer getNotIntReasonId() {
		return notIntReasonId;
	}

	public void setNotIntReasonId(Integer notIntReasonId) {
		this.notIntReasonId = notIntReasonId;
	}

	public Integer getResultId() {
		return resultId;
	}

	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getEmailText() {
		return emailText;
	}

	public void setEmailText(String emailText) {
		this.emailText = emailText;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public Timestamp getTsReportDate() {
		return tsReportDate;
	}

	public void setTsReportDate(Timestamp tsReportDate) {
		this.tsReportDate = tsReportDate;
	}

	@Override
	public String toString() {
		return "QuickContactReport [client=" + client + ", entityId=" + entityId + ", advisorId=" + advisorId
				+ ", requestId=" + requestId + ", channelId=" + channelId + ", reasonId=" + reasonId
				+ ", claimReasonId=" + claimReasonId + ", unreachableReasonId=" + unreachableReasonId
				+ ", notIntReasonId=" + notIntReasonId + ", resultId=" + resultId + ", comment=" + comment
				+ ", emailText=" + emailText + ", reportDate=" + reportDate + "]";
	}
}
