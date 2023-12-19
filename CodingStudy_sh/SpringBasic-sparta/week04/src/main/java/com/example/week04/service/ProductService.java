package com.example.week04.service;

import com.example.week04.models.ItemDto;
import com.example.week04.models.Product;
import com.example.week04.models.ProductMypriceRequestDto;
import com.example.week04.models.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor //final 선언된 멤버 변수를 자동으로 생성
@Service //서비스임을 선언
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional //메소드 동작이 SQL쿼리문임을 선언
    public Long update(Long id, ProductMypriceRequestDto requestDto){
        Product product = productRepository.findById(id).orElseThrow(
                ()->new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        product.update(requestDto);
        return id;
    }

    @Transactional //메소드 동작이 SQL쿼리문임을 선언
    public Long updateBySearch(Long id, ItemDto itemDto){
        Product product = productRepository.findById(id).orElseThrow(
                ()->new NullPointerException("해당아이디가 존재하지않습니다."));
        product.updateByItemDto(itemDto);
        return id;
    }
}
