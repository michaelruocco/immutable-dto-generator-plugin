package uk.co.mruoc.dto.plugin;

import org.junit.Test;

import javax.swing.event.DocumentListener;
import java.awt.event.ItemListener;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassNamesPanelTest {

    private final FakeTextField packageNameField = new FakeTextField();
    private final FakeTextField classNameField = new FakeTextField();
    private final FakeSourceRouteComboBox sourceComboBox = new FakeSourceRouteComboBox();
    private final FakeSourceRouteComboBox testComboBox = new FakeSourceRouteComboBox();

    private final ClassNamesPanel panel = new ClassNamesPanel(packageNameField,
            classNameField,
            sourceComboBox,
            testComboBox);

    @Test
    public void shouldAddItemListenerToComboBoxes() {
        ItemListener listener = new FakeItemListener();

        panel.addItemListener(listener);

        assertThat(sourceComboBox.getItemListeners()).contains(listener);
        assertThat(testComboBox.getItemListeners()).contains(listener);
    }

    @Test
    public void shouldAddDocumentListenerToTextFields() {
        DocumentListener listener = new FakeDocumentListener();

        panel.addDocumentListener(listener);

        assertThat(packageNameField.getDocumentListener()).isEqualTo(listener);
        assertThat(classNameField.getDocumentListener()).isEqualTo(listener);
    }

    @Test
    public void shouldReturnSourcePaths() {
        assertThat(panel.getSourcePath()).isNull();
        assertThat(panel.getTestSourcePath()).isNull();
    }

    @Test
    public void shouldNotBeCompletedIfNoSourcePathSelected() {
        assertThat(panel.isCompleted()).isFalse();
    }

    @Test
    public void shouldNotBeCompletedIfNoTestSourcePathSelected() {
        sourceComboBox.setHasSelectedSource(true);

        assertThat(panel.isCompleted()).isFalse();
    }

    @Test
    public void shouldNotBeCompletedIfNoClassNameEntered() {
        sourceComboBox.setHasSelectedSource(true);
        testComboBox.setHasSelectedSource(true);
        classNameField.setText("");

        assertThat(panel.isCompleted()).isFalse();
    }

    @Test
    public void shouldBeCompletedIfSourceSetsSelectedAndClassNameEntered() {
        sourceComboBox.setHasSelectedSource(true);
        testComboBox.setHasSelectedSource(true);
        classNameField.setText("SomeClass");

        assertThat(panel.isCompleted()).isTrue();
    }

    @Test
    public void packageNameShouldDefaultToEmpty() {
        FakeDocument document = new FakeDocument();
        classNameField.setDocument(document);

        assertThat(panel.getPackageName()).isEmpty();
    }

}
