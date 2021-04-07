package com.example.stateapi2;

public class PojoLinear {

    String codeName;
    String codenumber;
    int images;



    public PojoLinear( String codeName,int images,String codenumber){
        this.codeName = codeName;
        this.images = images;
        this.codenumber = codenumber;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodenumber() {
        return codenumber;
    }

    public void setCodenumber(String codenumber) {
        this.codenumber = codenumber;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
