package hykx.ds.whkc.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "third_commodity", schema = "cloud_mall", catalog = "")
public class ThirdCommodityEntity {
    private String drugid;
    private String drugCommonName;
    private String nameZjm;
    private String manufacturer;
    private String manufacturerZjm;
    private String approveNumber;
    private String drugImg;
    private String recipeType;
    private String typeCode;
    private String dosageForm;
    private String appearance;
    private String bases;
    private String majorFunctions;
    private String untowardEffect;
    private String taboo;
    private String store;
    private String warnings;
    private String drugInteractions;
    private String brand;
    private String usageDosage;
    private String specifications;
    private String packageUnit;
    private String mediumPackage;
    private String largePackage;
    private String leftView;
    private String rightView;
    private String unpackView;
    private String specificationView;
    private String goodsSn;
    private String isRetail;
    private String productionBatch;
    private String dateExpiration;
    private String repertory;
    private String barCode;
    private String supplierName;
    private String supplier;
    private String supplierPrice;
    private String productionDate;

    @Id
    @Column(name = "drugid")
    public String getDrugid() {
        return drugid;
    }

    public void setDrugid(String drugid) {
        this.drugid = drugid;
    }

    @Basic
    @Column(name = "drugCommonName")
    public String getDrugCommonName() {
        return drugCommonName;
    }

    public void setDrugCommonName(String drugCommonName) {
        this.drugCommonName = drugCommonName;
    }

    @Basic
    @Column(name = "nameZjm")
    public String getNameZjm() {
        return nameZjm;
    }

    public void setNameZjm(String nameZjm) {
        this.nameZjm = nameZjm;
    }

