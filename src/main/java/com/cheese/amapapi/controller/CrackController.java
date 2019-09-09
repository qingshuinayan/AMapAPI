package com.cheese.amapapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Icemap
 * @date 2019-09-06 16:04
 */
@RestController
@RequestMapping("/")
public class CrackController {
    @GetMapping("/null")
    public String crackAMapRequest () {
        return null;
    }
}
