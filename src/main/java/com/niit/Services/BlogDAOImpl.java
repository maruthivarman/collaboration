package com.niit.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Blog;
@Repository("BlogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	 public SessionFactory getSession() {
		return sessionFactory;
	}

	public BlogDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public void setSession(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Blog> getAllBlog() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog");
		@SuppressWarnings("unchecked")
		List<Blog> blog=query.list();
		session.close();
		return blog;
	}

	@Transactional
	public Blog getBlog(int blogid) {
		return (Blog)sessionFactory.getCurrentSession().get(Blog.class, blogid);
	}

	@Transactional
	public void insertBlog(Blog blog) {
		// TODO Auto-generated method stub

	}

	@Transactional
	public Blog updateBlog(int id, Blog blog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void deleteBlog(int id) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
