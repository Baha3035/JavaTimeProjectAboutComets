package kg.megacom;

import java.time.Instant;
import java.time.LocalDateTime;

public class CometAazai {
    private LocalDateTime timeOfCreation;
    private Instant timeOfArrival;

    public CometAazai(LocalDateTime timeOfCreation, Instant timeOfArrival) {
        this.timeOfCreation = timeOfCreation;
        this.timeOfArrival = timeOfArrival;
    }

    public CometAazai() {
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
