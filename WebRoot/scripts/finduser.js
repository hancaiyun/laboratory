/** 模糊查询用户  **/
	function search(){
		var un=$("#findByUname").val().trim();
		$.ajax({
			url:"http://localhost:8080/laboratory/user/findUser.do",
			type:"post",
			data:{"userName":un},
			dataType:"json",
			success:function(result){
				//成功处理
				//alert("测试");
				if(result.status==0){//成功
				//清除原有user列表
			    $("#user_info_t").empty();  
			    var users=result.data;
			    //循环信息生成
			    for(var i=0;i<users.length;i++){
				var userId = users[i].user_id;
				var userName = users[i].user_name;
				var gender=users[i].gender;
				var position=users[i].position;
				var tel=users[i].tel;
				//拼成
				createUserLi(userId,userName,gender,position,tel);	
			}  
				} 
			},
			error:function(){
				//异常处理
				alert("查询用户信息失败");
			}
		});	
	}
	function createUserLi(userId,userName,gender,position,tel){	
		var str="<tr>";
		str+="<td>";
		str+="<input type='checkbox' name='IDCheck' value='14458579642011' class='acb' />";
		str+="</td>";
		str+="<td>"+userId+"</td>";
		str+="<td>"+userName+"</td>";
		str+="<td>"+gender+"</td>";
		str+="<td>"+position+"</td>";
		str+="<td>"+tel+"</td>";
		str+="<td>";
		str+="<a href='house_edit.html?fyID=14458579642011' class='edit'>编辑</a> "; 
		str+="<a href='javascript:del('14458579642011');'>删除</a>";
		str+="</td>";
		str+="</tr>";
		var $tr=$(str);
		$("#user_info_t").append($tr);
	}