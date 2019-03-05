package net.devk.marketing.service.basedata;

import net.devk.marketing.service.model.SupplyStatusType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyStatusTypeRepository extends JpaRepository<SupplyStatusType, Long> {

    public SupplyStatusType findByCode(String code);
}
