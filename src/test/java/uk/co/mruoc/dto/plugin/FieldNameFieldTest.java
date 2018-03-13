package uk.co.mruoc.dto.plugin;

import org.junit.Test;

import javax.swing.JTextField;

import static org.assertj.core.api.Assertions.assertThat;

public class FieldNameFieldTest {

    private final JTextField field = new FieldNameField();

    @Test
    public void shouldReturnDefaultFieldName() {
        assertThat(field.getText()).isEqualTo("myField");
    }

}
