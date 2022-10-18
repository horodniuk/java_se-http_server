package lecture3_static_method_abstract_inner_classes.lecture;

public class ObjectToStringConverter extends Converter<Object, String>{
    @Override
    public String convert(Object source) {
         return String.valueOf(source);
    }
}
