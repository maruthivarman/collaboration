package com.niit.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Forum;
@Repository("ForumDAO")
@Transactional
public class ForumDAOImpl implements ForumDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	 public SessionFactory getSession() {
		return sessionFactory;
	}

	public ForumDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public void setSession(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Forum> getAllForum() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Forum");
		@SuppressWarnings("unchecked")
		List<Forum> forum=query.list();
		session.close();
		return forum;
	}

	@Transactional
	public Forum getForum(int forumid) {
		return (Forum)sessionFactory.getCurrentSession().get(Forum.class, forumid);
	}

	@Transactional
	public void insertForum(Forum forum) {
		// TODO Auto-generated method stub

	}

	@Transactional
	public Forum updateForum(int id, Forum forum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void deleteForum(int id) {
		// TODO Auto-generated method stub

	}

}
