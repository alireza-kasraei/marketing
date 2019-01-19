package net.devk.marketing.service.meetings;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.model.MeetingResult;

interface MeetingResultRepository extends JpaRepository<MeetingResult, Long> {

}
