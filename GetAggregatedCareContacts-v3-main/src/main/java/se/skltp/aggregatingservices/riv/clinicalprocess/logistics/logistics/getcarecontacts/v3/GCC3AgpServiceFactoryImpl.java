package se.skltp.aggregatingservices.riv.clinicalprocess.logistics.logistics.getcarecontacts.v3;

import java.util.List;
import lombok.extern.log4j.Log4j2;
import riv.clinicalprocess.logistics.logistics.enums.v3.ResultCodeEnum;
import riv.clinicalprocess.logistics.logistics.getcarecontactsresponder.v3.GetCareContactsResponseType;
import riv.clinicalprocess.logistics.logistics.getcarecontactsresponder.v3.GetCareContactsType;
import riv.clinicalprocess.logistics.logistics.v3.ResultType;
import se.skltp.aggregatingservices.AgServiceFactoryBase;

@Log4j2
public class GCC3AgpServiceFactoryImpl extends
    AgServiceFactoryBase<GetCareContactsType, GetCareContactsResponseType>{

@Override
public String getPatientId(GetCareContactsType queryObject){
    return queryObject.getPatientId().getId();
    }

@Override
public String getSourceSystemHsaId(GetCareContactsType queryObject){
    return queryObject.getSourceSystemHSAId();
    }

@Override
public GetCareContactsResponseType aggregateResponse(List<GetCareContactsResponseType> aggregatedResponseList ){

    GetCareContactsResponseType aggregatedResponse=new GetCareContactsResponseType();

    for (Object object : aggregatedResponseList) {
        GetCareContactsResponseType response = (GetCareContactsResponseType)object;
        aggregatedResponse.getCareContact().addAll(response.getCareContact());
    }

    aggregatedResponse.setResult(new ResultType());
    aggregatedResponse.getResult().setResultCode(ResultCodeEnum.INFO);
    aggregatedResponse.getResult().setLogId("NA");

    log.info("Returning {} aggregated care contacts GetCareContacts v3", aggregatedResponse.getCareContact().size());

    return aggregatedResponse;
    }
}

