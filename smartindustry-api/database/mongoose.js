/*----------------------- MONGOOSE ------------------------*/

const mongoose      = require('mongoose');

const MONGO_ADDRESS = 'localhost';
const MONGO_DB_NAME = 'smart-industry';

mongoose.connect('mongodb://'+ MONGO_ADDRESS +'/' + MONGO_DB_NAME);

var db = mongoose.connection;

db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', function() {
    console.log('Connected with MongoDB on mongodb://'+ MONGO_ADDRESS + '/' + MONGO_DB_NAME);
});

// mongoose object of data
var dataSchema = mongoose.Schema({
    machine     : String,
    sensor      : String,
    value       : Number,
    timestamp   : String
},{
    // _id         : false,
    // versionKey  : false
});

var Data = mongoose.model('Data', dataSchema);

module.exports = {
    Data: Data
};
