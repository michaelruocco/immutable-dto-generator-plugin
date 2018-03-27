package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.ui.ValidationInfo;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class TypeFieldTest {

    private final TypeField field = new TypeField();

    @Test
    public void typeShouldDefaultToString() {
        assertThat(field.getType()).isEqualTo("java.lang.String");
    }

    @Test
    public void shouldThrowExceptionIfGetTypeCalledWhenTypeIsInvalid() {
        field.setText("not-valid");

        Throwable thrown = catchThrowable(field::getType);

        assertThat(thrown).isInstanceOf(InvalidTypeException.class)
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid type not-valid");
    }

    @Test
    public void doValidateShouldReturnValidationInfoIfTypeIsNotValid() {
        field.setText("not-valid");

        ValidationInfo validationInfo = field.doValidate();

        assertThat(validationInfo.message).isEqualTo("Invalid type not-valid");
    }

    @Test
    public void doValidateShouldReturnNullIfTypeIsValid() {
        field.setText("Object");

        ValidationInfo validationInfo = field.doValidate();

        assertThat(validationInfo).isNull();
    }

}
