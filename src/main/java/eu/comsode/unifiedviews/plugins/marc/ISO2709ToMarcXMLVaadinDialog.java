package eu.comsode.unifiedviews.plugins.marc;

import com.vaadin.data.util.ObjectProperty;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.NativeSelect;

import eu.unifiedviews.dpu.config.DPUConfigException;
import eu.unifiedviews.helpers.dpu.vaadin.dialog.AbstractDialog;

/**
 * DPU's configuration dialog. User can use this dialog to configure DPU
 * configuration.
 */
public class ISO2709ToMarcXMLVaadinDialog extends AbstractDialog<ISO2709ToMarcXMLConfig_V1> {

    private static final long serialVersionUID = 4106235356505425558L;

    public static String[] encoding = { "AUTO", "UTF-8", "UTF-16", "ISO-8859-1", "windows-1250" };

    private ObjectProperty<Boolean> skipOnError = new ObjectProperty<Boolean>(false);

    private NativeSelect encodingSelect;

    public ISO2709ToMarcXMLVaadinDialog() {
        super(ISO2709ToMarcXML.class);
    }

    @Override
    protected void buildDialogLayout() {
        FormLayout mainLayout = new FormLayout();

        setWidth("100%");
        setHeight("100%");

        encodingSelect = new NativeSelect(ctx.tr("dialog.charset"));
        for (String encd : encoding) {
            encodingSelect.addItem(encd);
            encodingSelect.setItemCaption(encd, encd);
        }
        encodingSelect.setNullSelectionAllowed(false);
        encodingSelect.setImmediate(true);
        mainLayout.addComponent(encodingSelect);
        mainLayout.addComponent(new CheckBox(ctx.tr("dialog.skipOnError"), skipOnError));
        mainLayout.setSpacing(true);
        mainLayout.setMargin(true);

        setCompositionRoot(mainLayout);
    }

    @Override
    public void setConfiguration(ISO2709ToMarcXMLConfig_V1 conf) throws DPUConfigException {
        skipOnError.setValue(conf.isSkipOnError());
        encodingSelect.select(conf.getCharset());
    }

    @Override
    public ISO2709ToMarcXMLConfig_V1 getConfiguration() throws DPUConfigException {
        ISO2709ToMarcXMLConfig_V1 conf = new ISO2709ToMarcXMLConfig_V1();
        conf.setSkipOnError(skipOnError.getValue());
        conf.setCharset((String) encodingSelect.getValue());
        return conf;
    }

}
