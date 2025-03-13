
CREATE OR ALTER PROCEDURE usp_paises_crud
@indicador varchar(40),
@country_id char(2),
@country_name varchar(40),
@region_id int
as
begin
	If @indicador ='Insertar'
	Begin
		Insert into countries(country_id, country_name, region_id)
		values (@country_id, @country_name,@region_id)
	End

	If @indicador ='Eliminar'
	Begin
		Delete from countries where country_id= @country_id
	End
 	If @indicador ='Actualizar'
	Begin
		Update countries set country_name=@country_name, region_id=@region_id 
		where country_id=@country_id
	End
	If @indicador ='ConsultarXId'
	Begin
		Select country_id, country_name, region_id  from countries 
		where country_id=@country_id
	End

	If @indicador ='ConsultarTodo'
	Begin
		Select country_id, country_name, region_id  from countries
	End
	
END
GO












