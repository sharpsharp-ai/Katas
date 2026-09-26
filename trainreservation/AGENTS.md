# Train Reservation

Die Regeln der Wurzel gelten (`../AGENTS.md`). Hier nur, was diese Kata besonders macht.

## Struktur
- `src/main/java/de/sharpsharp/trainreservation/TicketOffice.java`: `makeReservation(ReservationRequest)`, die Aufgabe. Bekommt beide Dienste im Konstruktor.
- `TrainDataService.java`, `BookingReferenceService.java`: die zwei Dienste als Schnittstellen (Ports). Im Test sind sie Mocks; ein Adapter gegen die HTTP-Dienste des Originals ist nicht Teil der Kata.
- `Seat.java`, `ReservationRequest.java`, `Reservation.java`: Werte als Records. `Reservation.none(trainId)` ist die leere Reservierung.
- `src/test/java/de/sharpsharp/trainreservation/TicketOfficeTest.java`: der erste mockist-Test, Mockito-Runner, Mocks als Felder.
- `TrainReservationKata.md`: die Aufgabe und die Geschäftsregeln (Emily Bache).

## Der Weg
- Mockist TDD: Abfragen an die Dienste stubben (`when(...).thenReturn(...)`), Befehle an sie verifizieren (`verify(trainData).reserve(...)`), nie beides im selben Test.
- Regeln aus dem Dokument, eine je Test: höchstens 70 % der Sitze eines Zugs, alle Sitze einer Reservierung im selben Wagen, keine passenden Sitze heißt leere Reservierung.
- `/implementiere` mit dem Testnamen, `/generate-tests-from-spec` für die Regeln aus dem Dokument.
