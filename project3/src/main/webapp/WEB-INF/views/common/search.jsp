<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function sh(){
	$("#btn_search").click(function(){
		console.log("click");
		self.location = "search" +"?keyword="+$("#keyword").val();
		});		
	});	

</script>

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
<title>4조 Spring Project</title>

  <!-- Bootstrap core CSS -->
  <link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="../resources/css/modern-business.css" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="../common/main">4조 Spring Project</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
      
        <ul class="navbar-nav ml-auto">
        
        <c:choose>
        	<c:when test="${!empty sessionScope.owner}">
        		<li class="nav-item dropdown">
        			<span class="nav-link">${sessionScope.owner.o_id } 님 환영합니다.</span>
        		</li>
        		<li class="nav-item">
            		<a class="nav-link" href="../common/logout">로그아웃</a>
          		</li>
        		<li class="nav-item">
            		<a class="nav-link" href="../ownersignup/myaccount">mypage</a>
          		</li>
          		<li class="nav-item">
            		<a class="nav-link" href="../common/login">공지사항</a>
          		</li>
        	</c:when>
        	
        	<c:when test="${!empty sessionScope.user}">
        		<li class="nav-item dropdown">
        			<span class="nav-link">${sessionScope.user.u_id } 님 환영합니다.</span>
        		</li>
        		<li class="nav-item">
            		<a class="nav-link" href="../common/logout">로그아웃</a>
          		</li>
        		<li class="nav-item">
            		<a class="nav-link" href="../usersignup/myaccount">mypage</a>
          		</li>
          		<li class="nav-item">
            		<a class="nav-link" href="../common/login">공지사항</a>
          		</li>
        	</c:when>
        
        	<c:otherwise>
        	
        		<!-- 회원가입으로 보내기 -->
	        	<li class="nav-item dropdown">
	            	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	             	회원가입
	           		</a>
	            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
	              <a class="dropdown-item" href="../usersignup/register">일반 회원가입</a>
	              <a class="dropdown-item" href="../ownersignup/register">기업 회원가입</a>
	            </div>
          		</li>
          		
          		<!-- 로그인 -->
          		<li class="nav-item">
            		<a class="nav-link" href="../common/login">로그인</a>
          		</li>
          		
          		<!-- 공지사항 -->
          		<li class="nav-item">
            		<a class="nav-link" href="../common/login">공지사항</a>
          		</li>
        	</c:otherwise>

        
        </c:choose> 
        
        </ul>
      </div>
    </div>
  </nav>
<div class="container">
	<div id="map" style="width:100%; height:350px; margin-top: 100px; margin-bottom: 60px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b379df0a9db6630ff914150b18f5d67f&libraries=services"></script>
	<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b379df0a9db6630ff914150b18f5d67f"></script>
<script>




	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	
		mapOption = {
			
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



	var listData = [];
	var listName = [];
	var listScore = [];
	var listTime = [];
	var photo =[];
	
	<c:forEach var="cvo" items="${s_list}" >
		listData.push("${cvo.c_newadd }");	
		listName.push("${cvo.c_name }");	
		listScore.push("${cvo.c_score }");
		listTime.push("${cvo.c_time }");
		photo.push("${cvo.c_photo }")
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
                			listName[index]	 + 
                '            <div class="close"  title="닫기"></div>' + 
                '        </div>' + 
                '        <div class="body">' + 
                '            <div class="img">' +
                '                <img src="'+photo[index]+'" width="73" height="70">' +//음식점 사진(db)
                '           </div>' + 
                '            <div class="desc">' + 
                	'<div class="ellipsis" style="width:130px; height:20px; text-align:center; padding:6px 0; font-size:11px"> 주소 : ' + listData[index] + '</div>'+ //listData[index]:위치db(geocoder로 주소에서 좌표로 변환)
                '				  <div class="tel"> 평점 : '+listScore[index]+ '</div>' +
                '				  <div class="foodtype">영업시간 : '+listTime[index]+ '</div>'+//음식종류(db)
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
</c:forEach>   

</script>


  <!-- Page Content -->
  <div class="card-body"  style="margin-top: 60px; margin-bottom: 60px;" >
	  <div class="input-group" align="center">
	    <input type="text" class="form-control" placeholder="맛집을 찾아보세요" id="keyword">
	    <span class="input-group-btn">
	      <button class="btn btn-secondary" type="button" id="btn_search" name="#btn_search" onclick="sh()">찾기</button>
	    </span>
	  </div>
  </div>
    <!-- Portfolio Section -->
    <h2>" ${keyword } " 의  검색 결과 </h2>
	
	
    <div class="row">
	<c:forEach var="cvo" items="${s_list }" >
      <div class="col-lg-6 col-sm-6 portfolio-item">
      <a href="/common/r_site?bnum=${cvo.bnum }" style="text-decoration: none; color:#000000;">
        <div class="card h-100">
         <img class="card-img-top" src="${cvo.c_photo }" alt=""style="width: 540px; height: 250px;">
          <div class="card-body">
            <h4 class="card-title">
              <p>${cvo.c_name }</p>
              
               <span>평점 : </span>${cvo.c_score }
            </h4>
           <p class="card-text">${com.c_contents }</p>
          </div>
        </div>
      </a>
      </div>
     </c:forEach>
      </div>
      </div>

    <!-- /.row -->


<%@ include file="../footer2.jsp" %>