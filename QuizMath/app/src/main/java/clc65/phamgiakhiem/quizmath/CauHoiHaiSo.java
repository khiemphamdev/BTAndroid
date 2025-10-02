package clc65.phamgiakhiem.quizmath;

public class CauHoiHaiSo
{
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;// số thứ tự
    String loiHoi;  // 33+ 66
    int daDung; // 99
    int sai1;  //100
    int sai2; //90
    int sai3; //68

    // Get/Set/Contructer


    public CauHoiHaiSo(int id, String loiHoi, int daDung, int sai1, int sai2, int sai3) {
        this.id =id;
        this.loiHoi = loiHoi;
        this.daDung = daDung;
        this.sai1 = sai1;
        this.sai2 = sai2;
        this.sai3 = sai3;
    }

    public String getLoiHoi() {
        return loiHoi;
    }

    public int getDaDung() {
        return daDung;
    }

    public int getSai1() {
        return sai1;
    }

    public int getSai2() {
        return sai2;
    }

    public int getSai3() {
        return sai3;
    }

    public void setLoiHoi(String loiHoi) {
        this.loiHoi = loiHoi;
    }

    public void setDaDung(int daDung) {
        this.daDung = daDung;
    }

    public void setSai1(int sai1) {
        this.sai1 = sai1;
    }

    public void setSai2(int sai2) {
        this.sai2 = sai2;
    }

    public void setSai3(int sai3) {
        this.sai3 = sai3;
    }
}
