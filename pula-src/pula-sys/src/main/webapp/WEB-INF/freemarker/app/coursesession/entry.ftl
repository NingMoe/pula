<#import "/app/macros/commonBase.ftl" as b><@b.html title="course.title">

<style>
#workerList A:hover{
	text-decoration:line-through;
}
</style>
  <div class="top" id="__top"> </div>
<div class="body">
    <!-- condition -->
    <div id="conditionDiv" class="h forList">
	<#include "condition.ftl"/>
	 </div>


    <!-- listview -->
    <div class="l forList" id="listview">
      <form id="batchForm">
        <div id="dt"> </div>
      </form>
      <!-- left ends --> 
    </div>

	<!-- edit form -->
	<div id="inputPanel" class="l h">
	<form action="${uri}" method="post" id="addForm">
	<div class="l"><table border="0" class="grid" width="700">
	<colgroup><col style="width:100px"/>
	<col /><col style="width:100px"/>
	<col />
	</colgroup>
	  <tr class="title"> 
            <td colspan="4"><div class="l">请填写下列信息 <span id="pageMode" style="color:blue"></span></div>
              <div class="r">
              <div class="backToList " id="backToList"><A href="javascript:pes.backToList()">返回至列表</A></div></td>
	  </tr> <tr> 
		<td >编号<span class="redStar">*</span></td>
		<td ><input type="text" name="course.no" id="course.no" size="20" maxlength="40"/> </td>
	  
		<td >名称<span class="redStar">*</span></td>
		<td ><input type="text" name="course.name" id="course.name" size="20" maxlength="40"/> </td>
	  </tr> <tr> 
		<td >分类<span class="redStar">*</span></td>
		<td>
		
		<label><input type="checkbox" name="course.showInWeb" value="true" id="course.showInWeb"/> 显示在网站上 </label></td>
		<td >序号</td>
		<td ><input type="text" name="course.indexNo" id="course.indexNo" size="10" maxlength="40" class="numberEdit" value="0"/> </td>
		</tr>

	  <tr> 
		<td >发布日期</td>
		<td ><input type="text" name="course.publishTimeText" id="course.publishTimeText" size="12" maxlength="10" class="dateField"/>
		</td>
	  
		<td >失效日期</td>
		<td ><input type="text" name="course.expiredTimeText" id="course.expiredTimeText" size="12" maxlength="10" class="dateField"/></td>
	  </tr><tr> 
		<td >KEY</td>
		<td colspan="3"><input type="text" name="course.key" id="course.key" size="60" maxlength="40"/> </td>
	  </tr>
	   <tr> 
		<td >备注</td>
		<td colspan="3"><input type="text" name="course.comments" id="course.comments" size="60" maxlength="80"/> </td>
	  </tr> 
	  <tr> 
		<td colspan="4">
		<input type="submit" value="<@b.text key="submitBtn"/>" id="submitBtn"/>
		<input type="hidden" name="course.id" id="course.id"/>
		</td>
	  </tr> 
	</table>

</div>
	
	</form>
	</div>
  </div>
<!-- others -->
<#include "/calendar.ftl"/>
<link rel="stylesheet" type="text/css" href="${base}/static/app/css/t-style.css"></link>
<script type="text/javascript" src="${base}/static/library/puerta/t-table.js"></script> 
<script type="text/javascript" src="${base}/static/app/javascript/coursesession.js"></script>
<script type="text/javascript" src="${base}/static/library/mootools/modules/mbox/mt.mbox.js"></script>
<script type="text/javascript" src="${base}/static/library/puerta/t-simple-no.js"></script>
<script type="text/javascript">

var pageVars = {
	queryString:'',
	action : '_create',
	id :'',
	base :'${base}'
}

var lang = {
	name:'名称',no:'编号',domain:'授课记录',expiredTime:'失效日期',publishTime:'发布日期',showInWeb:'显示在网站上',indexNo:'序号',
	categoryName:'分类',status:'状态'
}


	function check(){
		
		if(isEmpty($F("course.no"))){
			alert("请填写编号");
			$("course.no").focus();
			return false; 
		}
		if(isEmpty($F("course.name"))){
			alert("请填写名称");
			$("course.name").focus();
			return false; 
		}
		if(isEmpty($F("course.categoryId"))){
			alert("请选择分类");
			$("course.categoryId").focus();
			return false; 
		}

		var b = true;
		var eel = null ;
		$$(".numberEdit").each ( function (el){
			var v = Number.from( el.value ) ;
			if( b && !v && v!=0  ) {
				eel = el ;
				b= false;
			}
			
		});

		if(!b){
			alert("请正确填写数值");
			eel.select();
			eel.focus();
			return false;
		}

		len = $F("course.comments").length ;
		if(len>200){
			alert("备注信息过长，请填写200字以内信息");
			$("course.comments").focus();
			return false;
		}

		var pass = true ;
		$$(".dateField").each ( function(el){
			if( !pass ) return ;
			var dv = $F( el );
			if( !isEmpty( dv ) &&  !isDate( dv )){
				alert("请正确填写日期");
				el.focus();
				pass =false; 
				return ;
			}
		});

		if(!pass ) {
			return false ;
		}
		
		return true ;
	}
</script>
</@b.html>