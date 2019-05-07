package io.exnihilo.accessspecifiers.innerouter;

/**
 * Created by anand on 8/4/2018.
 */
public class OuterClass {
    static String outerStaticString = "outerStaticString";
    String outerDefaultName = "outerDefaultName";
    public String outerPublicName = "outerPublicName";
    protected String outerProtectedName = "outerProtectedName";
    private String outerPrivateName = "outerPrivateName";

    void getOuterDefaultName() {
        System.out.println(outerDefaultName);
    }

    public void getOuterPublicName() {
        System.out.println(outerPublicName);
    }

    protected void getOuterProtectedName() {
        System.out.println(outerProtectedName);
    }

    private void getOuterPrivateName() {
        System.out.println(outerPrivateName);
    }

    private class InnerPrivateClass {
        String innerDefaultName = "InnerPrivateClass: innerDefaultName";
        public String innerPublicName = "InnerPrivateClass: innerPublicName";
        protected String innerProtectedName = "InnerPrivateClass: innerProtectedName";
        private String innerPrivateName = "InnerPrivateClass: innerPrivateName";

        void getInnerDefaultName() {
            System.out.println(innerDefaultName);
        }

        public void getInnerPublicName() {
            System.out.println(innerPublicName);
        }

        protected void getInnerProtectedName() {
            System.out.println(innerProtectedName);
        }

        private void getInnerPrivateName() {
            System.out.println(innerPrivateName);
        }
    }

    protected static class InnerStaticProtectedClass {
        static String innerStaticString = "InnerStaticProtectedClass: innerStaticString";
        String innerDefaultName = "InnerStaticProtectedClass: innerDefaultName";
        public String innerPublicName = "InnerStaticProtectedClass: innerPublicName";
        protected String innerProtectedName = "InnerStaticProtectedClass: innerProtectedName";
        private String innerPrivateName = "InnerStaticProtectedClass: innerPrivateName";

        void getInnerDefaultName() {
            System.out.println(innerDefaultName);
        }

        public void getInnerPublicName() {
            System.out.println(innerPublicName);
        }

        protected void getInnerProtectedName() {
            System.out.println(innerProtectedName);
        }

        public void testOuterClassMethodsFromInnerStaticProtectedClass() {
            System.out.println("Inside : testOuterClassMethodsFromInnerStaticProtectedClass");
            System.out.println(outerStaticString);
            innerProtectedName = "changed innerProtectedName";
        }
    }

    protected class InnerProtectedClass {
        //static String innerStaticString = "InnerProtectedClass: innerStaticString";
        String innerDefaultName = "InnerProtectedClass: innerDefaultName";
        public String innerPublicName = "InnerProtectedClass: innerPublicName";
        protected String innerProtectedName = "InnerProtectedClass: innerProtectedName";
        private String innerPrivateName = "InnerProtectedClass: innerPrivateName";

        void getInnerDefaultName() {
            System.out.println(innerDefaultName);
        }

        public void getInnerPublicName() {
            System.out.println(innerPublicName);
        }

        protected void getInnerProtectedName() {
            System.out.println(innerProtectedName);
        }

        private void getInnerPrivateName() {
            System.out.println(innerPrivateName);
        }

        public void testOuterClassMethodsFromInnerProtectedClass() {
            System.out.println("Inside : testOuterClassMethodsFromInnerProtectedClass");
            getOuterDefaultName();
            getOuterPublicName();
            getOuterProtectedName();
            getOuterPrivateName();
        }
    }

    public void testInnerPrivateAndStaticProtectedClassMethods() {
        System.out.println("Inside : testInnerPrivateAndStaticProtectedClassMethods");
        InnerPrivateClass innerPrivateClass = new InnerPrivateClass();
        innerPrivateClass.getInnerDefaultName();
        innerPrivateClass.getInnerPublicName();
        innerPrivateClass.getInnerProtectedName();
        innerPrivateClass.getInnerPrivateName();
        InnerStaticProtectedClass innerStaticProtectedClass = new InnerStaticProtectedClass();
        innerStaticProtectedClass.getInnerDefaultName();
    }
}