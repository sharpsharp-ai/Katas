package de.sharpsharp.tripservice.trip;

import de.sharpsharp.tripservice.exception.UserNotLoggedInException;
import de.sharpsharp.tripservice.user.User;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TripServiceTest {

    @Spy
    TripService tripService = new TripService();

    @Test(expected = UserNotLoggedInException.class)
    public void userMayNotBeNull() {
        //arrange
        User loggedUser = null;
        doReturn(loggedUser).when(tripService).getLoggedUser();
        //act
        tripService.getTripsByUser(null);
    }
}
