// CONTEXT API AND useReducer
// Context API lets you share state across many components
// without passing props down through every level (prop drilling)
//
// Real life: imagine the Capitec app. The logged-in user's account
// details are needed on the home screen, the transfer screen, the
// settings screen. Instead of passing that data down through every
// screen one by one, you store it once and any screen grabs it.

import React, { useState, useReducer } from "react";

// CONTEXT API SETUP

// Step 1: create the context — the central store
const AccountContext = React.createContext();

// Step 2: Provider holds the state and shares it with all children
function AccountProvider({ children }) {
    // the logged-in account holders and their balances
    const [accounts, setAccounts] = useState([
        { name: "Anita", type: "Current", balance: 5000 },
        { name: "Vito", type: "Savings", balance: 3000 }
    ]);

    return (
        <AccountContext.Provider value={{ accounts }}>
            {children}
        </AccountContext.Provider>
    );
}

// Step 3: custom hook makes reading the context easier
const useAccountContext = () => React.useContext(AccountContext);

// CONSUMER COMPONENT — reads context without props
// This is like the account list screen on the Capitec app.
// It needs the account data but we never passed it props —
// it reaches into the central store directly.
function AccountList() {
    const { accounts } = useAccountContext();

    return (
        <div>
            {accounts.map((acc) => (
                <h2 key={acc.name}>
                    {acc.name} — {acc.type}: R{acc.balance}
                </h2>
            ))}
        </div>
    );
}

// useReducer — like useState but for complex state logic
// Real life: Anita's Current account starts at R5000.
// A deposit increases it, a withdrawal decreases it. The reducer
// is the rulebook that decides what each action does to the balance.

// reducer defines how the balance changes based on action type
function balanceReducer(state, action) {
    switch (action.type) {
        case "deposit":
            return state + 500;  // Anita gets paid
        case "withdraw":
            return state - 200;  // Anita buys groceries
        default:
            return state;
    }
}

function AnitaAccount() {
    // useReducer takes the reducer and Anita's starting balance of 5000
    const [balance, dispatch] = useReducer(balanceReducer, 5000);

    return (
        <div>
            <p>Anita's Current Account: R{balance}</p>
            {/* dispatch sends an action to the reducer */}
            <button onClick={() => dispatch({ type: "deposit" })}>
                Deposit Salary
            </button>
            <button onClick={() => dispatch({ type: "withdraw" })}>
                Buy Groceries
            </button>
        </div>
    );
}

export { AccountProvider, AccountList, AnitaAccount };