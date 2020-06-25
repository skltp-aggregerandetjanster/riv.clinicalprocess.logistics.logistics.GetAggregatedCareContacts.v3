package se.skltp.aggregatingservices.riv.clinicalprocess.logistics.logistics.getcarecontacts.v3;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import riv.clinicalprocess.logistics.logistics.getcarecontactsrequest.v3.GetCareContactsResponderInterface;
import riv.clinicalprocess.logistics.logistics.getcarecontactsrequest.v3.GetCareContactsResponderService;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "getaggregatedcarecontacts.v3")
public class GCC3AgpServiceConfiguration extends se.skltp.aggregatingservices.configuration.AgpServiceConfiguration {

public static final String SCHEMA_PATH = "/schemas/clinicalprocess_logistics_logistics_3.0.0/interactions/GetCareContactsInteraction/GetCareContactsInteraction_3.0_RIVTABP21.wsdl";

  public GCC3AgpServiceConfiguration() {

    setServiceName("GetAggregatedCareContacts-v3");
    setTargetNamespace("urn:riv:clinicalprocess:logistics:logistics:GetCareContacts:3:rivtabp21");

    // Set inbound defaults
    setInboundServiceURL("http://0.0.0.0:9021/GetAggregatedCareContacts/service/v3");
    setInboundServiceWsdl(SCHEMA_PATH);
    setInboundServiceClass(GetCareContactsResponderInterface.class.getName());
    setInboundPortName(GetCareContactsResponderService.GetCareContactsResponderPort.toString());

    // Set outbound defaults
    setOutboundServiceWsdl(SCHEMA_PATH);
    setOutboundServiceClass(getInboundServiceClass());
    setOutboundPortName(getInboundPortName());

    // FindContent
    setEiServiceDomain("riv:clinicalprocess:logistics:logistics");
    setEiCategorization("vko");

    // TAK
    setTakContract("urn:riv:clinicalprocess:logistics:logistics:GetCareContactsResponder:3");

    // Set service factory
    setServiceFactoryClass(GCC3AgpServiceFactoryImpl.class.getName());
    }


}
