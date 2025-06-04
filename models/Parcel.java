package models;

import java.util.ArrayList;
import java.util.List;

public class Parcel {
  private final String trackingId;
  private final User sender;
  private final User recipient;
  private final String origin;
  private final String destination;
  private final DeliveryType type;
  private final List<TrackingEvent> history;

  public Parcel(String trackingId, User sender, User recipient, String origin, String destination, DeliveryType type) {
    this.trackingId = trackingId;
    this.sender = sender;
    this.recipient = recipient;
    this.origin = origin;
    this.destination = destination;
    this.type = type;
    this.history = new ArrayList<>();
    this.addTrackingEvent(new TrackingEvent(origin, DeliveryStatus.REGISTERED));
  }

  public void addTrackingEvent(TrackingEvent event) {
    history.add(event);
  }

  public String getCurrentLocation() {
    if (history.isEmpty())
      return "Unknown";
    return history.get(history.size() - 1).getLocation();
  }

  public DeliveryStatus getCurrentStatus() {
    if (history.isEmpty())
      return null;
    return history.get(history.size() - 1).getStatus();
  }

  public String getTrackingId() {
    return trackingId;
  }

  public void printTrackingHistory() {
    System.out.println("Tracking History for Parcel: " + trackingId);
    for (TrackingEvent event : history) {
      System.out.println(event);
    }
  }

  @Override
  public String toString() {
    return "Parcel [trackingId = " + trackingId + ", sender = " + sender + ", recipient = " + recipient + ", origin = "
        + origin + ", destination = " + destination + ", type = " + type + ", current location = "
        + getCurrentLocation()
        + ", current status = " + getCurrentStatus() + "]";
  }
}
