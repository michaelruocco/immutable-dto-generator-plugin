package uk.co.mruoc.dto.plugin;

public class GenerateDtoField {

    private final String fieldName;
    private final String type;

    GenerateDtoField(String fieldName, String type) {
        this.fieldName = fieldName;
        this.type = type;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldType() {
        return type;
    }

}
