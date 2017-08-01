package com.mvp.model.bean;

/**
 * 作者：李飞 on 2017/7/28 20:14
 * 类的用途：
 */

public class ImageMenu {

    private boolean isShow;
    private boolean isPinBi;
    private boolean isLianJie;
    private boolean isJueBao;
    private boolean isGuanZhu;
    private boolean isShouC;
    private boolean isFenX;
    private boolean isPinLun;
    private int position;

    public ImageMenu(boolean isShow, boolean isPinBi, boolean isLianJie, boolean isJueBao, boolean isGuanZhu, boolean isShouC, boolean isFenX, boolean isPinLun, int position) {
        this.isShow = isShow;
        this.isPinBi = isPinBi;
        this.isLianJie = isLianJie;
        this.isJueBao = isJueBao;
        this.isGuanZhu = isGuanZhu;
        this.isShouC = isShouC;
        this.isFenX = isFenX;
        this.isPinLun = isPinLun;
        this.position = position;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public boolean isPinBi() {
        return isPinBi;
    }

    public void setPinBi(boolean pinBi) {
        isPinBi = pinBi;
    }

    public boolean isLianJie() {
        return isLianJie;
    }

    public void setLianJie(boolean lianJie) {
        isLianJie = lianJie;
    }

    public boolean isJueBao() {
        return isJueBao;
    }

    public void setJueBao(boolean jueBao) {
        isJueBao = jueBao;
    }

    public boolean isGuanZhu() {
        return isGuanZhu;
    }

    public void setGuanZhu(boolean guanZhu) {
        isGuanZhu = guanZhu;
    }

    public boolean isShouC() {
        return isShouC;
    }

    public void setShouC(boolean shouC) {
        isShouC = shouC;
    }

    public boolean isFenX() {
        return isFenX;
    }

    public void setFenX(boolean fenX) {
        isFenX = fenX;
    }

    public boolean isPinLun() {
        return isPinLun;
    }

    public void setPinLun(boolean pinLun) {
        isPinLun = pinLun;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
