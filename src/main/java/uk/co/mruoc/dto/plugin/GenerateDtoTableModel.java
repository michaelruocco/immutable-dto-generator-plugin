package uk.co.mruoc.dto.plugin;

import com.intellij.ui.AddEditRemovePanel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateDtoTableModel extends AddEditRemovePanel.TableModel<GenerateDtoField> {

    private final List<String> columnNames = Arrays.asList("Field Name", "Type");
    private final List<GenerateDtoField> rows = new ArrayList<>();

    GenerateDtoTableModel() {
        //add(new GenerateDtoField("firstName", String.class));
        //add(new GenerateDtoField("lastName", String.class));
        //add(new GenerateDtoField("balance", BigDecimal.class));
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames.get(columnIndex);
    }

    @Override
    public Object getField(GenerateDtoField row, int columnIndex) {
        switch (columnIndex) {
            case 0: return row.getFieldName();
            case 1: return row.getFieldType();
            default: throw new IllegalArgumentException("column index " + columnIndex);
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    public List<GenerateDtoField> getData() {
        return rows;
    }

}
