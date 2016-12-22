package com.niit.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.Services.BlogDAO;
import com.niit.model.Blog;

@Controller
public class BlogController {

	@Autowired
	private BlogDAO blogDAO;


	public BlogDAO getBlogDAO() {
		return blogDAO;
	}

	public void setBlogDAO(BlogDAO blogDAO) {
		this.blogDAO = blogDAO;
	}
	
	
	
	@RequestMapping(value="blog",method=RequestMethod.GET)
	public  ResponseEntity<List<Blog>> getAllBlogs(){
		System.out.println(blogDAO.getAllBlog());
		List<Blog> persons=blogDAO.getAllBlog();
		if(persons.isEmpty())
			return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Blog>>(persons,HttpStatus.OK);
	}


	@RequestMapping(value="blog/{id}",method=RequestMethod.GET)
	public ResponseEntity<Blog> getBlogById(@PathVariable(value="id") int id){
		Blog blog=blogDAO.getBlog(id);
		if(blog==null)
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}

	@RequestMapping(value="blog",method=RequestMethod.POST)

	public ResponseEntity createBlog(@RequestBody Blog blog, UriComponentsBuilder build)
	{
		blogDAO.insertBlog(blog);
		HttpHeaders headers=new HttpHeaders();
		
		URI urilocation=
				build.path("blog/")
				.path(String.valueOf(blog.getBlogid()))
				.build()
				.toUri();
		headers.setLocation(urilocation);
		return new ResponseEntity(headers,HttpStatus.CREATED);
	}


	@RequestMapping(value="blog/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Blog> updateBlog(
			@PathVariable int id,@RequestBody Blog blog){
		
		Blog updatedBlog=blogDAO.updateBlog(id, blog);
		if(blog==null)
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		blogDAO.updateBlog(id, blog);
		return new ResponseEntity<Blog>(updatedBlog,HttpStatus.OK);
		
		
	}
	@RequestMapping(value="blog/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteBlog(@PathVariable int id){
		Blog blog=blogDAO.getBlog(id);
		if(blog==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		blogDAO.deleteBlog(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
