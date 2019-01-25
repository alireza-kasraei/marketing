package net.devk.marketing.service.targets.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AggregateTargetResponseDTO {

	private final long summaryFromFirstDayToNow;

	private final long dayCount;

	private final long totalValue;

	private final long averageProgressToNow;

	private final long totalDay;

	private final long progressPercentageToNow;

	private final long todayProgress;

}
