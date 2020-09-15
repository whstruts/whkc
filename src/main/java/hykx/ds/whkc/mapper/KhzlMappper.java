package hykx.ds.whkc.mapper;

import hykx.ds.whkc.bean.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface KhzlMappper {
    @Select("select  goods_sn,substring_index(substring_index(goods_name,'(',1),'（',1)  as goods_name,goods_number,market_price, " +
            "truncate(zk*(select markUp from hykx_rd.lmsys where customNo = 'hl'),2) as shop_price_hl, " +
            "truncate(zk*(select markUp from hykx_rd.lmsys where customNo = 'yex'),2) as shop_price_yex, " +
            "truncate(zk*(select markUp from hykx_rd.lmsys where customNo = 'wky'),2) as shop_price_wky, " +
            "truncate(zk*(select markUp from hykx_rd.lmsys where customNo = 'st'),2) as shop_price_st, " +
            "shop_price,is_on_sale, YPDM,CDMC,CDDM,GG,TXM,DW,JX,PZWH,BZ,ZBZ,YXQ,PH,ISRETAIL,PCH,SCRQ,goods_id_s " +
            "from hykx_rd.yzy_goods " +
            "where RPAD(YXQ,10,'-15') >sysdate()  and is_on_sale = 1  " +
            "and ((ISRETAIL = 0 and goods_number+1 > bz*2) or (ISRETAIL = 1 and goods_number+1 > bz/2) )  " +
            "and CONVERT(bz,DECIMAL) > CONVERT(zbz,DECIMAL) and shop_price > 0  " +
            "and  locate('YSBBB', goods_sn) and pzwh not like '%食%' and jx not like '%消毒%'")
    public List<YZYGOODS> getyzygoods();

    @Insert("replace INTO hykx_hl.ysb_ddhz(djbh,rq,ontime,customerId,status,je,xgdjbh,beizhu,is_zx) " +
            " VALUES(#{djbh},#{rq},#{ontime},#{customerId},#{status},#{djje},#{xgdjbh},#{beizhu},#{is_zx})")
    void insertysbDDHZ(ysbddhz ddhz);

    @Insert("replace INTO hykx_hl.ysb_ddmx(djbh,dj_sn,drugCode,shl,dj,je,batchNum,validity,status,is_zx ) "+
            " VALUES(#{djbh},#{dj_sn},#{drugcode},#{shl},#{dj},#{je},#{batchnum},#{validity},#{status},#{is_zx})")
    void insertysbDDMX(ysbddmx ddmx);

    @Insert("replace INTO hykx_rd.gysgoods(gysbh,drugCode,stock,sptm,spmch,zjm,dw,shpchd,shpgg,pizhwh,jixing,youxq,shangplx,leibie,jlgg,bzgg,cunchtj,gmpzsyxq, " +
            "gmpzsh,gsp_pzwhyxq,zzhcpj,ssxkcy,ysbgwj,jingd,taxRate,batchNum,prodDate,validity,k_bbgwj ) "+
            " VALUES(#{gysbh},#{drugCode},#{stock},#{sptm},#{spmch},#{zjm},#{dw},#{shpchd},#{shpgg},#{pizhwh},#{jixing},#{youxq},#{shangplx},#{leibie}," +
            "#{jlgg},#{bzgg},#{cunchtj},#{gmpzsyxq}," +
            "#{gmpzsh},#{gsp_pzwhyxq},#{zzhcpj},#{ssxkcy},#{ysbgwj},#{jingd},#{taxRate},#{batchNum},#{prodDate},#{validity},#{k_bbgwj} )")
    void insertgysgoods(gysgoods gysgoods);

    @Select("call hykx_rd.gystoyzy()")
    void gysgoodsToyzygoods();

}


