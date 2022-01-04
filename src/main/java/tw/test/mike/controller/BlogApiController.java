package tw.test.mike.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tw.test.mike.bean.BlogBean;
import tw.test.mike.service.BlogService;

@RestController
@RequestMapping("/blog")
@CrossOrigin
public class BlogApiController {
	@Autowired
	private BlogService blogService;
	
	@GetMapping({"/{keyword}"})
	public ResponseEntity<?> read(
			@PathVariable(name = "keyword",required = false) String keyword){	
		System.out.println(keyword);
		try {
			List<BlogBean> resault = blogService.selectByKeyword(keyword);
			if(resault!=null) {
				return ResponseEntity.ok(resault);
			}
			return ResponseEntity.notFound().build();
		}catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.status(500).build();
		}

	}
	
	@PostMapping({"/",})
	public ResponseEntity<?> create(@RequestBody BlogBean bean){
		BlogBean result = blogService.create(bean);
		if(result!=null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping({"{id}"})
	public ResponseEntity<?> delete(
			@PathVariable(name = "id",required = false) Integer id){
		BlogBean bean = new BlogBean();
		bean.setBlogid(id);
		boolean result = blogService.delete(bean);
		if(result) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PutMapping({"/"})
	public ResponseEntity<?> update(@RequestBody BlogBean bean){
		BlogBean result = blogService.update(bean);
		if(result!=null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
		
}
