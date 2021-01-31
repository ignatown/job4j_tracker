package ru.job4j.stream;

public class City {
    private String cityName;
    private String mayorName;
    private String nationLiving;
    private String district;
    private int yearOfFoundation;

    static class Builder {
        private String cityName;
        private String mayorName;
        private String nationLiving;
        private String district;
        private int yearOfFoundation;

        Builder buildCityName(String cityName) {
            this.cityName = cityName;
            return this;
        }
        Builder buildMayorName(String mayorName) {
            this.mayorName = mayorName;
            return this;
        }
        Builder buildNationLiving(String nationLiving) {
            this.nationLiving = nationLiving;
            return this;
        }
        Builder buildDistrict(String district) {
            this.district = district;
            return this;
        }
        Builder buildYearOfFoundation(int yearOfFoundation) {
            this.yearOfFoundation = yearOfFoundation;
            return this;
        }
        public  City build() {
            City city = new City();
            city.cityName = cityName;
            city.mayorName = mayorName;
            city.nationLiving = nationLiving;
            city.district = district;
            city.yearOfFoundation = yearOfFoundation;
            return city;
        }

    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", mayorName='" + mayorName + '\'' +
                ", nationLiving='" + nationLiving + '\'' +
                ", district='" + district + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                '}';
    }

    public static void main(String[] args) {
        City city = new Builder().buildCityName("name")
                .buildMayorName("mayor name")
                .buildNationLiving("nation living")
                .buildDistrict("district")
                .buildYearOfFoundation(1234)
                .build();
        System.out.println(city);
    }
}
