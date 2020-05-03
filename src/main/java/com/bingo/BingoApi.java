package com.bingo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("Housie Fun App")
public class BingoApi {
    RandomNumberController randomNumberController = RandomNumberController.getInstance();

    @GetMapping("/bingo")
    @ApiOperation("Generate lucky number")
    public LuckyNumber luckyNumber() {
        return new LuckyNumber(randomNumberController.generateLuckyNumber().toString());
    }

    @GetMapping("/sorted")
    @ApiOperation("Check the generated numbers")
    public GeneratedNumbers generatedNumber() {
        return randomNumberController.numbersTillNow();
    }

    @GetMapping("/generatedInSequence")
    @ApiOperation("Check the generated numbers")
    public GeneratedNumbers generatedNumberInSequence() {
        return randomNumberController.numberInOrder();
    }

    @GetMapping("/lastTen")
    @ApiOperation("Check the last ten generated numbers")
    public GeneratedNumbers generatedLastTen() {
        return randomNumberController.lastTen();
    }

    @GetMapping("/verify")
    @ApiOperation("Verify the numbers, enter comma separated numbers to verify")
    public Verification verify(@RequestParam(value = "numbers") String numbers) {
        return randomNumberController.verify(numbers);
    }

    @DeleteMapping("/reset")
    @ApiOperation("Reset the numbers and generate it again")
    public GeneratedNumbers reset() {
        return randomNumberController.reset();
    }
}
