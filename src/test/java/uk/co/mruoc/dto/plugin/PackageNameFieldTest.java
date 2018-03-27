package uk.co.mruoc.dto.plugin;

import org.junit.Test;

import javax.swing.JTextField;

import static org.assertj.core.api.Assertions.assertThat;

public class PackageNameFieldTest {

    private final JTextField field = new PackageNameField();

    @Test
    public void shouldReturnDefaultPackageName() {
        assertThat(field.getText()).isEqualTo("uk.co.temp");
    }

}
