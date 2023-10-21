//package Observer20.payloads;
//
//
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.data.jpa.repository.query.AbstractJpaQuery;
//import Observer20.Dto.QuestionStaticArrivalDto;
//import Observer20.Model.QuestionStatic;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class Convertor implements Converter<AbstractJpaQuery.TupleConverter.TupleBackedMap,QuestionStatic> {
//
//    @Override
//    public QuestionStatic convert(AbstractJpaQuery.TupleConverter.TupleBackedMap source) {
//        // Create a new instance of QuestionStaticArrivalDto
//        QuestionStatic dto = new QuestionStatic();
//
//        // Extract data from the TupleBackedMap and set it in the DTO
//        dto.setQid((Long)source.get("qid"));
//      
//        dto.setName((String) source.get("name"));
//        dto.setOtherField((String) source.get("otherField"));
//
//        // You can continue setting other fields as needed
//
//        return dto;
//    }
//}
//
//
//
//
//
