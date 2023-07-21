//package Observer20.Model;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import jakarta.persistence.metamodel.Attribute;
//
//public class HashMapResponseDetails  implements Attribute<List<Response>, String>{
//	
//	private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public String convertToDatabaseColumn(List<Response> response) {
//
//        String coachDetailsJson = null;
//        
//        try {
//        	
//        	coachDetailsJson = objectMapper.writeValueAsString(coachDetails);
//        	
//        } catch (final JsonProcessingException e) {
//        	
//        	System.out.println("JSON writing error"+ e);
//        }
//
//        return coachDetailsJson;
//    }
//
//    @Override
//    public List<Response> convertToEntityAttribute(String coachDetailsJSON) {
//
//        List<Response> coachDetails = null;
//        
//        try {
//        	
//        	coachDetails = objectMapper.readValue(coachDetailsJSON, ArrayList.class);
//        	
//        } catch (final IOException e) {
//        	
//            System.out.println("JSON reading error"+e);
//        }
//
//        return coachDetails;
//    }
//    
//
//}
