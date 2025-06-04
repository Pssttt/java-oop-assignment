package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TrackingEvent {
  private final String location;
  private final DeliveryStatus status;
  private final LocalDateTime timestamp;

  public TrackingEvent(String location, DeliveryStatus status) {
    this.location = location;
    this.status = status;
    this.timestamp = LocalDateTime.now();
  }

  public DeliveryStatus getStatus() {
    return status;
  }

  public String getLocation() {
    return location;
  }

  @Override
  public String toString() {
    return "[" + timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +
        "] " + status + " @ " + location;
  }
}
