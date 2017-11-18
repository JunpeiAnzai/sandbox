import * as React from 'react';
import {AppState} from './module';
import {ActionDispatcher} from './Container';
import './App.css';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import FlatButton from 'material-ui/FlatButton'

const png = require('./App.png')

interface Props {
  value: AppState
  actions: ActionDispatcher
}

export class App extends React.Component<Props, {}> {
  render() {
    return(
      <div>
        <span className="app-text">aaa</span>
        <img src={png} />
        <MuiThemeProvider>
          <FlatButton label="default" />
        </MuiThemeProvider>
      </div>
    )
  }
}
