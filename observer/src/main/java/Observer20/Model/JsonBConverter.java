//package Observer20.Model;
//
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.type.MapType;
//
//import Observer20.Dto.SubformResponse;
//
//import org.springframework.stereotype.Component;
//
//import javax.persistence.AttributeConverter;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class JsonBConverter implements AttributeConverter<Map<String, SubformResponse>, String> {
//
//    private final ObjectMapper objectMapper = new ObjectMapper();
//   // private final TypeFactory typeFactory = objectMapper.getTypeFactory();
//    //private final MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, SubformResponse.class);
//	
//   // private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public String convertToDatabaseColumn(Map<String, SubformResponse> attribute) {
//        try {
//            return objectMapper.writeValueAsString(attribute);
//        } catch (JsonProcessingException e) {
//            // Handle the exception (e.g., log, throw, etc.)
//            return null;
//        }
//    }
//
//    @Override
//    public Map<String, SubformResponse> convertToEntityAttribute(String dbData) {
//        if (dbData == null) {
//            return new HashMap<>();
//        }
//
//        try {
//            return objectMapper.readValue(dbData, mapType);
//        } catch (IOException e) {
//            // Handle the exception (e.g., log, throw, etc.)
//            return new HashMap<>();
//        }
//    }
//}
