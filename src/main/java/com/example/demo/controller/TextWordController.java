package com.example.demo.controller;

import com.example.demo.model.TextWordModel;
import com.example.demo.service.TextWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TextWordController {

    @Autowired
    private TextWordService textWordService;


    @RequestMapping(method = RequestMethod.POST)
    @PostMapping("/textWord/addTextWord")
    public void addTextWord(@RequestBody TextWordModel textWordModel) {
        textWordService.addTextWord(textWordModel);
    }

    @RequestMapping(method= RequestMethod.DELETE)
    @DeleteMapping("/textWord/deleteTextWord/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity< String > deleteTextWord(@PathVariable String id) {
        textWordService.deleteTextWord(id);
      return ResponseEntity.ok().body("Deleted successfully...!");

    }

    @RequestMapping(method = RequestMethod.PUT)
    @PutMapping("/textWord/updateTextWord/{id}")
    public void updateTextWord(@PathVariable String id, @RequestBody TextWordModel textWordModel) {
        textWordService.updateTextWord(id,textWordModel);
    }

    @GetMapping("/textWord/getTextWord/{id}")
    public TextWordModel getTextWord(@PathVariable String id) {
        return textWordService.getTextWord(id);
    }

    @GetMapping("/textWord/allTextWord")
    public List<TextWordModel> getAllTextWord() {
        return textWordService.getAllTextWord();
    }

    @RequestMapping("/textWord/{palindrome}")
    public boolean isPalindrome(@PathVariable String palindrome) {
      return textWordService.isPalindrome(palindrome);
    }
}
