import { Action } from 'redux';

enum ActionNames {
  NOTHING
}

interface NothingAction extends Action {
  type: ActionNames.NOTHING
  amount: string
}

export const nothingAmount = (val: string): NothingAction => ({
  type: ActionNames.NOTHING,
  amount: val
});

export interface AppState {
  value: string
}

export type AppActions = NothingAction
const initialState: AppState = { value: "initial" }

export default function reducer(state: AppState = initialState, action: AppActions): AppState {
  switch (action.type) {
    case ActionNames.NOTHING:
      return { value: state.value + action.amount }
    default:
      return state
  }
}
