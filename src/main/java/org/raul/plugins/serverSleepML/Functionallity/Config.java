package org.raul.plugins.serverSleepML.Functionallity;

public class Config {
    private final String lang;
    private int percent;
    private final boolean showPercent;

    public Config(String lang, int percent, String show) {
        this.lang = lang;
        this.percent = percent;
        if(show.equalsIgnoreCase("percent")){
            showPercent = true;
        }else showPercent = !show.equalsIgnoreCase("amount");
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
