package io.exnihilo.accessspecifiers.innerouter;

/**
 * Created by anand on 8/4/2018.
 */
public class OuterClass {
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

    public void testInnerPrivateClassMethods() {
        System.out.println("Inside : testInnerPrivateClassMethods");
        InnerPrivateClass innerPrivateClass = new InnerPrivateClass();
        innerPrivateClass.getInnerDefaultName();
        innerPrivateClass.getInnerPublicName();
        innerPrivateClass.getInnerProtectedName();
        innerPrivateClass.getInnerPrivateName();
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

        public void testOuterClassMethods() {
            getInnerDefaultName();
            getInnerPublicName();
            getInnerProtectedName();
            getInnerPrivateName();
        }
    }

    protected class InnerProtectedClass {

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

        public void testOuterClassMethods() {
            System.out.println("Inside : testOuterClassMethods");
            getOuterDefaultName();
            getOuterPublicName();
            getOuterProtectedName();
            getOuterPrivateName();
        }
    }
}
