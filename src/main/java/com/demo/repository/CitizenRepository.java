package com.demo.repository;

import com.demo.domain.entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CitizenRepository  extends JpaRepository<Citizen, String> {




 //   Optional<Citizen> findByFirstName (String firstName);
}
