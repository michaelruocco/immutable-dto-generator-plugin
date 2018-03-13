package uk.co.mruoc.dto.plugin;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class GenerateDtoTableModelTest {

    private final GenerateDtoTableModel model = new GenerateDtoTableModel();

    @Test
    public void shouldReturnColumnHeaders() {
        assertThat(model.getColumnCount()).isEqualTo(2);
        assertThat(model.getColumnName(0)).isEqualTo("Field Name");
        assertThat(model.getColumnName(1)).isEqualTo("Type");
    }

    @Test
    public void shouldDefaultDataToEmpty() {
        assertThat(model.getData()).isEmpty();;
    }

    @Test
    public void shouldReturnColumnValues() {
        GenerateDtoField field = new GenerateDtoField("myName", "myType");
        assertThat(model.getField(field, 0)).isEqualTo(field.getFieldName());
        assertThat(model.getField(field, 1)).isEqualTo(field.getFieldType());
    }

    @Test
    public void shouldThrowExceptionForInvalidColumnIndex() {
        GenerateDtoField field = new GenerateDtoField("myName", "myType");

        Throwable thrown = catchThrowable(() -> model.getField(field, 2));

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("invalid column index 2");
    }
}
