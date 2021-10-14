package hykx.ds.whkc.dao;

import hykx.ds.whkc.entity.ThirdCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdCustomerDao extends JpaRepository<ThirdCustomerEntity,Integer> {

}
