package de.sharpsharp.trainreservation;

/** Ein Sitz, wie ihn der Zugdaten-Dienst kennt: "1A" ist Sitz 1 im Wagen A. Frei, wenn die Buchungsreferenz leer ist. */
public record Seat(String coach, int number, String bookingReference) {

    public boolean isFree() {
        return bookingReference.isEmpty();
    }
}
