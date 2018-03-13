package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.ui.ValidationInfo;
import org.junit.Test;

import javax.swing.JTextField;

import static org.assertj.core.api.Assertions.assertThat;

public class AddFieldPanelTest {

    @Test
    public void shouldReturnFieldWithDefaultFieldName() {
        AddFieldPanel panel = new AddFieldPanel();

        GenerateDtoField field = panel.getField();

        assertThat(field.getFieldName()).isEqualTo("myField");
    }

    @Test
    public void shouldReturnFieldWithDefaultFieldType() {
        AddFieldPanel panel = new AddFieldPanel();

        GenerateDtoField field = panel.getField();

        assertThat(field.getFieldType()).isEqualTo(String.class);
    }

    @Test
    public void shouldSetFieldNameAndType() {
        AddFieldPanel panel = new AddFieldPanel();
        GenerateDtoField expectedField = new GenerateDtoField("changedField", Object.class);

        panel.setField(expectedField);

        assertThat(panel.getField()).isEqualToComparingFieldByField(expectedField);
    }

    @Test
    public void shouldReturnErrorIfTypeIsNotValidValue() {
        ValidationInfo validationInfo = new ValidationInfo("name", new JTextField());
        TypeField typeField = new FakeTypeField(validationInfo);

        AddFieldPanel panel = new AddFieldPanel(new JTextField(), typeField);

        assertThat(panel.doValidate()).isEqualTo(validationInfo);
    }

}
