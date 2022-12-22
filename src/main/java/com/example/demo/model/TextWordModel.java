package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TextWordModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String textWord;

    public TextWordModel () {

    }

    public TextWordModel (String id, String textWord) {
        super();
        this.id = Long.parseLong(id);
        this.textWord = textWord;
    }
    public long getId() {
        return id;
    }
    public void setId(String id) {
        this.id = Long.parseLong(id);
    }
    public String getTextWord() {
        return textWord;
    }
    public void setTextWord(String textWord) {
        this.textWord = textWord;
    }

    @Override
    public String toString() {
        return "TextWordModel [id=" + id + ", textWord=" + textWord + "]";
    }


}