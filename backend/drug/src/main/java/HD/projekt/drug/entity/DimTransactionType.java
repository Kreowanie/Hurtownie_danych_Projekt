package HD.projekt.drug.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DimTransactionType", schema = "dbo")
public class DimTransactionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionTypeKey")
    private Integer transactionTypeKey;

    @Column(name = "TransactionType")
    private String transactionType;

    @Column(name = "IsCancelled")
    private Boolean isCancelled;

    @Column(name = "IsReturn")
    private Boolean isReturn;

    public DimTransactionType() {
    }

    public Integer getTransactionTypeKey() {
        return transactionTypeKey;
    }

    public void setTransactionTypeKey(Integer transactionTypeKey) {
        this.transactionTypeKey = transactionTypeKey;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Boolean getIsCancelled() {
        return isCancelled;
    }

    public void setIsCancelled(Boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    public Boolean getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(Boolean isReturn) {
        this.isReturn = isReturn;
    }
}