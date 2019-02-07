package net.devk.marketing.service.basedata;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import net.devk.marketing.service.basedata.dto.AggregatedBasedataDTO;
import net.devk.marketing.service.model.BusinessScale;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasedataServiceTests {

	@Autowired
	private BasedataService basedataService;

	@Test
	public void testGetAggregatedBasedata() {
		AggregatedBasedataDTO aggregatedBasedata = basedataService.getAggregatedBasedata();
		// data.sql has items
		assertNotEquals(aggregatedBasedata.getBusinessScales().size(), 0);
		assertNotEquals(aggregatedBasedata.getAssignStatusTypes(), 0);
		assertNotEquals(aggregatedBasedata.getServices(), 0);
		assertNotEquals(aggregatedBasedata.getAttractionTypes(), 0);
		assertNotEquals(aggregatedBasedata.getContactRoles(), 0);
		assertNotEquals(aggregatedBasedata.getDocumentTypes(), 0);
		assertNotEquals(aggregatedBasedata.getOrganizationTypes(), 0);
		assertNotEquals(aggregatedBasedata.getOwnershipTypes(), 0);
		assertNotEquals(aggregatedBasedata.getRequirementStatusTypes(), 0);
		assertNotEquals(aggregatedBasedata.getValueTypes(), 0);
	}

	@Test
	public void testGetExistingBusinessScale() {
		// data.sql has items
		BusinessScale businessScale = basedataService.findOneBusinessScale(1L);
		assertNotNull(businessScale);
	}

	@Test(expected = EntityNotFoundException.class)
	@Transactional
	public void testGetNonExistingBusinessScale() {
		// data.sql has items
		BusinessScale businessScale = basedataService.findOneBusinessScale(Long.MAX_VALUE);
		businessScale.getName();
	}

}
