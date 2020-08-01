package hykx.ds.whkc.mapper;

import hykx.ds.whkc.bean.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface KhzlMappper {
    @Select("select  goods_sn,substring_index(substring_index(goods_name,'(',1),'（',1)  as goods_name,goods_number,market_price,shop_price,is_on_sale, " +
            "            YPDM,CDMC,CDDM,GG,TXM,DW,JX,PZWH,BZ,ZBZ, " +
            "            YXQ,PH,ISRETAIL,PCH,SCRQ,goods_id_s " +
            "            from hykx_rd.yzy_goods  " +
            "where RPAD(YXQ,10,'-15') >sysdate()  and is_on_sale = 1 " +
            "and ((ISRETAIL = 0 and goods_number+1 > bz*2) or (ISRETAIL = 1 and goods_number+1 > bz/2) ) " +
            "and goods_sn like 'YSBBB%' and CONVERT(bz,DECIMAL) > CONVERT(zbz,DECIMAL) and shop_price > 0 " +
            "and pzwh not like '%食%' and jx not like '%消毒%'")
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

    @Insert("replace INTO hykx_rd.yzy_goods (goods_sn,goods_name,goods_number,market_price,dj,shop_price,is_on_sale,YPDM,CDMC,CDDM,GG,TXM,DW,JX,PZWH,BZ,ZBZ,YXQ,PH,ISRETAIL,PCH,SCRQ,goods_id_s) " +
            "select drugCode as goods_sn,spmch as goods_name,stock as goods_number,0 as market_price, " +
            "truncate(k_bbgwj*(select markUp from hykx_rd.lmsys where customNo = 'lm-bb'),2) as dj, " +
            "truncate(k_bbgwj*(select markUp from hykx_rd.lmsys where customNo = 'lm-bb')*(select markUp from lmsys where customNo = 'bb-ysb'),2) as shop_price,  " +
            "case jingd  " +
            "WHEN 'A' THEN (case DAYOFWEEK(NOW()) when 7 then 1 when 1 then 1 else 0 end)  " +
            "WHEN 'B' THEN (case when HOUR(NOW()) > 7  and HOUR(NOW()) <18 then 0 else 1 end) " +
            "ELSE 1 END as is_on_sale,zjm as YPDM,shpchd as CDMC,'' as CDDM,shpgg as GG, " +
            "sptm as TXM,dw as DW,jixing as JX,pizhwh as PZWH,jlgg as BZ,bzgg as ZBZ,validity as YXQ,batchNum as PH, " +
            "1 as ISRETAIL,1 as PCH ,prodDate as SCRQ,drugCode as goods_id_s " +
            " from hykx_rd.gysgoods where jingd <> '' ")
    void gysgoodsToyzygoods();

}


