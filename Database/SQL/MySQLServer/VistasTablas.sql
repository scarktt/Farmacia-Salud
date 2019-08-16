#vistas pantalla compras
-- la vista 5 falta el descuento!!

CREATE VIEW v_compras_1 AS SELECT FacturaPedido,FechaPedido,Nombre  FROM farmaciamsalud.pedido t1 INNER JOIN farmaciamsalud.empleado t2 on t1.IDempleado = t2.IDempleado ;
CREATE VIEW v_compras_2 AS SELECT FacturaPedido,FechaPedido FROM farmaciamsalud.pedido;
CREATE VIEW v_compras_3 AS SELECT Nombre,Dosis_Contenido,Unidad_medida,Nombre_proveedor  FROM farmaciamsalud.producto t1 INNER JOIN farmaciamsalud.DetallePedido t2 on t1.IDproducto = t2.IDproducto INNER JOIN farmaciamsalud.Pedido t3 on t2.FacturaPedido = t3.FacturaPedido INNER JOIN farmaciamsalud.Proveedor t4 on t3.IDproveedor = t4.IDproveedor;
CREATE VIEW v_compras_4 AS SELECT Nombre,Dosis_Contenido,Unidad_medida,PrecioUnitario  FROM farmaciamsalud.producto t1 INNER JOIN farmaciamsalud.DetalleProducto t2 on t1.IDproducto = t2.IDproducto;
CREATE VIEW v_compras_5 AS SELECT t1.IDproducto,t1.Nombre,t1.Dosis_Contenido,t1.Unidad_medida,t4.Nombre_proveedor,t5.CantidadUnidades, t6.PrecioUnitario FROM farmaciamsalud.producto t1 INNER JOIN farmaciamsalud.DetallePedido t2 on t1.IDproducto = t2.IDproducto INNER JOIN farmaciamsalud.Pedido t3 on t2.FacturaPedido = t3.FacturaPedido INNER JOIN farmaciamsalud.Proveedor t4 on t3.IDproveedor = t4.IDproveedor LEFT JOIN farmaciamsalud.DetalleCompraProducto t5 on t1.IDproducto = t5.IDproducto LEFT JOIN farmaciamsalud.DetalleProducto t6 on t1.IDproducto = t6.IDproducto;
CREATE VIEW v_compras_6 AS SELECT t1.FacturaCompraProducto, t1.Observacion, t3.Nombre_proveedor, t4.CantidadUnidades FROM farmaciamsalud.compraproducto as t1 INNER JOIN  farmaciamsalud.abono t2 on t1.FacturaCompraProducto = t2.FacturaCompraProducto INNER JOIN farmaciamsalud.proveedor t3 on t2.IDproveedor = t3.IDproveedor LEFT JOIN farmaciamsalud.detallecompraproducto t4 on t4.FacturaCompraProducto = t1.FacturaCompraProducto;

#vistas pantalla facturacion

CREATE VIEW v_facturacion_1 AS SELECT Nombre, Forma_farmaceutica,Dosis_Contenido,Unidad_medida FROM farmaciamsalud.producto;
# en facturacion 2 se repiten campos por los lotes..
CREATE VIEW v_facturacion_2 AS SELECT t1.NoFactura,t3.Nombre,t3.Forma_farmaceutica,t3.Dosis_Contenido,t3.Unidad_medida, t1.Cantidad,t1.PrecioUnitario, t1.Total FROM farmaciamsalud.detallefactura t1 INNER JOIN farmaciamsalud.detalleproducto t2 on t1.IDproducto = t2.IDproducto INNER JOIN farmaciamsalud.producto t3 on t3.IDproducto = t1.IDproducto ;
CREATE VIEW v_facturacion_3 AS SELECT t3.IDproducto,t3.Nombre,t3.Forma_farmaceutica,t3.Dosis_Contenido,t3.Unidad_medida, t1.Cantidad,t3.StockEstante FROM farmaciamsalud.detallefactura t1 INNER JOIN farmaciamsalud.detalleproducto t2 on t1.IDproducto = t2.IDproducto INNER JOIN farmaciamsalud.producto t3 on t3.IDproducto = t1.IDproducto ;

#vistas pantalla pago de deudas y servicios

