package io.exnihilo.shallowanddeepcopy;

import lombok.Data;

public class CloningExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        City city = new City("Dehradun");
        Country country = new Country("India");
        city.setName("Pune");
        country.setName("IN");
        Person person1 = new Person(1, "Naresh", 10000, city, country);
        System.out.println(person1);
        Person person2 = person1.clone();
        System.out.println(person2);
        if (person1 == person2) {
            System.out.println("Both person1 and person2 holds same object");
        }
        if (person1.equals(person2)) {
            System.out.println("But both person1 and person2 are equal and have same content");
        }
        if (person1.getCity() == person2.getCity()) {
            System.out.println("Both person1 and person2 have same city object");
        }
        if (person1.getCountry() == person2.getCountry()) {
            System.out.println("Both person1 and person2 have same country object");
        }
        System.out.println(person1);
        System.out.println(person2);
        Person person3 = new Person(person1);

        if (person1 == person3) {
            System.out.println("Both person1 and person3 holds same object");
        }
        if (person1.equals(person3)) {
            System.out.println("But both person1 and person3 are equal and have same content");
        }
        if (person1.getCity() == person3.getCity()) {
            System.out.println("Both person1 and person3 have same city object");
        }
        if (person1.getCountry() == person3.getCountry()) {
            System.out.println("Both person1 and person3 have same country object");
        }
    }
}

@Data
class Person implements Cloneable {

    private final int id;
    private String name;
    private int income;
    private City city;
    private Country country;

    public Person(int id, String name, int income, City city, Country country) {
        super();
        this.id = id;
        this.name = name;
        this.income = income;
        this.city = city;
        this.country = country;
    }

    public Person clone() throws CloneNotSupportedException {
        Person clonedObj = (Person) super.clone();
        clonedObj.city = this.city.clone();
        return clonedObj;
    }

    public Person(Person original) {
        this.id = original.id + 1;
        this.name = new String(original.name);
        this.income = original.income;
        this.city = new City(original.city);
        this.country = new Country(original.country);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + income;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Person other = (Person) obj;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (income != other.income)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}

@Data
class City implements Cloneable {
    private String name;

    public City(String name) {
        super();
        this.name = name;
    }

    public City(City city) {
        this.name = new String(city.name);
    }

    public City clone() throws CloneNotSupportedException {
        return (City) super.clone();
    }
}

@Data
class Country {
    private String name;

    public Country(String name) {
        super();
        this.name = name;
    }

    public Country(Country country) {
        this.name = new String(country.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Country other = (Country) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    /**
     * Advantages of Object.clone()
     * Object.clone() have many design issues but it is still the popular and easiest way  of copying objects, Some advantages of using clone() are
     * 	Cloning requires very less line of code, just an abstract class with 4 or 5 line long clone() method but we will need to override it if we need deep cloning.
     * 	It is the easiest way of copying object specially if we are applying it to an already developed or an old project. We just need to define a parent class, implement Cloneable in it, provide the definition of clone() method and we are ready every child of our parent will get the cloning feature.
     * 	We should use clone to copy arrays because that’s generally the fastest way to do it.
     * 	As of release 1.5, calling clone on an array returns an array whose compile-time
     * type is the same as that of the array being cloned which clearly means calling clone on arrays do not require type casting.
     *
     * Disadvantages of Object.clone()
     * Below are some cons due to which many developers don't use Object.clone()
     * 	Using Object.clone() method requires us to add lots of syntax to our code like implement Cloneable interface, define clone() method and handle CloneNotSupportedException and finally call to Object.clone() and cast it our object.
     * 	Cloneable interface lacks clone() method, actually, Cloneable is a marker interface and doesn’t have any method in it and still, we need to implement it just to tell JVM that we can perform clone() on our object.
     * 	Object.clone() is protected so we have to provide our own clone() and indirectly call Object.clone() from it.
     * 	We don’t have any control over object construction because Object.clone() doesn’t invoke any constructor.
     * 	If we are writing clone method in a child class e.g. Person then all of its superclasses should define clone() method in them or inherit it from another parent class otherwise super.clone() chain will fail.
     * 	Object.clone() support only shallow copy so reference fields of our newly cloned object will still hold objects which fields of our original object was holding. In order to overcome this, we need to implement clone() in every class whose reference our class is holding and then call their clone them separately in our clone() method like in below example.
     * 	We can not manipulate final fields in Object.clone() because final fields can only be changed through constructors. In our case, if we want every Person objects to be unique by id we will get the duplicate object if we use Object.clone() because Object.clone() will not call the constructor and final final id field can’t be modified from Person.clone().
     */

    /**
     * Advantages of copy constructors over Object.clone()
     * Copy constructors are better than Object.clone() because they
     * Don’t force us to implement any interface or throw any exception but we can surely do it if it is required.
     * Don’t require any casts.
     * Don’t require us to depend on an unknown object creation mechanism.
     * Don’t require parent class to follow any contract or implement anything.
     * Allow us to modify final fields.
     * Allow us to have complete control over object creation, we can write our initialization logic in it.
     */
}
