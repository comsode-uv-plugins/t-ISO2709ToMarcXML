package eu.unifiedviews.plugins.marc;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ISO2709ToMarcXMLConfig_V1 {
    
    private boolean skipOnError = false;

    public ISO2709ToMarcXMLConfig_V1() {
    }
    
    public boolean isSkipOnError() {
        return skipOnError;
    }

    public void setSkipOnError(boolean skipOnError) {
        this.skipOnError = skipOnError;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
    }
}
