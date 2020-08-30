package test.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.beans.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, Long>{
	
	List<Job> findByEndDate(Date endDate);
	List<Job> findByEndDateBetween(Date minEndDate, Date maxEndDate);
}
