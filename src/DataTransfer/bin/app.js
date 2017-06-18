/**
 * 程序入口
 */
var http = require("http");
var url = require("url");
var portConfig = require("../config/portConfig.json");
var packageDataService = require("../service/packageDataService");
var logger = require("../logging/logger")();

var mimetype = {
    txt: "text/plain",
    html: "text/html",
    css: "text/css",
    xml: "application/xml",
    json: "application/json",
    js: "application/javascript",
    jpg: "image/jpeg",
    jpeg: "image/jpeg",
    gif: "image/gif",
    png: "image/png",
    svg: "image/svg+xml"
};

/**
 * 处理pageNotFound
 * @param req
 * @param res
 * @param path
 */
var pageNotFound = function(req, res, path){
    res.writeHead(404, {
        "Content-Type": mimetype['html']
    });
    res.write("<!doctype html>\n");
    res.write("<title>404 Not Found</title>\n");
    res.write("<h1>Not Found</h1>");
    res.write(
        "<p>The requested URL " +
        path +
        " was not found on this server.</p>"
    );
    res.end();
};

/**
 * 开启端口监听
 */
http.createServer(function (req, res) {

    var pathname = url.parse(req.url).pathname;
    var requestMethod = req.method;

    if(pathname == "/" && requestMethod == "GET"){
        
        logger.info("http Server receive msg from fore-end");

        var data = require("url").parse(req.url,true).query;

        if(data['header'] == "req" && data['name']){

            var name = data['name'];

            res.writeHead(200, {
                "Content-Type": mimetype['json'],
                "Access-Control-Allow-Origin":"*",
                "Access-Control-Allow-Methods":"GET"
            });

            packageDataService.packageDataByID(name, function (err, msg) {
                if(!err){
                    res.write(JSON.stringify(msg));
                    res.end();
                    logger.info("http Server send success" + JSON.stringify(msg));
                } else {
                    res.write(JSON.stringify(err));
                    res.end();
                    logger.info("http Server send error" + JSON.stringify(err));
                }
            });

        } else {
            logger.error("http Server data format is wrong");
            return pageNotFound(req, res, pathname);
        }

    } else {
        logger.error("http Server request is not from fore-end");
        return pageNotFound(req, res, pathname);
    }

}).listen(portConfig['app']);
logger.info("http Server server is listening at port: " + portConfig['app']);

// http.createServer(function (req, res) {
//     res.writeHead(200,{"Content-Type":"text/plain","charset":"utf-8","Access-Control-Allow-Origin":"*","Access-Control-Allow-Methods":"GET"});
//     var data = require("url").parse(req.url,true).query;
//     console.log(data);
//     if(data["header"] == "req"){
//         var id = data["id"];
//         packageDataService.packageDataByID(id, function (err, msg) {
//             if(!err){
//                 console.log(msg);
//                 res.write(JSON.stringify(msg));
//                 res.end();
//                 console.log("send success");
//             } else {
//                 console.log(err);
//                 res.write(JSON.stringify(err));
//                 res.end();
//                 console.log("send error");
//             }
//         });
//
//     } else {
//         console.log("request is not from fore-end");
//     }
// }).listen(portConfig["app"]);

