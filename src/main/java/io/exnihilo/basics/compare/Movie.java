package io.exnihilo.basics.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// A class 'Movie' that implements Comparable
class Movie implements Comparable<Movie> {
    private double rating;
    private String name;
    private int year;

    // Used to sort movies by year 
    public int compareTo(Movie m) {
        return this.year - m.year;
    }

    // Constructor 
    public Movie(String nm, double rt, int yr) {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }

    // Getter methods for accessing private data 
    public double getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return (name + " " + rating + " " + year);
    }
}

// Class to compare Movies by ratings 
class RatingCompare implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        if (m1.getRating() > m2.getRating()) return 1;
        if (m1.getRating() < m2.getRating()) return -1;
        else return 0;
    }
}

// Class to compare Movies by name 
class NameCompare implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return m1.getName().compareTo(m2.getName());
    }
}

// Driver class 
class MovieComparisonTest {
    public static void main(String[] args) {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.4, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));

        System.out.println("Sorted by rating");
        RatingCompare ratingCompare = new RatingCompare();
        Collections.sort(list, ratingCompare);
        list.forEach(System.out::println);

        System.out.println("\nSorted by name");
        NameCompare nameCompare = new NameCompare();
        Collections.sort(list, nameCompare);
        list.forEach(System.out::println);

        System.out.println("\nSorted by year");
        Collections.sort(list);
        List<Movie> filteredMovieList = list.stream()
                .filter(movie -> movie.getRating() == 8.4)
                .collect(Collectors.toList());
        filteredMovieList.forEach(System.out::println);
    }
}