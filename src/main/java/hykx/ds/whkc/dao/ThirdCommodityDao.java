package hykx.ds.whkc.dao;

import hykx.ds.whkc.entity.ThirdCommodityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdCommodityDao extends JpaRepository<ThirdCommodityEntity,Integer> {

}
