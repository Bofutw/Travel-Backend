package tw.test.mike.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
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
import tw.test.mike.bean.JourneyBean;
import tw.test.mike.service.BlogService;
import tw.test.mike.service.JourneyService;

@RestController
@RequestMapping("/journey")
@CrossOrigin
public class JourneyApiController {
	@Autowired
	private JourneyService journeyService;
	
	@GetMapping({"/"})
	public ResponseEntity<?> read(){	
		try {
			List<JourneyBean> resault = journeyService.selectAll();
			if(resault!=null) {
				return ResponseEntity.ok(resault);
			}
			return ResponseEntity.notFound().build();
		}catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.status(500).build();
		}

	}
	@GetMapping("/{id}")
	public ResponseEntity<?> selectbyId(
			@PathVariable(name = "id", required = false) Integer id){
		JourneyBean bean = new JourneyBean();
		bean.setJourneyid(id);
		JourneyBean result = journeyService.selectbyId(bean);
		if(result!=null){
			return ResponseEntity.ok(result);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping({"/",})
	public ResponseEntity<?> create(@RequestBody JourneyBean bean){
		JourneyBean result = journeyService.create(bean);
		if(result!=null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping({"{id}"})
	public ResponseEntity<?> delete(
			@PathVariable(name = "id",required = false) Integer id){
		JourneyBean bean = new JourneyBean();
		bean.setJourneyid(id);
		boolean result = journeyService.delete(bean);
		if(result) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PutMapping({"/"})
	public ResponseEntity<?> update(@RequestBody JourneyBean bean){
		JourneyBean result = journeyService.update(bean);
		if(result!=null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
		
}
