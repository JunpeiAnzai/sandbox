import app, { AppActions, AppState } from './app/module';
import { createStore, combineReducers, Action } from 'redux';

export default createStore(
  combineReducers({
    app
  })
);

export type ReduxState = {
  app: AppState
}

export type ReduxAction = AppActions | Action;
