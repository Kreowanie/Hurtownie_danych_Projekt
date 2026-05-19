package HD.projekt.drug.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DimCountry", schema = "dbo")
public class DimCountry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CountryKey")
    private Integer countryKey;

    @Column(name = "Country")
    private String country;

    @Column(name = "CountryGroup")
    private String countryGroup;

    @Column(name = "IsUnitedKingdom")
    private Boolean isUnitedKingdom;

    public DimCountry() {
    }

    public Integer getCountryKey() {
        return countryKey;
    }

    public void setCountryKey(Integer countryKey) {
        this.countryKey = countryKey;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryGroup() {
        return countryGroup;
    }

    public void setCountryGroup(String countryGroup) {
        this.countryGroup = countryGroup;
    }

    public Boolean getIsUnitedKingdom() {
        return isUnitedKingdom;
    }

    public void setIsUnitedKingdom(Boolean isUnitedKingdom) {
        this.isUnitedKingdom = isUnitedKingdom;
    }
}