package hykx.ds.whkc.rabbitmq;

import hykx.ds.whkc.bean.*;
import hykx.ds.whkc.mapper.KhzlMappper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhzlService {

	@Autowired
	private KhzlMappper khzlMapper;

	public List<YZYGOODS> getYZYGOODS() { return khzlMapper.getyzygoods();}

    public void ItoYSBDDHZs(ysbddhz ddhz){
	khzlMapper.insertysbDDHZ(ddhz);
}
	public void ItoYSBDDMXs(ysbddmx ddmx){
		khzlMapper.insertysbDDMX(ddmx);
	}
	public void Itogysgoods(gysgoods gysgoods){khzlMapper.insertgysgoods(gysgoods);}
	public void gysgoodsToyzygoods(){khzlMapper.gysgoodsToyzygoods();}
	public void ItoSTGoods(STGoods stGoods){khzlMapper.insertSTGoods(stGoods);}
}
