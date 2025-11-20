package Test;

import java.util.*;
import java.util.stream.Collectors;

public class OracleInterview {


    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        String maxKey = Collections.max(map.entrySet(), Map.Entry.comparingByKey()).getKey();
        System.out.println("Key with highest value: " + maxKey);


        City city1 = new City("delhi");
        City city2 = new City("bangalore");
        City city3 = new City("delhi");
        System.out.println(city1.hashCode() + " " + city2.hashCode());
        List<City> list = Arrays.asList(city1, city2, city3);
        System.out.println(list);
        System.out.println(removeDuplicates(list));


    }

    public static List<City> removeDuplicates(List<City> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

}


class City {

    private String cityName;

    public City(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(cityName, city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cityName);
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                '}';
    }


}