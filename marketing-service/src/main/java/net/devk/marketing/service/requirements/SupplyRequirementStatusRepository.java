package net.devk.marketing.service.requirements;

import net.devk.marketing.service.model.SupplyRequirementStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyRequirementStatusRepository  extends JpaRepository<SupplyRequirementStatus, Long> {
}
