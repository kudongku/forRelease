package com.example.forrelease;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HiService {

    private final HiRepository hiRepository;

    public void createHi(String hiStr) {
        Hi hi = new Hi(hiStr);
        hiRepository.save(hi);
    }

    public List<Hi> getHi(String hiStr) {
        return hiRepository.findAllByContents(hiStr);
    }
}
