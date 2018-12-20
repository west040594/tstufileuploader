const path = require('path');
const VueLoaderPlugin = require('vue-loader/lib/plugin');

module.exports = {
    mode: 'development',
    devtool: 'source-map',
    entry: {
      'main': path.join(__dirname, 'js', 'main.js'),
    },
    output: {
        filename: 'bundle.js',
        publicPath: ''
    },
    devServer: {
        contentBase: './dist',
        compress: true,
        host: '0.0.0.0',
        port: 8085,
        stats: 'errors-only',
        clientLogLevel : 'error',
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /(node_modules|bower_components)/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-env']
                    }
                }
            },
            {
                test: /\.vue$/,
                loader: 'vue-loader'
            },
        ]
    },
    plugins: [
        new VueLoaderPlugin()
    ],
    watchOptions: {
        aggregateTimeout:300,
        poll: 1000
    },
    resolve: {
        modules: [
            path.join(__dirname, 'js'),
            path.join(__dirname, 'node_modules'),
        ],
    }
}
