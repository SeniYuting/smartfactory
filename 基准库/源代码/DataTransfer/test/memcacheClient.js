/**
 * Created by 13416 on 2016-10-19.
 */
var Memcached = require("memcached");
var memcachedConfig = require("../config/memcachedConfig");

var memcached = new Memcached(memcachedConfig["locations"]);

/* 1 */
var DATA_OPERATIONS_TEST_1 = {
    "name" : "source_A",
    "type" : "single",
    "tupleNum" : "2",
    "frequency" : "60",
    "content" :{
        "sum_area": 15,
        "count_quantity": 5
    }
};

/* 2 */
var DATA_OPERATIONS_TEST_2 = {
    "name" : "source_B",
    "type" : "single",
    "tupleNum" : "2",
    "frequency" : "60",
    "content" :{
        "sum_area": 15,
        "count_quantity": 5
    }

};

/* 3 */
var DATA_OPERATIONS_TEST_3 = {
    "name" : "source_C",
    "type" : "single",
    "tupleNum" : "1",
    "frequency" : "60",
    "content" : {
        "count_row": 5
    }
};

/* 4 */
var DATA_OPERATIONS_TEST_4 = {
    "name" : "source_D",
    "type" : "list",
    "tupleNum" : "3",
    "frequency" : "60",
    "content" :
        [{
        "name": "监控1",
        "area":300,
        "quantity":1000
        },
        {
            "name": "监控2",
            "area":14422,
            "quantity":0
        },
        {
            "name": "监控3",
            "area":14422,
            "quantity":0
        }]
};



memcached.set("zhc", {"value": "123"}, 0, function (err) {
    if(err){
        console.log("set error" + JSON.stringify(err));
    }
});

// memcached.get("DATA_OPERATIONS_TEST_1", function (err, data) {
//     if(err){
//         console.log("get error" + JSON.stringify(err));
//     } else {
//         console.log(JSON.stringify(data));
//     }
// });