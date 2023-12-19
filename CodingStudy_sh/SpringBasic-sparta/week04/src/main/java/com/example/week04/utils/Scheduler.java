package com.example.week04.utils;

import com.example.week04.models.ItemDto;
import com.example.week04.models.Product;
import com.example.week04.models.ProductRepository;
import com.example.week04.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor //final 멤버 변수를 자동으로 생성합니다.
@Component //스프링 필요시 자동으로 생성하는 클래스 목록에 추가합니다.
public class Scheduler {
    private final ProductRepository productRepository;
    private final ProductService productService;
    private final NaverShopSearch naverShopSearch;

    //초,분,시,일,월,주 순서
    @Scheduled(cron = "0 0 1 * * *") //0초 0분 1시 매일 매월 매주  , 즉 매일 1시에 적용
    public void updatePrice() throws InterruptedException {
        //오류 발생시 InterruptedException는 방해 요소 알려주는거

        System.out.println("가격 업데이트 실행");
        //저장된 모든 관심상품 조회
        List<Product> productList = productRepository.findAll();
        for (int i = 0; i < productList.size(); i++) {
            //1초에 한상품씩 조회
            TimeUnit.SECONDS.sleep(1); //1초마다 쉬어라 , 이걸하는 이유는 너무 빨리 자주하면 네이버에서 막아버림
            //i번째 관심상품을 꺼냅니다.
            Product p = productList.get(i);
            //i번쨰 관심상품의 제목으로 검색을 실행
            String title = p.getTitle();
            String resultString = naverShopSearch.search(title);
            //i번쨰 관심 상품의 검색 결과 목록중에서 첫번째 결과를 꺼냅니다.
            List<ItemDto> itemDtoList = naverShopSearch.fromJSONtoItems(resultString);
            ItemDto itemDto = itemDtoList.get(0);
            //i번째 관심상품 정보는 업데이트합니다.
            Long id = p.getId();
            productService.updateBySearch(id, itemDto);
        }


    }


}
