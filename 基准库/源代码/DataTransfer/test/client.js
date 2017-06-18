/**
 * Created by 13416 on 2016-10-19.
 */
var http = require("http");

var options = {
    "path":"127.0.0.1",
    "port":"3000",
    "method":"POST",
    "path":"/"
};

var request = http.request(options, function (res) {
    var data = "";
    res.on("data",function(chunk){
        data += chunk;
    });
    res.on("end",function(){
        console.log(JSON.parse(data.toString()));//返回JSON字符串为data.toString()
    });
});

var content = {
    "header":"req",
    "id":"zhc"
};//消息体为content

request.write(JSON.stringify(content));
request.end();