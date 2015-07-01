USE [pulasys]
GO

/****** Object:  Table [dbo].[notice]    Script Date: 2015/7/1 23:49:08 ******/
DROP TABLE [dbo].[notice]
GO

/****** Object:  Table [dbo].[notice]    Script Date: 2015/7/1 23:49:08 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[notice](
	[noticeId] [int] NOT NULL,
	[title] [nvarchar](400) NULL,
	[formattedTitle] [nvarchar](2000) NULL,
	[content] text NULL,
	[imgPath] [nvarchar](400) NULL,
	[suffix] [nvarchar](10) NULL,
	[createTime] [datetime] NULL,
	[updateTime] [datetime] NULL
) ON [PRIMARY]

GO

