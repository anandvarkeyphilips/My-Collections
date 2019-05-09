package io.exnihilo.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationParsingTest {

    public static void main(String[] args) {
        try {
            for (Method aAnnotationExampleClassMethod : AnnotationParsingTest.class.getClassLoader().loadClass(("io.exnihilo.annotations.AnnotationExample")).getMethods()) {
                // checks if MethodInfo annotation is present for the method
                if (aAnnotationExampleClassMethod.isAnnotationPresent(io.exnihilo.annotations.MethodInfo.class)) {
                    try {
                        // iterates all the annotations available in the method
                        for (Annotation annotation : aAnnotationExampleClassMethod.getDeclaredAnnotations()) {
                            System.out.println("Annotation in '" + aAnnotationExampleClassMethod + "' : " + annotation);
                        }
                        MethodInfo methodInfoAnnotation = aAnnotationExampleClassMethod.getAnnotation(io.exnihilo.annotations.MethodInfo.class);
                        if (methodInfoAnnotation.revision() == 1) {
                            System.out.println("Method with revision no 1 = " + aAnnotationExampleClassMethod);
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
