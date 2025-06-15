

CREATE OR ALTER PROCEDURE usp_empleado_crud(
	@indicador varchar(20),
	@employee_id int,
    @first_name VARCHAR(50),
    @last_name VARCHAR(50),
    @email VARCHAR(100),
    @phone_number VARCHAR(20),
    @hire_date DATE,
    @job_id INT,
    @salary DECIMAL(10, 2),
    @manager_id INT,
    @department_id INT
)
as
BEGIN
    
	if @indicador = 'Insertar'
	Begin
		INSERT INTO dbo.employees (first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id, department_id)
		VALUES (@first_name, @last_name, @email, @phone_number, @hire_date, @job_id, @salary, @manager_id, @department_id)
	end
	if @indicador = 'Actualizar'
	begin

		UPDATE dbo.employees
		SET 
			first_name = @first_name,
			last_name = @last_name,
			email = @email,
			phone_number = @phone_number,
			hire_date = @hire_date,
			job_id = @job_id,
			salary = @salary,
			manager_id = @manager_id,
			department_id = @department_id
		 WHERE employee_id=@employee_id	
	end
	if @indicador='eliminar'
	begin
		delete from employees where employee_id= @employee_id
	end

	if @indicador='ConsultarXID'
	begin
	SELECT employee_id, first_name, last_name, email, 
		isnull(phone_number,'') as phone_number,
		hire_date, job_id, salary, isNull(manager_id,0) as manager_id
		, department_id
		FROM dbo.employees where employee_id=@employee_id
	end

	if @indicador='ConsultarTodo'
	begin

		SELECT employee_id, first_name, last_name, email, 
		isNull(phone_number,'') as phone_number, hire_date, job_id, salary, 
		isNull(manager_id,0) as manager_id , department_id
		FROM [dbo].[employees] 
	end

END
go


create or alter procedure usp_formulario_combo
@indicador varchar(30)
as
begin
	if @indicador ='tabla_empleado'
	begin
		declare @table table(
			indicador varchar(30), combo_id int, combo_name varchar(50)
		)
		insert into @table(indicador, combo_id, combo_name)
		select 'TRABAJO', job_id, job_title from jobs

		insert into @table(indicador, combo_id, combo_name)
		select 'DEPARTAMENTO', department_id, department_name from departments

		insert into @table(indicador, combo_id, combo_name)
		select 'EMPLEADO', employee_id, Concat(first_name,' ', last_name) from employees

		Select indicador, combo_id, combo_name from @table
	end
end
go

usp_formulario_combo 'tabla_empleado'
go