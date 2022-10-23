package lecture4_interface_enum.lecture;

public class ObjectToStringConverter implements Converter<Object, String> {
    @Override
    public String convert(Object source) {
         return String.valueOf(source);
    }
}
