/**
 * Created by Victor_Zhou on 2017-1-1.
 */
var Memcached = require("memcached");
var memcached = new Memcached("127.0.0.1:11211");
memcached.get("t_resource_test3", function (err, data) {
    if(data){
        console.log("memcachedDAO get: " + JSON.stringify(data));
        console.log(JSON.parse(data)['name']);
    } else {
        console.log("memcachedDAO get err " + JSON.stringify(err));
    }
});