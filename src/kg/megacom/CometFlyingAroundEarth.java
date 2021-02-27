package kg.megacom;

import java.time.Instant;
import java.time.LocalDateTime;

public class CometFlyingAroundEarth {
    private LocalDateTime timeOfCreation;
    private Instant timeOfArrival;


    public CometFlyingAroundEarth(LocalDateTime timeOfCreation, Instant timeOfArrival) {
        this.timeOfCreation = timeOfCreation;
        this.timeOfArrival = timeOfArrival;
    }

    public CometFlyingAroundEarth() {
    }

    public LocalDateTime getTimeOfCreation() {
        return timeOfCreation;
    }

    public void setTimeOfCreation(LocalDateTime timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
    }

    public Instant getTimeOfArrival() {
        return timeOfArrival;
    }

    public void setTimeOfArrival(Instant timeOfArrival) {
        this.timeOfArrival = timeOfArrival;
    }
}
