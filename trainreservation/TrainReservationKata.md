# Kata: Train Reservation

Von Emily Bache, https://github.com/emilybache/KataTrainReservation (MIT-Lizenz). Der Text unten ist das Original;
darunter steht, wie der Startstand in diesem Ordner dazu passt.

Railway operators aren't always known for their use of cutting edge technology, and in this case they're a little
behind the times. The railway people want you to help them to improve their online booking service. They'd like to be
able to not only sell tickets online, but to decide exactly which seats should be reserved, at the time of booking.

You're working on the "TicketOffice" service, and your next task is to implement the feature for reserving seats on a
particular train. The railway operator has a service-oriented architecture, and both the interface you'll need to
fulfill, and some services you'll need to use are already implemented.

## Business Rules around Reservations

There are various business rules and policies around which seats may be reserved. For a train overall, no more than 70%
of seats may be reserved in advance, and ideally no individual coach should have no more than 70% reserved seats either.
However, there is another business rule that says you _must_ put all the seats for one reservation in the same coach.
This could make you and go over 70% for some coaches, just make sure to keep to 70% for the whole train.

## The Guiding Test

The Ticket Office service needs to respond to a request that comes with data telling you which train the customer
wants to reserve seats on, and how many they want. It should return a reservation document.

A reservation comprises three fields, the train id, booking reference, and the ids of the seats that have been reserved.
Example json:

    {"train_id": "express_2000", "booking_reference": "75bcd15", "seats": ["1A", "1B"]}

If it is not possible to find suitable seats to reserve, the service should instead return an empty list of seats and an
empty string for the booking reference.

### Booking Reference Service

You can get a unique booking reference using a REST-based service (in the original a local Python service on
`http://localhost:8082/booking_reference`). A GET request returns a string that looks a bit like this:

    75bcd15

### Train Data Service

You can get information about which seats each train has by using the train data service (in the original
`http://localhost:8081/data_for_train/express_2000`). It returns a json document with information about the seats that
this train has, for example:

    {"seats": {"1A": {"booking_reference": "", "seat_number": "1", "coach": "A"}, "2A": {"booking_reference": "", "seat_number": "2", "coach": "A"}}}

All that's there is which seats the train has, and if they are already booked. A seat is available if the
"booking_reference" field contains an empty string. To reserve seats on a train, you make a POST request to
`http://localhost:8081/reserve` with three fields: "train_id", "seats" (a json encoded list of seat ids, for example
`'["1A", "2A"]'`) and "booking_reference". Note the server will prevent you from booking a seat that is already reserved
with another booking reference.

## Der Startstand in diesem Ordner

Die zwei Dienste sind hier Schnittstellen im Package `de.sharpsharp.trainreservation`: `TrainDataService` (Sitze eines
Zugs abfragen, Sitze reservieren) und `BookingReferenceService` (nächste Referenz). Im Test sind sie Mockito-Mocks; ein
Adapter gegen die HTTP-Dienste ist nicht Teil der Kata. `Seat`, `ReservationRequest` und `Reservation` sind Records,
`Reservation.none(trainId)` ist die leere Reservierung aus dem Guiding Test. `TicketOffice.makeReservation` hat den
ersten Fall (keine passenden Sitze) und einen `TODO` für den Rest. Der erste mockist-Test steht in `TicketOfficeTest`.
