package org.philips.solid.app.util;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class UserInterfaceUtils {

    public static String getYesOrNoFromCheckBox(final JCheckBox checkbox) {
        return checkbox.isSelected() ? "Y" : "N";
    }

    public static Long getValueFromKeyValueComboBox(final JComboBox comboBox) {
        final String val = (String) comboBox.getSelectedItem();
        return Long.valueOf(val.split("-")[0].trim());
    }

}
