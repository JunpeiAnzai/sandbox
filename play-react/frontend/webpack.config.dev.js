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
        test: /\.tsx?$/,
        use: [
          'ts-loader'
        ]
      },
      {
        test: /\.css$/,
        use: ExtractTextPlugin.extract({
          fallback: 'style-loader',
          use: ['css-loader']
        })
      },
      {
        test: /\.(png|jpg|gif)$/,
        use: [
          {
            loader: 'file-loader',
            options: {
              useRelativePath: true,
              publicPath: '/assets/images/',
              outputPath: '../public/images/'
            }
          }
        ]
      },
      {
        test: /\.(eot|otf|ttf|woff2?|svg)(\?.+)?$/,
        include: [
          path.resolve(__dirname, 'node_modules')
        ],
        use: {
          loader: 'file-loader',
          options: {
            useRelativePath: true,
            publicPath: '/assets/images/',
            outputPath: '../public/images/'
          }
        }
      }
    ]
  },
  plugins: [
    new ExtractTextPlugin({
      filename: '../public/stylesheets/[name].css'
    })
  ]
};
