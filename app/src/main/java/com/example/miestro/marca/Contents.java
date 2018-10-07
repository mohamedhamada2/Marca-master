package com.example.miestro.marca;

/**
 * Created by MIESTRO on 01/02/2018.
 */

public class Contents {
    String title,description,urltoimage;

    Contents( String title,String description,String urltoimage){

        setTitle(title);
        setDescription(description);
        setUrltoimage(urltoimage);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrltoimage() {
        return urltoimage;
    }

    public void setUrltoimage(String urltoimage) {
        this.urltoimage = urltoimage;
    }
}
