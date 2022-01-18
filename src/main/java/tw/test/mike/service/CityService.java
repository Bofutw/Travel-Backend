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

    @Autowired
    private MemberRepository memberRepository;

    public CityBean selectbyid(CityBean cityBean){
        CityBean result = null;
        Optional<CityBean> optional = cityRepository.findById(cityBean.getCityid());
        if(optional.isPresent()){
            result = optional.get();
        }
        return result;
    }

    public JSONArray selectmembercountbycity(){
        JSONArray result = new JSONArray();



        CityBean cityBean = new CityBean();
        for(int i=1; i<=22; i++){
            JSONObject city = new JSONObject();
            cityBean.setCityid(i);
            Integer count = 0;
            String name = "";
            if(cityBean!=null){
                count = memberRepository.countByCity(cityBean);
                name = cityRepository.findById(i).get().getCityname();
                city.put(name,count);
            }
            result.put(city);
        }
        return result;
    }

}
