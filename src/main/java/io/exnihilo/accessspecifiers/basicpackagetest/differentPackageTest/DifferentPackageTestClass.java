package io.exnihilo.accessspecifiers.basicpackagetest.differentPackageTest;

import io.exnihilo.accessspecifiers.basicpackagetest.PublicClass;

/**
 * Created by anand on 8/4/2018.
 */
public class DifferentPackageTestClass {
    public static void main(String... args) {

        /******** Access Levels  ****************
         Modifier	Class	Pkg	SubCls	World
         public	        Y	Y	    Y	Y
         protected	    Y	Y	    Y	N
         no modifier    Y	Y	    N	N
         private	    Y	N	    N	N
         ****************************************/

        PublicClass publicClass = new PublicClass();
        //publicClass.getDefaultName();
        publicClass.getPublicName();
        //publicClass.getProtectedName();
        //publicClass.getPrivateName();

        //DefaultClass defaultClass = new DefaultClass();
        //defaultClass.getDefaultName();
        //defaultClass.getPublicName();
        //defaultClass.getProtectedName();
        //defaultClass.getPrivateName();

    }
}
