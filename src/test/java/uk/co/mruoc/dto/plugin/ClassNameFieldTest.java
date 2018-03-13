package uk.co.mruoc.dto.plugin;

import org.junit.Test;

import javax.swing.JTextField;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassNameFieldTest {

    private final JTextField field = new ClassNameField();

    @Test
    public void shouldReturnDefaultClassName() {
        assertThat(field.getText()).isEqualTo("MyClass");
    }

}
