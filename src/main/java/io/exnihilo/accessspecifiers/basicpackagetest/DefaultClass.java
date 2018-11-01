package io.exnihilo.accessspecifiers.basicpackagetest;

/**
 * Created by anand on 8/4/2018.
 */
class DefaultClass {

    String defaultName = "defaultName";
    public String publicName = "publicName";
    protected String protectedName = "protectedName";
    private String privateName = "privateName";

    void getDefaultName() {
        System.out.println(defaultName);
    }

    public void getPublicName() {
        System.out.println(publicName);
    }

    protected void getProtectedName() {
        System.out.println(protectedName);
    }
}
