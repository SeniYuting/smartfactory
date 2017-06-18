$(function() {

	$("#save").click(function(e) {
		var name = $("input[name='name']").val();
		var type = $("select[name='type']").val();
		var tupleNum = $("input[name='tupleNum']").val();
		var frequency = $("input[name='frequency']").val();
		var source = $("textarea[name='source']").val();
		var sql = $("textarea[name='sql']").val();
		console.log(name, type, tupleNum, frequency, source, sql);
		
		if(name != "" && type != "" && tupleNum != ""
			&& frequency != "" && source != "" && sql != "" 
				&& name != "null" && type != "null" && tupleNum != "null"
					&& frequency != "null" && source != "null" && sql != "null") {
			
			var oldName = $("input[name='name']").attr("data-old");
			// 检查重名
			var nameList = document.getElementsByName("source_item");
			
			for(var i=0; i < nameList.length; i++) {
                if(name!=oldName && nameList[i].innerHTML == name){
                	$("#alert").html("name重名！");
					return;
				}
			}
				
			// Add 或   Edit
			var dataset = e.currentTarget.dataset;
			var id = dataset.id;
			var path = dataset.path;

			if (id != "") { // Edit
				jQuery.ajax({
					url : "UpdateSourceDataServlet",
					processData : true,
					dataType : "text",
					data : {
						id : id,
						name : name,
						type : type,
						tupleNum : tupleNum,
						frequency : frequency,
						source : source,
						sql : sql								
					},
					success : function(data) {
						bootbox.alert({
							message : "修改成功",
							callback : function() {
								location.reload();
							}
						});
					}
				});
			} else { // Add
				jQuery.ajax({
					url : "AddSourceDataServlet",
					processData : true,
					dataType : "text",
					data : {
						name : name,
						type : type,
						tupleNum : tupleNum,
						frequency : frequency,
						source : source,
						sql : sql								
					},
					success : function(data) {
						console.log(id);
						bootbox.alert({
							message : "添加成功",
							callback : function() {
								location.reload();
							}
						});
					}
				})
			}
			
			$("#modal").modal("hide");
			
		} else {
			$("#alert").html("存在空值或null！");
		}
		
	});

	$(".delete").click(function(e) {
		
		bootbox.confirm({
			buttons: {
				confirm: {
					label: "删除"
				},
				cancel: {
					label: "取消"
				}
			},
			message: "确认删除？",
			callback: function(result) {
				if(result) {
					
					var dataset = e.currentTarget.dataset;
					var id = dataset.id;
					jQuery.ajax({
						url : "DeleteSourceDataServlet",
						processData : true,
						dataType : "text",
						data : {
							id : id
						},
						success : function(data) {
							console.log(id);
							bootbox.alert({ 
					            message: "删除成功",  
					            callback: function() {
					                location.reload();
					            } 
					        });
						}
					});	
				} 
			}	
		});
	});

	$("#add").click(function(e) {
		$("#modalTitle").html("添加");

		// 模态框值填充，默认为空
		$("input[name='name']").attr("data-old", "");
		
		$("input[name='name']").val("");
		$("select[name='type']").val("single");
		$("input[name='tupleNum']").val("");
		$("input[name='frequency']").val("");
		$("textarea[name='source']").val("");
		$("textarea[name='sql']").val("");

		$("#save").attr("data-id", "");
		$("#alert").html("");
		$("#modal").modal("show");
	});

	$(".edit").click(function(e) {
		$("#modalTitle").html("编辑");
		var dataset = e.currentTarget.dataset;

		// 模态框值填充
		$("input[name='name']").attr("data-old", dataset.name);
		
		$("input[name='name']").val(dataset.name);
		$("select[name='type']").val(dataset.type);
		$("input[name='tupleNum']").val(dataset.tuplenum);
		$("input[name='frequency']").val(dataset.frequency);
		$("textarea[name='source']").val(dataset.source);
		$("textarea[name='sql']").val(dataset.sql);
		
		$("#save").attr("data-id", dataset.id);
		$("#alert").html("");
		$("#modal").modal("show");
	});

});
