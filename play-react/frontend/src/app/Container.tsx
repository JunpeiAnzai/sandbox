import {App} from './App';
import {connect} from 'react-redux';
import {Dispatch} from 'redux';
import {nothingAmount} from './module';
import {ReduxAction, ReduxState} from '../store';

export class ActionDispatcher {
  constructor(private dispatch: (action: ReduxAction) => void) {}

  public nothing(amount: string) {
    this.dispatch(nothingAmount(amount));
  }
}

export default connect(
  (state: ReduxState) => ({value: state.app}),
  (dispatch: Dispatch<ReduxAction>) => ({actions: new ActionDispatcher(dispatch)})
)(App)
