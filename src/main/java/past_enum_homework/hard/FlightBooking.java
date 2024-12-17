package past_enum_homework.hard;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum FlightClass {
    ECONOMY, PREMIUM_ECONOMY, BUSINESS, FIRST_CLASS
}

enum Destination {
    NEW_YORK, LONDON, TOKYO, PARIS, SYDNEY
}

enum SeatPreference {
    WINDOW, AISLE, MIDDLE
}


public class FlightBooking {

    private static final Map<Destination, Integer> BASE_PRICES =
            Map.of(
                    Destination.NEW_YORK, 500,
                    Destination.LONDON, 600,
                    Destination.TOKYO, 700,
                    Destination.PARIS, 550,
                    Destination.SYDNEY, 1000
            );

    private static final Map<FlightClass, Double> CLASS_MULTIPLIERS =
            Map.of(
                    FlightClass.ECONOMY, 1.0,
                    FlightClass.PREMIUM_ECONOMY, 1.5,
                    FlightClass.BUSINESS, 2.0,
                    FlightClass.FIRST_CLASS, 3.0
            );

    private static final Map<SeatPreference, Integer> SEAT_CHARGES =
            Map.of(
                    SeatPreference.WINDOW, 50,
                    SeatPreference.AISLE, 25,
                    SeatPreference.MIDDLE, 0
            );


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            FlightClass flightClass = selectFlightClass(scanner);
            Destination destination = selectDestination(scanner);
            SeatPreference seatPreference = selectSeatPreference(scanner);
            int tickets = selectNumberOfTickets(scanner);
            String email = enterEmail(scanner);

            double totalPrice = calculateTotalPrice(destination, flightClass, seatPreference, tickets);

            printOrderSummary(destination, flightClass, seatPreference, tickets, totalPrice, email);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    private static FlightClass selectFlightClass(Scanner scanner) {
        System.out.println("Select a flight class: (ECONOMY, PREMIUM_ECONOMY, BUSINESS, FIRST_CLASS)");
        String input = scanner.nextLine().toUpperCase();
        if (isValidEnum(input, FlightClass.class)) {
            return FlightClass.valueOf(input);
        }
        throw new IllegalArgumentException("Invalid flight class selected.");
    }


    private static Destination selectDestination(Scanner scanner) {
        System.out.println("Select a destination: (NEW_YORK, LONDON, TOKYO, PARIS, SYDNEY)");
        String input = scanner.nextLine().toUpperCase();
        if (isValidEnum(input, Destination.class)) {
            return Destination.valueOf(input);
        }
        throw new IllegalArgumentException("Invalid destination selected.");
    }


    private static SeatPreference selectSeatPreference(Scanner scanner) {
        System.out.println("Choose a seat preference: (WINDOW, AISLE, MIDDLE)");
        String input = scanner.nextLine().toUpperCase();
        if (isValidEnum(input, SeatPreference.class)) {
            return SeatPreference.valueOf(input);
        }
        throw new IllegalArgumentException("Invalid seat preference selected.");
    }

    // Bilet sayinin daxil edilmesi ve check edilmesi
    private static int selectNumberOfTickets(Scanner scanner) {
        System.out.println("Enter the number of tickets (1-5):");
        String input = scanner.nextLine();
        if (input.matches("[1-5]")) {
            return Integer.parseInt(input);
        }
        throw new IllegalArgumentException("Invalid number of tickets. Please enter a number between 1 and 5.");
    }

    // Mailin daxil edilmesi ve check edilmesi
    private static String enterEmail(Scanner scanner) {
        System.out.println("Enter your email for booking confirmation:");
        String email = scanner.nextLine();
        if (isValidEmail(email)) {
            return email;
        }
        throw new IllegalArgumentException("Invalid email format.");
    }

    // Toplam deyerler hesablanir
    private static double calculateTotalPrice(Destination destination, FlightClass flightClass, SeatPreference seatPreference, int tickets) {
        int basePrice = BASE_PRICES.get(destination);
        double multiplier = CLASS_MULTIPLIERS.get(flightClass);
        int seatCharge = SEAT_CHARGES.get(seatPreference);

        return tickets * (basePrice * multiplier + seatCharge);
    }

    // Toplam deyerler cap edilir
    private static void printOrderSummary(Destination destination, FlightClass flightClass, SeatPreference seatPreference, int tickets, double totalPrice, String email) {
        System.out.println("\n--- Booking Summary ---");
        System.out.println("Destination: " + destination);
        System.out.println("Flight Class: " + flightClass);
        System.out.println("Seat Preference: " + seatPreference);
        System.out.println("Number of Tickets: " + tickets);
        System.out.printf("Total Price: $%.2f\n", totalPrice);
        System.out.println("Booking Confirmation will be sent to: " + email);
    }

    // Burda email validasiya edilir
    private static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Burda enum validasiya edilir
    private static <E extends Enum<E>> boolean isValidEnum(String value, Class<E> enumClass) {
        for(E e: enumClass.getEnumConstants()) {
            if (e.name().equals(value)) {
                return true;
            }
        }
        return false;
    }
}

