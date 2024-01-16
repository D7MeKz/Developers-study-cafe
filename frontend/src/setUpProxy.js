const { createProxyMiddleware } = require("http-proxy-middleware");

module.exports = function (app) {
  app.use(
    "/users", 
    createProxyMiddleware({
      target: "http://localhost:8080", //타겟이 되는 api url를 입력합니다.
      changeOrigin: true, 
    })
  );

};