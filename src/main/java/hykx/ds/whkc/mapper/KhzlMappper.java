package hykx.ds.whkc.mapper;

import hykx.ds.whkc.bean.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface KhzlMappper {
    @Select("select  goods_sn,goods_name,goods_number,market_price,shop_price,is_on_sale, " +
            "            YPDM,CDMC,CDDM,GG,TXM,DW,JX,PZWH,BZ,ZBZ, " +
            "            YXQ,PH,ISRETAIL,PCH,SCRQ,goods_id_s " +
            "            from hykx_rd.yzy_goods  " +
            "where RPAD(YXQ,10,'-15') >sysdate()  and is_on_sale = 1 " +
            "and ((ISRETAIL = 0 and goods_number+1 > bz*2) or (ISRETAIL = 1 and goods_number+1 > bz/2) ) " +
            "and goods_sn like 'YSBBB%' and CONVERT(bz,DECIMAL) > CONVERT(zbz,DECIMAL) and shop_price > 0 " +
            "or (goods_sn like 'YSBYMD%'and is_on_sale = 1 and bz > 0) ")
    public List<YZYGOODS> getyzygoods();

    @Insert("replace INTO hykx_rd.ysb_ddhz(djbh,rq,ontime,customerId,status,je,xgdjbh,beizhu,is_zx) " +
            " VALUES(#{djbh},#{rq},#{ontime},#{customerId},#{status},#{djje},#{xgdjbh},#{beizhu},#{is_zx})")
    void insertysbDDHZ(ysbddhz ddhz);

    @Insert("replace INTO hykx_rd.ysb_ddmx(djbh,dj_sn,drugCode,shl,dj,je,batchNum,validity,status,is_zx ) "+
            " VALUES(#{djbh},#{dj_sn},#{drugcode},#{shl},#{dj},#{je},#{batchnum},#{validity},#{status},#{is_zx})")
    void insertysbDDMX(ysbddmx ddmx);

}


