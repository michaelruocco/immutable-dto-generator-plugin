package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.ui.ValidationInfo;

public class FakeTypeField extends TypeField {

    private final ValidationInfo validationInfo;

    public FakeTypeField(ValidationInfo validationInfo) {
        this.validationInfo = validationInfo;
    }
    @Override
    public ValidationInfo doValidate() {
        return validationInfo;
    }

}
