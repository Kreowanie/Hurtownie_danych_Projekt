package HD.projekt.drug.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DimMan", schema = "dbo")
public class DimMan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dimName")
    private String dimName;

    public DimMan() {
    }

    public DimMan(final String dimName) {
        this.dimName = dimName;
    }

    public Long getId() {
        return id;
    }

    public String getDimName() {
        return dimName;
    }
}