package org.raul.plugins.serverSleepML.Functionallity;

public class Config {
    private final String lang;
    private int percent;
    private final boolean showPercent;

    public Config(String lang, int percent, boolean showPercent) {
        this.lang = lang;
        this.percent = percent;
        this.showPercent = showPercent;
    }

    public String getLang() {
        return lang;
    }

    public boolean isShowPercent() {
        return showPercent;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent){
        this.percent = percent;
    }
}
