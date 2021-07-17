package com.litvak.mystore_lesson1.service;

import com.litvak.mystore_lesson1.domain.Bucket;
import com.litvak.mystore_lesson1.domain.User;
import com.litvak.mystore_lesson1.dto.BucketDTO;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> productIds);

    void addProducts(Bucket bucket, List<Long> productIds);

    BucketDTO getBucketByUser(String name);

    void commitBucketToOrder(String username);

    void removeProductFromBucket(Long id, String name);
}
