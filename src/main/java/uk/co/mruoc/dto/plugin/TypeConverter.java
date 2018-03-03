package uk.co.mruoc.dto.plugin;

import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;

public class TypeConverter extends ObjectToStringConverter {

    @Override
    public String getPreferredStringForItem(Object item) {
        if (item instanceof Class<?>) {
            Class<?> type = (Class<?>) item;
            return toString(type);
        }
        return item.toString();
    }

    private String toString(Class<?> type) {
        return type.getTypeName();
    }

}
