package HD.projekt.drug.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DimDataQuality", schema = "dbo")
public class DimDataQuality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DataQualityKey")
    private Integer dataQualityKey;

    @Column(name = "DataQualityFlag")
    private String dataQualityFlag;

    public DimDataQuality() {
    }

    public Integer getDataQualityKey() {
        return dataQualityKey;
    }

    public void setDataQualityKey(Integer dataQualityKey) {
        this.dataQualityKey = dataQualityKey;
    }

    public String getDataQualityFlag() {
        return dataQualityFlag;
    }

    public void setDataQualityFlag(String dataQualityFlag) {
        this.dataQualityFlag = dataQualityFlag;
    }
}