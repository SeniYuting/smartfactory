$(function() {
	
	function isRuleOK(rule) {
		/**
		 * isJSONOK取值:
		 * 0: 符合要求,3种情况，允许为{}
		 * 1: 必须以{开头，以}结尾
		 * 2: 必须为JSON格式
		 * rule不为{}时
		 * 3: ruleName值必须为"sort"或"exp"
		 * 4: ruleName值为sort，key必须有order
		 * 5: order值必须为"desc"或"asc"
		 * 6: ruleName值为exp，key必须有expression
		 * 7: expression值必须为string格式
		 * 8: key值必须为string格式 
		 * 9: key中必须有ruleName和key各一次
		 * 
		 */
		var isJSONOK = 0;
	
		// 必须以{开头，以}结尾
		var indexBegin = rule.indexOf("{");
		var indexEnd = rule.indexOf("}");
		if(!(indexBegin == 0 && indexEnd == rule.length - 1)) {
			isJSONOK = 1;
		} else {
			if(rule != "{}") {
				try {  // 必须为JSON格式
					var ruleJson = JSON.parse(rule);
					var keyRuleNameNum = 0;  // key为ruleName出现的次数
					var keyKeyNum = 0;  // key为key出现的次数
					
					for (var key in ruleJson) {
						if(key == "ruleName") {
							keyRuleNameNum ++;
							
							// ruleName值必须为"sort"或"exp"
							if(ruleJson[key] != "sort" && ruleJson[key] != "exp") { 
								isJSONOK = 3;
								return isJSONOK;  // 直接返回
							} else if(ruleJson[key] == "sort") {
	
								if(!("order" in ruleJson)) { // ruleName值为sort，key必须有order 
									isJSONOK = 4;
									return isJSONOK;  // 直接返回
								} else {  // order值必须为"desc"或"asc"
									if(ruleJson["order"] != "desc" && ruleJson["order"] != "asc") {
										isJSONOK = 5;
										return isJSONOK;  // 直接返回
									}	
								}
								
							} else if(ruleJson[key] == "exp") {
								
								if(!("expression" in ruleJson)) { // ruleName值为exp，key必须有expression 
									isJSONOK = 6;
									return isJSONOK;  // 直接返回
								} else {	
									if(typeof(ruleJson["expression"]) != "string") {  // expression值必须为string格式
										isJSONOK = 7;
										return isJSONOK;  // 直接返回
									}	
								}
								
							}
							
						}
						
						if(key == "key") {
							keyKeyNum ++;
							
							// key值必须为string格式
							if(typeof(ruleJson[key]) != "string") { 
								isJSONOK = 8;
								return isJSONOK;  // 直接返回
							}
						}
					}
					
					// key中必须有ruleName和key各一次
					if(keyRuleNameNum != 1 || keyKeyNum != 1) {
						isJSONOK = 9;
					}
					
				}catch (err) {
					isJSONOK = 2;
				}
			}
		}
		
		return isJSONOK;
	}
	
	function isDataSourceListOK(dataSourceList) {
		/**
		 * isJSONOK取值:
		 * 0: 符合要求
		 * 1: 必须以[开头，以]结尾且非[]
		 * 2: 必须为JSON格式
		 * 3: key必须为name或frequency
		 * 4: name后的value必须是string
		 * 5: frequency后的value必须是数字
		 * 6: JSON中存在没有key的单值
		 * 7: key中name和frequency必须成对出现
		 * 
		 */
		var isJSONOK = 0;
	
		// 必须以[开头，以]结尾
		var indexBegin = dataSourceList.indexOf("[");
		var indexEnd = dataSourceList.indexOf("]");
		
		if (!(indexBegin == 0 && indexEnd == dataSourceList.length - 1) || dataSourceList.replace(/[ ]/g, "") == "[]") {
			isJSONOK = 1;
		} else {
			try {  // 必须为JSON格式
				
				var dataSourceList_array_json = JSON.parse(dataSourceList);

				// 遍历dataSourceList_array_json数组
				$.each(dataSourceList_array_json, function (i, dataSourceList_json) {
				
					var length = 0; // 判断是否进入for循环，处理：JSON中存在没有key的单值的情况，如：[1]
					var keyNameNum = 0; // key为name出现的次数
					var keyFrequencyNum = 0; // key为frequency出现的次数
					
					for (var key in dataSourceList_json) {
						length ++;   
						// key必须为name或frequency
						if(key!="name" && key !="frequency") {
							isJSONOK = 3; 
							return isJSONOK;  // 直接返回
						} 
			        
						if(key == "name") {
							keyNameNum ++;
							
							// name后的value必须是string
							if(typeof(dataSourceList_json[key]) != "string") { 
								isJSONOK = 4;
								return isJSONOK;  // 直接返回
							}
						}
			        
						if(key == "frequency") {
							keyFrequencyNum ++;
			        	
							// frequency后的value必须是数字
							if(typeof(dataSourceList_json[key]) != "number") { 
								isJSONOK = 5;
								return isJSONOK;  // 直接返回
							}
						}
					}	
				
					// 没有进入循环
					if(length == 0) {
						isJSONOK = 6;
						return; // 跳出each循环
					}
				
					// 判断name和frequency是否成对出现
					if(keyNameNum != 1 || keyFrequencyNum != 1) {
						isJSONOK = 7;
						return;  // 跳出each循环
					}
				
				});
			
			}catch (err) {
				isJSONOK = 2;
			}
		}
		
		return isJSONOK;
	}

	$("#save").click(function(e) {
		var name = $("input[name='name']").val();
		var type = $("select[name='type']").val();
		var tupleNum = $("input[name='tupleNum']").val();
		var frequency = $("input[name='frequency']").val();
		var rule = $("textarea[name='rule']").val();
		var dataSourceList = $("textarea[name='dataSourceList']").val();
		console.log(name, type, tupleNum, frequency, rule, dataSourceList);

	    if (name != "" && type != "" && tupleNum != "" 
			&& frequency != "" && rule != "" && dataSourceList != ""
				&& name != "null" && type != "null" && tupleNum != "null" 
					&& frequency != "null" && rule != "null" && dataSourceList != "null") {
			
			var oldName = $("input[name='name']").attr("data-old");
			// 检查重名
			var nameList = document.getElementsByName("goal_item");
				
			for(var i=0; i < nameList.length; i++) {
	            if(name!=oldName && nameList[i].innerHTML == name){
	               	$("#alert").html("name重名！");
					return;
				}
			}

	    	// rule格式检查
	    	var isRuleOKResult = isRuleOK(rule);
			// dataSourceList格式检查
	    	var isDataSourceListOKResult = isDataSourceListOK(dataSourceList);
	    	
	    	if(isRuleOKResult == 0 && isDataSourceListOKResult == 0) {  // 检查合格，格式正确
	    		
	    		// 处理重复key插入
	    		// 如dataSourceList：[{"name":"","frequency":60,"name":""}]，这种情况取最后一个的value
	    		rule = JSON.stringify(JSON.parse(rule));
	    		dataSourceList = JSON.stringify(JSON.parse(dataSourceList));
	    		
	    		// Add或Edit
	    		var dataset = e.currentTarget.dataset;
				var id = dataset.id;
				var path = dataset.path;

				if (id != "") { // Edit
					jQuery.ajax({
						url : 'UpdateGoalDataServlet',
						processData : true,
						dataType : "text",
						data : {
							id : id,
							name : name,
							type : type,
							tupleNum : tupleNum,
							frequency : frequency,
							rule : rule,
							dataSourceList : dataSourceList								
						},
						success : function(data) {
							console.log(id);
							bootbox.alert({
								message : '修改成功',
								callback : function() {
									location.reload();
								}
							});
						}
					});
				} else { // Add
					jQuery.ajax({
						url : 'AddGoalDataServlet',
						processData : true,
						dataType : "text",
						data : {
							name : name,
							type : type,
							tupleNum : tupleNum,
							frequency : frequency,
							rule : rule,
							dataSourceList : dataSourceList								
						},
						success : function(data) {
							console.log(id);
							bootbox.alert({
								message : '添加成功',
								callback : function() {
									location.reload();
								}
							});
						}
					})
				}

				$('#modal').modal('hide');
	    		
				return true;
	    	}
	    	
	    	// 格式有误，alert
	    	if(isRuleOKResult != 0) { // rule格式有误
	    		
	    		switch(isRuleOKResult) {
	    		case 1:
	    			$("#alert").html("rule必须以{开头，以}结尾！"); break;	    		
	    		case 2:
	    			$("#alert").html("rule必须为JSON格式！"); break;
	    		case 3:
	    			$("#alert").html("rule中ruleName值必须为sort或exp！"); break;	    		
	    		case 4:
	    			$("#alert").html("rule中ruleName值为sort，key必须有order！"); break;
	    		case 5:
	    			$("#alert").html("rule中order值必须为desc或asc！"); break;	    		
	    		case 6:
	    			$("#alert").html("rule中ruleName值为exp，key必须有expression！"); break;
	    		case 7:
	    			$("#alert").html("rule中expression值必须为string格式！"); break;	 
	    		case 8:
	    			$("#alert").html("rule中key值必须为string格式！"); break;
	    		case 9:
	    			$("#alert").html("rule中key必须有ruleName和key各一次！"); break;
	    		default:
	    			$("#alert").html("rule格式不正确！");
	    		}
	    		
	    	} else {  // rule格式正确，dataSourceList格式有误
	    		
	    		switch(isDataSourceListOKResult){
		    	case 1:
		    		$("#alert").html("dataSourceList必须以[开头，以]结尾且非[]！"); break; 		
		    	case 2:
		    		$("#alert").html("dataSourceList必须为JSON格式！"); break;	
		    	case 3:
		    		$("#alert").html("dataSourceList的key必须为name或frequency！"); break;		
		    	case 4:  		
		    		$("#alert").html("dataSourceList中name后的value必须是string！"); break;
		    	case 5:
		    		$("#alert").html("dataSourceList中frequency后的value必须是数字！"); break;		
		    	case 6:
		    		$("#alert").html("dataSourceList的JSON中存在没有key的单值！"); break; 		
		    	case 7:
		    		$("#alert").html("dataSourceList的key中name和frequency必须成对出现！"); break;	    		
		    	default:
		    		$("#alert").html("dataSourceList格式不正确！");
		    	}
	    		
	    	}   	
	    	
		} else {
			$("#alert").html("存在空值或null！");
		}
	});

	$(".delete").click(function(e) {
		
		bootbox.confirm({
			buttons: {
				confirm: {
					label: '删除'
				},
				cancel: {
					label: '取消'
				}
			},
			message: '确认删除？',
			callback: function(result) {
				if(result) {
		
					var dataset = e.currentTarget.dataset;
					var id = dataset.id;
					jQuery.ajax({
						url : 'DeleteGoalDataServlet',
						processData : true,
						dataType : "text",
						data : {
							id : id
						},
						success : function(data) {
							console.log(id);
							bootbox.alert({
								message : '删除成功',
								callback : function() {
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
		$('#modalTitle').html("添加");

		// 模态框值填充，默认为空
		$("input[name='name']").attr("data-old", "");
		
		$("input[name='name']").val("");
		$("select[name='type']").val("single");
		$("input[name='tupleNum']").val("");
		$("input[name='frequency']").val("");
		$("textarea[name='rule']").val("");
		$("textarea[name='dataSourceList']").val("");

		$("#save").attr("data-id", "");
		$("#alert").html("");
		$('#modal').modal('show');
	});

	$(".edit").click(function(e) {
		$('#modalTitle').html("编辑");
		var dataset = e.currentTarget.dataset;

		// 模态框值填充
		$("input[name='name']").attr("data-old", dataset.name);
		
		$("input[name='name']").val(dataset.name);
		$("select[name='type']").val(dataset.type);
		$("input[name='tupleNum']").val(dataset.tuplenum);
		$("input[name='frequency']").val(dataset.frequency);
		$("textarea[name='rule']").val(dataset.rule);
		$("textarea[name='dataSourceList']").val(dataset.datasourcelist);

		$("#save").attr("data-id", dataset.id);
		$("#alert").html("");
		$('#modal').modal('show');
	});
});