package tw.test.mike.controller;

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

import tw.test.mike.bean.MemberBean;
import tw.test.mike.service.MemberService;

@RestController
@RequestMapping("/member")
@CrossOrigin
public class MemberApiController {
	
	@Autowired
	private MemberService memberService;
	@GetMapping({"/{id}"})
	public ResponseEntity<?> read(
			@PathVariable(name = "id",required = false) Integer id){
		
		MemberBean bean = new MemberBean();
		bean.setMemberid(id);
		MemberBean result = memberService.selectbyId(bean);
		if(result!=null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.notFound().build();
	}
	@PostMapping({"/",})
	public ResponseEntity<?> create(@RequestBody MemberBean bean){
		System.out.println(bean);
		MemberBean result = memberService.create(bean);
		if(result!=null) {
			return ResponseEntity.ok(bean);
		}
		return ResponseEntity.notFound().build();
	}
	@DeleteMapping({"{id}"})
	public ResponseEntity<?> delete(
			@PathVariable(name = "id",required = false) Integer id){
		MemberBean bean = new MemberBean();
		bean.setMemberid(id);
		boolean result = memberService.delete(bean);
		if(result) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	@PutMapping({"/"})
	public ResponseEntity<?> update(@RequestBody MemberBean bean){
		MemberBean result = memberService.update(bean);
		if(result!=null) {
			return ResponseEntity.ok(bean);
		}
		return ResponseEntity.notFound().build();
	}
}
