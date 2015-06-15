package com.scb.event.invocator.test;

import static org.junit.Assert.assertNotNull;
import static org.ops4j.pax.exam.CoreOptions.maven;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.configureConsole;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.features;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.karafDistributionConfiguration;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.logLevel;

import java.io.File;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.karaf.options.LogLevelOption.LogLevel;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scb.event.workflow.core.EventInvocator;
import com.scb.event.workflow.model.ProcessContext;

/**
 * 
 * Test class for {@link CacheService}
 * 
 */

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class EventInvocatorIntegrationTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventInvocatorIntegrationTest.class);

	@Inject
	private BundleContext bundleContext;

	private EventInvocator eventInvocator;

	@Configuration
	public Option[] config() {
		return new Option[] {
				karafDistributionConfiguration()
						.frameworkUrl(
								maven().groupId("org.apache.servicemix").artifactId("apache-servicemix").type("zip")
										.version("6.0.0.M1")).karafVersion("3.0.3").name("Apache ServiceMix")
						.unpackDirectory(new File("target/pax")).useDeployFolder(false),
				// keepRuntimeFolder(),
				configureConsole().ignoreLocalConsole(),
				logLevel(LogLevel.INFO),
				// To enable the other cache provider, please uncomment the below line.
				features("mvn:com.scb.deployment/wb-transaction-api-features/1.0.0/xml/features", "integration-test",
						"karaf-shell"),
		// features("mvn:com.scb.cache.features/cache-features/1.0.0-SNAPSHOT/xml/features",
		// "ehcache-cache-service"),
		// To enable DEBUG, uncomment the below line.
		// debugConfiguration("5000", true)
		};
	}

	@Before
	public void setup() {
		final ServiceReference<EventInvocator> serviceReference = bundleContext
				.getServiceReference(EventInvocator.class);
		try {
			assertNotNull(serviceReference);
			eventInvocator = bundleContext.getService(serviceReference);
			assertNotNull(eventInvocator);
		} finally {
			bundleContext.ungetService(serviceReference);
		}
	}

	@Test
	public void putAllValidDataSuccess() {
		// Method under test
		System.out.println("**** Entering the init Method of EventInvocator impl ");
		final ProcessContext context = new ProcessContext();
		context.setActionId("DEAL_PERSISTENCE_ACTION");
		context.setApplicationGroup("FAP");
		context.setChunkProcessingEnabled(Boolean.FALSE);
		context.setCountry("India");
		context.setEntity("DEAL");
		context.setFlowId("DEAL_PERSISTENCE_FLOW");
		context.setFunction("CF");
		context.setInstanceCode("123");
		context.setUserId("1297014");
		final Object object = new Object();
		eventInvocator.invoke(context, object);
		System.out.println("Exiting the init method of Event Invocator");
		LOGGER.info("Test Case Executed Successfully");
	}

}