/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP 1000 [id]
      ,[name]
      ,[indexNo]
      ,[appField]
      ,[removed]
      ,[comments]
      ,[no]
  FROM [pula_sys].[dbo].[module]

insert into [pula_sys].[dbo].[module](id, name, indexNo, appField, removed, comments, no)
values
(
'c78cd590-7090-433b-9551-066798301a10',	'次课管理','70', 'bd5cab3d-453f-4bf2-ad21-47dce6dfbc68',0, '', 'M_TimeCourse')