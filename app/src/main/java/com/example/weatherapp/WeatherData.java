package com.example.weatherapp;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherData {

    private String mTemperature,mIcon,mCity,mWeatherType;
    private int mCondition;

    public static WeatherData fromJson(JSONObject jsonObject)
    {
          try{
              WeatherData weatherD = new WeatherData();
              weatherD.mCity=jsonObject.getString("name");
              weatherD.mCondition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
              weatherD.mWeatherType=jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
              weatherD.mIcon=updateWeatherIcon(weatherD.mCondition);
              double tempResults = jsonObject.getJSONObject("main").getDouble("temp")-273.15;
              int roundedValue=(int)Math.rint(tempResults);
              weatherD.mTemperature= Integer.toString(roundedValue);
              return weatherD;

          } catch (JSONException e) {
              e.printStackTrace();
              return null;
          }
    }

    private static String updateWeatherIcon(int condition){
        if (condition>=0 && condition<=300){
            return "thunderstorm";
        }
        else if (condition>=300 && condition<=500){
            return "rain";
        }
        else if (condition>=500 && condition<=600){
            return "storm";
        }
        else if (condition>=600 && condition<=700){
            return "snowflake";
        }
        else if (condition>=701 && condition<=771){
            return "mist";
        }
        else if (condition>=772 && condition<=800){
            return "overcast";
        }
        else if (condition==800){
            return "sun";
        }
        else if (condition>=801 && condition<=804){
            return "cloudy";
        }
       else if (condition>=900 && condition<=90) {
            return "thunderstorm";
        }
        else if (condition==903) {
            return "snowflake";
        }
        else if (condition==904) {
            return "sun";
        }
        else if (condition>=904 && condition<=1000) {
            return "storm";
        }
            return "johntez";
    }

    public String getmTemperature() {
        return mTemperature+"°C";
    }

    public String getmIcon() {
        return mIcon;
    }

    public String getmCity() {
        return mCity;
    }

    public String getmWeatherType() {
        return mWeatherType;
    }
}

