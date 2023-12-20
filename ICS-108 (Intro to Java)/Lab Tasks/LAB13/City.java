package LAB13;


public class City implements Comparable<City>, Cloneable {
    private String cityName;
    private int temperature;

    City(String cityName, int temperature) {
        this.cityName = cityName;
        this.temperature = temperature;
    }

    @Override
    public int compareTo(City o) {

        if (this.temperature < o.temperature) {
            return 1;
        } else if (this.temperature > o.temperature) {
            return -1;
        }

        return 0;
    }
    
    public boolean equals(Object o) {

        return (o instanceof City) && this.temperature == ((City) o).temperature;
    }




    @Override
    public String toString() {
        return "cityName= " + cityName + ", temperature= " + temperature;
    }
}

