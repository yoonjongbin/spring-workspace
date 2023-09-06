<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>휴대전화 목록</h1>

	<table border="1">

		<thead>

			<tr>

				<th>모델번호</th>
				<th>모델이름</th>
				<th>가격</th>
				<th>제조사명</th>

			</tr>

		</thead>

		<tbody id="list">
		</tbody>


	</table>


	<h1>휴대전화 정보</h1>

	<form action="phoneFrm" method="post">

		모델번호 : <input type="text" name="num" id="num"/> <br> 
		모델명 :<input type="text" name="model" id="model"/> <br> 
		가격 : <input type="text" name="price" id="price"/> <br> 
		제조사 : <select id="vcode" name="vcode" id="vcode">
			<option value="10">삼성</option>
			<option value="20">애플</option>
		</select> 
		<br> 
		<input type="button" value="추가하기" id="insert"/> 
		<input type="button" value="수정하기" id="update"/> 
		<input type="button" value="삭제하기" id="delete"/>

	</form>

	<script>
		
		function list(){
			$.ajax({
				type: "GET",
				url: "http://localhost:8080/api/phone",
				data: null,
				success: function(data){
					
					let html = '';
					
					for (let phone of data) {
					
						html += "<tr>" +
								"<td class='num'>" + phone.num + "</td>" +
								"<td>" + phone.model + "</td>" +
								"<td>" + phone.price + "</td>" +
								"<td>" + phone.vcode + "</td>" +
								"</tr>"
			  
					}
					$('#list').html(html);
				},
			
				error: function() {
					console.log("시스템 상 에러 발생!")
				}
			});
		}	
		
	
		//$('document').ready(list(){
			
			
			//
			
		//});
		
		list();
		
		// 상세 조회
		$('#list').on('click', '.num', function(){
			console.log($(this).text());
			
			$.ajax({
				url : 'http://localhost:8080/api/phone/' + $(this).text(),
				type : 'GET',
				success : function(data){
					console.log(data);
					
					$('#num').val(data.num);
					$('#model').val(data.model);
					$('#price').val(data.price);
					$('#vcode').val(data.vcode);
				}
			});
		});
		
		
		
		// 추가
		$('#insert').on('click', function(){
			// JSON 방식으로 전달
			console.log($(this).val());
			
			let phone = {
				    num: $('#num').val(),
				    model: $('#model').val(),
				    price: $('#price').val(),
				    vcode: $('#vcode').val()
				};
			
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/api/phone",
				data: JSON.stringify(phone),	// JSON 방식으로 변환
				contentType: 'application/json',
				success: function(){
					//console.log($('#model').val() + "기기 추가");
					//$('#list').html('');
					list();
				}
			
			});
		});
		
		
		// 수정
		$('#update').on('click', function(){
			console.log($(this).val())
			
			let phone = {
			    num: $('#num').val(),
			    model: $('#model').val(),
			    price: $('#price').val(),
			    vcode: $('#vcode').val()
			};
		
			$.ajax({
				type: "PUT",
				url: "http://localhost:8080/api/phone",
				data: JSON.stringify(phone),
				contentType: 'application/json',
				success: function(){
					//$('#list').html('');
					list();
				}
		
			});
		});
		
		
		// 삭제
		$('#delete').on('click', function(){
			console.log($(this).val())
			
		
			$.ajax({
				type: "DELETE",
				url: "http://localhost:8080/api/phone/" + $('#num').val(),
				success: function(data){
					//console.log($('#num').val() + "기기 삭제");
					
					$('#num').val("");
					$('#model').val("");
					$('#price').val("");
					$('#vcode').val("");
					
					list();
				}
		
			});
		});
		
		
		
	</script>

</body>
</html>