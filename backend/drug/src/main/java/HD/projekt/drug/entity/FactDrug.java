package HD.projekt.drug.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "factDrug", schema = "dbo")
public class FactDrug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dimCity_id")
    private Integer dimCityId;

    @Column(name = "dimConTh_id")
    private Integer dimConThId;

    @Column(name = "dimDrug_id")
    private Integer dimDrugId;

    @Column(name = "dimDrugType_id")
    private Integer dimDrugTypeId;

    @Column(name = "dimMan_id")
    private Integer dimManId;

    @Column(name = "dimTime_id")
    private Integer dimTimeId;

    @Column(name = "is_refunded")
    private Boolean refunded;

    @Column(name = "cntDrug")
    private Integer cntDrug;

    @Column(name = "sumDrug")
    private Double sumDrug;

    @Column(name = "avgDrug")
    private Double avgDrug;

    @Column(name = "minDrug")
    private Double minDrug;

    @Column(name = "maxDrug")
    private Double maxDrug;

    public FactDrug() {
    }

    public FactDrug(
            final Integer dimCityId,
            final Integer dimConThId,
            final Integer dimDrugId,
            final Integer dimDrugTypeId,
            final Integer dimManId,
            final Integer dimTimeId,
            final Boolean refunded,
            final Integer cntDrug,
            final Double sumDrug,
            final Double avgDrug,
            final Double minDrug,
            final Double maxDrug
    ) {
        this.dimCityId = dimCityId;
        this.dimConThId = dimConThId;
        this.dimDrugId = dimDrugId;
        this.dimDrugTypeId = dimDrugTypeId;
        this.dimManId = dimManId;
        this.dimTimeId = dimTimeId;
        this.refunded = refunded;
        this.cntDrug = cntDrug;
        this.sumDrug = sumDrug;
        this.avgDrug = avgDrug;
        this.minDrug = minDrug;
        this.maxDrug = maxDrug;
    }

    public Long getId() {
        return id;
    }

    public Integer getDimCityId() {
        return dimCityId;
    }

    public Integer getDimConThId() {
        return dimConThId;
    }

    public Integer getDimDrugId() {
        return dimDrugId;
    }

    public Integer getDimDrugTypeId() {
        return dimDrugTypeId;
    }

    public Integer getDimManId() {
        return dimManId;
    }

    public Integer getDimTimeId() {
        return dimTimeId;
    }

    public Boolean getRefunded() {
        return refunded;
    }

    public Integer getCntDrug() {
        return cntDrug;
    }

    public Double getSumDrug() {
        return sumDrug;
    }

    public Double getAvgDrug() {
        return avgDrug;
    }

    public Double getMinDrug() {
        return minDrug;
    }

    public Double getMaxDrug() {
        return maxDrug;
    }
}