package com.ClientReq.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ClientReq.dto.Client;

@Repository 
public interface ClientRepo extends JpaRepository <Client, Integer>{

}
