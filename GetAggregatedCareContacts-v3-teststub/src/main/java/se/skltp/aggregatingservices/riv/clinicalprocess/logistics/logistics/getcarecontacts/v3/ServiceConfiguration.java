package se.skltp.aggregatingservices.riv.clinicalprocess.logistics.logistics.getcarecontacts.v3;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import riv.clinicalprocess.logistics.logistics.getcarecontactsrequest.v3.GetCareContactsResponderInterface;
import riv.clinicalprocess.logistics.logistics.getcarecontactsrequest.v3.GetCareContactsResponderService;
import se.skltp.aggregatingservices.config.TestProducerConfiguration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="getaggregatedcarecontacts.v3.teststub")
public class ServiceConfiguration extends TestProducerConfiguration {

  public static final String SCHEMA_PATH = "/schemas/clinicalprocess_logistics_logistics_3.0.0/interactions/GetCareContactsInteraction/GetCareContactsInteraction_3.0_RIVTABP21.wsdl";

  public ServiceConfiguration() {
    setProducerAddress("http://localhost:8083/vp");
    setServiceClass(GetCareContactsResponderInterface.class.getName());
    setServiceNamespace("urn:riv:clinicalprocess:logistics:logistics:GetCareContactsResponder:3");
    setPortName(GetCareContactsResponderService.GetCareContactsResponderPort.toString());
    setWsdlPath(SCHEMA_PATH);
    setTestDataGeneratorClass(ServiceTestDataGenerator.class.getName());
    setServiceTimeout(27000);
  }

}
