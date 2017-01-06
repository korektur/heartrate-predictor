package com.itmo.ctdev.db.entity;

import com.google.common.base.MoreObjects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author korektur
 *         05/01/2017
 */
@SuppressWarnings("WeakerAccess")
@Document(collection = "workouts")
public class Workout {

    /**
     * id("198690217")
     */
    @Nonnull
    @Id
    public String id = "";

    /**
     * [race]
     */
    @Nullable
    public List<String> hashtags;

    /**
     * 31.0
     */
    @Nullable
    public Double descent;

    /**
     * 3.938788890838623
     */
    @Nullable
    public Double distance;

    /**
     * 946.0
     */
    @Nullable
    public Double duration;

    @Nullable
    public Double heartRateAvg;

    @Nullable
    public Double heartRateMax;

    @Nullable
    public Double hydration;

    @Nullable
    public Date localStartTime;

    @Nullable
    public String message;

    @Nullable
    public List<String> playlist;

    /**
     * 14.98904863321252
     */
    @Nullable
    public Double speedAvg;

    /**
     * 37.7197
     */
    @Nullable
    public Double speedMax;

    @Nullable
    public Integer sportId;

    @Nullable
    public String sportName;

    @Nullable
    public String title;

    @Nullable
    public Weather weather;

    @Nullable
    public List<Point> points;

    @Nullable
    public String userId;

    @SuppressWarnings("unused")
    public Workout() {
    }

    private Workout(@Nonnull String id,
                    @Nonnull List<String> hashtags,
                    @Nullable Double descent,
                    @Nullable Double distance,
                    @Nullable Double duration,
                    @Nullable Double heartRateAvg,
                    @Nullable Double heartRateMax,
                    @Nullable Double hydration,
                    @Nullable Date localStartTime,
                    @Nullable String message,
                    @Nonnull List<String> playlist,
                    @Nullable Double speedAvg,
                    @Nullable Double speedMax,
                    @Nullable Integer sportId,
                    @Nullable String sportName,
                    @Nullable String title,
                    @Nullable Weather weather,
                    @Nonnull List<Point> points,
                    @Nullable String userId) {
        this.id = Objects.requireNonNull(id);
        this.hashtags = Objects.requireNonNull(hashtags);
        this.descent = descent;
        this.distance = distance;
        this.duration = duration;
        this.heartRateAvg = heartRateAvg;
        this.heartRateMax = heartRateMax;
        this.hydration = hydration;
        this.localStartTime = localStartTime;
        this.message = message;
        this.playlist = Objects.requireNonNull(playlist);
        this.speedAvg = speedAvg;
        this.speedMax = speedMax;
        this.sportId = sportId;
        this.sportName = sportName;
        this.title = title;
        this.weather = weather;
        this.points = Objects.requireNonNull(points);
        this.userId = userId;
    }

    public static Builder builder() {
        return new Builder();
    }

    @SuppressWarnings({"unused", "NullableProblems"})
    private static class Builder {
        @Nonnull
        private String id;
        private List<String> hashtags;
        private Double descent;
        private Double distance;
        private Double duration;
        private Double heartRateAvg;
        private Double heartRateMax;
        private Double hydration;
        private Date localStartTime;
        private String message;
        private List<String> playlist;
        private Double speedAvg;
        private Double speedMax;
        private Integer sportId;
        private String sportName;
        private String title;
        private Weather weather;
        private List<Point> points;
        private String userId;

        public Builder setId(@Nonnull String id) {
            this.id = Objects.requireNonNull(id);
            return this;
        }

        public Builder setHashtags(List<String> hashtags) {
            this.hashtags = hashtags;
            return this;
        }

        public Builder setDescent(Double descent) {
            this.descent = descent;
            return this;
        }

        public Builder setDistance(Double distance) {
            this.distance = distance;
            return this;
        }

        public Builder setDuration(Double duration) {
            this.duration = duration;
            return this;
        }

        public Builder setHeartRateAvg(Double heartRateAvg) {
            this.heartRateAvg = heartRateAvg;
            return this;
        }

        public Builder setHeartRateMax(Double heartRateMax) {
            this.heartRateMax = heartRateMax;
            return this;
        }

        public Builder setHydration(Double hydration) {
            this.hydration = hydration;
            return this;
        }

        public Builder setLocalStartTime(Date localStartTime) {
            this.localStartTime = localStartTime;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setPlaylist(List<String> playlist) {
            this.playlist = playlist;
            return this;
        }

        public Builder setSpeedAvg(Double speedAvg) {
            this.speedAvg = speedAvg;
            return this;
        }

        public Builder setSpeedMax(Double speedMax) {
            this.speedMax = speedMax;
            return this;
        }

        public Builder setSportId(Integer sportId) {
            this.sportId = sportId;
            return this;
        }

        public Builder setSportName(String sportName) {
            this.sportName = sportName;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setWeather(Weather weather) {
            this.weather = weather;
            return this;
        }

        public Builder setPoints(List<Point> points) {
            this.points = points;
            return this;
        }

        public Builder setUserId( String userId) {
            this.userId = userId;
            return this;
        }
        
        public Workout build() {
            Objects.requireNonNull(id);
            return new Workout(id, hashtags != null ? hashtags : Collections.emptyList(), descent, distance, duration,
                    heartRateAvg, heartRateMax, hydration, localStartTime, message,
                    playlist != null ? playlist : Collections.emptyList(), speedAvg, speedMax, sportId, sportName,
                    title, weather, points != null ? points : Collections.emptyList(), userId);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Workout)) return false;
        Workout workout = (Workout) o;
        return Objects.equals(id, workout.id) &&
                Objects.equals(hashtags, workout.hashtags) &&
                Objects.equals(descent, workout.descent) &&
                Objects.equals(distance, workout.distance) &&
                Objects.equals(duration, workout.duration) &&
                Objects.equals(heartRateAvg, workout.heartRateAvg) &&
                Objects.equals(heartRateMax, workout.heartRateMax) &&
                Objects.equals(hydration, workout.hydration) &&
                Objects.equals(localStartTime, workout.localStartTime) &&
                Objects.equals(message, workout.message) &&
                Objects.equals(playlist, workout.playlist) &&
                Objects.equals(speedAvg, workout.speedAvg) &&
                Objects.equals(speedMax, workout.speedMax) &&
                Objects.equals(sportId, workout.sportId) &&
                Objects.equals(sportName, workout.sportName) &&
                Objects.equals(title, workout.title) &&
                Objects.equals(weather, workout.weather) &&
                Objects.equals(points, workout.points) &&
                Objects.equals(userId, workout.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hashtags, descent, distance, duration, heartRateAvg, heartRateMax, hydration,
                localStartTime, message, playlist, speedAvg, speedMax, sportId, sportName, title, weather,
                points, userId);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("hashtags", hashtags)
                .add("descent", descent)
                .add("distance", distance)
                .add("duration", duration)
                .add("heartRateAvg", heartRateAvg)
                .add("heartRateMax", heartRateMax)
                .add("hydration", hydration)
                .add("localStartTime", localStartTime)
                .add("message", message)
                .add("playlist", playlist)
                .add("speedAvg", speedAvg)
                .add("speedMax", speedMax)
                .add("sportId", sportId)
                .add("sportName", sportName)
                .add("title", title)
                .add("weather", weather)
                .add("points", points)
                .add("userId", userId)
                .toString();
    }
}
