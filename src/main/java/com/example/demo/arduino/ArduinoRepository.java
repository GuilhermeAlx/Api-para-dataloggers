package com.example.demo.arduino;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;




@Repository
public interface ArduinoRepository extends JpaRepositoryImplementation<Arduino, Long> {

    
}


