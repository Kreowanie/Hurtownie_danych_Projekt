package HD.projekt.drug.Repozytorium;

import HD.projekt.drug.entity.FactDrug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactDrugRepository extends JpaRepository<FactDrug, Long> {
}