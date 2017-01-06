package com.itmo.ctdev.db.entity;

import javax.annotation.Nullable;
import java.util.Objects;

import static com.google.common.base.MoreObjects.*;

/**
 * data.weather.humidity","data.weather.temperature","data.weather.type","data.weather.wind_directi
 * on","data.weather.wind_speed"
 *
 * @author korektur
 *         05/01/2017
 */
@SuppressWarnings("WeakerAccess")
public class Weather {

    /**
     * 57
     */
    @Nullable
    public Double humidity;

    /**
     * 13
     */
    @Nullable
    public Double temperature;

    /**
     * 1
     */
    @Nullable
    public Double type;

    /**
     * 14
     */
    @Nullable
    public Double windDirection;

    /**
     * 14
     */
    @Nullable
    public Double windSpeed;

    @SuppressWarnings("unused")
    public Weather() {
    }

    private Weather(@Nullable Double humidity,
                   @Nullable Double temperature,
                   @Nullable Double type,
                   @Nullable Double windDirection,
                   @Nullable Double windSpeed) {
        this.humidity = humidity;
        this.temperature = temperature;
        this.type = type;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
    }

    public static Builder builder() {
        return new Builder();
    }

    private static class Builder{
        @Nullable
        private Double humidity;
        @Nullable
        private Double temperature;
        @Nullable
        private Double type;
        @Nullable
        private Double windDirection;
        @Nullable
        private Double windSpeed;

        public Builder setHumidity(@Nullable Double humidity) {
            this.humidity = humidity;
            return this;
        }

        public Builder setTemperature(@Nullable Double temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder setType(@Nullable Double type) {
            this.type = type;
            return this;
        }

        public Builder setWindDirection(@Nullable Double windDirection) {
            this.windDirection = windDirection;
            return this;
        }

        public Builder setWindSpeed(@Nullable Double windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }

        public Weather build() {
            return new Weather(humidity, temperature, type, windDirection, windSpeed);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weather)) return false;
        Weather weather = (Weather) o;
        return Objects.equals(humidity, weather.humidity) &&
                Objects.equals(temperature, weather.temperature) &&
                Objects.equals(type, weather.type) &&
                Objects.equals(windDirection, weather.windDirection) &&
                Objects.equals(windSpeed, weather.windSpeed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(humidity, temperature, type, windDirection, windSpeed);
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("humidity", humidity)
                .add("temperature", temperature)
                .add("type", type)
                .add("windDirection", windDirection)
                .add("windSpeed", windSpeed)
                .toString();
    }
}
