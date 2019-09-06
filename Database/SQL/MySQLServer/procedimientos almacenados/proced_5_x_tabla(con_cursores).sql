
/* procedimientos almacenados tabla abono */
   
-- sencillos ---------------------------- 
DELIMITER $$
CREATE PROCEDURE `PA_Abono_1` (in saldo decimal)
BEGIN
select IDabono, FechaAbono from FarmaciaMSalud.Abono where SaldoAbono = saldo ORDER BY FechaAbono Desc;
END$$
DELIMITER 

DELIMITER $$
CREATE PROCEDURE `PA_Abono_2` (in proveedor int)
BEGIN
select a.SaldoAbono, a.FechaAbono from FarmaciaMSalud.Abono a INNER JOIN FarmaciaMSalud.Proveedor p 
where p.IDproveedor= proveedor ORDER BY SaldoAbono ASC;
END$$
DELIMITER 

-- con cursores -----------------

DELIMITER $$
CREATE PROCEDURE `PA_Abono_3` (f_inicio DATETIME,f_fin DATETIME)
BEGIN
DECLARE v_proveedor char(30); DECLARE v_saldo decimal;
DECLARE temp_prov char(30) default 0; DECLARE temp_saldo decimal default 0;
DECLARE hecho INT DEFAULT FALSE;     

DECLARE CurMayorAbono CURSOR FOR SELECT p.Nombre_proveedor,a.SaldoAbono FROM FarmaciaMSalud.Abono a 
INNER JOIN FarmaciaMSalud.Proveedor p ON a.IDproveedor = p.IDproveedor  AND (a.FechaAbono BETWEEN f_inicio AND f_fin);
DECLARE CONTINUE HANDLER FOR NOT FOUND SET hecho = TRUE;

	OPEN CurMayorAbono;
		loop1: LOOP
			FETCH CurMayorAbono INTO v_proveedor, v_saldo;
				IF hecho THEN LEAVE loop1;
				END IF;
			IF v_saldo >Temp_saldo THEN
				SET temp_saldo = v_saldo;
				SET temp_prov = v_proveedor;
			END IF;
		 END LOOP loop1;
	CLOSE CurMayorAbono;
SELECT  temp_prov AS Proveedor, temp_saldo AS Saldo;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `PA_Abono_4` (f_inicio DATETIME,f_fin DATETIME)
BEGIN
DECLARE v_proveedor char(30); DECLARE v_saldo decimal;
DECLARE temp_prov char(30) default 0; DECLARE temp_saldo decimal default 0;
DECLARE hecho INT DEFAULT FALSE;     

DECLARE CurMenorAbono CURSOR FOR SELECT p.Nombre_proveedor,a.SaldoAbono FROM FarmaciaMSalud.Abono a 
INNER JOIN FarmaciaMSalud.Proveedor p ON a.IDproveedor = p.IDproveedor  AND (a.FechaAbono BETWEEN f_inicio AND f_fin);
DECLARE CONTINUE HANDLER FOR NOT FOUND SET hecho = TRUE;

	OPEN CurMenorAbono;
		loop1: LOOP
			FETCH CurMenorAbono INTO v_proveedor, v_saldo;
				IF hecho THEN LEAVE loop1;
				END IF;
			IF v_saldo <=temp_saldo or temp_saldo = 0  THEN
				SET temp_saldo = v_saldo;
				SET temp_prov = v_proveedor;
			END IF;
		 END LOOP loop1;
	CLOSE CurMenorAbono;
SELECT  temp_prov AS Proveedor, temp_saldo AS Saldo;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `PA_Abono_5` (f_inicio DATETIME,f_fin DATETIME)
BEGIN
DECLARE v_saldo decimal;
DECLARE total_saldo decimal default 0;
DECLARE hecho INT DEFAULT FALSE;     

DECLARE CurTotalAbono CURSOR FOR SELECT SaldoAbono FROM FarmaciaMSalud.Abono 
WHERE FechaAbono BETWEEN f_inicio AND f_fin;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET hecho = TRUE;

	OPEN CurTotalAbono;
		loop1: LOOP
			FETCH CurTotalAbono INTO v_saldo;
				IF hecho THEN LEAVE loop1;
				END IF;
			SET total_saldo = total_saldo + v_saldo;
			
		 END LOOP loop1;
	CLOSE CurTotalAbono;
SELECT  total_saldo AS Saldo_Total;
END$$
DELIMITER ;

