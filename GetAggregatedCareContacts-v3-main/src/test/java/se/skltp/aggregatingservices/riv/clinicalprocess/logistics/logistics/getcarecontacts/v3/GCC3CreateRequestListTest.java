package se.skltp.aggregatingservices.riv.clinicalprocess.logistics.logistics.getcarecontacts.v3;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import riv.clinicalprocess.logistics.logistics.getcarecontactsresponder.v3.GetCareContactsResponseType;
import se.skltp.aggregatingservices.api.AgpServiceFactory;
import se.skltp.aggregatingservices.tests.CreateRequestListTest;

@RunWith(SpringJUnit4ClassRunner.class)
public class GCC3CreateRequestListTest extends CreateRequestListTest {

  private static GCC3AgpServiceConfiguration configuration = new GCC3AgpServiceConfiguration();
  private static AgpServiceFactory<GetCareContactsResponseType> agpServiceFactory = new GCC3AgpServiceFactoryImpl();
  private static ServiceTestDataGenerator testDataGenerator = new ServiceTestDataGenerator();


  public GCC3CreateRequestListTest() {
    super(testDataGenerator, agpServiceFactory, configuration);
  }
}