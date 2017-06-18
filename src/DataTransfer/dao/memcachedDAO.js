/**
 * memcache数据访问
 */
var Memcached = require("memcached");
var memcachedConfig = require("../config/memcachedConfig");
var logger = require("../logging/logger")();

var memcached = new Memcached(memcachedConfig['locations']);

/**
 * memcache数据访问函数
 * @param name
 * @param cb
 */
exports.getDataFromMemcachedByID = function(name, cb){
    memcached.get(name, function (err, data) {
        if(data){
            cb(null, data);
            logger.info("memcachedDAO get: " + JSON.stringify(data));
        } else {
            cb("[" + name + "] can not find", null);
            logger.error("memcachedDAO get err " + JSON.stringify(err));
        }
    });
};