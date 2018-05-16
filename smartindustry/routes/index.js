var express     = require('express');
var router      = express.Router();
var path        = require('path');

const database  = require('.././database/mongoose');

const VIEW_PATH = 'C:/Users/caspe/PhpstormProjects/smartindustry/views/';


router.get('/data', function(req, res, next){
    res.sendFile(path.join(VIEW_PATH + 'insert-data.html'));
});

router.post('/data/insert', function(req, res, next){
    var data = new database.Data({
        machine     : req.body.machine,
        sensor      : req.body.sensor,
        value       : req.body.value,
        timestamp   : req.body.timestamp
    });

    data.save(function(err, data){
        if (err) console.log(err);
        else {
            console.log('Data successfully saved!');
            console.log(JSON.stringify(data));
        }
    });



    res.send(JSON.stringify(data));

});

module.exports = router;