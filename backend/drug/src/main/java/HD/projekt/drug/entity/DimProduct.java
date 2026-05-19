package HD.projekt.drug.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DimProduct", schema = "dbo")
public class DimProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductKey")
    private Integer productKey;

    @Column(name = "ProductNo")
    private String productNo;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "ProductCategory")
    private String productCategory;

    public DimProduct() {
    }

    public Integer getProductKey() {
        return productKey;
    }

    public void setProductKey(Integer productKey) {
        this.productKey = productKey;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
}