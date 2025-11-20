package outputs;


import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Compare {
    public static void main(String[] args) {
        NavigableSet<Movie> movieList= new TreeSet<>();
        movieList.add(new Movie("Bahubali",8.15,2015));
        movieList.add(new Movie("Janwar ",8.4,1977));
        movieList.add(new Movie("Mr India",8.7,1980));
        movieList.add(new Movie("Amar Akbar Anthony",8.8,1983));

        System.out.println("Movie after Sorting");
        for(Movie m:movieList){
            System.out.println(m.getName() +" " + m.getRating() +" "+ m.getYear());
        }

        System.out.println(movieList.stream().sorted(Comparator.comparing(Movie::getRating)).toList());
    }
}

class Movie implements Comparable<Movie> {
    private double rating;
    private String name;
    private int year;

    public Movie(String name,  double rating,int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    @Override
    public int compareTo(Movie m) {
        return this.year - m.year;
    }

    public double getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "rating=" + rating +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}