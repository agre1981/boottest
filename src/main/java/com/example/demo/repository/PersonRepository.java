package com.example.demo.repository;

import com.example.demo.entity.PersonEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface PersonRepository extends PagingAndSortingRepository<PersonEntity, UUID> {
}
