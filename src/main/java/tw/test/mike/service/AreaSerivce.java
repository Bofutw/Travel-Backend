package tw.test.mike.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.test.mike.bean.AreaBean;
import tw.test.mike.bean.CityBean;
import tw.test.mike.dao.AreaRepository;

@Service
@Transactional

public class AreaSerivce {

    @Autowired
    private AreaRepository areaRepository;

    public AreaBean selectbycityid(CityBean cityBean){
        AreaBean result = null;

        result = areaRepository.findByCity(cityBean);

        return result;
    }
}
