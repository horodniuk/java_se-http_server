package lecture3_static_method_abstract_inner_classes.lecture;

public class OuterClass {
    private static class InnerStaticClass {
    }
    private class InnerClass {
    }
    private void method1(){
        class InnerMethod1Class {
        }
    }
    private void method2(){
        {
            class InnerMethod2Class {
            }
        }
    }
}
