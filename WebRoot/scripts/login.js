$(function(){
	//出现乱码问题，只能把前台的汉字转换一下传到后台
	$("#login").click(function(){
		var role=$("option:selected").val().trim();//获取被选中的option的值--
		if(role!="管理员" &&  role!="学生"  &&  role!="老师"){
			alert("请选择角色");
			return;
		}
		//alert(role);
		//清除原有提示信息
		$("#count_span").html("");
		$("#password_span").html("");
		//获取请求提交数据
		var name = $("#name").val().trim();
		var password = $("#pwd").val().trim();
		//检测数据格式
		var ok = true;//表单是否通过检测
		if(name==""){
			ok = false;
			/*弹出式提示*/
			$("#count_span").html("用户名不能为空");
			return;
		}
		if(password==""){
			ok = false;
			$("#password_span").html("密码不能为空");
		}
		//通过检测发送AJAX请求
		if(ok){
			$.ajax({
				url:"http://localhost:8080/laboratory/user/login.do",
				type:"post",
				data:{"username":name,"password":password,"role":role},
				dataType:"json",
				success:function(result){
					//成功处理
					//alert("测试");
					if(result.status==0){//成功
						//将返回的用户ID写入Cookie
						var  userID = result.data;//用户ID
						//document.cookie="userName=123123";
						alert(userID);
						addCookie("userID",userID,2);//写入,2小时有效
							alert("ceshi");
					    
						//权限管理
						if(role=="管理员"){
							//alert("是管理员");
								window.location.href="index.html";
						}else if(role=="学生"){
							window.location.href=".html";
						}else if(role=="老师"){
							window.location.href=".html";
						}
						//
					}else if(result.status==1){//用户名错误
						$("#count_span").html(result.msg);
					}else if(result.status==2){//密码错误
						$("#password_span").html(result.msg);
					}
				},
				error:function(){
					//异常处理
					alert("登录异常");
				}
			});
		}
	});
});