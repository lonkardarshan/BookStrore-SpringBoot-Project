package com.bookStore.bookStore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.bookStore.Entity.MyBooklist;
@Repository
public interface MybookRepository extends JpaRepository<MyBooklist, Integer>{

}
