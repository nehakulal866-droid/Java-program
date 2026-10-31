
import java.util.ArrayList;
import java.util.Scanner;

// Room class
class Room {

    private int roomNumber;
    private String category;
    private double price;
    private boolean available;

    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.available = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void displayRoom() {
        System.out.printf("%-12d %-15s Rs.%-12.2f %-10s%n",
                roomNumber, category, price,
                available ? "Available" : "Booked");
    }
}

// Reservation class
class Reservation {

    private int bookingId;
    private String customerName;
    private String phoneNumber;
    private Room room;
    private int nights;
    private double totalAmount;

    public Reservation(int bookingId, String customerName,
                       String phoneNumber, Room room, int nights) {

        this.bookingId = bookingId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.room = room;
        this.nights = nights;
        this.totalAmount = room.getPrice() * nights;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Room getRoom() {
        return room;
    }

    public void displayDetails() {

        System.out.println("\n========== BOOKING DETAILS ==========");
        System.out.println("Booking ID    : " + bookingId);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Phone Number  : " + phoneNumber);
        System.out.println("Room Number   : " + room.getRoomNumber());
        System.out.println("Room Category : " + room.getCategory());
        System.out.println("Number of Nights : " + nights);
        System.out.println("Total Amount  : Rs." + totalAmount);
        System.out.println("Payment Status: Paid");
        System.out.println("=====================================");
    }
}

// Main Hotel Reservation System
public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Reservation> reservations = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    static int bookingCounter = 1001;

    // Add hotel rooms
    public static void addRooms() {

        rooms.add(new Room(101, "Standard", 1500));
        rooms.add(new Room(102, "Standard", 1500));
        rooms.add(new Room(201, "Deluxe", 2500));
        rooms.add(new Room(202, "Deluxe", 2500));
        rooms.add(new Room(301, "Suite", 4000));
        rooms.add(new Room(302, "Suite", 4000));
    }

    // Display all rooms
    public static void displayRooms() {

        System.out.println("\n============== ROOM DETAILS ==============");
        System.out.printf("%-12s %-15s %-15s %-10s%n",
                "Room Number", "Category", "Price/Night", "Status");

        for (Room room : rooms) {
            room.displayRoom();
        }

        System.out.println("==========================================");
    }

    // Book a room
    public static void bookRoom() {

        displayRooms();

        System.out.print("\nEnter room number to book: ");
        int roomNumber = sc.nextInt();
        sc.nextLine();

        Room selectedRoom = null;

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNumber) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom == null) {
            System.out.println("Invalid room number.");
            return;
        }

        if (!selectedRoom.isAvailable()) {
            System.out.println("Sorry! This room is already booked.");
            return;
        }

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        System.out.print("Enter number of nights: ");
        int nights = sc.nextInt();

        if (nights <= 0) {
            System.out.println("Please enter a valid number of nights.");
            return;
        }

        double amount = selectedRoom.getPrice() * nights;

        System.out.println("\nTotal Amount: Rs." + amount);

        System.out.print("Confirm payment? (yes/no): ");
        String payment = sc.next();

        if (payment.equalsIgnoreCase("yes")) {

            selectedRoom.setAvailable(false);

            Reservation reservation = new Reservation(
                    bookingCounter, name, phone,
                    selectedRoom, nights);

            reservations.add(reservation);

            System.out.println("\nPayment successful!");
            System.out.println("Room booked successfully.");
            System.out.println("Your Booking ID is: " + bookingCounter);

            reservation.displayDetails();

            bookingCounter++;

        } else {

            System.out.println("Payment cancelled. Booking not completed.");
        }
    }

    // View booking details
    public static void viewBooking() {

        System.out.print("\nEnter Booking ID: ");
        int id = sc.nextInt();

        for (Reservation reservation : reservations) {

            if (reservation.getBookingId() == id) {
                reservation.displayDetails();
                return;
            }
        }

        System.out.println("Booking not found.");
    }

    // Cancel reservation
    public static void cancelBooking() {

        System.out.print("\nEnter Booking ID to cancel: ");
        int id = sc.nextInt();

        for (Reservation reservation : reservations) {

            if (reservation.getBookingId() == id) {

                reservation.getRoom().setAvailable(true);

                reservations.remove(reservation);

                System.out.println("Reservation cancelled successfully.");
                return;
            }
        }

        System.out.println("Booking not found.");
    }

    // Main method
    public static void main(String[] args) {

        addRooms();

        int choice;

        System.out.println("====================================");
        System.out.println("     HOTEL RESERVATION SYSTEM");
        System.out.println("====================================");

        do {

            System.out.println("\n1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. View Booking Details");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    displayRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    viewBooking();
                    break;

                case 4:
                    cancelBooking();
                    break;

                case 5:
                    System.out.println("Thank you for using our Hotel Reservation System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
