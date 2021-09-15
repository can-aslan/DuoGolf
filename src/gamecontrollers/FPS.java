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
    private static Instant initialTime = Instant.now();
    private static Duration fpsDeltaTime = Duration.ZERO;
    private static Duration lastTime = Duration.ZERO;
    private static double deltaTime = fpsDeltaTime.toMillis() - lastTime.toMillis();


    // Constructors
    private FPS() {

    }

    // Methods
    /**
        Calculates the initial time
    */
    public static void calculateInitialTime() {
        initialTime = Instant.now();
        fpsDeltaTime = Duration.ZERO;
    }

    /**
        Calculates the time difference between the last frame and the current frame
    */
    public static void calculateDeltaTime() {
        fpsDeltaTime = Duration.between(initialTime, Instant.now());
        deltaTime = (double) fpsDeltaTime.toMillis() - lastTime.toMillis();
        lastTime = fpsDeltaTime;
    }

    /**
        @return Delta Time (the time difference between the last frame and the current frame) in seconds
    */
    public static double getDeltaTimeSeconds() {
        return deltaTime / 1000;
    }

    /**
        @return Delta Time (the time difference between the last frame and the current frame) in milliseconds
    */
    public static double getDeltaTimeMillis() {
        return deltaTime;
    }

    /**
        @return Frames Per Second
    */
    public static double getFPS() {
        double fps = 1 / getDeltaTimeSeconds();

        return fps;
    }
}
