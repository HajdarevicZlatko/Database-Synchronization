
class MysqlDAL{

    constructor(){
        
     }
        name="Zlatko";
      mysql = require('mysql');
     connection = mysql.createConnection({
        host     : 'localhost',
        user     : 'root',
        password : '',
        database : 'smartbuilding'
        });
     test(){
        connection.connect();
        let res;
        connection.query('SELECT * from person', function (error, results, fields) {
          if (error) return error;
        res=results;
        });
        connection.end();
        return res;
    }

}
module.exports = MysqlDAL;



