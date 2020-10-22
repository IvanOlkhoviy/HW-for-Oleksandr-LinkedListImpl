import annotations.ShowMethodAnnotation;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args){
    LinkedListImpl linkedList = new LinkedListImpl();
    linkedList.add(20);

    showTaggedMethods(linkedList);
    }

    public static void showTaggedMethods(List list){
        Method[] methods = list.getClass().getMethods();
        Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(ShowMethodAnnotation.class))
                .forEach(method -> System.out.println(method.getAnnotatedReturnType() + " " + method.getName() + "()"));
    }
}
