package com.virtual.third.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtual.third.model.Element;

@Repository
public interface ElementRepository extends JpaRepository<Element, Long> {
}
