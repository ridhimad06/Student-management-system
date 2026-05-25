package MovieTicketBookingSystem;

import java.util.Scanner;

class MovieTicketSystem {
    int totalSeats = 50;
    int bookedSeats = 0;

    void bookTickets(int seats) {
        if (seats <= 0) {
            System.out.println("Invalid number of seats.");
        } else if (seats <= totalSeats - bookedSeats) {
            bookedSeats = bookedSeats + seats;
            System.out.println(seats + " ticket(s) booked successfully!");
        } else {
            System.out.println("Sorry, only " + (totalSeats - bookedSeats) + " seat(s) available.");
        }
    }

    void checkSeatAvailability() {
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Booked Seats: " + bookedSeats);
        System.out.println("Available Seats: " + (totalSeats - bookedSeats));
    }

    void cancelTickets(int seats) {
        if (seats <= 0) {
            System.out.println("Invalid number of seats.");
        } else if (seats <= bookedSeats) {
            bookedSeats = bookedSeats - seats;
            System.out.println(seats + " ticket(s) cancelled successfully!");
        } else {
            System.out.println("You cannot cancel more tickets than booked.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieTicketSystem movie = new MovieTicketSystem();

        int choice;

        do {
            System.out.println("\n--- Movie Ticket System ---");
            System.out.println("1. Book Tickets");
            System.out.println("2. Check Seat Availability");
            System.out.println("3. Cancel Tickets");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of tickets to book: ");
                    int book = sc.nextInt();
                    movie.bookTickets(book);
                    break;

                case 2:
                    movie.checkSeatAvailability();
                    break;

                case 3:
                    System.out.print("Enter number of tickets to cancel: ");
                    int cancel = sc.nextInt();
                    movie.cancelTickets(cancel);
                    break;

                case 4:
                    System.out.println("Thank you! Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}