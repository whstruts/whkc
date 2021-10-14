package hykx.ds.whkc.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "third_customer", schema = "cloud_mall", catalog = "")
public class ThirdCustomerEntity {
    private String code;
    private String name;
    private String telephone;
    private String address;
    private String taxNumber;
    private String linkman;
    private String xkzh;

    @Id
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "tax_number")
    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    @Basic
    @Column(name = "linkman")
    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    @Basic
    @Column(name = "xkzh")
    public String getXkzh() {
        return xkzh;
    }

    public void setXkzh(String xkzh) {
        this.xkzh = xkzh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThirdCustomerEntity that = (ThirdCustomerEntity) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(name, that.name) &&
                Objects.equals(telephone, that.telephone) &&
                Objects.equals(address, that.address) &&
                Objects.equals(taxNumber, that.taxNumber) &&
                Objects.equals(linkman, that.linkman) &&
                Objects.equals(xkzh, that.xkzh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, telephone, address, taxNumber, linkman, xkzh);
    }
}
