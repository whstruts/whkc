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

//    @Insert("replace INTO hykx_rd.BBSPJG(drugCode,price,chainprice) VALUES(#{drugCode},#{price},#{chainprice})")
//    void insertBBSPJG(BBSPJG bbspjg);
//
//    @Insert("replace INTO hykx_rd.BBSPKC(drugCode,stock) VALUES(#{drugCode},#{stock})")
//    void insertBBSPKC(BBSPKC bbspkc);
//
//    @Insert("replace INTO hykx_rd.BBSPPH(drugCode,batchNum,prodDate,validity) VALUES(#{drugCode},#{batchNum},#{prodDate},#{validity})")
//    void insertBBSPPH(BBSPPH bbspph);
//
//    @Insert("replace INTO hykx_rd.BBSPZL(drugCode,drugName,pack,factory,unit,barcode,approval,busiType,stock,price,inCode,step,taxRate,wholePack,recommendedPrice) "+
//              " VALUES(#{drugCode},#{drugName},#{pack},#{factory},#{unit},#{barcode},#{approval},#{busiType},#{stock},#{price},#{inCode},#{step},#{taxRate},#{wholePack},#{recommendedPrice})")
//    void insertBBSPZL(BBSPZL bbspzl);

//	@Insert("replace INTO huayuanra.zt_kh(code,dwbh,name,jyfw,zzzch,zzyxqz,xkzh,xkzyxqz,gspzh,gspzyxqz,dwjb,qyfr,shr1,email,telephone,fzrlxdh)" +
//            " VALUES(#{code},#{dwbh},#{name},#{jyfw},#{zzzch},#{zzyxqz},#{xkzh},#{xkzyxqz},#{gspzh},#{gspzyxqz},#{dwjb},#{qyfr},#{shr1},#{email},#{telephone},#{fzrlxdh}) ")
//	void insert(Khzl khzl);
//
//    @Insert("replace INTO huayuanra.zt_ywkc(code,amount,is_exist,batchnumber,validdate,productdate) VALUES(#{code},#{amount},1,#{batchnumber},#{validdate},#{productdate})")
//    void insertKC(SpKC spkc);
//
//    @Insert("replace INTO huayuanra.zt_ddzt(kpbh,kprq,ds) VALUES(#{kpbh},#{kprq},#{ds})")
//    void insertDD(Ddzt ddzt);
//
//    @Insert("replace INTO hykx_rd.zt_dzfp(orderId,invoiceCode,invoiceNo,securityCode,invoiceUrl,dates,xsddbh) " +
//            " VALUES(#{orderId},#{invoiceCode},#{invoiceNo},#{securityCode},#{invoiceUrl},#{dates},#{xsddbh})")
//    void insertDZFP(DZFP dzfp);
//
//    @Insert("replace INTO huayuanra.zt_spzl(code,spmc,spgg,spcd,pzwh) VALUES(#{code},#{spmc},#{spgg},#{spcd},#{pzwh})")
//    void insertSP(Spzl spzl);

//    @Select("select oi.order_sn kpbh,DATE_FORMAT(oi.hy_time,'%Y-%m-%d') kprq, " +
//            "oi.hyds_userid khcode, kh.name khmc,kh.address shdz,'4' soft, " +
//            "oi.hyds_ddid dsfddh,oi.ahhy_ddid hyzbddh " +
//            "from huayuanra.yzy_order_info oi,huayuanra.zt_kh kh " +
//            "where oi.is_to_erp = 0 and oi.pay_status = 2 and oi.is_upload = 1 " +
//            "and oi.order_status > 0 " +
//            "and oi.ahhy_ddid is not null " +
//            "and oi.hyds_ddid is not NULL " +
//            "and oi.hy_time is not NULL " +
//            "and oi.hyds_userid is not null  and oi.hyds_userid !='' " +
//            "and oi.hyds_userid = kh.code ")
//    public List<ERPddhz> getddhz();

//    @Select("select oi.order_sn kpbh,DATE_FORMAT(oi.hy_time,'%Y-%m-%d') kprq, " +
//            "oi.hyds_userid khcode, kh.name khmc,kh.address shdz,'4' soft, " +
//            "oi.hyds_ddid dsfddh,oi.ahhy_ddid hyzbddh " +
//            "from huayuanra.yzy_order_info oi,huayuanra.zt_kh kh " +
//            "where oi.is_to_erp = 0 and oi.pay_status = 2 and oi.is_upload = 1 " +
//            "and oi.order_status > 0 " +
//            "and oi.ahhy_ddid is not null " +
//            "and oi.hyds_ddid is not NULL " +
//            "and oi.hy_time is not NULL " +
//            "and oi.hyds_userid is not null  and oi.hyds_userid !='' " +
//            "and oi.hyds_userid = kh.code ")
//    public List<ysbddhz> getysbddhz();

