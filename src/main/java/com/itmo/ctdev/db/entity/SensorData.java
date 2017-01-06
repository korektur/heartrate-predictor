package com.itmo.ctdev.db.entity;

import com.google.common.base.MoreObjects;

import javax.annotation.Nullable;
import java.util.Objects;

/**
 * @author korektur
 *         05/01/2017
 */
@SuppressWarnings("WeakerAccess")
public class SensorData {

    @Nullable
    public Double speed;

    public SensorData() {
    }

    public SensorData(@Nullable Double speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SensorData)) return false;
        SensorData that = (SensorData) o;
        return Objects.equals(speed, that.speed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("speed", speed)
                .toString();
    }
}
