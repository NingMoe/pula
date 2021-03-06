/****** Script for SelectTopNRows command from SSMS  ******/
SELECT *
  FROM [pula_sys].[dbo].[purview] where module = 'c78cd590-7090-433b-9551-066798301a10'


insert into [pula_sys].[dbo].[purview](
id,menuItem,defaultURL,parentPurview,level,name,module,visible,appField,treePath,removed,leaf,indexNo,no)
values
(
'5f751d10-24e8-4c9a-be9b-4beaed185d1f',1, 'timecourse/entry',NULL,0,'次课查询', 
'c78cd590-7090-433b-9551-066798301a10', 1, 'bd5cab3d-453f-4bf2-ad21-47dce6dfbc68', 'M070-P010',0,1,10,'P_TIME_COURSE'
)


insert into [pula_sys].[dbo].[purview](
id,menuItem,defaultURL,parentPurview,level,name,module,visible,appField,treePath,removed,leaf,indexNo,no)
values
(
'5f751d11-24e8-4c9a-be9b-4beaed185d1f',1, 'timecourseorder/entry',NULL,0,'次课订单查询', 
'c78cd590-7090-433b-9551-066798301a10', 1, 'bd5cab3d-453f-4bf2-ad21-47dce6dfbc68', 'M070-P010',0,1,10,'P_TIME_COURSE_ORDER'
)

insert into [pula_sys].[dbo].[purview](
id,menuItem,defaultURL,parentPurview,level,name,module,visible,appField,treePath,removed,leaf,indexNo,no)
values
(
'5f751d12-24e8-4c9a-be9b-4beaed185d1f',1, 'notice/entry',NULL,0,'次课活动查询', 
'c78cd590-7090-433b-9551-066798301a10', 1, 'bd5cab3d-453f-4bf2-ad21-47dce6dfbc68', 'M070-P010',0,1,10,'P_TIME_COURSE_NOTICE'
)
-- delete from [pula_sys].[dbo].[purview] where id='5f751d12-24e8-4c9a-be9b-4beaed185d1f'

insert into [pula_sys].[dbo].[purview](
id,menuItem,defaultURL,parentPurview,level,name,module,visible,appField,treePath,removed,leaf,indexNo,no)
values
(
'5f751d13-24e8-4c9a-be9b-4beaed185d1f',1, 'timecourseorderusage/entry',NULL,0,'次课消费查询', 
'c78cd590-7090-433b-9551-066798301a10', 1, 'bd5cab3d-453f-4bf2-ad21-47dce6dfbc68', 'M070-P030',0,1,10,'P_TIME_COURSE_ORDER_USAGE'
)
