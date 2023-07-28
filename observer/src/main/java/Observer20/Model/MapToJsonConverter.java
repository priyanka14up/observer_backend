package Observer20.Model;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Converter
public class MapToJsonConverter implements AttributeConverter<Map<Long, List<Long>>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<Long, List<Long>> attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            // Handle the exception (e.g., log, throw, etc.)
            return null;
        }
    }

    @Override
    public Map<Long, List<Long>> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return new HashMap<>();
        }

        try {
            return objectMapper.readValue(dbData, Map.class);
        } catch (IOException e) {
            // Handle the exception (e.g., log, throw, etc.)
            return new HashMap<>();
        }
    }
}