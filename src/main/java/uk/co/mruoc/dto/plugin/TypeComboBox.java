package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.ui.ComboBox;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import java.util.Collection;

public class TypeComboBox extends ComboBox<Class<?>> {

    TypeComboBox() {
        this(new StubbedTypeProvider());
    }

    private TypeComboBox(TypeProvider typeProvider) {
        addTypes(typeProvider.getTypes());
        AutoCompleteDecorator.decorate(this, new TypeConverter());
    }

    private void addTypes(Collection<Class<?>> types) {
        types.forEach(this::addItem);
    }

    public Class<?> getSelectedType() {
        return this.getItemAt(this.getSelectedIndex());
    }

}
