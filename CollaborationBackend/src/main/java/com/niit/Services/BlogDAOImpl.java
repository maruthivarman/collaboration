package com.niit.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.model.Blog;



public class BlogDAOImpl implements BlogDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Transactional
	public List<Blog> list() {
		@SuppressWarnings({ "unchecked" })
		List<Blog> listBlog = (List<Blog>) sessionFactory.getCurrentSession().createCriteria(Blog.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listBlog;
	}
	@Transactional
	public Blog get(int bid) {
		String hql = "from Blog where bid ='" + bid + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> listBlog = (List<Blog>) query.list();

		if (listBlog != null && !listBlog.isEmpty()) {
			return listBlog.get(0);
		}
		return null;
	}
	@Transactional
	public Blog saveOrUpdate(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		return blog;
	}
	
	@Transactional
	public void delete(int bid) {
		Blog blogtoDelete=new Blog();
		blogtoDelete.setBid(bid);
		sessionFactory.getCurrentSession().delete(blogtoDelete);
		
	}


	


	

	
	
}