-- procedimientos almacenados tabla compra ----------------------------------------
-- sencillos ----------------------------
DELIMITER $$
CREATE PROCEDURE `PA_compra_1` (in no_factura decimal)
BEGIN
select FechaCompra, MontoCompra from FarmaciaMSalud.compra where FacturaCompra = no_factura;
END$$
DELIMITER 

DELIMITER $$
CREATE PROCEDURE `PA_compra_2` (in estatus char(10))
BEGIN
select FechaCompra, MontoCompra from FarmaciaMSalud.Compra where Status = estatus;
END$$
DELIMITER 

-- con cursores -----------------------------------------------
DELIMITER $$
CREATE PROCEDURE `PA_compra_3` (no_proveedor int(11) )
BEGIN
DECLARE v_monto decimal;
DECLARE total_monto decimal default 0;
DECLARE hecho INT DEFAULT FALSE;     

DECLARE CurTotalMonto CURSOR FOR SELECT MontoCompra FROM FarmaciaMSalud.Compra 
WHERE IDproveedor = no_proveedor;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET hecho = TRUE;

	OPEN CurTotalMonto;
		loop1: LOOP
			FETCH CurTotalMonto INTO v_monto;
				IF hecho THEN LEAVE loop1;
				END IF;
			SET total_monto = total_monto + v_monto;
			
		 END LOOP loop1;
	CLOSE CurTotalMonto;
SELECT  total_monto AS Monto_Total;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `PA_compra_4` (f_inicio DATETIME,f_fin DATETIME)
BEGIN
DECLARE v_proveedor char(11); DECLARE v_monto decimal(13,3);
DECLARE temp_prov char(11) default 0; DECLARE temp_monto decimal(13,3) default 0;
DECLARE hecho INT DEFAULT FALSE;     

DECLARE CurMayorMonto CURSOR FOR SELECT p.Nombre_proveedor,c.MontoCompra FROM FarmaciaMSalud.Compra c INNER JOIN FarmaciaMSalud.Abono a 
on a.IDproveedor = a.IDproveedor INNER JOIN FarmaciaMSalud.Proveedor p ON a.IDproveedor = p.IDproveedor  
AND (c.FechaCompra BETWEEN f_inicio AND f_fin);
DECLARE CONTINUE HANDLER FOR NOT FOUND SET hecho = TRUE;

	OPEN CurMayorMonto;
		loop1: LOOP
			FETCH CurMayorMonto INTO v_proveedor, v_monto;
				IF hecho THEN LEAVE loop1;
				END IF;
			IF v_monto >=Temp_monto THEN
				SET temp_monto = v_monto;
				SET temp_prov = v_proveedor;
			END IF;
		 END LOOP loop1;
	CLOSE CurMayorMonto;
SELECT  temp_prov AS Proveedor, temp_monto AS Monto;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `PA_compra_5` (estatus char(10))
BEGIN
DECLARE v_proveedor char(11); DECLARE v_monto decimal(13,3);
DECLARE temp_prov char(11) default 0; DECLARE temp_monto decimal(13,3) default 0;
DECLARE hecho INT DEFAULT FALSE;     
DECLARE CurMayorMonto CURSOR FOR SELECT p.Nombre_proveedor,c.MontoCompra FROM FarmaciaMSalud.Compra c INNER JOIN FarmaciaMSalud.Abono a 
on a.IDproveedor = a.IDproveedor INNER JOIN FarmaciaMSalud.Proveedor p ON a.IDproveedor = p.IDproveedor  
WHERE c.status = estatus;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET hecho = TRUE;
	OPEN CurMayorMonto;
		loop1: LOOP
			FETCH CurMayorMonto INTO v_proveedor, v_monto;
				IF hecho THEN LEAVE loop1;
				END IF;
			IF v_monto >=Temp_monto THEN
				SET temp_monto = v_monto;
				SET temp_prov = v_proveedor;
			END IF;
		 END LOOP loop1;
	CLOSE CurMayorMonto;
SELECT  temp_prov AS Proveedor, temp_monto AS Monto;
END$$
DELIMITER ;

-- procedimientos almacenados tabla factura ---------------------------------
-- sencillos --------------------------------------------
DELIMITER $$
CREATE PROCEDURE `PA_factura_1` (in fecha_factura datetime)
BEGIN
select f.NoFactura, df.Total from FarmaciaMSalud.Factura f INNER JOIN FarmaciaMSalud.DetalleFactura df on f.NoFactura = df.NoFactura
 where f.Fecha = fecha_factura;
