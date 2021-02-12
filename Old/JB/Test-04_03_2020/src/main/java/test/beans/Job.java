package test.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "jobs")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jobId;
	@Column
	private String description;
	@Column
	private Date endDate;

	public Job() {
	}

	public Job(String description, Date endDate) {
		this.description = description;
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getJobId() {
		return jobId;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", description=" + description + ", endDate=" + endDate + "]";
	}

}
