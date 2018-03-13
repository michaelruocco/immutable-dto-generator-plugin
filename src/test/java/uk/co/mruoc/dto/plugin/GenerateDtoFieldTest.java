package uk.co.mruoc.dto.plugin;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GenerateDtoFieldTest {

    private static final String NAME = "myName";
    private static final String TYPE = "myType";

    private final GenerateDtoField field = new GenerateDtoField(NAME, TYPE);

    @Test
    public void shouldReturnFieldName() {
        assertThat(field.getFieldName()).isEqualTo(NAME);
    }

    @Test
    public void shouldReturnFieldType() {
        assertThat(field.getFieldType()).isEqualTo(TYPE);
    }

}
