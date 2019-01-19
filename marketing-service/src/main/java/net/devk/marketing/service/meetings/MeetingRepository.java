package net.devk.marketing.service.meetings;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.model.Meeting;

interface MeetingRepository extends JpaRepository<Meeting, Long> {

}
