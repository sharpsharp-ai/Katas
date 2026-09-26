package de.sharpsharp.trainreservation;

/** Was der Kunde will: so viele Sitze in diesem Zug. */
public record ReservationRequest(String trainId, int seatCount) {
}
