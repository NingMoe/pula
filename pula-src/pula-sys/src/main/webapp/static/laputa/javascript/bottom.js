
 //** iframe�Զ���Ӧҳ�� **//

 //������ϣ������ҳ��߶��Զ������߶ȵ�iframe�����Ƶ��б�
 //�ö��Ű�ÿ��iframe��ID�ָ�. ����: ["myframe1", "myframe2"]������ֻ��һ�����壬���ö��š�

 //����iframe��ID
	//parent.document.all("contentFrame").style.height=document.body.scrollHeight;

	
	function hideMenu(){
		var oMenuBar = parent.oMenuBar;
		oMenuBar.hasFocus = false;
		
		if(oMenuBar.activeItem) {

			var oSubmenu = oMenuBar.activeItem.cfg.getProperty("submenu");
			if(oSubmenu) {
			
				oSubmenu.hide();
			
			}
			oMenuBar.clearActiveItem();
			oMenuBar.activeItem.blur();
		
		}
		
	}

	function onResizeMe(){
		//alert('hi');
	}

	function onDocumentClick(p_oEvent) {
					var oMenuBar = parent.oMenuBar;
					if( typeof(oMenuBar)  == 'undefined') { return ;}
                    var oTarget = YAHOO.util.Event.getTarget(p_oEvent);
                    if(
                        oTarget != oMenuBar.element && 
                        !YAHOO.util.Dom.isAncestor(oMenuBar.element, oTarget)
                    ) {
        
                        //oMenuBar.hasFocus = false;
                        
                        if(oMenuBar.activeItem) {
							//alert('hi');
                            var oSubmenu = oMenuBar.activeItem.cfg.getProperty("submenu");
                            if(oSubmenu) {
                            
                                oSubmenu.hide();
                            
                            }
                            oMenuBar.clearActiveItem();
                            //oMenuBar.activeItem.blur();
                        
                        }
                    
                    }
                }

                // Add a "click" handler for the document
                YAHOO.util.Event.addListener(
                        document, 
                        "click", 
                        onDocumentClick
                    );

					//hideMenu();

				//Ext.onReady(onResizeMe);

	function makeTitle(){
		//alert(parent.oTitleLine.innerHTML);
		if($defined($('pageTitle'))){
			parent.oTitleLine.innerHTML = $('pageTitle').innerHTML;
		}

	}

				//window.addEvent('domready', onResizeMe);
				//window.addEvent('domready', makeTitle);
