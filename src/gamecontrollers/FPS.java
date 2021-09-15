package gamecontrollers;

import java.time.Duration;
import java.time.Instant;

/**
 * FPS Class for calculating Delta Time (the time between frames)
 * @author Yağız Can Aslan
 * @version 15.09.2021
*/
public class FPS {

    // Properties
    private Instant initialTime = Instant.now();
    private Duration fpsDeltaTime = Duration.ZERO;
    private Duration lastTime = Duration.ZERO;
    private double deltaTime = fpsDeltaTime.toMillis() - lastTime.toMillis();


    // Constructors
    private FPS() {

    }

    // Methods
    /**
        Calculates the initial time
    */
    public void calculateInitialTime() {
        initialTime = Instant.now();
        fpsDeltaTime = Duration.ZERO;
    }

    /**
        Calculates the time difference between the last frame and the current frame
    */
    public void calculateDeltaTime() {
        fpsDeltaTime = Duration.between(initialTime, Instant.now());
        deltaTime = (double) fpsDeltaTime.toMillis() - lastTime.toMillis();
        lastTime = fpsDeltaTime;
    }

    /**
        @return Delta Time (the time difference between the last frame and the current frame) in seconds
    */
    public double getDeltaTimeSeconds() {
        return deltaTime / 1000;
    }

    /**
        @return Delta Time (the time difference between the last frame and the current frame) in milliseconds
    */
    public double getDeltaTimeMillis() {
        return deltaTime;
    }
}
