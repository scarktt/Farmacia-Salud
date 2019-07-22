-- spCompraProductoEliminar
CREATE PROCEDURE spCompraProductoEliminar (
    @IDcompra INT,
    @IDpedido INT,
    @IDproveedor INT,
    @IDproducto INT
) AS
BEGIN
    DELETE FROM dbo.CompraProducto 
    WHERE   IDcompra = @IDcompra AND
            IDpedido = @IDpedido AND
            IDproveedor = @IDproveedor AND
            IDproducto = @IDproducto
END
GO

------------------------------------------------------------
------------------------------------------------------------
-- spDetalleCompraEliminar
CREATE PROCEDURE spDetalleCompraEliminar (
    @IDdetallecompra INT,
    @IDcompra INT,
    @IDproducto INT
) AS
BEGIN
    DELETE FROM dbo.DetalleCompra
    WHERE   IDdetallecompra = @IDdetallecompra AND
            IDcompra = @IDcompra AND
            IDproducto = @IDproducto
END
GO

------------------------------------------------------------
------------------------------------------------------------
-- spEmpleadoEliminar
CREATE PROCEDURE spEmpleadoEliminar (
    @IDempleado INT
) AS 
BEGIN
    DELETE FROM dbo.Empleado
    WHERE   IDempleado = @IDempleado
END
GO

------------------------------------------------------------
------------------------------------------------------------
-- spEnfermedadEliminar
CREATE PROCEDURE spEnfermedadEliminar (
    @IDenfermedad INT
) AS
BEGIN
    DELETE FROM dbo.Enfermedad
    WHERE      IDenfermedad = @IDenfermedad
END
GO

------------------------------------------------------------
------------------------------------------------------------
-- spIndicacionEliminar
CREATE PROCEDURE spIndicacionEliminar (
    @IDinidicacion INT
) AS
BEGIN
    DELETE FROM dbo.Indicacion I dbo.IndicacionProducto IP
    WHERE   I.IDindicacion = @IDinidicacion AND IP.IDindicacion = @IDindicacion
END
GO

------------------------------------------------------------
------------------------------------------------------------
-- sp
