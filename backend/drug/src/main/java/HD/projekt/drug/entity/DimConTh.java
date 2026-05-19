package HD.projekt.drug.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DimConTh", schema = "dbo")
public class DimConTh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "dimName")
    private String dimName;

    public DimConTh() {
    }

    public DimConTh(final String dimName) {
        this.dimName = dimName;
    }

    public Integer getId() {
        return id;
    }

    public String getDimName() {
        return dimName;
    }
}