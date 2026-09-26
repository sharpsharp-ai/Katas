package de.sharpsharp.trainreservation;

import java.util.List;

/** Der Zugdaten-Dienst (im Original http://localhost:8081): welche Sitze ein Zug hat, und Sitze reservieren. */
public interface TrainDataService {

    List<Seat> seatsOf(String trainId);

    void reserve(String trainId, List<Seat> seats, String bookingReference);
}
