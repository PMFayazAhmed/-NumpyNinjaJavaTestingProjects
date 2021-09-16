package com.ninja.demo.jpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ninja.demo.entity.DemoEntity;
@Repository
public interface DemoRepository extends JpaRepository<DemoEntity, Long> {
	

}