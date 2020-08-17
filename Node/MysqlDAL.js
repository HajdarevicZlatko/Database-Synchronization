    var  mysql = require('mysql2');
    var connection = mysql.createConnection({
        host     : 'localhost',
        user     : 'root',
        password : '',
        database : 'smartbuilding'
        });
        var arrayFromMysql=[];
exports.GetAll = ()=>{
                connection.connect();
                return connection.promise().query('SELECT * from person');  
}