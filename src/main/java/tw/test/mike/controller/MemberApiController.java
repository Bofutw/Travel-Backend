package tw.test.mike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tw.test.mike.bean.AreaBean;
import tw.test.mike.bean.CityBean;
import tw.test.mike.bean.MemberBean;
import tw.test.mike.dao.CityRepository;
import tw.test.mike.service.AreaSerivce;
import tw.test.mike.service.CityService;
import tw.test.mike.service.MemberService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/member")
@CrossOrigin
public class MemberApiController {
	
	@Autowired
	private MemberService memberService;

	@Autowired
	private AreaSerivce areaSerivce;

	@Autowired
	private CityService cityService;

	@GetMapping({"/"})
	public ResponseEntity<?> selectAll(){
		List<MemberBean> result = memberService.selectAll();
		if(result!=null){
			return ResponseEntity.ok(result);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

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
	@PutMapping({"/", "/cityid={cityid}"})
	public ResponseEntity<?> update(@RequestBody MemberBean bean, @PathVariable(name = "cityid", required = false) Integer cityid){
		CityBean cityBean = new CityBean();
		AreaBean areaBean = new AreaBean();

		if(cityid!=null){
			cityBean.setCityid(cityid);
			System.out.println(cityBean);
		}else {
			cityBean = cityService.selectbyid(bean.getCity());
			System.out.println(cityBean);
		}

		cityBean.setCityname(cityService.selectbyid(cityBean).getCityname());

		areaBean.setAreaid(areaSerivce.selectbycityid(cityBean).getAreaid());
		areaBean.setAreaname(areaSerivce.selectbycityid(cityBean).getAreaname());

		cityBean.setArea(areaBean);

		System.out.println(cityBean);
		bean.setCity(cityBean);

		MemberBean result = memberService.update(bean);
		if(result!=null) {
			return ResponseEntity.ok(bean);
		}
		return ResponseEntity.notFound().build();
	}
}
