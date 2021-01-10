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
	public void ItoKhs(Khzl khzl){
		khzlMapper.insert(khzl);
	}
    public void ItoKCs(SpKC spkc){
        khzlMapper.insertKC(spkc);
    }
	public void ItoDDs(Ddzt ddzt){
		khzlMapper.insertDD(ddzt);
	}
	public void ItoDZFPs(DZFP dzfp){
		khzlMapper.insertDZFP(dzfp);
	}
	public void ItoSPs(Spzl spzl){
		khzlMapper.insertSP(spzl);
	}
	public List<ERPddhz> getDDHZ() { return khzlMapper.getddhz();}
//	public List<ERPddmx> getDDMX() { return khzlMapper.getddmx();}

	public List<ERPddmx> getDDMXbyID(String kpbh) { return khzlMapper.getddmxbyid(kpbh);}

	public void UpdateDD(String kpbh){
		khzlMapper.updatedd(kpbh);
	}

	public void UpdateDDMX(ERPddmx mx){
		khzlMapper.updateddmx(mx);
	}

	public void DoYSBWriteBack(){
		khzlMapper.DoYSBWriteBack();
	}

	public void Itogysgoods(gysgoods gysgoods){khzlMapper.insertgysgoods(gysgoods);}
}
