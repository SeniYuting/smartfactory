/**
 * 数据打包
 */
var memcacahedDAO = require("../dao/memcachedDAO");
var logger = require("../logging/logger")();

exports.packageDataByID = function (name, cb) {
    memcacahedDAO.getDataFromMemcachedByID(name, function (err, data) {
        if(data){
            data['timestamp'] = new Date().getTime();
            var msg = {"header": "res", "data": data};
            cb(null, msg);
            logger.info("packageDataService success " + JSON.stringify(msg));
        } else {
            var msg = {"header": "err", "id": name, "info": JSON.stringify(err)};
            cb(msg, null);
            logger.error("packageDataService error " + JSON.stringify(msg));
        }
    });
};