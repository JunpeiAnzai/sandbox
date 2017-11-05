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
        use: [
          'style-loader',
          'css-loader'
        ]
      },
      {
        test: /\.tsx?$/,
        use: [
          'ts-loader'
        ]
      }
    ]
  }
};
