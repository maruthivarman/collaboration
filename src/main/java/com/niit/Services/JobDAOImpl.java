package com.niit.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Job;
@Repository("JobDAO")
@Transactional
public class JobDAOImpl implements JobDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	 public SessionFactory getSession() {
		return sessionFactory;
	}

	public JobDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public void setSession(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Job> getAllJob() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job");
		@SuppressWarnings("unchecked")
		List<Job> job=query.list();
		session.close();
		return job;
	}

	@Transactional
	public Job getJob(int jobid) {
		return (Job)sessionFactory.getCurrentSession().get(Job.class, jobid);
	}

	@Transactional
	public void insertJob(Job job) {
		sessionFactory.getCurrentSession().saveOrUpdate(job);

	}

	@Transactional
	public Job updateJob(int id, Job job) {
Session session=sessionFactory.openSession();
		
		System.out.println("Id of Job is " +job.getJobid());
		if(session.get(Job.class, id)==null)
		return null;
		session.merge(job); 
		
		Job updatedJob=(Job)session.get(Job.class, id); 
		session.flush();
		session.close();
		return updatedJob;
	}
	

	@Transactional
	public void deleteJob(int id) {
Session session=sessionFactory.openSession();
		
Job job=(Job)session.get(Job.class, id);
		session.delete(job);
		
		session.flush();
		session.close();


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
