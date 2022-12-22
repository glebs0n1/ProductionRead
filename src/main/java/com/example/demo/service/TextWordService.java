package com.example.demo.service;

import java.util.*;

import com.example.demo.model.TextWordModel;
import org.springframework.stereotype.Service;

@Service
public class TextWordService {

    private List< TextWordModel > textWordModelList = new ArrayList< TextWordModel >(Arrays.asList(
            new TextWordModel("1", "text"),
            new TextWordModel("2", "text two"),
            new TextWordModel("3", "text three")));
    public void addTextWord(TextWordModel textWordModel) {
        textWordModelList.add(textWordModel);
    }
    public TextWordModel getTextWord(String id) {
        return textWordModelList.stream().filter(textWordId -> id.equals(textWordId.getId())).findFirst().orElse(null);
    }

    public void deleteTextWord(String id) {
        textWordModelList.removeIf(textWord -> Objects.equals(textWord.getId(), id));
    }

    public void updateTextWord(String id, TextWordModel textWordModel) {
        int count = -1;
        for (TextWordModel model : textWordModelList) {
            count++;
            if ( Objects.equals(model.getId(), id) ) {
                textWordModelList.set(count, textWordModel);
            }
        }
    }

    public List< TextWordModel > getAllTextWord() {
        return textWordModelList;
    }

    public boolean isPalindrome(String string) {
        if ( string == null || string.equals("") ) {
            return false;
        }
        String palindrome = string.replaceAll("[^A-z]", "").toString();
        StringBuilder reversePalindrome = new StringBuilder();
        for (int i = palindrome.length() - 1; i >= 0; i--) {
            reversePalindrome.append(palindrome.charAt(i));
        }
        return palindrome.equals(reversePalindrome.toString());
    }
}