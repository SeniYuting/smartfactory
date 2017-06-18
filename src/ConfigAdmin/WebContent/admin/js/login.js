$(function() {
	
    $("#login").click(function(){
        var email = $("input[name='email']").val();
        var password = $("input[name='password']").val();
        console.log(email, password);
        
        if(email != "" && password != "") {
        	
        	jQuery.ajax({
        		url : '/ConfigAdmin/LoginServlet',
        		processData : true,
    			dataType : "text",
    			data : {
    				email : email,
    				password : password							
    			},
    			success : function(data) {
    				if(data=="success") {
    					window.location = "/ConfigAdmin/SourceDataServlet";
    				} else {
    					bootbox.alert("用户名或密码错误！");
    				}
    			}
    		});
        	
        } else {
        	bootbox.alert("用户名或密码不能为空！");
        }
       
    });

});

