package org.ligoj.app.plugin.qa;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ligoj.app.AbstractAppTest;
import org.ligoj.app.model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test class of {@link QaResource}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/application-context-test.xml")
@Rollback
@Transactional
public class QaResourceTest extends AbstractAppTest {

	@Autowired
	private QaResource resource;

	@Before
	public void prepareData() throws IOException {
		persistEntities("csv", new Class[] { Node.class }, StandardCharsets.UTF_8.name());
	}

	@Test
	public void getKey() throws IOException {
		// Coverage only
		Assert.assertEquals("service:qa", resource.getKey());
	}
}
