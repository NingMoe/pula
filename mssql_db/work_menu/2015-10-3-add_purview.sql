/****** Script for SelectTopNRows command from SSMS  ******/
SELECT *
  FROM [pula_sys].[dbo].[purview] where module = 'c78cd590-7090-433b-9551-066798301a10'


--insert into [pula_sys].[dbo].[purview](
--id,menuItem,defaultURL,parentPurview,level,name,module,visible,appField,treePath,removed,leaf,indexNo,no)
--values
--(
--'5f751d10-24e8-4c9a-be9b-4beaed185d1f',1, 'timecourse/entry',NULL,0,'次课查询', 
--'c78cd590-7090-433b-9551-066798301a10', 1, 'bd5cab3d-453f-4bf2-ad21-47dce6dfbc68', 'M070-P010',0,1,10,'P_TIME_COURSE'
--)

insert into [pula_sys].[dbo].[purview](
id,menuItem,defaultURL,parentPurview,level,name,module,visible,appField,treePath,removed,leaf,indexNo,no)
values
(
'5f751d14-24e8-4c9a-be9b-4beaed185d1f',1, 'timecoursework/entry',NULL,0,'次课作品查询', 
'c78cd590-7090-433b-9551-066798301a10', 1, 'bd5cab3d-453f-4bf2-ad21-47dce6dfbc68', 'M070-P040',0,1,10,'P_TIME_COURSE_WORK'
)
-- delete from [pula_sys].[dbo].[purview] where id='5f751d14-24e8-4c9a-be9b-4beaed185d1f'
