package com.example.week04.service;

import com.example.week04.models.Product;
import com.example.week04.models.ProductMypriceRequestDto;
import com.example.week04.models.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor //productRepository가 매번 생성되도록 선언
@Service
public class ProduceService {

    private final ProductRepository productRepository; //여기서 유일하게 필요하므로  private final 사용

    @Transactional //DB업데이트 관련 작업이라는 의미로 선언
    public Long update(Long id, ProductMypriceRequestDto requestDto) {
        Product product =productRepository.findById(id).orElseThrow(() -> new NullPointerException("아이디가 존재하지않습니다."));
        product.update(requestDto);
        return id;
    }


}
