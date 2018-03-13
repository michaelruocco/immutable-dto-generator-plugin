package uk.co.mruoc.dto.plugin;

public class GenerateDtoField {

    private final String fieldName;
    private final Class<?> type;

    GenerateDtoField(String fieldName, Class<?> type) {
        this.fieldName = fieldName;
        this.type = type;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Class<?> getFieldType() {
        return type;
    }

}
