package HD.projekt.drug.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DimDrug", schema = "dbo")
public class DimDrug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dimName")
    private String dimName;

    public DimDrug() {
    }

    public DimDrug(final String dimName) {
        this.dimName = dimName;
    }

    public Long getId() {
        return id;
    }

    public String getDimName() {
        return dimName;
    }
}