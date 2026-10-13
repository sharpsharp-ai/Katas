package de.sharpsharp.tripservice.trip;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

public class TripServiceTest {

    @Test
    public void canary() {
        assertThat(true, is(not(false)));
    }
}
