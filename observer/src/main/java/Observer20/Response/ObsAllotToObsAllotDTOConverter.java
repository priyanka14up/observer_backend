package Observer20.Response;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

import Observer20.Model.Obs_Allot;
import Observer20.payloads.ObsAllotDTO;

@Component
public class ObsAllotToObsAllotDTOConverter implements Converter<Obs_Allot, ObsAllotDTO> {

	@Override
	public JavaType getInputType(TypeFactory typeFactory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaType getOutputType(TypeFactory typeFactory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObsAllotDTO convert(Obs_Allot obs_Allot) {
		// TODO Auto-generated method stub
		return null;
	}
}



	

