package com.itmo.ctdev.parsing;

import com.itmo.ctdev.db.WorkoutRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.io.*;
import java.util.Objects;
import java.util.Optional;

/**
 * @author korektur
 *         06/01/2017
 */
@Service("sensorDataParser")
public class WorkoutDataParser {

    private static final Logger logger = LoggerFactory.getLogger(WorkoutDataParser.class);

    private final WorkoutDataParser workoutDataParser;
    private final WorkoutRepository workoutRepository;

    @Value("${data.workouts.file.name}")
    private String workoutsFileName;

    @Autowired
    public WorkoutDataParser(WorkoutDataParser workoutDataParser,
                             WorkoutRepository workoutRepository) {
        this.workoutDataParser = Objects.requireNonNull(workoutDataParser);
        this.workoutRepository = workoutRepository;
    }

    //"row ID","data.hashtags","data.descent","data.distance","data.duration","data.heart_rate_avg",
    // "data.heart_rate_max","data.hydration","data.local_start_time","data.message","data.pla
//    ylist","data.speed_avg","data.speed_max","data.sport","data.sportName","data.title",
// "data.weather.humidity","data.weather.temperature","data.weather.type","data.weather.wind_direction",
// "data.weather.wind_speed","data.points.points","user_id"
    @Async
    private void parse(@Nonnull String line, int lineNumber) {
        Objects.requireNonNull(line);
        //TODO: workout line parse
        Parser parser = new Parser(line);

        logger.info("parsed {} line: {}", lineNumber, null);
    }

    public void parseWorkoutFile() throws IOException {
        File file = new File(workoutsFileName);
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 1;
            while ((line = in.readLine()) != null) {
                workoutDataParser.parse(line, i);
                ++i;
            }
        }
    }
}
