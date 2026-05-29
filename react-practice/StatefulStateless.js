// STATEFUL vs STATELESS COMPONENTS
// Stateful: holds its own internal state that can change
// Stateless: holds no state, only receives data through props
//
// Real life: think of the Capitec app home screen (stateful parent)
// that holds Anita's balance. It passes that balance down to a small
// display card (stateless child) that just shows it on screen.
// The card never changes the balance — it only displays what it is given.

import React, { useState } from "react";

// STATEFUL PARENT — stores and manages the state
function App() {
    // the parent holds the state — Anita's account balance
    const [balance, setBalance] = useState(5000);

    // pass the balance down to the child as a prop
    return (
        <div>
            <BalanceCard message={`Anita's balance is R${balance}`} />

            {/* the parent can change its own state through events */}
            <button onClick={() => setBalance(balance + 500)}>
                Deposit R500
            </button>
        </div>
    );
}

// STATELESS CHILD — holds no state, only receives props
function BalanceCard(props) {
    // it just displays the message prop passed in
    // it never changes the prop because props are immutable
    return <h1>{props.message}</h1>;
}

export default App;