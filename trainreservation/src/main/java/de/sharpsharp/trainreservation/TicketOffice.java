package de.sharpsharp.trainreservation;

import java.util.List;

public class TicketOffice {

    private final TrainDataService trainData;
    private final BookingReferenceService bookingReferences;

    public TicketOffice(TrainDataService trainData, BookingReferenceService bookingReferences) {
        this.trainData = trainData;
        this.bookingReferences = bookingReferences;
    }

    public Reservation makeReservation(ReservationRequest request) {
        List<Seat> free = trainData.seatsOf(request.trainId()).stream().filter(Seat::isFree).toList();
        if (free.size() < request.seatCount()) {
            return Reservation.none(request.trainId());
        }
        throw new UnsupportedOperationException("TODO: Sitze wählen, Buchungsreferenz holen, reservieren");
    }
}
