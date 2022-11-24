package lecture3_static_method_abstract_inner_classes.lecture;

public class StringToIntegerConverter extends Converter<String, Integer> {
    @Override
    public Integer convert(String source) {
        return Integer.parseInt(source);
    }
}
