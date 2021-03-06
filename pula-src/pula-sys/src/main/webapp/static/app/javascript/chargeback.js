var PPage = new Class({
		Extends: PBasePage,
		initialize: function (configs) {			
			this.initVars(configs);
			this.init();
		},
	
		init : function(){
			this.initBase({focusField:'student.no'});
			this.initToolBar({remove:true,condition:true});
			this.initSearchForm();
			this.initViewTable();
			this.initHistory();

			
			this.showCondition();
			this.reload();
			

			var $this = this ;

			loadCalCss(".dateField");

			this.edtStudent = new TSimpleNo({
				field:'condition.studentNo',
				field_id:'cStudentNo',
				text:'',
				value:'',
				showTips:true,
				tips:lang.tipsOfTSN,
				url:'../student/find',
				container:'sStudent'
			});	

			
			this.edtSalesman = new TSimpleNo({
				field:'form.salesmanNo',
				field_id:'cSalesmanNo',
				text:'',
				value:'',
				showTips:true,
				tips:lang.tipsOfTSN,
				url:'../salesman/find',
				container:'sSalesman'
			});	

			this.teacherNo = new TSimpleNo({
				field:'form.teacherNo',
				field_id:'cTeacherNo',
				text:'',
				value:'',
				showTips:true,
				tips:lang.tipsOfTSN,
				url:'../teacher/find',
				container:'sTeacher'
			});	
			//c();
		},//init ends
		initViewTable : function(){
			var getRequestParam = function(){
				return this.vars.requestParam;
			}
			var onSelectRow = function(i,tr){
				if(i==-1){
					this.navigateHistory("id", 'create');
				}else{
					var data = this.dt.rows[i] ;
					//this.showData(data);
					//this.navigateHistory("id", ''+data.id);
					if( data.status == pageConsts.S_INPUT){ //input
						this.updatePage(data.id);
					}else{
						this.view(data.id);
					}
				}
			}
			var cfgs = {
				id :'dt',
				container:'dt',
				height:PGlobals.minusHeight.bind(['conditionDiv','__top']),
				url:"list",
				requestParam:getRequestParam.bind(this),
				selectRow:onSelectRow.bind(this),
				columns: [
					{label:TTable.checkAll,width:24,key:'id',formatter:TTable.formatCheckbox},
					{label:'订单号',width:100,key:'no',align:'center'},
					{label:lang.branchName,width:180,key:'branchName'},			
					{label:'学员',width:80,key:'studentName'},		
					{label:'课程产品',key:'courseProductName'},		
					{label:'价格',key:'totalAmount',width:40},		
					{label:'退课数',key:'backCourses',width:40},		
					{label:'退额',key:'backAmount',width:40},		
					{label:'佣金类型',width:70,key:'commissionTypeName',align:'center'},
					{label:'主销售',width:100,key:'masterName'},
					{label:'辅销售',width:100,key:'slaveName'},
					{label:'状态',width:60,key:'statusName',align:'center'},
					{label:'填写人',width:90,key:'creatorName'},
					{label:'填写日期',width:100,key:'createdTime',formatter:TTable.formatDate},
					{label:lang.view,width:40,key:'id',formatter:TTable.formatLinkJs.bind({func:'pes.view',label:lang.view}),align:'center'}
				]
			};

			if(PGlobals.smallScreen()){
				cfgs.selectRow = null ;
				cfgs.intoRow = onSelectRow.bind(this) ;
			}

			this.dt = new TTable(cfgs);		
			
			this.dt.draw();
			
		},
		
	disableBtn:function (b){
		$('submitBtn').disabled = b; 
	},
	
	createPage : function(b){
		
        var url = encodeURIComponent('../chargeback/create');
        centerWindow('../my/window?u=' + url,850, 380);
	},
	updatePage : function(id ){
		var url = encodeURIComponent('../chargeback/update?id='+id);
		        centerWindow('../my/window?u=' + url,850, 400);
	},view : function(id ){
		var url = encodeURIComponent('../chargeback/view?id='+id);
		        centerWindow('../my/window?u=' + url,950, 400);
	},

		showData:function (d){

			

			
		},updateMode:function(){}
		
		
});

var pes = null ;
window.addEvent('domready',function(){
	pes = new PPage({"id":"pes","pageMode":"pageMode","searchForm":"searchForm","addForm":"addForm"});
});

var reloadData = function (){
	pes.reload();
}
