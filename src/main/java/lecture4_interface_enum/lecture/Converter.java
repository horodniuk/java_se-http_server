package lecture4_interface_enum.lecture;

public interface Converter<S, D> {
     D convert(S source);
}
