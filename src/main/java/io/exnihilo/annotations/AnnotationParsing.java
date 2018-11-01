package io.exnihilo.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationParsing {

    public static void main(String[] args) {
        try {
            for (Method method : AnnotationParsing.class.getClassLoader().loadClass(("io.exnihilo.annotations.AnnotationExample")).getMethods()) {
                // checks if MethodInfo annotation is present for the method
                if (method.isAnnotationPresent(io.exnihilo.annotations.MethodInfo.class)) {
                    try {
                        // iterates all the annotations available in the method
                        for (Annotation annotation : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in '" + method + "' : " + annotation);
                        }
                        MethodInfo methodInfoAnnotation = method.getAnnotation(io.exnihilo.annotations.MethodInfo.class);
                        if (methodInfoAnnotation.revision() == 1) {
                            System.out.println("Method with revision no 1 = " + method);
                        }

                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
