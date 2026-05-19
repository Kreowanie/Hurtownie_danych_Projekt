package HD.projekt.drug.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DimSource", schema = "dbo")
public class DimSource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SourceKey")
    private Integer sourceKey;

    @Column(name = "SourceDataset")
    private String sourceDataset;

    public DimSource() {
    }

    public Integer getSourceKey() {
        return sourceKey;
    }

    public void setSourceKey(Integer sourceKey) {
        this.sourceKey = sourceKey;
    }

    public String getSourceDataset() {
        return sourceDataset;
    }

    public void setSourceDataset(String sourceDataset) {
        this.sourceDataset = sourceDataset;
    }
}