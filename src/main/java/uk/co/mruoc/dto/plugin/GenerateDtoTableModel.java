package uk.co.mruoc.dto.plugin;

import com.intellij.ui.AddEditRemovePanel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateDtoTableModel extends AddEditRemovePanel.TableModel<GenerateDtoTableRow> {

    private final List<String> columnNames = Arrays.asList("Field Name", "Type");
    private final List<GenerateDtoTableRow> rows = new ArrayList<>();

    GenerateDtoTableModel() {
        //add(new GenerateDtoTableRow("firstName", String.class));
        //add(new GenerateDtoTableRow("lastName", String.class));
        //add(new GenerateDtoTableRow("balance", BigDecimal.class));
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames.get(columnIndex);
    }

    @Override
    public Object getField(GenerateDtoTableRow row, int columnIndex) {
        switch (columnIndex) {
            case 0: return row.getFieldName();
            case 1: return row.getType();
            default: throw new IllegalArgumentException("column index " + columnIndex);
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    public List<GenerateDtoTableRow> getData() {
        return rows;
    }

}
