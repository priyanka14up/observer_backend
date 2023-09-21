
  package Observer20.Model; import java.io.IOException; import
  java.util.ArrayList; import java.util.List; import java.util.Map;
  
  import javax.persistence.AttributeConverter;
  
  import com.fasterxml.jackson.core.JsonProcessingException; import
  com.fasterxml.jackson.databind.ObjectMapper;
  
  
  
  public class Serialization implements AttributeConverter<List<Map>, String>{
  private final ObjectMapper objectMapper = new ObjectMapper();
  
  @Override public String convertToDatabaseColumn(List<Map> sidAidsMaps) {
  
  String sidAidsMapsJson = null;
  
  try {
  
  sidAidsMapsJson = objectMapper.writeValueAsString(sidAidsMaps);
  
  } catch (final JsonProcessingException e) {
  
  System.out.println("JSON writing error"+ e); }
  
  return sidAidsMapsJson;
  
  }
  
  @Override public List<Map> convertToEntityAttribute(String sidAidsMapsJson) {
  
  List<Map> sidAidsMaps = null;
  
  try {
  
  sidAidsMaps = objectMapper.readValue(sidAidsMapsJson, ArrayList.class);
  
  } catch (final IOException e) {
  
  System.out.println("JSON reading error"+e); }
  
  return sidAidsMaps; }
  
  
  }
  
 