package ru.geekbrains.java2.dz.dz1.EmelyanovSergey;

public enum BarriersENum {
    SIMPLE_BAR("барьеры",10), WATER_PIT("водяная яма",15), FENCE("забор",20), CABLE("канат",25), FIRE_BAR("огненный барьер",30);
    private String rusName;
    private int powerToPass; //секунд на прохождение

    BarriersENum(String _rusName, int _powerToPass) {
        rusName=_rusName;
        powerToPass =_powerToPass;
    }

    public String getRusName() {
        return rusName;
    }

    public String getInfo() {
        return rusName+" усилие="+ powerToPass;
    }

    public int getPowerToPass() {
        return powerToPass;
    }
}
