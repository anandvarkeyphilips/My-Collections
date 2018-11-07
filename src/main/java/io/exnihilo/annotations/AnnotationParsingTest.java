package io.exnihilo.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationParsingTest {

    public static void main(String[] args) {
        try {
            for (Method AnnotationExampleClassMethod : AnnotationParsingTest.class.getClassLoader().loadClass(("io.exnihilo.annotations.AnnotationExample")).getMethods()) {
                // checks if MethodInfo annotation is present for the method
                if (AnnotationExampleClassMethod.isAnnotationPresent(io.exnihilo.annotations.MethodInfo.class)) {
                    try {
                        // iterates all the annotations available in the method
                        for (Annotation annotation : AnnotationExampleClassMethod.getDeclaredAnnotations()) {
                            System.out.println("Annotation in '" + AnnotationExampleClassMethod + "' : " + annotation);
                        }
                        MethodInfo methodInfoAnnotation = AnnotationExampleClassMethod.getAnnotation(io.exnihilo.annotations.MethodInfo.class);
                        if (methodInfoAnnotation.revision() == 1) {
                            System.out.println("Method with revision no 1 = " + AnnotationExampleClassMethod);
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
