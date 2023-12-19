let targetId;

$(document).ready(function () {
    // id 가 query 인 녀석 위에서 엔터를 누르면 execSearch() 함수를 실행하라는 뜻입니다.
    $('#query').on('keypress', function (e) {
        if (e.key == 'Enter') {
            execSearch();
        }
    });
    $('#close').on('click', function () {
        $('#container').removeClass('active');
    })

    $('.nav div.nav-see').on('click', function () {
        $('div.nav-see').addClass('active');
        $('div.nav-search').removeClass('active');

        $('#see-area').show();
        $('#search-area').hide();
    })
    $('.nav div.nav-search').on('click', function () {
        $('div.nav-see').removeClass('active');
        $('div.nav-search').addClass('active');

        $('#see-area').hide();
        $('#search-area').show();
    })

    $('#see-area').show();
    $('#search-area').hide();

    showProduct();
})


function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

//////////////////////////////////////////////////////////////////////////////////////////
///// 여기 아래에서부터 코드를 작성합니다. ////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////

function execSearch() {
    /**
     * 검색어 input id: query
     * 검색결과 목록: #search-result-box
     * 검색결과 HTML 만드는 함수: addHTML
     */
    $('#search-result-box').empty(); //검색시 해당 영역을 비워준다.
    // 1. 검색창의 입력값을 가져온다.
    let query = $('#query').val(); // 해당 id 입력창의 값을 가져온다.
    // 2. 검색창 입력값을 검사하고, 입력하지 않았을 경우 focus.
    if (query == '') {
        alert("검색어를 입력해주세요");
        $('#query').focus(); //포커스를 잡게만든다. 다시 입력창이 반짝이게한다.
    }
    // 3. GET /api/search?query=${query} 요청
    $.ajax({
        type: 'GET',
        url: `/api/search?query=${query}`,
        success: function (response) {
            //요청 성공시에
            for (let i = 0; i < response.length; i++) { //각 성공시받은 데이터들로
                let itemDto = response[i]; //각각 받아서
                let tempHtml = addHTML(itemDto); // html 추가할 내용을 구성
                $('#search-result-box').append(tempHtml); //html 추가할 영역에 추가한다.
            }
        }

    })
    //contenttype, data 는 get에서는 사용안함 , put, post에서만 사용한다. 참고하기

    // 4. for 문마다 itemDto를 꺼내서 HTML 만들고 검색결과 목록에 붙이기!


}

function addHTML(itemDto) {
    /**
     * class="search-itemDto" 인 녀석에서
     * image, title, lprice, addProduct 활용하기
     * 참고) onclick='addProduct(${JSON.stringify(itemDto)})'
     */
    return ` <div class="search-itemDto">
            <div class="search-itemDto-left">
                <img src="${itemDto.image}" alt="">
            </div>
            <div class="search-itemDto-center">
                <div>${itemDto.title}</div>
                <div class="price">
                    ${itemDto.lprice}
                    <span class="unit">원</span>
                </div>
            </div>
            <div class="search-itemDto-right">
                <img src="images/icon-save.png" alt="" onclick='addProduct(${JSON.stringify(itemDto)})'>
            </div>
        </div>`
    //${JSON.stringify(itemDto)}는 json은 addProduct에서 사용을 못하니 , 문자로 바꿔주는것임
}

function addProduct(itemDto) {
    /**
     * modal 뜨게 하는 법: $('#container').addClass('active');
     * data를 ajax로 전달할 때는 두 가지가 매우 중요
     * 1. contentType: "application/json",
     * 2. data: JSON.stringify(itemDto),
     */

    // console.log(itemDto); //다시 되돌려줄때도 JSON.stringify를 해줘야됨 , 그로인해서 해보는 테스트임
    // console.log(JSON.stringify(itemDto));

    // 1. POST /api/products 에 관심 상품 생성 요청
    $.ajax({
        type: "POST",
        url: "/api/products",
        data: JSON.stringify(itemDto),
        contentType: "application/json",
        success: function (response) {
            // console.log(response);
            $('#container').addClass('active'); //아이디가 container를 찾아서 클래스에 active인것을 추가한다는 의미
            targetId = response.id; //tagetID는 이 함수 맨위에 기본으로 만들어둔것이있음
        }

    })
    // 2. 응답 함수에서 modal을 뜨게 하고, targetId 를 reponse.id 로 설정 (숙제로 myprice 설정하기 위함)

}

function showProduct() {
    /**
     * 관심상품 목록: #product-container
     * 검색결과 목록: #search-result-box
     * 관심상품 HTML 만드는 함수: addProductItem
     */
    // 1. GET /api/products 요청
    $.ajax({
        type: 'GET',
        url: '/api/products',
        success: function (response) {
            // 2. 관심상품 목록, 검색결과 목록 비우기
            $('#product-container').empty();
            $('#search-result-box').empty();
            // 3. for 문마다 관심 상품 HTML 만들어서 관심상품 목록에 붙이기!
            for (let i = 0; i < response.length; i++) {
                let product = response[i];
                let tempHtml = addProductItem(product);
                $('#product-container').append(tempHtml);
            }
        }
    })
}

function addProductItem(product) {
    // link, image, title, lprice, myprice 변수 활용하기
    return `<div class="product-card" onclick="window.location.href='${product.link}'">
            <div class="card-header">
                <img src="${product.image}"
                     alt="">
            </div>
            <div class="card-body">
                <div class="title">
                    ${product.title}
                </div>
                <div class="lprice">
                    <span>${numberWithCommas(product.lprice)}</span>원
                </div>
                <div class="isgood ${product.lprice <= product.myprice ? '' : 'none'}">
                    최저가
                </div>
            </div>
        </div>`;
}

function setMyprice() {
    /**
     * 숙제! myprice 값 설정하기.
     * 1. id가 myprice 인 input 태그에서 값을 가져온다.
     * 2. 만약 값을 입력하지 않았으면 alert를 띄우고 중단한다.
     * 3. PUT /api/product/${targetId} 에 data를 전달한다.
     *    주의) contentType: "application/json",
     *         data: JSON.stringify({myprice: myprice}),
     *         빠뜨리지 말 것!
     * 4. 모달을 종료한다. $('#container').removeClass('active');
     * 5, 성공적으로 등록되었음을 알리는 alert를 띄운다.
     * 6. 창을 새로고침한다. window.location.reload();
     */
    let myprice = $('#myprice').val(); //myprice id를 가진 html 입력창의 값을 가져온다.
    if (myprice == '') { // 입력 문자가 빈칸인 경우 알림
        alert('값을 입력해주세요.');
        return;
    }
    $.ajax({
        type: 'PUT',
        url: `/api/products/${targetId}`, // ${targetId}때문에 백틱을 이용한다.
        contentType: 'application/json',//밑의 data가 json형식이라는 걸 알려준다
        data: JSON.stringify({'myprice': myprice}), //바로 문자로 보내는가 아리나 json방식의 문자로 수정해서 보낸다
        success: function (response) { //성공적으로 실행시
            $('#container').removeClass('active'); //모달 창을 종료한다.
            alert('관심 가격이 설정되었습니다.');
            window.location.reload(); //창 새로고침
        }
    })
}