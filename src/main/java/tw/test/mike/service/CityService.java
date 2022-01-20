package tw.test.mike.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.test.mike.bean.CityBean;
import tw.test.mike.dao.CityRepository;
import tw.test.mike.dao.MemberRepository;

import java.util.Optional;


@Service
@Transactional
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public CityBean selectbyid(CityBean cityBean){
        CityBean result = null;
        Optional<CityBean> optional = cityRepository.findById(cityBean.getCityid());
        if(optional.isPresent()){
            result = optional.get();
        }
        return result;
    }



}
