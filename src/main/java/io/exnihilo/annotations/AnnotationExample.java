package io.exnihilo.annotations;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AnnotationExample {

	@Override
	@MethodInfo(author = "Varkey", comments = "Main method", date = "Oct 8 2018", revision = 1)
	public String toString() {
		return "Overridden toString method";
	}

	@Deprecated
	@MethodInfo(comments = "deprecated method", date = "Oct 6 2018")
	public static void oldMethod() {
		System.out.println("old method, don't use it.");
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@MethodInfo(author = "Philips", comments = "Main method", date = "Oct 5 2018", revision = 10)
	public static void genericsTest() throws FileNotFoundException {
		List l = new ArrayList();
		l.add("abc");
		oldMethod();
	}
}
