package net.devk.marketing.service.targets;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.model.TargetMember;

interface TargetMemberRepository extends JpaRepository<TargetMember, Long> {

}