//
//    @Select("select oi.order_sn kpbh,og.goods_id,og.rec_id ywxh,'' code,og.goods_name spmc, " +
//            "g.gg spgg,g.cdmc spcd,g.jx jx,g.dw unit,g.bz spbz,g.PZWH pzwh,og.goods_number amount, " +
//            "case when g.dj is null then format(og.goods_price/1.17,2) " +
//            "else g.dj end  factprice,og.goods_price xfactprice,case when LOCATE(',',g.ph) > 0 then SUBSTR(g.ph,1,LOCATE(',',g.ph)-1) " +
//            "else g.ph end batchnumber,'' packages, " +
//            "case when LENGTH(g.yxq) < 10 then SUBSTR(DATE_FORMAT(LAST_DAY(STR_TO_DATE(g.YXQ,'%Y-%m-%d')),'%Y%m%d'),1,6) " +
//            "else DATE_FORMAT(LAST_DAY(STR_TO_DATE(g.YXQ,'%Y-%m-%d')),'%Y%m%d') end yxqz, " +
//            "DATE_FORMAT(LAST_DAY(STR_TO_DATE(g.YXQ,'%Y-%m-%d')),'%Y%m%d') validdate,g.SCRQ productdate,case when og.is_lock_kc = 2 then 1 " +
//            "else 2 end  fhdd, " +
//            "DATE_FORMAT(NOW(),'%Y-%m-%d') kprq, " +
//            "DATE_FORMAT(NOW(),'%Y-%m-%d') factkprq " +
//            "from yzy_order_info oi,yzy_order_goods og,yzy_goods g  " +
//            "where oi.is_to_erp = 1 and oi.pay_status = 2 and oi.is_upload = 1 " +
//            "and oi.order_status > 0 " +
//            "and oi.ahhy_ddid is not null " +
//            "and oi.hyds_ddid is not NULL " +
//            "and og.goods_sn like 'HYYP%' " +
//            "and og.is_to_erp = 0 " +
//            "and oi.hyds_userid is not null  and oi.hyds_userid !='' " +
//            "and oi.order_id = og.order_id  " +
//            "and og.goods_id = g.goods_id ")
//    public List<ERPddmx> getddmx();

//    @Select("select oi.order_sn kpbh,og.goods_id,og.rec_id ywxh,'' code,og.goods_name spmc, " +
//            "g.gg spgg,g.cdmc spcd,g.jx jx,g.dw unit,g.bz spbz,g.PZWH pzwh,og.goods_number amount, " +
//            "case when g.dj is null then format(og.goods_price/1.17,2) " +
//            "else g.dj end  factprice,og.goods_price xfactprice,case when LOCATE(',',g.ph) > 0 then SUBSTR(g.ph,1,LOCATE(',',g.ph)-1) " +
//            "else g.ph end batchnumber,'' packages, " +
//            "case when LENGTH(g.yxq) < 10 then SUBSTR(DATE_FORMAT(LAST_DAY(STR_TO_DATE(g.YXQ,'%Y-%m-%d')),'%Y%m%d'),1,6) " +
//            "else DATE_FORMAT(LAST_DAY(STR_TO_DATE(g.YXQ,'%Y-%m-%d')),'%Y%m%d') end yxqz, " +
//            "DATE_FORMAT(LAST_DAY(STR_TO_DATE(g.YXQ,'%Y-%m-%d')),'%Y%m%d') validdate,g.SCRQ productdate,case when og.is_lock_kc = 2 then 1 " +
//            "else 2 end  fhdd, " +
//            "DATE_FORMAT(NOW(),'%Y-%m-%d') kprq, " +
//            "DATE_FORMAT(NOW(),'%Y-%m-%d') factkprq " +
//            "from huayuanra.yzy_order_info oi,huayuanra.yzy_order_goods og,huayuanra.yzy_goods g  " +
//            "where oi.is_to_erp = 0 and oi.pay_status = 2 and oi.is_upload = 1 " +
//            "and oi.order_status > 0 " +
//            "and oi.ahhy_ddid is not null " +
//            "and oi.hyds_ddid is not NULL " +
//            "and og.goods_sn like 'HYYP%' " +
//            "and og.is_to_erp = 0 " +
//            "and oi.hyds_userid is not null  and oi.hyds_userid !='' " +
//            "and oi.order_id = og.order_id  " +
//            "and og.goods_id = g.goods_id " +
//            "and oi.order_sn = #{kpbh}")
//    public List<ERPddmx> getddmxbyid(String kpbh);

//    @Update("update huayuanra.yzy_order_info set is_to_erp = 1 where is_to_erp = 0 and order_sn = #{kpbh}")
//    public void updatedd(String kpbh);

//    @Update("update huayuanra.yzy_order_info oi,huayuanra.yzy_order_goods og set og.is_to_erp = 1 where  oi.order_id = og.order_id and og.is_to_erp = 0 and oi.order_sn = #{kpbh} and og.goods_id = #{goods_id}")
//    public void updateddmx(ERPddmx mx);

//    @Select("call huayuanra.HY_INF_KC_YYY_YSB()")
//    public void DoYSBWriteBack();
}


