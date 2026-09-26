package de.sharpsharp.trainreservation;

/** Der Buchungsreferenz-Dienst (im Original http://localhost:8082): liefert je Aufruf eine neue Referenz wie "75bcd15". */
public interface BookingReferenceService {

    String nextBookingReference();
}
