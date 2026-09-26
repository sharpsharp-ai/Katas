package de.sharpsharp.trainreservation;

import java.util.List;

/** Das Ergebnis einer Buchung. Ohne passende Sitze: leere Referenz, keine Sitze. */
public record Reservation(String trainId, String bookingReference, List<Seat> seats) {

    public static Reservation none(String trainId) {
        return new Reservation(trainId, "", List.of());
    }
}
