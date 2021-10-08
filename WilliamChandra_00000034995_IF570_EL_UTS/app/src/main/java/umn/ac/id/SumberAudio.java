package umn.ac.id;

import java.io.Serializable;

public class SumberAudio implements Serializable {
    private String name;
    private String genre;
    private String audioURI;

    public SumberAudio(String name, String genre, String audioURI){
        this.name = name;
        this.genre = genre;
        this.audioURI = audioURI;
    }

    public String getName() { return this.name; }
    public String getGenre() { return this.genre; }
    public String getAudioURI() { return this.audioURI; }

    public void setName(String name){
        this.name = name;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setAudioURI(String audioURI) {
        this.audioURI = audioURI;
    }

    public String toString() { return this.getName() + " => " + this.getGenre(); }
}
