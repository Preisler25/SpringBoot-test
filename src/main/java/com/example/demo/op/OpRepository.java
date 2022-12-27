package com.example.demo.op;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpRepository  extends JpaRepository<Operations, Long> {
}
