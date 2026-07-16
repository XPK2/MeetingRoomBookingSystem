package org.example.policy.booking;

import org.example.model.Booking;
import org.example.model.User;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DefaultBookingTimePolicy implements BookingTimePolicy{
    private static final int MINIMUM_BOOKING_DURATION = 30;
    private static final int MAXIMUM_BOOKING_DURATION = 4;
    private static final int MINIMUM_ADVANCE_BOOKING_TIME = 30;
    private static final int MAXIMUM_ADVANCE_BOOKING_TIME = 30;
    private static final int OPEN_WORKING_HOUR = 8;
    private static final int CLOSE_WORKING_HOUR = 22;
    private static final List<DayOfWeek> WORKING_DAYS = new ArrayList<>(List.of(
            DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY
    ));

    @Override
    public void validate(User user, Booking booking) {
        if (booking.getEndTime().isBefore(booking.getStartTime())) {
            throw new RuntimeException("Start time must be before end time\n");
        }

        if (booking.getStartTime().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Booking must be in the future");
        }

        Duration bookingDuration = Duration.between(booking.getStartTime(), booking.getEndTime());

        if (bookingDuration.compareTo(Duration.ofMinutes(MINIMUM_BOOKING_DURATION)) < 0 || bookingDuration.compareTo(Duration.ofHours(MAXIMUM_BOOKING_DURATION)) > 0) {
            throw new RuntimeException("Invalid booking duration");
        }

        /* Bookings cannot overlap

         */

        if (booking.getStartTime().getHour() < OPEN_WORKING_HOUR || booking.getEndTime().getHour() > CLOSE_WORKING_HOUR) {
            throw new RuntimeException("Booking period must be in working hour");
        }

        DayOfWeek bookingDayOfWeek = booking.getStartTime().getDayOfWeek();

        if (!WORKING_DAYS.contains(bookingDayOfWeek)) {
            throw new RuntimeException("Booking period must be in working day");
        }

        Duration advanceBookingDuration = Duration.between(booking.getStartTime(), LocalDateTime.now());

        if(advanceBookingDuration.compareTo(Duration.ofMinutes(MINIMUM_ADVANCE_BOOKING_TIME)) < 0 ||
                advanceBookingDuration.compareTo(Duration.ofDays(MAXIMUM_ADVANCE_BOOKING_TIME)) > 0) {
            throw new RuntimeException("Invalid advance booking duration");
        }

        /* User may have at most 3 active bookings

         */
    }
}