CREATE VIEW v_pago_1 AS SELECT t3.Nombre_proveedor, t1.MontoCompra, t1.ReciboColector, t1.Observacion, t1.FechaVencPago FROM farmaciamsalud.compraproducto t1 INNER JOIN farmaciamsalud.abono t2 on t1.FacturaCompraProducto = t2.FacturaCompraProducto INNER JOIN farmaciamsalud.proveedor t3 on t2.IDproveedor = t3.IDproveedor;
CREATE VIEW v_pago_2 AS SELECT t2.Nombre, t1.TipoPago, t1.MontoPago FROM farmaciamsalud.pagos t1 INNER JOIN farmaciamsalud.empleado t2 on t1.IDempleado = t2.IDempleado;


#vistas pantalla pedidos
-- se repite la v_compras_3 

CREATE VIEW v_pedidos_1 AS SELECT t1.FacturaPedido,t3.Nombre,t3.Dosis_Contenido,t3.Unidad_medida,t4.Nombre_proveedor,t2.CantidadUnidad,t2.PrecioxUnidad,t1.MontoPedido  FROM farmaciamsalud.pedido t1 INNER JOIN farmaciamsalud.detallepedido t2 on t1.FacturaPedido = t2.FacturaPedido INNER JOIN farmaciamsalud.producto t3 on t2.IDproducto = t3.IDproducto LEFT JOIN farmaciamsalud.proveedor t4 on t1.IDproveedor = t4.IDproveedor;
CREATE VIEW v_pedidos_2 AS SELECT t3.IDproducto,t3.Nombre,t3.Dosis_Contenido,t3.Unidad_medida,t4.Nombre_proveedor,t2.CantidadUnidad  FROM farmaciamsalud.pedido t1 INNER JOIN farmaciamsalud.detallepedido t2 on t1.FacturaPedido = t2.FacturaPedido INNER JOIN farmaciamsalud.producto t3 on t2.IDproducto = t3.IDproducto LEFT JOIN farmaciamsalud.proveedor t4 on t1.IDproveedor = t4.IDproveedor;

#vistas pantalla productos

CREATE VIEW v_productos_1 AS SELECT t1.IDproducto,t1.Nombre,t1.Forma_farmaceutica,t1.Dosis_Contenido,t1.Unidad_medida,t1.Restriccion,t1.Descontinuado,t3.Descripcion Utilidadproducto, t5.Descripcion, t1.StockBodega,t1.StockEstante from farmaciamsalud.producto t1 INNER JOIN farmaciamsalud.utilidadproducto t2 on t1.IDproducto = t2.IDproducto INNER JOIN farmaciamsalud.enfermedad t3 on t2.IDenfermedad = t3.IDenfermedad LEFT JOIN farmaciamsalud.indicacionproducto t4 on t1.IDproducto = t4.IDproducto INNER JOIN farmaciamsalud.indicacion t5 on t4.IDindicacion = t5.IDindicacion;
CREATE VIEW v_productos_2 AS SELECT t1.IDproducto,t2.IDlote,t1.Nombre,t1.Forma_farmaceutica,t1.Dosis_Contenido,t1.Unidad_medida, t1.StockBodega,t1.StockEstante from farmaciamsalud.producto t1 INNER JOIN farmaciamsalud.detalleproducto t2 on t1.IDproducto = t2.IDproducto;
CREATE VIEW v_productos_3 AS SELECT Nombre,Forma_farmaceutica,Dosis_Contenido,Unidad_medida,Restriccion,Descontinuado FROM farmaciamsalud.producto;
CREATE VIEW v_productos_4 AS SELECT t1.IDproducto,t1.IDlote,t3.Nombre,t3.Forma_farmaceutica,t3.Dosis_Contenido,t3.Unidad_medida,t6.Nombre_proveedor,t1.Cantidad,t1.MontoPerdido FROM farmaciamsalud.perdidaproducto t1 INNER JOIN farmaciamsalud.detalleproducto t2 on t1.IDproducto = t2.IDproducto INNER JOIN farmaciamsalud.producto t3 on t2.IDproducto = t3.IDproducto INNER JOIN farmaciamsalud.detallepedido t4 on t3.IDproducto= t4.IDproducto INNER JOIN farmaciamsalud.pedido t5 on t4.FacturaPedido = t5.FacturaPedido INNER JOIN farmaciamsalud.proveedor t6 on t5.IDproveedor = t6.IDproveedor;

#vistas pantalla proveedor

CREATE VIEW v_proveedor_1 AS SELECT IDproveedor,Nombre_proveedor,Tipo_proveedor,tel1,tel2 FROM farmaciamsalud.proveedor;




 