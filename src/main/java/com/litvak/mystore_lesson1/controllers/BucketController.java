package com.litvak.mystore_lesson1.controllers;

import com.litvak.mystore_lesson1.dto.BucketDTO;
import com.litvak.mystore_lesson1.service.BucketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/bucket")
public class BucketController {

    private final BucketService bucketService;

    public BucketController(BucketService bucketService) {
        this.bucketService = bucketService;
    }

    //    @GetMapping("/bucket")
    @GetMapping
    public String aboutBucket(Model model, Principal principal) {
        if (principal == null) {
            model.addAttribute("bucket", new BucketDTO());
        } else {
            BucketDTO bucketDto = bucketService.getBucketByUser(principal.getName());
            model.addAttribute("bucket", bucketDto);
        }
        return "bucket";
    }

    //    @PostMapping("/bucket")
    @PostMapping
    public String commitBucket(Principal principal) {
        if (principal != null) {
            bucketService.commitBucketToOrder(principal.getName());
        }
        return "redirect:/bucket";
    }

    @GetMapping("/remove/{id}")
    public String removeProductFromBucket(Principal principal,
                                          @PathVariable Long id) {
        bucketService.removeProductFromBucket(id, principal.getName());
        return "redirect:/bucket";
    }

}

