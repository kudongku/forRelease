package com.example.forrelease;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HiRepository extends JpaRepository<Hi,Long> {

    List<Hi> findAllByContents(String hiStr);
}
