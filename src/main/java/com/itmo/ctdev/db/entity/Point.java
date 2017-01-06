package com.itmo.ctdev.db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

import javax.annotation.Nullable;
import java.util.Date;
import java.util.Objects;

/**
 * @author korektur
 *         05/01/2017
 */
@SuppressWarnings("WeakerAccess")
public class Point {

    /**
     * 2013-06-04T11:22:54.000Z
     */
    @Nullable
    public Date time;

    /**
     * 2
     */
    @Nullable
    public Integer instruction;

    @Nullable
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    public org.springframework.data.geo.Point location;

    @Nullable
    public Double altitude;

    @Nullable
    public Double distance;

    @Nullable
    public Double duration;

    @Nullable
    public SensorData sensorData;

    @SuppressWarnings("unused")
    public Point() {
    }

    private Point(@Nullable Date time,
                  @Nullable Integer instruction,
                  @Nullable org.springframework.data.geo.Point location,
                  @Nullable Double altitude,
                  @Nullable Double distance,
                  @Nullable Double duration,
                  @Nullable SensorData sensorData) {
        this.time = time;
        this.instruction = instruction;
        this.location = location;
        this.altitude = altitude;
        this.distance = distance;
        this.duration = duration;
        this.sensorData = sensorData;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return Objects.equals(time, point.time) &&
                Objects.equals(instruction, point.instruction) &&
                Objects.equals(location, point.location) &&
                Objects.equals(altitude, point.altitude) &&
                Objects.equals(distance, point.distance) &&
                Objects.equals(duration, point.duration) &&
                Objects.equals(sensorData, point.sensorData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, instruction, location, altitude, distance, duration, sensorData);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("time", time)
                .add("instruction", instruction)
                .add("location", location)
                .add("altitude", altitude)
                .add("distance", distance)
                .add("duration", duration)
                .add("sensorData", sensorData)
                .toString();
    }

    private static class Builder {
        @Nullable
        private Date time;
        @Nullable
        private Integer instruction;
        @Nullable
        private org.springframework.data.geo.Point location;
        @Nullable
        private Double altitude;
        @Nullable
        private Double distance;
        @Nullable
        private Double duration;
        @Nullable
        private SensorData sensorData;

        public void setTime(@Nullable Date time) {
            this.time = time;
        }

        public void setInstruction(@Nullable Integer instruction) {
            this.instruction = instruction;
        }

        public void setLocation(@Nullable org.springframework.data.geo.Point location) {
            this.location = location;
        }

        public void setAltitude(@Nullable Double altitude) {
            this.altitude = altitude;
        }

        public void setDistance(@Nullable Double distance) {
            this.distance = distance;
        }

        public void setDuration(@Nullable Double duration) {
            this.duration = duration;
        }

        public void setSensorData(@Nullable SensorData sensorData) {
            this.sensorData = sensorData;
        }

        public Point build() {
            return new Point(time, instruction, location, altitude, distance, duration, sensorData);
        }
    }
}
