package com.techelevator.weatherapi;

// example of printing out a 5 day forecast for weather
// would love to build upon this, especially learning on how apps like weather.com
// forecasts the weather and makes changes in real time as the weather changes

public class Tutorial {

    public static void main(String[] args) {

        int i;

        for (i = 0; i <= 5; i++) {
            System.out.println(i);
        }

        for (i =10; i >= 0; i--) {
            System.out.println(i);
        }

        int[] forecastTemperatures = new int[5];
        forecastTemperatures[0] = 72;
        forecastTemperatures[0] = 78;
        forecastTemperatures[0] = 58;
        forecastTemperatures[0] = 79;
        forecastTemperatures[0] = 74;

        forecastTemperatures[2] += 10;

        for (i = 0; i < forecastTemperatures.length; i++) {
            System.out.println(forecastTemperatures[i]);
        }

        int highestTemperatureValue = forecastTemperatures[0];
        int highestTemperatureIndex = 0;

        for(int j = 1; j < forecastTemperatures.length; j++);

        for (int j = 1; j < forecastTemperatures.length; j++) {
            if (forecastTemperatures[j] > highestTemperatureValue) {
                highestTemperatureValue = forecastTemperatures[j];
                highestTemperatureIndex = j;
            }
        }

        System.out.println("The highest temperature is " + highestTemperatureValue);

        System.out.println("The highest temperature is in " + (highestTemperatureIndex + 1) + " days");

    }

// Example of running a web based API linking to the geocoding.geo.census page
// Would love to see this in action!
   import axios from 'axios';

const http = axios.create({
        baseURL: "https://geocoding.geo.census.gov/geocoder/returntype/searchtype?parameters"
    });

    export default {

        list() {
            return http.get('/locations');
        },

        get(id) {
            return http.get(`/coordinates/${id}`);
        }

    }
}