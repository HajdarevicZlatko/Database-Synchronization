const express= require('express');
const app =express();
var mongoClient=require('mongodb').MongoClient;
const url='mongodb://localhost:27017';

//ROUTES
app.get('/',(req, res)=>{
res.send("We are on home");
});
app.get('/zika',(req, res)=>{
    try{
        mongoClient.connect(url, function(err, db) {
            if (err) {
                throw "Konekcija nije uspela";
            }
            var dbo = db.db('local');
            var x=dbo.collection('Test').find().toArray((err, result)=>{
                if(err){
                    throw "Ucitavanje nije uspelo"
                }
                result.map(item=>{
                delete item._id;
                }) 
                res.send(result);
            });
            
        }); 
    }
    catch(err){
        console.log(err)
    }
    });
    app.get('/mysql',(req, res)=>{
        let mysqlDAL = require('./MysqlDAL');
        let pr=new Promise((a,b)=>{
            a(mysqlDAL.GetAll())
        });
        pr.then(a=>res.send(a[0]))  
    });


//LISTENING
app.listen(8082);

