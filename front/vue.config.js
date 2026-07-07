const webpack = require('webpack')

module.exports = {
    publicPath: './',
    assetsDir: 'static',
    productionSourceMap: false,
    configureWebpack: {
        plugins: [
            new webpack.ProvidePlugin({
                $: "jquery",
                jQuery: "jquery",
                "windows.jQuery": "jquery"
            })
        ]
    },
    devServer: {
        port: 8081,
        disableHostCheck: true,
        proxy: {
            '/message': {
                target: 'http://localhost:8080',
                changeOrigin: true
            },
            '/user': {
                target: 'http://localhost:8080',
                changeOrigin: true
            },
            '/idle': {
                target: 'http://localhost:8080',
                changeOrigin: true
            },
            '/order': {
                target: 'http://localhost:8080',
                changeOrigin: true
            },
            '/favorite': {
                target: 'http://localhost:8080',
                changeOrigin: true
            },
            '/address': {
                target: 'http://localhost:8080',
                changeOrigin: true
            }
        }
    }
};