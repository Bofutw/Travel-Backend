package tw.test.mike.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.test.mike.bean.BlogBean;
import tw.test.mike.bean.JourneyBean;
import tw.test.mike.dao.BlogRepository;
import tw.test.mike.dao.JourneyRepository;

@Service
@Transactional
public class JourneyService {
	@Autowired
	private JourneyRepository journeyRepository;
	
	public List<JourneyBean> select() {
		
		return journeyRepository.findAll();
	}
	public JourneyBean selectById(Integer id) {
		Optional<JourneyBean> optional = journeyRepository.findById(id);
		if(optional.isPresent()) {
			
			return optional.get();
		}
		return null;
	}

	public boolean delete(JourneyBean journeyBean) {
		Optional<JourneyBean> optional =journeyRepository.findById(journeyBean.getJourneyid());
		if(optional.isPresent()) {
			journeyRepository.delete(journeyBean);
			return true;
		}
		return false;
	}
	public JourneyBean update(JourneyBean journeyBean) {
		Optional<JourneyBean> optional =journeyRepository.findById(journeyBean.getJourneyid());
		if(optional.isPresent()) {
			return journeyRepository.save(journeyBean);
		}
		return null;
	}
	public JourneyBean create(JourneyBean journeyBean) {
		Optional<JourneyBean> optional =journeyRepository.findById(journeyBean.getJourneyid());
		if(!optional.isPresent()) {
			return journeyRepository.save(journeyBean);
		}
		return null;
	}
}
