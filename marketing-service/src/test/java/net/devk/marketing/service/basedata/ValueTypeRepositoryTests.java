package net.devk.marketing.service.basedata;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValueTypeRepositoryTests {

	@Autowired
	private ValueTypeRepository valueTypeRepository;

	@Test
	public void saveAndFindAllTests() {

//		ValueType valueType = new ValueType();
//		valueType.setName("DUMMY");
//
//		valueTypeRepository.save(valueType);

		final long count = valueTypeRepository.count();

		Assert.assertEquals(3, count);

	}

}
