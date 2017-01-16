package com.niit.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.model.Jobs;



public class JobDAOImpl implements JobDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Transactional
	public List<Jobs> list() {
		@SuppressWarnings({ "unchecked" })
		List<Jobs> listJobs = (List<Jobs>) sessionFactory.getCurrentSession().createCriteria(Jobs.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listJobs;
	}
	@Transactional
	public Jobs get(int jid) {
		String hql = "from Jobs where jid ='" + jid + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Jobs> listJobs = (List<Jobs>) query.list();

		if (listJobs != null && !listJobs.isEmpty()) {
			return listJobs.get(0);
		}
		return null;
	}
	@Transactional
	public Jobs saveOrUpdate(Jobs job) {
		sessionFactory.getCurrentSession().saveOrUpdate(job);
		return job;
	}
	
	@Transactional
	public void delete(int jid) {
		Jobs jobstoDelete=new Jobs();
		jobstoDelete.setJid(jid);
		sessionFactory.getCurrentSession().delete(jobstoDelete);
		
	}
	

}
