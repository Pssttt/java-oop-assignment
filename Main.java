import models.*;
import service.ParcelTracker;

import java.util.Scanner;
import java.util.UUID;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ParcelTracker tracker = new ParcelTracker();
    boolean running = true;

    while (running) {
      System.out.println("\n===== PARCEL TRACKING SYSTEM =====");
      System.out.println("1. Register new parcel");
      System.out.println("2. Add tracking update");
      System.out.println("3. View parcel tracking");
      System.out.println("4. Exit");
      System.out.print("Choose an option: ");
      String input = scanner.nextLine();

      switch (input) {
        case "1":
          System.out.print("Sender name: ");
          String sName = scanner.nextLine();
          System.out.print("Sender email: ");
          String sEmail = scanner.nextLine();
          User sender = new User(sName, sEmail);

          System.out.print("Recipient name: ");
          String rName = scanner.nextLine();
          System.out.print("Recipient email: ");
          String rEmail = scanner.nextLine();
          User recipient = new User(rName, rEmail);

          System.out.print("Origin: ");
          String origin = scanner.nextLine();
          System.out.print("Destination: ");
          String destination = scanner.nextLine();

          System.out.print("Delivery type (STANDARD/EXPRESS): ");
          DeliveryType type = DeliveryType.valueOf(scanner.nextLine().toUpperCase());

          String trackingId = UUID.randomUUID().toString().substring(0, 8);
          Parcel newPkg = new Parcel(trackingId, sender, recipient, origin, destination, type);
          tracker.registerParcel(newPkg);
          break;

        case "2":
          System.out.print("Enter tracking ID: ");
          String id = scanner.nextLine();
          System.out.print("Current location: ");
          String loc = scanner.nextLine();
          System.out.print("Status (REGISTERED, DISPATCHED, IN_TRANSIT, DELIVERED, DELAYED): ");
          DeliveryStatus status = DeliveryStatus.valueOf(scanner.nextLine().toUpperCase());
          tracker.updateTracking(id, new TrackingEvent(loc, status));
          break;

        case "3":
          System.out.print("Enter tracking ID: ");
          String trackId = scanner.nextLine();
          tracker.displayTracking(trackId);
          break;

        case "4":
          running = false;
          System.out.println("Exiting");
          break;

        default:
          System.out.println("Invalid option.");
      }
    }

    scanner.close();
  }
}
