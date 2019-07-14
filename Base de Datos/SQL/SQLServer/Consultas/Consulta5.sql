Create view [Fechaordenada] As
--Muestre todos los nombres de los productos ordenados por la fecha mas próxima a vencerse a la fecha mas lejana
SELECT Nombre, FechaVenc FROM Producto P, Lote L, StockProducto S
WHERE L.IDlote = S.IDlote AND P.IDproducto = S.IDproducto
ORDER BY FechaVenc OFFSET 0 ROWS