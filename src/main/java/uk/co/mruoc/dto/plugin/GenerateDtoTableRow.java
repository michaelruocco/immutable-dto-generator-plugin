package uk.co.mruoc.dto.plugin;

public class GenerateDtoTableRow {

    private final String fieldName;
    private final Class<?> type;

    GenerateDtoTableRow(String fieldName, Class<?> type) {
        this.fieldName = fieldName;
        this.type = type;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Class<?> getType() {
        return type;
    }

}
