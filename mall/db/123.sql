SELECT GROUP_CONCAT(COLUMN_NAME SEPARATOR ",") FROM information_schema.COLUMNS 
WHERE TABLE_SCHEMA = 'mall' AND TABLE_NAME = 't_address';

SELECT CONCAT("var ",COLUMN_NAME," = $('#",COLUMN_NAME,"').val();") FROM information_schema.COLUMNS 
WHERE TABLE_SCHEMA = 'mall' AND TABLE_NAME = 't_address';

select is_Default,id,recv_name from t_address;

$('#recv_name').val(data.recv_name);

SELECT CONCAT("$('#",COLUMN_NAME,"').val(data.",COLUMN_NAME,");") FROM information_schema.COLUMNS 
WHERE TABLE_SCHEMA = 'mall' AND TABLE_NAME = 't_address';

SELECT CONCAT(COLUMN_NAME,"=#{",COLUMN_NAME,"},") FROM information_schema.COLUMNS 
WHERE TABLE_SCHEMA = 'mall' AND TABLE_NAME = 't_address';
