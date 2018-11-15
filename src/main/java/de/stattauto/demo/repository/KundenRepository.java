package de.stattauto.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.stattauto.demo.entity.Kunde;

@Repository
public interface KundenRepository extends JpaRepository<Kunde, Long>{
	
	Collection<Kunde> findByNummer(String nummer);

}
