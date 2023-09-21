/*
 * package Observer20.payloads;
 * 
 * import javax.persistence.AttributeConverter; import
 * javax.persistence.Converter;
 * 
 * import Observer20.Model.ObserverUser;
 * 
 * 
 * @Converter public class ObserverUserConverter implements
 * AttributeConverter<ObserverUser, String> {
 * 
 * @Override public String convertToDatabaseColumn(ObserverUser user) { //
 * Convert ObserverUser to its unique identifier (e.g., user ID or username)
 * return user != null ? user.getObscode() : null; }
 * 
 * @Override public ObserverUser convertToEntityAttribute(String uniqueId) { //
 * Convert the unique identifier back to an ObserverUser object if (uniqueId !=
 * null) { ObserverUser user = new ObserverUser(); user.setObscode(uniqueId); //
 * Set the unique identifier in the ObserverUser object return user; } return
 * null; // Handle the case when uniqueId is null } }
 * 
 * 
 * 
 */