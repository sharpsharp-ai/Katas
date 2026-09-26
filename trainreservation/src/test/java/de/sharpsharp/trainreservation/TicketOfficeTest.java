package de.sharpsharp.trainreservation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TicketOfficeTest {

    @Mock
    TrainDataService trainData;
    @Mock
    BookingReferenceService bookingReferences;
    @InjectMocks
    TicketOffice ticketOffice;

    @Test
    public void reservesNothingWhenTheTrainHasNoFreeSeat() {
        //arrange
        when(trainData.seatsOf("express_2000")).thenReturn(List.of(
                new Seat("A", 1, "75bcd15"),
                new Seat("A", 2, "75bcd15")));
        //act
        Reservation reservation = ticketOffice.makeReservation(new ReservationRequest("express_2000", 1));
        //assert
        assertThat(reservation.trainId(), is("express_2000"));
        assertThat(reservation.bookingReference(), is(""));
        assertThat(reservation.seats(), is(empty()));
    }
}
