package com.bingo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BingoApi {
    RandomNumberController randomNumberController = RandomNumberController.getInstance();

    @GetMapping("/bingo")
    public LuckyNumber luckyNumber() {
        return new LuckyNumber(randomNumberController.generateLuckyNumber().toString());
    }

    @GetMapping("/generated")
    public GeneratedNumbers generatedNumber() {
        return randomNumberController.numbersTillNow();
    }

    @GetMapping("/verify")
    public Verification verify(@RequestParam(value = "numbers") String numbers) {
        return randomNumberController.verify(numbers);
    }

    @GetMapping("/reset")
    public GeneratedNumbers reset() {
        return randomNumberController.reset();
    }
}
