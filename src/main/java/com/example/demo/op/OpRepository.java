package com.example.demo.op;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpRepository  extends JpaRepository<Operations, Long> {

}
