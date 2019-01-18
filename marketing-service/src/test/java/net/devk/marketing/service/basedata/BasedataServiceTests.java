package net.devk.marketing.service.basedata;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.devk.marketing.service.basedata.dto.AggregatedBasedataDTO;
import net.devk.marketing.service.model.BusinessScale;
import net.devk.marketing.service.model.ValueType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasedataServiceTests {

	@Autowired
	private BasedataService basedataService;

	@Autowired
	private ValueTypeRepository valueTypeRepository;

	@Autowired
	private BusinessScaleRepository businessScaleRepository;

	@Test
	public void aggregateBasedataTest() {

		ValueType valueType = new ValueType();
		valueType.setName("DUMMY");
		valueTypeRepository.save(valueType);

		BusinessScale businessScale = new BusinessScale();
		businessScale.setName("DUMMY_SCALE");
		businessScaleRepository.save(businessScale);

		AggregatedBasedataDTO aggregatedBasedata = basedataService.getAggregatedBasedata();
		Assert.assertEquals(1, aggregatedBasedata.getValueTypes().size());
		Assert.assertEquals(1, aggregatedBasedata.getBusinessScales().size());

	}

}
