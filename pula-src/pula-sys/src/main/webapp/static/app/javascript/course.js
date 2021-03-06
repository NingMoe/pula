var PPage = new Class({
		Extends: PBasePage,
		initialize: function (configs) {			
			this.initVars(configs);
			this.init();
		},
	
		init : function(){
			this.initBase({focusField:'course.no'});
			this.initToolBar(false);
			this.initSaveForm();
			this.initSearchForm();
			this.initViewTable();
			this.initHistory();

			
			this.showCondition();
			

			loadCalCss('.dateField');

			var $this = this;

			
			var obj = new TSelectLoader( {'leader':'ccategoryId','fireChangeAfterLoad':true,
					'uri':pageVars.base+'/app/syscategory/underById',
					'params':function(v){
						return "id="+v;
					}}
			);

			var obj = new TSelectLoader( {'leader':'categoryId','fireChangeAfterLoad':true,
					'uri':pageVars.base+'/app/syscategory/underById',
					'params':function(v){
						return "id="+v;
					},'defaultValue' : function(){
						return pageVars.subCategoryId;
					}}
			);

			this.reload();

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
					this.navigateHistory("id", ''+data.id);
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
					{label:lang.no,width:200,key:'no'},
					{label:lang.name,key:'name'},
					{label:lang.categoryName,width:140,key:'categoryName'},
					{label:lang.subCategoryName,width:140,key:'subCategoryName'},
					{label:lang.publishTime,width:120,key:'publishTime',formatter:TTable.formatDate},
					{label:lang.expiredTime,width:120,key:'expiredTime',formatter:TTable.formatDate},
					{label:lang.showInWeb,width:120,key:'showInWeb',formatter:TTable.formatBoolean,align:'center'},
					{label:lang.indexNo,width:100,key:'indexNo',align:'center'},
					{label:lang.status,width:40,key:'enabled',formatter:TTable.formatEnabled}
				]
			};

			if(PGlobals.smallScreen()){
				cfgs.selectRow = null ;
				cfgs.intoRow = onSelectRow.bind(this) ;
			}

			this.dt = new TTable(cfgs);		
			
			this.dt.draw();
			
		},
		
		

		showData:function (d){

			$('addForm').reset();
			if(d==null){
				this.vars.action='_create';
				this.updateMode();
			}else{

				PA.ajax.gf('get','id='+d.id,function(ed){
					if(ed.error){
						alert(ed.message);
						return false;
					}
					var data =ed.data; 

					var data =ed.data; 
					for( var k in data ) {
						if($('course.'+k)){
							$('course.'+k).value = PA.utils.defaultStr(data[k]);
						}
					}

					if( data.expiredTime) {
						$('course.expiredTimeText').value = new Date( data.expiredTime).format('yyyy-MM-dd');
					}
					if( data.publishTime) {
						$('course.publishTimeText').value = new Date( data.publishTime).format('yyyy-MM-dd');
					}
					if(data.categoryId){
						$('categoryId').value = data.categoryId;
					}
					if(data.subCategoryId){
						pageVars.subCategoryId = data.subCategoryId;
					}

					$('categoryId').fireEvent('change');
					
					
					$('course.showInWebChk').set('checked',data.showInWeb);

					this.showInput(true);
					this.vars.action='_update';
					pageVars.id  = d.id;
					this.updateMode();
					
				}.bind(this));
			}

			
		}
		
		
});

var WORKER_TPL = "<a href='javascript:pes.eraseWorker(\"{no}\")'>{no} {name}<input type='hidden' name='course.courseNos' value='{no}'/></a>";
var pes = null ;
window.addEvent('domready',function(){
	pes = new PPage({"id":"pes","pageMode":"pageMode","searchForm":"searchForm","addForm":"addForm"});
	//pes.mockCheck();
	//alert('final:'+$("conditionDiv").className);
});


