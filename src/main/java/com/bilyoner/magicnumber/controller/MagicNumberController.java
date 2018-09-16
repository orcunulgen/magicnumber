package com.bilyoner.magicnumber.controller;

import com.bilyoner.magicnumber.dto.MagicNumber;
import com.bilyoner.magicnumber.exception.BaseResponse;
import com.bilyoner.magicnumber.service.MagicNumberService;
import com.bilyoner.magicnumber.exception.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class MagicNumberController {

    @Autowired
    MagicNumberService magicNumberService;


    @PostMapping(path = "/number")
    public ResponseEntity<?> saveNumber(@RequestBody MagicNumber magicNumber) {
        magicNumberService.save(magicNumber);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/number/{number}")
    public ResponseEntity<?> getNumber(@PathVariable(value = "number") Long number) {
        return ResponseEntity.ok(magicNumberService.findByNumber(number));
    }

    @GetMapping(path = "/number")
    public ResponseEntity<?> findNumber(@RequestParam(value = "findMinimum") boolean findMinimum) {
        return ResponseEntity.ok(magicNumberService.findMinOrMaxNumber(findMinimum));
    }

    @GetMapping(path = "/numbers")
    public ResponseEntity<?> findNumber(@RequestParam(value = "orderBy") String field,
                                        @RequestParam(value = "direction") String direction) {
        return ResponseEntity.ok(magicNumberService.getAllNumbers(field, direction));
    }

    @DeleteMapping(path = "/number/{number}")
    public ResponseEntity<?> deleteNumber(@PathVariable(value = "number") Long number) {
        if (magicNumberService.deleteNumber(number)) {
            return ResponseEntity.accepted().body(new BaseResponse(ResponseCode.DELETE_OPERATION_SUCCESS.toString(), "Number: " + number + " deleted successfully"));
        } else {
            return ResponseEntity.badRequest().body(new BaseResponse(ResponseCode.NUMBER_NOT_FOUND.toString(), "Number: " + number + " could not found in db"));
        }

    }

}