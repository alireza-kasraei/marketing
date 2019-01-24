package net.devk.marketing.service.charts.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AggregateTargetResponseDTO {

	private long summaryFromFirstDayToNow;

	private int dayCount;

	private long totalAmount;

	private long averageProgressToNow;

	private int totalDay;

	private int progressPercentageToNow;

	private int todayProgress;

}
