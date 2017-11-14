import * as React from 'react';
import {AppState} from './module';
import {ActionDispatcher} from './Container';
import './App.css';

interface Props {
  value: AppState
  actions: ActionDispatcher
}

export class App extends React.Component<Props, {}> {
  render() {
    return(
      <div>
        <span className="app-text">aaa</span>
      </div>
    )
  }
}
