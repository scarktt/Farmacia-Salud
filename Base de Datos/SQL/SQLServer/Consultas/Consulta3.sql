/****** Script for SelectTopNRows command from SSMS  ******/
--Mostrar nombre de productos utililes para la gripe
SELECT TOP 1000 [Nombre]
      ,[Descripcion]
  FROM [Farmacia].[dbo].[Gripe]