    @Basic
    @Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "manufacturerZjm")
    public String getManufacturerZjm() {
        return manufacturerZjm;
    }

    public void setManufacturerZjm(String manufacturerZjm) {
        this.manufacturerZjm = manufacturerZjm;
    }

    @Basic
    @Column(name = "approveNumber")
    public String getApproveNumber() {
        return approveNumber;
    }

    public void setApproveNumber(String approveNumber) {
        this.approveNumber = approveNumber;
    }

    @Basic
    @Column(name = "drugImg")
    public String getDrugImg() {
        return drugImg;
    }

    public void setDrugImg(String drugImg) {
        this.drugImg = drugImg;
    }

    @Basic
    @Column(name = "recipeType")
    public String getRecipeType() {
        return recipeType;
    }

    public void setRecipeType(String recipeType) {
        this.recipeType = recipeType;
    }

    @Basic
    @Column(name = "typeCode")
    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    @Basic
    @Column(name = "dosageForm")
    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    @Basic
    @Column(name = "appearance")
    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    @Basic
    @Column(name = "bases")
    public String getBases() {
        return bases;
    }

    public void setBases(String bases) {
        this.bases = bases;
    }

    @Basic
    @Column(name = "majorFunctions")
    public String getMajorFunctions() {
        return majorFunctions;
    }

    public void setMajorFunctions(String majorFunctions) {
        this.majorFunctions = majorFunctions;
    }

    @Basic
    @Column(name = "untowardEffect")
    public String getUntowardEffect() {
        return untowardEffect;
    }

    public void setUntowardEffect(String untowardEffect) {
        this.untowardEffect = untowardEffect;
    }

    @Basic
    @Column(name = "taboo")
    public String getTaboo() {
        return taboo;
    }

    public void setTaboo(String taboo) {
        this.taboo = taboo;
    }

    @Basic
    @Column(name = "store")
    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    @Basic
    @Column(name = "warnings")
    public String getWarnings() {
        return warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    @Basic
    @Column(name = "drugInteractions")
    public String getDrugInteractions() {
        return drugInteractions;
    }

    public void setDrugInteractions(String drugInteractions) {
        this.drugInteractions = drugInteractions;
    }

    @Basic
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "usageDosage")
    public String getUsageDosage() {
        return usageDosage;
    }

    public void setUsageDosage(String usageDosage) {
        this.usageDosage = usageDosage;
    }

    @Basic
    @Column(name = "specifications")
    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    @Basic
    @Column(name = "packageUnit")
    public String getPackageUnit() {
        return packageUnit;
    }

    public void setPackageUnit(String packageUnit) {
        this.packageUnit = packageUnit;
    }

    @Basic
    @Column(name = "mediumPackage")
    public String getMediumPackage() {
        return mediumPackage;
    }

    public void setMediumPackage(String mediumPackage) {
        this.mediumPackage = mediumPackage;
    }

    @Basic
    @Column(name = "largePackage")
    public String getLargePackage() {
        return largePackage;
    }

    public void setLargePackage(String largePackage) {
        this.largePackage = largePackage;
    }

    @Basic
    @Column(name = "leftView")
    public String getLeftView() {
        return leftView;
    }

    public void setLeftView(String leftView) {
        this.leftView = leftView;
    }

    @Basic
    @Column(name = "rightView")
    public String getRightView() {
        return rightView;
    }

    public void setRightView(String rightView) {
        this.rightView = rightView;
    }

    @Basic
    @Column(name = "unpackView")
    public String getUnpackView() {
        return unpackView;
    }

    public void setUnpackView(String unpackView) {
        this.unpackView = unpackView;
    }

    @Basic
    @Column(name = "specificationView")
    public String getSpecificationView() {
        return specificationView;
    }

    public void setSpecificationView(String specificationView) {
        this.specificationView = specificationView;
    }

    @Basic
    @Column(name = "goodsSn")
    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    @Basic
    @Column(name = "isRetail")
    public String getIsRetail() {
        return isRetail;
    }

    public void setIsRetail(String isRetail) {
        this.isRetail = isRetail;
    }

    @Basic
    @Column(name = "productionBatch")
    public String getProductionBatch() {
        return productionBatch;
    }

    public void setProductionBatch(String productionBatch) {
        this.productionBatch = productionBatch;
    }

    @Basic
    @Column(name = "dateExpiration")
    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    @Basic
    @Column(name = "repertory")
    public String getRepertory() {
        return repertory;
    }

    public void setRepertory(String repertory) {
        this.repertory = repertory;
    }

    @Basic
    @Column(name = "barCode")
    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    @Basic
    @Column(name = "supplierName")
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Basic
    @Column(name = "supplier")
    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Basic
    @Column(name = "supplierPrice")
    public String getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(String supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

    @Basic
    @Column(name = "productionDate")
    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThirdCommodityEntity that = (ThirdCommodityEntity) o;
        return Objects.equals(drugid, that.drugid) &&
                Objects.equals(drugCommonName, that.drugCommonName) &&
                Objects.equals(nameZjm, that.nameZjm) &&
                Objects.equals(manufacturer, that.manufacturer) &&
                Objects.equals(manufacturerZjm, that.manufacturerZjm) &&
                Objects.equals(approveNumber, that.approveNumber) &&
                Objects.equals(drugImg, that.drugImg) &&
                Objects.equals(recipeType, that.recipeType) &&
                Objects.equals(typeCode, that.typeCode) &&
                Objects.equals(dosageForm, that.dosageForm) &&
                Objects.equals(appearance, that.appearance) &&
                Objects.equals(bases, that.bases) &&
                Objects.equals(majorFunctions, that.majorFunctions) &&
                Objects.equals(untowardEffect, that.untowardEffect) &&
                Objects.equals(taboo, that.taboo) &&
                Objects.equals(store, that.store) &&
                Objects.equals(warnings, that.warnings) &&
                Objects.equals(drugInteractions, that.drugInteractions) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(usageDosage, that.usageDosage) &&
                Objects.equals(specifications, that.specifications) &&
                Objects.equals(packageUnit, that.packageUnit) &&
                Objects.equals(mediumPackage, that.mediumPackage) &&
                Objects.equals(largePackage, that.largePackage) &&
                Objects.equals(leftView, that.leftView) &&
                Objects.equals(rightView, that.rightView) &&
                Objects.equals(unpackView, that.unpackView) &&
                Objects.equals(specificationView, that.specificationView) &&
                Objects.equals(goodsSn, that.goodsSn) &&
                Objects.equals(isRetail, that.isRetail) &&
                Objects.equals(productionBatch, that.productionBatch) &&
                Objects.equals(dateExpiration, that.dateExpiration) &&
                Objects.equals(repertory, that.repertory) &&
                Objects.equals(barCode, that.barCode) &&
                Objects.equals(supplierName, that.supplierName) &&
                Objects.equals(supplier, that.supplier) &&
                Objects.equals(supplierPrice, that.supplierPrice) &&
                Objects.equals(productionDate, that.productionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drugid, drugCommonName, nameZjm, manufacturer, manufacturerZjm, approveNumber, drugImg, recipeType, typeCode, dosageForm, appearance, bases, majorFunctions, untowardEffect, taboo, store, warnings, drugInteractions, brand, usageDosage, specifications, packageUnit, mediumPackage, largePackage, leftView, rightView, unpackView, specificationView, goodsSn, isRetail, productionBatch, dateExpiration, repertory, barCode, supplierName, supplier, supplierPrice, productionDate);
    }
}
