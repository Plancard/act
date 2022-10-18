
const { createProxyMiddleware } = require('http-proxy-middleware');

// BackEnd 서버와 미들웨어 연결
module.exports = function(app) {
    app.use(
        '/',
        createProxyMiddleware({
            target: 'http://localhost:8080',
            changeOrigin: true,
            ws: true,

        })
    );
};