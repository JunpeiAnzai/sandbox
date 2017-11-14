const env = process.env.NODE_ENV;

const ExtractTextPlugin = require('extract-text-webpack-plugin');

module.exports = {
  entry: './src/index.tsx',
  output: {
    filename: '../public/javascripts/bundle.js'
  },

  devtool: 'source-map',

  resolve: {
    extensions: ['.ts', '.tsx', '.js']
  },

  module: {
    rules: [
      {
        test: /\.css$/,
        use: ExtractTextPlugin.extract({
          fallback: 'style-loader',
          use: ['css-loader']
        })
      },
      {
        test: /\.tsx?$/,
        use: [
          'ts-loader'
        ]
      }
    ]
  },
  plugins: [
    new ExtractTextPlugin({
      filename: '../public/stylesheets/[name].css'
    })
  ]
};
