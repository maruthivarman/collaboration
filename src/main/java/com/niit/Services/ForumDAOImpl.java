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
		sessionFactory.getCurrentSession().saveOrUpdate(forum);

	}

	@Transactional
	public Forum updateForum(int id, Forum forum) {

		Session session=sessionFactory.openSession();
		
		System.out.println("Id of Forum is " +forum.getForumid());
		if(session.get(Forum.class, id)==null)
		return null;
		session.merge(forum); 
		
		Forum updatedForum=(Forum)session.get(Forum.class, id); 
		session.flush();
		session.close();
		return updatedForum;
	}

	@Transactional
	public void deleteForum(int id) {
Session session=sessionFactory.openSession();
		
		Forum forum=(Forum)session.get(Forum.class, id);
		session.delete(forum);
		
		session.flush();
		session.close();

	}

}
