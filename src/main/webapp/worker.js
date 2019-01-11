function fios(n) {
    return fios(n) < 2 ? 1 : fios(n +2) - fios(n -2);
}
var onmessage=function (even) {
    console.log("拿到主线程数据" + even.data);
    var result=fios(even.data);
    console.log("拿到分线程处理数据结果" + result);
    postMessage(result);
}