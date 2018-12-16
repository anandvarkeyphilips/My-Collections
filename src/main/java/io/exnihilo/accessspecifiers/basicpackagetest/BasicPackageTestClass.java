package io.exnihilo.accessspecifiers.basicpackagetest;

/**
 * Created by anand on 8/4/2018.
 */
public class BasicPackageTestClass {
    public static void main(String... args) {

        /******** Access Levels  ****************
         Modifier	Class	Pkg	SubCls	World
         public	        Y	Y	    Y	Y
         protected	    Y	Y	    Y	N
         no modifier    Y	Y	    Y	N
         private	    Y	N	    N	N
         ****************************************/

        PublicClass publicClass = new PublicClass();
        publicClass.getDefaultName();
        publicClass.getPublicName();
        publicClass.getProtectedName();
        //publicClass.getPrivateName();

        DefaultClass defaultClass = new DefaultClass();
        defaultClass.getDefaultName();
        defaultClass.getPublicName();
        defaultClass.getProtectedName();
        //defaultClass.getPrivateName();

    }
}
