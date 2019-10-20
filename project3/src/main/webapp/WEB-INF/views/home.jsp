<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>db 화면에 띄우기</title>

<style type="text/css">
	   .wrap * {padding: 0;margin: 0;}
    .wrap .info {width:286px;height: 150px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
    .wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
    .info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 16px;font-weight: bold;}
    .info .close {position: absolute;top: 10px;right: 10px;color: #888;width: 17px;height: 17px;background: url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
    .info .close:hover {cursor: pointer;}
    .info .body {position: relative;	height:100%;overflow: hidden;}
    .info .desc {position: relative;margin: 13px 0 0 90px;height: 75px;}
    .desc .ellipsis {text-overflow: ellipsis;white-space: nowrap;}
    .desc .jibun {font-size: 8px;color: #888;margin-top: -2px;}
    .info .img {position: absolute;top: 6px;left: 5px;width: 73px;height: 71px;border: 1px solid #ddd;color: #888;overflow: hidden;}
    .info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
    .info .link {color: #5085BB;}
    .info .tel {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
    .info .foodtype {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
    .map_wrap, .map_wrap * {margin:0;padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
.map_wrap a, .map_wrap a:hover, .map_wrap a:active{color:#000;text-decoration: none;}
.map_wrap {position:relative;width:100%;height:500px;}
#menu_wrap {position:absolute;top:0;left:0;bottom:0;width:250px;margin:10px 0 30px 10px;padding:5px;overflow-y:auto;background:rgba(255, 255, 255, 0.7);z-index: 1;font-size:12px;border-radius: 10px;}
.bg_white {background:#fff;}
#menu_wrap hr {display: block; height: 1px;border: 0; border-top: 2px solid #5F5F5F;margin:3px 0;}
#menu_wrap .option{text-align: center;}
#menu_wrap .option p {margin:10px 0;}  
#menu_wrap .option button {margin-left:5px;}
	</style>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>


<!-- 맴크기 수정 -->
<!-- 순서그대로 -->
<div id="map" style="width:100%; height:350px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b379df0a9db6630ff914150b18f5d67f&libraries=services"></script>
	<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b379df0a9db6630ff914150b18f5d67f"></script>
<script>




var mapContainer = document.getElementById('map'), // 지도를 표시할 div 

mapOption = {
		/* 중심 좌표 안고쳐도됨*/
    center: new kakao.maps.LatLng(33,50), // 지도의 중심좌표
		

    level: 6, // 지도의 확대 레벨
    mapTypeId : kakao.maps.MapTypeId.ROADMAP // 지도종류
}; 

//지도를 생성한다 
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 지형도 타일 이미지 추가
map.addOverlayMapTypeId(kakao.maps.MapTypeId.TERRAIN); 

// 지도 타입 변경 컨트롤을 생성한다
var mapTypeControl = new kakao.maps.MapTypeControl();


// 지도의 상단 우측에 지도 타입 변경 컨트롤을 추가한다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);	
//지도에 확대 축소 컨트롤을 생성한다
var zoomControl = new kakao.maps.ZoomControl();

// 지도의 우측에 확대 축소 컨트롤을 추가한다
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

var geocoder = new kakao.maps.services.Geocoder();
var listData = [
    

	'서울특별시 종로구 돈의동  28번지',
	
	'서울특별시 강남구 대치동 1005-4',
	'서울특별시 회기동 54-26',
	
]; //위치 db

listData.forEach(function(addr, index) {
	
	
	
    geocoder.addressSearch(addr, function(result, status) {
    	
    	 // 정상적으로 검색이 완료됐으면 
        if (status === kakao.maps.services.Status.OK) {
          
        	var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
         
            // 결과값으로 받은 위치를 마커로 표시합니다
            var marker = new kakao.maps.Marker({
                map: map,
                position: coords
            });
            

            
            
            var infowindow = new kakao.maps.InfoWindow({
            	
            	
            	
                content : '<div class="wrap">' + 
                '    <div class="info">' + 
                '        <div class="title">' + //음식점 이름(db)
                '            음식점 이름(db)' + 
                '            <div class="close"  title="닫기"></div>' + 
                '        </div>' + 
                '        <div class="body">' + 
                '            <div class="img">' +
                '                <img src="http://cfile181.uf.daum.net/image/250649365602043421936D" width="73" height="70">' +//음식점 사진(db)
                '           </div>' + 
                '            <div class="desc">' + 
                	'<div class="ellipsis" style="width:130px;height:20px;text-align:center;padding:6px 0;font-size:11px">' + listData[index] + '</div>'+ //listData[index]:위치db(geocoder로 주소에서 좌표로 변환)
                	
                '                <div class="jibun ellipsis">(지번) db동 909호 99층(우)db000</div>' + //우편번호(선택)동,지번 db 받기
                '				  <div class="tel">db0-전화번호-dbdb</div>' +
                '				  <div class="foodtype">한식</div>'+//음식종류(db)
                // '               <div><a href="http://www.dbfoodhomepage.com/main" target="_blank" class="link">db홈페이지</a></div>' + //음식점 홈페이지 db로 받기(선택)
                '            </div>' + 
                '        </div>' + 
                '    </div>' +    
                '</div>'// 인포윈도우에 표시할 내용
    
                
            });
            
            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
    		map.setCenter(coords);
            
    		// 마커에 클릭 이벤트를 등록한다 (우클릭 : rightclick)
    		kakao.maps.event.addListener(marker, 'click', function() {
    		 //   alert('마커를 클릭했습니다!');
    		    infowindow.open(map, marker);
    		    
    		    
    		    $(function(){
    		    	$('.close').click(function(){
    		    		//console.log("click");
    		    		infowindow.close();
    		     	});
    		     });
    		});
    		
    		
    		
            
        } 
    });
});


</script>
</body>
</html>