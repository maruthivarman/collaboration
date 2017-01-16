

package com.niit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Services.BlogDAO;
import com.niit.model.Blog;


@RestController
public class BlogController {
	@Autowired
	private BlogDAO blogDAO;

	public BlogDAO getBlogDAO() {
		return blogDAO;
	}

	public void setBlogDAO(BlogDAO blogDAO) {
		this.blogDAO = blogDAO;
	}
	@GetMapping("/blogs")
	public List getCustomers() {
		return blogDAO.list();
	}
	
	
	@GetMapping("/blogs/{id}")
	public ResponseEntity getBlog(@PathVariable("id") int id) {

		Blog blog = blogDAO.get(id);
		if (blog == null) {
			return new ResponseEntity("No Blog found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(blog, HttpStatus.OK);
	}
	
	@PostMapping("/blogs")
	public ResponseEntity createblog(@RequestBody Blog blog) {

		blogDAO.saveOrUpdate(blog);

		return new ResponseEntity(blog, HttpStatus.OK);
	}
	@DeleteMapping("/blogs/{id}")
	public ResponseEntity deleteBlog(@PathVariable int id) {
		Blog blog=blogDAO.get(id);
 		if (blog==null) {
			return new ResponseEntity("No Blog found for ID " + id, HttpStatus.NOT_FOUND);
		}
 		blogDAO.delete(id);
		return new ResponseEntity(id, HttpStatus.OK);

	}
	@PutMapping("/blogs/{id}")
	public ResponseEntity updateBlog(@PathVariable Long id, @RequestBody Blog blog) {

		blog = blogDAO.saveOrUpdate(blog);

		if (null == blog) {
			return new ResponseEntity("No Blog found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(blog, HttpStatus.OK);
	}

}

