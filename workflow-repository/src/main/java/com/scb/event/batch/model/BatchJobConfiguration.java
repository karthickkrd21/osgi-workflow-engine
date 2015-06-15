package com.scb.event.batch.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * The BatchJobConfiguration Entity to configure the BatchJob Instance.
 * 
 * @author 1434190
 * 
 */
@Entity
@NamedQuery(name = BatchJobConfiguration.FIND_ALL_BATCH_JOB_CONFIGURATION, query = "select c from BatchJobConfiguration c left join fetch c.parameters left join fetch c.routes")
@Table(name = "BATCH_JOB_CONFIGURATION")
public class BatchJobConfiguration implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = -8525955156740291965L;

	public static final String FIND_ALL_BATCH_JOB_CONFIGURATION = "findAllJobConfiguration";

	@Id
	@Column(name = "JOB_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BATCH_JOB_SEQUENCE")
	@SequenceGenerator(name = "BATCH_JOB_SEQUENCE", sequenceName = "EVENT_MESSAGE_SEQ")
	private BigInteger jobId;

	@Column(name = "GROUP_NAME", length = 256, nullable = false)
	private String groupName;

	@Column(name = "JOB_NAME", length = 256, nullable = false)
	private String jobName;

	@Column(name = "JOB_DESCRIPTION", length = 1024)
	private String jobDescription;

	@Column(name = "REPEAT_COUNT")
	private BigInteger repeatCount;

	@Column(name = "REPEAT_INTERVAL")
	private BigInteger repeatInterval;

	@Column(name = "IS_CRON_TRIGGER", length = 1)
	private Boolean cronTrigger;

	@Column(name = "CRON_EXPRESSION", length = 120)
	private String cronExpression;

	@Column(name = "IS_ENABLED", length = 1)
	private Boolean enabled;

	@Column(name = "TIME_ZONE", length = 120)
	private String timeZone;

	@OneToMany(mappedBy = "jobConfiguration")
	public Set<BatchJobParam> parameters = new HashSet<BatchJobParam>();

	@OneToMany(mappedBy = "jobConfiguration")
	public Set<RouteConfiguration> routes = new HashSet<RouteConfiguration>();

	/**
	 * @return the jobId
	 */
	public BigInteger getJobId() {
		return jobId;
	}

	/**
	 * @param jobId
	 *            the jobId to set
	 */
	public void setJobId(final BigInteger jobId) {
		this.jobId = jobId;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName
	 *            the groupName to set
	 */
	public void setGroupName(final String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @param jobName
	 *            the jobName to set
	 */
	public void setJobName(final String jobName) {
		this.jobName = jobName;
	}

	/**
	 * @return the jobDescription
	 */
	public String getJobDescription() {
		return jobDescription;
	}

	/**
	 * @param jobDescription
	 *            the jobDescription to set
	 */
	public void setJobDescription(final String jobDescription) {
		this.jobDescription = jobDescription;
	}

	/**
	 * @return the repeatCount
	 */
	public BigInteger getRepeatCount() {
		return repeatCount;
	}

	/**
	 * @param repeatCount
	 *            the repeatCount to set
	 */
	public void setRepeatCount(final BigInteger repeatCount) {
		this.repeatCount = repeatCount;
	}

	/**
	 * @return the repeatInterval
	 */
	public BigInteger getRepeatInterval() {
		return repeatInterval;
	}

	/**
	 * @param repeatInterval
	 *            the repeatInterval to set
	 */
	public void setRepeatInterval(final BigInteger repeatInterval) {
		this.repeatInterval = repeatInterval;
	}

	/**
	 * @return the cronTrigger
	 */
	public Boolean getCronTrigger() {
		return cronTrigger;
	}

	/**
	 * @param cronTrigger
	 *            the cronTrigger to set
	 */
	public void setCronTrigger(final Boolean cronTrigger) {
		this.cronTrigger = cronTrigger;
	}

	/**
	 * @return the cronExpression
	 */
	public String getCronExpression() {
		return cronExpression;
	}

	/**
	 * @param cronExpression
	 *            the cronExpression to set
	 */
	public void setCronExpression(final String cronExpression) {
		this.cronExpression = cronExpression;
	}

	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(final Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the timeZone
	 */
	public String getTimeZone() {
		return timeZone;
	}

	/**
	 * @param timeZone
	 *            the timeZone to set
	 */
	public void setTimeZone(final String timeZone) {
		this.timeZone = timeZone;
	}

	/**
	 * @return the parameters
	 */
	public Set<BatchJobParam> getParameters() {
		return parameters;
	}

	/**
	 * @return the routes
	 */
	public Set<RouteConfiguration> getRoutes() {
		return routes;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append("jobId").append("groupName").append("jobName").append("jobDescription")
				.append("repeatCount").append("repeatInterval").append("cronExpression").append("cronTrigger")
				.append("enabled").append("timeZone").toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final BatchJobConfiguration other = (BatchJobConfiguration) obj;
		if (cronExpression == null) {
			if (other.cronExpression != null)
				return false;
		} else if (!cronExpression.equals(other.cronExpression))
			return false;
		if (cronTrigger == null) {
			if (other.cronTrigger != null)
				return false;
		} else if (!cronTrigger.equals(other.cronTrigger))
			return false;
		if (enabled == null) {
			if (other.enabled != null)
				return false;
		} else if (!enabled.equals(other.enabled))
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (jobDescription == null) {
			if (other.jobDescription != null)
				return false;
		} else if (!jobDescription.equals(other.jobDescription))
			return false;
		if (jobId == null) {
			if (other.jobId != null)
				return false;
		} else if (!jobId.equals(other.jobId))
			return false;
		if (jobName == null) {
			if (other.jobName != null)
				return false;
		} else if (!jobName.equals(other.jobName))
			return false;
		if (parameters == null) {
			if (other.parameters != null)
				return false;
		} else if (!parameters.equals(other.parameters))
			return false;
		if (repeatCount == null) {
			if (other.repeatCount != null)
				return false;
		} else if (!repeatCount.equals(other.repeatCount))
			return false;
		if (repeatInterval == null) {
			if (other.repeatInterval != null)
				return false;
		} else if (!repeatInterval.equals(other.repeatInterval))
			return false;
		if (routes == null) {
			if (other.routes != null)
				return false;
		} else if (!routes.equals(other.routes))
			return false;
		if (timeZone == null) {
			if (other.timeZone != null)
				return false;
		} else if (!timeZone.equals(other.timeZone))
			return false;
		return true;
	}

}