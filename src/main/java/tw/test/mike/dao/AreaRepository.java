package tw.test.mike.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.test.mike.bean.AreaBean;

public interface AreaRepository extends JpaRepository<AreaBean, Integer> {

}
