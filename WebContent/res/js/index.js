jQuery(function($){
	$("body").on("click","a.ajax-link",function(evt){
		evt.preventDefault();
		$("#main").load($(this).attr("href"));
	});
	
	$("body").on("submit","form.ajax-form",function(evt){
		evt.preventDefault();
		var form = $(this);
		$.post(form.attr("action"),form.serialize(),function(data){
			if(data.success){
				alert(data.msg);
				$("#main").load(form.attr("okUrl"));
			}else{
				alert(data.msg);
			}
			
		});
	});
	$("body").on("click","a.ajax-link-delete",function(evt){
		evt.preventDefault();
		if(confirm("确定要删除吗？")){
			$("#main").load($(this).attr("href"));
		}
	});
});