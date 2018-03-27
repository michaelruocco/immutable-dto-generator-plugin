package uk.co.mruoc.dto.plugin;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InvalidTypeExceptionTest {

    private static final Throwable CAUSE = new Exception();
    private static final String MESSAGE = "my message";

    @Test
    public void shouldReturnMessage() {
        Throwable throwable = new InvalidTypeException(MESSAGE, CAUSE);

        assertThat(throwable.getMessage()).isEqualTo(MESSAGE);
    }

    @Test
    public void shouldReturnCause() {
        Throwable throwable = new InvalidTypeException(MESSAGE, CAUSE);

        assertThat(throwable.getCause()).isEqualTo(CAUSE);
    }

}