END$$
DELIMITER 

DELIMITER $$
CREATE PROCEDURE `PA_factura_2` (in no_empleado int(11))
BEGIN
select f.NoFactura, df.Total from FarmaciaMSalud.Factura f INNER JOIN FarmaciaMSalud.DetalleFactura df on f.NoFactura = df.NoFactura
 where f.IDempleado = no_empleado;
END$$
DELIMITER 

-- con cursores ---------------------------------------

DELIMITER $$
CREATE PROCEDURE `PA_factura_3` (no_empleado int(11) )
BEGIN
DECLARE v_monto decimal; DECLARE total_fact int default 0;
DECLARE total_monto decimal default 0;
DECLARE hecho INT DEFAULT FALSE;     

DECLARE CurTotalfact CURSOR FOR 
select df.Total from FarmaciaMSalud.Factura f INNER JOIN FarmaciaMSalud.DetalleFactura df on f.NoFactura = df.NoFactura
 where f.IDempleado = no_empleado;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET hecho = TRUE;

	OPEN CurTotalfact;
		loop1: LOOP
			FETCH CurTotalfact INTO v_monto;
				IF hecho THEN LEAVE loop1;
				END IF;
			SET total_monto = total_monto + v_monto;
            set total_fact = total_fact + 1;
			
		 END LOOP loop1;
	CLOSE CurTotalfact;
SELECT  total_monto AS Monto_Total, total_fact as Cantidad_facturas;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `PA_factura_4` (f_inicio DATETIME,f_fin DATETIME)
BEGIN
DECLARE v_monto decimal(13,3);
DECLARE temp_fact char(11) default 0; DECLARE temp_monto decimal(13,3) default 0;
DECLARE hecho INT DEFAULT FALSE;     

DECLARE CurTotalMonto CURSOR FOR 
select df.Total from FarmaciaMSalud.Factura f INNER JOIN FarmaciaMSalud.DetalleFactura df on f.NoFactura = df.NoFactura
 AND (f.Fecha BETWEEN f_inicio AND f_fin);
DECLARE CONTINUE HANDLER FOR NOT FOUND SET hecho = TRUE;

	OPEN CurTotalMonto;
		loop1: LOOP
			FETCH CurTotalMonto INTO v_monto;
				IF hecho THEN LEAVE loop1;
				END IF;
			SET temp_monto = temp_monto + v_monto;
            set temp_fact = temp_fact + 1;
		 END LOOP loop1;
	CLOSE CurTotalMonto;
SELECT  temp_monto AS Monto_Total, temp_fact as Cantidad_facturas;
END$$	
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `PA_factura_5` (f_inicio DATETIME,f_fin DATETIME)
BEGIN
DECLARE v_empleado char(30); DECLARE v_monto decimal;
DECLARE temp_emp char(30) default 0; DECLARE temp_monto decimal default 0;
DECLARE hecho INT DEFAULT FALSE;     

DECLARE CurMayorMonto CURSOR FOR 
SELECT e.Nombre,df.Total FROM FarmaciaMSalud.factura f INNER JOIN FarmaciaMSalud.Empleado e ON e.IDempleado = f.IDempleado 
INNER JOIN FarmaciaMSalud.DetalleFactura df on f.NoFactura = df.NoFactura AND (f.Fecha BETWEEN f_inicio AND f_fin);
DECLARE CONTINUE HANDLER FOR NOT FOUND SET hecho = TRUE;

	OPEN CurMayorMonto;
		loop1: LOOP
			FETCH CurMayorMonto INTO v_empleado, v_monto;
				IF hecho THEN LEAVE loop1;
				END IF;
			IF v_monto >Temp_monto THEN
				SET temp_monto = v_monto;
				SET temp_emp = v_empleado;
			END IF;
		 END LOOP loop1;
	CLOSE CurMayorMonto;
SELECT  temp_emp AS Empleado, temp_monto AS MontoTotal;
END$$
DELIMITER ;


-- procedimientos almacenados tabla inventarioproducto
-- sencillos
-- con cursores

-- procedimientos almacenados tabla pagos
-- sencillos
-- con cursores

-- procedimientos almacenados tabla pedido
-- sencillos
-- con cursores

-- procedimientos almacenados tabla producto
-- sencillos
-- con cursores

