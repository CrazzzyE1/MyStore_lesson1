package com.litvak.mystore_lesson1.dao;

import com.litvak.mystore_lesson1.domain.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketRepository extends JpaRepository<Bucket, Long> {

}
