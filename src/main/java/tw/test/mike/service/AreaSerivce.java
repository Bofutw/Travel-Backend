package tw.test.mike.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.test.mike.bean.AreaBean;
import tw.test.mike.bean.CityBean;
import tw.test.mike.dao.AreaRepository;
import tw.test.mike.dao.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class AreaSerivce {

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private MemberRepository memberRepository;

    public AreaBean selectbycityid(CityBean cityBean){
        AreaBean result = null;

        result = areaRepository.findByCity(cityBean);

        return result;
    }

    public JSONArray selectcountbyarea(){
        JSONArray result = new JSONArray();
        AreaBean areaBean = new AreaBean();
        CityBean cityBean = new CityBean();
        for(int i=1;i<=5;i++){
            JSONObject area = new JSONObject();
            List<CityBean> citys = new ArrayList<>();

            Integer count = 0;
            String name = "";

            areaBean.setAreaid(i);
            if(areaBean!=null){
                citys = areaRepository.findById(i).get().getCity();
                for(CityBean city : citys){
                    count += memberRepository.countByCity(city);
                }
                name=areaRepository.findById(i).get().getAreaname();

                area.put(name, count);
            }
            result.put(area);
        }
        return result;
    }
}
