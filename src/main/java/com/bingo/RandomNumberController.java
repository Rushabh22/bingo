package com.bingo;

import java.util.*;
import java.util.stream.Collectors;

public class RandomNumberController {
    private final Set<Integer> generatedNumbers = new HashSet<>();
    private final Random random = new Random();

    private static final RandomNumberController randomNumberController = new RandomNumberController();
    public static RandomNumberController getInstance() {
        return randomNumberController;
    }

    public Integer generateLuckyNumber(){
        Integer randomNumber = random.nextInt(90);
        if(generatedNumbers.contains(randomNumber)){
            return generateLuckyNumber();
        }else {
            generatedNumbers.add(randomNumber);
            return randomNumber;
        }
    }

    public Verification verify(String numbers){
        Verification verification = new Verification();
        verification.setInput(Arrays.stream(numbers.split(",")).map(Integer::valueOf).sorted().collect(Collectors.toList()));
        List<Integer> unVerified = Arrays.stream(numbers.split(",")).map(Integer::valueOf).sorted().collect(Collectors.toList());
        unVerified.removeAll(generatedNumbers);
        verification.setNotPresent(unVerified);
        if ((unVerified.isEmpty())) {
            verification.setResult("Successful Verification!");
        } else {
            verification.setResult("Verification Failure!");
        }
        return verification;
    }

    public GeneratedNumbers numbersTillNow(){
        GeneratedNumbers generated = new GeneratedNumbers();
        generated.setGenerated(generatedNumbers.stream().sorted().collect(Collectors.toList()));
        return generated;
    }

    public GeneratedNumbers reset(){
        generatedNumbers.clear();
        return numbersTillNow();
    }


}