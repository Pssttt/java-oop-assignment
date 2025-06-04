package service;

import models.Parcel;
import models.TrackingEvent;

import java.util.HashMap;
import java.util.Map;

public class ParcelTracker {
  private final Map<String, Parcel> packageMap = new HashMap<>();

  public void registerParcel(Parcel pkg) {
    packageMap.put(pkg.getTrackingId(), pkg);
    System.out.println("Package registered with tracking ID: " + pkg.getTrackingId());
  }

  public void updateTracking(String trackingId, TrackingEvent event) {
    Parcel pkg = packageMap.get(trackingId);
    if (pkg != null) {
      pkg.addTrackingEvent(event);
      System.out.println("Tracking updated successfully.");
    } else {
      System.out.println("Package with ID " + trackingId + " not found.");
    }
  }

  public void displayTracking(String trackingId) {
    Parcel pkg = packageMap.get(trackingId);
    if (pkg != null) {
      System.out.println(pkg);
      pkg.printTrackingHistory();
    } else {
      System.out.println("Package not found.");
    }
  }
}
