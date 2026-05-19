package HD.projekt.drug.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DimCustomer", schema = "dbo")
public class DimCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerKey")
    private Integer customerKey;

    @Column(name = "CustomerNo")
    private Integer customerNo;

    @Column(name = "IsCustomerKnown")
    private Boolean isCustomerKnown;

    @Column(name = "CustomerType")
    private String customerType;

    public DimCustomer() {
    }

    public Integer getCustomerKey() {
        return customerKey;
    }

    public void setCustomerKey(Integer customerKey) {
        this.customerKey = customerKey;
    }

    public Integer getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(Integer customerNo) {
        this.customerNo = customerNo;
    }

    public Boolean getIsCustomerKnown() {
        return isCustomerKnown;
    }

    public void setIsCustomerKnown(Boolean isCustomerKnown) {
        this.isCustomerKnown = isCustomerKnown;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}